/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashf.model.prepreparo;

import com.cashf.model.produto.Produto;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author joao
 */
@Entity
@Table(name = "pre_preparo")
public class PrePreparo implements Serializable {

    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Id
    @Column(columnDefinition = "serial")
    private long idPrepreparo;
    @ManyToOne
    @JoinColumn(nullable = false)
    private Produto produtoPrincipal;
    private String descricao;
    @Column(columnDefinition = "DATE")
    private LocalDate dataProducao;
    private BigDecimal rendimento;
    private BigDecimal custoTotal;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "produto_pre_preparo", joinColumns
            = {
                @JoinColumn(name = "id_prepreparo")}, inverseJoinColumns
            = {
                @JoinColumn(name = "id_produto")})
    private List<Produto> listaProdutos;
    private Boolean status;

    public PrePreparo() {
    }

    public PrePreparo(long idPrepreparo, Produto produtoPrincipal, String descricao, LocalDate dataProducao, BigDecimal rendimento, BigDecimal custoTotal, List<Produto> listaProdutos, Boolean status) {
        this.idPrepreparo = idPrepreparo;
        this.produtoPrincipal = produtoPrincipal;
        this.descricao = descricao;
        this.dataProducao = dataProducao;
        this.rendimento = rendimento;
        this.custoTotal = custoTotal;
        this.listaProdutos = listaProdutos;
        this.status = status;
    }

    public long getIdPrepreparo() {
        return idPrepreparo;
    }

    public void setIdPrepreparo(long idPrepreparo) {
        this.idPrepreparo = idPrepreparo;
    }

    public Produto getProdutoPrincipal() {
        return produtoPrincipal;
    }

    public void setProdutoPrincipal(Produto produtoPrincipal) {
        this.produtoPrincipal = produtoPrincipal;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getDataProducao() {
        return dataProducao;
    }

    public void setDataProducao(LocalDate dataProducao) {
        this.dataProducao = dataProducao;
    }

    public BigDecimal getRendimento() {
        return rendimento;
    }

    public void setRendimento(BigDecimal rendimento) {
        this.rendimento = rendimento;
    }

    public BigDecimal getCustoTotal() {
        return custoTotal;
    }

    public void setCustoTotal(BigDecimal custoTotal) {
        this.custoTotal = custoTotal;
    }

    public List<Produto> getListaProdutos() {
        return listaProdutos;
    }

    public void setListaProdutos(List<Produto> listaProdutos) {
        this.listaProdutos = listaProdutos;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + (int) (this.idPrepreparo ^ (this.idPrepreparo >>> 32));
        hash = 97 * hash + Objects.hashCode(this.dataProducao);
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
        final PrePreparo other = (PrePreparo) obj;
        if (this.idPrepreparo != other.idPrepreparo) {
            return false;
        }
        if (!Objects.equals(this.dataProducao, other.dataProducao)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.descricao;
    }

}
