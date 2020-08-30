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
@Table(name = "parentescofamiliar")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Parentescofamiliar.findAll", query = "SELECT p FROM Parentescofamiliar p")
    , @NamedQuery(name = "Parentescofamiliar.findByIdparentescoFamiliar", query = "SELECT p FROM Parentescofamiliar p WHERE p.idparentescoFamiliar = :idparentescoFamiliar")
    , @NamedQuery(name = "Parentescofamiliar.findByParentesco", query = "SELECT p FROM Parentescofamiliar p WHERE p.parentesco = :parentesco")})
public class Parentescofamiliar implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idparentescoFamiliar")
    private Integer idparentescoFamiliar;
    @Size(max = 100)
    @Column(name = "parentesco")
    private String parentesco;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idparentescoFamiliar", fetch = FetchType.LAZY)
    private List<Parentescofamiliarusuario> parentescofamiliarusuarioList;

    public Parentescofamiliar() {
    }

    public Parentescofamiliar(Integer idparentescoFamiliar) {
        this.idparentescoFamiliar = idparentescoFamiliar;
    }

    public Integer getIdparentescoFamiliar() {
        return idparentescoFamiliar;
    }

    public void setIdparentescoFamiliar(Integer idparentescoFamiliar) {
        this.idparentescoFamiliar = idparentescoFamiliar;
    }

    public String getParentesco() {
        return parentesco;
    }

    public void setParentesco(String parentesco) {
        this.parentesco = parentesco;
    }

    @XmlTransient
    public List<Parentescofamiliarusuario> getParentescofamiliarusuarioList() {
        return parentescofamiliarusuarioList;
    }

    public void setParentescofamiliarusuarioList(List<Parentescofamiliarusuario> parentescofamiliarusuarioList) {
        this.parentescofamiliarusuarioList = parentescofamiliarusuarioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idparentescoFamiliar != null ? idparentescoFamiliar.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Parentescofamiliar)) {
            return false;
        }
        Parentescofamiliar other = (Parentescofamiliar) object;
        if ((this.idparentescoFamiliar == null && other.idparentescoFamiliar != null) || (this.idparentescoFamiliar != null && !this.idparentescoFamiliar.equals(other.idparentescoFamiliar))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.software.fnj.modelo.Parentescofamiliar[ idparentescoFamiliar=" + idparentescoFamiliar + " ]";
    }
    
}
