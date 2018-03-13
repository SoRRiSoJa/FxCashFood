/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashf.model.contasPagar;

/**
 *
 * @author joao
 */
public enum StatusPagto {
    PAGO("PAGO"), ABERTO("EM ABERTO"),CANCELADA("CANCELADA");

    private final String descricao;

    private StatusPagto(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return descricao;
    }
    

}
