/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.software.fnj.servicio;

import com.software.fnj.facade.UsuarioFacade;
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
     * @return @throws ServiceException
     */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<Usuario> obtenerUsuariosActivos() throws ServiceException {
        List<Usuario> usuarios = new ArrayList();
        try {
            usuarios = usuarioFacade.obtenerUsuariosActivos();
            LOG.log(Level.SEVERE, "UsuarioServicio: Useuarios activos obtenidos");
        } catch (Exception e) {
            LOG.log(Level.SEVERE, "UsuarioServicio: Error get all users: " + usuarios);
            LOG.log(Level.SEVERE, "", e);
            throw new ServiceException("Se ha producido un error en el servidor", Response.Status.INTERNAL_SERVER_ERROR.getStatusCode());
        }
        return usuarios;
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

    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
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
}
