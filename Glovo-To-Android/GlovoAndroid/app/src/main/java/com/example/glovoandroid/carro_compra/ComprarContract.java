package com.example.glovoandroid.carro_compra;

import com.example.glovoandroid.entities.Plato;

import java.util.ArrayList;

public interface ComprarContract {
    public interface View{
        void onSuccessComprar(String respuesta);
        void onFailureComprar(String err);
    }
    public interface Presenter{
        //Introduce la compra en la bbdd.
        void comprarCarro(String total, String idUser);
    }
    public interface Model{
        interface onComprarListener{
            void onSuccess(String respuesta);
            void onFailure(String err);
        }
        void ComprarWS(String total,String idUser, ComprarContract.Model.onComprarListener onComprarListener);
    }
}
