/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashf.model.pessoa;

/**
 *
 * @author joao
 */
public enum Sexo {
    F("Feminino"), M("Masculino");
    private String descricao;

    private Sexo(String desc) {
        this.descricao = desc;
    }

    @Override
    public String toString() {
        return this.descricao;
    }
}
