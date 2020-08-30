/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.software.fnj.modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Alterbios
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
    , @NamedQuery(name = "Usuario.findBySituacionMigratoria", query = "SELECT u FROM Usuario u WHERE u.situacionMigratoria = :situacionMigratoria")
    , @NamedQuery(name = "Usuario.findByTipoIdentificacion", query = "SELECT u FROM Usuario u WHERE u.tipoIdentificacion = :tipoIdentificacion")
    , @NamedQuery(name = "Usuario.findByIdRegistrador", query = "SELECT u FROM Usuario u WHERE u.idRegistrador = :idRegistrador")
    , @NamedQuery(name = "Usuario.findByTelefono", query = "SELECT u FROM Usuario u WHERE u.telefono = :telefono")
    , @NamedQuery(name = "Usuario.findByTelefonoContacto", query = "SELECT u FROM Usuario u WHERE u.telefonoContacto = :telefonoContacto")
    , @NamedQuery(name = "Usuario.findByObservacionIngreso", query = "SELECT u FROM Usuario u WHERE u.observacionIngreso = :observacionIngreso")})
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
    @Column(name = "tipoIdentificacion")
    private Integer tipoIdentificacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idRegistrador")
    private int idRegistrador;
    @Size(max = 45)
    @Column(name = "telefono")
    private String telefono;
    @Size(max = 500)
    @Column(name = "telefonoContacto")
    private String telefonoContacto;
    @Size(max = 999)
    @Column(name = "observacionIngreso")
    private String observacionIngreso;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idusuario", fetch = FetchType.LAZY)
    private List<Parentescofamiliarusuario> parentescofamiliarusuarioList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idusuario", fetch = FetchType.LAZY)
    private List<Asignacionperfil> asignacionperfilList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idusuario", fetch = FetchType.LAZY)
    private List<Documento> documentoList;
    @JoinColumn(name = "idlugarIngreso", referencedColumnName = "idlugarIngreso")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Lugaringreso idlugarIngreso;
    @JoinColumn(name = "idciudad", referencedColumnName = "idciudad")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Ciudad idciudad;
    @JoinColumn(name = "idgenero", referencedColumnName = "idgenero")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Genero idgenero;
    @JoinColumn(name = "idnacionalidad", referencedColumnName = "idnacionalidad")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Nacionalidad idnacionalidad;
    @JoinColumn(name = "idpais", referencedColumnName = "idpais")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Pais idpais;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idusuario", fetch = FetchType.LAZY)
    private List<Salud> saludList;

    public Usuario() {
    }

    public Usuario(Integer idusuario) {
        this.idusuario = idusuario;
    }

    public Usuario(Integer idusuario, int idRegistrador) {
        this.idusuario = idusuario;
        this.idRegistrador = idRegistrador;
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

    public Integer getTipoIdentificacion() {
        return tipoIdentificacion;
    }

    public void setTipoIdentificacion(Integer tipoIdentificacion) {
        this.tipoIdentificacion = tipoIdentificacion;
    }

    public int getIdRegistrador() {
        return idRegistrador;
    }

    public void setIdRegistrador(int idRegistrador) {
        this.idRegistrador = idRegistrador;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getTelefonoContacto() {
        return telefonoContacto;
    }

    public void setTelefonoContacto(String telefonoContacto) {
        this.telefonoContacto = telefonoContacto;
    }

    public String getObservacionIngreso() {
        return observacionIngreso;
    }

    public void setObservacionIngreso(String observacionIngreso) {
        this.observacionIngreso = observacionIngreso;
    }

    @XmlTransient
    public List<Parentescofamiliarusuario> getParentescofamiliarusuarioList() {
        return parentescofamiliarusuarioList;
    }

    public void setParentescofamiliarusuarioList(List<Parentescofamiliarusuario> parentescofamiliarusuarioList) {
        this.parentescofamiliarusuarioList = parentescofamiliarusuarioList;
    }

    @XmlTransient
    public List<Asignacionperfil> getAsignacionperfilList() {
        return asignacionperfilList;
    }

    public void setAsignacionperfilList(List<Asignacionperfil> asignacionperfilList) {
        this.asignacionperfilList = asignacionperfilList;
    }

    @XmlTransient
    public List<Documento> getDocumentoList() {
        return documentoList;
    }

    public void setDocumentoList(List<Documento> documentoList) {
        this.documentoList = documentoList;
    }

    public Lugaringreso getIdlugarIngreso() {
        return idlugarIngreso;
    }

    public void setIdlugarIngreso(Lugaringreso idlugarIngreso) {
        this.idlugarIngreso = idlugarIngreso;
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
    public List<Salud> getSaludList() {
        return saludList;
    }

    public void setSaludList(List<Salud> saludList) {
        this.saludList = saludList;
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
        return "com.software.fnj.modelo.Usuario[ idusuario=" + idusuario + " ]";
    }
    
}
