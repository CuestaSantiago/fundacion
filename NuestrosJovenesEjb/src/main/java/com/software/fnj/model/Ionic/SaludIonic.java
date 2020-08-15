/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.software.fnj.model.Ionic;

/**
 *
 * @author Santiago
 */
public class SaludIonic {

    private Integer idSalud;
    private String condicionMedica;
    private String foto;
    private Integer estadoDiscapacidad;

    public Integer getIdSalud() {
        return idSalud;
    }

    public void setIdSalud(Integer idSalud) {
        this.idSalud = idSalud;
    }

    public String getCondicionMedica() {
        return condicionMedica;
    }

    public void setCondicionMedica(String condicionMedica) {
        this.condicionMedica = condicionMedica;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public Integer getEstadoDiscapacidad() {
        return estadoDiscapacidad;
    }

    public void setEstadoDiscapacidad(Integer estadoDiscapacidad) {
        this.estadoDiscapacidad = estadoDiscapacidad;
    }

}
