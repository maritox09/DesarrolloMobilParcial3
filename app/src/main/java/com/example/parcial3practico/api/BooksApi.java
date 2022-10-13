package com.example.parcial3practico.api;

import com.example.parcial3practico.beans.Book;
import com.example.parcial3practico.beans.Respuesta;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface BooksApi {

    @GET("/erik-sytnyk/movies-list/master/db.json")
    Call<Respuesta> getBooks();

}