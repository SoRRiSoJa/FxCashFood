/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author joao
 */
public class GenericDAOIMP<T> implements GenericDAO<T> {

    private final Class<T> clazz;
    public final SessionFactory sessionFactory;

    protected GenericDAOIMP(Class<T> clazz) {
        this.clazz = clazz;
        this.sessionFactory = HibernateUtil.getSessionFactory();
    }

    @Override
    public Long save(T obj) {
        Long id=0L;
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            id=(Long)session.save(obj);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return id;
    }

    @Override
    public void update(T obj) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.saveOrUpdate(obj);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }

    }

    @Override
    public void delete(T obj) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.delete(obj);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }

    }

    @Override
    public T findById(long id) {
        Object obj = null;
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            obj = session.load(clazz, id);
            tx.commit();
        } catch (HibernateException e) {

        } finally {
//            
        }
        return (T) obj;
    }

    @Override
    public List<T> listAll() {
        try (Session session = sessionFactory.openSession()) {

            List<T> roleList = session.createQuery("from " + clazz.getName() + "").list();
            return roleList;

        } catch (HibernateException e) {

        }
        return null;
    }

   

}
