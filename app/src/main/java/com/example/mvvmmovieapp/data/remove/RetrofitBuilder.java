package com.example.mvvmmovieapp.data.remove;

import android.util.Log;

import com.example.mvvmmovieapp.model.MovieList;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitBuilder implements MovieCallBack{

 Retrofit retrofit = new Retrofit.Builder().baseUrl("https://ghibliapi.herokuapp.com/")
 .addConverterFactory(GsonConverterFactory.create())
 .build();

 RetrofitService service = retrofit.create(RetrofitService.class);

 @Override
 public void CallBack(MovieCall movieCall) {
  Call<List<MovieList>> movieList = service.getAllMovies();
  movieList.enqueue(new Callback<List<MovieList>>() {
   @Override
   public void onResponse(Call<List<MovieList>> call, Response<List<MovieList>> response) {
    movieCall.onSuccess(response.body());
   }

   @Override
   public void onFailure(Call<List<MovieList>> call, Throwable t) {
    Log.d("TAG", "onFailure: "+t.getLocalizedMessage());
   }
  });
 }
}
//https://ghibliapi.herokuapp.com/films
