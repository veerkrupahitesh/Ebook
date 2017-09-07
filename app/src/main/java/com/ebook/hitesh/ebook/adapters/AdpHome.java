package com.ebook.hitesh.ebook.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import com.ebook.hitesh.ebook.R;
import com.ebook.hitesh.ebook.models.BookModel;

import java.util.ArrayList;

/**
 * Created by vijay on 27-08-2017.
 */

public class AdpHome extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private ArrayList<BookModel> bookList;

    public AdpHome(ArrayList<BookModel> bookList) {
        this.bookList = bookList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_book, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        if (holder instanceof MyViewHolder) {
            MyViewHolder myViewHolder = (MyViewHolder) holder;

            BookModel bookModel = bookList.get(position);

            myViewHolder.tvAuthorName.setText(bookModel.getAuthor());
            myViewHolder.tvBookName.setText(bookModel.getName());
            myViewHolder.ratingBar.setRating(bookModel.getRating());
        }
    }

    @Override
    public int getItemCount() {
        return bookList.size();
    }

    private class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tvAuthorName, tvBookName;
        RatingBar ratingBar;

        MyViewHolder(View itemView) {
            super(itemView);

            tvBookName = itemView.findViewById(R.id.tv_bookName);
            tvAuthorName = itemView.findViewById(R.id.tv_authorName);

            ratingBar = itemView.findViewById(R.id.rating);
        }
    }
}
