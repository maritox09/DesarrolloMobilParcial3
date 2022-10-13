package com.example.parcial3practico;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.parcial3practico.BooksMVP.BookPresenter.BookPresenter;
import com.example.parcial3practico.BooksMVP.BookPresenter.IBookPresenter;
import com.example.parcial3practico.BooksMVP.BookView.IBookView;
import com.example.parcial3practico.MoviesMVP.MoviePresenter.IMoviePresenter;
import com.example.parcial3practico.MoviesMVP.MoviePresenter.MoviePresenter;
import com.example.parcial3practico.MoviesMVP.MovieView.IMovieView;
import com.example.parcial3practico.adapters.BooksAdapter;
import com.example.parcial3practico.adapters.MoviesAdapter;
import com.example.parcial3practico.beans.Book;
import com.example.parcial3practico.beans.Movie;

import java.util.ArrayList;
import java.util.List;

public class ExtraActivity extends AppCompatActivity implements IBookView, IMovieView {

    private IBookPresenter bookPresenter;
    private BooksAdapter booksAdapter;
    private IMoviePresenter moviePresenter;
    private MoviesAdapter moviesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_extra);

        this.bookPresenter = new BookPresenter(this);
        this.bookPresenter.getBooks();

        this.moviePresenter = new MoviePresenter(this);
        this.moviePresenter.getMovies();

        RecyclerView rvBooks = (RecyclerView) findViewById(R.id.books_list);
        this.booksAdapter = new BooksAdapter(new ArrayList<>());
        rvBooks.setAdapter(booksAdapter);
        rvBooks.setLayoutManager(new LinearLayoutManager(this));

        RecyclerView rvMovies = (RecyclerView) findViewById(R.id.movies_list);
        this.moviesAdapter = new MoviesAdapter(new ArrayList<>());
        rvMovies.setAdapter(moviesAdapter);
        rvMovies.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void onBookSuccess(List<Book> books) {
        booksAdapter.reloadData(books);
    }

    @Override
    public void onBookError(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }

    @Override
    public void OnMovieSucc(List<Movie> mMovies) {
        moviesAdapter.reloadData(mMovies);
    }

    @Override
    public void OnMovieFail(String msg) {
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }
}