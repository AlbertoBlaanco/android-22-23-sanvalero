package com.example.skill4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MensajeActivity extends AppCompatActivity {
    TextView msj;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mensaje);
        msj=(TextView) findViewById(R.id.txtNombreMsj);

        Bundle miBundle = this.getIntent().getExtras();

        if(miBundle!=null){
            String nombre = miBundle.getString("nombre");
            msj.setText("Bienvenido: " + nombre);

        }
    }

    public void onclick(View view){
        finish();
    }
}