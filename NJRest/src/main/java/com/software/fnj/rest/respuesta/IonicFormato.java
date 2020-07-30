/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.software.fnj.rest.respuesta;

import com.software.fnj.modelo.*;
import com.software.fnj.modelo.ionic.*;

/**
 *
 * @author santiago
 */
public class IonicFormato {

    /**
     *
     * @param usuario
     * @return
     */
    public static UsuarioIonic ConstruirUsuarioIonic(Usuario usuario) {
        UsuarioIonic user = new UsuarioIonic();
        user.setIdusuario(usuario.getIdusuario());
        user.setNombres(usuario.getNombres());
        user.setApellidos(usuario.getApellidos());
        return user;
    }

    public static Usuario ConstruirUsuario(UsuarioIonic usuarioIonic) {
        Usuario user = new Usuario();
        user.setIdusuario(usuarioIonic.getIdusuario());
        user.setNombres(usuarioIonic.getNombres());
        user.setApellidos(usuarioIonic.getApellidos());
        return user;
    }

}
