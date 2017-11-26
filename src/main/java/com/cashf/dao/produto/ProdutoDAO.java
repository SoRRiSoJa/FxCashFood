/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashf.dao.produto;

import com.cashf.model.produto.Produto;
import dao.GenericDAOIMP;

/**
 *
 * @author joao
 */
public class ProdutoDAO extends GenericDAOIMP<Produto> {

    public ProdutoDAO(Class<Produto> clazz) {
        super(Produto.class);
    }
    
}
