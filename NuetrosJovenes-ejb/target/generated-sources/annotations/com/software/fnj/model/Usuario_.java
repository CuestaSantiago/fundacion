package com.software.fnj.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Usuario.class)
public abstract class Usuario_ {

	public static volatile SingularAttribute<Usuario, Integer> estado;
	public static volatile SingularAttribute<Usuario, Date> fechaNacimiento;
	public static volatile CollectionAttribute<Usuario, Salud> saludCollection;
	public static volatile SingularAttribute<Usuario, Lugaringreso> idlugarIngreso;
	public static volatile SingularAttribute<Usuario, Date> fechaIngresoFundacion;
	public static volatile SingularAttribute<Usuario, Ciudad> idciudad;
	public static volatile SingularAttribute<Usuario, String> provincia;
	public static volatile SingularAttribute<Usuario, String> nombres;
	public static volatile SingularAttribute<Usuario, Date> fechaIngresoEcuador;
	public static volatile SingularAttribute<Usuario, Date> fechaEgresoFundacion;
	public static volatile SingularAttribute<Usuario, Pais> idpais;
	public static volatile CollectionAttribute<Usuario, Parentescofamiliarusuario> parentescofamiliarusuarioCollection;
	public static volatile SingularAttribute<Usuario, String> situacionMigratoria;
	public static volatile SingularAttribute<Usuario, String> habilidades;
	public static volatile SingularAttribute<Usuario, String> apellidos;
	public static volatile CollectionAttribute<Usuario, Documento> documentoCollection;
	public static volatile SingularAttribute<Usuario, Nacionalidad> idnacionalidad;
	public static volatile SingularAttribute<Usuario, String> identificacion;
	public static volatile SingularAttribute<Usuario, String> razonEgreso;
	public static volatile CollectionAttribute<Usuario, Asignacionperfil> asignacionperfilCollection;
	public static volatile SingularAttribute<Usuario, Integer> idusuario;
	public static volatile SingularAttribute<Usuario, String> oficio;
	public static volatile SingularAttribute<Usuario, byte[]> foto;
	public static volatile SingularAttribute<Usuario, String> nivelInstruccion;
	public static volatile SingularAttribute<Usuario, String> profesion;
	public static volatile SingularAttribute<Usuario, Genero> idgenero;

}

