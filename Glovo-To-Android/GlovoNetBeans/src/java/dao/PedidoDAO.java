/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidad.Pedido;
import entidad.Restaurante;
import interfacesDAO.SQLTools;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import motores.MotorMySQL;

/**
 *
 * @author alber
 */
public class PedidoDAO {

    private SQLTools miMotor = null;
    private static final String SQL_FINDALL = "SELECT * FROM `pedidos` WHERE 1=1 ";
    private final String SQL_PEDIDO = "INSERT INTO pedidos SET ";

    public PedidoDAO() {
        this.miMotor = new MotorMySQL();
    }

    public ArrayList<Pedido> findAllAk(Pedido bean) {
        String sql_filtro = "";
        String sql_final = "";
        ArrayList<Pedido> lstPedido = null;
        try {
            this.miMotor.connect();

            if (bean != null) {
                if (bean.getId_pedido() != 0) {
                    sql_filtro += "AND id_pedido='" + bean.getId_pedido() + "'";
                }
                if (bean.getId_usuario() != 0) {
                    sql_filtro += "AND Id_Usuario='" + bean.getId_usuario() + "'";
                }
                if (bean.getPrecio_total().length() > 0 && !bean.getPrecio_total().equals("") && bean.getPrecio_total() != null) {
                    sql_filtro += "AND precio_total='" + bean.getPrecio_total() + "'";
                }

                if (bean.getFecha().length() > 0 && !bean.getFecha().equals("") && bean.getFecha() != null) {
                    sql_filtro += "AND FECHA='" + bean.getFecha() + "'";
                }

            }

            sql_final = SQL_FINDALL + sql_filtro;

            ResultSet resultset = this.miMotor.executeQuery(sql_final);

            if (resultset != null) {
                lstPedido = new ArrayList();

                while (resultset.next()) {
                    Pedido entidad = new Pedido();
                    entidad.setId_pedido(resultset.getInt(1));
                    entidad.setId_usuario(resultset.getInt(2));
                    entidad.setPrecio_total(resultset.getString(3));
                    entidad.setFecha(resultset.getString(4));
                    lstPedido.add(entidad);

                }
            }
            this.miMotor.disconnect();
        } catch (Exception ex) {
            Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lstPedido;
    }

    public int add(Pedido bean) {
        //Usuario usuario = new Usuario();
        String sql = SQL_PEDIDO;
        int filas = 0;
        try {
            
            this.miMotor.connect();
            if (bean != null) {
                if (bean.getId_usuario() != 0) {
                    sql += " Id_Usuario='" + bean.getId_usuario() + "'";
                }
                if (bean.getPrecio_total().length() > 0 && !bean.getPrecio_total().equals("") && bean.getPrecio_total() != null) {
                    sql += ",precio_total ='" + bean.getPrecio_total() + "'";
                }
                if (bean.getFecha().length() > 0 && !bean.getFecha().equals("") && bean.getFecha() != null) {
                    sql += ",fecha='" + bean.getFecha() + "'";
                }

            }
            filas = miMotor.execute(sql);
            //this.miMotor.disconnect();

        } catch (Exception e) {
            Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return filas;
    }

}
