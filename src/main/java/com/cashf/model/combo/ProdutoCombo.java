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
}
