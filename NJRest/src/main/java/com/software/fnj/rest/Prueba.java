/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.software.fnj.rest;

import com.software.fnj.modelo.ionic.UsuarioIonic;
import com.software.fnj.response.exception.ServiceException;
import com.software.fnj.rest.respuesta.ServicioRestAcceso;
import com.software.fnj.util.Constante;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.*;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author santiago
 */
@Path("prueba")
@RequestScoped
public class Prueba {

    @Context
    private UriInfo context;

    @Inject
    ServicioRestAcceso servicioRestAcceso;

    /**
     * Creates a new instance of AutenticacionResource
     */
    public Prueba() {
    }

    @GET
    @Path("obtener_usuarios")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON + Constante.UTF8_CHARSET)
    public List<UsuarioIonic> autenticarUsuario() throws ServiceException {
        return servicioRestAcceso.getAllUsers();
    }

    @POST
    @Path("crear_usuario")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON + Constante.UTF8_CHARSET)
    public boolean crearUsuario(UsuarioIonic usuarioIonic) throws ServiceException {
        return servicioRestAcceso.crearUsuario(usuarioIonic);
    }

    @PUT
    @Path("editar_usuario")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON + Constante.UTF8_CHARSET)
    public boolean editar(UsuarioIonic usuarioIonic) throws ServiceException {
        return servicioRestAcceso.crearUsuario(usuarioIonic);
    }

}
