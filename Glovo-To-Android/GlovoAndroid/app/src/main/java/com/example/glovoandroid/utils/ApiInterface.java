package com.example.glovoandroid.utils;

import com.example.glovoandroid.entities.Restaurante;
import com.example.glovoandroid.entities.RestauranteRespuesta;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {
    @GET("api")
    Call<ArrayList<Restaurante>> getRestaurante();
}
