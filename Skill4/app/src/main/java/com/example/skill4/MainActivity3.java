package com.example.skill4;

import android.os.Bundle;
import android.util.Log;


import androidx.appcompat.app.AppCompatActivity;

public class MainActivity3 extends AppCompatActivity {

    private static final String TAG="Seguimiento";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);


        Log.i("info","Valor Informacion");
        Log.d("Debug","Valor Debug");
        Log.w("Warning","Valor Warning");
        Log.e("Debug","Valor Debug");
        Log.v("Verbose","Valor Verbose");

        Log.i(TAG,"Mensaje Seguimiento 1");
        Log.i(TAG,"Mensaje Seguimiento 2");
        Log.i(TAG,"Mensaje Seguimiento 3");
        Log.i(TAG,"Mensaje Seguimiento 4");
        Log.i(TAG,"Mensaje Seguimiento 5");


    }
}
