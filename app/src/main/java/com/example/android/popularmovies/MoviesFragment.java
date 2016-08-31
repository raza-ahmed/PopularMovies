package com.example.android.popularmovies;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import model.MovieObj;
import model.MovieResults;
import retro.MovieDbUrl;
import retro.RetrofitAdapter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MoviesFragment extends Fragment {

    private static final String TAG = MoviesFragment.class.getSimpleName();
    private final static String API_KEY = "7b68fe1fe71d23838afc32790bd1c939";


    public MoviesFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View rootView = inflater.inflate(R.layout.fragment_movies, container, false);

        final RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.recycler_view_moviecollection);
        MovieDbUrl movieDbUrl = RetrofitAdapter.getClient().create(MovieDbUrl.class);
        Call<MovieObj> call = movieDbUrl.getPopularMovies(API_KEY);
        call.enqueue(new Callback<MovieObj>() {
            @Override
            public void onResponse(Call<MovieObj> call, Response<MovieObj> response) {
                int statusCode = response.code();
                List<MovieResults> movieResults = response.body().getResults();
                recyclerView.setAdapter(new MoviesAdapter(movieResults, R.layout.list_movie_items, getActivity().getApplicationContext()));
            }

            @Override
            public void onFailure(Call<MovieObj> call, Throwable t) {
                Log.e(TAG, t.toString());
            }
        });


        return rootView;
    }



}