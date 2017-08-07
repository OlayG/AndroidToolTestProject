package com.example.admin.androidtooltestproject.Music;


import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;
import com.example.admin.androidtooltestproject.R;
import com.example.admin.androidtooltestproject.SectionsPageAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class MusicLibraryFragment extends Fragment {

    private static final String TAG = "MusicLibraryFragment";


    private SectionsPageAdapter mSectionsPageAdapter;
    private ViewPager mViewPager;

    public MusicLibraryFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_music_library, container, false);

        mSectionsPageAdapter = new SectionsPageAdapter(getFragmentManager());

        mViewPager = view.findViewById(R.id.container);
        setupViewPager(mViewPager);

        TabLayout tabLayout = view.findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

        return view;
    }

    private void setupViewPager(ViewPager viewPager) {
        SectionsPageAdapter adapter = new SectionsPageAdapter(getFragmentManager());
        adapter.addFragment(new SongsFragment(), "SONGS");
        adapter.addFragment(new PlaylistFragment(), "PLAYLIST");
        adapter.addFragment(new StationsFragment(), "STATIONS");
        adapter.addFragment(new ArtistsFragment(), "ARTISTS");
        adapter.addFragment(new AlbumsFragment(), "ALBUMS");
        viewPager.setAdapter(adapter);
    }

}
