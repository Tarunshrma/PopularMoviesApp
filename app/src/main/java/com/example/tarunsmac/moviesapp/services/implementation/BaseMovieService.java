package com.example.tarunsmac.moviesapp.services.implementation;

import com.example.tarunsmac.moviesapp.helpers.Constants;
import com.example.tarunsmac.moviesapp.services.interfaces.MovieApi;

import retrofit2.Retrofit;

/**
 * Created by tarunsmac on 10/03/18.
 */

public class BaseMovieService {

    protected MovieApi service;

    void BaseMovieService(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .build();

        service = retrofit.create(MovieApi.class);

    }
}
