package com.example.parcial3practico.beans;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Movie {

    @SerializedName("title")
    public String mTitle;
    @SerializedName("year")
    public String mYear;
    @SerializedName("runtime")
    public String mRuntime;
    @SerializedName("genres")
    public List<String> genres;
    @SerializedName("director")
    public String mDirector;
    @SerializedName("actors")
    public String mActors;
    @SerializedName("plot")
    public String mPlot;
    @SerializedName("posterUrl")
    public String mPosterUrl;

    public Movie(String mTitle, String mYear, String mRuntime, List<String> genres, String mDirector, String mActors, String mPlot, String mPosterUrl) {
        this.mTitle = mTitle;
        this.mYear = mYear;
        this.mRuntime = mRuntime;
        this.genres = genres;
        this.mDirector = mDirector;
        this.mActors = mActors;
        this.mPlot = mPlot;
        this.mPosterUrl = mPosterUrl;
    }

    public Movie(){}
}
