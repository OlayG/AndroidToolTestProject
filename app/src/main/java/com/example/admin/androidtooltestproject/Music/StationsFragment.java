package com.example.admin.androidtooltestproject.Music;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.admin.androidtooltestproject.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class StationsFragment extends Fragment {

    public static final String TAG = "StationsFragment";

    public StationsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_stations, container, false);

        return view;
    }

}
