package com.example.mvvmmovieapp.repasitory;

import com.example.mvvmmovieapp.data.remove.MovieCallBack;
import com.example.mvvmmovieapp.model.MovieList;

import java.util.List;

public class MovieRepository implements MovieCallBack {
 MovieCallBack movieCallBack;

    public MovieRepository(MovieCallBack movieCallBack) {
        this.movieCallBack = movieCallBack;
    }

    @Override
    public void CallBack(MovieCall call) {
        movieCallBack.CallBack(new MovieCall() {
            @Override
            public void onSuccess(List<MovieList> result) {
                call.onSuccess(result);
            }

            @Override
            public void onFailure(Exception e) {
               call.onFailure(new Exception("errors"));
            }
        });
    }
}
