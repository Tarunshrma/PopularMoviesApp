package com.example.tarunsmac.moviesapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tarunsmac.moviesapp.helpers.Constants;
import com.example.tarunsmac.moviesapp.models.Movies;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

public class MovieDetailActivity extends AppCompatActivity {

    //region PRIVATE VARIABLES
    private TextView mMovieTitleTextView;
    private ImageView mMoviePosterImageView;
    private TextView mReleaseDateTextView;
    private TextView mMovieRatingTextview;
    private TextView mMovieDescription;
    //endregion

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);

        setupUI();
    }

    private void setupUI(){
        mMovieTitleTextView = findViewById(R.id.tv_movie_title);
        mMoviePosterImageView = findViewById(R.id.img_movie_poster);
        mReleaseDateTextView = findViewById(R.id.tv_movie_release_date);
        mMovieRatingTextview = findViewById(R.id.tv_movie_rating);
        mMovieDescription = findViewById(R.id.tv_movie_description);

        //Feth the selected movie model and populate it in UI components
        Bundle data = getIntent().getExtras();
        Movies selectedMovie = data.getParcelable(Constants.SELECTED_MOVIE_EXTRA_KEY);

        if (selectedMovie != null){
            mMovieTitleTextView.setText(selectedMovie.getOriginalTitle());
            mReleaseDateTextView.setText(selectedMovie.getReleaseYear());
            mMovieRatingTextview.setText(selectedMovie.getRating()  + "/10");
            mMovieDescription.setText(selectedMovie.getDescription());

            Picasso.with(this).load(selectedMovie.fullImagePath()).into(mMoviePosterImageView);
        }


    }
}
