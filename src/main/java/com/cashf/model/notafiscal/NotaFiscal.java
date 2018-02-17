/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashf.model.notafiscal;

import com.cashf.model.fornecedor.Fornecedor;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
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
@Table(name = "nota_fiscal")
public class NotaFiscal implements Serializable {

    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Id
    @Column(columnDefinition = "serial")
    private long idNota;
    private int numero_nota;
    @ManyToOne
    @JoinColumn(nullable = false)
    private Fornecedor fornecedor;
    @Column(columnDefinition = "DATE")
    private LocalDate dataNota;
    @Column(columnDefinition = "DATE")
    private LocalDate dataRecebimento;
    private BigDecimal base_calc_icms;
    private BigDecimal valor_icms;
    private BigDecimal base_icms_subst;
    private BigDecimal valor_icms_subst;
    private BigDecimal outrasDespesas;
    private BigDecimal desconto;
    private BigDecimal valorTotalProdutos;
    private BigDecimal valorTotalNota;
    private String observacao;
    @OneToMany(mappedBy = "notaFiscal", cascade = CascadeType.ALL)
    private List<ProdutoNotaFiscal> listaProdutos;
}
