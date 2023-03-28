package com.example.glovoandroid.hst_compras;

import com.example.glovoandroid.entities.Pedido;
import com.example.glovoandroid.entities.Restaurante;
import com.example.glovoandroid.entities.Usuario;

import java.util.ArrayList;

public interface HstComprasContract {
    public interface View{
        void onSuccessHstCompras(ArrayList<Pedido> lstPedidos);
        void onFailureHstCompras(String err);
    }
   public interface Presenter{
        //Historico de compras.
        void verCompras(String idUser);
   }
   public interface Model{
        interface onHstComprasListener{
            void onSuccess(ArrayList<Pedido> lstPedidos);
            void onFailure(String err);
        }
    void verComprasWS(String idUser, onHstComprasListener onHstComprasListener);
   }
}
