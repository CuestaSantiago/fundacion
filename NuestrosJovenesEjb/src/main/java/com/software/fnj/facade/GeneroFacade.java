/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.software.fnj.facade;

import com.software.fnj.modelo.Genero;
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
public class GeneroFacade extends AbstractFacade<Genero> {

    private static final Logger LOG = Logger.getLogger(Genero.class.getName());

    @PersistenceContext(unitName = "fundacion")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public GeneroFacade() {
        super(Genero.class);
    }

    public Genero obtenerGeneroPorId(int idGenero) throws ServiceException {
        Genero genero = new Genero();
        try {
            genero = em.createQuery("SELECT g FROM Genero g WHERE g.idgenero = :idgenero",
                    Genero.class)
                    .setParameter("idgenero", idGenero)
                    .getSingleResult();
        } catch (Exception e) {
            LOG.log(Level.SEVERE, "UsuarioFacade: Error al consultar usuario por idUsuario: {0}{1}", new Object[]{idGenero, e.toString()});
            throw new ServiceException("Se ha producido un error en el servidor", Response.Status.INTERNAL_SERVER_ERROR.getStatusCode());
        }
        return genero;
    }
}
