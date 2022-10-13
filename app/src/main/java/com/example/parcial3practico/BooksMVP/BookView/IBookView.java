package com.example.parcial3practico.BooksMVP.BookView;

import com.example.parcial3practico.beans.Book;

import java.util.List;

public interface IBookView {

    void onBookSuccess(List<Book> books);
    void onBookError(String msg);
}
