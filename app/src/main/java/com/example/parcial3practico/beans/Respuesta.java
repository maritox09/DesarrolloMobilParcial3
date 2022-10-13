package com.example.parcial3practico.beans;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Respuesta {
    @SerializedName("movies")
    public List<Book> movies;
}
