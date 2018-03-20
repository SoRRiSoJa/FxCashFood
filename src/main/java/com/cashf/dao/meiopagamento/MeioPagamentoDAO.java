/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashf.dao.meiopagamento;

import com.cashf.model.meiopagamento.MeioPagamento;
import com.cashf.model.meiopagamento.TPPagto;
import dao.GenericDAOIMP;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 *
 * @author joao
 */
public class MeioPagamentoDAO extends GenericDAOIMP<MeioPagamento> {

    public MeioPagamentoDAO(Class<MeioPagamento> clazz) {
        super(MeioPagamento.class);
        
    }
     public MeioPagamento getMPDinheiro() {
        try (Session session = sessionFactory.openSession()) {
            String hql = "from MeioPagamento mp where mp.tipoPagto like :tPagto";
            Query query = session.createQuery(hql);
            query.setParameter("tPagto", TPPagto.DINHEIRO);
            return (MeioPagamento) query.getSingleResult();
        } catch (Exception e) {
            System.out.println("Erro:" + e);
            return null;
        }

    }

}
