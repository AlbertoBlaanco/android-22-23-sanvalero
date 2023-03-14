/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidad;

import java.util.ArrayList;

/**
 *
 * @author S2-PC00
 */
public class Restaurante {

    private int id;
    private String nombre;
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

    public static String fromArrayListToJson(ArrayList<Restaurante> lstRestaurantes) {
        String resp = "[";
        for (Restaurante restaurante : lstRestaurantes) {
            resp += "{"
                    + "\"ID_PERSONA\" :\"" + restaurante.getId() + "\", "
                    + "\"NOMBRE\" : \"" + restaurante.getNombre() + "\","
                    + "\"DIRECCION\" : \"" + restaurante.getDireccion() + "\"}";
            resp += ",";
        }
        resp = resp.substring(0, resp.length() - 1);
        resp += "]";
        return resp;
    }

}
