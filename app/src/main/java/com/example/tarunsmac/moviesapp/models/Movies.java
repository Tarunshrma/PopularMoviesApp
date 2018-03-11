package com.example.tarunsmac.moviesapp.models;

import android.os.Parcel;
import android.os.ParcelFormatException;
import android.os.Parcelable;

import com.example.tarunsmac.moviesapp.helpers.Constants;
import com.example.tarunsmac.moviesapp.helpers.DateUtils;
import com.google.gson.annotations.SerializedName;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

/**
 * Created by tarunsmac on 10/03/18.
 */

public class Movies implements Parcelable{

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


    protected Movies(Parcel in) {
        movieTitle = in.readString();
        originalTitle = in.readString();
        posterPath = in.readString();
        description = in.readString();
        rating = in.readString();
        releaseDate = in.readString();
    }

    public static final Creator<Movies> CREATOR = new Creator<Movies>() {
        @Override
        public Movies createFromParcel(Parcel in) {
            return new Movies(in);
        }

        @Override
        public Movies[] newArray(int size) {
            return new Movies[size];
        }
    };

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

    public String getReleaseYear()  {
        //As date is in format of
        try{
            int year = DateUtils.getYear(releaseDate,"yyyy-mm-dd");
            return String.valueOf(year);
        } catch (ParseException e) {
            return releaseDate;
        }
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String fullImagePath(){
        return Constants.IMAGE_BASE_URL + Constants.DEFAULT_IMAGE_SIZE + "/" + this.posterPath;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(movieTitle);
        dest.writeString(originalTitle);
        dest.writeString(posterPath);
        dest.writeString(description);
        dest.writeString(rating);
        dest.writeString(releaseDate);
    }
}
