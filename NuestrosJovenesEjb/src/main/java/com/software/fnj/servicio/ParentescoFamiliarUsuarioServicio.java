/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.software.fnj.servicio;

import com.software.fnj.facade.ParentescofamiliarFacade;
import com.software.fnj.facade.ParentescofamiliarusuarioFacade;
import com.software.fnj.modelo.Parentescofamiliar;
import com.software.fnj.modelo.Parentescofamiliarusuario;
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
public class ParentescoFamiliarUsuarioServicio {

    private static final java.util.logging.Logger LOG = java.util.logging.Logger.getLogger(ParentescoFamiliarUsuarioServicio.class.getName());

    @EJB
    ParentescofamiliarusuarioFacade parentescoFamiliarUsuarioFacade;

    @EJB
    ParentescofamiliarFacade parentescoFamiliarFacade;

    /**
     *
     * @return @throws ServiceException
     */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<Parentescofamiliarusuario> obtenerUsuariosActivos() throws ServiceException {
        List<Parentescofamiliarusuario> usuarios = new ArrayList();
        try {
            usuarios = parentescoFamiliarUsuarioFacade.obtenerUsuariosActivos();
            LOG.log(Level.SEVERE, "UsuarioServicio: User: successfully edited");
        } catch (Exception e) {
            LOG.log(Level.SEVERE, "UsuarioServicio: Error get all users: " + usuarios);
            LOG.log(Level.SEVERE, "", e);
            throw new ServiceException("Se ha producido un error en el servidor", Response.Status.INTERNAL_SERVER_ERROR.getStatusCode());
        }
        return usuarios;
    }

    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<Parentescofamiliar> obtenerParentescos() throws ServiceException {
        List<Parentescofamiliar> parentesco = new ArrayList();
        try {
            parentesco = parentescoFamiliarFacade.findAll();
            LOG.log(Level.SEVERE, "UsuarioServicio: User: successfully edited");
        } catch (Exception e) {
            LOG.log(Level.SEVERE, "UsuarioServicio: Error get all users: " + parentesco);
            LOG.log(Level.SEVERE, "", e);
            throw new ServiceException("Se ha producido un error en el servidor", Response.Status.INTERNAL_SERVER_ERROR.getStatusCode());
        }
        return parentesco;
    }
    
     @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<Parentescofamiliarusuario> obenerTodosLosUsuarios() throws ServiceException {
        List<Parentescofamiliarusuario> usuarios = new ArrayList();
        try {
            usuarios = parentescoFamiliarUsuarioFacade.obtenerUsuariosActivos();
            LOG.log(Level.SEVERE, "UsuarioServicio: User: successfully edited");
        } catch (Exception e) {
            LOG.log(Level.SEVERE, "UsuarioServicio: Error get all users actavete");
            LOG.log(Level.SEVERE, "", e);
            throw new ServiceException("Se ha producido un error en el servidor", Response.Status.INTERNAL_SERVER_ERROR.getStatusCode());
        }
        return usuarios;
    }

     @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<Parentescofamiliarusuario> obtenerUsuariosInactivos() throws ServiceException {
        List<Parentescofamiliarusuario> usuarios = new ArrayList();
        try {
            usuarios = parentescoFamiliarUsuarioFacade.obtenerUsuariosInactivos();
            LOG.log(Level.SEVERE, "UsuarioServicio: User: successfully edited");
        } catch (Exception e) {
            LOG.log(Level.SEVERE, "UsuarioServicio: Error get all users inactivate");
            LOG.log(Level.SEVERE, "", e);
            throw new ServiceException("Se ha producido un error en el servidor", Response.Status.INTERNAL_SERVER_ERROR.getStatusCode());
        }
        return usuarios;
    }
}
