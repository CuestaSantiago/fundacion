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

    public boolean obtenerCiudadPorId(String idciudad) throws ServiceException {
        Long userBoolean = -1l;
        try {
            userBoolean = em.createQuery("SELECT count(c.ciudad) FROM Ciudad c WHERE c.ciudad = :ciudad",
                    Long.class)
                    .setParameter("ciudad", idciudad)
                    .getSingleResult();
        } catch (Exception e) {
            LOG.log(Level.SEVERE, "UsuarioFacade: Error al consultar usuario por idUsuario: {0}{1}", new Object[]{idciudad, e.toString()});
            throw new ServiceException("Se ha producido un error en el servidor", Response.Status.INTERNAL_SERVER_ERROR.getStatusCode());
        }
        return userBoolean.equals(0l);

    }

    public Ciudad obtenerCiudadesPorCiudad(String ciudad) throws ServiceException {
        Ciudad ciudades = null;
        try {
            ciudades = em.createQuery("SELECT c FROM Ciudad c WHERE c.ciudad = :ciudad",
                    Ciudad.class)
                    .setParameter("ciudad", ciudad)
                    .getSingleResult();
        } catch (Exception e) {
            LOG.log(Level.SEVERE, "UsuarioFacade: Error al consultar usuario por idUsuario: {0}{1}", new Object[]{ciudad, e.toString()});
            throw new ServiceException("Se ha producido un error en el servidor", Response.Status.INTERNAL_SERVER_ERROR.getStatusCode());
        }
        return ciudades;
    }

}
