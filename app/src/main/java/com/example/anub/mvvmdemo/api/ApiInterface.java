package com.example.anub.mvvmdemo.api;

import android.arch.lifecycle.MutableLiveData;

import com.example.anub.mvvmdemo.model.PostResponse;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ApiInterface {

        @GET("posts/")
        Observable<List<PostResponse>> getAllPosts();

        @GET("posts/")
        MutableLiveData<List<PostResponse>> getLiveAllPosts();

}
