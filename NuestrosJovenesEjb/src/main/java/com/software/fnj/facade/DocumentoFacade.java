/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.software.fnj.facade;

import com.software.fnj.modelo.Documento;
import com.software.fnj.modelo.Salud;
import com.software.fnj.modelo.Usuario;
import com.software.fnj.response.exception.ServiceException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.core.Response;

/**
 *
 * @author Alterbios
 */
@Stateless
public class DocumentoFacade extends AbstractFacade<Documento> {

    private static final Logger LOG = Logger.getLogger(Salud.class.getName());

    @PersistenceContext(unitName = "fundacion")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DocumentoFacade() {
        super(Documento.class);
    }

    public Documento obtenerDocumentoPorUsuarios(Usuario usuario) throws ServiceException {
        Documento documento = new Documento();
        try {
            documento = em.createQuery("SELECT d FROM Documento d WHERE d.idusuario=:usuario",
                    Documento.class)
                    .setParameter("usuario", usuario)
                    .getSingleResult();
        } catch (Exception e) {
            LOG.log(Level.SEVERE, "DocumentoFacade: Error al consultar usuario por idUsuario: {0}{1}", new Object[]{usuario, e.toString()});
            throw new ServiceException("Se ha producido un error en el servidor", Response.Status.INTERNAL_SERVER_ERROR.getStatusCode());
        }
        return documento;
    }

}
