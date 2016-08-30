package retro;

import model.MovieObj;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by ahmedraza on 30/08/16.
 */
public interface MovieDbUrl {

    @GET("movie/top_rated")
    Call<MovieObj> getTopRatedMovies(@Query("api_key") String apiKey);

    @GET("movie/popular")
    Call<MovieObj> getPopularMovies(@Query("api_key") String apiKey);

    @GET("movie/{id}")
    Call<MovieObj> getMovieDetails(@Path("id") int id, @Query("api_key") String apiKey);
}
