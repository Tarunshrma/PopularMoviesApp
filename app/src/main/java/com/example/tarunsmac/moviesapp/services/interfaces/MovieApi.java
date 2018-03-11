package com.example.tarunsmac.moviesapp.services.interfaces;

import com.example.tarunsmac.moviesapp.enums.MovieFilters;
import com.example.tarunsmac.moviesapp.models.MovieResponse;
import com.example.tarunsmac.moviesapp.models.Movies;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by tarunsmac on 10/03/18.
 */

public interface MovieApi {
    @GET("movie/top_rated")
    Call<MovieResponse> getTopRatedMovies(@Query("api_key") String apiKey);

    @GET("movie/popular")
    Call<MovieResponse> getMostPopularMovies(@Query("api_key") String apiKey);
}
