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
public enum SituacaoTributaria  {
    NAO_INCIDENTE("Não Incidente"),SERVICO("Serviço"),
    SUBSTITUICAO_TRIBUTARIA("Subistituição tributária"),
    ISENTO("Isento"),
    TRIBUTADO("Tributado");

    private final String descricao;

    private SituacaoTributaria(String desc) {
        this.descricao = desc;
    }

    @Override
    public String toString() {
        return this.descricao;
    }
}
