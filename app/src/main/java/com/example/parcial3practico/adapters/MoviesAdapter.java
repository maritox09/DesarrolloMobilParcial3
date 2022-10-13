package com.example.parcial3practico.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.parcial3practico.R;
import com.example.parcial3practico.beans.Movie;

import java.util.List;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.ViewHolder> {

    private List<Movie> mMovies;
    private Context context;

    public MoviesAdapter(List<Movie> mMovies) {
        this.mMovies = mMovies;
    }

    public void reloadData(List<Movie> movies) {
        this.mMovies = movies;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MoviesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        this.context = parent.getContext();

        LayoutInflater inflater = LayoutInflater.from(this.context);

        View contactView = inflater.inflate(R.layout.item_movie, parent, false);
        return new ViewHolder(contactView);
    }

    @Override
    public void onBindViewHolder(@NonNull MoviesAdapter.ViewHolder holder, int position) {
        // Get the data model based on position
        Movie movie = mMovies.get(position);

        // Set item views based on your views and data model
        holder.mMovieTittle.setText("Titulo: " + movie.mTitle);
        holder.mMovieYear.setText("Año: " + movie.mYear);
        holder.mMovieRuntime.setText("Duracion: " + movie.mRuntime + " minutos");
        holder.mMovieGenres.setText("Generos: " + String.join(",",movie.genres));
        holder.mMovieDirector.setText("Director: " + movie.mDirector);
        holder.mMovieActors.setText("Actores: " + movie.mActors);
        holder.mMoviePlot.setText("Resumen: " + movie.mPlot);
        Glide.with(this.context).load(movie.mPosterUrl).into(holder.mMovieImage);
    }

    @Override
    public int getItemCount() {
        return mMovies.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private ImageView mMovieImage;
        private TextView mMovieTittle,mMovieYear,mMovieRuntime,mMovieGenres,mMovieDirector,mMovieActors,mMoviePlot;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            mMovieImage = itemView.findViewById(R.id.movie_image);
            mMovieTittle = itemView.findViewById(R.id.movie_tittle);
            mMovieYear = itemView.findViewById(R.id.movie_year);
            mMovieRuntime = itemView.findViewById(R.id.movie_runtime);
            mMovieGenres = itemView.findViewById(R.id.movie_genres);
            mMovieDirector = itemView.findViewById(R.id.movie_director);
            mMovieActors = itemView.findViewById(R.id.movie_actors);
            mMoviePlot = itemView.findViewById(R.id.movie_plot);

        }

        @Override
        public void onClick(View view) {

        }
    }
}
