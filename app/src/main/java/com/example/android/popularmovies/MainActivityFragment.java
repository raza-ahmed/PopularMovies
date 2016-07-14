package com.example.android.popularmovies;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    private PopularMoviesAdapter moviesAdapter;
    private ArrayList<PopularMovies> popularMoviesList;

    PopularMovies[] popularMovies = {

            new PopularMovies("Movie Name1", "Release Date1", R.drawable.cupcake),
            new PopularMovies("Movie Name2", "Release Date2", R.drawable.donut),
            new PopularMovies("Movie Name3", "Release Date3", R.drawable.eclair),
            new PopularMovies("Movie Name4", "Release Date4", R.drawable.froyo),
            new PopularMovies("Movie Name5", "Release Date5", R.drawable.gingerbread),
            new PopularMovies("Movie Name6", "Release Date6", R.drawable.honeycomb),
            new PopularMovies("Movie Name7", "Release Date7", R.drawable.icecream),
            new PopularMovies("Movie Name8", "Release Date8", R.drawable.jellybean),
            new PopularMovies("Movie Name9", "Release Date1", R.drawable.kitkat),
            new PopularMovies("Movie Name10", "Release Date1", R.drawable.lollipop),
            new PopularMovies("Movie Name11", "Release Date1", R.drawable.eclair),
    };

    public MainActivityFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        if (savedInstanceState==null || !savedInstanceState.containsKey("popular")){
            popularMoviesList = new ArrayList<PopularMovies>(Arrays.asList(popularMovies));
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState){
        outState.putParcelableArrayList("popular", popularMoviesList);
        super.onSaveInstanceState(outState);
    }
    


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView =  inflater.inflate(R.layout.fragment_main, container, false);


        moviesAdapter = new PopularMoviesAdapter(getActivity(), Arrays.asList(popularMovies));

        // Get a reference to the ListView, and attach this adapter to it.
        GridView gridView = (GridView) rootView.findViewById(R.id.listview_popular_movies);
        gridView.setAdapter(moviesAdapter);

        return rootView;
    }
}
