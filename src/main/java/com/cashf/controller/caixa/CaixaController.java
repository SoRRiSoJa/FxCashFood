/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashf.controller.caixa;

import com.cashf.controller.login.LoginController;
import com.cashf.dao.caixa.CaixaDAO;
import com.cashf.dao.caixamovimento.CaixaMovimentoDAO;
import com.cashf.dao.contacorrente.ContaCorrenteDAO;
import com.cashf.dao.contaspagar.ContaPagarDAO;
import com.cashf.model.caixa.Caixa;
import com.cashf.model.caixa.CaixaMovimento;
import com.cashf.model.caixa.TPMov;
import com.cashf.model.caixa.TPStatusCX;
import com.cashf.model.contacorrente.ContaCorrente;
import com.cashf.model.contasPagar.ContaPagar;
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
    private final ContaPagarDAO contasPagarDAO;
    private final ContaCorrenteDAO contaCorrenteDAO;
    private ObservableList<Caixa> lista;
    private ObservableList<CaixaMovimento> listaMov;
    private ObservableList<ContaCorrente> listaConta;
    private Caixa caixa;
    private Caixa caixaAberto;
    private CaixaMovimento caixaMovimento;
    private ContaCorrente contaCorrente;
    private TPMov tipoMovimento;
    private int tipoConsulta;
    private BigDecimal totalDebitos = BigDecimal.ZERO;
    private BigDecimal totalCreditos = BigDecimal.ZERO;
    private BigDecimal saldoFinal = BigDecimal.ZERO;
    private BigDecimal saldoConta = BigDecimal.ZERO;


    private CaixaController() {
        this.caixaDAO = new CaixaDAO(Caixa.class);
        this.contasPagarDAO = new ContaPagarDAO(ContaPagar.class);
        this.contaCorrenteDAO = new ContaCorrenteDAO(ContaCorrente.class);
        this.caixaMovimentoDAO = new CaixaMovimentoDAO(CaixaMovimento.class);
        this.lista = FXCollections.observableList(caixaDAO.listAll());
        this.listaConta = FXCollections.observableList(contaCorrenteDAO.listCcaixa());
        try {
            this.caixaAberto = caixaDAO.getCaixaAberto();
            this.listaMov = FXCollections.observableList(caixaMovimentoDAO.listByDateAndCaixa(caixaAberto.getDataAbertura(), caixaAberto));
            atualizaSaldo();
        } catch (Exception ex) {
            this.caixaAberto = new Caixa();
            this.caixaAberto.setIdCaixa(0l);
            this.listaMov = FXCollections.observableList(new ArrayList<>());

        }
        this.caixaMovimento = new CaixaMovimento();
        this.caixa = new Caixa();
        this.caixa.setIdCaixa(0l);
        this.caixaMovimento.setIdCaixaMovimento(0l);
        this.contaCorrente = new ContaCorrente();
        this.contaCorrente.setId(0l);
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

    public void setCaixa(long idCaixa, LocalDate dataAbertura, LocalDate dataFechamento, BigDecimal valorInicial, Usuario usuario, ContaCorrente contaCorrente, TPStatusCX status) {
        this.caixa.setIdCaixa(idCaixa);
        this.caixa.setDataAbertura(LocalDate.now());
        this.caixa.setDataFechamento(dataFechamento);
        this.caixa.setValorInicial(valorInicial);
        this.caixa.setUsuario(usuario);
        this.caixa.setContaCorrente(contaCorrente);
        this.caixa.setStatus(status);
    }

    public Caixa getCaixaAberto() {
        return caixaAberto;
    }

    public void setCaixaAberto(long idCaixa, LocalDate dataAbertura, LocalTime horaAbertura, LocalDate dataFechamento, LocalTime horaFechamento, BigDecimal valorInicial, Usuario usuario, ContaCorrente contaCorrente, TPStatusCX status) {
        this.caixaAberto.setIdCaixa(idCaixa);
        this.caixaAberto.setDataAbertura(dataAbertura);
        this.caixaAberto.setHoraAbertura(horaAbertura);
        this.caixaAberto.setDataFechamento(dataFechamento);
        this.caixaAberto.setHoraFechamento(horaFechamento);
        this.caixaAberto.setValorInicial(valorInicial);
        this.caixaAberto.setUsuario(usuario);
        this.caixaAberto.setContaCorrente(contaCorrente);
        this.caixaAberto.setStatus(status);
    }

    public CaixaMovimento getCaixaMovimento() {
        return caixaMovimento;
    }

    public void setCaixaMovimento(CaixaMovimento caixaMovimento) {
        this.caixaMovimento = caixaMovimento;
    }

    public void setCaixaMovimento(long idCaixaMovimento, LocalDate data, String observacao, BigDecimal valor, TPMov tipoMovimento, Caixa caixa) {
        this.caixaMovimento.setIdCaixaMovimento(idCaixaMovimento);
        this.caixaMovimento.setDataMovimento(data);
        this.caixaMovimento.setObservacao(observacao);
        this.caixaMovimento.setValor(valor);
        this.caixaMovimento.setTipoMovimento(tipoMovimento);
        this.caixaMovimento.setCaixa(caixa);
    }

    public BigDecimal getTotalDebitos() {
        return totalDebitos;
    }

    public BigDecimal getTotalCreditos() {
        return totalCreditos;
    }

    public BigDecimal getSaldoFinal() {
        return saldoFinal;
    }

    public TPMov getTipoMovimento() {
        return tipoMovimento;
    }
    public BigDecimal getSaldoConta() {
        return saldoConta;
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

    public void sangrarCaixa(BigDecimal valor) {
        setCaixaMovimento(0l, caixaAberto.getDataAbertura(), "SANGRIA DE CAIXA", valor, TPMov.SANGRIA, getCaixaAberto());
        getCaixaAberto().getContaCorrente().setSaldo(getCaixaAberto().getContaCorrente().getSaldo().subtract(valor));
        contaCorrenteDAO.update(getCaixaAberto().getContaCorrente());
        this.caixaMovimento.setIdCaixaMovimento(caixaMovimentoDAO.save(caixaMovimento));
        listaMov.add(caixaMovimento);
        caixaMovimento = null;
        caixaMovimento = new CaixaMovimento();
        this.caixaMovimento.setIdCaixaMovimento(0l);

        atualizaSaldo();
    }

    public void movimentarCaixaDebito(String desc, BigDecimal valor) {
        setCaixaMovimento(0l, LocalDate.now(), desc, valor, TPMov.DEBITO, getCaixaAberto());
        getCaixaAberto().getContaCorrente().setSaldo(getCaixaAberto().getContaCorrente().getSaldo().subtract(valor));
        contaCorrenteDAO.update(getCaixaAberto().getContaCorrente());
        this.caixaMovimento.setIdCaixaMovimento(caixaMovimentoDAO.save(caixaMovimento));
        listaMov.add(caixaMovimento);
        caixaMovimento = null;
        caixaMovimento = new CaixaMovimento();
        this.caixaMovimento.setIdCaixaMovimento(0l);

        atualizaSaldo();
    }

    public void movimentarCaixaCredito(String desc, BigDecimal valor) {
        setCaixaMovimento(0l, LocalDate.now(), desc, valor, TPMov.CREDITO, getCaixaAberto());
        getCaixaAberto().getContaCorrente().setSaldo(getCaixaAberto().getContaCorrente().getSaldo().add(valor));
        contaCorrenteDAO.update(getCaixaAberto().getContaCorrente());
        
        this.caixaMovimento.setIdCaixaMovimento(caixaMovimentoDAO.save(caixaMovimento));
        listaMov.add(caixaMovimento);
        caixaMovimento = null;
        caixaMovimento = new CaixaMovimento();
        this.caixaMovimento.setIdCaixaMovimento(0l);
        atualizaSaldo();
    }

    public void suprirCaixa(BigDecimal valor) {
        setCaixaMovimento(0l, caixaAberto.getDataAbertura(), "SUPRIMENTO DE CAIXA", valor, TPMov.SUPRIMENTO, getCaixaAberto());
        getCaixaAberto().getContaCorrente().setSaldo(getCaixaAberto().getContaCorrente().getSaldo().add(valor));
        contaCorrenteDAO.update(getCaixaAberto().getContaCorrente());
        
        this.caixaMovimento.setIdCaixaMovimento(caixaMovimentoDAO.save(caixaMovimento));
        
        listaMov.add(caixaMovimento);
        caixaMovimento = null;
        caixaMovimento = new CaixaMovimento();
        this.caixaMovimento.setIdCaixaMovimento(0l);

        atualizaSaldo();
    }

    public void abrirCaixa(LocalDate dataAbertura, LocalTime horaAbertura, BigDecimal valorInicial) {
        setCaixaAberto(0l, dataAbertura, horaAbertura, null, null, valorInicial, LoginController.getInstance().getUsuario(), getContaCorrente(), TPStatusCX.ABERTO);
        this.caixaAberto.setIdCaixa(caixaDAO.save(caixaAberto));
        setCaixaMovimento(0l, dataAbertura, "* LANÇAMENTO INICIAL - ABERTURA CAIXA *", valorInicial, TPMov.SUPRIMENTO, getCaixaAberto());
        this.caixaMovimento.setIdCaixaMovimento(caixaMovimentoDAO.save(caixaMovimento));
        getCaixaAberto().getContaCorrente().setSaldo(getCaixaAberto().getContaCorrente().getSaldo().add(valorInicial));
        contaCorrenteDAO.update(getCaixaAberto().getContaCorrente());
        listaMov.add(caixaMovimento);
        caixaMovimento = null;
        caixaMovimento = new CaixaMovimento();
        this.caixaMovimento.setIdCaixaMovimento(0l);

        atualizaSaldo();
    }

    public void fecharCaixa() {
        caixaAberto.setDataFechamento(LocalDate.now());
        caixaAberto.setHoraFechamento(LocalTime.now());
        caixaAberto.setStatus(TPStatusCX.FECHADO);
        caixaDAO.update(caixaAberto);
        caixaAberto = null;
        this.caixaAberto = new Caixa();
        this.caixaAberto.setIdCaixa(0l);
        this.listaMov = FXCollections.observableList(new ArrayList<>());

        atualizaSaldo();
    }

    public void refreshLists() {
        this.listaMov = FXCollections.observableList(caixaMovimentoDAO.listByDateAndCaixa(caixaAberto.getDataAbertura(), caixaAberto));
        this.lista = FXCollections.observableList(caixaDAO.listAll());
    }

    /**
     * Atualiza os valores totais de Creditos Débitos e o saldo final apartir
     * dos movimentos de caixa. public void atualizaSaldo()
     */
    public void atualizaSaldo() {
        totalCreditos = BigDecimal.ZERO;
        totalDebitos = BigDecimal.ZERO;
        saldoFinal = BigDecimal.ZERO;
        refreshLists();

        listaMov.forEach((cm) -> {
            if (cm.getTipoMovimento().equals(TPMov.SUPRIMENTO) || cm.getTipoMovimento().equals(TPMov.CREDITO)) {
                totalCreditos = totalCreditos.add(cm.getValor());
            } else {
                totalDebitos = totalDebitos.add(cm.getValor());
            }
        });
        saldoConta=getCaixaAberto().getContaCorrente().getSaldo();
        saldoFinal = totalCreditos.subtract(totalDebitos);
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

    public BigDecimal getTotalContasPagarCaixa(Caixa caixaAberto) {
        return contasPagarDAO.getTotalContas(caixaAberto);
    }
}
