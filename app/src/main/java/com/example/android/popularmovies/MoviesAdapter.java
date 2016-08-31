package com.example.android.popularmovies;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import model.MovieResults;

/**
 * Created by ahmedraza on 30/08/16.
 */
public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MoviesViewHolder> {

    private List<MovieResults> movies;
    private int rowLayout;
    private Context context;
    private MovieResults mMovieResults;

    public static class MoviesViewHolder extends RecyclerView.ViewHolder{
        RelativeLayout relativeLayoutImage;
        ImageView imageItmIcon;
        TextView listItemMovieTitle;

        public MoviesViewHolder(View v){
            super (v);
            relativeLayoutImage = (RelativeLayout) v.findViewById(R.id.relative_layout_image);
            imageItmIcon = (ImageView) v.findViewById(R.id.image_item_icon);
            listItemMovieTitle = (TextView) v.findViewById(R.id.list_item_movie_title);
        }

    }

    public MoviesAdapter(List<MovieResults> movies, int rowLayout, Context context)
    {
        this.movies = movies;
        this.rowLayout = rowLayout;
        this.context = context;

    }

    @Override
    public MoviesAdapter.MoviesViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        return new MoviesViewHolder(view);

    }
    @Override
    public void onBindViewHolder(MoviesViewHolder holder, final int position){
//        holder.imageItmIcon.setImageResource(movies.get(position).getPosterPath());

        Picasso.with(context)
                .load(mMovieResults.getPosterUrl())
                .into(holder.imageItmIcon);
        holder.listItemMovieTitle.setText(movies.get(position).getOriginalTitle());
    }

    @Override
    public int getItemCount(){
        return movies.size();
    }
}
