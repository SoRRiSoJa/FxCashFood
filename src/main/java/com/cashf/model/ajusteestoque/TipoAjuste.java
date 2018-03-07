/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashf.model.ajusteestoque;

/**
 *
 * @author joao
 */
public enum TipoAjuste {
    E("ENTRADA"), S("SAÍDA");
    private String descricao;

    private TipoAjuste(String desc) {
        this.descricao = desc;
    }

    @Override
    public String toString() {
        return  this.descricao ;
    }
    
}
