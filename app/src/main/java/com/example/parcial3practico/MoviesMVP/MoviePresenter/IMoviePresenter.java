package com.example.parcial3practico.MoviesMVP.MoviePresenter;

import com.example.parcial3practico.beans.Movie;

import java.util.List;

public interface IMoviePresenter {

    public void OnMovieSucc(List<Movie> mMovies);
    public void OnMovieFail(String msg);
    public void getMovies();

}
