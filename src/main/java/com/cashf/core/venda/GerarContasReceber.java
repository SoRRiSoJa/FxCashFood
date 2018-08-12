/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashf.core.venda;

import com.cashf.dao.contareceber.ContaReceberDAO;
import com.cashf.model.caixa.Caixa;
import com.cashf.model.contareceber.ContaReceber;
import com.cashf.model.contasPagar.StatusPagto;
import com.cashf.model.meiopagamento.MeioPagamento;
import com.cashf.model.venda.Venda;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 *
 * @author joao
 */
public class GerarContasReceber {

    private ContaReceber contaReceber;
    private final ContaReceberDAO contaReceberDAO;

    public GerarContasReceber() {
        this.contaReceberDAO = new ContaReceberDAO(ContaReceber.class);
        this.contaReceber = new ContaReceber();
        this.contaReceber.setIdContaReceber(0l);
    }

    public ContaReceber getContaReceber() {
        return contaReceber;
    }

    public void setContaReceber(ContaReceber contaReceber) {
        this.contaReceber = contaReceber;
    }

    public void setContaReceber(LocalDate dataVencimento, LocalDate dataPagamento, String favorecido, String descricao, BigDecimal valorBruto, BigDecimal encargos, BigDecimal desconto, BigDecimal acrecimo, BigDecimal valorPago, MeioPagamento meioPagamento, Venda venda, Caixa caixa, StatusPagto statusPagto) {
        this.contaReceber = contaReceber;
    }
}
