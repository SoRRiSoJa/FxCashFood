/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashf.model.contacorrente;

import com.cashf.model.banco.Banco;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author joao
 */
@Entity
@Table(name = "conta_corrente")
public class ContaCorrente implements Serializable {

    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(columnDefinition = "serial")
    @Id
    private Long idConta;
    private String descricao;
    private String agencia;
    private String contaCorrente;
    @ManyToOne
    @JoinColumn(nullable = false)
    private Banco banco;

    public ContaCorrente() {
    }

    public ContaCorrente(Long idConta, String descricao, String agencia, String contaCorrente, Banco banco) {
        this.idConta = idConta;
        this.descricao = descricao;
        this.agencia = agencia;
        this.contaCorrente = contaCorrente;
        this.banco = banco;
    }

    public Long getId() {
        return idConta;
    }

    public void setId(Long id) {
        this.idConta = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public String getContaCorrente() {
        return contaCorrente;
    }

    public void setContaCorrente(String contaCorrente) {
        this.contaCorrente = contaCorrente;
    }

    public Banco getBanco() {
        return banco;
    }

    public void setBanco(Banco banco) {
        this.banco = banco;
    }

    @Override
    public String toString() {
        return this.descricao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idConta != null ? idConta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(obj instanceof ContaCorrente)) {
            return false;
        }
        ContaCorrente other = (ContaCorrente) obj;
        if ((this.idConta == null && other.idConta != null) || (this.idConta != null && !this.idConta.equals(other.idConta))) {
            return false;
        }
        return true;
    }

}
