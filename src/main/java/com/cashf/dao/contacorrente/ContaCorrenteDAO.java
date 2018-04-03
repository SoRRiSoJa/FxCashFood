/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashf.dao.contacorrente;

import com.cashf.model.contacorrente.ContaCorrente;
import dao.GenericDAOIMP;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author joao
 */
public class ContaCorrenteDAO extends GenericDAOIMP<ContaCorrente> {

    public ContaCorrenteDAO(Class<ContaCorrente> clazz) {
        super(clazz);
    }
    public List<ContaCorrente> listCcaixa() {
        try (Session session = sessionFactory.openSession()) {
            String hql = "from ContaCorrente cc where cc.cCaixa=TRUE";
            List<ContaCorrente> roleList = session.createQuery(hql).list();
            return roleList;
        } catch (Exception e) {
            System.out.println("Erro:" + e);
            return null;
        }
    }

}
