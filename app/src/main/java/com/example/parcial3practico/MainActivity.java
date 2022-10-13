package com.example.parcial3practico;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.parcial3practico.MoviePresenter.IMoviePresenter;
import com.example.parcial3practico.MoviePresenter.MoviePresenter;
import com.example.parcial3practico.MovieView.IMovieView;
import com.example.parcial3practico.adapter.BooksAdapter;
import com.example.parcial3practico.beans.Book;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements IMovieView {

    private BooksAdapter adapter;
    private IMoviePresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView rvBooks = (RecyclerView) findViewById(R.id.books_list);
        this.adapter = new BooksAdapter(new ArrayList<>());
        rvBooks.setAdapter(adapter);
        rvBooks.setLayoutManager(new LinearLayoutManager(this));

        presenter = new MoviePresenter(this);
        presenter.getMovies();
    }

    @Override
    public void OnMovieSucc(List<Book> mBooks) {
        adapter.reloadData(mBooks);
    }

    @Override
    public void OnMovieFail(String msg) {
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }
}