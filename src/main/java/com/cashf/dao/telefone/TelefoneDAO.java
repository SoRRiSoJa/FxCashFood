/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashf.dao.telefone;

import com.cashf.model.telefone.Telefone;
import dao.GenericDAOIMP;

/**
 *
 * @author joao
 */
public class TelefoneDAO  extends GenericDAOIMP<Telefone> {

    public TelefoneDAO(Class<Telefone> clazz) {
        super(Telefone.class);
    }
    
}
