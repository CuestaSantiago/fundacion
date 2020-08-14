/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.software.fnj.facade;

import com.software.fnj.modelo.Lugaringreso;
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
public class LugaringresoFacade extends AbstractFacade<Lugaringreso> {
     private static final Logger LOG = Logger.getLogger(Lugaringreso.class.getName());

    @PersistenceContext(unitName = "fundacion")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public LugaringresoFacade() {
        super(Lugaringreso.class);
    }

    public Lugaringreso obtenerLugarIngresoPorId(String idlugarIngreso) throws ServiceException {
        Lugaringreso lugarIngreso = null;
        try {
            lugarIngreso = em.createQuery("SELECT l FROM Lugaringreso l WHERE l.nombre = :nombre",
                    Lugaringreso.class)
                    .setParameter("nombre", idlugarIngreso)
                    .getSingleResult();
        } catch (Exception e) {
            LOG.log(Level.SEVERE, "UsuarioFacade: Error al consultar usuario por idUsuario: {0}{1}", new Object[]{idlugarIngreso, e.toString()});
            throw new ServiceException("Se ha producido un error en el servidor", Response.Status.INTERNAL_SERVER_ERROR.getStatusCode());
        }
        return lugarIngreso;
    }
    
    public Boolean verificarLugarIngreso(String lugarIngreso) throws ServiceException {
        Long userBoolean = -1l;
        try {
            userBoolean = em.createQuery("SELECT count(l.nombre) FROM Lugaringreso l WHERE l.nombre = :nombre", Long.class)
                    .setParameter("nombre", lugarIngreso).getSingleResult();
        } catch (Exception e) {
            LOG.log(Level.SEVERE, "UsuarioFacade: Error al consultar usuario por identificación: {0}{1}", new Object[]{lugarIngreso, e.toString()});
            throw new ServiceException("Se ha producido un error en el servidor", Response.Status.INTERNAL_SERVER_ERROR.getStatusCode());
        }
        return userBoolean.equals(0l);//es cero long no uno   si encuentra algo es falso 
    }
    
}
