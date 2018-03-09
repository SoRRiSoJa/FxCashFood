/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashf.model.notafiscal;

import com.cashf.model.produto.Produto;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;
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
@Table(name = "produto_nota_fiscal")
public class ProdutoNotaFiscal implements Serializable {

    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Id
    @Column(columnDefinition = "serial")
    private Long idProdutoNotaFiscal;
    @ManyToOne
    @JoinColumn(name = "idnota")
    private NotaFiscal notaFiscal;
    @ManyToOne
    @JoinColumn(name = "idproduto")
    private Produto produto;
    private Integer qtdeProduto;
    private BigDecimal valorUnitario;
    private BigDecimal valorTotal;
    public ProdutoNotaFiscal() {
    }

    public ProdutoNotaFiscal(Long idProdutoNotaFiscal, NotaFiscal notaFiscal, Produto produto, Integer qtdeProduto, BigDecimal valoruUnitario,BigDecimal valorTotal) {
        this.idProdutoNotaFiscal = idProdutoNotaFiscal;
        this.notaFiscal = notaFiscal;
        this.produto = produto;
        this.qtdeProduto = qtdeProduto;
        this.valorUnitario = valoruUnitario;
        this.valorTotal=valorTotal;
    }

    public Long getIdProdutoNotaFiscal() {
        return idProdutoNotaFiscal;
    }

    public void setIdProdutoNotaFiscal(Long idProdutoNotaFiscal) {
        this.idProdutoNotaFiscal = idProdutoNotaFiscal;
    }

    public NotaFiscal getNotaFiscal() {
        return notaFiscal;
    }

    public void setNotaFiscal(NotaFiscal notaFiscal) {
        this.notaFiscal = notaFiscal;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Integer getQtdeProduto() {
        return qtdeProduto;
    }

    public void setQtdeProduto(Integer qtdeProduto) {
        this.qtdeProduto = qtdeProduto;
    }

    public BigDecimal getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(BigDecimal valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }
    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 43 * hash + Objects.hashCode(this.idProdutoNotaFiscal);
        hash = 43 * hash + Objects.hashCode(this.notaFiscal);
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
        final ProdutoNotaFiscal other = (ProdutoNotaFiscal) obj;
        if (!Objects.equals(this.idProdutoNotaFiscal, other.idProdutoNotaFiscal)) {
            return false;
        }
        if (!Objects.equals(this.notaFiscal, other.notaFiscal)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return  produto.getDescriao();
    }

}
