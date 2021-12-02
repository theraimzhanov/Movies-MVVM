package com.example.mvvmmovieapp.ui.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.mvvmmovieapp.R;
import com.example.mvvmmovieapp.adapter.MovieAdapter;
import com.example.mvvmmovieapp.model.MovieList;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    MovieViewModel model;
    RecyclerView recyclerView;
    MovieAdapter adapter;
    List<MovieList> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initRecyclerView();
        model = new ViewModelProvider(this).get(MovieViewModel.class);
        model.getDataFromApi();
        model.movie.observe(this, new Observer<List<MovieList>>() {
            @Override
            public void onChanged(List<MovieList> movieLists) {
                adapter.setList(movieLists);
                recyclerView.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }
        });
    }

    private void initRecyclerView() {
        recyclerView = findViewById(R.id.recycler);
        list = new ArrayList<>();
        adapter = new MovieAdapter(list, this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}