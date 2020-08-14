/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.software.fnj.model.Ionic;

import com.software.fnj.modelo.Documento;
import com.software.fnj.modelo.Salud;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Alterbios
 */
public class UsuarioNuevoIonic {

    private Integer idusuario;
    private String nombres;
    private String apellidos;
    private String identificacion;
    private String oficio;
    private String profesion;
    private String habilidades;
    private String nivelInstruccion;
    private String razonEgreso;
    private String provincia;
    private String situacionMigratoria;
    private String lugarIngreso;
    private String telefono;
    private String telefonoContacto;
    private String observacionIngreso;
    private Date fechaNacimiento;
    private Date fechaEgresoFundacion;
    private Date fechaIngresoFundacion;
    private Date fechaIngresoEcuador;
    private byte[] foto;
    private Integer tipoIdentificacion;
    private Integer estado;
    private Integer idciudad;
    private Integer idgenero;
    private Integer idnacionalidad;
    private Integer idpais;
    private Integer idRegistrador;
    private Integer idParentesco;
    private List<SaludIonic> salud;
    private List<DocumentoIonic> documento;

    public Integer getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Integer idusuario) {
        this.idusuario = idusuario;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getOficio() {
        return oficio;
    }

    public void setOficio(String oficio) {
        this.oficio = oficio;
    }

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    public String getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(String habilidades) {
        this.habilidades = habilidades;
    }

    public String getNivelInstruccion() {
        return nivelInstruccion;
    }

    public void setNivelInstruccion(String nivelInstruccion) {
        this.nivelInstruccion = nivelInstruccion;
    }

    public String getRazonEgreso() {
        return razonEgreso;
    }

    public void setRazonEgreso(String razonEgreso) {
        this.razonEgreso = razonEgreso;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getSituacionMigratoria() {
        return situacionMigratoria;
    }

    public void setSituacionMigratoria(String situacionMigratoria) {
        this.situacionMigratoria = situacionMigratoria;
    }

    public String getLugarIngreso() {
        return lugarIngreso;
    }

    public void setLugarIngreso(String lugarIngreso) {
        this.lugarIngreso = lugarIngreso;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getTelefonoContacto() {
        return telefonoContacto;
    }

    public void setTelefonoContacto(String telefonoContacto) {
        this.telefonoContacto = telefonoContacto;
    }

    public String getObservacionIngreso() {
        return observacionIngreso;
    }

    public void setObservacionIngreso(String observacionIngreso) {
        this.observacionIngreso = observacionIngreso;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Date getFechaEgresoFundacion() {
        return fechaEgresoFundacion;
    }

    public void setFechaEgresoFundacion(Date fechaEgresoFundacion) {
        this.fechaEgresoFundacion = fechaEgresoFundacion;
    }

    public Date getFechaIngresoFundacion() {
        return fechaIngresoFundacion;
    }

    public void setFechaIngresoFundacion(Date fechaIngresoFundacion) {
        this.fechaIngresoFundacion = fechaIngresoFundacion;
    }

    public Date getFechaIngresoEcuador() {
        return fechaIngresoEcuador;
    }

    public void setFechaIngresoEcuador(Date fechaIngresoEcuador) {
        this.fechaIngresoEcuador = fechaIngresoEcuador;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    public Integer getTipoIdentificacion() {
        return tipoIdentificacion;
    }

    public void setTipoIdentificacion(Integer tipoIdentificacion) {
        this.tipoIdentificacion = tipoIdentificacion;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    public Integer getIdciudad() {
        return idciudad;
    }

    public void setIdciudad(Integer idciudad) {
        this.idciudad = idciudad;
    }

    public Integer getIdgenero() {
        return idgenero;
    }

    public void setIdgenero(Integer idgenero) {
        this.idgenero = idgenero;
    }

    public Integer getIdnacionalidad() {
        return idnacionalidad;
    }

    public void setIdnacionalidad(Integer idnacionalidad) {
        this.idnacionalidad = idnacionalidad;
    }

    public Integer getIdpais() {
        return idpais;
    }

    public void setIdpais(Integer idpais) {
        this.idpais = idpais;
    }

    public Integer getIdRegistrador() {
        return idRegistrador;
    }

    public void setIdRegistrador(Integer idRegistrador) {
        this.idRegistrador = idRegistrador;
    }

    public Integer getIdParentesco() {
        return idParentesco;
    }

    public void setIdParentesco(Integer idParentesco) {
        this.idParentesco = idParentesco;
    }

    public List<SaludIonic> getSalud() {
        return salud;
    }

    public void setSalud(List<SaludIonic> salud) {
        this.salud = salud;
    }

    public List<DocumentoIonic> getDocumento() {
        return documento;
    }

    public void setDocumento(List<DocumentoIonic> documento) {
        this.documento = documento;
    }

}
