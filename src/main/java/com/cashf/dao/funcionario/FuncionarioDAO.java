/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashf.dao.funcionario;

import com.cashf.model.funcionario.Funcionario;
import dao.GenericDAOIMP;

/**
 *
 * @author Aluno
 */
public class FuncionarioDAO extends GenericDAOIMP<Funcionario>{

    public FuncionarioDAO(Class<Funcionario> clazz) {
        super(Funcionario.class);
    }
    
    
}
