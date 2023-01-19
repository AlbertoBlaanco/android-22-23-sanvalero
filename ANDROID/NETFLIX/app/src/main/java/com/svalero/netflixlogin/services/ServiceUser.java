package com.svalero.netflixlogin.services;

import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.svalero.netflixlogin.MainActivity;

public class ServiceUser {
    //1º Opción para instanciar el MainActivity
    /* private MainActivity parent;
    public ServiceUser(MainActivity parent){
        this.parent = this.parent;
    }*/

    public static void validarUser(EditText edtUser, EditText edtPassword){
                if(!edtUser.equals("") && edtUser.length() > 0
                        && !edtPassword.equals("") && edtPassword.length() > 0){
                    Toast.makeText(MainActivity.getInstance(),
                            "Usuario y Password correctas...",
                            Toast.LENGTH_SHORT).show();
                }

        }
}
