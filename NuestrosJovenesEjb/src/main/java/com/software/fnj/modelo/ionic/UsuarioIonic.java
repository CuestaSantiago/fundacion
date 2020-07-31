/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.software.fnj.modelo.ionic;

import com.software.fnj.modelo.Ciudad;
import com.software.fnj.modelo.Documento;
import com.software.fnj.modelo.Genero;
import com.software.fnj.modelo.Lugaringreso;
import com.software.fnj.modelo.Nacionalidad;
import com.software.fnj.modelo.Pais;
import com.software.fnj.modelo.Salud;
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
    private byte[] foto;
    private Date fechaEgresoFundacion;
    private String provincia;
    private String situacionMigratoria;
    private Ciudad idciudad;
    private Genero idgenero;
    private Lugaringreso idlugarIngreso;
    private Nacionalidad idnacionalidad;
    private Pais idpais;
    private List<Salud> salud;
    private List<Documento> documento;

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

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
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

    public Nacionalidad getIdnacionalidad() {
        return idnacionalidad;
    }

    public void setIdnacionalidad(Nacionalidad idnacionalidad) {
        this.idnacionalidad = idnacionalidad;
    }

    public Pais getIdpais() {
        return idpais;
    }

    public void setIdpais(Pais idpais) {
        this.idpais = idpais;
    }

    public List<Salud> getSalud() {
        return salud;
    }

    public void setSalud(List<Salud> salud) {
        this.salud = salud;
    }

    public List<Documento> getDocumento() {
        return documento;
    }

    public void setDocumento(List<Documento> documento) {
        this.documento = documento;
    }




}
