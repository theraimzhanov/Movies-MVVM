package com.example.mvvmmovieapp.data.remove;

import com.example.mvvmmovieapp.base.Base;
import com.example.mvvmmovieapp.model.MovieList;

import java.util.List;

public interface MovieCallBack {

      void CallBack(MovieCall call);

      interface MovieCall extends Base<List<MovieList>> {
            @Override
            void onFailure(Exception e);

            @Override
            void onSuccess(List<MovieList> result);
      }
}
