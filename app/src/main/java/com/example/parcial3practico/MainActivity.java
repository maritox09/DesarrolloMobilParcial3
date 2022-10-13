package com.example.parcial3practico;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.parcial3practico.MoviesMVP.MoviePresenter.IMoviePresenter;
import com.example.parcial3practico.MoviesMVP.MoviePresenter.MoviePresenter;
import com.example.parcial3practico.MoviesMVP.MovieView.IMovieView;
import com.example.parcial3practico.adapters.MoviesAdapter;
import com.example.parcial3practico.beans.Movie;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements IMovieView {

    private MoviesAdapter adapter;
    private IMoviePresenter presenter;

    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView rvBooks = (RecyclerView) findViewById(R.id.movies_list);
        this.adapter = new MoviesAdapter(new ArrayList<>());
        rvBooks.setAdapter(adapter);
        rvBooks.setLayoutManager(new LinearLayoutManager(this));

        presenter = new MoviePresenter(this);
        presenter.getMovies();

        button = findViewById(R.id.boton_extra);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(v.getContext(),ExtraActivity.class));
            }
        });
    }

    @Override
    public void OnMovieSucc(List<Movie> mMovies) {
        adapter.reloadData(mMovies);
    }

    @Override
    public void OnMovieFail(String msg) {
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }
}