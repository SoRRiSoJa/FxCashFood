/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashf.model.mesa;

/**
 *
 * @author joao
 */
public enum StatusMesa {
    ABERTA("ABERTA"), FECHADA("FECHADA"), DISPONIVEL("DISPONÍVEL");

    private final String descricao;

    private StatusMesa(String desc) {
        this.descricao = desc;
    }

    @Override
    public String toString() {
        return descricao;
    }

}
