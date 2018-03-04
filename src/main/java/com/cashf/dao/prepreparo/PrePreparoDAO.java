/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashf.dao.prepreparo;

import com.cashf.model.prepreparo.PrePreparo;
import dao.GenericDAOIMP;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author joao
 */
public class PrePreparoDAO extends GenericDAOIMP<PrePreparo> {

    public PrePreparoDAO(Class<PrePreparo> clazz) {
        super(clazz);
    }
    public List<PrePreparo> listByDesc(String desc) {
        try (Session session = sessionFactory.openSession()) {
            String hql = "from PrePreparo pre where pre.produtoPrincipal.descricao like '" + desc + "%'";
            List<PrePreparo> roleList = session.createQuery(hql).list();
            return roleList;
        } catch (Exception e) {
            System.out.println("Erro:" + e);
            return null;
        }
    }
    public List<PrePreparo> listByDate(LocalDate date) {
        try (Session session = sessionFactory.openSession()) {
            String hql = "from PrePreparo pre where pre.produtoPrincipal.descricao like '" + date.format(DateTimeFormatter.ISO_LOCAL_DATE) + "%'";
            List<PrePreparo> roleList = session.createQuery(hql).list();
            return roleList;
        } catch (Exception e) {
            System.out.println("Erro:" + e);
            return null;
        }
    }

}
