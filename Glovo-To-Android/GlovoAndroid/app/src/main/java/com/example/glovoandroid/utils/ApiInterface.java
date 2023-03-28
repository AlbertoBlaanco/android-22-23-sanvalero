package com.example.glovoandroid.utils;


import com.example.glovoandroid.entities.Pedido;
import com.example.glovoandroid.entities.Plato;
import com.example.glovoandroid.entities.Restaurante;
import com.example.glovoandroid.entities.Usuario;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ApiInterface {
    @GET("api/ventas")
    Call<ArrayList<Restaurante>> getRestaurante();

    @GET("api/filtr_usu/{tipo}")
    Call<ArrayList<Restaurante>> getFiltroRestaurante(@Path("tipo") String tipo);

    @GET("api/ver_ficha/{idRestaurante}")
    Call<ArrayList<Restaurante>> getFichaRestaurante(@Path("idRestaurante") int nombreRestaurante);

    @GET("api/ver_carta/{idRestaurante}")
    Call<ArrayList<Plato>> getCartaRestaurante(@Path("idRestaurante") int idRestaurante);

    @GET("api/comprar/{total}/{idUser}")
    Call<String> comprarLstCompra(@Path("total") String total, @Path("idUser") String idUser);

    @GET("api/register/{nombre}/{password}")
    Call <Usuario> sendRegisterData(@Path("nombre") String nombre,@Path("password") String password);

    @GET("api/login/{nombre}/{password}")
    Call <ArrayList<Usuario>> checkLogin(@Path("nombre") String nombre,@Path("password") String password);
    @GET("api/historialCompras/{idUser}")
    Call <ArrayList<Pedido>> getHistorialCompras(@Path("idUser") String idUser);







}
