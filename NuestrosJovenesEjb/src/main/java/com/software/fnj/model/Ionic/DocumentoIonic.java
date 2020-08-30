/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.software.fnj.model.Ionic;

/**
 *
 * @author Alterbios
 */
public class DocumentoIonic {

    private Integer idUsuario;
    private String observacion;
    private String documento;
    private boolean violencia;
    private boolean firma;

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public boolean isViolencia() {
        return violencia;
    }

    public void setViolencia(boolean violencia) {
        this.violencia = violencia;
    }

    public boolean isFirma() {
        return firma;
    }

    public void setFirma(boolean firma) {
        this.firma = firma;
    }

}
