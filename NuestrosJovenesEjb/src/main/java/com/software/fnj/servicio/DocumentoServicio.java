/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.software.fnj.servicio;

import com.software.fnj.facade.DocumentoFacade;
import com.software.fnj.facade.SaludFacade;
import com.software.fnj.facade.UsuarioFacade;
import com.software.fnj.modelo.Documento;
import com.software.fnj.modelo.Salud;
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
public class DocumentoServicio {

    private static final java.util.logging.Logger LOG = java.util.logging.Logger.getLogger(DocumentoServicio.class.getName());

    @EJB
    UsuarioFacade usuarioFacade;
    @EJB
    DocumentoFacade documentoFacade;
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<Documento> obtenerDocumentoPorUsuario(Usuario usuario) throws ServiceException {
        List<Documento> documento = new ArrayList();
        try {
            documento = documentoFacade.obtenerDocumentoPorUsuarios(usuario);
        } catch (Exception e) {
            LOG.log(Level.SEVERE, "DocumentoServicio: Error al crear usuario usuario: " + usuario.getNombres());
            LOG.log(Level.SEVERE, "", e);
            throw new ServiceException("Se ha producido un error en el servidor", Response.Status.INTERNAL_SERVER_ERROR.getStatusCode());
        }
        return documento;
    }
}
