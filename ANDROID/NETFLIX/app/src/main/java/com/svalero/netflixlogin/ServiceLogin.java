package com.svalero.netflixlogin;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ServiceLogin {
    public static void mostrarLogin(Button btnLogin, EditText edtUser, EditText edtPassword){

//Overrride del metodo por defecto que tiene Android de OnClick
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = edtUser.getText().toString();
                String pass = edtPassword.getText().toString();

                if(!email.equals("") && email.length() > 0
                        && !pass.equals("") && pass.length() > 0){
                    Toast.makeText(MainActivity.getInstance(),
                            "Usuario y Password correctas...",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
