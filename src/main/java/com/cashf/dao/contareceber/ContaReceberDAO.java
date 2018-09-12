/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashf.dao.contareceber;

import com.cashf.model.contareceber.ContaReceber;
import dao.GenericDAOIMP;
import java.time.LocalDate;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author joao
 */
public class ContaReceberDAO extends GenericDAOIMP<ContaReceber> {

    public ContaReceberDAO(Class<ContaReceber> clazz) {
        super(clazz);
    }
    public List<ContaReceber> listByPeriodo(LocalDate dataIni, LocalDate dataFin) {
        try (Session session = sessionFactory.openSession()) {
            String hql = "from ContaReceber crb where crb.dataVencimento between :dataIni and :dataFin "
                    + " ";

            List<ContaReceber> roleList = session.createQuery(hql)
                    .setParameter("dataIni", dataIni)
                    .setParameter("dataFin", dataFin)
                    .list();
            return roleList;
        } catch (Exception e) {
            System.out.println("Erro:" + e);
            return null;
        }
    }

}
