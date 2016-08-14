package com.example.android.popularmovies;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by ahmedraza on 14/08/16.
 */
public class MovieAdapter extends ArrayAdapter<MovieCollection>{

    private static final String Log_TAG = MovieAdapter.class.getSimpleName();

    public MovieAdapter(Activity context, List<MovieCollection> movieCollections){

        super(context,0, movieCollections);

    }



    public View getView(int position, View convertView, ViewGroup parent){
        MovieCollection movieCollection = getItem(position);

        if(convertView==null){

        convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_movie_items, parent, false);
        }

        ImageView iconView = (ImageView) convertView.findViewById(R.id.list_item_icon);
        iconView.setImageResource(movieCollection.moviePoster);
        TextView titleView = (TextView) convertView.findViewById(R.id.list_item_movie_title);
        titleView.setText(movieCollection.movieTitle);



        return convertView;
    }
}
