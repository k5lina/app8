package com.example.app8.UI.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.app8.Data.model.BookEntity;
import com.example.app8.R;

import java.util.List;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.BookEntityViewHolder>{
    private List<BookEntity> books;

    public void setBookEntities(List<BookEntity> animalEntities) {
        books = animalEntities;
        notifyDataSetChanged();
    }

    @Override
    public BookEntityViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new BookEntityViewHolder(view);
    }

    @Override
    public void onBindViewHolder(BookEntityViewHolder holder, int position) {
        if (books != null) {
            BookEntity currentEntity = books.get(position);
            holder.textViewName.setText(currentEntity.getName());
        } else {
            holder.textViewName.setText("No BookEntity");
        }
    }

    @Override
    public int getItemCount() {
        return books != null ?books.size() : 0;
    }

    static class BookEntityViewHolder extends RecyclerView.ViewHolder {
        private final TextView textViewName;
        public BookEntityViewHolder(View itemView) {
            super(itemView);
            textViewName = itemView.findViewById(R.id.text);
        }
    }
}
