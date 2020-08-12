/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.software.fnj.facade;

import com.software.fnj.modelo.Ciudad;
import com.software.fnj.response.exception.ServiceException;
import java.util.ArrayList;
import java.util.List;
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
public class CiudadFacade extends AbstractFacade<Ciudad> {

    private static final Logger LOG = Logger.getLogger(Ciudad.class.getName());

    @PersistenceContext(unitName = "fundacion")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CiudadFacade() {
        super(Ciudad.class);
    }

    public Ciudad obtenerCiudadPorId(Integer idciudad) throws ServiceException {
        Ciudad ciudad = new Ciudad();
        try {
            ciudad = em.createQuery("SELECT c FROM Ciudad c WHERE c.idciudad = :idciudad",
                    Ciudad.class)
                    .setParameter("idciudad", idciudad)
                    .getSingleResult();
        } catch (Exception e) {
            LOG.log(Level.SEVERE, "UsuarioFacade: Error al consultar usuario por idUsuario: {0}{1}", new Object[]{idciudad, e.toString()});
            throw new ServiceException("Se ha producido un error en el servidor", Response.Status.INTERNAL_SERVER_ERROR.getStatusCode());
        }
        return ciudad;
    }

    public List<Ciudad> obtenerCiudadesPorCodigoPais(String paisCodigo) throws ServiceException {
        List<Ciudad> ciudad = new ArrayList();
        try {
            ciudad = em.createQuery("SELECT c FROM Ciudad c WHERE c.paisCodigo = :paisCodigo",
                    Ciudad.class)
                    .setParameter("paisCodigo", paisCodigo)
                    .getResultList();
        } catch (Exception e) {
            LOG.log(Level.SEVERE, "UsuarioFacade: Error al consultar usuario por idUsuario: {0}{1}", new Object[]{paisCodigo, e.toString()});
            throw new ServiceException("Se ha producido un error en el servidor", Response.Status.INTERNAL_SERVER_ERROR.getStatusCode());
        }
        return ciudad;
    }

}
