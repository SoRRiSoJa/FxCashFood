/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashf.model.combo;

import com.cashf.model.produto.Produto;
import com.cashf.model.produto.UnidadeMedida;
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
@Table(name = "produto_combo")
public class ProdutoCombo implements Serializable{
    
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Id
    @Column(columnDefinition = "serial")
    private long idProdutoCombo;
    @ManyToOne
    @JoinColumn(name = "idprepreparo")
    private Combo combo;
    @ManyToOne
    @JoinColumn(name = "idproduto")
    private Produto produto;
    private UnidadeMedida unidadeMedida;
    private BigDecimal qtdeProduto;
    private BigDecimal valorDiferenciado;
    private Boolean valorDif;
    private Integer sequencia;

    public ProdutoCombo() {
    }

    public ProdutoCombo(long idProdutoCombo, Combo combo, Produto produto, UnidadeMedida unidadeMedida, BigDecimal qtdeProduto, BigDecimal valorDiferenciado, Boolean valorDif, Integer sequencia) {
        this.idProdutoCombo = idProdutoCombo;
        this.combo = combo;
        this.produto = produto;
        this.unidadeMedida = unidadeMedida;
        this.qtdeProduto = qtdeProduto;
        this.valorDiferenciado = valorDiferenciado;
        this.valorDif = valorDif;
        this.sequencia = sequencia;
    }

    public long getIdProdutoCombo() {
        return idProdutoCombo;
    }

    public void setIdProdutoCombo(long idProdutoCombo) {
        this.idProdutoCombo = idProdutoCombo;
    }

    public Combo getCombo() {
        return combo;
    }

    public void setCombo(Combo combo) {
        this.combo = combo;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public UnidadeMedida getUnidadeMedida() {
        return unidadeMedida;
    }

    public void setUnidadeMedida(UnidadeMedida unidadeMedida) {
        this.unidadeMedida = unidadeMedida;
    }

    public BigDecimal getQtdeProduto() {
        return qtdeProduto;
    }

    public void setQtdeProduto(BigDecimal qtdeProduto) {
        this.qtdeProduto = qtdeProduto;
    }

    public BigDecimal getValorDiferenciado() {
        return valorDiferenciado;
    }

    public void setValorDiferenciado(BigDecimal valorDiferenciado) {
        this.valorDiferenciado = valorDiferenciado;
    }

    public Boolean getValorDif() {
        return valorDif;
    }

    public void setValorDif(Boolean valorDif) {
        this.valorDif = valorDif;
    }

    public Integer getSequencia() {
        return sequencia;
    }

    public void setSequencia(Integer sequencia) {
        this.sequencia = sequencia;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + (int) (this.idProdutoCombo ^ (this.idProdutoCombo >>> 32));
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
        final ProdutoCombo other = (ProdutoCombo) obj;
        if (this.idProdutoCombo != other.idProdutoCombo) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return  produto.getDescriao() ;
    }
    
    
}
