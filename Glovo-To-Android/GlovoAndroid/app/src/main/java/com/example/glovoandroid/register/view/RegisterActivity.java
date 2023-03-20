package com.example.glovoandroid.register.view;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.glovoandroid.R;
import com.example.glovoandroid.entities.Usuario;

import com.example.glovoandroid.register.RegisterContract;
import com.example.glovoandroid.register.presenter.RegisterPresenter;

public class RegisterActivity extends AppCompatActivity implements RegisterContract.View {
    private RegisterPresenter registerPresenter;
    private TextView nombre;
    private TextView email;
    private TextView password;

    private Button bt1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        initComponents();
        initPresenter();
        //initData();
    }
    public void initComponents(){
        nombre = findViewById(R.id.NombreUsuario);
        email = findViewById(R.id.EmailUsuario);
        password = findViewById(R.id.PasswordUsuario);
        bt1 = findViewById(R.id.btn1);

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Usuario user = new Usuario();
                user.setNombre(String.valueOf(nombre));
                user.setEmail(String.valueOf(email));
                user.setPassword(String.valueOf(password));
                initData(user);
            }
        });




    }
    public void initPresenter()
    {
        registerPresenter = new RegisterPresenter(this);
    }
    public void initData(Usuario user){
        registerPresenter.register(user);
    }

    @Override
    public void onSuccessRegister(Usuario user) {
        //Llamaríamos al Adapter
        Toast.makeText(this,"BIENVENIDO:" + user.getNombre() , Toast.LENGTH_LONG).show();
    }

    @Override
    public void onFailureRegister(String err) {
        Toast.makeText(this, err, Toast.LENGTH_LONG).show();
    }
}