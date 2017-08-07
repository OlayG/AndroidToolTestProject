package com.example.admin.androidtooltestproject.Music;


import android.content.Context;
import android.database.Cursor;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.admin.androidtooltestproject.R;

import java.io.IOException;
import java.text.DecimalFormat;

/**
 * A simple {@link Fragment} subclass.
 */
public class SongsFragment extends Fragment {

    public static final String TAG = "SongsFragment";
    private String[] audioPath;
    private String[] musicList;
    private MediaPlayer mediaPlayer;

    ListView lvSongs;
    TextView tvSongStart;
    TextView tvSongEnd;

    private SeekBar sbMusic = null;
    private ImageButton ibPlay = null;
    private ImageButton ibPrev = null;
    private ImageButton ibNext = null;


    public SongsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_songs, container, false);

        ibPlay = view.findViewById(R.id.ibPlay);
        ibPrev = view.findViewById(R.id.ibPrev);
        ibNext = view.findViewById(R.id.ibNext);
        sbMusic = view.findViewById(R.id.sbMusic);

        mediaPlayer = new MediaPlayer();
        lvSongs = view.findViewById(R.id.lvSongs);
        musicList = getAudioList();
        ArrayAdapter<String> mAdapter = new ArrayAdapter<String>(
                SongsFragment.this.getActivity(),
                android.R.layout.simple_list_item_1, musicList);
        lvSongs.setAdapter(mAdapter);

        lvSongs.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                                    long arg3) {
                try {
                    playSong(audioPath[arg2]);
                } catch (IllegalArgumentException e) {
                    e.printStackTrace();
                } catch (IllegalStateException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        ibPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mediaPlayer.isPlaying()){
                    mediaPlayer.pause();
                    ibPlay.setImageResource(android.R.drawable.ic_media_play);
                } else {
                    mediaPlayer.start();
                    ibPlay.setImageResource(android.R.drawable.ic_media_pause);
                }
            }
        });

        sbMusic.setMax(mediaPlayer.getDuration());
        sbMusic.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int position, boolean b) {
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        return view;
    }

    private String[] getAudioList() {
        Context appContext = SongsFragment.this.getActivity();
        final Cursor mCursor =  appContext.getContentResolver().query(
                MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,
                new String[]{MediaStore.Audio.Media.DISPLAY_NAME, MediaStore.Audio.Media.DATA}, null, null,
                "LOWER(" + MediaStore.Audio.Media.TITLE + ") ASC");

        int count = mCursor.getCount();

        String[] songs = new String[count];
        audioPath = new String[count];
        int i = 0;
        if (mCursor.moveToFirst()) {
            do {
                songs[i] = mCursor.getString(mCursor.getColumnIndexOrThrow(MediaStore.Audio.Media.DISPLAY_NAME));
                audioPath[i] = mCursor.getString(mCursor.getColumnIndexOrThrow(MediaStore.Audio.Media.DATA));
                i++;
            } while (mCursor.moveToNext());
        }

        mCursor.close();

        return songs;
    }

    private void playSong(String path) throws IllegalArgumentException,
            IllegalStateException, IOException {

        Log.d("ringtone", "playSong :: " + path);

        mediaPlayer.reset();
        mediaPlayer.setDataSource(path);
        //mMediaPlayer.setLooping(true);
        ibPlay.setImageResource(android.R.drawable.ic_media_pause);
        mediaPlayer.prepare();
        double durationInMins = (mediaPlayer.getDuration()/1000.00) /  60.00;
        Log.d(TAG, "" + durationInMins);
        DecimalFormat df = new DecimalFormat("#.00");
        tvSongEnd.setText("" + df.format(durationInMins));

        mediaPlayer.start();
    }

}
