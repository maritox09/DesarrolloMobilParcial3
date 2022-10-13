package com.example.parcial3practico.MoviePresenter;

import com.example.parcial3practico.beans.Book;

import java.util.List;

public interface IMoviePresenter {

    public void OnMovieSucc(List<Book> mBooks);
    public void OnMovieFail(String msg);
    public void getMovies();

}
