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
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Alterbios
 */
@Entity
@Table(name = "salud")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Salud.findAll", query = "SELECT s FROM Salud s")
    , @NamedQuery(name = "Salud.findByIdsalud", query = "SELECT s FROM Salud s WHERE s.idsalud = :idsalud")
    , @NamedQuery(name = "Salud.findByCondicionMedica", query = "SELECT s FROM Salud s WHERE s.condicionMedica = :condicionMedica")
    , @NamedQuery(name = "Salud.findByEstadoDiscapacidad", query = "SELECT s FROM Salud s WHERE s.estadoDiscapacidad = :estadoDiscapacidad")})
public class Salud implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idsalud")
    private Integer idsalud;
    @Size(max = 500)
    @Column(name = "condicionMedica")
    private String condicionMedica;
    @Lob
    @Column(name = "foto")
    private byte[] foto;
    @Column(name = "estadoDiscapacidad")
    private Integer estadoDiscapacidad;
    @JoinColumn(name = "idusuario", referencedColumnName = "idusuario")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Usuario idusuario;

    public Salud() {
    }

    public Salud(Integer idsalud) {
        this.idsalud = idsalud;
    }

    public Integer getIdsalud() {
        return idsalud;
    }

    public void setIdsalud(Integer idsalud) {
        this.idsalud = idsalud;
    }

    public String getCondicionMedica() {
        return condicionMedica;
    }

    public void setCondicionMedica(String condicionMedica) {
        this.condicionMedica = condicionMedica;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    public Integer getEstadoDiscapacidad() {
        return estadoDiscapacidad;
    }

    public void setEstadoDiscapacidad(Integer estadoDiscapacidad) {
        this.estadoDiscapacidad = estadoDiscapacidad;
    }

    public Usuario getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Usuario idusuario) {
        this.idusuario = idusuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idsalud != null ? idsalud.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Salud)) {
            return false;
        }
        Salud other = (Salud) object;
        if ((this.idsalud == null && other.idsalud != null) || (this.idsalud != null && !this.idsalud.equals(other.idsalud))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.software.fnj.modelo.Salud[ idsalud=" + idsalud + " ]";
    }
    
}
