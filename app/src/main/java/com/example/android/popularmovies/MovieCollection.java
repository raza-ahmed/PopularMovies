package com.example.android.popularmovies;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by ahmedraza on 14/08/16.
 */
public class MovieCollection implements Parcelable {

    String movieTitle;
    String moviePoster;

    public MovieCollection(String mvTitle, String mvPoster){
        this.movieTitle = mvTitle;
        this.moviePoster = mvPoster;
    }

    protected MovieCollection(Parcel in) {
        movieTitle = in.readString();
        moviePoster = in.readString();
    }

    public static final Creator<MovieCollection> CREATOR = new Creator<MovieCollection>() {
        @Override
        public MovieCollection createFromParcel(Parcel in) {
            return new MovieCollection(in);
        }

        @Override
        public MovieCollection[] newArray(int size) {
            return new MovieCollection[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(movieTitle);
        parcel.writeString(moviePoster);
    }
}
