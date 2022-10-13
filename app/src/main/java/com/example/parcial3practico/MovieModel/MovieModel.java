package com.example.parcial3practico.MovieModel;

import com.example.parcial3practico.MoviePresenter.IMoviePresenter;
import com.example.parcial3practico.api.ApiClient;
import com.example.parcial3practico.api.BooksApi;
import com.example.parcial3practico.beans.Book;
import com.example.parcial3practico.beans.Respuesta;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MovieModel implements IMovieModel{

    private IMoviePresenter presenter;
    private BooksApi api;

    public MovieModel(IMoviePresenter presenter){
        this.presenter = presenter;
        api = ApiClient.getInstance().create(BooksApi.class);
    }

    @Override
    public void getMovies() {
        Call<Respuesta> bookCall = api.getBooks();
        bookCall.enqueue(new Callback<Respuesta>() {
            @Override
            public void onResponse(Call<Respuesta> call, Response<Respuesta> response) {

                presenter.OnMovieSucc(response.body().movies);
            }

            @Override
            public void onFailure(Call<Respuesta> call, Throwable t) {
                presenter.OnMovieFail("Error el obtener los libros");
            }
        });
    }
}
