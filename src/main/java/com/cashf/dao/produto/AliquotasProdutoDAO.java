/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashf.dao.produto;

import com.cashf.model.produto.AliquotasProduto;
import dao.GenericDAOIMP;

/**
 *
 * @author joao
 */
public class AliquotasProdutoDAO extends GenericDAOIMP<AliquotasProduto>{

    public AliquotasProdutoDAO(Class<AliquotasProduto> clazz) {
        super(AliquotasProduto.class);
    }
    
}
