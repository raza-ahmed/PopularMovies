package com.example.android.popularmovies;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.Arrays;


public class MoviesFragment extends Fragment {


    public MoviesFragment() {
        // Required empty public constructor
    }
    MovieCollection[] movieCollections = {
            new MovieCollection("First Movie", "15th August", R.drawable.pl14),
            new MovieCollection("Second Movie", "16th August", R.drawable.pl14c),
            new MovieCollection("Third Movie", "17th August", R.drawable.pl20c),
            new MovieCollection("Fourth Movie", "18th August", R.drawable.pl20c2),
            new MovieCollection("Fifth Movie", "19th August", R.drawable.pl35),
            new MovieCollection("Sixth Movie", "20th August", R.drawable.pl14c2),
            new MovieCollection("Seventh Movie", "21th August", R.drawable.pl35),
            new MovieCollection("Eigth Movie", "22th August", R.drawable.pl35c2),

    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_movies, container, false);

        MovieAdapter movieAdapter = new MovieAdapter(getActivity(), Arrays.asList(movieCollections));

        ListView listView = (ListView) rootView.findViewById(R.id.list_view_moviecollection);
        listView.setAdapter(movieAdapter);
        return rootView;
    }

}