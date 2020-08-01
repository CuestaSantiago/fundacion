/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.software.fnj.rest.respuesta;

import com.software.fnj.modelo.Asignacionperfil;
import com.software.fnj.model.Ionic.AsignacionPerfilIonic;
import com.software.fnj.response.exception.ServiceException;
import com.software.fnj.servicio.AsignacionPerfilServicio;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.core.Response;

/**
 *
 * @author santiago
 */
@Stateless
@LocalBean
public class AutenticacionRestRecurso {

    @EJB
    AsignacionPerfilServicio asignacionPerfilServicio;

    public Boolean crearAdministrador(AsignacionPerfilIonic usuarioIonic) throws ServiceException {
        boolean asignacion = false;
        if (usuarioIonic != null) {
            asignacion = asignacionPerfilServicio.crearAsignacionPerfil(usuarioIonic);
        } else {
            throw new ServiceException("No se ha podido crear asignacion por el momento", Response.Status.INTERNAL_SERVER_ERROR.getStatusCode());
        }
        return asignacion;
    }

    public List<Asignacionperfil> obtenerAdministradores() throws ServiceException {
        List<Asignacionperfil> asignacionperfil = new ArrayList();
        asignacionperfil = asignacionPerfilServicio.obtenerAsignaciones();
        if (asignacionperfil != null && asignacionperfil.size() > 0) {
            return asignacionperfil;
        } else {
            throw new ServiceException("No se ha podido encontrar asignaciones de perfiles por el momento", Response.Status.INTERNAL_SERVER_ERROR.getStatusCode());
        }
    }
    
    public Boolean desactivarAsignacionPerfil(Integer idAdministrador) throws ServiceException {
        boolean asignacion = false;
        
        if (idAdministrador != null) {
            asignacion = asignacionPerfilServicio.desactivarAsignacionPerfil(idAdministrador);
        } else {
            throw new ServiceException("No se ha podido desactivar asignaciones de perfiles por el momento", Response.Status.INTERNAL_SERVER_ERROR.getStatusCode());
        }
        return asignacion;
    }

}
