package com.example.glovoandroid.hst_compras.presenter;

import com.example.glovoandroid.entities.Pedido;
import com.example.glovoandroid.entities.Restaurante;
import com.example.glovoandroid.fltr_usuario.FiltroNecUsuarioContract;
import com.example.glovoandroid.fltr_usuario.model.FiltroNecUsuarioModel;
import com.example.glovoandroid.hst_compras.HstComprasContract;
import com.example.glovoandroid.hst_compras.model.HstComprasModel;

import java.util.ArrayList;

public class HstComprasPresenter implements HstComprasContract.Presenter {
    private HstComprasModel hstComprasModel;
    private HstComprasContract.View view;

    public HstComprasPresenter(HstComprasContract.View view){
        this.view = view;
        this.hstComprasModel = new HstComprasModel();
    }

    @Override
    public void verCompras(String idUser) {
        hstComprasModel.verComprasWS(idUser, new HstComprasContract.Model.onHstComprasListener() {
            @Override
            public void onSuccess(ArrayList<Pedido> lstPedidos) {
                if(lstPedidos!=null && lstPedidos.size()>0){
                    view.onSuccessHstCompras(lstPedidos);
                }
            }

            @Override
            public void onFailure(String err) {

            }
        });
    }
}
