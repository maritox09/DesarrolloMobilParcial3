package com.example.parcial3practico.MoviePresenter;

import com.example.parcial3practico.MovieModel.IMovieModel;
import com.example.parcial3practico.MovieModel.MovieModel;
import com.example.parcial3practico.MovieView.IMovieView;
import com.example.parcial3practico.beans.Book;

import java.util.List;

public class MoviePresenter implements IMoviePresenter{

    private IMovieView view;
    private IMovieModel model;

    public MoviePresenter(IMovieView view){
        this.view = view;
        this.model = new MovieModel(this);
    }

    @Override
    public void OnMovieSucc(List<Book> mBooks) {
        view.OnMovieSucc(mBooks);
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
