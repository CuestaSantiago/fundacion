/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.software.fnj.facade;

import com.software.fnj.modelo.Pais;
import com.software.fnj.modelo.Perfil;
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
public class PaisFacade extends AbstractFacade<Pais> {

    private static final Logger LOG = Logger.getLogger(Perfil.class.getName());

    @PersistenceContext(unitName = "fundacion")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PaisFacade() {
        super(Pais.class);
    }

    public Pais obtenerPaisPorId(Integer idpais) throws ServiceException {
        Pais pais = new Pais();
        try {
            pais = em.createQuery("SELECT p FROM Pais p WHERE p.idpais = :idpais",
                    Pais.class)
                    .setParameter("idpais", idpais)
                    .getSingleResult();
        } catch (Exception e) {
            LOG.log(Level.SEVERE, "UsuarioFacade: Error al consultar usuario por idUsuario: {0}{1}", new Object[]{idpais, e.toString()});
            throw new ServiceException("Se ha producido un error en el servidor", Response.Status.INTERNAL_SERVER_ERROR.getStatusCode());
        }
        return pais;
    }

}
