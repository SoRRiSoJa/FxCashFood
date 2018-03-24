/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashf.model.meiopagamento;

import com.cashf.model.contacorrente.ContaCorrente;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
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
@Table(name = "meio_pagamento")
public class MeioPagamento implements Serializable {

    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Id
    @Column(columnDefinition = "serial")
    private long idMeio;
    private String descricao;
    private Integer prazoRecebimento;
    private BigDecimal taxa;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TPPagto tipoPagto;
    @ManyToOne(cascade = CascadeType.ALL,fetch=FetchType.EAGER)
    @JoinColumn(nullable = false)
    private ContaCorrente contaCorrente;
    public MeioPagamento() {
    }

    public MeioPagamento(long id, String descricao, Integer prazoRecebimento,BigDecimal taxa, TPPagto tipoPagto, ContaCorrente contaCorrente) {
        this.idMeio = id;
        this.descricao = descricao;
        this.prazoRecebimento = prazoRecebimento;
        this.tipoPagto = tipoPagto;
        this.contaCorrente = contaCorrente;
        this.taxa=taxa;
    }

   
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getPrazoRecebimento() {
        return prazoRecebimento;
    }

    public void setPrazoRecebimento(Integer prazoRecebimento) {
        this.prazoRecebimento = prazoRecebimento;
    }

    public TPPagto getTipoPagto() {
        return tipoPagto;
    }

    public void setTipoPagto(TPPagto tipoPagto) {
        this.tipoPagto = tipoPagto;
    }

    public ContaCorrente getContaCorrente() {
        return contaCorrente;
    }

    public void setContaCorrente(ContaCorrente contaCorrente) {
        this.contaCorrente = contaCorrente;
    }

    public long getIdMeio() {
        return idMeio;
    }

    public void setIdMeio(long idMeio) {
        this.idMeio = idMeio;
    }

    public BigDecimal getTaxa() {
        return taxa;
    }

    public void setTaxa(BigDecimal taxa) {
        this.taxa = taxa;
    }
    
    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 73 * hash + (int) (this.idMeio ^ (this.idMeio >>> 32));
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
        final MeioPagamento other = (MeioPagamento) obj;
        if (this.idMeio != other.idMeio) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.descricao;
    }

}
