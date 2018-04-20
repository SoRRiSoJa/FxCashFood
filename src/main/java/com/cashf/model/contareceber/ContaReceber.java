/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashf.model.contareceber;

import com.cashf.model.caixa.Caixa;
import com.cashf.model.contasPagar.StatusPagto;
import com.cashf.model.meiopagamento.MeioPagamento;
import com.cashf.model.venda.Venda;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
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
@Table(name = "contas_receber")
public class ContaReceber implements Serializable {

    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Id
    @Column(columnDefinition = "serial")
    private long idContaReceber;
    private LocalDate dataVencimento;
    private LocalDate dataPagamento;
    private String favorecido;
    private String descricao;
    private BigDecimal valorBruto;
    private BigDecimal encargos;
    private BigDecimal desconto;
    private BigDecimal acrecimo;
    private BigDecimal valorPago;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(nullable = false)
    private MeioPagamento meioPagamento;
    @ManyToOne
    @JoinColumn(nullable = false)
    private Venda venda;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Caixa caixa;
    @Enumerated(EnumType.STRING)
    private StatusPagto statusPagto;

    public ContaReceber() {
    }

    public ContaReceber(long idContaReceber, LocalDate dataVencimento, LocalDate dataPagamento, String favorecido, String descricao, BigDecimal valorBruto, BigDecimal encargos, BigDecimal desconto, BigDecimal acrecimo, BigDecimal valorPago, MeioPagamento meioPagamento, Venda venda, Caixa caixa, StatusPagto statusPagto) {
        this.idContaReceber = idContaReceber;
        this.dataVencimento = dataVencimento;
        this.dataPagamento = dataPagamento;
        this.favorecido = favorecido;
        this.descricao = descricao;
        this.valorBruto = valorBruto;
        this.encargos = encargos;
        this.desconto = desconto;
        this.acrecimo = acrecimo;
        this.valorPago = valorPago;
        this.meioPagamento = meioPagamento;
        this.venda = venda;
        this.caixa = caixa;
        this.statusPagto = statusPagto;
    }

    public long getIdContaReceber() {
        return idContaReceber;
    }

    public void setIdContaReceber(long idContaReceber) {
        this.idContaReceber = idContaReceber;
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

    public BigDecimal getAcrecimo() {
        return acrecimo;
    }

    public void setAcrecimo(BigDecimal acrecimo) {
        this.acrecimo = acrecimo;
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

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    public Caixa getCaixa() {
        return caixa;
    }

    public void setCaixa(Caixa caixa) {
        this.caixa = caixa;
    }

    public StatusPagto getStatusPagto() {
        return statusPagto;
    }

    public void setStatusPagto(StatusPagto statusPagto) {
        this.statusPagto = statusPagto;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + (int) (this.idContaReceber ^ (this.idContaReceber >>> 32));
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
        final ContaReceber other = (ContaReceber) obj;
        if (this.idContaReceber != other.idContaReceber) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return descricao + "|R$ " + valorBruto;
    }

}
