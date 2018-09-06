/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashf.dao.fichatecnica;

import com.cashf.model.fichatecnica.FichaTecnica;
import com.cashf.model.produto.Produto;
import dao.GenericDAOIMP;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 *
 * @author joao
 */
public class FichaTecnicaDAO extends GenericDAOIMP<FichaTecnica> {

    public FichaTecnicaDAO(Class<FichaTecnica> clazz) {
        super(clazz);
    }

    public FichaTecnica getByProduto(Produto produto) {
        try (Session session = sessionFactory.openSession()) {
            String hql = "from FichaTecnica ft where fl.produtoPrincipal.IdProduto like :produtoId";
            Query query = session.createQuery(hql);
            query.setParameter("produtoId", produto.getIdProduto());
            return (FichaTecnica) query.getSingleResult();
        } catch (Exception e) {
            System.out.println("Erro:" + e);
            return null;
        }

    }

}
