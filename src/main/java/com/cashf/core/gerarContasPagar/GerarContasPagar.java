/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashf.core.gerarContasPagar;

import com.cashf.controller.caixa.CaixaController;
import com.cashf.controller.receberpedido.ReceberPedidoController;
import com.cashf.core.atualizarestoque.AtualizarEstoque;
import com.cashf.dao.contaspagar.ContaPagarDAO;
import com.cashf.dao.meiopagamento.MeioPagamentoDAO;
import com.cashf.model.caixa.Caixa;
import com.cashf.model.contasPagar.ContaPagar;
import com.cashf.model.contasPagar.StatusPagto;
import com.cashf.model.meiopagamento.MeioPagamento;
import java.math.BigDecimal;
import java.math.RoundingMode;
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
    //---
    private BigDecimal encargos;
    private BigDecimal desconto;
    private BigDecimal acrecimo;
    private BigDecimal valorBruto;
    private BigDecimal valorPago;
    private String favorecido;
    private String numeroNota;

    public GerarContasPagar() {
        this.contaPagarDAO = new ContaPagarDAO(ContaPagar.class);
        this.meioPagamentoDAO = new MeioPagamentoDAO(MeioPagamento.class);
        this.meioPagamento = meioPagamentoDAO.getMPDinheiro();
        this.lista = FXCollections.observableList(new ArrayList<>());
        this.listaMeioPagamento = FXCollections.observableList(meioPagamentoDAO.listAll());
        this.contaPagar = new ContaPagar();
        this.contaPagar.setIdContaPagar(0l);
        
    }

    public GerarContasPagar(String numeroNota, String favorecido, BigDecimal valorBruto, BigDecimal encargos, BigDecimal acrecimo, BigDecimal desconto, BigDecimal valorPago) {
        this.contaPagarDAO = new ContaPagarDAO(ContaPagar.class);
        this.meioPagamentoDAO = new MeioPagamentoDAO(MeioPagamento.class);
        this.meioPagamento = meioPagamentoDAO.getMPDinheiro();
        this.lista = FXCollections.observableList(new ArrayList<>());
        this.listaMeioPagamento = FXCollections.observableList(meioPagamentoDAO.listAll());
        this.contaPagar = new ContaPagar();
        this.contaPagar.setIdContaPagar(0l);
        this.acrecimo = acrecimo;
        this.desconto = desconto;
        this.valorBruto = valorBruto;
        this.valorPago = valorPago;
        this.encargos = encargos;
        this.numeroNota = numeroNota;
        this.favorecido = favorecido;
    }

    public BigDecimal getEncargos() {
        return encargos;
    }

    public void setEncargos(BigDecimal encargos) {
        this.encargos = encargos;
    }

    public BigDecimal getDesconto() {
        return desconto;
    }

    public void setDesconto(BigDecimal desconto) {
        this.desconto = desconto;
    }

    public BigDecimal getAcrecimo() {
        return acrecimo;
    }

    public void setAcrecimo(BigDecimal acrecimo) {
        this.acrecimo = acrecimo;
    }

    public BigDecimal getValorBruto() {
        return valorBruto;
    }

    public void setValorBruto(BigDecimal valorBruto) {
        this.valorBruto = valorBruto;
    }

    public BigDecimal getValorPago() {
        return valorPago;
    }

    public void setValorPago(BigDecimal valorPago) {
        this.valorPago = valorPago;
    }

    public String getFavorecido() {
        return favorecido;
    }

    public void setFavorecido(String favorecido) {
        this.favorecido = favorecido;
    }

    public String getNumeroNota() {
        return numeroNota;
    }

    public void setNumeroNota(String numeroNota) {
        this.numeroNota = numeroNota;
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
                "Nota fiscal de compra[" + ReceberPedidoController.getInstance().getNotaFiscal().getNumero_nota() + "] em [" + LocalDate.now() + "]",
                valorBruto,
                encargos,
                desconto,
                acrecimo,
                valorPago, meioPagamento, CaixaController.getInstance().getCaixaAberto(), StatusPagto.ABERTO);
        lista.add(contaPagar);
        flushObject();
    }

    public void gerarParcelas(BigDecimal valorPago, LocalDate dataVencimento, String favorecido, int parcelas, int intervalo) {
        int i;
        BigDecimal valParcela = valorPago.divide(BigDecimal.valueOf(parcelas), 4, RoundingMode.HALF_EVEN);
        this.lista = FXCollections.observableList(new ArrayList<>());
        for (i = 1; i <= parcelas; i++) {
            dataVencimento = (i > 1) ? dataVencimento.plusDays(intervalo) : dataVencimento;
            setContaPAgar(0,
                    (i > 1) ? dataVencimento.plusDays(intervalo) : dataVencimento,
                    null,
                    favorecido,
                    "Nota fiscal de compra[" + ReceberPedidoController.getInstance().getNotaFiscal().getNumero_nota() + "] Parcela nº [" + i + "]",
                    valParcela,
                    BigDecimal.ZERO,
                    BigDecimal.ZERO,
                    BigDecimal.ZERO,
                    valParcela, meioPagamento, CaixaController.getInstance().getCaixaAberto(), StatusPagto.ABERTO);
            lista.add(contaPagar);
            flushObject();
        }

    }

    public void efetuarLancamento() {
        lista.forEach((ll) -> {
            ll.setIdContaPagar(contaPagarDAO.save(ll));
        });
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
    
    private void flushObject() {
        this.contaPagar = new ContaPagar();
        this.contaPagar.setIdContaPagar(0l);
    }

}
