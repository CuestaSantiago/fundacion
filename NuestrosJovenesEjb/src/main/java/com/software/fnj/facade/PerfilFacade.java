/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.software.fnj.facade;

import com.software.fnj.modelo.Perfil;
import com.software.fnj.response.exception.ServiceException;
import com.software.fnj.util.Constante;
import com.software.fnj.util.Constante.PerfilConstante;
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
public class PerfilFacade extends AbstractFacade<Perfil> {
    private static final Logger LOG = Logger.getLogger(Perfil.class.getName());

    @PersistenceContext(unitName = "fundacion")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PerfilFacade() {
        super(Perfil.class);
    }
    
      public Perfil obtenerPerfilAdmin() throws ServiceException {
         Perfil perfil = new Perfil();
        try {
            perfil = em.createQuery("SELECT p FROM Perfil p WHERE p.idperfil = :idperfil", Perfil.class)
                    .setParameter("idperfil", PerfilConstante.ADMIN.getProfileId()).getSingleResult();
        } catch (Exception e) {
            LOG.log(Level.SEVERE, "UsuarioFacade: Error al consultar asignacion por correo: {0}{1}", new Object[]{e.toString()});
            throw new ServiceException("Se ha producido un error en el servidor", Response.Status.INTERNAL_SERVER_ERROR.getStatusCode());
        }
        return perfil;//es cero long no uno   si encuentra algo es falso 
    }
}
