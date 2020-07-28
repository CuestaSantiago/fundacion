/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.software.fnj.rest;


import com.software.fnj.response.exception.ServiceException;
import com.software.fnj.rest.respuesta.ServicioRestAcceso;
import com.software.fnj.rest.wsresponse.WsResponse;
import java.io.UnsupportedEncodingException;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
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
    @Path("usuarios")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public WsResponse autenticarUsuario() throws ServiceException{
        return servicioRestAcceso.getAllUsers();
    }
    
  
    
}
