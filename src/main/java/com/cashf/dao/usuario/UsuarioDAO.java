/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashf.dao.usuario;

import com.cashf.model.usuario.Usuario;
import dao.GenericDAOIMP;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 *
 * @author joao
 */
public class UsuarioDAO extends GenericDAOIMP<Usuario> {

    public UsuarioDAO(Class<Usuario> clazz) {
        super(Usuario.class);
    }

    public Usuario findByLogin(String login) {
        try (Session session = sessionFactory.openSession()) {
            String hql = "from Usuario user where user.login like :userLogin";
            Query query = session.createQuery(hql);
            query.setParameter("userLogin", login);
            return (Usuario) query.getSingleResult();
        } catch (Exception e) {
            System.out.println("Erro:" + e);
            return null;
        }

    }
}
