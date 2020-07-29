/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.software.fnj.modelo;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Alterbios
 */
@Entity
@Table(name = "lugaringreso")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Lugaringreso.findAll", query = "SELECT l FROM Lugaringreso l")
    , @NamedQuery(name = "Lugaringreso.findByIdlugarIngreso", query = "SELECT l FROM Lugaringreso l WHERE l.idlugarIngreso = :idlugarIngreso")
    , @NamedQuery(name = "Lugaringreso.findByNombre", query = "SELECT l FROM Lugaringreso l WHERE l.nombre = :nombre")})
public class Lugaringreso implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idlugarIngreso")
    private Integer idlugarIngreso;
    @Size(max = 100)
    @Column(name = "nombre")
    private String nombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idlugarIngreso", fetch = FetchType.LAZY)
    private Collection<Usuario> usuarioCollection;

    public Lugaringreso() {
    }

    public Lugaringreso(Integer idlugarIngreso) {
        this.idlugarIngreso = idlugarIngreso;
    }

    public Integer getIdlugarIngreso() {
        return idlugarIngreso;
    }

    public void setIdlugarIngreso(Integer idlugarIngreso) {
        this.idlugarIngreso = idlugarIngreso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlTransient
    public Collection<Usuario> getUsuarioCollection() {
        return usuarioCollection;
    }

    public void setUsuarioCollection(Collection<Usuario> usuarioCollection) {
        this.usuarioCollection = usuarioCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idlugarIngreso != null ? idlugarIngreso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Lugaringreso)) {
            return false;
        }
        Lugaringreso other = (Lugaringreso) object;
        if ((this.idlugarIngreso == null && other.idlugarIngreso != null) || (this.idlugarIngreso != null && !this.idlugarIngreso.equals(other.idlugarIngreso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.software.fnj.modelo.Lugaringreso[ idlugarIngreso=" + idlugarIngreso + " ]";
    }
    
}
