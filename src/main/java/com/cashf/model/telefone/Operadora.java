/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashf.model.telefone;

/**
 *
 * @author joao
 */
public enum Operadora {
    VIVO("Vivo"),OI("Oi"),
    TIM("Tim"),
    CLARO("Claro"),
    NEXTEL("Nextel");
    
    private final String descricao;

    private Operadora(String desc) {
        this.descricao = desc;
    }

    @Override
    public String toString() {
        return this.descricao;
    }    

}
