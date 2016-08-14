package com.example.android.popularmovies;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;


public class MoviesFragment extends Fragment {


    public MoviesFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_movies, container, false);

        GridView moviegridview = (GridView) rootView.findViewById(R.id.gridview);
        moviegridview.setAdapter(new MovieImageAdapter(getActivity()));

        return rootView;
    }

}