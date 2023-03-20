/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package API;

import static com.sun.xml.ws.security.impl.policy.Constants.Body;
import dao.RestauranteDAO;
import dao.UsuarioDAO;
import entidad.Restaurante;
import entidad.Usuario;
import java.util.ArrayList;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author S2-PC00
 */
@Path("api")
public class ApiRestaurant {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of ApiRestaurant
     */
    public ApiRestaurant() {
    }

    /**
     * Retrieves representation of an instance of API.ApiRestaurant
     * @return an instance of java.lang.String
     */
    @GET
    @Path("/ventas")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String getRestaurantesVentas() {
        //TODO return proper representation object
        RestauranteDAO restauranteDAO = new RestauranteDAO();
        ArrayList<Restaurante> lstRestaurantes = restauranteDAO.findRestaurantesVentas(null);
        return Restaurante.fromArrayListToJson(lstRestaurantes);
    }
     /*http://192.168.104.78:8080/GlovoNetBeans/webresources/api/filtr_usu/Kebab   -> Clase */ 
    
    /*http://192.168.1.35:8888/GlovoNetBeans/webresources/api/filtr_usu/Kebab  -> Casa*/
    /**/
    @GET
    @Path("/filtr_usu/{tipo}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String getFiltroComida(@PathParam("tipo") String tipo) {
        //TODO return proper representation object
        
        
        RestauranteDAO restauranteDAO = new RestauranteDAO();
        Restaurante restaurante = new Restaurante();
        restaurante.setNOMBRE("");
        restaurante.setIMAGEN("");
        if(tipo.equals("Tipo")){
            restaurante.setTIPO("");
        }else{
            restaurante.setTIPO(tipo);
        }
        
        ArrayList<Restaurante> lstRestaurantes = restauranteDAO.findAllAk(restaurante);
        return Restaurante.fromArrayListToJson(lstRestaurantes);
    }
    @GET
    @Path("/ver_ficha/{nombreRestaurante}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String getFichaRestaurante(@PathParam("nombreRestaurante") String nombreRestaurante) {
        //TODO return proper representation object
        
        
        RestauranteDAO restauranteDAO = new RestauranteDAO();
        Restaurante restaurante = new Restaurante();
        if(nombreRestaurante.equals("")){
            restaurante.setNOMBRE("");
        }else{
            restaurante.setNOMBRE(nombreRestaurante);
        }
        
        Restaurante restauranteRespuesta = restauranteDAO.findOne(nombreRestaurante);
        return Restaurante.fromArrayListToJsonOnly(restauranteRespuesta);
    }
    @POST
    @Path("/register{usuario}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Usuario register(Usuario usuario){
        UsuarioDAO usuarioDao = new UsuarioDAO();
        ArrayList<Usuario> usuarios = usuarioDao.findAll(null);
        for (Usuario usuarioRespuesta : usuarios) {
            if (usuarioRespuesta.getEmail().equals(usuario.getEmail())) {
                return null;
            }
        }
        usuarioDao.add(usuario);
        return usuario;
    }
/*   @GET
    @Produces({MediaType.APPLICATION_JSON})
        return productoDAO.findAll();    public List<Producto> getProductos() {

    }
    @GET
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String buscarCine (@PathParam("id") int idCine) {
        CineDAO cineDao = new CineDAO();
        Cine cine = new Cine();
        cine.setId_cine(idCine);
        ArrayList<Cine> cines = cineDao.findAll(cine);
        return Cine.toArrayJSon(cines);
    }

@POST
    @Path("/login")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String login(Usuario usuario) {
        UsuarioDAO usuarioDao = new UsuarioDAO();
        ArrayList<Usuario> usuarios = usuarioDao.findAll(usuario);
        return Usuario.toObjectJSon(usuarios.get(0));
    }
@POST
    @Path("/register")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Usuario register(Usuario usuario) {
        UsuarioDAO usuarioDao = new UsuarioDAO();
        ArrayList<Usuario> usuarios = usuarioDao.findAll(null);
        for (Usuario usuarioRespuesta : usuarios) {
            if (usuarioRespuesta.getEmail().equals(usuario.getEmail())) {
                return null;
            }
        }
        usuarioDao.add(usuario);
        return usuario;
    }*/
   
}
