/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashf.dao.caixa;

import com.cashf.model.caixa.Caixa;
import dao.GenericDAOIMP;

/**
 *
 * @author joao
 */
public class CaixaDAO extends  GenericDAOIMP<Caixa>{

    public CaixaDAO(Class<Caixa> clazz) {
        super(clazz);
    }
    
}
