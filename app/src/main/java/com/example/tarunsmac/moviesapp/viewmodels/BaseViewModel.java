package com.example.tarunsmac.moviesapp.viewmodels;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.example.tarunsmac.moviesapp.models.MovieResponse;
import com.example.tarunsmac.moviesapp.services.interfaces.MovieServiceResponseHandler;


/**
 * Created by tarunsmac on 10/03/18.
 */

public class BaseViewModel extends ViewModel implements MovieServiceResponseHandler{

    public MutableLiveData<Boolean> isLoading = new MutableLiveData<>();

    public MutableLiveData<MovieResponse> apiResponse = new MutableLiveData<>();

    public MutableLiveData<Throwable> apiError = new MutableLiveData<>();

    @Override
    public void notifySuccess(MovieResponse response) {
        this.isLoading.setValue(false);
        this.apiResponse.setValue(response);
    }

    @Override
    public void notifyError(Throwable error) {
        this.apiError.setValue(error);
        this.isLoading.setValue(false);
    }
}
