/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashf.model.produto;

/**
 *
 * @author joao
 */
public enum UnidadeMedida {
    l("Litro(l)"),
    ml("MiliLitro(ml)"),
    Kg("Quilograma(Kg)"),
    g("Grama(g)"),
    mg("MiliGrama(mg)");;
    
    private final String descricao;

    private UnidadeMedida(String desc) {
        this.descricao = desc;
    }

    @Override
    public String toString() {
        return this.descricao;
    }
}
