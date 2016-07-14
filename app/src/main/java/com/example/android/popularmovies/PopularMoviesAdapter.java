package com.example.android.popularmovies;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by ahmedraza on 14/07/16.
 */
public class PopularMoviesAdapter extends ArrayAdapter<PopularMovies> {

    private static final String LOG_TAG = PopularMoviesAdapter.class.getSimpleName();


    /**
     * This is our own custom constructor (it doesn't mirror a superclass constructor).
     * The context is used to inflate the layout file, and the List is the data we want
     * to populate into the lists
     *
     * @param context        The current context. Used to inflate the layout file.
     * @param popularMovies A List of PopularMovies objects to display in a list
     */
    public PopularMoviesAdapter(Activity context, List<PopularMovies> popularMovies){

        super(context, 0, popularMovies);

    }


    /**
     * Provides a view for an AdapterView (ListView, GridView, etc.)
     *
     * @param position    The AdapterView position that is requesting a view
     * @param convertView The recycled view to populate.
     *                    (search online for "android view recycling" to learn more)
     * @param parent The parent ViewGroup that is used for inflation.
     * @return The View for the position in the AdapterView.
     */

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        // Gets the PopularMovies object from the ArrayAdapter at the appropriate position

        PopularMovies popularMovies = getItem(position);

        // Adapters recycle views to AdapterViews.
        // If this is a new View object we're getting, then inflate the layout.
        // If not, this view already has the layout inflated from a previous call to getView,
        // and we modify the View widgets as usual.
        if (convertView==null){
            convertView= LayoutInflater.from(getContext()).inflate(R.layout.list_item_poular_movies,parent,false);
        }
        ImageView iconView = (ImageView) convertView.findViewById(R.id.list_item_image_banner);
        iconView.setImageResource(popularMovies.image);

        TextView movieTitleView = (TextView) convertView.findViewById(R.id.list_item_movie_title);
        movieTitleView.setText(popularMovies.movieTitle);

        EditText releasedateView = (EditText) convertView.findViewById(R.id.list_item_release_date);
        releasedateView.setText(popularMovies.releaseDate);

        return convertView;
    }

}

