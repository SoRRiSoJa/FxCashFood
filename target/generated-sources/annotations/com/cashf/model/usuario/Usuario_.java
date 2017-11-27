package com.cashf.model.usuario;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Usuario.class)
public abstract class Usuario_ {

	public static volatile SingularAttribute<Usuario, String> senha;
	public static volatile SingularAttribute<Usuario, Long> idUsuario;
	public static volatile SingularAttribute<Usuario, String> login;
	public static volatile SingularAttribute<Usuario, UNivel> nivel;
	public static volatile SingularAttribute<Usuario, Boolean> status;

}

