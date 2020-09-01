/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.software.fnj.modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Alterbios
 */
@Entity
@Table(name = "remember")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Remember.findAll", query = "SELECT r FROM Remember r")
    , @NamedQuery(name = "Remember.findByIdRemember", query = "SELECT r FROM Remember r WHERE r.idRemember = :idRemember")
    , @NamedQuery(name = "Remember.findByPregunta", query = "SELECT r FROM Remember r WHERE r.pregunta = :pregunta")
    , @NamedQuery(name = "Remember.findByRespuesta", query = "SELECT r FROM Remember r WHERE r.respuesta = :respuesta")})
public class Remember implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_remember")
    private Integer idRemember;
    @Size(max = 10000)
    @Column(name = "pregunta")
    private String pregunta;
    @Size(max = 500)
    @Column(name = "respuesta")
    private String respuesta;

    public Remember() {
    }

    public Remember(Integer idRemember) {
        this.idRemember = idRemember;
    }

    public Integer getIdRemember() {
        return idRemember;
    }

    public void setIdRemember(Integer idRemember) {
        this.idRemember = idRemember;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRemember != null ? idRemember.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Remember)) {
            return false;
        }
        Remember other = (Remember) object;
        if ((this.idRemember == null && other.idRemember != null) || (this.idRemember != null && !this.idRemember.equals(other.idRemember))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.software.fnj.modelo.Remember[ idRemember=" + idRemember + " ]";
    }
    
}
