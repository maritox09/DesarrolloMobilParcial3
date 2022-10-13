package com.example.parcial3practico.MoviesMVP.MovieView;

import com.example.parcial3practico.beans.Movie;

import java.util.List;

public interface IMovieView {

    public void OnMovieSucc(List<Movie> mMovies);
    public void OnMovieFail(String msg);

}
