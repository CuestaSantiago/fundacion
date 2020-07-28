package com.software.fnj.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Documento.class)
public abstract class Documento_ {

	public static volatile SingularAttribute<Documento, String> tipoDocumento;
	public static volatile SingularAttribute<Documento, Integer> iddocumento;
	public static volatile SingularAttribute<Documento, byte[]> documento;
	public static volatile SingularAttribute<Documento, String> observacion;
	public static volatile SingularAttribute<Documento, Usuario> idusuario;

}

