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
import com.software.fnj.modelo.ionic.AutoIonic;
import com.software.fnj.modelo.ionic.UsuarioIonic;
import com.software.fnj.response.exception.ServiceException;
import com.software.fnj.servicio.DocumentoServicio;
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
public class ServicioRestUsuarioRecurso {

    @EJB
    ParentescoFamiliarUsuarioServicio usuarioServicio;
    @EJB
    SaludServicio saludServicio;
    @EJB
    DocumentoServicio documentoServicio;

    public List<UsuarioIonic> getAllUsers() throws ServiceException {
        List<UsuarioIonic> usuariosIonic = new ArrayList();
        List<Parentescofamiliarusuario> usuarios = new ArrayList();
        usuarios = usuarioServicio.obtenerUsuariosActivos();
        if (usuarios.size() > 0 || usuarios != null) {
            for (Parentescofamiliarusuario usuario : usuarios) {
                Salud salud = new Salud();
                Documento documento = new Documento();
                salud = saludServicio.obtenerSaludPorUsuario(usuario.getIdusuario());
                documento = documentoServicio.obtenerDocumentoPorUsuario(usuario.getIdusuario());
                usuariosIonic.add(IonicFormato.ConstruirUsuarioIonic(usuario,salud,documento));
            }
        } else {
            throw new ServiceException("No se ha podido encontrar clientes por el momento", Response.Status.INTERNAL_SERVER_ERROR.getStatusCode());
        }
        return usuariosIonic;
    }

}
