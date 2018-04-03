/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashf.controller.meiopagamento;

import com.cashf.dao.contacorrente.ContaCorrenteDAO;
import com.cashf.dao.meiopagamento.MeioPagamentoDAO;
import com.cashf.model.contacorrente.ContaCorrente;
import com.cashf.model.meiopagamento.MeioPagamento;
import com.cashf.model.meiopagamento.TPPagto;
import java.math.BigDecimal;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author joao
 */
public class MeioPagamentoController {

    private final MeioPagamentoDAO meioPagamentoDAO;
    private final ContaCorrenteDAO contaCorrenteDAO;
    private ObservableList<MeioPagamento> lista;
    private ObservableList<ContaCorrente> listaConta;
    private ContaCorrente contaCorrente;
    private MeioPagamento meioPagamento;
    private TPPagto tpPagto;

    public MeioPagamentoController() {
        this.meioPagamentoDAO = new MeioPagamentoDAO(MeioPagamento.class);
        this.contaCorrenteDAO = new ContaCorrenteDAO(ContaCorrente.class);
        this.meioPagamento = new MeioPagamento();
        this.contaCorrente = new ContaCorrente();
        this.lista = FXCollections.observableList(meioPagamentoDAO.listAll());
        this.listaConta = FXCollections.observableList(contaCorrenteDAO.listAll());
        this.meioPagamento.setIdMeio(0);
    }

    public ObservableList<MeioPagamento> getLista() {
        return lista;
    }

    public void setLista(ObservableList<MeioPagamento> lista) {
        this.lista = lista;
    }

    public void setItemLista(MeioPagamento meioPagamento) {
        this.lista.add(meioPagamento);
    }

    public ObservableList<ContaCorrente> getListaConta() {
        return listaConta;
    }

    public void setListaConta(ObservableList<ContaCorrente> listaConta) {
        this.listaConta = listaConta;
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

    public TPPagto getTpPagto() {
        return tpPagto;
    }

    public void setTpPagto(TPPagto tpPagto) {
        this.tpPagto = tpPagto;
    }

    public void setMeioPagamento(MeioPagamento meioPagamento) {
        this.meioPagamento = meioPagamento;
    }

    public void setMeioPagamento(long id, String descricao, Integer prazoRecebimento, BigDecimal taxa, TPPagto tipoPagto, ContaCorrente contaCorrente) {
        this.meioPagamento = new MeioPagamento(id, descricao, prazoRecebimento, taxa, tipoPagto, contaCorrente);
    }

    public void insert() {
        meioPagamento.setIdMeio(meioPagamentoDAO.save(meioPagamento));
        setItemLista(meioPagamento);
        flushMeioPagamento();
    }

    public void delete() {
        meioPagamentoDAO.delete(meioPagamento);
        lista.remove(meioPagamento);
        flushMeioPagamento();
    }

    public void update() {
        meioPagamentoDAO.update(meioPagamento);
        flushMeioPagamento();
    }

    private void flushMeioPagamento() {
        meioPagamento = new MeioPagamento();
        meioPagamento.setIdMeio(0l);
    }

    public void refreshList() {
        this.lista = FXCollections.observableList(meioPagamentoDAO.listAll());
    }
}
