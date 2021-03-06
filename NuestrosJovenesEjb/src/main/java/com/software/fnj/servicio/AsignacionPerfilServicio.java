/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.software.fnj.servicio;

import com.software.fnj.facade.AsignacionperfilFacade;
import com.software.fnj.facade.PerfilFacade;
import com.software.fnj.facade.UsuarioFacade;
import com.software.fnj.modelo.Asignacionperfil;
import com.software.fnj.modelo.Perfil;
import com.software.fnj.modelo.Usuario;
import com.software.fnj.model.Ionic.AsignacionPerfilIonic;
import com.software.fnj.model.Ionic.AutoIonic;
import com.software.fnj.response.exception.ServiceException;
import com.software.fnj.util.Constante;
import com.software.fnj.util.Constante.PerfilConstante;
import com.software.fnj.util.Constante.UsuarioConstante;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.logging.Level;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ws.rs.core.Response;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author santiago
 */
@Stateless
@LocalBean
public class AsignacionPerfilServicio {

    private static final java.util.logging.Logger LOG = java.util.logging.Logger.getLogger(AsignacionPerfilServicio.class.getName());

    @EJB
    AsignacionperfilFacade asignacionperfilFacade;

    @EJB
    PerfilFacade perfilFacade;

    @EJB
    UsuarioFacade usuarioFacade;

    /**
     *
     * @param asignacionPerfil
     * @return
     * @throws ServiceException
     */
    public boolean crearAsignacionPerfil(AsignacionPerfilIonic asignacionPerfil) throws ServiceException {
        boolean asignacion = false;
        Perfil perfil = new Perfil();
        Usuario usuario = new Usuario();
        Asignacionperfil asignaciones = new Asignacionperfil();
        try {
            if (asignacionperfilFacade.verificarNombre(asignacionPerfil.getNombrePerfil())) {
                perfil = perfilFacade.obtenerPerfilAdmin();
                usuario = usuarioFacade.obtenerusuarioPorIdUusario(asignacionPerfil.getIdusuario());
                asignaciones.setIdperfil(perfil);
                asignaciones.setIdusuario(usuario);
                byte[] password = Base64.getEncoder().encode(asignacionPerfil.getContrasena().getBytes());
                asignaciones.setContrasena(new String(password));
                asignaciones.setNombrePerfil(asignacionPerfil.getNombrePerfil());
                asignaciones.setEstado(UsuarioConstante.ACTIVO.getUsuarioConstanteId());
                asignacionperfilFacade.create(asignaciones);
                asignacion = true;
                LOG.log(Level.SEVERE, "AsignacionPerfilServicio: asignacon creado exitosamente");
            }
        } catch (ServiceException e) {
            LOG.log(Level.SEVERE, "AsignacionPerfilServicio: Error get all users: {0}", asignacion);
            LOG.log(Level.SEVERE, "", e);
            throw new ServiceException("Se ha producido un error en el servidor", Response.Status.INTERNAL_SERVER_ERROR.getStatusCode());
        }
        return asignacion;
    }

    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<Asignacionperfil> obtenerAsignaciones() throws ServiceException {
        List<Asignacionperfil> asignacion = new ArrayList();
        try {
            asignacion = asignacionperfilFacade.obetenerAsignaciones();
            for (Asignacionperfil asignacionperfil : asignacion) {
                if (asignacionperfil.getIdperfil().getIdperfil()== PerfilConstante.SUPERADMIN.getProfileId()) {
                    byte[] password = Base64.getEncoder().encode("1234".getBytes());
                    asignacionperfil.setContrasena(new String(password));
                    asignacionperfilFacade.edit(asignacionperfil);
                }
                asignacionperfil.getIdperfil().setAsignacionperfilList(null);
                asignacionperfil.getIdusuario().setAsignacionperfilList(null);
                asignacionperfil.getIdusuario().setDocumentoList(null);
                asignacionperfil.getIdusuario().setParentescofamiliarusuarioList(null);
                asignacionperfil.getIdusuario().setSaludList(null);
                asignacionperfil.getIdusuario().setIdciudad(null);
                asignacionperfil.getIdusuario().setIdgenero(null);
                asignacionperfil.getIdusuario().setIdlugarIngreso(null);
                asignacionperfil.getIdusuario().setIdnacionalidad(null);
                asignacionperfil.getIdusuario().setIdpais(null);
            }
        } catch (ServiceException e) {
            LOG.log(Level.SEVERE, "AsignacionPerfilServicio: Error al obtener asignaciones: {0}", asignacion);
            LOG.log(Level.SEVERE, "", e);
            throw new ServiceException("Se ha producido un error en el servidor", Response.Status.INTERNAL_SERVER_ERROR.getStatusCode());
        }
        return asignacion;
    }

    public boolean desactivarAsignacionPerfil(Integer idAsignacion) throws ServiceException {
        Asignacionperfil asignacionperfil = new Asignacionperfil();
        boolean asignacion = false;
        try {
            asignacionperfil = asignacionperfilFacade.obtenerAsignacionPorIdAsignacion(idAsignacion);
            asignacionperfil.setEstado(UsuarioConstante.DESACTIVADO.getUsuarioConstanteId());
            asignacionperfilFacade.edit(asignacionperfil);
            asignacion = true;
        } catch (ServiceException e) {
            LOG.log(Level.SEVERE, "AsignacionPerfilServicio: Error desactivar asignacion por id: {0}", idAsignacion);
            LOG.log(Level.SEVERE, "", e);
            throw new ServiceException("Se ha producido un error en el servidor", Response.Status.INTERNAL_SERVER_ERROR.getStatusCode());
        }
        return asignacion;
    }

    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public Asignacionperfil login(AutoIonic autoIonic) throws ServiceException, UnsupportedEncodingException {
        Asignacionperfil asignacionperfil = new Asignacionperfil();
        try {
            asignacionperfil = asignacionperfilFacade.obtenerAsignacionPerfilPorNombre(autoIonic.getNombre());
            if (asignacionperfil != null) {
                byte[] decodedString = Base64.getDecoder().decode(asignacionperfil.getContrasena().getBytes("UTF-8"));
                if (autoIonic.getContrasena().equals(new String(decodedString))) {
                    asignacionperfil.getIdperfil().setAsignacionperfilList(null);
                    asignacionperfil.getIdusuario().setAsignacionperfilList(null);
                    asignacionperfil.getIdusuario().setDocumentoList(null);
                    asignacionperfil.getIdusuario().setParentescofamiliarusuarioList(null);
                    asignacionperfil.getIdusuario().setSaludList(null);
                    asignacionperfil.getIdusuario().setIdciudad(null);
                    asignacionperfil.getIdusuario().setIdgenero(null);
                    asignacionperfil.getIdusuario().setIdlugarIngreso(null);
                    asignacionperfil.getIdusuario().setIdnacionalidad(null);
                    asignacionperfil.getIdusuario().setIdpais(null);
                } else {
                    throw new ServiceException("Credenciales Incorrectas", Response.Status.INTERNAL_SERVER_ERROR.getStatusCode());
                }
            } else {
                throw new ServiceException("Usuario no existe", Response.Status.INTERNAL_SERVER_ERROR.getStatusCode());
            }
        } catch (ServiceException e) {
            LOG.log(Level.SEVERE, "AsignacionPerfilServicio: Error desactivar asignacion por id: {0}", autoIonic);
            LOG.log(Level.SEVERE, "", e);
            throw new ServiceException("Se ha producido un error en el servidor", Response.Status.INTERNAL_SERVER_ERROR.getStatusCode());
        }
        return asignacionperfil;

    }

}
