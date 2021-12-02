package com.example.mvvmmovieapp.data.remove;

import com.example.mvvmmovieapp.model.MovieList;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitService {
 @GET("films")
    Call<List<MovieList>>getAllMovies();
}

//https://ghibliapi.herokuapp.com/films