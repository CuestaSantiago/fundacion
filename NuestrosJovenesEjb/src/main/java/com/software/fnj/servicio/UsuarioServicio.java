/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.software.fnj.servicio;

import com.software.fnj.facade.CiudadFacade;
import com.software.fnj.facade.DocumentoFacade;
import com.software.fnj.facade.GeneroFacade;
import com.software.fnj.facade.LugaringresoFacade;
import com.software.fnj.facade.NacionalidadFacade;
import com.software.fnj.facade.PaisFacade;
import com.software.fnj.facade.UsuarioFacade;
import com.software.fnj.model.Ionic.DocumentoIonic;
import com.software.fnj.modelo.Ciudad;
import com.software.fnj.modelo.Documento;
import com.software.fnj.modelo.Genero;
import com.software.fnj.modelo.Lugaringreso;
import com.software.fnj.modelo.Nacionalidad;
import com.software.fnj.modelo.Pais;
import com.software.fnj.modelo.Usuario;
import com.software.fnj.response.exception.ServiceException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ws.rs.core.Response;

/**
 *
 * @author santiago
 */
@Stateless
@LocalBean
public class UsuarioServicio {

    private static final java.util.logging.Logger LOG = java.util.logging.Logger.getLogger(UsuarioServicio.class.getName());

    @EJB
    UsuarioFacade usuarioFacade;
    @EJB
    CiudadFacade ciudadFacade;
    @EJB
    PaisFacade paisFacade;
    @EJB
    GeneroFacade generoFacade;
    @EJB
    NacionalidadFacade nacionalidadFacade;
    @EJB
    LugaringresoFacade lugaringresoFacade;
    @EJB
    DocumentoFacade documentoFacade; 

    /**
     * Method that carries out the edition of an event already created in the
     * database
     *
     * @param user is the complete event to be edited
     * @boolean return with the edit response
     */
    public boolean editarUsuario(Usuario user) throws ServiceException {
        Boolean edit = false;
        try {
            usuarioFacade.edit(user);
            edit = true;
            LOG.log(Level.SEVERE, "UsuarioServicio: User: " + user.getNombres() + " successfully edited");
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, "UsuarioServicio: Error editing user: " + user);
            LOG.log(Level.SEVERE, "", ex);
            throw new ServiceException("Se ha producido un error en el servidor", Response.Status.INTERNAL_SERVER_ERROR.getStatusCode());
        }
        return edit;
    }

    /**
     *
     * @param idUsuario
     * @return
     * @throws ServiceException
     */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public Usuario obtenerUsarioPorIdUsuario(int idUsuario) throws ServiceException {
        Usuario usuario = new Usuario();
        try {
            usuario = usuarioFacade.obtenerusuarioPorIdUusario(idUsuario);
        } catch (Exception e) {
            LOG.log(Level.SEVERE, "UsuarioServicio: Error al obtener usuario por id:" + idUsuario);
            LOG.log(Level.SEVERE, "", e);
            throw new ServiceException("Se ha producido un error en el servidor", Response.Status.INTERNAL_SERVER_ERROR.getStatusCode());
        }
        return usuario;
    }

    public boolean crearUsuario(Usuario usuario) throws ServiceException {
        boolean exito = false;
        try {
            if (usuarioFacade.verificarUsuarioRegistrado(usuario.getIdentificacion())) {
                usuarioFacade.create(usuario);
                exito = true;
            } else {
                LOG.log(Level.SEVERE, "UsuarioServicio: Usuario ya registrado: " + usuario.getNombres());
            }
        } catch (Exception e) {
            LOG.log(Level.SEVERE, "UsuarioServicio: Error al crear usuario usuario: " + usuario.getNombres());
            LOG.log(Level.SEVERE, "", e);
            throw new ServiceException("Se ha producido un error en el servidor", Response.Status.INTERNAL_SERVER_ERROR.getStatusCode());
        }
        return exito;
    }

    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<Ciudad> obtenerCiudades() throws ServiceException {
        List<Ciudad> ciudades = new ArrayList();
        try {
            ciudades = ciudadFacade.findAll();
        } catch (Exception e) {
            LOG.log(Level.SEVERE, "UsuarioServicio: Error al obtener ciudades");
            LOG.log(Level.SEVERE, "", e);
            throw new ServiceException("Se ha producido un error en el servidor", Response.Status.INTERNAL_SERVER_ERROR.getStatusCode());
        }
        return ciudades;
    }

    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<Pais> obtenerPaises() throws ServiceException {
        List<Pais> paises = new ArrayList();
        try {
            paises = paisFacade.findAll();
        } catch (Exception e) {
            LOG.log(Level.SEVERE, "UsuarioServicio: Error al obtener ciudades");
            LOG.log(Level.SEVERE, "", e);
            throw new ServiceException("Se ha producido un error en el servidor", Response.Status.INTERNAL_SERVER_ERROR.getStatusCode());
        }
        return paises;
    }

    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<Genero> obtenerGeneros() throws ServiceException {
        List<Genero> generos = new ArrayList();
        try {
            generos = generoFacade.findAll();
        } catch (Exception e) {
            LOG.log(Level.SEVERE, "UsuarioServicio: Error al obtener ciudades");
            LOG.log(Level.SEVERE, "", e);
            throw new ServiceException("Se ha producido un error en el servidor", Response.Status.INTERNAL_SERVER_ERROR.getStatusCode());
        }
        return generos;
    }

    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<Nacionalidad> obtenernacionalidades() throws ServiceException {
        List<Nacionalidad> nacionalidad = new ArrayList();
        try {
            nacionalidad = nacionalidadFacade.findAll();
        } catch (Exception e) {
            LOG.log(Level.SEVERE, "UsuarioServicio: Error al obtener ciudades");
            LOG.log(Level.SEVERE, "", e);
            throw new ServiceException("Se ha producido un error en el servidor", Response.Status.INTERNAL_SERVER_ERROR.getStatusCode());
        }
        return nacionalidad;
    }

    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<Lugaringreso> obtenernLugarIngreso() throws ServiceException {
        List<Lugaringreso> nacionalidad = new ArrayList();
        try {
            nacionalidad = lugaringresoFacade.findAll();
        } catch (Exception e) {
            LOG.log(Level.SEVERE, "UsuarioServicio: Error al obtener Lugares de ingreso");
            LOG.log(Level.SEVERE, "", e);
            throw new ServiceException("Se ha producido un error en el servidor", Response.Status.INTERNAL_SERVER_ERROR.getStatusCode());
        }
        return nacionalidad;
    }
    
     public boolean agregarDocumento(DocumentoIonic docUsuario) throws ServiceException {
        boolean exito = false;
        Usuario usuario = new Usuario();
        Documento documento = new Documento();
        try {
            usuario = usuarioFacade.obtenerusuarioPorIdUusario(docUsuario.getIdUsuario());
            if (usuario != null) {
                documento.setDocumento(docUsuario.getDocumento());
                documento.setIdusuario(usuario);
                documento.setObservacion(docUsuario.getObservacion());
                documentoFacade.create(documento);
                exito = true;
            } else {
                LOG.log(Level.SEVERE, "UsuarioServicio: Usuario ya registrado: " + docUsuario.getIdUsuario());
            }
        } catch (Exception e) {
            LOG.log(Level.SEVERE, "UsuarioServicio: Error al crear usuario usuario: " + docUsuario.getIdUsuario());
            LOG.log(Level.SEVERE, "", e);
            throw new ServiceException("Se ha producido un error en el servidor", Response.Status.INTERNAL_SERVER_ERROR.getStatusCode());
        }
        return exito;
    }
}
