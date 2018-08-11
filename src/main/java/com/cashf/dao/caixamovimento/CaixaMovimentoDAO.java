/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashf.dao.caixamovimento;

import com.cashf.model.caixa.Caixa;
import com.cashf.model.caixa.CaixaMovimento;
import dao.GenericDAOIMP;
import java.time.LocalDate;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author joao
 */
public class CaixaMovimentoDAO extends GenericDAOIMP<CaixaMovimento> {

    public CaixaMovimentoDAO(Class<CaixaMovimento> clazz) {
        super(clazz);
    }

    public List<CaixaMovimento> listByDAndCaixa(LocalDate dataMov, Caixa caixaAberto) {
        try (Session session = sessionFactory.openSession()) {
            String hql = "from CaixaMovimento cax where Extract(DAY from cax.dataMovimento) >= :dia"
                    + " and Extract(MONTH from cax.dataMovimento) >= :mes"
                    + " and Extract(YEAR from cax.dataMovimento) >= :ano"
                    + " and caixa.idCaixa = :idCaixaA ";

            List<CaixaMovimento> roleList = session.createQuery(hql)
                    .setParameter("dia", dataMov.getDayOfMonth())
                    .setParameter("mes", dataMov.getMonth().getValue())
                    .setParameter("ano", dataMov.getYear())
                    .setParameter("idCaixaA", caixaAberto.getIdCaixa())
                    .list();
            return roleList;
        } catch (Exception e) {
            System.out.println("Erro:" + e);
            return null;
        }
    }
    public List<CaixaMovimento> listByDateAndCaixa(LocalDate dataMov, Caixa caixaAberto) {
        try (Session session = sessionFactory.openSession()) {
            String hql = "from CaixaMovimento cax where cax.dataMovimento>=:dataInicio"
                    + " and caixa.idCaixa = :idCaixaA ";

            List<CaixaMovimento> roleList = session.createQuery(hql)
                    .setParameter("dataInicio", dataMov)
                    .setParameter("idCaixaA", caixaAberto.getIdCaixa())
                    .list();
            return roleList;
        } catch (Exception e) {
            System.out.println("Erro:" + e);
            return null;
        }
    }
    

}
