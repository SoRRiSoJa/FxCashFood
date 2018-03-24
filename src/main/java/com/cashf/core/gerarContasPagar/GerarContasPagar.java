/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashf.core.gerarContasPagar;

import com.cashf.controller.caixa.CaixaController;
import com.cashf.dao.contaspagar.ContaPagarDAO;
import com.cashf.dao.meiopagamento.MeioPagamentoDAO;
import com.cashf.model.caixa.Caixa;
import com.cashf.model.contasPagar.ContaPagar;
import com.cashf.model.contasPagar.StatusPagto;
import com.cashf.model.meiopagamento.MeioPagamento;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author joao
 */
public class GerarContasPagar {

    private ContaPagar contaPagar;
    private ObservableList<ContaPagar> lista;
     private ObservableList<MeioPagamento> listaMeioPagamento;
    private MeioPagamento meioPagamento;
    private final ContaPagarDAO contaPagarDAO;
    private final MeioPagamentoDAO meioPagamentoDAO;
    private boolean tipoParcelamento;
    public GerarContasPagar() {
        this.contaPagarDAO = new ContaPagarDAO(ContaPagar.class);
        this.meioPagamentoDAO = new MeioPagamentoDAO(MeioPagamento.class);
        this.meioPagamento = meioPagamentoDAO.getMPDinheiro();
        this.lista=FXCollections.observableList(new ArrayList<>());
        this.listaMeioPagamento=FXCollections.observableList(meioPagamentoDAO.listAll());
        this.contaPagar = new ContaPagar();
        this.contaPagar.setIdContaPagar(0l);
    }

    public boolean isTipoParcelamento() {
        return tipoParcelamento;
    }

    public void setTipoParcelamento(boolean tipoParcelamento) {
        this.tipoParcelamento = tipoParcelamento;
    }
    
    public ContaPagar getContaPagar() {
        return contaPagar;
    }

    public void setContaPagar(ContaPagar contaPagar) {
        this.contaPagar = contaPagar;
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

    public MeioPagamento getMeioPagamento() {
        return meioPagamento;
    }

    public void setMeioPagamento(MeioPagamento meioPagamento) {
        this.meioPagamento = meioPagamento;
    }

    public void gerarContaPagar(BigDecimal valorBruto, BigDecimal encargos, BigDecimal desconto, BigDecimal acrecimo, BigDecimal valorPago, LocalDate dataVencimento, String favorecido) {
        setContaPAgar(0,
                dataVencimento,
                null,
                favorecido,
                "PEDIDO DE COMPRA DE PRODUTOS em:" + LocalDate.now(),
                valorBruto,
                encargos,
                desconto,
                acrecimo,
                valorPago, meioPagamento, CaixaController.getInstance().getCaixaAberto(), StatusPagto.ABERTO);
        contaPagar.setIdContaPagar(contaPagarDAO.save(contaPagar));
    }

    public ObservableList<ContaPagar> getLista() {
        return lista;
    }

    public void setLista(ObservableList<ContaPagar> lista) {
        this.lista = lista;
    }

    public ObservableList<MeioPagamento> getListaMeioPagamento() {
        return listaMeioPagamento;
    }

    public void setListaMeioPagamento(ObservableList<MeioPagamento> listaMeioPagamento) {
        this.listaMeioPagamento = listaMeioPagamento;
    }
    
    
}
