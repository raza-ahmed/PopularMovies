package com.example.android.popularmovies;

import android.content.Context;
import android.widget.ArrayAdapter;

/**
 * Created by ahmedraza on 11/08/16.
 */
public class MovieAdapter extends ArrayAdapter <MovieCollection>{


    public MovieAdapter(Context context, int resource, int textViewResourceId) {
        super(context, resource, textViewResourceId);
    }
}
