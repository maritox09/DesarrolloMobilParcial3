package com.example.parcial3practico.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.parcial3practico.R;
import com.example.parcial3practico.beans.Book;

import java.util.List;

public class BooksAdapter extends RecyclerView.Adapter<BooksAdapter.ViewHolder> {

    private List<Book> mBooks;
    private Context context;

    public BooksAdapter(List<Book> mBooks) {
        this.mBooks = mBooks;
    }

    public void reloadData(List<Book> books) {
        this.mBooks = books;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public BooksAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        this.context = parent.getContext();

        LayoutInflater inflater = LayoutInflater.from(this.context);

        View contactView = inflater.inflate(R.layout.item_book, parent, false);
        ViewHolder viewHolder = new ViewHolder(contactView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull BooksAdapter.ViewHolder holder, int position) {
        // Get the data model based on position
        Book book = mBooks.get(position);

        // Set item views based on your views and data model
        holder.mBookName.setText(book.mTitle);
        holder.mBookAuthor.setText(book.mAuthor);
        Glide.with(this.context).load(book.mImageUrl).into(holder.mBookImage);
    }

    @Override
    public int getItemCount() {
        return mBooks.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private ImageView mBookImage;
        private TextView mBookName;
        private TextView mBookAuthor;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            mBookImage = itemView.findViewById(R.id.book_image);
            mBookName = itemView.findViewById(R.id.book_name);
            mBookAuthor = itemView.findViewById(R.id.book_author);

            // itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {

        }
    }
}

