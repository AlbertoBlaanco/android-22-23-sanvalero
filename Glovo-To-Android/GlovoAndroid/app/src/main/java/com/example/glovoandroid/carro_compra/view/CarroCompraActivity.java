package com.example.glovoandroid.carro_compra.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.glovoandroid.R;
import com.example.glovoandroid.carro_compra.ComprarContract;
import com.example.glovoandroid.carro_compra.presenter.ComprarPresenter;
import com.example.glovoandroid.entities.Plato;
import com.example.glovoandroid.fltr_usuario.view.FiltrUsuActivity;
import com.example.glovoandroid.hst_compras.view.HstComprasActivity;
import com.example.glovoandroid.verCarta.view.verCartaActivity;
import com.squareup.picasso.Picasso;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import java.util.Properties;

import java.io.Serializable;
import java.util.ArrayList;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class CarroCompraActivity extends AppCompatActivity implements ComprarContract.View {
    private ArrayList<Plato> carroCompras;
    private ComprarPresenter comprarPresenter;
    private VerCarroAdapter adapter;
    private RecyclerView rvListaCarro;
    private TextView tvTotal,tvCantProductos;
    private ImageView btnVolver;
    private Button btnComprar,btnverHst;

    // Propiedades del cliente de correo
    private static Session session;         // Sesion de correo
    private static Properties properties;   // Propiedades de la sesion
    private static Transport transport;     // Envio del correo
    private static MimeMessage mensaje;     // Mensaje que enviaremos

    // Credenciales de usuario
    private static String direccionCorreo = "a26004@svalero.com";   // Dirección de correo
    private static String contrasenyaCorreo = "3qcXNw3!";                 // Contraseña

    // Correo al que enviaremos el mensaje
    private static String destintatarioCorreo = "albertoblanco633@gmail.com";
    // NOTIFICACION
    private static final String CHANNEL_ID = "canal";
    private PendingIntent pendingIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carro_compra);
        //getSupportActionBar().hide();
        Bundle extras = getIntent().getExtras();
        int idRestaurante = extras.getInt("idRestaurante");
        int idUser = getIntent().getExtras().getInt("idUser");
        initComponents(idRestaurante);
        initPresenter();

    }
    public void initComponents(int idRestaurante){
        carroCompras = (ArrayList<Plato>) getIntent().getSerializableExtra("CarroCompras");
        rvListaCarro = findViewById(R.id.rvListaCarro);
        rvListaCarro.setLayoutManager(new GridLayoutManager(CarroCompraActivity.this, 1));
        tvTotal = findViewById(R.id.tvTotal);
        btnComprar = findViewById(R.id.btnComprar);
        btnverHst = findViewById(R.id.verHst);
        btnComprar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new SweetAlertDialog(CarroCompraActivity.this, SweetAlertDialog.WARNING_TYPE)
                        .setTitleText("Quieres comprar?")
                        .setContentText("No podrás recuperar tu dinero!")
                        .setConfirmText("Comprar")
                        .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                            @Override
                            public void onClick(SweetAlertDialog sDialog) {
                                sDialog.dismissWithAnimation();
                                initData(tvTotal.getText().toString(), String.valueOf(getIntent().getExtras().getInt("idUser")));
                            }
                        })
                        .setCancelButton("Cancel", new SweetAlertDialog.OnSweetClickListener() {
                            @Override
                            public void onClick(SweetAlertDialog sDialog) {
                                sDialog.dismissWithAnimation();
                            }
                        })
                        .show();
            }
        });
        btnVolver = findViewById(R.id.btnVolver);
        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), verCartaActivity.class);
                intent.putExtra("idRestaurante",idRestaurante);
                intent.putExtra("CarroCompras",(Serializable) carroCompras);
                intent.putExtra("tvCantProductos",getIntent().getExtras().getString("tvCantProductos"));
                intent.putExtra("idUser",String.valueOf(getIntent().getExtras().getInt("idUser")));
                startActivity(intent);
            }
        });
        VerCarroAdapter adapter = new VerCarroAdapter(getBaseContext(), carroCompras, tvTotal);
        rvListaCarro.setAdapter(adapter);

        btnverHst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), HstComprasActivity.class);
                intent.putExtra("CarroCompras",(Serializable) carroCompras);
                intent.putExtra("idUser",getIntent().getExtras().getInt("idUser"));
                intent.putExtra("idRestaurante",idRestaurante);
                intent.putExtra("tvCantProductos",getIntent().getExtras().getString("tvCantProductos"));
                startActivity(intent);
            }
        });


    }

    public void initPresenter(){
        comprarPresenter = new ComprarPresenter(this);
    }
    public void initData(String total, String idUser) {
        comprarPresenter.comprarCarro(total,idUser);

    }
    @Override
    public void onSuccessComprar(String respuesta) {
        new SweetAlertDialog(CarroCompraActivity.this)
                .setTitleText("Compra realizada con éxito!")
                .show();
    }

    @Override
    public void onFailureComprar(String err) {
        new SweetAlertDialog(CarroCompraActivity.this)
                .setTitleText("Compra realizada con éxito!")
                .show();

        //    PARTE DE MANDAR EL EMAIL
        //properties = System.getProperties();
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        properties = new Properties();
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.socketFactory.port", "465");
        properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.port", "465");
        try {
            //Configuramos la sesión
            session = Session.getDefaultInstance(properties, new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(direccionCorreo,contrasenyaCorreo);
                }
            });
            if(session!=null){
                mensaje = new MimeMessage(session);
                mensaje.setFrom(new InternetAddress(direccionCorreo));
                mensaje.setSubject("¡Gracias por tu compra!");
                mensaje.setRecipients(Message.RecipientType.TO,InternetAddress.parse("albertoblanco633@gmail.com"));
                String cnt = "";
                for(int i = 0 ; i < carroCompras.size() ; i++) {
                    cnt += carroCompras.get(i).getNombre() + ", ";
                }
                mensaje.setContent("Aqui tienes un resumen de la compra: "+ cnt+ " Total de: "+tvTotal.getText().toString()+"€\n Gracias por comprar con nosotros, esperamos verte pronto!" +  Picasso.get().load(R.drawable.homer),"text/html; charset=utf-8");
                Transport.send(mensaje);
            }
        } catch (MessagingException e) {
            e.printStackTrace();
        }

        // PARTE DE LA NOTIFICACIÓN


        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            showNotification();
        }else{
            showNewNotification();
        }

    }

    private void showNotification(){
        NotificationChannel channel = new NotificationChannel(CHANNEL_ID,"NEW",NotificationManager.IMPORTANCE_DEFAULT);
        NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        manager.createNotificationChannel(channel);
        showNewNotification();
    }

    private void showNewNotification(){
        setPendingIntent(CarroCompraActivity.class);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(getApplicationContext(), CHANNEL_ID)
                .setSmallIcon(R.drawable.background)
                .setContentTitle("Glovo-To-Android")
                .setContentText("¡Gracias por comprar con nosotros! OOOUUU YEAH")
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setContentIntent(pendingIntent);

        NotificationManagerCompat managerCompat = NotificationManagerCompat.from(getApplicationContext());
        managerCompat.notify(1,builder.build());
    }

    private void setPendingIntent(Class<?> clsActivity){
        Intent intent = new Intent(this, FiltrUsuActivity.class);
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
        stackBuilder.addParentStack(clsActivity);
        stackBuilder.addNextIntent(intent);
        pendingIntent = stackBuilder.getPendingIntent(1,PendingIntent.FLAG_IMMUTABLE);
    }
}