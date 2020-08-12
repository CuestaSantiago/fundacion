/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.software.fnj.facade;

import com.software.fnj.modelo.Nacionalidad;
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
public class NacionalidadFacade extends AbstractFacade<Nacionalidad> {

    private static final Logger LOG = Logger.getLogger(Nacionalidad.class.getName());

    @PersistenceContext(unitName = "fundacion")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public NacionalidadFacade() {
        super(Nacionalidad.class);
    }

    public Nacionalidad obtenerNaionalidadPorId(Integer idnacionalidad) throws ServiceException {
        Nacionalidad nacionalidad = new Nacionalidad();
        try {
            nacionalidad = em.createQuery("SELECT n FROM Nacionalidad n WHERE n.idnacionalidad = :idnacionalidad",
                    Nacionalidad.class)
                    .setParameter("idnacionalidad", idnacionalidad)
                    .getSingleResult();
        } catch (Exception e) {
            LOG.log(Level.SEVERE, "UsuarioFacade: Error al consultar usuario por idUsuario: {0}{1}", new Object[]{idnacionalidad, e.toString()});
            throw new ServiceException("Se ha producido un error en el servidor", Response.Status.INTERNAL_SERVER_ERROR.getStatusCode());
        }
        return nacionalidad;
    }

}
