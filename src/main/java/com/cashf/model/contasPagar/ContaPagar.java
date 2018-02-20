/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashf.model.contasPagar;

import com.cashf.model.meiopagamento.MeioPagamento;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
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
@Table(name = "contas_pagar")
public class ContaPagar implements Serializable {

    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Id
    @Column(columnDefinition = "serial")
    private long idContaPagar;
    @Column(columnDefinition = "DATE")
    private LocalDate dataVencimento;
    @Column(columnDefinition = "DATE")
    private LocalDate dataPagamento;
    private String favorecido;
    private String observação;
    private BigDecimal valorBruto;
    private BigDecimal encargos;
    private BigDecimal desconto;
    private BigDecimal valorPago;
    @ManyToOne
    @JoinColumn(nullable = false)
    private MeioPagamento meioPagamento;
}
