/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashf.core.venda;

import com.cashf.controller.caixa.CaixaController;
import com.cashf.dao.contareceber.ContaReceberDAO;
import com.cashf.dao.meiopagamento.MeioPagamentoDAO;
import com.cashf.model.contareceber.ContaReceber;
import com.cashf.model.contasPagar.StatusPagto;
import com.cashf.model.meiopagamento.MeioPagamento;
import controller.GenericController;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author joao
 */
public class ContaReceberController implements GenericController<ContaReceber> {

    public static ContaReceberController contaReceberController;
    private ContaReceber contaReceber;
    private ObservableList<ContaReceber> lista;
    private final ContaReceberDAO contaReceberDAO;
    private final MeioPagamentoDAO meioPagamentoDAO;

    private ContaReceberController() {
        this.contaReceberDAO = new ContaReceberDAO(ContaReceber.class);
        this.meioPagamentoDAO = new MeioPagamentoDAO(MeioPagamento.class);
        this.lista = FXCollections.observableList(contaReceberDAO.listAll());
        this.contaReceber = new ContaReceber();
        this.contaReceber.setIdContaReceber(0l);
        
    }

    public static synchronized ContaReceberController getInstance() {
        if (contaReceberController == null) {
            contaReceberController = new ContaReceberController();
        }
        return contaReceberController;
    }

    public ContaReceber getContaReceber() {
        return contaReceber;
    }

    public void setContaReceber(ContaReceber contaReceber) {
        this.contaReceber = contaReceber;
    }

    public void setContaReceber(LocalDate dataVencimento, LocalDate dataPagamento, String favorecido, String descricao, BigDecimal valorBruto, BigDecimal encargos, BigDecimal desconto, BigDecimal acrecimo, BigDecimal valorPago, StatusPagto statusPagto) {
        this.contaReceber.setDataVencimento(dataVencimento);
        this.contaReceber.setDataPagamento(dataPagamento);
        this.contaReceber.setFavorecido(favorecido);
        this.contaReceber.setDescricao(descricao);
        this.contaReceber.setValorBruto(valorBruto);
        this.contaReceber.setEncargos(encargos);
        this.contaReceber.setDesconto(desconto);
        this.contaReceber.setAcrecimo(acrecimo);
        this.contaReceber.setValorPago(valorPago);
        this.contaReceber.setCaixa(CaixaController.getInstance().getCaixaAberto());
        this.contaReceber.setStatusPagto(statusPagto);
    }

    public void quitarContaReceber(LocalDate dataPagamento, BigDecimal encargos, BigDecimal desconto, BigDecimal acrecimo, BigDecimal valorPago, MeioPagamento meioPagamento, StatusPagto statusPagto) {
        this.contaReceber.setStatusPagto(StatusPagto.RECEBIDA);
        this.contaReceber.setDataPagamento(dataPagamento);
        this.contaReceber.setDesconto(desconto);
        this.contaReceber.setAcrecimo(acrecimo);
        this.contaReceber.setMeioPagamento(ContaReceberController.getInstance().getContaReceber().getMeioPagamento());
        this.contaReceber.setValorPago(valorPago);
        update();
        CaixaController.getInstance().movimentarCaixaCredito(contaReceber.getDescricao(), valorPago);
    }

    @Override
    public void insert() {
        contaReceber.setIdContaReceber(contaReceberDAO.save(contaReceber));
    }

    @Override
    public void update() {
        contaReceberDAO.update(contaReceber);
    }

    @Override
    public void delete() {
        contaReceberDAO.delete(contaReceber);
        this.contaReceber = new ContaReceber();
        this.contaReceber.setIdContaReceber(0l);
    }

    @Override
    public void flushObject() {
        this.contaReceber = new ContaReceber();
        this.contaReceber.setIdContaReceber(0l);
        this.lista = FXCollections.observableList(new ArrayList<>());
    }

    @Override
    public ObservableList<ContaReceber> getLista() {
        return lista;
    }

    @Override
    public void setLista(ObservableList<ContaReceber> lista) {
        this.lista = lista;
    }

    @Override
    public void setItenLista(ContaReceber obj) {
        lista.add(obj);
    }

    public ObservableList<MeioPagamento> getListaMeioPagamento() {
        return FXCollections.observableList(meioPagamentoDAO.listAll());
    }
}
