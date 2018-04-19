/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashf.model.venda;

import com.cashf.model.produto.Produto;
import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "produto_venda")

public class ProdutoVenda implements Serializable {

    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Id
    @Column(columnDefinition = "serial")
    private long idProdVenda;
    @ManyToOne
    @JoinColumn(name = "idvenda")
    private Venda vendaId;
    @ManyToOne
    @JoinColumn(name = "idproduto")
    Produto produto;
    private BigDecimal qtde;
    private BigDecimal precoUnit;

    public ProdutoVenda() {
    }

    public ProdutoVenda(long idProdVenda, Venda venda, Produto produto, BigDecimal qtde, BigDecimal precoUnit) {
        this.idProdVenda = idProdVenda;
        this.vendaId = venda;
        this.produto = produto;
        this.qtde = qtde;
        this.precoUnit = precoUnit;
    }

    public long getIdProdVenda() {
        return idProdVenda;
    }

    public void setIdProdVenda(long idProdVenda) {
        this.idProdVenda = idProdVenda;
    }

    public Venda getVendaId() {
        return vendaId;
    }

    public void setVendaId(Venda vendaId) {
        this.vendaId = vendaId;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public BigDecimal getQtde() {
        return qtde;
    }

    public void setQtde(BigDecimal qtde) {
        this.qtde = qtde;
    }

    public BigDecimal getPrecoUnit() {
        return precoUnit;
    }

    public void setPrecoUnit(BigDecimal precoUnit) {
        this.precoUnit = precoUnit;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + (int) (this.idProdVenda ^ (this.idProdVenda >>> 32));
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
        final ProdutoVenda other = (ProdutoVenda) obj;
        if (this.idProdVenda != other.idProdVenda) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return produto.getDescriao();
    }

}
