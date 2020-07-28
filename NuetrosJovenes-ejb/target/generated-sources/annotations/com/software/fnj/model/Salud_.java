package com.software.fnj.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Salud.class)
public abstract class Salud_ {

	public static volatile SingularAttribute<Salud, byte[]> foto;
	public static volatile SingularAttribute<Salud, Integer> idsalud;
	public static volatile SingularAttribute<Salud, String> condicionMedica;
	public static volatile SingularAttribute<Salud, Integer> estadoDiscapacidad;
	public static volatile SingularAttribute<Salud, Usuario> idusuario;

}

