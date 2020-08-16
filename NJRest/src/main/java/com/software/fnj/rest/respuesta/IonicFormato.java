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
import com.software.fnj.model.Ionic.UsuarioIonic;
import com.software.fnj.modelo.Salud;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Base64;
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
    public static UsuarioIonic ConstruirUsuarioIonic(Parentescofamiliarusuario usuario, List<Salud> salud, List<Documento> documento) throws UnsupportedEncodingException {
        UsuarioIonic user = new UsuarioIonic();
        List<DocumentoIonic> docsIonic = new ArrayList();
        List<SaludIonic> saludes = new ArrayList();
        try {
            usuario.getIdusuario().getIdgenero().setUsuarioCollection(null);
            usuario.getIdusuario().getIdciudad().setUsuarioCollection(null);
            usuario.getIdusuario().getIdlugarIngreso().setUsuarioCollection(null);
            usuario.getIdusuario().getIdpais().setUsuarioCollection(null);
            usuario.getIdusuario().getIdnacionalidad().setUsuarioCollection(null);
            usuario.getIdparentescoFamiliar().setParentescofamiliarusuarioCollection(null);
            usuario.getIdusuario().setAsignacionperfilCollection(null);
            usuario.getIdusuario().setDocumentoCollection(null);
            usuario.getIdusuario().setParentescofamiliarusuarioCollection(null);
            usuario.getIdusuario().setSaludCollection(null);
            for (Documento doc : documento) {
                DocumentoIonic docionic = new DocumentoIonic();
                byte[] decodedString = Base64.getDecoder().decode(new String(doc.getDocumento()).getBytes("UTF-8"));
                docionic.setObservacion(doc.getObservacion());
                docionic.setDocumento(new String(decodedString));
                docsIonic.add(docionic);
                doc.setIdusuario(null);
            }
            for (Salud sal : salud) {
                SaludIonic saludIonic = new SaludIonic();
                if (sal.getFoto() != null) {
                    byte[] decodedString = Base64.getDecoder().decode(new String(sal.getFoto()).getBytes("UTF-8"));
                    saludIonic.setFoto(new String(decodedString));
                }
                saludIonic.setCondicionMedica(sal.getCondicionMedica());
                saludIonic.setEstadoDiscapacidad(sal.getEstadoDiscapacidad());
                saludIonic.setIdSalud(sal.getIdsalud());
                saludes.add(saludIonic);
                sal.setIdusuario(null);
            }
            user.setIdusuario(usuario.getIdusuario().getIdusuario());
            user.setNombres(usuario.getIdusuario().getNombres());
            user.setApellidos(usuario.getIdusuario().getApellidos());
            user.setIdentificacion(usuario.getIdusuario().getIdentificacion());
            user.setOficio(usuario.getIdusuario().getOficio());
            user.setProfesion(usuario.getIdusuario().getProfesion());
            user.setHabilidades(usuario.getIdusuario().getHabilidades());
            user.setNivelInstruccion(usuario.getIdusuario().getNivelInstruccion());
            user.setFechaIngresoEcuador(usuario.getIdusuario().getFechaIngresoEcuador());
            user.setFechaIngresoFundacion(usuario.getIdusuario().getFechaIngresoFundacion());
            user.setEstado(usuario.getIdusuario().getEstado());
            user.setRazonEgreso(usuario.getIdusuario().getRazonEgreso());
            byte[] decodedString = Base64.getDecoder().decode(new String(usuario.getIdusuario().getFoto()).getBytes("UTF-8"));
            user.setFoto(new String(decodedString));
            user.setFechaEgresoFundacion(usuario.getIdusuario().getFechaEgresoFundacion());
            user.setFechaNacimiento(usuario.getIdusuario().getFechaNacimiento());
            user.setProvincia(usuario.getIdusuario().getProvincia());
            user.setSituacionMigratoria(usuario.getIdusuario().getSituacionMigratoria());
            user.setIdciudad(usuario.getIdusuario().getIdciudad());
            user.setIdpais(usuario.getIdusuario().getIdpais());
            user.setIdnacionalidad(usuario.getIdusuario().getIdnacionalidad());
            user.setIdgenero(usuario.getIdusuario().getIdgenero());
            user.setIdlugarIngreso(usuario.getIdusuario().getIdlugarIngreso());
            user.setTipoIdentificacion(usuario.getIdusuario().getTipoIdentificacion());
            user.setIdRegistrador(usuario.getIdusuario().getIdRegistrador());
            user.setTelefono(usuario.getIdusuario().getTelefono());
            user.setTelefonoContacto(usuario.getIdusuario().getTelefonoContacto());
            user.setObservacionIngreso(usuario.getIdusuario().getObservacionIngreso());
            user.setDocumento(docsIonic);
            user.setSalud(saludes);
            user.setIdCabezaHogar(usuario.getIdusuarioCabezaHogar());
            user.setParentesco(usuario.getIdparentescoFamiliar().getParentesco());
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return user;
    }
}
