package com.example.android.popularmovies;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import java.util.Arrays;


public class MoviesFragment extends Fragment {


    String movieDataJsonStr = null;
    private static final String TAGJSON =  "Result";


    public MoviesFragment() {
        // Required empty public constructor
    }

    @Override
    public void onStart(){
        super.onStart();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_movies, container, false);

        MovieAdapter movieAdapter = new MovieAdapter(getActivity(), Arrays.asList(movieCollections));

        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.recycler_view_moviecollection);
        RecyclerView.setAdapter(movieAdapter);
        return rootView;
    }



}