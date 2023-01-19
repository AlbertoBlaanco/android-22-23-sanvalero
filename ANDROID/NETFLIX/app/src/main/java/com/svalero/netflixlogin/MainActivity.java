package com.svalero.netflixlogin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.svalero.netflixlogin.services.ServiceUser;

public class MainActivity extends AppCompatActivity {
    private static  MainActivity mainActivity;
    @Override
    // ON LOAD JAVASCRIPT
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // ON LOAD JAVASCRIPT
        initComponents();
        this.parent = this;
    }
    private EditText edtUser;
    private EditText edtPassword;
    private Button btnLogin;
    private static MainActivity parent;

    private ServiceLogin serLogin = new ServiceLogin();
    private ServiceUser serviceUser = new ServiceUser();
    private void initComponents(){
        edtUser = (EditText) findViewById(R.id.edtUser);
        edtPassword= (EditText) findViewById(R.id.edtPass);
        btnLogin = (Button) findViewById(R.id.btnLogin5);
        //serviceUser.validarUser(edtUser,edtPassword);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //serLogin.mostrarLogin(btnLogin,edtUser,edtPassword);
                ServiceUser.validarUser(edtUser,edtPassword);
            }
        });










    }
    public static MainActivity getInstance(){
        if(mainActivity == null){
            return new MainActivity();
        }else{
            return mainActivity;
        }
    }
}
