/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashf.dao.produto;

import com.cashf.model.produto.Grupo;
import dao.GenericDAOIMP;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author joao
 */
public class GrupoDAO extends GenericDAOIMP<Grupo> {

    public GrupoDAO(Class<Grupo> clazz) {
        super(Grupo.class);
    }
    public List<Grupo> listNotInsumos() {
        try (Session session = sessionFactory.openSession()) {
            String hql = "from Grupo gru where gru.descricao NOT like 'INSUMOS'";
            List<Grupo> roleList = session.createQuery(hql).list();
            return roleList;
        } catch (Exception e) {
            System.out.println("Erro:" + e);
            return null;
        }

    }

}
