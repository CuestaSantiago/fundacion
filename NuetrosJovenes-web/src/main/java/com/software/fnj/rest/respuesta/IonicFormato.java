/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.software.fnj.rest.respuesta;

import com.software.fnj.model.*;
import com.software.fnj.model.ionic.*;

/**
 *
 * @author mauro
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
}
