package com.software.fnj.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Pais.class)
public abstract class Pais_ {

	public static volatile SingularAttribute<Pais, String> codigo;
	public static volatile SingularAttribute<Pais, Integer> idpais;
	public static volatile CollectionAttribute<Pais, Usuario> usuarioCollection;
	public static volatile SingularAttribute<Pais, String> pais;

}

