package com.example.glovoandroid.hst_compras.model;

import com.example.glovoandroid.entities.Pedido;
import com.example.glovoandroid.entities.Restaurante;
import com.example.glovoandroid.entities.Usuario;
import com.example.glovoandroid.fltr_usuario.FiltroNecUsuarioContract;
import com.example.glovoandroid.hst_compras.HstComprasContract;
import com.example.glovoandroid.utils.ApiClient;
import com.example.glovoandroid.utils.ApiInterface;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class HstComprasModel implements HstComprasContract.Model {
    @Override
    public void verComprasWS(String idUser, onHstComprasListener onHstComprasListener) {
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<ArrayList<Pedido>> call = apiService.getHistorialCompras(idUser);
        call.enqueue(new Callback<ArrayList<Pedido>>() {
            @Override
            public void onResponse(Call<ArrayList<Pedido>> call, Response<ArrayList<Pedido>> response) {
                ArrayList<Pedido> listaPedidos = response.body();
                onHstComprasListener.onSuccess(listaPedidos);
            }

            @Override
            public void onFailure(Call<ArrayList<Pedido>> call, Throwable t) {
                onHstComprasListener.onFailure(t.getMessage());
            }
        });
    }
}
