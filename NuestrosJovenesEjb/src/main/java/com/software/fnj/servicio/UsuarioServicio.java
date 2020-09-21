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
import com.software.fnj.util.Constante.UsuarioConstante;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Calendar;
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
    @EJB
    SaludServicio saludServicio;
    @EJB
    DocumentoServicio documentoServicio;

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

    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<Ciudad> obtenerCiudades() throws ServiceException {
        List<Ciudad> ciudades = new ArrayList();
        try {
            ciudades = ciudadFacade.findAll();
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
                if (docUsuario.getDocumento() != null) {
                    byte[] foto = Base64.getEncoder().encode(docUsuario.getDocumento().getBytes());
                    documento.setDocumento(foto);
                }
                documento.setIdusuario(usuario);
                documento.setTipoDocumento("pdf");
                documento.setObservacion(docUsuario.getObservacion());
                if (docUsuario.isViolencia()) {
                    short esViolencia = 1;
                    documento.setEstado(esViolencia);
                } else {
                    short noEsViolencia = 0;
                    documento.setEstado(noEsViolencia);
                }
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
        boolean confirmado = false;
        int idCabezaHogar = 0;
        int contador = 0;
        try {
            for (UsuarioNuevoIonic usuarioNuevoIonic : newUsuario) {
                if (usuarioFacade.verificarUsuarioRegistrado(usuarioNuevoIonic.getIdentificacion())) {
                    confirmado = true;
                } else {
                    throw new ServiceException("Usuario ya registrado", Response.Status.NOT_FOUND.getStatusCode());
                }
            }
            if (confirmado) {
                for (UsuarioNuevoIonic usuarioNuevoIonic : newUsuario) {
                    Usuario usuario = new Usuario();
                    Parentescofamiliarusuario parentesco = new Parentescofamiliarusuario();
                    if (newUsuario.size() > 1) {
                        usuario = agrearUsaurio(usuarioNuevoIonic);
                        if (contador == 0) {
                            idCabezaHogar = usuario.getIdusuario();
                        }
                        parentesco.setIdusuario(usuario);
                        parentesco.setIdparentescoFamiliar(parentescofamiliarFacade.find(usuarioNuevoIonic.getIdParentesco()));
                        parentesco.setIdusuarioCabezaHogar(idCabezaHogar);
                        llenarDocumentoSalud(usuarioNuevoIonic, usuario);
                        parentescofamiliarusuarioFacade.create(parentesco);
                        contador++;
                    } else {
                        usuario = agrearUsaurio(usuarioNuevoIonic);
                        parentesco.setIdusuario(usuario);
                        parentesco.setIdparentescoFamiliar(parentescofamiliarFacade.find(usuarioNuevoIonic.getIdParentesco()));
                        parentesco.setIdusuarioCabezaHogar(usuario.getIdusuario());
                        llenarDocumentoSalud(usuarioNuevoIonic, usuario);
                        parentescofamiliarusuarioFacade.create(parentesco);
                    }
                }
            } else {
                throw new ServiceException("Usuario ya registrado", Response.Status.NOT_FOUND.getStatusCode());
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
                if (ciudadFacade.obtenerCiudadPorId(newUsuario.getIdciudad())) {
                    ciudad.setCiudad(newUsuario.getIdciudad());
                    ciudadFacade.create(ciudad);
                } else {
                    ciudad = ciudadFacade.obtenerCiudadesPorCiudad(newUsuario.getIdciudad());
                }
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

                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                if (newUsuario.getFechaEgresoFundacion() != null) {
                    Date fechaEgreso = sdf.parse(newUsuario.getFechaEgresoFundacion());
                    usuario.setFechaEgresoFundacion(fechaEgreso);
                }
                Date fechaIngreso = sdf.parse(newUsuario.getFechaIngresoEcuador());
                usuario.setFechaIngresoEcuador(fechaIngreso);
                Date fechaIngresoFundacion = sdf.parse(newUsuario.getFechaIngresoFundacion());
                usuario.setFechaIngresoFundacion(fechaIngresoFundacion);
                Date fechaNacimiento = sdf.parse(newUsuario.getFechaNacimiento());
                usuario.setFechaNacimiento(fechaNacimiento);

                if (newUsuario.getFoto() != null) {
                    byte[] foto = Base64.getEncoder().encode(newUsuario.getFoto().getBytes());
                    usuario.setFoto(foto);
                }
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

    private void llenarDocumentoSalud(UsuarioNuevoIonic newUsuario, Usuario usuario) {
        if (newUsuario.getDocumento() != null) {
            for (DocumentoIonic object : newUsuario.getDocumento()) {
                Documento doc = new Documento();
                if (object.getDocumento() != null) {
                    byte[] document = Base64.getEncoder().encode(object.getDocumento().getBytes());
                    doc.setDocumento(document);
                }
                doc.setIdusuario(usuario);
                doc.setObservacion(object.getObservacion());
                documentoFacade.create(doc);
            }
        }
        if (newUsuario.getSalud() != null) {
            for (SaludIonic object : newUsuario.getSalud()) {
                Salud salud = new Salud();
                if (object.getFoto() != null) {
                    byte[] foto = Base64.getEncoder().encode(object.getFoto().getBytes());
                    salud.setFoto(foto);
                }
                salud.setIdusuario(usuario);
                salud.setEstadoDiscapacidad(object.getEstadoDiscapacidad());
                salud.setCondicionMedica(object.getCondicionMedica());
                saludFacade.create(salud);
            }
        }
    }

    public boolean editarUsuario(UsuarioNuevoIonic newUsuario) throws ServiceException {
        boolean exito = false;
        Usuario usuario = new Usuario();
        try {
            usuario = llenarUsuario(newUsuario);
            if (usuario != null) {
                if (newUsuario.getSalud() != null) {
                    for (SaludIonic saludIonic : newUsuario.getSalud()) {
                        Salud salud = new Salud();
                        if (saludIonic.getIdSalud() == null) {
                            if (saludIonic.getFoto() != null) {
                                byte[] foto = Base64.getEncoder().encode(saludIonic.getFoto().getBytes());
                                salud.setFoto(foto);
                            }
                            salud.setIdusuario(usuario);
                            salud.setEstadoDiscapacidad(saludIonic.getEstadoDiscapacidad());
                            salud.setCondicionMedica(saludIonic.getCondicionMedica());
                            saludFacade.create(salud);
                        } else {
                            salud = saludFacade.obtenerSaludPorIdSalud(saludIonic.getIdSalud());
                            if (saludIonic.getFoto() != null) {
                                byte[] foto = Base64.getEncoder().encode(saludIonic.getFoto().getBytes());
                                salud.setFoto(foto);
                            }
                            salud.setIdusuario(usuario);
                            salud.setEstadoDiscapacidad(saludIonic.getEstadoDiscapacidad());
                            salud.setCondicionMedica(saludIonic.getCondicionMedica());
                            saludFacade.edit(salud);
                        }
                    }
                }
                usuarioFacade.edit(usuario);
                exito = true;
            }
        } catch (Exception e) {
            LOG.log(Level.SEVERE, "UsuarioServicio: Error al crear usuario usuario");
            LOG.log(Level.SEVERE, "", e);
            throw new ServiceException("Se ha producido un error en el servidor", Response.Status.INTERNAL_SERVER_ERROR.getStatusCode());
        }
        return exito;
    }

    private Usuario llenarUsuario(UsuarioNuevoIonic newUsuario) throws ServiceException {
        Usuario usuario = new Usuario();
        Genero genero = new Genero();
        Ciudad ciudad = new Ciudad();
        Pais pais = new Pais();
        Nacionalidad nacionaliad = new Nacionalidad();
        Lugaringreso lugarIngreso = new Lugaringreso();
        try {
            genero = generoFacade.obtenerGeneroPorId(newUsuario.getIdgenero());
            if (ciudadFacade.obtenerCiudadPorId(newUsuario.getIdciudad())) {
                ciudad.setCiudad(newUsuario.getIdciudad());
                ciudadFacade.create(ciudad);
            } else {
                ciudad = ciudadFacade.obtenerCiudadesPorCiudad(newUsuario.getIdciudad());
            }
            pais = paisFacade.obtenerPaisPorId(newUsuario.getIdpais());
            nacionaliad = nacionalidadFacade.obtenerNaionalidadPorId(newUsuario.getIdnacionalidad());
            if (lugaringresoFacade.verificarLugarIngreso(newUsuario.getLugarIngreso())) {
                lugarIngreso.setNombre(newUsuario.getLugarIngreso());
                lugaringresoFacade.create(lugarIngreso);
            } else {
                lugarIngreso = lugaringresoFacade.obtenerLugarIngresoPorId(newUsuario.getLugarIngreso());
            }
            usuario.setIdusuario(newUsuario.getIdusuario());
            usuario.setApellidos(newUsuario.getApellidos());
            usuario.setEstado(Constante.UsuarioConstante.ACTIVO.getUsuarioConstanteId());

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            if (newUsuario.getFechaEgresoFundacion() != null) {
                Date fechaEgreso = sdf.parse(newUsuario.getFechaEgresoFundacion());
                usuario.setFechaEgresoFundacion(fechaEgreso);
            }
            Date fechaIngreso = sdf.parse(newUsuario.getFechaIngresoEcuador());
            usuario.setFechaIngresoEcuador(fechaIngreso);
            Date fechaIngresoFundacion = sdf.parse(newUsuario.getFechaIngresoFundacion());
            usuario.setFechaIngresoFundacion(fechaIngresoFundacion);
            Date fechaNacimiento = sdf.parse(newUsuario.getFechaNacimiento());
            usuario.setFechaNacimiento(fechaNacimiento);

            if (newUsuario.getFoto() != null) {
                byte[] foto = Base64.getEncoder().encode(newUsuario.getFoto().getBytes());
                usuario.setFoto(foto);
            }
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
        } catch (Exception e) {
            LOG.log(Level.SEVERE, "UsuarioServicio: Error al crear usuario usuario");
            LOG.log(Level.SEVERE, "", e);
            throw new ServiceException("Se ha producido un error al contruir el usuario", Response.Status.INTERNAL_SERVER_ERROR.getStatusCode());
        }
        return usuario;
    }

    public Boolean activarUsuario(UsuarioNuevoIonic newUsuario) throws ServiceException {
        Usuario usuario = new Usuario();
        boolean exito = false;
        try {
            usuario = usuarioFacade.obtenerusuarioPorIdentificacion(newUsuario.getIdentificacion());
            usuario.setEstado(Constante.UsuarioConstante.ACTIVO.getUsuarioConstanteId());
            usuario.setObservacionIngreso(newUsuario.getObservacionIngreso());
            usuarioFacade.edit(usuario);
            exito = true;
        } catch (Exception e) {
            LOG.log(Level.SEVERE, "UsuarioServicio: Error al obtener usuario por id:" + newUsuario.getIdusuario());
            LOG.log(Level.SEVERE, "", e);
            throw new ServiceException("Se ha producido un error en el servidor", Response.Status.INTERNAL_SERVER_ERROR.getStatusCode());
        }
        return exito;
    }

    public boolean desactivarUsuario(DocumentoIonic newUsuario) throws ServiceException {
        boolean exito = false;
        Usuario usuario = new Usuario();
        try {
            usuario = usuarioFacade.find(newUsuario.getIdUsuario());
            if (usuario != null) {
                Documento documento = new Documento();
                if (newUsuario.getDocumento() != null) {
                    byte[] foto = Base64.getEncoder().encode(newUsuario.getDocumento().getBytes());
                    documento.setDocumento(foto);
                }
                documento.setIdusuario(usuario);
                documento.setObservacion(newUsuario.getObservacion());
                documento.setTipoDocumento("pdf");
                short noEsViolencia = 0;
                documento.setEstado(noEsViolencia);
                documentoFacade.create(documento);
                if (newUsuario.isFirma()) {
                    usuario.setEstado(UsuarioConstante.DESACTIVADO.getUsuarioConstanteId());
                } else {
                    usuario.setEstado(UsuarioConstante.SINFIRMA.getUsuarioConstanteId());
                }
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                if (newUsuario.getFecha()!= null) {
                    Date fechaEgreso = sdf.parse(newUsuario.getFecha());
                    usuario.setFechaEgresoFundacion(fechaEgreso);
                }
                usuario.setRazonEgreso(newUsuario.getObservacion());
                usuarioFacade.edit(usuario);
                exito = true;
            }
        } catch (Exception e) {
            LOG.log(Level.SEVERE, "UsuarioServicio: Error al dar de baja al usuario usuario");
            LOG.log(Level.SEVERE, "", e);
            throw new ServiceException("Se ha producido un error en el servidor", Response.Status.INTERNAL_SERVER_ERROR.getStatusCode());
        }
        return exito;
    }
}
