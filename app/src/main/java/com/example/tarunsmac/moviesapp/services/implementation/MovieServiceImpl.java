package com.example.tarunsmac.moviesapp.services.implementation;

import com.example.tarunsmac.moviesapp.enums.MovieFilters;
import com.example.tarunsmac.moviesapp.helpers.Constants;
import com.example.tarunsmac.moviesapp.models.MovieResponse;
import com.example.tarunsmac.moviesapp.services.interfaces.MovieApi;
import com.example.tarunsmac.moviesapp.services.interfaces.MovieService;
import com.example.tarunsmac.moviesapp.services.interfaces.MovieServiceResponseHandler;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by tarunsmac on 10/03/18.
 */

public class MovieServiceImpl extends BaseMovieService implements MovieService {


    public MovieServiceImpl(){
        super();
    }

    public void getMovies(MovieFilters filter, final MovieServiceResponseHandler responseHandler) {

        Call<MovieResponse> call;

        if (filter == MovieFilters.Top_Rated){
            call = this.service.getTopRatedMovies(this.movieApiKey);
        }else{
            call = this.service.getMostPopularMovies(this.movieApiKey);
        }

        call.enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                 responseHandler.notifySuccess(response.body());
            }

            @Override
            public void onFailure(Call<MovieResponse> call, Throwable t) {
                responseHandler.notifyError(t);
            }
        });
    }

}
