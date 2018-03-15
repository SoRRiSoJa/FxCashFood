/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashf.model.caixa;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "caixa_movimento")
public class CaixaMovimento implements Serializable{
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Id
    @Column(columnDefinition = "serial")
    private long idCaixaMovimento;
    private LocalDate dataMovimento;
    private String observacao;
    private BigDecimal valor;
    private TPMov tipoMovimento;
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(nullable = false)
    private Caixa caixa;

    public CaixaMovimento() {
    }

    public CaixaMovimento(long idCaixaMovimento, LocalDate data, String observacao, BigDecimal valor, TPMov tipoMovimento, Caixa caixa) {
        this.idCaixaMovimento = idCaixaMovimento;
        this.dataMovimento = data;
        this.observacao = observacao;
        this.valor = valor;
        this.tipoMovimento = tipoMovimento;
        this.caixa = caixa;
    }

    public long getIdCaixaMovimento() {
        return idCaixaMovimento;
    }

    public void setIdCaixaMovimento(long idCaixaMovimento) {
        this.idCaixaMovimento = idCaixaMovimento;
    }

    public LocalDate getDataMovimento() {
        return dataMovimento;
    }

    public void setDataMovimento(LocalDate dataMovimento) {
        this.dataMovimento = dataMovimento;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public TPMov getTipoMovimento() {
        return tipoMovimento;
    }

    public void setTipoMovimento(TPMov tipoMovimento) {
        this.tipoMovimento = tipoMovimento;
    }

    public Caixa getCaixa() {
        return caixa;
    }

    public void setCaixa(Caixa caixa) {
        this.caixa = caixa;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + (int) (this.idCaixaMovimento ^ (this.idCaixaMovimento >>> 32));
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
        final CaixaMovimento other = (CaixaMovimento) obj;
        if (this.idCaixaMovimento != other.idCaixaMovimento) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return observacao;
    }
    
    
}
