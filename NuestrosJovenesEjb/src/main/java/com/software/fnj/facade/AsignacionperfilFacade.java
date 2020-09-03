/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.software.fnj.facade;

import com.software.fnj.modelo.Asignacionperfil;
import com.software.fnj.response.exception.ServiceException;
import com.software.fnj.util.Constante;
import com.software.fnj.util.Constante.UsuarioConstante;
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
 * @author bryan
 */
@Stateless
public class AsignacionperfilFacade extends AbstractFacade<Asignacionperfil> {

    private static final Logger LOG = Logger.getLogger(Asignacionperfil.class.getName());

    @PersistenceContext(unitName = "fundacion")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AsignacionperfilFacade() {
        super(Asignacionperfil.class);
    }

    public boolean verificarEmail(String correo) throws ServiceException {
        Long asignacionBoolean = -1l;
        try {
            asignacionBoolean = em.createQuery("select count(a.correo) FROM Asignacionperfil a WHERE a.correo = :correo", Long.class)
                    .setParameter("correo", correo).getSingleResult();
        } catch (Exception e) {
            LOG.log(Level.SEVERE, "AsignacionperfilFacade: Error al consultar asignacion por correo: {0}{1}", new Object[]{correo, e.toString()});
            throw new ServiceException("Se ha producido un error en el servidor", Response.Status.INTERNAL_SERVER_ERROR.getStatusCode());
        }
        return asignacionBoolean.equals(0l);//es cero long no uno   si encuentra algo es falso 
    }

    public List<Asignacionperfil> obetenerAsignaciones() throws ServiceException {
        List<Asignacionperfil> asignacion = new ArrayList();
        try {
            asignacion = em.createQuery("select a FROM Asignacionperfil a JOIN FETCH a.idperfil pa JOIN FETCH a.idusuario au  WHERE au.estado = :estadoActivo AND a.estado = :estadoActivo AND pa.idperfil=:admin", Asignacionperfil.class)
                    .setParameter("admin", Constante.PerfilConstante.ADMIN.getProfileId())
                    .setParameter("estadoActivo", UsuarioConstante.ACTIVO.getUsuarioConstanteId())
                    .getResultList();
        } catch (Exception e) {
            LOG.log(Level.SEVERE, "AsignacionperfilFacade: Error al consultar asignaciones: {0}", new Object[]{e.toString()});
            throw new ServiceException("Se ha producido un error en el servidor", Response.Status.INTERNAL_SERVER_ERROR.getStatusCode());
        }
        return asignacion;
    }

    public Asignacionperfil obtenerAsignacionPorIdAsignacion(Integer idAsignacion) throws ServiceException {
        Asignacionperfil asignacionBoolean = new Asignacionperfil();
        try {
            asignacionBoolean = em.createQuery("select a FROM Asignacionperfil a WHERE a.idasignacionPerfil = :idasignacionPerfil", Asignacionperfil.class)
                    .setParameter("idasignacionPerfil", idAsignacion).getSingleResult();
        } catch (Exception e) {
            LOG.log(Level.SEVERE, "AsignacionperfilFacade: Error al consultar asignacion por idAsignacion: {0}{1}", new Object[]{idAsignacion, e.toString()});
            throw new ServiceException("Se ha producido un error en el servidor", Response.Status.INTERNAL_SERVER_ERROR.getStatusCode());
        }
        return asignacionBoolean;
    }

    public Asignacionperfil obtenerAsignacionPerfilPorNombre(String nombre) throws ServiceException {
        Asignacionperfil asignacionBoolean = new Asignacionperfil();
        try {
            asignacionBoolean = em.createQuery("select a FROM Asignacionperfil a JOIN FETCH a.idperfil JOIN FETCH a.idusuario WHERE a.nombrePerfil =:nombreUsuario and a.estado =:estado", Asignacionperfil.class)
                    .setParameter("nombreUsuario", nombre)
                    .setParameter("estado", UsuarioConstante.ACTIVO.getUsuarioConstanteId()).getSingleResult();//forma de traer una constante de otra clase.
        } catch (Exception e) {
            LOG.log(Level.SEVERE, "AsignacionperfilFacade: Error al consultar usuario y password ", new Object[]{e.toString()});
            throw new ServiceException("Se ha producido un error en el servidor", Response.Status.INTERNAL_SERVER_ERROR.getStatusCode());
        }
        return asignacionBoolean;
    }

    public boolean verificarNombre(String nombre) throws ServiceException {
        Long asignacionBoolean = -1l;
        try {
            asignacionBoolean = em.createQuery("select count(a.nombrePerfil) FROM Asignacionperfil a WHERE a.nombrePerfil = :nombrePerfil", Long.class)
                    .setParameter("nombrePerfil", nombre).getSingleResult();
        } catch (Exception e) {
            LOG.log(Level.SEVERE, "AsignacionperfilFacade: Error al consultar asignacion por correo: {0}{1}", new Object[]{nombre, e.toString()});
            throw new ServiceException("Se ha producido un error en el servidor", Response.Status.INTERNAL_SERVER_ERROR.getStatusCode());
        }
        return asignacionBoolean.equals(0l);//es cero long no uno   si encuentra algo es falso 
    }

}
