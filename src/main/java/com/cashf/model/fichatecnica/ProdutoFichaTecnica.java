/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashf.model.fichatecnica;

import com.cashf.model.produto.Produto;
import com.cashf.model.produto.UnidadeMedida;
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
@Table(name = "produto_ficha_tecnica")
public class ProdutoFichaTecnica implements Serializable{
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Id
    @Column(columnDefinition = "serial")
    private Long idProdutoFichaTecnica;
    @ManyToOne
    @JoinColumn(name = "idfichatecnica") 
    private FichaTecnica fichaTecnica;
    @ManyToOne
    @JoinColumn(name = "idproduto")
    private Produto produto;
    private UnidadeMedida unidadeMedida;
    private BigDecimal qtdeProduto;
    private BigDecimal valorPorcao;

    public ProdutoFichaTecnica() {
    }

    public ProdutoFichaTecnica(Long idProdutoFichaTecnica, FichaTecnica fichaTecnica, Produto produto, UnidadeMedida unidadeMedida, BigDecimal qtdeProduto, BigDecimal valorPorcao) {
        this.idProdutoFichaTecnica = idProdutoFichaTecnica;
        this.fichaTecnica = fichaTecnica;
        this.produto = produto;
        this.unidadeMedida = unidadeMedida;
        this.qtdeProduto = qtdeProduto;
        this.valorPorcao = valorPorcao;
    }

    public Long getIdProdutoFichaTecnica() {
        return idProdutoFichaTecnica;
    }

    public void setIdProdutoFichaTecnica(Long idProdutoFichaTecnica) {
        this.idProdutoFichaTecnica = idProdutoFichaTecnica;
    }

    public FichaTecnica getFichaTecnica() {
        return fichaTecnica;
    }

    public void setFichaTecnica(FichaTecnica fichaTecnica) {
        this.fichaTecnica = fichaTecnica;
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

    public BigDecimal getValorPorcao() {
        return valorPorcao;
    }

    public void setValorPorcao(BigDecimal valorPorcao) {
        this.valorPorcao = valorPorcao;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + Objects.hashCode(this.idProdutoFichaTecnica);
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
        final ProdutoFichaTecnica other = (ProdutoFichaTecnica) obj;
        if (!Objects.equals(this.idProdutoFichaTecnica, other.idProdutoFichaTecnica)) {
            return false;
        }
        if (!Objects.equals(this.fichaTecnica, other.fichaTecnica)) {
            return false;
        }
        if (!Objects.equals(this.produto, other.produto)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return  produto.getDescriao() ;
    }
    
    
}
