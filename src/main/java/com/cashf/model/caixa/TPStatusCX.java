/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashf.model.caixa;

/**
 *
 * @author joao
 */
public enum TPStatusCX {
    ABERTO("Aberto"), FECHADO("Fechado"), CONCILIADO("Conciliado");
    private String descricao;

    private TPStatusCX(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return descricao;
    }

}
