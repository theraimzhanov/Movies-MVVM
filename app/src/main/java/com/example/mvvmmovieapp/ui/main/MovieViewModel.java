package com.example.mvvmmovieapp.ui.main;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.mvvmmovieapp.App;
import com.example.mvvmmovieapp.data.remove.MovieCallBack;
import com.example.mvvmmovieapp.model.MovieList;

import java.util.List;

public class MovieViewModel extends ViewModel {
    MutableLiveData<List<MovieList>> movie = new MutableLiveData<>();


    public void getDataFromApi(){
        App.repasitory.CallBack(new MovieCallBack.MovieCall() {
            @Override
            public void onSuccess(List<MovieList> result) {
                movie.setValue(result);
            }

            @Override
            public void onFailure(Exception e) {
                Log.d("TAG", "onFailure: "+e.getLocalizedMessage());
            }
        });
    }
}
