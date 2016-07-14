package com.example.android.popularmovies;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by ahmedraza on 14/07/16.
 */

public class PopularMovies implements Parcelable{

    String movieTitle;
    String releaseDate;
    int image;

    public PopularMovies(String tTitle, String tDate, int image){
        this.movieTitle = tTitle;
        this.releaseDate = tDate;
        this.image = image;
    }

    protected PopularMovies(Parcel in) {
        movieTitle = in.readString();
        releaseDate = in.readString();
        image = in.readInt();
    }

    public static final Creator<PopularMovies> CREATOR = new Creator<PopularMovies>() {
        @Override
        public PopularMovies createFromParcel(Parcel in) {
            return new PopularMovies(in);
        }

        @Override
        public PopularMovies[] newArray(int size) {
            return new PopularMovies[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(movieTitle);
        parcel.writeString(releaseDate);
        parcel.writeInt(image);
    }
}
