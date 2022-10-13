package com.example.parcial3practico.BooksMVP.BookPresenter;

import com.example.parcial3practico.beans.Book;

import java.util.List;

public interface IBookPresenter {

    void getBooks();
    void onBooksSuccess(List<Book> books);
    void onBooksError(String msg);
}
