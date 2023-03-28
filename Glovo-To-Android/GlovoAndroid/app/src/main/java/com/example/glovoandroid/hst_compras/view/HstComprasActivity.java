package com.example.glovoandroid.hst_compras.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.glovoandroid.R;
import com.example.glovoandroid.carro_compra.view.CarroCompraActivity;
import com.example.glovoandroid.entities.Pedido;
import com.example.glovoandroid.entities.Plato;
import com.example.glovoandroid.fltr_usuario.presenter.LstRestaurantPresenter;
import com.example.glovoandroid.fltr_usuario.view.FiltrUsuAdapter;
import com.example.glovoandroid.hst_compras.HstComprasContract;
import com.example.glovoandroid.hst_compras.presenter.HstComprasPresenter;
import com.example.glovoandroid.verCarta.view.verCartaActivity;

import java.io.Serializable;
import java.util.ArrayList;

public class HstComprasActivity extends AppCompatActivity implements HstComprasContract.View {
    private HstComprasPresenter hstComprasPresenter;
    private ArrayList<Plato> carroCompras;
    private RecyclerView recyclerView;
    private ImageView btnVolver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hst_compras);
        initComponents();
        initPresenter();
        initData(String.valueOf(getIntent().getExtras().getInt("idUser")));
    }
    public void initComponents(){
        int idRestaurante = getIntent().getExtras().getInt("idRestaurante");
        btnVolver = findViewById(R.id.btnVolver);
        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), CarroCompraActivity.class);
                intent.putExtra("idRestaurante",idRestaurante);
                intent.putExtra("CarroCompras",(Serializable) carroCompras);
                intent.putExtra("tvCantProductos",getIntent().getExtras().getString("tvCantProductos"));
                intent.putExtra("idUser",String.valueOf(getIntent().getExtras().getInt("idUser")));
                startActivity(intent);
            }
        });
        carroCompras = (ArrayList<Plato>) getIntent().getSerializableExtra("CarroCompras");
        recyclerView = (RecyclerView) findViewById(R.id.recyclerHst);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));

    }
    public void initPresenter(){
        hstComprasPresenter = new HstComprasPresenter(this);
    }
    public void initData(String idUser){

        hstComprasPresenter.verCompras(idUser);
    }
    @Override
    public void onSuccessHstCompras(ArrayList<Pedido> lstPedidos) {
        HstComprasAdapter adapter = new HstComprasAdapter(getBaseContext(),lstPedidos);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onFailureHstCompras(String err) {
        Toast.makeText(this, err, Toast.LENGTH_LONG).show();
    }
}