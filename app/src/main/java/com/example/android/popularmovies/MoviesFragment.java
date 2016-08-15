package com.example.android.popularmovies;


import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;


public class MoviesFragment extends Fragment {


    String movieDataJsonStr = null;
    private static final String TAGJSON =  "Result";


    public MoviesFragment() {
        // Required empty public constructor
    }
    MovieCollection[] movieCollections = {
            new MovieCollection("First Movie",  Integer.toString(R.drawable.pl14)),
            new MovieCollection("Second Movie",  Integer.toString(R.drawable.pl14c)),
            new MovieCollection("Third Movie",  Integer.toString(R.drawable.pl20c)),
            new MovieCollection("Fourth Movie",  Integer.toString(R.drawable.pl20c2)),
            new MovieCollection("Fifth Movie",  Integer.toString(R.drawable.pl35)),
            new MovieCollection("Sixth Movie",  Integer.toString(R.drawable.pl14c2)),
            new MovieCollection("Seventh Movie",  Integer.toString(R.drawable.pl35)),
            new MovieCollection("Eigth Movie",  Integer.toString(R.drawable.pl35c2)),

    };

    @Override
    public void onStart(){
        super.onStart();
        FetchMoviedata executemoviedata = new FetchMoviedata();
        executemoviedata.execute();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_movies, container, false);

        MovieAdapter movieAdapter = new MovieAdapter(getActivity(), Arrays.asList(movieCollections));

        GridView gridView = (GridView) rootView.findViewById(R.id.list_view_moviecollection);
        gridView.setAdapter(movieAdapter);
        return rootView;
    }


    public class FetchMoviedata extends AsyncTask<Void, Void, String[]> {
        private final String LOG_TAG = FetchMoviedata.class.getSimpleName();
        private static final String TAG =  "JSONValue";



        private String[] getMovieDataFromJson(String movieJsonString)

        throws JSONException {

            JSONObject movieJson = new JSONObject(movieJsonString);
            JSONArray listVal = movieJson.getJSONArray("results");

            String[] resultStrs = new String[listVal.length()] ;
            for (int i=0; i<listVal.length();i++){

            JSONObject movieInfo = listVal.getJSONObject(i);

                String movie_title = movieInfo.getString("title");
                String movie_poster = movieInfo.getString("poster_path");
                resultStrs[i] = movie_poster + movie_title;

            }

            return resultStrs;
        }

        @Override
        protected String[] doInBackground(Void... params) {

            HttpURLConnection urlConnection = null;
            BufferedReader reader = null;



            try{
                URL url = new URL("http://api.themoviedb.org/3/movie/top_rated?api_key=7b68fe1fe71d23838afc32790bd1c939");

                urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.setRequestMethod("GET");
                urlConnection.connect();

                InputStream inputStream = urlConnection.getInputStream();
                StringBuffer buffer = new StringBuffer();
                if (inputStream==null){
                    return null;
                }

            reader = new BufferedReader(new InputStreamReader(inputStream));


            String line;

            while ((line = reader.readLine()) != null){
                    buffer.append(line + "\n");
                }

                if (buffer.length()==0){
                    return null;
                }

                movieDataJsonStr = buffer.toString();
                Log.v(TAG, "JSON return"+ movieDataJsonStr);

            }catch (IOException e) {
                Log.e("MoviesFragment", "Error ", e);
                // If the code didn't successfully get the weather data, there's no point in attemping
                // to parse it.
                return null;
            } finally{
                if (urlConnection != null) {
                    urlConnection.disconnect();
                }
                if (reader != null) {
                    try {
                        reader.close();
                    } catch (final IOException e) {
                        Log.e("MoviesFragment", "Error closing stream", e);
                    }
                }
            }
            return null;
        }

      @Override
        protected void onPostExecute(String[] result)

      {

          try {
              String[] postLogofJson= getMovieDataFromJson(movieDataJsonStr);
                StringBuilder builder = new StringBuilder();
              for (int i=0; i<postLogofJson.length;i++){
                  builder.append(postLogofJson[i]);
              }
              String postLogofJsonOut = builder.toString();
              Log.v(TAGJSON, postLogofJsonOut);

          } catch (JSONException e) {
              e.printStackTrace();
          }
      }
    }
}