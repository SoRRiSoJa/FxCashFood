/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashf.dao.fornecedor;

import com.cashf.model.fornecedor.Fornecedor;
import dao.GenericDAOIMP;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author joao
 */
public class FornecedorDAO extends GenericDAOIMP<Fornecedor> {

    public FornecedorDAO(Class<Fornecedor> clazz) {
        super(Fornecedor.class);
    }

    public List<Fornecedor> listByName(String name) {
        try (Session session = sessionFactory.openSession()) {
            String hql = "from Fornecedor fone where forne.nomefantasia like '" + name + "%'";
            List<Fornecedor> roleList = session.createQuery(hql).list();
            return roleList;
        } catch (Exception e) {
            System.out.println("Erro:" + e);
            return null;
        }
    }

    public List<Fornecedor> listByRazao(String Razao) {
        try (Session session = sessionFactory.openSession()) {
            String hql = "from Fornecedor forne where forne.razaosocial like '" + Razao + "%'";
            List<Fornecedor> roleList = session.createQuery(hql).list();
            return roleList;
        } catch (Exception e) {
            System.out.println("Erro:" + e);
            return null;
        }
    }

}
