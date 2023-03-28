package com.example.glovoandroid.entities;

import com.google.gson.annotations.SerializedName;

public class Pedido {
    @SerializedName("ID_PEDIDO")
    private int id_pedido;
    @SerializedName("ID_USER")
    private int id_usuario;
    @SerializedName("PRECIO")
    private String precio_total;
    @SerializedName("FECHA")
    private String fecha;

    public Pedido() {
    }

    public Pedido(int id_pedido, int id_usuario, String precio_total, String fecha) {
        this.id_pedido = id_pedido;
        this.id_usuario = id_usuario;
        this.precio_total = precio_total;
        this.fecha = fecha;
    }

    public int getId_pedido() {
        return id_pedido;
    }

    public void setId_pedido(int id_pedido) {
        this.id_pedido = id_pedido;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getPrecio_total() {
        return precio_total;
    }

    public void setPrecio_total(String precio_total) {
        this.precio_total = precio_total;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

}
