/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashf.dao.funcionario;

import com.cashf.model.funcionario.Funcionario;
import dao.GenericDAOIMP;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Aluno
 */
public class FuncionarioDAO extends GenericDAOIMP<Funcionario>{

    public FuncionarioDAO(Class<Funcionario> clazz) {
        super(Funcionario.class);
    }
     public List<Funcionario> listByName(String name) {
        try (Session session = sessionFactory.openSession()) {
            String hql = "from Funcionario fun where fun.nome like '"+name+"%'";
            List<Funcionario> roleList = session.createQuery(hql).list();
            return roleList;
        } catch (Exception e) {
            System.out.println("Erro:" + e);
            return null;
        }
    }
    public List<Funcionario> listByCPF(String CPF) {
        try (Session session = sessionFactory.openSession()) {
            String hql = "from Funcionario fun where fun.cpf like '"+CPF+"%'";
            List<Funcionario> roleList = session.createQuery(hql).list();
            return roleList;
        } catch (Exception e) {
            System.out.println("Erro:" + e);
            return null;
        }
    }
    
}
