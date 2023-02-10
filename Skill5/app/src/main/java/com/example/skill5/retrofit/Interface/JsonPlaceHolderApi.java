package com.example.skill5.retrofit.Interface;

import com.example.skill5.retrofit.model.Posts;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JsonPlaceHolderApi {
    @GET("posts")
    Call<List<Posts>> getPosts();

}
