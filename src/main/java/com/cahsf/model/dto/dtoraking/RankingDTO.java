/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cahsf.model.dto.dtoraking;

import com.cashf.model.produto.Produto;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

/**
 *
 * @author joao
 */
public class RankingDTO implements Serializable{
    private long id;
    private Produto produto;
    private int nVendas;
    private BigDecimal precoUni;
    private BigDecimal totVenda;
    private BigDecimal totCusto;
    private BigDecimal margem;

    public RankingDTO() {
    }

    public RankingDTO(long id, Produto produto, int nVendas, BigDecimal precoUni, BigDecimal totVenda, BigDecimal totCusto, BigDecimal margem) {
        this.id = id;
        this.produto = produto;
        this.nVendas = nVendas;
        this.precoUni = precoUni;
        this.totVenda = totVenda;
        this.totCusto = totCusto;
        this.margem = margem;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getnVendas() {
        return nVendas;
    }

    public void setnVendas(int nVendas) {
        this.nVendas = nVendas;
    }

    public BigDecimal getPrecoUni() {
        return precoUni;
    }

    public void setPrecoUni(BigDecimal precoUni) {
        this.precoUni = precoUni;
    }

    public BigDecimal getTotVenda() {
        return totVenda;
    }

    public void setTotVenda(BigDecimal totVenda) {
        this.totVenda = totVenda;
    }

    public BigDecimal getTotCusto() {
        return totCusto;
    }

    public void setTotCusto(BigDecimal totCusto) {
        this.totCusto = totCusto;
    }

    public BigDecimal getMargem() {
        return margem;
    }

    public void setMargem(BigDecimal margem) {
        this.margem = margem;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 47 * hash + Objects.hashCode(this.produto);
        hash = 47 * hash + this.nVendas;
        hash = 47 * hash + Objects.hashCode(this.precoUni);
        hash = 47 * hash + Objects.hashCode(this.totVenda);
        hash = 47 * hash + Objects.hashCode(this.totCusto);
        hash = 47 * hash + Objects.hashCode(this.margem);
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
        final RankingDTO other = (RankingDTO) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.nVendas != other.nVendas) {
            return false;
        }
        if (!Objects.equals(this.produto, other.produto)) {
            return false;
        }
        if (!Objects.equals(this.precoUni, other.precoUni)) {
            return false;
        }
        if (!Objects.equals(this.totVenda, other.totVenda)) {
            return false;
        }
        if (!Objects.equals(this.totCusto, other.totCusto)) {
            return false;
        }
        if (!Objects.equals(this.margem, other.margem)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return  produto.getDescriao();
    }
    
}
