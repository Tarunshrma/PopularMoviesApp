package com.example.tarunsmac.moviesapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tarunsmac.moviesapp.helpers.Constants;
import com.example.tarunsmac.moviesapp.models.Movies;
import com.squareup.picasso.Picasso;

public class MovieDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);

        setupUI();
    }

    private void setupUI(){
        TextView mMovieTitleTextView = findViewById(R.id.tv_movie_title);
        ImageView mMoviePosterImageView = findViewById(R.id.img_movie_poster);
        TextView mReleaseDateTextView = findViewById(R.id.tv_movie_release_date);
        TextView mMovieRatingTextview = findViewById(R.id.tv_movie_rating);
        TextView mMovieDescription = findViewById(R.id.tv_movie_description);

        //Feth the selected movie model and populate it in UI components
        Bundle data = getIntent().getExtras();
        Movies selectedMovie = data.getParcelable(Constants.SELECTED_MOVIE_EXTRA_KEY);

        if (selectedMovie != null){
            mMovieTitleTextView.setText(selectedMovie.getOriginalTitle());
            mReleaseDateTextView.setText(selectedMovie.getReleaseYear());
            mMovieRatingTextview.setText(String.format("%s/10", selectedMovie.getRating()));
            mMovieDescription.setText(selectedMovie.getDescription());

            Picasso.with(this).load(selectedMovie.fullImagePath()).into(mMoviePosterImageView);
        }


    }
}
