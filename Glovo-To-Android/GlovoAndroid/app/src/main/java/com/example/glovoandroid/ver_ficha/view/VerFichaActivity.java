package com.example.glovoandroid.ver_ficha.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.glovoandroid.R;
import com.example.glovoandroid.entities.Restaurante;
import com.example.glovoandroid.lst_restaurantes.presenter.LstRestaurantPresenter;
import com.example.glovoandroid.lst_restaurantes.view.LstRestaurantAdapter;
import com.example.glovoandroid.ver_ficha.VerFichaContract;
import com.example.glovoandroid.ver_ficha.presenter.VerFichaPresenter;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class VerFichaActivity extends AppCompatActivity implements VerFichaContract.View {

    private VerFichaPresenter verFichaPresenter;
    private RecyclerView recyclerView;
    private TextView idRestaurante;
    private TextView nombreRestaurante;
    private TextView tipoRestaurante;
    private TextView ventasRestaurante;
    private TextView puntuacionRestaurante;
    private ImageView imagenRestaurante;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_ficha);
        Bundle extras = getIntent().getExtras();
        String nombre = extras.getString("nombreRestaurante");
        initComponents();
        initPresenter();
        initData(nombre);
    }
    public void initComponents(){
        recyclerView = (RecyclerView) findViewById(R.id.recyclerFicha);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));

        nombreRestaurante = findViewById(R.id.NOMBRE2);
        tipoRestaurante = findViewById(R.id.TIPO2);
        ventasRestaurante = findViewById(R.id.VENTAS2);
        puntuacionRestaurante = findViewById(R.id.PUNTUACION2);
        imagenRestaurante = (ImageView) findViewById(R.id.IMAGEN);


    }
    public void initPresenter()
    {
        verFichaPresenter = new VerFichaPresenter(this);
    }
    public void initData(String nombreRestaurante) {
        verFichaPresenter.verFichaRestaurante(nombreRestaurante); //SEL

    }

    @Override
    public void onSuccessRestaurante(ArrayList<Restaurante> restaurante) {
        LstRestaurantAdapter adapter = new LstRestaurantAdapter(getBaseContext(),restaurante);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onFailureRestaurante(String err) {
            Toast.makeText(this, err, Toast.LENGTH_LONG).show();
    }
}