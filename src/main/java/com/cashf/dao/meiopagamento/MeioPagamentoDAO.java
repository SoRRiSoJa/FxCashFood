/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashf.dao.meiopagamento;

import com.cashf.model.meiopagamento.MeioPagamento;
import dao.GenericDAOIMP;

/**
 *
 * @author joao
 */
public class MeioPagamentoDAO extends GenericDAOIMP<MeioPagamento> {

    public MeioPagamentoDAO(Class<MeioPagamento> clazz) {
        super(MeioPagamento.class);
    }

}
