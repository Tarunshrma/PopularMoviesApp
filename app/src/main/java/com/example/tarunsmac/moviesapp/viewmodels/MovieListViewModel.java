package com.example.tarunsmac.moviesapp.viewmodels;

import com.example.tarunsmac.moviesapp.enums.MovieFilters;
import com.example.tarunsmac.moviesapp.services.interfaces.MovieService;

import javax.inject.Inject;

/**
 * Created by tarunsmac on 10/03/18.
 */

public class MovieListViewModel extends BaseViewModel {

    private MovieService apiService;

    //Constructor injection for api service.
    @Inject
    public MovieListViewModel(MovieService _apiService){
        this.apiService = _apiService;
    }

    public void fetchMovies(MovieFilters filter){
        this.apiService.getMovies(filter,this);
    }

}
