/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashf.dao.cliente;

import com.cashf.model.cliente.Cliente;
import dao.GenericDAOIMP;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author joao
 */
public class ClienteDAO extends GenericDAOIMP<Cliente> {

    public ClienteDAO(Class<Cliente> clazz) {
        super(clazz);
    }
    public List<Cliente> listByName(String name) {
        try (Session session = sessionFactory.openSession()) {
            String hql = "from Cliente cli where cli.nome like '"+name+"%'";
            List<Cliente> roleList = session.createQuery(hql).list();
            return roleList;
        } catch (Exception e) {
            System.out.println("Erro:" + e);
            return null;
        }
    }
    public List<Cliente> listByCPF(String CPF) {
        try (Session session = sessionFactory.openSession()) {
            String hql = "from Cliente cli where cli.cpf like '"+CPF+"%'";
            List<Cliente> roleList = session.createQuery(hql).list();
            return roleList;
        } catch (Exception e) {
            System.out.println("Erro:" + e);
            return null;
        }
    }
}
