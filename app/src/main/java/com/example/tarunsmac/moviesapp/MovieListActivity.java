package com.example.tarunsmac.moviesapp;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.tarunsmac.moviesapp.enums.MovieFilters;
import com.example.tarunsmac.moviesapp.helpers.Constants;
import com.example.tarunsmac.moviesapp.models.MovieResponse;
import com.example.tarunsmac.moviesapp.models.Movies;
import com.example.tarunsmac.moviesapp.viewmodels.MovieListViewModel;

public class MovieListActivity extends BaseActivity implements MovieListGridAdapter.MovieListGridAdapterAdapterOnClickHandler{

    private static final String TAG = "MovieListActivity";
    private static final String[] filters = {"Most Populer", "Top Rated"};
    private MovieFilters currentFilter = MovieFilters.Popular;


    private RecyclerView rvMovieList;
    private MovieListGridAdapter gridAdapter;

    private ProgressBar pbLoadngIndicator;
    protected MovieListViewModel viewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_list);

        //Load the UI component and Bind with view models
        setupUI();

        //Fetch movie data
        fetchMovieDataFrom();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.home_menu,menu);

        MenuItem menuItem = menu.findItem(R.id.home_menu);
        Spinner spinner = (Spinner) menuItem.getActionView();

        ArrayAdapter<String>spinnerAdapter = new ArrayAdapter<String>(MovieListActivity.this,
                android.R.layout.simple_spinner_item,filters);

        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(spinnerAdapter);

        spinner.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {

                switch (position){
                    case 0:
                        currentFilter = MovieFilters.Popular;
                        break;
                    case 1:
                        currentFilter = MovieFilters.Top_Rated;
                        break;
                }

                fetchMovieDataFrom();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub
            }
        });


        return super.onCreateOptionsMenu(menu);
    }

    private void setupUI(){

        pbLoadngIndicator = findViewById(R.id.pb_loading_indicator);
        rvMovieList = findViewById(R.id.rv_movies);
        GridLayoutManager gridLayout = new GridLayoutManager(this,2);
        rvMovieList.setLayoutManager(gridLayout);

        gridAdapter = new MovieListGridAdapter(this,this);
        rvMovieList.setAdapter(gridAdapter);

        rvMovieList.setHasFixedSize(true);

        viewModel = ViewModelProviders.of(this).get(MovieListViewModel.class);
        bindView();

    }

    private void fetchMovieDataFrom(){
        showLoadingIndicator();
        viewModel.fetchMovies(currentFilter);
    }

    private void bindView() {
        viewModel.isLoading.observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(@Nullable Boolean aBoolean) {
                Log.i(TAG,"IsLoading Changed");
                hideLoadingIndicator();
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
                gridAdapter.setMoviesData(response.getResults());
            }
        });
    }

    private void showLoadingIndicator()
    {
        pbLoadngIndicator.setVisibility(View.VISIBLE);
        rvMovieList.setVisibility(View.INVISIBLE);
    }

    private void hideLoadingIndicator()
    {
        pbLoadngIndicator.setVisibility(View.INVISIBLE);
        rvMovieList.setVisibility(View.VISIBLE);
    }

    @Override
    public void onItemClicked(Movies selectedMovie) {
        Intent intent = new Intent(this,MovieDetailActivity.class);
        intent.putExtra(Constants.SELECTED_MOVIE_EXTRA_KEY,selectedMovie);
        this.startActivity(intent);
    }

}
