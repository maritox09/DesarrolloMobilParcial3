package com.example.parcial3practico.apis;

import com.example.parcial3practico.beans.Respuesta;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MovieApi {

    @GET("/erik-sytnyk/movies-list/master/db.json")
    Call<Respuesta> getMovies();

}