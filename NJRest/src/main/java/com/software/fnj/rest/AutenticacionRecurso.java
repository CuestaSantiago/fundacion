/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.software.fnj.rest;

import com.software.fnj.model.Ionic.AsignacionPerfilIonic;
import com.software.fnj.model.Ionic.AsignacionPerfilNewIonic;
import com.software.fnj.model.Ionic.AutoIonic;
import com.software.fnj.model.Ionic.DesactivadorAdminIonic;
import com.software.fnj.modelo.Asignacionperfil;
import com.software.fnj.response.exception.ServiceException;
import com.software.fnj.rest.respuesta.AutenticacionRestRecurso;
import com.software.fnj.util.Constante;
import java.io.UnsupportedEncodingException;
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
@Path("autenticacion")
@RequestScoped
public class AutenticacionRecurso {

    @Context
    private UriInfo context;

    @Inject
    AutenticacionRestRecurso servicioRestAcceso;

    /**
     * Creates a new instance of AutenticacionResource
     */
    public AutenticacionRecurso() {
    }

    @POST
    @Path("crear_administrador")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON + Constante.UTF8_CHARSET)
    public boolean crearAdministrador(AsignacionPerfilIonic asignacion) throws ServiceException {
        return servicioRestAcceso.crearAdministrador(asignacion);
    }
    
    @GET
    @Path("obtener_administrador")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON + Constante.UTF8_CHARSET)
    public List<AsignacionPerfilNewIonic> obtenerAdministradores() throws ServiceException, UnsupportedEncodingException {
        return servicioRestAcceso.obtenerAdministradores();
    }
    
    @PUT
    @Path("desactivar_administrador")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON + Constante.UTF8_CHARSET)
    public boolean desactivarAsignacionPerfil(DesactivadorAdminIonic desactivador) throws ServiceException {
        return servicioRestAcceso.desactivarAsignacionPerfil(desactivador);
    }

    
    //servicio rest Post comunicacion final con el postman
    @POST
    @Path("login")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON + Constante.UTF8_CHARSET)
    public Asignacionperfil login(AutoIonic autoIonic) throws ServiceException, UnsupportedEncodingException {
        return servicioRestAcceso.login(autoIonic);
    }
    
}
