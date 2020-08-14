/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.software.fnj.facade;

import com.software.fnj.modelo.Parentescofamiliarusuario;
import com.software.fnj.modelo.Salud;
import com.software.fnj.modelo.Usuario;
import com.software.fnj.response.exception.ServiceException;
import com.software.fnj.util.Constante;
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
public class ParentescofamiliarusuarioFacade extends AbstractFacade<Parentescofamiliarusuario> {
     
    private static final Logger LOG = Logger.getLogger(Parentescofamiliarusuario.class.getName());

    @PersistenceContext(unitName = "fundacion")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ParentescofamiliarusuarioFacade() {
        super(Parentescofamiliarusuario.class);
    }
    
    
    public List<Parentescofamiliarusuario> obtenerUsuariosActivos() throws ServiceException {
        List<Parentescofamiliarusuario> usuarios = new ArrayList();
        try {
            usuarios = em.createQuery("select p FROM Parentescofamiliarusuario p JOIN FETCH p.idparentescoFamiliar JOIN FETCH p.idusuario up JOIN FETCH up.idciudad JOIN FETCH up.idgenero JOIN FETCH up.idpais JOIN FETCH up.idlugarIngreso JOIN FETCH up.idnacionalidad WHERE up.estado=:estado",
                    Parentescofamiliarusuario.class)
                    .setParameter("estado", Constante.UsuarioConstante.ACTIVO.getUsuarioConstanteId())
                    .getResultList();
        } catch (Exception e) {
            LOG.log(Level.SEVERE,"ParentescoFamiliarUsuarioFacade: Error al consultar usuario por id del Usuario: {0}{1}", new Object[]{Constante.UsuarioConstante.ACTIVO.getUsuarioConstanteId(), e.toString()});
            throw new ServiceException("Se ha producido un error en el servidor", Response.Status.INTERNAL_SERVER_ERROR.getStatusCode());
        }
        return usuarios;
    }
}
