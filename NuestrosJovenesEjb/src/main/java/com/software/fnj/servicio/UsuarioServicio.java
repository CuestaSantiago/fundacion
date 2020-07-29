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
            LOG.log(Level.SEVERE, "UserService: User: " + user.getNombres() + " successfully edited");
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, "UserService: Error editing user: " + user);
            LOG.log(Level.SEVERE, "", ex);
            throw new ServiceException("Se ha producido un error en el servidor", Response.Status.INTERNAL_SERVER_ERROR.getStatusCode());
        }
        return edit;
    }

    /**
     * 
     * @return
     * @throws ServiceException 
     */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<Usuario> getAllUsers() throws ServiceException {
        List<Usuario> usuarios = new ArrayList();
        try {
            usuarios = usuarioFacade.findAll();
            LOG.log(Level.SEVERE, "UserService: User: successfully edited");
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, "UserService: Error get all users: " + usuarios);
            LOG.log(Level.SEVERE, "", ex);
            throw new ServiceException("Se ha producido un error en el servidor", Response.Status.INTERNAL_SERVER_ERROR.getStatusCode());
        }
        return usuarios;
    }
}
