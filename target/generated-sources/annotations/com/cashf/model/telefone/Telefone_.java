package com.cashf.model.telefone;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Telefone.class)
public abstract class Telefone_ {

	public static volatile SingularAttribute<Telefone, String> numero;
	public static volatile SingularAttribute<Telefone, String> ddd;
	public static volatile SingularAttribute<Telefone, Long> idTelefone;
	public static volatile SingularAttribute<Telefone, Operadora> operadora;

}

