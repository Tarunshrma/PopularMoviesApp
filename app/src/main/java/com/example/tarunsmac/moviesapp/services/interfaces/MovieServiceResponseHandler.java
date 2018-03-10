package com.example.tarunsmac.moviesapp.services.interfaces;

import com.example.tarunsmac.moviesapp.models.MovieResponse;

import org.json.JSONObject;

/**
 * Created by tarunsmac on 10/03/18.
 */

public interface MovieServiceResponseHandler {
        public void notifySuccess(MovieResponse response);
        public void notifyError(Throwable error);
}
