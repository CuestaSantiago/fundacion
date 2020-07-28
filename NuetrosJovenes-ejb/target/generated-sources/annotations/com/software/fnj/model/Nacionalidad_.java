package com.software.fnj.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Nacionalidad.class)
public abstract class Nacionalidad_ {

	public static volatile SingularAttribute<Nacionalidad, String> gentilicio;
	public static volatile SingularAttribute<Nacionalidad, Integer> idnacionalidad;
	public static volatile CollectionAttribute<Nacionalidad, Usuario> usuarioCollection;
	public static volatile SingularAttribute<Nacionalidad, String> pais;
	public static volatile SingularAttribute<Nacionalidad, String> codigoPais;

}

