/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashf.dao.parametros;

import com.cashf.model.parametros.ParametrosFiscais;
import com.cashf.model.produto.SituacaoTributaria;
import dao.GenericDAOIMP;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 *
 * @author joao
 */
public class ParametrosFiscaisDAO extends GenericDAOIMP<ParametrosFiscais> {

    public ParametrosFiscaisDAO(Class<ParametrosFiscais> clazz) {
        super(clazz);
    }

    public List<ParametrosFiscais> listBySituacaoTributaria(SituacaoTributaria st) {
        try (Session session = sessionFactory.openSession()) {
            String hql = "from ParametrosFiscais pf where pf.situacaoTributaria like '" + st.name() + "'";
            List<ParametrosFiscais> roleList = session.createQuery(hql).list();
            return roleList;
        } catch (Exception e) {
            System.out.println("Erro:" + e);
            return null;
        }
    }
    public ParametrosFiscais getBySituacaoTributaria(String st) {
        try (Session session = sessionFactory.openSession()) {
            String hql = "from ParametrosFiscais pf where pf.situacaoTributaria like :st";
            Query query = session.createQuery(hql);
            query.setParameter("st", st);
            return (ParametrosFiscais) query.getSingleResult();
        } catch (Exception e) {
            System.out.println("Erro:" + e);
            return null;
        }

    }
}
