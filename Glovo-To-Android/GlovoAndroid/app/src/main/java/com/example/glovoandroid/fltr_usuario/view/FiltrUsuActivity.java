package com.example.glovoandroid.fltr_usuario.view;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.example.glovoandroid.R;
import com.example.glovoandroid.entities.Plato;
import com.example.glovoandroid.entities.Restaurante;
import com.example.glovoandroid.fltr_usuario.FiltroNecUsuarioContract;

import com.example.glovoandroid.fltr_usuario.presenter.LstRestaurantPresenter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FiltrUsuActivity extends AppCompatActivity implements FiltroNecUsuarioContract.View {
    private LstRestaurantPresenter lstRestPresenter;
    private RecyclerView recyclerView;
    private Spinner comboNec;
    private ImageView fltr;
    private ArrayList<Plato> carroCompras;
    private String tvCantProductos;
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fltr_usuario);

        initComponents();
        initPresenter();
        //initData();
    }
    public void initComponents(){

        recyclerView = (RecyclerView) findViewById(R.id.recyclerFltr);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));

        comboNec = (Spinner) findViewById(R.id.SpinnerNec);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.combo_necesidades, android.R.layout.simple_spinner_item);
        comboNec.setAdapter(adapter);


        comboNec.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                initData(adapterView.getItemAtPosition(i).toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        tvCantProductos = "0";
        if(getIntent().getSerializableExtra("CarroCompras") != null){
            carroCompras = (ArrayList<Plato>) getIntent().getSerializableExtra("CarroCompras");
             tvCantProductos = getIntent().getExtras().getString("tvCantProductos");
        }

    }
    public void initPresenter(){
        lstRestPresenter = new LstRestaurantPresenter(this);
    }
    public void initData(String filtro){
        lstRestPresenter.lstRestaurant(filtro);
    }

    @Override
    public void onSuccessLstRestaurant(ArrayList<Restaurante> lstRestaurant) {
        FiltrUsuAdapter adapter = new FiltrUsuAdapter(getBaseContext(),lstRestaurant, carroCompras,tvCantProductos,getIntent().getExtras().getInt("idUser"));
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onFailureLstRestaurant(String err) {
        Toast.makeText(this, err, Toast.LENGTH_LONG).show();
    }


}