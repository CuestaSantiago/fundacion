/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.software.fnj.rest.respuesta;

import com.software.fnj.modelo.Documento;
import com.software.fnj.modelo.Parentescofamiliarusuario;
import com.software.fnj.modelo.Salud;
import com.software.fnj.modelo.Usuario;
import com.software.fnj.model.Ionic.AutoIonic;
import com.software.fnj.model.Ionic.UsuarioIonic;
import com.software.fnj.response.exception.ServiceException;
import com.software.fnj.servicio.ParentescoFamiliarUsuarioServicio;
import com.software.fnj.servicio.SaludServicio;
import com.software.fnj.servicio.UsuarioServicio;
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
public class ServicioRestAcceso {

    @EJB
    UsuarioServicio usuarioServicio;
//
//    public List<UsuarioIonic> getAllUsers() throws ServiceException {
//        List<UsuarioIonic> usuariosIonic = new ArrayList();
//        List<Usuario> usuarios = new ArrayList();
//        usuarios = usuarioServicio.obtenerUsuariosActivos();
//        if (usuarios.size() > 0 || usuarios != null) {
//            for (Usuario usuario : usuarios) {
//                //usuariosIonic.add(IonicFormato.ConstruirUsuarioIonic(usuario));
//            }
//        } else {
//            throw new ServiceException("No se ha podido encontrar clientes por el momento", Response.Status.INTERNAL_SERVER_ERROR.getStatusCode());
//        }
//        return usuariosIonic;
//    }

    public boolean crearUsuario(UsuarioIonic usuarioIonic) throws ServiceException {
        Boolean exito = false;
        Usuario usuario = new Usuario();
        if (usuarioIonic != null) {
            usuario = IonicFormato.ConstruirUsuario(usuarioIonic);
            exito = usuarioServicio.crearUsuario(usuario);
        }else {
            throw new ServiceException("No se ha podido encontrar clientes por el momento", Response.Status.INTERNAL_SERVER_ERROR.getStatusCode());
        }
        return exito;
    }

    public boolean modificarUsuario(UsuarioIonic usuarioIonic) throws ServiceException {
        Boolean exito = false;
        Usuario usuario = new Usuario();
        if (usuarioIonic != null) {
            usuario = IonicFormato.ConstruirUsuario(usuarioIonic);
            exito = usuarioServicio.editarUsuario(usuario);
        }else {
            throw new ServiceException("No se ha podido encontrar clientes por el momento", Response.Status.INTERNAL_SERVER_ERROR.getStatusCode());
        }
        return exito;
    }

}
