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
        Ciudad ciudad = new Ciudad();
        Genero genero = new Genero();
        Lugaringreso lugarIngreso = new Lugaringreso();
        Nacionalidad nacionalidad = new Nacionalidad();
        Pais pais = new Pais();
        
        ciudad.setIdciudad(usuarioIonic.getIdciudad());
        genero.setIdgenero(usuarioIonic.getIdgenero());
        lugarIngreso.setIdlugarIngreso(usuarioIonic.getIdlugarIngreso());
        nacionalidad.setIdnacionalidad(usuarioIonic.getIdgenero());
        pais.setIdpais(usuarioIonic.getIdpais());
        
        user.setNombres(usuarioIonic.getNombres());
        user.setApellidos(usuarioIonic.getApellidos());
        user.setIdentificacion(usuarioIonic.getIdentificacion());
        user.setEstado(1);
        user.setIdciudad(ciudad);
        user.setIdgenero(genero);
        user.setIdlugarIngreso(lugarIngreso);
        user.setIdnacionalidad(nacionalidad);
        user.setIdpais(pais);
        return user;
    }

}
