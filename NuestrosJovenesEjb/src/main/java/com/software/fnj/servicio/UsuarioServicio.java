/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.software.fnj.servicio;

import com.software.fnj.facade.CiudadFacade;
import com.software.fnj.facade.DocumentoFacade;
import com.software.fnj.facade.GeneroFacade;
import com.software.fnj.facade.LugaringresoFacade;
import com.software.fnj.facade.NacionalidadFacade;
import com.software.fnj.facade.PaisFacade;
import com.software.fnj.facade.ParentescofamiliarFacade;
import com.software.fnj.facade.ParentescofamiliarusuarioFacade;
import com.software.fnj.facade.SaludFacade;
import com.software.fnj.facade.UsuarioFacade;
import com.software.fnj.model.Ionic.DocumentoIonic;
import com.software.fnj.model.Ionic.SaludIonic;
import com.software.fnj.model.Ionic.UsuarioNuevoIonic;
import com.software.fnj.modelo.Ciudad;
import com.software.fnj.modelo.Documento;
import com.software.fnj.modelo.Genero;
import com.software.fnj.modelo.Lugaringreso;
import com.software.fnj.modelo.Nacionalidad;
import com.software.fnj.modelo.Pais;
import com.software.fnj.modelo.Parentescofamiliarusuario;
import com.software.fnj.modelo.Salud;
import com.software.fnj.modelo.Usuario;
import com.software.fnj.response.exception.ServiceException;
import com.software.fnj.util.Constante;
import com.software.fnj.util.Constante.SaludConstante;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ws.rs.core.Response;

/**
 *
 * @author santiago
 */
@Stateless
@LocalBean
public class UsuarioServicio {

    private static final java.util.logging.Logger LOG = java.util.logging.Logger.getLogger(UsuarioServicio.class.getName());

    @EJB
    UsuarioFacade usuarioFacade;
    @EJB
    CiudadFacade ciudadFacade;
    @EJB
    PaisFacade paisFacade;
    @EJB
    GeneroFacade generoFacade;
    @EJB
    NacionalidadFacade nacionalidadFacade;
    @EJB
    LugaringresoFacade lugaringresoFacade;
    @EJB
    DocumentoFacade documentoFacade;
    @EJB
    ParentescofamiliarFacade parentescofamiliarFacade;
    @EJB
    ParentescofamiliarusuarioFacade parentescofamiliarusuarioFacade;
    @EJB
    SaludFacade saludFacade;

