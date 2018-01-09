/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashf.model.prepreparo;

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
@Table(name = "produto_prepreparo")
public class ProdutoPrePreparo implements Serializable {

    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Id
    @Column(columnDefinition = "serial")
    private Long idProdutoPrepreparo;
    @ManyToOne
    @JoinColumn(name = "idprepreparo")
    private PrePreparo prePreparo;
    @ManyToOne
    @JoinColumn(name = "idproduto")
    private Produto produto;
    private BigDecimal qtdeProduto;
    private BigDecimal valorPorcao;

    public ProdutoPrePreparo() {
    }

    public ProdutoPrePreparo(Long idProdutoPrepreparo, Produto produto, BigDecimal qtdeProduto) {
        this.idProdutoPrepreparo = idProdutoPrepreparo;
        this.produto = produto;
        this.qtdeProduto = qtdeProduto;
    }

    public Long getIdProdutoPrepreparo() {
        return idProdutoPrepreparo;
    }

    public void setIdProdutoPrepreparo(Long idProdutoPrepreparo) {
        this.idProdutoPrepreparo = idProdutoPrepreparo;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public BigDecimal getQtdeProduto() {
        return qtdeProduto;
    }

    public void setQtdeProduto(BigDecimal qtdeProduto) {
        this.qtdeProduto = qtdeProduto;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + Objects.hashCode(this.idProdutoPrepreparo);
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
        final ProdutoPrePreparo other = (ProdutoPrePreparo) obj;
        if (!Objects.equals(this.idProdutoPrepreparo, other.idProdutoPrepreparo)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return produto.getDescriao();
    }

}
