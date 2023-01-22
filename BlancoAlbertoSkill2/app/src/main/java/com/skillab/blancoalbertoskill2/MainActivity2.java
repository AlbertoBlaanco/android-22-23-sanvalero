package com.skillab.blancoalbertoskill2;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity implements View.OnClickListener{

    Button btn1,btn2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        btn1 = findViewById(R.id.btnClaseAnonima);
        btn2 = findViewById(R.id.btnImplements);

        btn2.setOnClickListener(this);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Desde la anonima",Toast.LENGTH_SHORT).show();

            }
        });



    }

    @Override
    public void onClick(View view) {
        /*if (view.getId() == btn2.getId()){
            Toast.makeText(getApplicationContext(),"Desde el Onclick Implements",Toast.LENGTH_SHORT).show();
        }

        if (view.getId() == R.id.btn3){
            Toast.makeText(getApplicationContext(),"Desde el Onclick el metodo",Toast.LENGTH_SHORT).show();
        }*/

        switch (view.getId()){
            case R.id.btn3:
                Toast.makeText(getApplicationContext(),"Desde el Onclick metodo",Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnImplements:
                Toast.makeText(getApplicationContext(),"Desde el Onclick el Implements",Toast.LENGTH_SHORT).show();
                break;
        }

    }

    /*public void eventoBoton(View view) {
        Toast.makeText(getApplicationContext(),"Desde el metodo",Toast.LENGTH_SHORT).show();
    }*/
}
