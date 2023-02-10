package com.example.skill5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class RecyclerPersonalizado extends AppCompatActivity {
    ArrayList<PersonajeBO> listaPersonajes;
    RecyclerView recycler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recycler = (RecyclerView) findViewById(R.id.RecyclerId);
        recycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false));
        listaPersonajes = new ArrayList<PersonajeBO>();
        llenarPersonajes();

        AdapterPersonajes adapter = new AdapterPersonajes(listaPersonajes);
        recycler.setAdapter(adapter);

    }

    private void llenarPersonajes(){
        listaPersonajes.add(new PersonajeBO("Krusty","",R.drawable.ic_launcher_background));
        listaPersonajes.add(new PersonajeBO("Homero","",R.drawable.ic_launcher_background));
    }
}