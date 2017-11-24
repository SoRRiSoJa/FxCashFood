package com.cashf.model.contacorrente;

import com.cashf.model.banco.Banco;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ContaCorrente.class)
public abstract class ContaCorrente_ {

	public static volatile SingularAttribute<ContaCorrente, Long> idConta;
	public static volatile SingularAttribute<ContaCorrente, String> contaCorrente;
	public static volatile SingularAttribute<ContaCorrente, Banco> banco;
	public static volatile SingularAttribute<ContaCorrente, String> agencia;
	public static volatile SingularAttribute<ContaCorrente, String> descricao;

}

