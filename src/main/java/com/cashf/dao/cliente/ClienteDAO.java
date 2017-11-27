/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashf.dao.cliente;

import com.cashf.model.cliente.Cliente;
import dao.GenericDAOIMP;

/**
 *
 * @author joao
 */
public class ClienteDAO extends GenericDAOIMP<Cliente> {

    public ClienteDAO(Class<Cliente> clazz) {
        super(clazz);
    }

}
