/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashf.dao.combo;

import com.cashf.model.combo.Combo;
import com.cashf.model.produto.Produto;
import dao.GenericDAOIMP;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author joao
 */
public class ComboDAO extends GenericDAOIMP<Combo> {

    public ComboDAO(Class<Combo> clazz) {
        super(clazz);
    }
    public List<Combo> listProdInsumos(Produto produto) {
        try (Session session = sessionFactory.openSession()) {
            String hql = "from Combo cmb where cmb.produtoPrincipal.idProduto ="+produto.getIdProduto()+"";
            List<Combo> roleList = session.createQuery(hql).list();
            return roleList;
        } catch (Exception e) {
            System.out.println("Erro:" + e);
            return null;
        }
    }

}
