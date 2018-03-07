/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashf.dao.parametros;

import com.cashf.model.parametros.Parametros;
import dao.GenericDAOIMP;

/**
 *
 * @author joao
 */
public class ParametrosDAO extends GenericDAOIMP<Parametros>{

    public ParametrosDAO(Class<Parametros> clazz) {
        super(Parametros.class);
    }
    
}
