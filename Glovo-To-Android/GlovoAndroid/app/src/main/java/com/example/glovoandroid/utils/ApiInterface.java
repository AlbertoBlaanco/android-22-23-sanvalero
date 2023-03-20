package com.example.glovoandroid.utils;


import com.example.glovoandroid.entities.Restaurante;
import com.example.glovoandroid.entities.Usuario;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiInterface {
    @GET("api/ventas")
    Call<ArrayList<Restaurante>> getRestaurante();

    @GET("api/filtr_usu/{tipo}")
    Call<ArrayList<Restaurante>> getFiltroRestaurante(@Path("tipo") String tipo);

    @GET("api/ver_ficha/{nombreRestaurante}")
    Call<ArrayList<Restaurante>> getFichaRestaurante(@Path("nombreRestaurante") String nombreRestaurante);

    @POST("api/register")
    Call <Usuario> sendRegisterData(@Body Usuario user);






}
