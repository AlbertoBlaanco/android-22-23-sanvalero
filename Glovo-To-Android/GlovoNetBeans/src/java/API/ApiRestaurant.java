/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package API;

import static com.sun.xml.ws.security.impl.policy.Constants.Body;
import dao.PedidoDAO;
import dao.PlatoDAO;
import dao.RestauranteDAO;
import dao.UsuarioDAO;
import entidad.Pedido;
import entidad.Plato;
import entidad.Restaurante;
import entidad.Usuario;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
     *
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
        if (tipo.equals("Tipo")) {
            restaurante.setTIPO("");
        } else {
            restaurante.setTIPO(tipo);
        }

        ArrayList<Restaurante> lstRestaurantes = restauranteDAO.findAllAk(restaurante);
        return Restaurante.fromArrayListToJson(lstRestaurantes);
    }

    @GET
    @Path("/ver_ficha/{idRestaurante}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String getFichaRestaurante(@PathParam("idRestaurante") int idRestaurante) {
        //TODO return proper representation object

        RestauranteDAO restauranteDAO = new RestauranteDAO();
        Restaurante restaurante = new Restaurante();
        if (idRestaurante != 0) {
            restaurante.setID_RESTAURANTE(idRestaurante);
        } else {

        }

        Restaurante restauranteRespuesta = restauranteDAO.findOne(restaurante);
        return Restaurante.fromArrayListToJsonOnly(restauranteRespuesta);
    }

    @GET
    @Path("/ver_carta/{idRestaurante}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String getCartaRestaurante(@PathParam("idRestaurante") int idRestaurante) {
        //TODO return proper representation object

        PlatoDAO platoDAO = new PlatoDAO();
        Plato plato = new Plato();
        if (idRestaurante != 0) {
            plato.setId_restaurante(idRestaurante);
        } else {

        }

        ArrayList<Plato> cartaRespuesta = platoDAO.findRestaurantesVentas(plato);
        return Plato.fromArrayListToJson(cartaRespuesta);
    }

    @GET
    @Path("/comprar/{total}/{idUser}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String comprarCarro(@PathParam("total") String total, @PathParam("idUser") int id_Usuario) {
        //TODO return proper representation object

        Pedido pedido = new Pedido();
        PedidoDAO pedidoDAO = new PedidoDAO();
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yy");

        pedido.setId_usuario(id_Usuario);
        pedido.setPrecio_total(total);
        pedido.setFecha(dateFormat.format(date));
        pedidoDAO.add(pedido);
        return "Hecho";
    }

    @GET
    @Path("/register/{nombre}/{password}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Usuario register(@PathParam("nombre") String nombre, @PathParam("password") String password) {
        UsuarioDAO usuarioDao = new UsuarioDAO();
        Usuario usuario = new Usuario();
        ArrayList<Usuario> usuarios = usuarioDao.findAll(null);
        for (Usuario usuarioRespuesta : usuarios) {
            if (usuarioRespuesta.getNombre().equals(nombre) && usuarioRespuesta.getPassword().equals(password)) {
                return null;
            }
        }
        usuarioDao.add(usuario);
        return usuario;
    }

    @GET
    @Path("/login/{nombre}/{password}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String login(@PathParam("nombre") String nombre, @PathParam("password") String password) {
        UsuarioDAO usuarioDao = new UsuarioDAO();
        Usuario usuario = new Usuario();
        usuario.setNombre(nombre);
        usuario.setPassword(password);
        ArrayList<Usuario> usuarios = usuarioDao.findOne(usuario);
        for (Usuario usuarioRespuesta : usuarios) {
            if (!usuarioRespuesta.getNombre().equals(nombre) && !usuarioRespuesta.getPassword().equals(password)) {
                return null;
            }
        }

        return Usuario.fromArrayListToJson(usuarios);
    }

    @GET
    @Path("/historialCompras/{idUser}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String getHstCompras(@PathParam("idUser") int idUsu) {
        //TODO return proper representation object

        PedidoDAO pedidoDAO = new PedidoDAO();
        Pedido pedido = new Pedido();
        pedido.setId_usuario(idUsu);
        pedido.setFecha("");
        pedido.setPrecio_total("");
        ArrayList<Pedido> lstPedidos = pedidoDAO.findAllAk(pedido);
        return Pedido.fromArrayListToJson(lstPedidos);
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
