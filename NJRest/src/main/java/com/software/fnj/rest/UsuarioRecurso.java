/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.software.fnj.rest;

import com.software.fnj.model.Ionic.CodigoPaisIonic;
import com.software.fnj.model.Ionic.DocumentoIonic;
import com.software.fnj.model.Ionic.UsuarioIonic;
import com.software.fnj.model.Ionic.UsuarioNuevoIonic;
import com.software.fnj.modelo.Ciudad;
import com.software.fnj.modelo.Genero;
import com.software.fnj.modelo.Lugaringreso;
import com.software.fnj.modelo.Nacionalidad;
import com.software.fnj.modelo.Pais;
import com.software.fnj.modelo.Parentescofamiliar;
import com.software.fnj.response.exception.ServiceException;
import com.software.fnj.rest.respuesta.ServicioRestUsuarioRecurso;
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
@Path("usuario_recurso")
@RequestScoped
public class UsuarioRecurso {

    @Context
    private UriInfo context;

    @Inject
    ServicioRestUsuarioRecurso servicioRestUsuarioRecurso;

    /**
     * Creates a new instance of AutenticacionResource
     */
    public UsuarioRecurso() {
    }

    @GET
    @Path("obtener_usuarios")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON + Constante.UTF8_CHARSET)
    public List<UsuarioIonic> autenticarUsuario() throws ServiceException {
        return servicioRestUsuarioRecurso.getAllUsers();
    }

    @GET
    @Path("obtener_ciudades")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON + Constante.UTF8_CHARSET)
    public List<Ciudad> obtenerCiudades() throws ServiceException {
        return servicioRestUsuarioRecurso.obtenerCiudades();
    }

    @GET
    @Path("obtener_generos")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON + Constante.UTF8_CHARSET)
    public List<Genero> obtenerGeneros() throws ServiceException {
        return servicioRestUsuarioRecurso.obtenerGeneros();
    }

    @GET
    @Path("obtener_nacionalidades")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON + Constante.UTF8_CHARSET)
    public List<Nacionalidad> obtenerNacionalidades() throws ServiceException {
        return servicioRestUsuarioRecurso.obtenerNacionalidades();
    }

    @GET
    @Path("obtener_paises")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON + Constante.UTF8_CHARSET)
    public List<Pais> obtenerPaises() throws ServiceException {
        return servicioRestUsuarioRecurso.obtenerPaises();
    }

    @GET
    @Path("obtener_lugaringreso")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON + Constante.UTF8_CHARSET)
    public List<Lugaringreso> obtenernLugarIngreso() throws ServiceException {
        return servicioRestUsuarioRecurso.obtenernLugarIngreso();
    }

    @POST
    @Path("agregar_documento")
    @Consumes(MediaType.APPLICATION_JSON + Constante.UTF8_CHARSET)
    @Produces(MediaType.APPLICATION_JSON + Constante.UTF8_CHARSET)
    public boolean agregarDocumento(DocumentoIonic documendo) throws ServiceException {
        return servicioRestUsuarioRecurso.agregarDocumento(documendo);
    }

    @POST
    @Path("registrar_usuario")
    @Consumes(MediaType.APPLICATION_JSON + Constante.UTF8_CHARSET)
    @Produces(MediaType.APPLICATION_JSON + Constante.UTF8_CHARSET)
    public boolean registrarUsuario(List<UsuarioNuevoIonic>  newUsuario) throws ServiceException {
       return servicioRestUsuarioRecurso.agregarUsuarios(newUsuario);
    }
    
    @GET
    @Path("obtener_parentescos")
    @Consumes(MediaType.APPLICATION_JSON + Constante.UTF8_CHARSET)
    @Produces(MediaType.APPLICATION_JSON + Constante.UTF8_CHARSET)
    public List<Parentescofamiliar>  obtenerParentescos() throws ServiceException {
        return servicioRestUsuarioRecurso.obtenerParentescos();
    }
    
}
