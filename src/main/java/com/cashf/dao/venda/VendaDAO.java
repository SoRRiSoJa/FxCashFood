/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashf.dao.venda;

import com.cashf.model.venda.Venda;
import dao.GenericDAOIMP;

/**
 *
 * @author joao
 */
public class VendaDAO extends GenericDAOIMP<Venda> {

    public VendaDAO(Class<Venda> clazz) {
        super(clazz);
    }

}
