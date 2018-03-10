package com.example.tarunsmac.moviesapp;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.tarunsmac.moviesapp.enums.MovieFilters;
import com.example.tarunsmac.moviesapp.models.MovieResponse;
import com.example.tarunsmac.moviesapp.viewmodels.BaseViewModel;
import com.example.tarunsmac.moviesapp.viewmodels.MovieListViewModel;

public class MovieListActivity extends BaseActivity {

    private static final String TAG = "MovieListActivity";

    protected MovieListViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_list);

        viewModel = ViewModelProviders.of(this).get(MovieListViewModel.class);
        bindView();
        viewModel.fetchMovies(MovieFilters.Popular);
    }

    void bindView() {
        viewModel.isLoading.observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(@Nullable Boolean aBoolean) {
                Log.i(TAG,"IsLoading Changed");
            }
        });

        viewModel.apiError.observe(this, new Observer<Throwable>() {
            @Override
            public void onChanged(@Nullable Throwable throwable) {
                Log.e(TAG,"Error in api" + throwable.getMessage());
                Toast.makeText(getParent(),throwable.getLocalizedMessage().toString(),Toast.LENGTH_SHORT).show();
            }
        });

        viewModel.apiResponse.observe(this, new Observer<MovieResponse>() {
            @Override
            public void onChanged(@Nullable MovieResponse response) {
                Log.i(TAG,"Data Recieved Count" + response.getResults().size());
            }
        });
    }
}
