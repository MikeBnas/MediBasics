package com.wordpress.medicourses.medibasics;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.BookViewHolder> {

    private List<Book> items;

    public static class BookViewHolder extends RecyclerView.ViewHolder {

        public ImageView bookimg;
        public TextView booktitle;
        public TextView booksrc;
        public TextView bookid;

        public BookViewHolder(View v) {
            super(v);
            booktitle = (TextView) v.findViewById(R.id.booktitle);
            bookimg = (ImageView) v.findViewById(R.id.bookimg);
            booksrc = (Button) v.findViewById(R.id.booksrc);

        }
    }

    public BookAdapter(List<Book> items) {
        this.items = items;
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public BookViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.book_layout, viewGroup, false);
        return new BookViewHolder(v);
    }

    @Override
    public void onBindViewHolder(BookViewHolder viewHolder, int i) {
        viewHolder.booktitle.setText(items.get(i).getBooktitle());
        viewHolder.bookimg.setImageResource(items.get(i).getBookimg());
        viewHolder.booksrc.setText(items.get(i).getBooksrc());
        viewHolder.booksrc.setId(items.get(i).getBookid());
    }
}
