/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.software.fnj.facade;

import com.software.fnj.modelo.Salud;
import com.software.fnj.modelo.Usuario;
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
public class SaludFacade extends AbstractFacade<Salud> {

    private static final Logger LOG = Logger.getLogger(Salud.class.getName());

    @PersistenceContext(unitName = "fundacion")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SaludFacade() {
        super(Salud.class);
    }

    public List<Salud> obtenerSaludPorUsuarios(Usuario usuario) throws ServiceException {
        List<Salud> salud = new ArrayList();
        try {
            salud = em.createQuery("SELECT s FROM Salud s WHERE s.idusuario=:usuario",
                    Salud.class)
                    .setParameter("usuario", usuario)
                    .getResultList();
        } catch (Exception e) {
            LOG.log(Level.SEVERE, "SaludFacade: Error al consultar usuario por idUsuario: {0}{1}", new Object[]{usuario, e.toString()});
            throw new ServiceException("Se ha producido un error en el servidor", Response.Status.INTERNAL_SERVER_ERROR.getStatusCode());
        }
        return salud;
    }
    
     public Salud obtenerSaludPorIdSalud(int idSalud) throws ServiceException {
        Salud salud = null;
        try {
            salud = em.createQuery("SELECT s FROM Salud s WHERE s.idsalud=:idsalud",
                    Salud.class)
                    .setParameter("idsalud", idSalud)
                    .getSingleResult();
        } catch (Exception e) {
            LOG.log(Level.SEVERE, "SaludFacade: Error al consultar salud por idsalud: {0}{1}", new Object[]{idSalud, e.toString()});
            throw new ServiceException("Se ha producido un error en el servidor", Response.Status.INTERNAL_SERVER_ERROR.getStatusCode());
        }
        return salud;
    }

}
