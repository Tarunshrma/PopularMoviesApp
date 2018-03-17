package com.example.tarunsmac.moviesapp.services.interfaces;

import com.example.tarunsmac.moviesapp.models.MovieResponse;

/**
 * Created by tarunsmac on 10/03/18.
 */

public interface MovieServiceResponseHandler {
        void notifySuccess(MovieResponse response);
        void notifyError(Throwable error);
}
