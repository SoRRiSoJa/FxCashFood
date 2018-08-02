/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashf.dao.estado;

import com.cashf.model.estado.Estado;
import dao.GenericDAOIMP;

/**
 *
 * @author joao
 */
public class EstadoDAO extends GenericDAOIMP<Estado>{

    public EstadoDAO(Class<Estado> clazz) {
        super(clazz);
    }
    
}
