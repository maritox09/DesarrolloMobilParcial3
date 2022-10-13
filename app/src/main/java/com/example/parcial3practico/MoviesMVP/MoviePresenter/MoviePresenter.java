package com.example.parcial3practico.MoviesMVP.MoviePresenter;

import com.example.parcial3practico.MoviesMVP.MovieModel.IMovieModel;
import com.example.parcial3practico.MoviesMVP.MovieModel.MovieModel;
import com.example.parcial3practico.MoviesMVP.MovieView.IMovieView;
import com.example.parcial3practico.beans.Movie;

import java.util.List;

public class MoviePresenter implements IMoviePresenter{

    private IMovieView view;
    private IMovieModel model;

    public MoviePresenter(IMovieView view){
        this.view = view;
        this.model = new MovieModel(this);
    }

    @Override
    public void OnMovieSucc(List<Movie> mMovies) {
        view.OnMovieSucc(mMovies);
    }

    @Override
    public void OnMovieFail(String msg) {
        view.OnMovieFail(msg);
    }

    @Override
    public void getMovies() {
        model.getMovies();
    }
}
