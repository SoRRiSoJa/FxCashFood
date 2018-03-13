/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashf.controller.contaspagar;

import com.cashf.dao.contacorrente.ContaCorrenteDAO;
import com.cashf.dao.contaspagar.ContaPagarDAO;
import com.cashf.dao.meiopagamento.MeioPagamentoDAO;
import com.cashf.model.caixa.Caixa;
import com.cashf.model.contacorrente.ContaCorrente;
import com.cashf.model.contasPagar.ContaPagar;
import com.cashf.model.contasPagar.StatusPagto;
import com.cashf.model.meiopagamento.MeioPagamento;
import controller.GenericController;
import java.math.BigDecimal;
import java.time.LocalDate;
import javafx.collections.ObservableList;

/**
 *
 * @author joao
 */
public class ContasPagarController implements GenericController<ContaPagar>{

    private ContaPagarDAO contasPagarDAO;
    private ContaCorrenteDAO contaCorrenteDAO;
    private MeioPagamentoDAO meioPagamentoDAO;
    private ContaCorrente contaCorrente;
    private MeioPagamento meioPagamento;
    private ObservableList<ContaPagar> lista;
    private ContaPagar contaPAgar;

    public ContasPagarController() {
    }

    public ContaCorrente getContaCorrente() {
        return contaCorrente;
    }

    public void setContaCorrente(ContaCorrente contaCorrente) {
        this.contaCorrente = contaCorrente;
    }

    public MeioPagamento getMeioPagamento() {
        return meioPagamento;
    }

    public void setMeioPagamento(MeioPagamento meioPagamento) {
        this.meioPagamento = meioPagamento;
    }

    public ContaPagar getContaPAgar() {
        return contaPAgar;
    }

    public void setContaPAgar(ContaPagar contaPAgar) {
        this.contaPAgar = contaPAgar;
    }

    @Override
    public void insert() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void flushObject() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ObservableList<ContaPagar> getLista() {
        return lista;
    }

    @Override
    public void setLista(ObservableList<ContaPagar> lista) {
        this.lista=lista;
    }

    public void setItenLista(long idContaPagar, LocalDate dataVencimento, LocalDate dataPagamento, String favorecido, String descricao, BigDecimal valorBruto, BigDecimal encargos, BigDecimal desconto, BigDecimal valorPago, MeioPagamento meioPagamento, Caixa caixa, StatusPagto status) {
        this.lista.add(new ContaPagar(idContaPagar, dataVencimento, dataPagamento, favorecido, descricao, valorBruto, encargos, desconto, valorPago, meioPagamento, caixa, StatusPagto.ABERTO));
    }

    @Override
    public void setItenLista(ContaPagar obj) {
        this.lista.add(obj);
    }
    
    
}
