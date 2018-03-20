/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashf.dao.caixa;

import com.cashf.model.caixa.Caixa;
import com.cashf.model.caixa.TPStatusCX;
import dao.GenericDAOIMP;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 *
 * @author joao
 */
public class CaixaDAO extends  GenericDAOIMP<Caixa>{

    public CaixaDAO(Class<Caixa> clazz) {
        super(clazz);
    }
    public Caixa getCaixaAberto() {
        try (Session session = sessionFactory.openSession()) {
            String hql = "from Caixa cx where cx.status like :status";
            Query query = session.createQuery(hql);
            query.setParameter("status", TPStatusCX.ABERTO);
            return (Caixa) query.getSingleResult();
        } catch (Exception e) {
            System.out.println("Erro:" + e);
            return null;
        }

    }
}
