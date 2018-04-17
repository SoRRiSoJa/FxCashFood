/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashf.model.combo;

import com.cashf.model.produto.Produto;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Table(name = "combo")
public class Combo implements Serializable {

    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Id
    @Column(columnDefinition = "serial")
    private long idCombo;
    @ManyToOne
    @JoinColumn(nullable = false)
    private Produto produtoPrincipal;
    private BigDecimal custoTotal;
    private BigDecimal valorVenda;
    private Boolean status;
    @OneToMany(mappedBy = "combo", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<ProdutoCombo> listaProdutos;

    public Combo() {
    }

    public Combo(long idCombo, Produto produtoPrincipal, BigDecimal custoTotal, BigDecimal valorVenda, Boolean status, List<ProdutoCombo> listaProdutos) {
        this.idCombo = idCombo;
        this.produtoPrincipal = produtoPrincipal;
        this.custoTotal = custoTotal;
        this.valorVenda = valorVenda;
        this.status = status;
        this.listaProdutos = listaProdutos;
    }

    public long getIdCombo() {
        return idCombo;
    }

    public void setIdCombo(long idCombo) {
        this.idCombo = idCombo;
    }

    public Produto getProdutoPrincipal() {
        return produtoPrincipal;
    }

    public void setProdutoPrincipal(Produto produtoPrincipal) {
        this.produtoPrincipal = produtoPrincipal;
    }

    public BigDecimal getCustoTotal() {
        return custoTotal;
    }

    public void setCustoTotal(BigDecimal custoTotal) {
        this.custoTotal = custoTotal;
    }

    public BigDecimal getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(BigDecimal valorVenda) {
        this.valorVenda = valorVenda;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public List<ProdutoCombo> getListaProdutos() {
        return listaProdutos;
    }

    public void setListaProdutos(List<ProdutoCombo> listaProdutos) {
        this.listaProdutos = listaProdutos;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + (int) (this.idCombo ^ (this.idCombo >>> 32));
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
        final Combo other = (Combo) obj;
        if (this.idCombo != other.idCombo) {
            return false;
        }
        if (!Objects.equals(this.produtoPrincipal, other.produtoPrincipal)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return produtoPrincipal.getDescriao();
    }

}
