/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashf.dao.produto;

import com.cashf.model.produto.Grupo;
import dao.GenericDAOIMP;

/**
 *
 * @author joao
 */
public class GrupoDAO extends GenericDAOIMP<Grupo> {

    public GrupoDAO(Class<Grupo> clazz) {
        super(Grupo.class);
    }

}
