/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.software.fnj.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author santiago
 */
@Entity
@Table(name = "usuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u")
    , @NamedQuery(name = "Usuario.findByIdusuario", query = "SELECT u FROM Usuario u WHERE u.idusuario = :idusuario")
    , @NamedQuery(name = "Usuario.findByNombres", query = "SELECT u FROM Usuario u WHERE u.nombres = :nombres")
    , @NamedQuery(name = "Usuario.findByApellidos", query = "SELECT u FROM Usuario u WHERE u.apellidos = :apellidos")
    , @NamedQuery(name = "Usuario.findByFechaNacimiento", query = "SELECT u FROM Usuario u WHERE u.fechaNacimiento = :fechaNacimiento")
    , @NamedQuery(name = "Usuario.findByIdentificacion", query = "SELECT u FROM Usuario u WHERE u.identificacion = :identificacion")
    , @NamedQuery(name = "Usuario.findByOficio", query = "SELECT u FROM Usuario u WHERE u.oficio = :oficio")
    , @NamedQuery(name = "Usuario.findByProfesion", query = "SELECT u FROM Usuario u WHERE u.profesion = :profesion")
    , @NamedQuery(name = "Usuario.findByHabilidades", query = "SELECT u FROM Usuario u WHERE u.habilidades = :habilidades")
    , @NamedQuery(name = "Usuario.findByNivelInstruccion", query = "SELECT u FROM Usuario u WHERE u.nivelInstruccion = :nivelInstruccion")
    , @NamedQuery(name = "Usuario.findByFechaIngresoEcuador", query = "SELECT u FROM Usuario u WHERE u.fechaIngresoEcuador = :fechaIngresoEcuador")
    , @NamedQuery(name = "Usuario.findByFechaIngresoFundacion", query = "SELECT u FROM Usuario u WHERE u.fechaIngresoFundacion = :fechaIngresoFundacion")
    , @NamedQuery(name = "Usuario.findByEstado", query = "SELECT u FROM Usuario u WHERE u.estado = :estado")
    , @NamedQuery(name = "Usuario.findByRazonEgreso", query = "SELECT u FROM Usuario u WHERE u.razonEgreso = :razonEgreso")
    , @NamedQuery(name = "Usuario.findByFechaEgresoFundacion", query = "SELECT u FROM Usuario u WHERE u.fechaEgresoFundacion = :fechaEgresoFundacion")
    , @NamedQuery(name = "Usuario.findByProvincia", query = "SELECT u FROM Usuario u WHERE u.provincia = :provincia")
    , @NamedQuery(name = "Usuario.findBySituacionMigratoria", query = "SELECT u FROM Usuario u WHERE u.situacionMigratoria = :situacionMigratoria")})
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idusuario")
    private Integer idusuario;
    @Size(max = 200)
    @Column(name = "nombres")
    private String nombres;
    @Size(max = 200)
    @Column(name = "apellidos")
    private String apellidos;
    @Column(name = "fechaNacimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;
    @Size(max = 25)
    @Column(name = "identificacion")
    private String identificacion;
    @Size(max = 500)
    @Column(name = "oficio")
    private String oficio;
    @Size(max = 400)
    @Column(name = "profesion")
    private String profesion;
    @Size(max = 400)
    @Column(name = "habilidades")
    private String habilidades;
    @Size(max = 50)
    @Column(name = "nivelInstruccion")
    private String nivelInstruccion;
    @Column(name = "fechaIngresoEcuador")
    @Temporal(TemporalType.DATE)
    private Date fechaIngresoEcuador;
    @Column(name = "fechaIngresoFundacion")
    @Temporal(TemporalType.DATE)
    private Date fechaIngresoFundacion;
    @Column(name = "estado")
    private Integer estado;
    @Size(max = 300)
    @Column(name = "razonEgreso")
    private String razonEgreso;
    @Lob
    @Column(name = "foto")
    private byte[] foto;
    @Column(name = "fechaEgresoFundacion")
    @Temporal(TemporalType.DATE)
    private Date fechaEgresoFundacion;
    @Size(max = 500)
    @Column(name = "provincia")
    private String provincia;
    @Size(max = 500)
    @Column(name = "situacionMigratoria")
    private String situacionMigratoria;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idusuario", fetch = FetchType.LAZY)
    private Collection<Parentescofamiliarusuario> parentescofamiliarusuarioCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idusuario", fetch = FetchType.LAZY)
    private Collection<Asignacionperfil> asignacionperfilCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idusuario", fetch = FetchType.LAZY)
    private Collection<Documento> documentoCollection;
    @JoinColumn(name = "idciudad", referencedColumnName = "idciudad")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Ciudad idciudad;
    @JoinColumn(name = "idgenero", referencedColumnName = "idgenero")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Genero idgenero;
    @JoinColumn(name = "idlugarIngreso", referencedColumnName = "idlugarIngreso")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Lugaringreso idlugarIngreso;
    @JoinColumn(name = "idnacionalidad", referencedColumnName = "idnacionalidad")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Nacionalidad idnacionalidad;
    @JoinColumn(name = "idpais", referencedColumnName = "idpais")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Pais idpais;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idusuario", fetch = FetchType.LAZY)
    private Collection<Salud> saludCollection;

    public Usuario() {
    }

    public Usuario(Integer idusuario) {
        this.idusuario = idusuario;
    }

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

    @XmlTransient
    public Collection<Parentescofamiliarusuario> getParentescofamiliarusuarioCollection() {
        return parentescofamiliarusuarioCollection;
    }

    public void setParentescofamiliarusuarioCollection(Collection<Parentescofamiliarusuario> parentescofamiliarusuarioCollection) {
        this.parentescofamiliarusuarioCollection = parentescofamiliarusuarioCollection;
    }

    @XmlTransient
    public Collection<Asignacionperfil> getAsignacionperfilCollection() {
        return asignacionperfilCollection;
    }

    public void setAsignacionperfilCollection(Collection<Asignacionperfil> asignacionperfilCollection) {
        this.asignacionperfilCollection = asignacionperfilCollection;
    }

    @XmlTransient
    public Collection<Documento> getDocumentoCollection() {
        return documentoCollection;
    }

    public void setDocumentoCollection(Collection<Documento> documentoCollection) {
        this.documentoCollection = documentoCollection;
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

    @XmlTransient
    public Collection<Salud> getSaludCollection() {
        return saludCollection;
    }

    public void setSaludCollection(Collection<Salud> saludCollection) {
        this.saludCollection = saludCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idusuario != null ? idusuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.idusuario == null && other.idusuario != null) || (this.idusuario != null && !this.idusuario.equals(other.idusuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.software.fnj.model.Usuario[ idusuario=" + idusuario + " ]";
    }
    
}
