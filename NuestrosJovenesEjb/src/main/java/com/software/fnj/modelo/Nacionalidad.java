/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.software.fnj.modelo;

import java.io.Serializable;
import java.util.List;
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
@Table(name = "nacionalidad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Nacionalidad.findAll", query = "SELECT n FROM Nacionalidad n")
    , @NamedQuery(name = "Nacionalidad.findByIdnacionalidad", query = "SELECT n FROM Nacionalidad n WHERE n.idnacionalidad = :idnacionalidad")
    , @NamedQuery(name = "Nacionalidad.findByPais", query = "SELECT n FROM Nacionalidad n WHERE n.pais = :pais")
    , @NamedQuery(name = "Nacionalidad.findByGentilicio", query = "SELECT n FROM Nacionalidad n WHERE n.gentilicio = :gentilicio")
    , @NamedQuery(name = "Nacionalidad.findByCodigoPais", query = "SELECT n FROM Nacionalidad n WHERE n.codigoPais = :codigoPais")})
public class Nacionalidad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idnacionalidad")
    private Integer idnacionalidad;
    @Size(max = 100)
    @Column(name = "pais")
    private String pais;
    @Size(max = 150)
    @Column(name = "gentilicio")
    private String gentilicio;
    @Size(max = 3)
    @Column(name = "codigoPais")
    private String codigoPais;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idnacionalidad", fetch = FetchType.LAZY)
    private List<Usuario> usuarioList;

    public Nacionalidad() {
    }

    public Nacionalidad(Integer idnacionalidad) {
        this.idnacionalidad = idnacionalidad;
    }

    public Integer getIdnacionalidad() {
        return idnacionalidad;
    }

    public void setIdnacionalidad(Integer idnacionalidad) {
        this.idnacionalidad = idnacionalidad;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getGentilicio() {
        return gentilicio;
    }

    public void setGentilicio(String gentilicio) {
        this.gentilicio = gentilicio;
    }

    public String getCodigoPais() {
        return codigoPais;
    }

    public void setCodigoPais(String codigoPais) {
        this.codigoPais = codigoPais;
    }

    @XmlTransient
    public List<Usuario> getUsuarioList() {
        return usuarioList;
    }

    public void setUsuarioList(List<Usuario> usuarioList) {
        this.usuarioList = usuarioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idnacionalidad != null ? idnacionalidad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Nacionalidad)) {
            return false;
        }
        Nacionalidad other = (Nacionalidad) object;
        if ((this.idnacionalidad == null && other.idnacionalidad != null) || (this.idnacionalidad != null && !this.idnacionalidad.equals(other.idnacionalidad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.software.fnj.modelo.Nacionalidad[ idnacionalidad=" + idnacionalidad + " ]";
    }
    
}
