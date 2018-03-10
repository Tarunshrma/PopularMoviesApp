package com.example.tarunsmac.moviesapp.services.interfaces;

import com.example.tarunsmac.moviesapp.enums.MovieFilters;

/**
 * Created by tarunsmac on 10/03/18.
 */

public interface MovieService {
    void getMovies(MovieFilters filter, final MovieServiceResponseHandler responseHandler);
}
