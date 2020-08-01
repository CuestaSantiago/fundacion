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
import com.software.fnj.modelo.Ciudad;
import com.software.fnj.modelo.Genero;
import com.software.fnj.modelo.Lugaringreso;
import com.software.fnj.modelo.Nacionalidad;
import com.software.fnj.modelo.Pais;
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
    ParentescoFamiliarUsuarioServicio parentescoFamiliarUsuarioServicio;
    @EJB
    UsuarioServicio usuarioServicio;
    @EJB
    SaludServicio saludServicio;
    @EJB
    DocumentoServicio documentoServicio;

    public List<UsuarioIonic> getAllUsers() throws ServiceException {
        List<UsuarioIonic> usuariosIonic = new ArrayList();
        List<Parentescofamiliarusuario> usuarios = new ArrayList();
        usuarios = parentescoFamiliarUsuarioServicio.obtenerUsuariosActivos();
        if (usuarios.size() > 0 || usuarios != null) {
            for (Parentescofamiliarusuario usuario : usuarios) {
                List<Salud> salud = new ArrayList();
                List<Documento> documento = new ArrayList();
                salud = saludServicio.obtenerSaludPorUsuario(usuario.getIdusuario());
                documento = documentoServicio.obtenerDocumentoPorUsuario(usuario.getIdusuario());
                usuariosIonic.add(IonicFormato.ConstruirUsuarioIonic(usuario, salud, documento));
            }
        } else {
            throw new ServiceException("No se ha podido encontrar usuarios por el momento", Response.Status.INTERNAL_SERVER_ERROR.getStatusCode());
        }
        return usuariosIonic;
    }

    public List<Ciudad> obtenerCiudades() throws ServiceException {
        List<Ciudad> ciudades = new ArrayList();
        ciudades = usuarioServicio.obtenerCiudades();
        if (ciudades.size() > 0 || ciudades != null) {
            for (Ciudad ciudad : ciudades) {
                ciudad.setUsuarioCollection(null);
            }
        } else {
            throw new ServiceException("No se ha podido encontrar ciudades por el momento", Response.Status.INTERNAL_SERVER_ERROR.getStatusCode());
        }
        return ciudades;
    }

    public List<Pais> obtenerPaises() throws ServiceException {
        List<Pais> paises = new ArrayList();
        paises = usuarioServicio.obtenerPaises();
        if (paises.size() > 0 || paises != null) {
            for (Pais pais : paises) {
                pais.setUsuarioCollection(null);
            }
        } else {
            throw new ServiceException("No se ha podido encontrar paises por el momento", Response.Status.INTERNAL_SERVER_ERROR.getStatusCode());
        }
        return paises;
    }

    public List<Genero> obtenerGeneros() throws ServiceException {
        List<Genero> generos = new ArrayList();
        generos = usuarioServicio.obtenerGeneros();
        if (generos.size() > 0 || generos != null) {
            for (Genero genero : generos) {
                genero.setUsuarioCollection(null);
            }
        } else {
            throw new ServiceException("No se ha podido encontrar generos por el momento", Response.Status.INTERNAL_SERVER_ERROR.getStatusCode());
        }
        return generos;
    }

    public List<Nacionalidad> obtenerNacionalidades() throws ServiceException {
        List<Nacionalidad> nacionalidades = new ArrayList();
        nacionalidades = usuarioServicio.obtenernacionalidades();
        if (nacionalidades.size() > 0 || nacionalidades != null) {
            for (Nacionalidad nacionalidad : nacionalidades) {
                nacionalidad.setUsuarioCollection(null);
            }
        } else {
            throw new ServiceException("No se ha podido encontrar nacionalidades por el momento", Response.Status.INTERNAL_SERVER_ERROR.getStatusCode());
        }
        return nacionalidades;
    }
    
    public List<Lugaringreso> obtenernLugarIngreso() throws ServiceException {
        List<Lugaringreso> lugaringresos = new ArrayList();
        lugaringresos = usuarioServicio.obtenernLugarIngreso();
        if (lugaringresos.size() > 0 || lugaringresos != null) {
            for (Lugaringreso lugaringres : lugaringresos) {
                lugaringres.setUsuarioCollection(null);
            }
        } else {
            throw new ServiceException("No se ha podido encontrar nacionalidades por el momento", Response.Status.INTERNAL_SERVER_ERROR.getStatusCode());
        }
        return lugaringresos;
    }

}
