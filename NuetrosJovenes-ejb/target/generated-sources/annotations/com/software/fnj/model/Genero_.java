package com.software.fnj.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Genero.class)
public abstract class Genero_ {

	public static volatile SingularAttribute<Genero, String> descripcion;
	public static volatile CollectionAttribute<Genero, Usuario> usuarioCollection;
	public static volatile SingularAttribute<Genero, Integer> idgenero;

}

