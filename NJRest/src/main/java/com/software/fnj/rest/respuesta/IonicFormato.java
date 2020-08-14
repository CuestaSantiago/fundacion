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
        usuario.getIdusuario().getIdlugarIngreso().setUsuarioCollection(null);
        usuario.getIdusuario().getIdpais().setUsuarioCollection(null);
        usuario.getIdusuario().getIdnacionalidad().setUsuarioCollection(null);
        usuario.getIdparentescoFamiliar().setParentescofamiliarusuarioCollection(null);
        usuario.getIdusuario().setAsignacionperfilCollection(null);
        usuario.getIdusuario().setDocumentoCollection(null);
        usuario.getIdusuario().setParentescofamiliarusuarioCollection(null);
        usuario.getIdusuario().setSaludCollection(null);
        for (Documento doc : documento) {
            doc.setIdusuario(null);
        }
        for (Salud sal : salud) {
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
        user.setFoto(usuario.getIdusuario().getFoto());
        user.setFechaEgresoFundacion(usuario.getIdusuario().getFechaEgresoFundacion());
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
        user.setDocumento(documento);
        user.setSalud(salud);
        user.setIdCabezaHogar(usuario.getIdusuarioCabezaHogar());
        user.setParentesco(usuario.getIdparentescoFamiliar().getParentesco());
        return user;
    }
}
