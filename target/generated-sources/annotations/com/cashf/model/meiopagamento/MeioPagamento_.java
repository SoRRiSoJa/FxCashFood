package com.cashf.model.meiopagamento;

import com.cashf.model.contacorrente.ContaCorrente;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(MeioPagamento.class)
public abstract class MeioPagamento_ {

	public static volatile SingularAttribute<MeioPagamento, BigDecimal> taxa;
	public static volatile SingularAttribute<MeioPagamento, ContaCorrente> contaCorrente;
	public static volatile SingularAttribute<MeioPagamento, Long> idMeio;
	public static volatile SingularAttribute<MeioPagamento, TPPagto> tipoPagto;
	public static volatile SingularAttribute<MeioPagamento, Integer> prazoRecebimento;
	public static volatile SingularAttribute<MeioPagamento, String> descricao;

}

