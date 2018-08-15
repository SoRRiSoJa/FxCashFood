/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashf.dao.estado;

import com.cashf.model.estado.Estado;
import dao.GenericDAOIMP;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author joao
 */
public class EstadoDAO extends GenericDAOIMP<Estado> {

    public EstadoDAO(Class<Estado> clazz) {
        super(clazz);
    }

    public void saveEst(Estado obj) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(obj);
            tx.commit();
            session.refresh(obj);
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }

    }

}
