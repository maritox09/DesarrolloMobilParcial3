package com.example.parcial3practico.MovieView;

import com.example.parcial3practico.beans.Book;

import java.util.List;

public interface IMovieView {

    public void OnMovieSucc(List<Book> mBooks);
    public void OnMovieFail(String msg);

}
