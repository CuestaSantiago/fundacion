/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.software.fnj.rest.respuesta;

import com.software.fnj.model.Ionic.DocumentoIonic;
import com.software.fnj.model.Ionic.SaludIonic;
import com.software.fnj.modelo.Documento;
import com.software.fnj.modelo.Parentescofamiliarusuario;
import com.software.fnj.modelo.Salud;
import com.software.fnj.model.Ionic.UsuarioIonic;
import com.software.fnj.model.Ionic.UsuarioNuevoIonic;
import com.software.fnj.modelo.Ciudad;
import com.software.fnj.modelo.Genero;
import com.software.fnj.modelo.Lugaringreso;
import com.software.fnj.modelo.Nacionalidad;
import com.software.fnj.modelo.Pais;
import com.software.fnj.modelo.Parentescofamiliar;
import com.software.fnj.response.exception.ServiceException;
import com.software.fnj.servicio.DocumentoServicio;
import com.software.fnj.servicio.ParentescoFamiliarUsuarioServicio;
import com.software.fnj.servicio.SaludServicio;
import com.software.fnj.servicio.UsuarioServicio;
import java.io.UnsupportedEncodingException;
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

    public List<UsuarioIonic> getAllUsers() throws ServiceException, UnsupportedEncodingException {
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
            for (Ciudad ciu : ciudades) {
                ciu.setUsuarioList(null);
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
                pais.setUsuarioList(null);
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
                genero.setUsuarioList(null);
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
                nacionalidad.setUsuarioList(null);
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
                lugaringres.setUsuarioList(null);
            }
        } else {
            throw new ServiceException("No se ha podido encontrar nacionalidades por el momento", Response.Status.INTERNAL_SERVER_ERROR.getStatusCode());
        }
        return lugaringresos;
    }

    public Boolean agregarDocumento(DocumentoIonic documento) throws ServiceException {
        boolean agregado = false;
        if (documento != null) {
            agregado = usuarioServicio.agregarDocumento(documento);
        } else {
            throw new ServiceException("No se ha podido encontrar nacionalidades por el momento", Response.Status.INTERNAL_SERVER_ERROR.getStatusCode());
        }
        return agregado;
    }

    public Boolean agregarUsuarios(List<UsuarioNuevoIonic> newUsuario) throws ServiceException {
        boolean lugaringresos = false;
        if (newUsuario != null) {
            lugaringresos = usuarioServicio.agregarUsuarios(newUsuario);
        } else {
            throw new ServiceException("No se ha podido encontrar nacionalidades por el momento", Response.Status.INTERNAL_SERVER_ERROR.getStatusCode());
        }
        return lugaringresos;
    }

    public List<Parentescofamiliar> obtenerParentescos() throws ServiceException {
        List<Parentescofamiliar> parentescos = new ArrayList();
        parentescos = parentescoFamiliarUsuarioServicio.obtenerParentescos();
        if (parentescos.size() > 0 || parentescos != null) {
            for (Parentescofamiliar parentesco : parentescos) {
                parentesco.setParentescofamiliarusuarioList(null);
            }
            parentescos.remove(0);
        } else {
            throw new ServiceException("No se ha podido encontrar usuarios por el momento", Response.Status.INTERNAL_SERVER_ERROR.getStatusCode());
        }
        return parentescos;
    }

    public List<UsuarioIonic> obenerTodosLosUsuarios() throws ServiceException, UnsupportedEncodingException {
        List<UsuarioIonic> usuariosIonic = new ArrayList();
        List<Parentescofamiliarusuario> usuarios = new ArrayList();
        usuarios = parentescoFamiliarUsuarioServicio.obenerTodosLosUsuarios();
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

    public boolean editarUsuario(UsuarioNuevoIonic newUsuario) throws ServiceException {
        boolean lugaringresos = false;
        if (newUsuario != null) {
            lugaringresos = usuarioServicio.editarUsuario(newUsuario);
        } else {
            throw new ServiceException("No se ha podido editar usuario", Response.Status.INTERNAL_SERVER_ERROR.getStatusCode());
        }
        return lugaringresos;
    }

    public boolean activarUsuario(UsuarioNuevoIonic newUsuario) throws ServiceException {
        boolean lugaringresos = false;
        if (newUsuario != null) {
            lugaringresos = usuarioServicio.activarUsuario(newUsuario);
        } else {
            throw new ServiceException("No se ha podido editar usuario", Response.Status.INTERNAL_SERVER_ERROR.getStatusCode());
        }
        return lugaringresos;
    }

    public List<Salud> obtenerEstadosSalud() throws ServiceException, UnsupportedEncodingException {

        List<Salud> salud = new ArrayList();
        salud = saludServicio.obtenerEstadosSalud();
        if (salud.size() > 0 || salud != null) {
            return salud;
        } else {
            throw new ServiceException("No se ha podido encontrar usuarios por el momento", Response.Status.INTERNAL_SERVER_ERROR.getStatusCode());
        }

    }

    public boolean desactivarUsuario(DocumentoIonic newUsuario) throws ServiceException {
        boolean lugaringresos = false;
        if (newUsuario != null) {
            lugaringresos = usuarioServicio.desactivarUsuario(newUsuario);
        } else {
            throw new ServiceException("No se ha podido editar usuario", Response.Status.INTERNAL_SERVER_ERROR.getStatusCode());
        }
        return lugaringresos;
    }

    public boolean eliminarSalud(SaludIonic idSalud) throws ServiceException {
        boolean exito = false;
        exito = saludServicio.eliminarSalud(idSalud);
        if (exito) {
            return exito;
        } else {
            throw new ServiceException("No se ha podido editar usuario", Response.Status.INTERNAL_SERVER_ERROR.getStatusCode());
        }
    }

    public List<UsuarioIonic> obtenerUsariosInactivos() throws ServiceException, UnsupportedEncodingException {
        List<UsuarioIonic> usuariosIonic = new ArrayList();
        List<Parentescofamiliarusuario> usuarios = new ArrayList();
        usuarios = parentescoFamiliarUsuarioServicio.obtenerUsuariosInactivos();
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
}
