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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Alterbios
 */
@Entity
@Table(name = "parentescofamiliarusuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Parentescofamiliarusuario.findAll", query = "SELECT p FROM Parentescofamiliarusuario p")
    , @NamedQuery(name = "Parentescofamiliarusuario.findByIdparentescoFamiliarUsuario", query = "SELECT p FROM Parentescofamiliarusuario p WHERE p.idparentescoFamiliarUsuario = :idparentescoFamiliarUsuario")
    , @NamedQuery(name = "Parentescofamiliarusuario.findByIdusuarioCabezaHogar", query = "SELECT p FROM Parentescofamiliarusuario p WHERE p.idusuarioCabezaHogar = :idusuarioCabezaHogar")})
public class Parentescofamiliarusuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idparentescoFamiliarUsuario")
    private Integer idparentescoFamiliarUsuario;
    @Column(name = "idusuarioCabezaHogar")
    private Integer idusuarioCabezaHogar;
    @JoinColumn(name = "idparentescoFamiliar", referencedColumnName = "idparentescoFamiliar")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Parentescofamiliar idparentescoFamiliar;
    @JoinColumn(name = "idusuario", referencedColumnName = "idusuario")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Usuario idusuario;

    public Parentescofamiliarusuario() {
    }

    public Parentescofamiliarusuario(Integer idparentescoFamiliarUsuario) {
        this.idparentescoFamiliarUsuario = idparentescoFamiliarUsuario;
    }

    public Integer getIdparentescoFamiliarUsuario() {
        return idparentescoFamiliarUsuario;
    }

    public void setIdparentescoFamiliarUsuario(Integer idparentescoFamiliarUsuario) {
        this.idparentescoFamiliarUsuario = idparentescoFamiliarUsuario;
    }

    public Integer getIdusuarioCabezaHogar() {
        return idusuarioCabezaHogar;
    }

    public void setIdusuarioCabezaHogar(Integer idusuarioCabezaHogar) {
        this.idusuarioCabezaHogar = idusuarioCabezaHogar;
    }

    public Parentescofamiliar getIdparentescoFamiliar() {
        return idparentescoFamiliar;
    }

    public void setIdparentescoFamiliar(Parentescofamiliar idparentescoFamiliar) {
        this.idparentescoFamiliar = idparentescoFamiliar;
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
        hash += (idparentescoFamiliarUsuario != null ? idparentescoFamiliarUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Parentescofamiliarusuario)) {
            return false;
        }
        Parentescofamiliarusuario other = (Parentescofamiliarusuario) object;
        if ((this.idparentescoFamiliarUsuario == null && other.idparentescoFamiliarUsuario != null) || (this.idparentescoFamiliarUsuario != null && !this.idparentescoFamiliarUsuario.equals(other.idparentescoFamiliarUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.software.fnj.modelo.Parentescofamiliarusuario[ idparentescoFamiliarUsuario=" + idparentescoFamiliarUsuario + " ]";
    }
    
}
