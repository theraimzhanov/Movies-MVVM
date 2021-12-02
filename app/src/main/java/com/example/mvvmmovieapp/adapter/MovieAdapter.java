package com.example.mvvmmovieapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mvvmmovieapp.R;
import com.example.mvvmmovieapp.model.MovieList;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {
   List<MovieList> list;
   Context context;

    public MovieAdapter(List<MovieList> list,Context context) {
        this.list = list;
        this.context = context;
    }

    public List<MovieList> getList() {
        return list;
    }

    public void setList(List<MovieList> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_movie,parent,false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
   holder.bind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MovieViewHolder extends RecyclerView.ViewHolder{
      TextView textViewTilte,textViewDescribtion,textViewDirector;
      ImageView imageView;
        int id;
      public MovieViewHolder(@NonNull View itemView) {
          super(itemView);
          textViewDescribtion = itemView.findViewById(R.id.describtion);
          textViewTilte = itemView.findViewById(R.id.titlee);
          textViewDirector = itemView.findViewById(R.id.director);

      }

        public void bind(MovieList movieList) {
         textViewDirector.setText(movieList.getDirector());
         textViewDescribtion.setText(movieList.getDescription());
         textViewTilte.setText(movieList.getTitle());

      }
    }
}
