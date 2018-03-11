package com.example.tarunsmac.moviesapp;

import android.content.Context;
import android.graphics.Movie;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tarunsmac.moviesapp.enums.MovieFilters;
import com.example.tarunsmac.moviesapp.models.Movies;
import com.example.tarunsmac.moviesapp.services.interfaces.MovieServiceResponseHandler;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by tarunsmac on 10/03/18.
 */




public class MovieListGridAdapter extends RecyclerView.Adapter<MovieListGridAdapter.ViewHolder>{

    private List<Movies> movies;
    private Context context;

    private MovieListGridAdapterAdapterOnClickHandler _mClickHandler;

    public interface MovieListGridAdapterAdapterOnClickHandler {
        void onItemClicked(Movies selectedMovie);
    }

    public MovieListGridAdapter(Context context,MovieListGridAdapterAdapterOnClickHandler clickHandler){
        this.context = context;
        this._mClickHandler = clickHandler;
    }

    @Override
    public MovieListGridAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View gridItem = inflater.inflate(R.layout.recyclerview_item,parent,false);

        ViewHolder viewHolder = new ViewHolder(gridItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MovieListGridAdapter.ViewHolder holder, int position) {
        Picasso.with(context).load(this.movies.get(position).fullImagePath()).into(holder.imgPoster);
    }

    @Override
    public int getItemCount() {
        return movies == null ? 0 : movies.size();
    }

    public void setMoviesData(List<Movies> movies){
        this.movies = movies;
        notifyDataSetChanged();
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private ImageView imgPoster;

        public ViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            imgPoster = (ImageView) itemView.findViewById(R.id.img_movie_poster);
        }


        @Override
        public void onClick(View v) {
            if (_mClickHandler != null){
                Movies selectedMovie = movies.get(getAdapterPosition());
                _mClickHandler.onItemClicked(selectedMovie);
            }
        }
    }
}
