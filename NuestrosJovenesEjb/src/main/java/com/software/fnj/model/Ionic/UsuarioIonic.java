/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.software.fnj.model.Ionic;

import com.software.fnj.modelo.Ciudad;
import com.software.fnj.modelo.Genero;
import com.software.fnj.modelo.Lugaringreso;
import com.software.fnj.modelo.Nacionalidad;
import com.software.fnj.modelo.Pais;
import java.util.Date;
import java.util.List;

/**
 *
 * @author santiago
 */
public class UsuarioIonic {

    private Integer idusuario;
    private String nombres;
    private String apellidos;
    private Date fechaNacimiento;
    private String identificacion;
    private String oficio;
    private String profesion;
    private String habilidades;
    private String nivelInstruccion;
    private Date fechaIngresoEcuador;
    private Date fechaIngresoFundacion;
    private Integer estado;
    private String razonEgreso;
    private String foto;
    private Date fechaEgresoFundacion;
    private String provincia;
    private String situacionMigratoria;
    private Ciudad idciudad;
    private Pais idpais;
    private Nacionalidad idnacionalidad;
    private Genero idgenero;
    private Lugaringreso idlugarIngreso;
    private Integer tipoIdentificacion;
    private Integer idRegistrador;
    private String telefono;
    private String telefonoContacto;
    private String observacionIngreso;
    private List<SaludIonic> salud;
    private List<DocumentoIonic> documento;
    private Integer idCabezaHogar;
    private String parentesco;
    private List<FamiliaIonic> familia;

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

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
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

    public Date getFechaIngresoEcuador() {
        return fechaIngresoEcuador;
    }

    public void setFechaIngresoEcuador(Date fechaIngresoEcuador) {
        this.fechaIngresoEcuador = fechaIngresoEcuador;
    }

    public Date getFechaIngresoFundacion() {
        return fechaIngresoFundacion;
    }

    public void setFechaIngresoFundacion(Date fechaIngresoFundacion) {
        this.fechaIngresoFundacion = fechaIngresoFundacion;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    public String getRazonEgreso() {
        return razonEgreso;
    }

    public void setRazonEgreso(String razonEgreso) {
        this.razonEgreso = razonEgreso;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public Date getFechaEgresoFundacion() {
        return fechaEgresoFundacion;
    }

    public void setFechaEgresoFundacion(Date fechaEgresoFundacion) {
        this.fechaEgresoFundacion = fechaEgresoFundacion;
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

    public Ciudad getIdciudad() {
        return idciudad;
    }

    public void setIdciudad(Ciudad idciudad) {
        this.idciudad = idciudad;
    }

    public Pais getIdpais() {
        return idpais;
    }

    public void setIdpais(Pais idpais) {
        this.idpais = idpais;
    }

    public Nacionalidad getIdnacionalidad() {
        return idnacionalidad;
    }

    public void setIdnacionalidad(Nacionalidad idnacionalidad) {
        this.idnacionalidad = idnacionalidad;
    }

    public Genero getIdgenero() {
        return idgenero;
    }

    public void setIdgenero(Genero idgenero) {
        this.idgenero = idgenero;
    }

    public Lugaringreso getIdlugarIngreso() {
        return idlugarIngreso;
    }

    public void setIdlugarIngreso(Lugaringreso idlugarIngreso) {
        this.idlugarIngreso = idlugarIngreso;
    }

    public Integer getTipoIdentificacion() {
        return tipoIdentificacion;
    }

    public void setTipoIdentificacion(Integer tipoIdentificacion) {
        this.tipoIdentificacion = tipoIdentificacion;
    }

    public Integer getIdRegistrador() {
        return idRegistrador;
    }

    public void setIdRegistrador(Integer idRegistrador) {
        this.idRegistrador = idRegistrador;
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

    public Integer getIdCabezaHogar() {
        return idCabezaHogar;
    }

    public void setIdCabezaHogar(Integer idCabezaHogar) {
        this.idCabezaHogar = idCabezaHogar;
    }

    public String getParentesco() {
        return parentesco;
    }

    public void setParentesco(String parentesco) {
        this.parentesco = parentesco;
    }

    public List<FamiliaIonic> getFamilia() {
        return familia;
    }

    public void setFamilia(List<FamiliaIonic> familia) {
        this.familia = familia;
    }

}
