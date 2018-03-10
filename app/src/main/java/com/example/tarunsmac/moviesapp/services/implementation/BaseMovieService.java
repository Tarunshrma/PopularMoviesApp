package com.example.tarunsmac.moviesapp.services.implementation;

import com.example.tarunsmac.moviesapp.helpers.Constants;
import com.example.tarunsmac.moviesapp.services.interfaces.MovieApi;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by tarunsmac on 10/03/18.
 */

public class BaseMovieService {

    private MovieApi service;

    protected MovieApi getMovieService(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        service = retrofit.create(MovieApi.class);
        return service;
    }


}
