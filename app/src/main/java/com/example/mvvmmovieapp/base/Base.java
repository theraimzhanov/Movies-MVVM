package com.example.mvvmmovieapp.base;

public interface Base <T>{
  void onSuccess(T result);
  void onFailure(Exception e);
}
