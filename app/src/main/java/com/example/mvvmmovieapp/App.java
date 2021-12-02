package com.example.mvvmmovieapp;

import android.app.Application;

import com.example.mvvmmovieapp.data.remove.MovieCallBack;
import com.example.mvvmmovieapp.data.remove.RetrofitBuilder;
import com.example.mvvmmovieapp.repasitory.MovieRepository;

public class App extends Application {
    public static MovieRepository repasitory;
    MovieCallBack callBack;

    @Override
    public void onCreate() {
        super.onCreate();
       callBack = new RetrofitBuilder();
       repasitory = new MovieRepository(callBack);
    }
}
