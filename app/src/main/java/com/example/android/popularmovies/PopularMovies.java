package com.example.android.popularmovies;

/**
 * Created by ahmedraza on 14/07/16.
 */
public class PopularMovies {

    String movieTitle;
    String releaseDate;
    int image;

    public PopularMovies(String tTitle, String tDate, int image){
        this.movieTitle = tTitle;
        this.releaseDate = tDate;
        this.image = image;
    }
}
