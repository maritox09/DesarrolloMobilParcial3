package com.example.parcial3practico.beans;

import com.google.gson.annotations.SerializedName;

public class Book {

    @SerializedName("title")
    public String mTitle;
    @SerializedName("director")
    public String mAuthor;
    @SerializedName("posterUrl")
    public String mImageUrl;


}
