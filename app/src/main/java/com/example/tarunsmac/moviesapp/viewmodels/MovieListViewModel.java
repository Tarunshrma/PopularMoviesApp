package com.example.tarunsmac.moviesapp.viewmodels;

import com.example.tarunsmac.moviesapp.enums.MovieFilters;
import com.example.tarunsmac.moviesapp.services.implementation.MovieServiceImpl;
import com.example.tarunsmac.moviesapp.services.interfaces.MovieService;

/**
 * Created by tarunsmac on 10/03/18.
 */

public class MovieListViewModel extends BaseViewModel {


    private final MovieService apiService;

    //Constructor injection for api service.
    public MovieListViewModel(){
        //TODO: Service should be injected... Construcot injection was not working with Dagger and ViewModel
        this.apiService = new MovieServiceImpl();
    }

    public void fetchMovies(MovieFilters filter){
        this.apiService.getMovies(filter,this);
    }

}
