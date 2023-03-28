/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidad;

import java.util.ArrayList;

/**
 *
 * @author alber
 */
public class Pedido {
    private int id_pedido;
    private int id_usuario;
    private String precio_total;
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


    
    
    
    
    
    public static String fromArrayListToJson(ArrayList<Pedido> lstPedidos) {
        String resp = "[";
        for (Pedido pedido : lstPedidos) {
            resp += "{"
                    + "\"ID_PEDIDO\":\"" + pedido.getId_pedido()+ "\","
                    + "\"ID_USER\":\"" + pedido.getId_usuario()+ "\","
                    + "\"FECHA\":\"" + pedido.getFecha()+ "\", "
                    + "\"PRECIO\":\"" + pedido.getPrecio_total()+ "\"}";
            resp += ",";

        }
        resp = resp.substring(0, resp.length() - 1);
        resp += "]";
        return resp;
    }
}
