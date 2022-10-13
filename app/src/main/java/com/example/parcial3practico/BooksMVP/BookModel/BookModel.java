package com.example.parcial3practico.BooksMVP.BookModel;

import com.example.parcial3practico.BooksMVP.BookPresenter.IBookPresenter;
import com.example.parcial3practico.apis.ApiClient;
import com.example.parcial3practico.apis.BooksApi;
import com.example.parcial3practico.beans.Book;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BookModel implements IBookModel {

    private IBookPresenter presenter;
    private BooksApi api;

    public BookModel(IBookPresenter presenter) {
        this.presenter = presenter;
        api = ApiClient.getInstanceBooks().create(BooksApi.class);
    }

    @Override
    public void getBooks() {
        Call<List<Book>> bookCall = api.getBooks();
        bookCall.enqueue(new Callback<List<Book>>() {
            @Override
            public void onResponse(Call<List<Book>> call, Response<List<Book>> response) {
                presenter.onBooksSuccess(response.body());
            }

            @Override
            public void onFailure(Call<List<Book>> call, Throwable t) {
                presenter.onBooksError("Error el obtener los libros");
            }
        });
    }
}
