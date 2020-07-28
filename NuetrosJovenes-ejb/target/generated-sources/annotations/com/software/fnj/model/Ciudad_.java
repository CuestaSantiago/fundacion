package com.software.fnj.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Ciudad.class)
public abstract class Ciudad_ {

	public static volatile SingularAttribute<Ciudad, String> paisCodigo;
	public static volatile SingularAttribute<Ciudad, String> ciudad;
	public static volatile SingularAttribute<Ciudad, Integer> idciudad;
	public static volatile CollectionAttribute<Ciudad, Usuario> usuarioCollection;

}

