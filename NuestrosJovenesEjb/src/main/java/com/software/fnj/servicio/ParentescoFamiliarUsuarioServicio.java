/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.software.fnj.servicio;

import com.software.fnj.facade.ParentescofamiliarusuarioFacade;
import com.software.fnj.facade.UsuarioFacade;
import com.software.fnj.modelo.Parentescofamiliarusuario;
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
public class ParentescoFamiliarUsuarioServicio {

    private static final java.util.logging.Logger LOG = java.util.logging.Logger.getLogger(ParentescoFamiliarUsuarioServicio.class.getName());

    @EJB
    ParentescofamiliarusuarioFacade parentescoFamiliarUsuarioFacade;
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
    
}
