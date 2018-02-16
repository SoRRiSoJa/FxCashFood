/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashf.model.fichatecnica;

import com.cashf.model.produto.Produto;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
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
@Table(name = "ficha_tecnica")
public class FichaTecnica implements Serializable {

    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Id
    @Column(columnDefinition = "serial")
    private long idFichaTecnica;
    @ManyToOne
    @JoinColumn(nullable = false)
    private Produto produtoPrincipal;
    @Column(columnDefinition = "DATE")
    private LocalDate dataProducao;
    private BigDecimal custoTotal;
    @OneToMany(mappedBy = "fichaTecnica", cascade = CascadeType.ALL)
    private List<ProdutoFichaTecnica> listaProdutos;
    private Boolean status;
    public FichaTecnica() {
    }

    public FichaTecnica(long idFichaTecnica, Produto produtoPrincipal, LocalDate dataProducao, BigDecimal custoTotal, List<ProdutoFichaTecnica> listaProdutos, Boolean status) {
        this.idFichaTecnica = idFichaTecnica;
        this.produtoPrincipal = produtoPrincipal;
        this.dataProducao = dataProducao;
        this.custoTotal = custoTotal;
        this.listaProdutos = listaProdutos;
        this.status = status;
    }

    public long getIdFichaTecnica() {
        return idFichaTecnica;
    }

    public void setIdFichaTecnica(long idFichaTecnica) {
        this.idFichaTecnica = idFichaTecnica;
    }

    public Produto getProdutoPrincipal() {
        return produtoPrincipal;
    }

    public void setProdutoPrincipal(Produto produtoPrincipal) {
        this.produtoPrincipal = produtoPrincipal;
    }

    public LocalDate getDataProducao() {
        return dataProducao;
    }

    public void setDataProducao(LocalDate dataProducao) {
        this.dataProducao = dataProducao;
    }


    public BigDecimal getCustoTotal() {
        return custoTotal;
    }

    public void setCustoTotal(BigDecimal custoTotal) {
        this.custoTotal = custoTotal;
    }

    public List<ProdutoFichaTecnica> getListaProdutos() {
        return listaProdutos;
    }

    public void setListaProdutos(List<ProdutoFichaTecnica> listaProdutos) {
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
        hash = 59 * hash + (int) (this.idFichaTecnica ^ (this.idFichaTecnica >>> 32));
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
        final FichaTecnica other = (FichaTecnica) obj;
        if (this.idFichaTecnica != other.idFichaTecnica) {
            return false;
        }
        if (!Objects.equals(this.produtoPrincipal, other.produtoPrincipal)) {
            return false;
        }
        if (!Objects.equals(this.dataProducao, other.dataProducao)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return produtoPrincipal.getDescriao();
    }

}