    /**
     * Method that carries out the edition of an event already created in the
     * database
     *
     * @param user is the complete event to be edited
     * @boolean return with the edit response
     */
    public boolean editarUsuario(Usuario user) throws ServiceException {
        Boolean edit = false;
        try {
            usuarioFacade.edit(user);
            edit = true;
            LOG.log(Level.SEVERE, "UsuarioServicio: User: " + user.getNombres() + " successfully edited");
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, "UsuarioServicio: Error editing user: " + user);
            LOG.log(Level.SEVERE, "", ex);
            throw new ServiceException("Se ha producido un error en el servidor", Response.Status.INTERNAL_SERVER_ERROR.getStatusCode());
        }
        return edit;
    }

    /**
     *
     * @param idUsuario
     * @return
     * @throws ServiceException
     */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public Usuario obtenerUsarioPorIdUsuario(int idUsuario) throws ServiceException {
        Usuario usuario = new Usuario();
        try {
            usuario = usuarioFacade.obtenerusuarioPorIdUusario(idUsuario);
        } catch (Exception e) {
            LOG.log(Level.SEVERE, "UsuarioServicio: Error al obtener usuario por id:" + idUsuario);
            LOG.log(Level.SEVERE, "", e);
            throw new ServiceException("Se ha producido un error en el servidor", Response.Status.INTERNAL_SERVER_ERROR.getStatusCode());
        }
        return usuario;
    }

    public boolean crearUsuario(Usuario usuario) throws ServiceException {
        boolean exito = false;
        try {
            if (usuarioFacade.verificarUsuarioRegistrado(usuario.getIdentificacion())) {
                usuarioFacade.create(usuario);
                exito = true;
            } else {
                LOG.log(Level.SEVERE, "UsuarioServicio: Usuario ya registrado: " + usuario.getNombres());
            }
        } catch (Exception e) {
            LOG.log(Level.SEVERE, "UsuarioServicio: Error al crear usuario usuario: " + usuario.getNombres());
            LOG.log(Level.SEVERE, "", e);
            throw new ServiceException("Se ha producido un error en el servidor", Response.Status.INTERNAL_SERVER_ERROR.getStatusCode());
        }
        return exito;
    }

    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<Ciudad> obtenerCiudades(String paisCodigo) throws ServiceException {
        List<Ciudad> ciudades = new ArrayList();
        try {
            ciudades = ciudadFacade.obtenerCiudadesPorCodigoPais(paisCodigo);
        } catch (Exception e) {
            LOG.log(Level.SEVERE, "UsuarioServicio: Error al obtener ciudades");
            LOG.log(Level.SEVERE, "", e);
            throw new ServiceException("Se ha producido un error en el servidor", Response.Status.INTERNAL_SERVER_ERROR.getStatusCode());
        }
        return ciudades;
    }

    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<Pais> obtenerPaises() throws ServiceException {
        List<Pais> paises = new ArrayList();
        try {
            paises = paisFacade.findAll();
        } catch (Exception e) {
            LOG.log(Level.SEVERE, "UsuarioServicio: Error al obtener ciudades");
            LOG.log(Level.SEVERE, "", e);
            throw new ServiceException("Se ha producido un error en el servidor", Response.Status.INTERNAL_SERVER_ERROR.getStatusCode());
        }
        return paises;
    }

    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<Genero> obtenerGeneros() throws ServiceException {
        List<Genero> generos = new ArrayList();
        try {
            generos = generoFacade.findAll();
        } catch (Exception e) {
            LOG.log(Level.SEVERE, "UsuarioServicio: Error al obtener ciudades");
            LOG.log(Level.SEVERE, "", e);
            throw new ServiceException("Se ha producido un error en el servidor", Response.Status.INTERNAL_SERVER_ERROR.getStatusCode());
        }
        return generos;
    }

    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<Nacionalidad> obtenernacionalidades() throws ServiceException {
        List<Nacionalidad> nacionalidad = new ArrayList();
        try {
            nacionalidad = nacionalidadFacade.findAll();
        } catch (Exception e) {
            LOG.log(Level.SEVERE, "UsuarioServicio: Error al obtener ciudades");
            LOG.log(Level.SEVERE, "", e);
            throw new ServiceException("Se ha producido un error en el servidor", Response.Status.INTERNAL_SERVER_ERROR.getStatusCode());
        }
        return nacionalidad;
    }

    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<Lugaringreso> obtenernLugarIngreso() throws ServiceException {
        List<Lugaringreso> nacionalidad = new ArrayList();
        try {
            nacionalidad = lugaringresoFacade.findAll();
        } catch (Exception e) {
            LOG.log(Level.SEVERE, "UsuarioServicio: Error al obtener Lugares de ingreso");
            LOG.log(Level.SEVERE, "", e);
            throw new ServiceException("Se ha producido un error en el servidor", Response.Status.INTERNAL_SERVER_ERROR.getStatusCode());
        }
        return nacionalidad;
    }

    public boolean agregarDocumento(DocumentoIonic docUsuario) throws ServiceException {
        boolean exito = false;
        Usuario usuario = new Usuario();
        Documento documento = new Documento();
        try {
            usuario = usuarioFacade.obtenerusuarioPorIdUusario(docUsuario.getIdUsuario());
            if (usuario != null) {
                documento.setDocumento(docUsuario.getDocumento().getBytes());
                documento.setIdusuario(usuario);
                documento.setObservacion(docUsuario.getObservacion());
                documentoFacade.create(documento);
                exito = true;
            } else {
                LOG.log(Level.SEVERE, "UsuarioServicio: Usuario ya registrado: " + docUsuario.getIdUsuario());
            }
        } catch (Exception e) {
            LOG.log(Level.SEVERE, "UsuarioServicio: Error al crear usuario usuario: " + docUsuario.getIdUsuario());
            LOG.log(Level.SEVERE, "", e);
            throw new ServiceException("Se ha producido un error en el servidor", Response.Status.INTERNAL_SERVER_ERROR.getStatusCode());
        }
        return exito;
    }

    public boolean agregarUsuarios(List<UsuarioNuevoIonic> newUsuario) throws ServiceException {
        boolean exito = false;
        Usuario usuario = new Usuario();
        Parentescofamiliarusuario parentesco = new Parentescofamiliarusuario();
        int idCabezaHogar = 0;
        try {
            for (UsuarioNuevoIonic usuarioNuevoIonic : newUsuario) {
                if (newUsuario.size() > 1) {
                    usuario = agrearUsaurio(usuarioNuevoIonic);
                    if (newUsuario.size() == 0) {
                        idCabezaHogar = usuario.getIdusuario();
                    }
                    parentesco.setIdusuario(usuario);
                    parentesco.setIdusuarioCabezaHogar(usuario.getIdusuario());
                    parentesco.setIdparentescoFamiliar(parentescofamiliarFacade.find(usuarioNuevoIonic.getIdParentesco()));
                    parentesco.setIdusuarioCabezaHogar(idCabezaHogar);
                    llenarDocumentos(usuarioNuevoIonic, usuario);
                    parentescofamiliarusuarioFacade.create(parentesco);
                } else {
                    usuario = agrearUsaurio(usuarioNuevoIonic);
                    parentesco.setIdusuario(usuario);
                    parentesco.setIdusuarioCabezaHogar(usuario.getIdusuario());
                    parentesco.setIdparentescoFamiliar(parentescofamiliarFacade.find(usuarioNuevoIonic.getIdParentesco()));
                    parentesco.setIdusuarioCabezaHogar(usuario.getIdusuario());
                    llenarDocumentos(usuarioNuevoIonic, usuario);
                    parentescofamiliarusuarioFacade.create(parentesco);
                }
            }
            exito = true;
        } catch (Exception e) {
            LOG.log(Level.SEVERE, "UsuarioServicio: Error al crear usuario usuario");
            LOG.log(Level.SEVERE, "", e);
            throw new ServiceException("Se ha producido un error en el servidor", Response.Status.INTERNAL_SERVER_ERROR.getStatusCode());
        }
        return exito;
    }

    private Usuario agrearUsaurio(UsuarioNuevoIonic newUsuario) throws ServiceException {
        Usuario usuario = new Usuario();
        Genero genero = new Genero();
        Ciudad ciudad = new Ciudad();
        Pais pais = new Pais();
        Nacionalidad nacionaliad = new Nacionalidad();
        Lugaringreso lugarIngreso = new Lugaringreso();
        try {
            if (usuarioFacade.verificarUsuarioRegistrado(newUsuario.getIdentificacion())) {
                genero = generoFacade.obtenerGeneroPorId(newUsuario.getIdgenero());
                ciudad = ciudadFacade.obtenerCiudadPorId(newUsuario.getIdciudad());
                pais = paisFacade.obtenerPaisPorId(newUsuario.getIdpais());
                nacionaliad = nacionalidadFacade.obtenerNaionalidadPorId(newUsuario.getIdnacionalidad());
                if (lugaringresoFacade.verificarLugarIngreso(newUsuario.getLugarIngreso())) {
                    lugarIngreso.setNombre(newUsuario.getLugarIngreso());
                    lugaringresoFacade.create(lugarIngreso);
                } else {
                    lugarIngreso = lugaringresoFacade.obtenerLugarIngresoPorId(newUsuario.getLugarIngreso());
                }
                usuario.setApellidos(newUsuario.getApellidos());
                usuario.setEstado(Constante.UsuarioConstante.ACTIVO.getUsuarioConstanteId());
                usuario.setFechaEgresoFundacion(newUsuario.getFechaEgresoFundacion());
                usuario.setFechaIngresoEcuador(newUsuario.getFechaIngresoEcuador());
                usuario.setFechaIngresoFundacion(newUsuario.getFechaIngresoFundacion());
                usuario.setFechaNacimiento(newUsuario.getFechaNacimiento());
                usuario.setFoto(newUsuario.getFoto());
                usuario.setHabilidades(newUsuario.getHabilidades());
                usuario.setIdentificacion(newUsuario.getIdentificacion());
                usuario.setNivelInstruccion(newUsuario.getNivelInstruccion());
                usuario.setNombres(newUsuario.getNombres());
                usuario.setOficio(newUsuario.getOficio());
                usuario.setProfesion(newUsuario.getProfesion());
                usuario.setProvincia(newUsuario.getProvincia());
                usuario.setRazonEgreso(newUsuario.getRazonEgreso());
                usuario.setSituacionMigratoria(newUsuario.getSituacionMigratoria());
                usuario.setIdRegistrador(newUsuario.getIdRegistrador());
                usuario.setTelefono(newUsuario.getTelefono());
                usuario.setTelefonoContacto(newUsuario.getTelefonoContacto());
                usuario.setTipoIdentificacion(newUsuario.getTipoIdentificacion());
                usuario.setObservacionIngreso(newUsuario.getObservacionIngreso());
                usuario.setIdciudad(ciudad);
                usuario.setIdgenero(genero);
                usuario.setIdlugarIngreso(lugarIngreso);
                usuario.setIdnacionalidad(nacionaliad);
                usuario.setIdpais(pais);
                
                usuarioFacade.create(usuario);
            } else {
                throw new ServiceException("Usuario ya registrado", Response.Status.NOT_FOUND.getStatusCode());
            }
        } catch (Exception e) {
            LOG.log(Level.SEVERE, "UsuarioServicio: Error al crear usuario usuario");
            LOG.log(Level.SEVERE, "", e);
            throw new ServiceException("Se ha producido un error en el servidor", Response.Status.INTERNAL_SERVER_ERROR.getStatusCode());
        }

        return usuario;
    }

    private void llenarDocumentos(UsuarioNuevoIonic newUsuario, Usuario usuario) {
        if (newUsuario.getDocumento() != null) {
            for (DocumentoIonic object : newUsuario.getDocumento()) {
                Documento doc = new Documento();
                doc.setDocumento(object.getDocumento().getBytes());
                doc.setIdusuario(usuario);
                doc.setObservacion(object.getObservacion());
                documentoFacade.create(doc);
            }
        }
        if (newUsuario.getSalud() != null) {
            for (SaludIonic object : newUsuario.getSalud()) {
                Salud salud = new Salud();
                salud.setFoto(object.getFoto().getBytes());
                salud.setIdusuario(usuario);
                salud.setEstadoDiscapacidad(object.getEstadoDiscapacidad());
                saludFacade.create(salud);
            }
        } else {
            Salud salud = new Salud();
            salud.setCondicionMedica("No se registro ninguna condición medica");
            salud.setEstadoDiscapacidad(SaludConstante.SALUDABLE.getSaludConstanteId());
            salud.setIdusuario(usuario);
            saludFacade.create(salud);
        }
    }

}
