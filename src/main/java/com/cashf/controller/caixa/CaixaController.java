/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashf.controller.caixa;

import com.cashf.controller.login.LoginController;
import com.cashf.dao.caixa.CaixaDAO;
import com.cashf.dao.caixamovimento.CaixaMovimentoDAO;
import com.cashf.model.caixa.Caixa;
import com.cashf.model.caixa.CaixaMovimento;
import com.cashf.model.caixa.Caixa_;
import com.cashf.model.caixa.TPMov;
import com.cashf.model.usuario.Usuario;
import controller.GenericController;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author joao
 */
public class CaixaController implements GenericController<Caixa> {

    public static CaixaController controller = null;
    private final CaixaDAO caixaDAO;
    private final CaixaMovimentoDAO caixaMovimentoDAO;
    private ObservableList<Caixa> lista;
    private ObservableList<CaixaMovimento> listaMov;
    private Caixa caixa;
    private Caixa caixaAberto;
    private CaixaMovimento caixaMovimento;
    private TPMov tipoMovimento;
    private int tipoConsulta;

    private CaixaController() {
        this.caixaDAO = new CaixaDAO(Caixa.class);
        this.caixaMovimentoDAO = new CaixaMovimentoDAO(CaixaMovimento.class);
        this.lista = FXCollections.observableList(caixaDAO.listAll());
        this.caixa = new Caixa();
        this.caixaAberto = new Caixa();
        this.caixaMovimento = new CaixaMovimento();
        this.caixa.setIdCaixa(0l);
        this.caixaAberto.setIdCaixa(0l);
        this.caixaMovimento.setIdCaixaMovimento(0l);
        this.listaMov = FXCollections.observableList(new ArrayList<>());
    }

    public static synchronized CaixaController getInstance() {
        if (controller == null) {
            controller = new CaixaController();
        }
        return controller;
    }

    public ObservableList<CaixaMovimento> getListaMov() {
        return listaMov;
    }

    public void setListaMov(ObservableList<CaixaMovimento> listaMov) {
        this.listaMov = listaMov;
    }

    public Caixa getCaixa() {
        return caixa;
    }

    public void setCaixa(Caixa caixa) {
        this.caixa = caixa;
    }

    public void setCaixa(long idCaixa, LocalDate dataAbertura, LocalDate dataFechamento, BigDecimal valorInicial, Usuario usuario) {
        this.caixa.setIdCaixa(idCaixa);
        this.caixa.setDataAbertura(LocalDate.now());
        this.caixa.setDataFechamento(dataFechamento);
        this.caixa.setValorInicial(valorInicial);
        this.caixa.setUsuario(usuario);
    }

    public Caixa getCaixaAberto() {
        return caixaAberto;
    }

    public void setCaixaAberto(long idCaixa, LocalDate dataAbertura,LocalTime horaAbertura, LocalDate dataFechamento,LocalTime horaFechamento, BigDecimal valorInicial, Usuario usuario) {
        this.caixaAberto.setIdCaixa(idCaixa);
        this.caixaAberto.setDataAbertura(dataAbertura);
        this.caixaAberto.setHoraAbertura(horaAbertura);
        this.caixaAberto.setDataFechamento(dataFechamento);
        this.caixaAberto.setHoraFechamento(horaFechamento);
        this.caixaAberto.setValorInicial(valorInicial);
        this.caixaAberto.setUsuario(usuario);
    }

    public CaixaMovimento getCaixaMovimento() {
        return caixaMovimento;
    }

    public void setCaixaMovimento(CaixaMovimento caixaMovimento) {
        this.caixaMovimento = caixaMovimento;
    }
    public void setCaixaMovimento(long idCaixaMovimento, LocalDate data, String observacao, BigDecimal valor, TPMov tipoMovimento, Caixa caixa) {
        this.caixaMovimento.setIdCaixaMovimento(idCaixaMovimento);
        this.caixaMovimento.setData(data);
        this.caixaMovimento.setObservacao(observacao);
        this.caixaMovimento.setValor(valor);
        this.caixaMovimento.setTipoMovimento(tipoMovimento);
        this.caixaMovimento.setCaixa(caixa);
    }

    public TPMov getTipoMovimento() {
        return tipoMovimento;
    }

    public void setTipoMovimento(TPMov tipoMovimento) {
        this.tipoMovimento = tipoMovimento;
    }

    public int getTipoConsulta() {
        return tipoConsulta;
    }

    public void setTipoConsulta(int tipoConsulta) {
        this.tipoConsulta = tipoConsulta;
    }

    @Override
    public void insert() {

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
    public ObservableList<Caixa> getLista() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setLista(ObservableList<Caixa> lista) {
        this.lista = lista;
    }

    @Override
    public void setItenLista(Caixa obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void sangrarCaixa() {
    }

    public void suprirCaixa() {
    }

    public void abrirCaixa(LocalDate dataAbertura,LocalTime horaAbertura, BigDecimal valorInicial) {
        setCaixaAberto(0l, dataAbertura,horaAbertura, null,null, valorInicial, LoginController.getInstance().getUsuario());
        this.caixaAberto.setIdCaixa(caixaDAO.save(caixa));
        setCaixaMovimento(0l, dataAbertura, "* LANÇAMENTO INICIAL - ABERTURA CAIXA *", valorInicial, TPMov.CREDITO, getCaixaAberto());
        this.caixaMovimento.setIdCaixaMovimento(caixaMovimentoDAO.save(caixaMovimento));
        listaMov.add(caixaMovimento);
        caixaMovimento=null;
        caixaMovimento=new CaixaMovimento();
        this.caixaMovimento.setIdCaixaMovimento(0l);
    }

    public void fecharCaixa() {
    }

}
