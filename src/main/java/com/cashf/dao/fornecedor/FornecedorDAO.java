/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashf.dao.fornecedor;

import com.cashf.model.fornecedor.Fornecedor;
import dao.GenericDAOIMP;

/**
 *
 * @author joao
 */
public class FornecedorDAO extends GenericDAOIMP<Fornecedor>{

    public FornecedorDAO(Class<Fornecedor> clazz) {
        super(Fornecedor.class);
    }
    

    
}
