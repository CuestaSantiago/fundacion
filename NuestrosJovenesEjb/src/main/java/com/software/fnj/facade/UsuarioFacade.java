/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.software.fnj.facade;

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
public class UsuarioFacade extends AbstractFacade<Usuario> {
    
     private static final Logger LOG = Logger.getLogger(Usuario.class.getName());

    @PersistenceContext(unitName = "fundacion")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioFacade() {
        super(Usuario.class);
    }
    
    
    /**
     * 
     * @param identificacion
     * @return
     * @throws ServiceException 
     */
    public Boolean verificarUsuarioRegistrado(String identificacion) throws ServiceException {
        Long userBoolean = -1l;
        try {
            userBoolean = em.createQuery("select count(u.identificacion) from Usuario u where u.identificacion=:identificacion", Long.class)
                    .setParameter("identificacion", identificacion).getSingleResult();
        } catch (Exception e) {
            LOG.log(Level.SEVERE, "UsuarioFacade: Error al consultar usuario por identificación: {0}{1}", new Object[]{identificacion, e.toString()});
            throw new ServiceException("Se ha producido un error en el servidor", Response.Status.INTERNAL_SERVER_ERROR.getStatusCode());
        }
        return userBoolean.equals(0l);//es cero long no uno   si encuentra algo es falso 
    }
    
    public Usuario obtenerusuarioPorIdUusario(int idUsuario) throws ServiceException{
    Usuario usuario = new Usuario();
        try {
            usuario = em.createQuery("select u from Usuario u JOIN FETCH u.idciudad JOIN FETCH u.idgenero JOIN FETCH u.idlugarIngreso JOIN FETCH u.idnacionalidad JOIN FETCH u.idpais JOIN FETCH u.saludCollection WHERE u.idusuario = :idusuario ", 
                    Usuario.class)
                    .setParameter("idusuario", idUsuario)
                    .getSingleResult();
        } catch (Exception e) {
            LOG.log(Level.SEVERE,"UsuarioFacade: Error al consultar usuario por idUsuario: {0}{1}", new Object[]{idUsuario, e.toString()});
            throw new ServiceException("Se ha producido un error en el servidor", Response.Status.INTERNAL_SERVER_ERROR.getStatusCode());
        }
        return usuario;
    }
}
