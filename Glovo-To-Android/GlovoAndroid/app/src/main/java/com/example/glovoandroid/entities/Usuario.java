package com.example.glovoandroid.entities;

import com.google.gson.annotations.SerializedName;

public class Usuario {

    @SerializedName("ID_USER")
    private int idUser;
    @SerializedName("NOMBRE")
    private String nombre;
    @SerializedName("EMAIL")
    private String email;
    @SerializedName("PASSWORD")
    private String password;


    public Usuario() {

    }

    public Usuario(int idUser,String nommbre, String email, String password) {
        this.nombre = nommbre;
        this.email = email;
        this.password = password;
        this.idUser = idUser;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nommbre) {
        this.nombre = nommbre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }
}
