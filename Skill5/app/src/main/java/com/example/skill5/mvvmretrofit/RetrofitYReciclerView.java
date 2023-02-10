package com.example.skill5.mvvmretrofit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.skill5.R;

public class RetrofitYReciclerView extends AppCompatActivity {

    private RecyclerView recyclerView;
    private AdapterRetrofit adapterRetrofit;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit_yrecicler_view);
        recyclerView = findViewById(R.id.miRecycler);
    }




private void ConfigureRecyclerView(){
        //adapterRetrofit = new AdapterRetrofit();
}





}