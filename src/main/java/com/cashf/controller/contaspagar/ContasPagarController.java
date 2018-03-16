/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashf.controller.contaspagar;

import com.cashf.dao.contaspagar.ContaPagarDAO;
import com.cashf.dao.meiopagamento.MeioPagamentoDAO;
import com.cashf.model.caixa.Caixa;
import com.cashf.model.contasPagar.ContaPagar;
import com.cashf.model.contasPagar.StatusPagto;
import com.cashf.model.meiopagamento.MeioPagamento;
import controller.GenericController;
import java.math.BigDecimal;
import java.time.LocalDate;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author joao
 */
public class ContasPagarController implements GenericController<ContaPagar> {

    public static ContasPagarController contasPagarController = null;
    private final ContaPagarDAO contasPagarDAO;
    private final MeioPagamentoDAO meioPagamentoDAO;
    private MeioPagamento meioPagamento;
    private ObservableList<ContaPagar> lista;
    private ObservableList<MeioPagamento> meioPagamentoLista;
    private ContaPagar contaPagar;

    private ContasPagarController() {
        this.meioPagamentoDAO = new MeioPagamentoDAO(MeioPagamento.class);
        this.contasPagarDAO = new ContaPagarDAO(ContaPagar.class);
        this.meioPagamentoLista = FXCollections.observableList(meioPagamentoDAO.listAll());
        this.lista = FXCollections.observableList(contasPagarDAO.listAll());
        this.contaPagar = new ContaPagar();
        this.contaPagar.setIdContaPagar(0l);
    }

    public static synchronized ContasPagarController getInstance() {
        if (contasPagarController == null) {
            contasPagarController = new ContasPagarController();
        }
        return contasPagarController;
    }

    public MeioPagamento getMeioPagamento() {
        return meioPagamento;
    }

    public void setMeioPagamento(MeioPagamento meioPagamento) {
        this.meioPagamento = meioPagamento;
    }

    public ContaPagar getContaPAgar() {
        return contaPagar;
    }

    public void setContaPAgar(long idContaPagar, LocalDate dataVencimento, LocalDate dataPagamento, String favorecido, String descricao,
            BigDecimal valorBruto, BigDecimal encargos, BigDecimal desconto, BigDecimal acrecimo, BigDecimal valorPago, MeioPagamento meioPagamento, Caixa caixa, StatusPagto status) {
        this.contaPagar.setIdContaPagar(idContaPagar);
        this.contaPagar.setDataVencimento(dataVencimento);
        this.contaPagar.setDataPagamento(dataPagamento);
        this.contaPagar.setFavorecido(favorecido);
        this.contaPagar.setDescricao(descricao);
        this.contaPagar.setValorBruto(valorBruto);
        this.contaPagar.setEncargos(encargos);
        this.contaPagar.setDesconto(desconto);
        this.contaPagar.setAcrecimo(acrecimo);
        this.contaPagar.setValorPago(valorPago);
        this.contaPagar.setMeioPagamento(meioPagamento);
        this.contaPagar.setStatusPagto(status);
        this.contaPagar.setCaixa(caixa);
    }

    @Override
    public void insert() {
        System.out.println("CP"+contaPagar.getCaixa().toString());
        this.contaPagar.setIdContaPagar(contasPagarDAO.save(contaPagar));
    }

    @Override
    public void update() {
        contasPagarDAO.update(contaPagar);
    }

    @Override
    public void delete() {
        contaPagar.setStatusPagto(StatusPagto.CANCELADA);
        contaPagar.setDescricao(contaPagar.getDescricao().concat(" - *CANCELADA*"));
        contasPagarDAO.update(contaPagar);
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
        this.lista = lista;
    }

    public void setItenLista(long idContaPagar, LocalDate dataVencimento, LocalDate dataPagamento, String favorecido, String descricao, BigDecimal valorBruto, BigDecimal encargos, BigDecimal desconto, BigDecimal acrecimo, BigDecimal valorPago, MeioPagamento meioPagamento, Caixa caixa, StatusPagto status) {
        this.lista.add(new ContaPagar(idContaPagar, dataVencimento, dataPagamento, favorecido, descricao, valorBruto, encargos, desconto, acrecimo, valorPago, meioPagamento, caixa, StatusPagto.ABERTO));
    }

    @Override
    public void setItenLista(ContaPagar obj) {
        this.lista.add(obj);
    }

    public ObservableList<MeioPagamento> getMeioPagamentoLista() {
        return meioPagamentoLista;
    }

    public void setMeioPagamentoLista(ObservableList<MeioPagamento> meioPagamentoLista) {
        this.meioPagamentoLista = meioPagamentoLista;
    }

    public ContaPagar getContaPagar() {
        return contaPagar;
    }

    public void setContaPagar(ContaPagar contaPagar) {
        this.contaPagar = contaPagar;
    }

    public void quitarConta() {
        this.contaPagar.setStatusPagto(StatusPagto.PAGO);
    }
}
