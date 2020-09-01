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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Alterbios
 */
@Entity
@Table(name = "asignacionperfil")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Asignacionperfil.findAll", query = "SELECT a FROM Asignacionperfil a")
    , @NamedQuery(name = "Asignacionperfil.findByIdasignacionPerfil", query = "SELECT a FROM Asignacionperfil a WHERE a.idasignacionPerfil = :idasignacionPerfil")
    , @NamedQuery(name = "Asignacionperfil.findByContrasena", query = "SELECT a FROM Asignacionperfil a WHERE a.contrasena = :contrasena")
    , @NamedQuery(name = "Asignacionperfil.findByNombrePerfil", query = "SELECT a FROM Asignacionperfil a WHERE a.nombrePerfil = :nombrePerfil")
    , @NamedQuery(name = "Asignacionperfil.findByEstado", query = "SELECT a FROM Asignacionperfil a WHERE a.estado = :estado")})
public class Asignacionperfil implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idasignacionPerfil")
    private Integer idasignacionPerfil;
    @Size(max = 200)
    @Column(name = "contrasena")
    private String contrasena;
    @Size(max = 50)
    @Column(name = "nombrePerfil")
    private String nombrePerfil;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado")
    private int estado;
    @JoinColumn(name = "idperfil", referencedColumnName = "idperfil")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Perfil idperfil;
    @JoinColumn(name = "idusuario", referencedColumnName = "idusuario")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Usuario idusuario;

    public Asignacionperfil() {
    }

    public Asignacionperfil(Integer idasignacionPerfil) {
        this.idasignacionPerfil = idasignacionPerfil;
    }

    public Asignacionperfil(Integer idasignacionPerfil, int estado) {
        this.idasignacionPerfil = idasignacionPerfil;
        this.estado = estado;
    }

    public Integer getIdasignacionPerfil() {
        return idasignacionPerfil;
    }

    public void setIdasignacionPerfil(Integer idasignacionPerfil) {
        this.idasignacionPerfil = idasignacionPerfil;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getNombrePerfil() {
        return nombrePerfil;
    }

    public void setNombrePerfil(String nombrePerfil) {
        this.nombrePerfil = nombrePerfil;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public Perfil getIdperfil() {
        return idperfil;
    }

    public void setIdperfil(Perfil idperfil) {
        this.idperfil = idperfil;
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
        hash += (idasignacionPerfil != null ? idasignacionPerfil.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Asignacionperfil)) {
            return false;
        }
        Asignacionperfil other = (Asignacionperfil) object;
        if ((this.idasignacionPerfil == null && other.idasignacionPerfil != null) || (this.idasignacionPerfil != null && !this.idasignacionPerfil.equals(other.idasignacionPerfil))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.software.fnj.modelo.Asignacionperfil[ idasignacionPerfil=" + idasignacionPerfil + " ]";
    }
    
}
