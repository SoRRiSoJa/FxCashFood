/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashf.model.meiopagamento;

/**
 *
 * @author joao
 */
public enum TPPagto {
    CARTAO_DEBITO("Cartão Débito"),CARTAO_CREDITO("Cartão de Crédito"),
    DINHEIRO("Dinheiro");
    
    private final String descricao;

    private TPPagto(String desc) {
        this.descricao = desc;
    }

    @Override
    public String toString() {
        return this.descricao;
    }    

}
