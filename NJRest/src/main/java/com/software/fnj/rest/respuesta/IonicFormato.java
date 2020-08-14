/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.software.fnj.rest.respuesta;

import com.software.fnj.modelo.Nacionalidad;
import com.software.fnj.modelo.Genero;
import com.software.fnj.modelo.Documento;
import com.software.fnj.modelo.Parentescofamiliarusuario;
import com.software.fnj.modelo.Lugaringreso;
import com.software.fnj.model.Ionic.UsuarioIonic;
import com.software.fnj.modelo.Pais;
import com.software.fnj.modelo.Ciudad;
import com.software.fnj.modelo.Salud;
import com.software.fnj.modelo.Usuario;
import com.software.fnj.modelo.*;
import java.util.List;

/**
 *
 * @author santiago
 */
public class IonicFormato {

    /**
     *
     * @param usuario
     * @param salud
     * @param documento
     * @return
     */
    public static UsuarioIonic ConstruirUsuarioIonic(Parentescofamiliarusuario usuario, List<Salud> salud, List<Documento> documento) {
        UsuarioIonic user = new UsuarioIonic();
        usuario.getIdusuario().getIdgenero().setUsuarioCollection(null);
        usuario.getIdusuario().getIdciudad().setUsuarioCollection(null);
        for (Documento doc : documento) {
            doc.setIdusuario(null);
        }
        for (Salud sal : salud) {
            sal.setIdusuario(null);
        }
        //usuario.getIdusuario().getIdlugarIngreso().setUsuarioCollection(null);

        user.setIdusuario(usuario.getIdusuario().getIdusuario());
        user.setNombres(usuario.getIdusuario().getNombres());
        user.setApellidos(usuario.getIdusuario().getApellidos());
        user.setIdentificacion(usuario.getIdusuario().getIdentificacion());
        user.setFoto(usuario.getIdusuario().getFoto());
        user.setIdgenero(usuario.getIdusuario().getIdgenero());
        user.setIdciudad(usuario.getIdusuario().getIdciudad());
        user.setDocumento(documento);
        user.setSalud(salud);
        return user;
    }

    public static Usuario ConstruirUsuario(UsuarioIonic usuarioIonic) {
        Usuario user = new Usuario();
        Ciudad ciudad = new Ciudad();
        Genero genero = new Genero();
        Lugaringreso lugarIngreso = new Lugaringreso();
        Nacionalidad nacionalidad = new Nacionalidad();
        Pais pais = new Pais();

//        ciudad.setIdciudad(usuarioIonic.getIdciudad());
//        genero.setIdgenero(usuarioIonic.getIdgenero());
//        lugarIngreso.setIdlugarIngreso(usuarioIonic.getIdlugarIngreso());
//        nacionalidad.setIdnacionalidad(usuarioIonic.getIdgenero());
//        pais.setIdpais(usuarioIonic.getIdpais());
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
