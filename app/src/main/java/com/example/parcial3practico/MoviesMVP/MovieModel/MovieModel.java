package com.example.parcial3practico.MoviesMVP.MovieModel;

import com.example.parcial3practico.MoviesMVP.MoviePresenter.IMoviePresenter;
import com.example.parcial3practico.apis.ApiClient;
import com.example.parcial3practico.apis.MovieApi;
import com.example.parcial3practico.beans.Respuesta;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieModel implements IMovieModel{

    private IMoviePresenter presenter;
    private MovieApi api;

    public MovieModel(IMoviePresenter presenter){
        this.presenter = presenter;
        api = ApiClient.getInstance().create(MovieApi.class);
    }

    @Override
    public void getMovies() {
        Call<Respuesta> bookCall = api.getMovies();
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
