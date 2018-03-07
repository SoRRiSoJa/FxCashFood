/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashf.model.notafiscal;

import com.cashf.model.contasPagar.ContaPagar;
import com.cashf.model.fornecedor.Fornecedor;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author joao
 */
@Entity
@Table(name = "nota_fiscal")
public class NotaFiscal implements Serializable {

    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Id
    @Column(columnDefinition = "serial")
    private long idNota;
    private int numero_nota;
    @ManyToOne
    @JoinColumn(nullable = false)
    private Fornecedor fornecedor;
    @ManyToOne
    @JoinColumn(nullable = false)
    private ContaPagar contaPagar;
    @Column(columnDefinition = "DATE")
    private LocalDate dataNota;
    @Column(columnDefinition = "DATE")
    private LocalDate dataRecebimento;
    private BigDecimal base_calc_icms;
    private BigDecimal valor_icms;
    private BigDecimal base_icms_subst;
    private BigDecimal valor_icms_subst;
    private BigDecimal outrasDespesas;
    private BigDecimal desconto;
    private BigDecimal valorTotalProdutos;
    private BigDecimal valorTotalNota;
    private String observacao;
    @OneToMany(mappedBy = "notaFiscal", cascade = CascadeType.ALL)
    private List<ProdutoNotaFiscal> listaProdutos;

    public NotaFiscal() {
    }

    public NotaFiscal(long idNota, int numero_nota, Fornecedor fornecedor, ContaPagar contaPagar, LocalDate dataNota, LocalDate dataRecebimento, BigDecimal base_calc_icms, BigDecimal valor_icms, BigDecimal base_icms_subst, BigDecimal valor_icms_subst, BigDecimal outrasDespesas, BigDecimal desconto, BigDecimal valorTotalProdutos, BigDecimal valorTotalNota, String observacao, List<ProdutoNotaFiscal> listaProdutos) {
        this.idNota = idNota;
        this.numero_nota = numero_nota;
        this.fornecedor = fornecedor;
        this.contaPagar = contaPagar;
        this.dataNota = dataNota;
        this.dataRecebimento = dataRecebimento;
        this.base_calc_icms = base_calc_icms;
        this.valor_icms = valor_icms;
        this.base_icms_subst = base_icms_subst;
        this.valor_icms_subst = valor_icms_subst;
        this.outrasDespesas = outrasDespesas;
        this.desconto = desconto;
        this.valorTotalProdutos = valorTotalProdutos;
        this.valorTotalNota = valorTotalNota;
        this.observacao = observacao;
        this.listaProdutos = listaProdutos;
    }

    public long getIdNota() {
        return idNota;
    }

    public void setIdNota(long idNota) {
        this.idNota = idNota;
    }

    public int getNumero_nota() {
        return numero_nota;
    }

    public void setNumero_nota(int numero_nota) {
        this.numero_nota = numero_nota;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public ContaPagar getContaPagar() {
        return contaPagar;
    }

    public void setContaPagar(ContaPagar contaPagar) {
        this.contaPagar = contaPagar;
    }

    public LocalDate getDataNota() {
        return dataNota;
    }

    public void setDataNota(LocalDate dataNota) {
        this.dataNota = dataNota;
    }

    public LocalDate getDataRecebimento() {
        return dataRecebimento;
    }

    public void setDataRecebimento(LocalDate dataRecebimento) {
        this.dataRecebimento = dataRecebimento;
    }

    public BigDecimal getBase_calc_icms() {
        return base_calc_icms;
    }

    public void setBase_calc_icms(BigDecimal base_calc_icms) {
        this.base_calc_icms = base_calc_icms;
    }

    public BigDecimal getValor_icms() {
        return valor_icms;
    }

    public void setValor_icms(BigDecimal valor_icms) {
        this.valor_icms = valor_icms;
    }

    public BigDecimal getBase_icms_subst() {
        return base_icms_subst;
    }

    public void setBase_icms_subst(BigDecimal base_icms_subst) {
        this.base_icms_subst = base_icms_subst;
    }

    public BigDecimal getValor_icms_subst() {
        return valor_icms_subst;
    }

    public void setValor_icms_subst(BigDecimal valor_icms_subst) {
        this.valor_icms_subst = valor_icms_subst;
    }

    public BigDecimal getOutrasDespesas() {
        return outrasDespesas;
    }

    public void setOutrasDespesas(BigDecimal outrasDespesas) {
        this.outrasDespesas = outrasDespesas;
    }

    public BigDecimal getDesconto() {
        return desconto;
    }

    public void setDesconto(BigDecimal desconto) {
        this.desconto = desconto;
    }

    public BigDecimal getValorTotalProdutos() {
        return valorTotalProdutos;
    }

    public void setValorTotalProdutos(BigDecimal valorTotalProdutos) {
        this.valorTotalProdutos = valorTotalProdutos;
    }

    public BigDecimal getValorTotalNota() {
        return valorTotalNota;
    }

    public void setValorTotalNota(BigDecimal valorTotalNota) {
        this.valorTotalNota = valorTotalNota;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public List<ProdutoNotaFiscal> getListaProdutos() {
        return listaProdutos;
    }

    public void setListaProdutos(List<ProdutoNotaFiscal> listaProdutos) {
        this.listaProdutos = listaProdutos;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + (int) (this.idNota ^ (this.idNota >>> 32));
        hash = 71 * hash + this.numero_nota;
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
        final NotaFiscal other = (NotaFiscal) obj;
        if (this.numero_nota != other.numero_nota) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return numero_nota+"";
    }
    
}
