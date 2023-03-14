package com.example.glovoandroid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.glovoandroid.entities.Restaurante;
import com.example.glovoandroid.lst_restaurantes.LstRestaurantContract;
import com.example.glovoandroid.lst_restaurantes.view.LstRestaurantActivity;
import com.example.glovoandroid.lst_restaurantes.view.LstRestaurantAdapter;
import com.example.glovoandroid.utils.ApiClient;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lst_restaurant);

        Intent intent = new Intent(getBaseContext(),LstRestaurantActivity.class);
        startActivity(intent);
    }

}