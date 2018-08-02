/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashf.dao.contaspagar;

import com.cashf.model.caixa.Caixa;
import com.cashf.model.contasPagar.ContaPagar;
import com.cashf.model.contasPagar.StatusPagto;
import dao.GenericDAOIMP;
import java.math.BigDecimal;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author joao
 */
public class ContaPagarDAO extends GenericDAOIMP<ContaPagar> {

    public ContaPagarDAO(Class<ContaPagar> clazz) {
        super(clazz);
    }

    public BigDecimal getTotalContas(Caixa caixa) {
        try (Session session = sessionFactory.openSession()) {
            Criteria criteria = session.createCriteria(ContaPagar.class)
                    .setProjection(Projections.sum("this.valorPago"))
                    .add(Restrictions.eq("this.caixa.idCaixa", caixa.getIdCaixa()))
                    .add(Restrictions.eq("this.statusPagto", StatusPagto.PAGO));
            return (BigDecimal) criteria.uniqueResult();

        } catch (Exception e) {
            System.out.println("Erro:" + e);
            return BigDecimal.ZERO;
        }
    }

}
