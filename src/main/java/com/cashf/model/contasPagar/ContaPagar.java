/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashf.model.contasPagar;

import com.cashf.model.caixa.Caixa;
import com.cashf.model.meiopagamento.MeioPagamento;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
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
@Table(name = "contas_pagar")
public class ContaPagar implements Serializable {

    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Id
    @Column(columnDefinition = "serial")
    private long idContaPagar;
    @Column(columnDefinition = "DATE")
    private LocalDate dataVencimento;
    @Column(columnDefinition = "DATE")
    private LocalDate dataPagamento;
    private String favorecido;
    private String descricao;
    private BigDecimal valorBruto;
    private BigDecimal encargos;
    private BigDecimal desconto;
    private BigDecimal acrecimo;
    private BigDecimal valorPago;
    @ManyToOne
    @JoinColumn(nullable = false)
    private MeioPagamento meioPagamento;
    @ManyToOne
    @JoinColumn(nullable = false)
    private Caixa caixa;
    private StatusPagto status;

    public ContaPagar() {
    }

    public ContaPagar(long idContaPagar, LocalDate dataVencimento, LocalDate dataPagamento, String favorecido, String descricao, BigDecimal valorBruto, BigDecimal encargos, BigDecimal desconto,BigDecimal acrecimo, BigDecimal valorPago, MeioPagamento meioPagamento, Caixa caixa, StatusPagto status) {
        this.idContaPagar = idContaPagar;
        this.dataVencimento = dataVencimento;
        this.dataPagamento = dataPagamento;
        this.favorecido = favorecido;
        this.descricao = descricao;
        this.valorBruto = valorBruto;
        this.encargos = encargos;
        this.desconto = desconto;
        this.acrecimo=acrecimo;
        this.valorPago = valorPago;
        this.meioPagamento = meioPagamento;
        this.caixa = caixa;
        this.status = status;
    }

    public long getIdContaPagar() {
        return idContaPagar;
    }

    public void setIdContaPagar(long idContaPagar) {
        this.idContaPagar = idContaPagar;
    }

    public LocalDate getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(LocalDate dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public LocalDate getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(LocalDate dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public String getFavorecido() {
        return favorecido;
    }

    public void setFavorecido(String favorecido) {
        this.favorecido = favorecido;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getValorBruto() {
        return valorBruto;
    }

    public void setValorBruto(BigDecimal valorBruto) {
        this.valorBruto = valorBruto;
    }

    public BigDecimal getEncargos() {
        return encargos;
    }

    public void setEncargos(BigDecimal encargos) {
        this.encargos = encargos;
    }

    public BigDecimal getDesconto() {
        return desconto;
    }

    public void setDesconto(BigDecimal desconto) {
        this.desconto = desconto;
    }

    public BigDecimal getValorPago() {
        return valorPago;
    }

    public void setValorPago(BigDecimal valorPago) {
        this.valorPago = valorPago;
    }

    public MeioPagamento getMeioPagamento() {
        return meioPagamento;
    }

    public void setMeioPagamento(MeioPagamento meioPagamento) {
        this.meioPagamento = meioPagamento;
    }

    public Caixa getCaixa() {
        return caixa;
    }

    public void setCaixa(Caixa caixa) {
        this.caixa = caixa;
    }

    public StatusPagto getStatus() {
        return status;
    }

    public void setStatus(StatusPagto status) {
        this.status = status;
    }

    public BigDecimal getAcrecimo() {
        return acrecimo;
    }

    public void setAcrecimo(BigDecimal acrecimo) {
        this.acrecimo = acrecimo;
    }
    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + (int) (this.idContaPagar ^ (this.idContaPagar >>> 32));
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
        final ContaPagar other = (ContaPagar) obj;
        if (this.idContaPagar != other.idContaPagar) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return descricao;
    }

}
