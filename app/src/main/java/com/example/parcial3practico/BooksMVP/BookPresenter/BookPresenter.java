package com.example.parcial3practico.BooksMVP.BookPresenter;

import com.example.parcial3practico.BooksMVP.BookModel.BookModel;
import com.example.parcial3practico.BooksMVP.BookModel.IBookModel;
import com.example.parcial3practico.BooksMVP.BookView.IBookView;
import com.example.parcial3practico.beans.Book;

import java.util.List;

public class BookPresenter implements IBookPresenter {

    private IBookView view;
    private IBookModel model;

    public BookPresenter(IBookView view) {
        this.view = view;
        this.model = new BookModel(this);
    }

    @Override
    public void getBooks() {
        this.model.getBooks();
    }

    @Override
    public void onBooksSuccess(List<Book> books) {
        if (view == null)
            return;

        this.view.onBookSuccess(books);
    }

    @Override
    public void onBooksError(String msg) {
        if (view == null)
            return;

        this.view.onBookError(msg);
    }
}
