package com.example.glovoandroid.entities;

import com.google.gson.annotations.SerializedName;

public class Restaurante {
    @SerializedName("ID_PERSONA")
    private int id;
    @SerializedName("NOMBRE")
    private String nombre;
    @SerializedName("DIRECCION")
    private String direccion;
    public Restaurante() {

    }

    public Restaurante(int id, String nombre, String direccion) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

}
