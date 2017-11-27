/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashf.model.cliente;

import com.cashf.model.cidade.Cidade;
import com.cashf.model.pessoa.Pessoa;
import com.cashf.model.pessoa.Sexo;
import com.cashf.model.telefone.Telefone;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 *
 * @author joao
 */
@Entity
@Table(name = "cliente")
@PrimaryKeyJoinColumn(name = "idPessoa")
public class Cliente extends Pessoa implements Serializable {
    private String observacao;

    public Cliente() {
        super();
    }

    public Cliente(Long id, String nome, Sexo sexo, LocalDate dataNas, String endereco, String bairro, Integer numero, String complemento, String cep, Cidade cidade, String cpf, String rg, String email, List<Telefone> telefones, Boolean status,String observacao) {
        super(id, nome, sexo, dataNas, endereco, bairro, numero, complemento, cep, cidade, cpf, rg, email, telefones, status);
        this.observacao = observacao;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 19 * hash + Objects.hashCode(this.getIdPessoa());
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cliente other = (Cliente) obj;
        if (!Objects.equals(this.getIdPessoa(), other.getIdPessoa())) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.getNome();
    }

}
