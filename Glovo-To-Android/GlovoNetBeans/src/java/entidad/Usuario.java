/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidad;

/**
 *
 * @author alber
 */
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

    public static String fromArrayListToJson(Usuario user) {
        String resp = "[";

        resp += "{"
                + "\"NOMBRE\":\"" + user.getNombre() + "\","
                + "\"PASSWORD\":\"" + user.getPassword() + "\", "
                + "\"EMAIL\":\"" + user.getEmail() + "\"}";
        resp += ",";

        resp += "]";
        return resp;
    }
}
