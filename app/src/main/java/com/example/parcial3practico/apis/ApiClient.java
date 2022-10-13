package com.example.parcial3practico.apis;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    private static Retrofit retrofit = null;
    private static Retrofit retrofitBooks = null;

    public static Retrofit getInstance() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl("https://raw.githubusercontent.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

    public static Retrofit getInstanceBooks() {
        if (retrofitBooks == null) {
            retrofitBooks = new Retrofit.Builder()
                    .baseUrl("http://de-coding-test.s3.amazonaws.com")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofitBooks;
    }

}
