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
public enum TipoProduto {
    FICHA_TECNICA("Ficha Técnica"),INSUMO("Insumo"),
    MERCADORIA("Mercadoria"),PRE_PREPARO("Pré-preparo"),
    COMBO("Combo");
    
    private final String descricao;

    private TipoProduto(String desc) {
        this.descricao = desc;
    }

    @Override
    public String toString() {
        return this.descricao;
    }    

}
