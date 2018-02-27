/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashf.dao.produto;

import com.cashf.model.produto.Produto;
import dao.GenericDAOIMP;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author joao
 */
public class ProdutoDAO extends GenericDAOIMP<Produto> {

    public ProdutoDAO(Class<Produto> clazz) {
        super(Produto.class);
    }

    public List<Produto> listProdNotFicha() {
        try (Session session = sessionFactory.openSession()) {
            String hql = "from Produto prod where prod.tipo NOT like 'FICHA_TECNICA'";
            List<Produto> roleList = session.createQuery(hql).list();
            return roleList;
        } catch (Exception e) {
            System.out.println("Erro:" + e);
            return null;
        }

    }

    public List<Produto> listProdInsumos() {
        try (Session session = sessionFactory.openSession()) {
            String hql = "from Produto prod where prod.tipo like 'INSUMO'";
            List<Produto> roleList = session.createQuery(hql).list();
            return roleList;
        } catch (Exception e) {
            System.out.println("Erro:" + e);
            return null;
        }
    }

    public List<Produto> listProdPrePreparo() {
        try (Session session = sessionFactory.openSession()) {
            String hql = "from Produto prod where prod.tipo like 'PRE_PREPARO'";
            List<Produto> roleList = session.createQuery(hql).list();
            return roleList;
        } catch (Exception e) {
            System.out.println("Erro:" + e);
            return null;
        }
    }

    public List<Produto> listProdFichaTecnica() {
        try (Session session = sessionFactory.openSession()) {
            String hql = "from Produto prod where prod.tipo like 'FICHA_TECNICA'";
            List<Produto> roleList = session.createQuery(hql).list();
            return roleList;
        } catch (Exception e) {
            System.out.println("Erro:" + e);
            return null;
        }
    }
     public List<Produto> listByDesc(String desc) {
        try (Session session = sessionFactory.openSession()) {
            String hql = "from Produto prod where prod.descricao like '" + desc + "%'";
            List<Produto> roleList = session.createQuery(hql).list();
            return roleList;
        } catch (Exception e) {
            System.out.println("Erro:" + e);
            return null;
        }
    }
     public List<Produto> listByGrupo(String grup) {
        try (Session session = sessionFactory.openSession()) {
            String hql = "from Produto prod where prod.grupo like '" + grup + "%'";
            List<Produto> roleList = session.createQuery(hql).list();
            return roleList;
        } catch (Exception e) {
            System.out.println("Erro:" + e);
            return null;
        }
    }

}
