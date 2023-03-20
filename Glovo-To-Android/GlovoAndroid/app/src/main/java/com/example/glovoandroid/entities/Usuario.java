package com.example.glovoandroid.entities;

public class Usuario {
    private String nombre;
    private String email;
    private String password;

    public Usuario() {

    }

    public Usuario(String nommbre, String email, String password) {
        this.nombre = nommbre;
        this.email = email;
        this.password = password;
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
}
