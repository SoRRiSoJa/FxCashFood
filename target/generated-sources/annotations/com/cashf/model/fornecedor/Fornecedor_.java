package com.cashf.model.fornecedor;

import com.cashf.model.cidade.Cidade;
import com.cashf.model.telefone.Telefone;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Fornecedor.class)
public abstract class Fornecedor_ {

	public static volatile SingularAttribute<Fornecedor, Cidade> cidade;
	public static volatile SingularAttribute<Fornecedor, Long> idFornecedor;
	public static volatile SingularAttribute<Fornecedor, String> endereco;
	public static volatile SingularAttribute<Fornecedor, Integer> numero;
	public static volatile SingularAttribute<Fornecedor, String> bairro;
	public static volatile SingularAttribute<Fornecedor, String> cnpj;
	public static volatile ListAttribute<Fornecedor, Telefone> telefones;
	public static volatile SingularAttribute<Fornecedor, String> cep;
	public static volatile SingularAttribute<Fornecedor, String> complemento;
	public static volatile SingularAttribute<Fornecedor, String> Observacao;
	public static volatile SingularAttribute<Fornecedor, String> nomefantasia;
	public static volatile SingularAttribute<Fornecedor, String> razaoSocial;
	public static volatile SingularAttribute<Fornecedor, String> email;

}

