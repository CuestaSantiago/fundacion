/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.software.fnj.rest.respuesta;

import com.software.fnj.model.Usuario;
import com.software.fnj.model.ionic.UsuarioIonic;
import com.software.fnj.response.exception.ServiceException;
import com.software.fnj.rest.wsresponse.WsResponse;
import com.software.fnj.servicio.UsuarioServicio;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 *
 * @author santiago
 */
@Stateless
@LocalBean
public class ServicioRestAcceso {

    
    @EJB
    UsuarioServicio usuarioServicio;

    public WsResponse getAllUsers() throws ServiceException{
        WsResponse respuesta = new WsResponse();
        List<UsuarioIonic> usuariosIonic = new ArrayList();
        List<Usuario> usuarios = new ArrayList();
        usuarios = usuarioServicio.getAllUsers();
        if (usuarios.size() >0 || usuarios != null) {
            for (Usuario usuario : usuarios) {
                usuariosIonic.add(IonicFormato.buildUserMobileData(usuario));
            }
            respuesta.setContent(usuariosIonic);
            respuesta.setSuccess(Boolean.TRUE);
        }
        return respuesta;
    }

}
