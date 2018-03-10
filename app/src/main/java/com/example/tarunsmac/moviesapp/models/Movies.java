package com.example.tarunsmac.moviesapp.models;

import com.example.tarunsmac.moviesapp.helpers.Constants;
import com.google.gson.annotations.SerializedName;

/**
 * Created by tarunsmac on 10/03/18.
 */

public class Movies {

    @SerializedName("title")
    private String movieTitle;

    @SerializedName("original_title")
    private String originalTitle;

    @SerializedName("poster_path")
    private String posterPath;

    @SerializedName("overview")
    private String description;

    @SerializedName("vote_average")
    private String rating;

    @SerializedName("release_date")
    private String releaseDate;

    public Movies(String movieTitle,String originalTitle,String posterPath,
                  String description,String rating,String releaseDate){

        this.movieTitle = movieTitle;
        this.originalTitle = originalTitle;
        this.posterPath = posterPath;
        this.description = description;
        this.rating = rating;
        this.releaseDate = releaseDate;
    }


    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String fullImagePath(){
        return Constants.IMAGE_BASE_URL + Constants.DEFAULT_IMAGE_SIZE + "/" + this.posterPath;
    }
}
