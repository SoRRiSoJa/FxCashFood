/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashf.controller.contacorrente;

import com.cashf.dao.banco.BancoDAO;
import com.cashf.dao.contacorrente.ContaCorrenteDAO;
import com.cashf.model.banco.Banco;
import com.cashf.model.contacorrente.ContaCorrente;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Aluno
 */
public class ContaCorrenteController {

    private final ContaCorrenteDAO contaCorrenteDAO;
    private final BancoDAO bancoDAO;
    private ContaCorrente contaCorrente;
    private Banco banco;
    private ObservableList<ContaCorrente> lista;
    private ObservableList<Banco> listaBanco;

    public ContaCorrenteController() {
        this.contaCorrenteDAO = new ContaCorrenteDAO(ContaCorrente.class);
        this.bancoDAO = new BancoDAO(Banco.class);
        this.contaCorrente = new ContaCorrente();
        this.banco = new Banco();
        this.lista = FXCollections.observableList(contaCorrenteDAO.listAll());
        this.listaBanco = FXCollections.observableList(bancoDAO.listAll());
        this.contaCorrente.setId(0l);
    }

    public ContaCorrente getContaCorrente() {
        return contaCorrente;
    }

    public void setContaCorrente(ContaCorrente contaCorrente) {
        this.contaCorrente = contaCorrente;
    }

    public void setContaCorrente(long id, String descricao, String agencia, String contaCorrente, Banco banco) {
        this.contaCorrente = new ContaCorrente(id, descricao, agencia, contaCorrente, banco);
    }

    public ObservableList<ContaCorrente> getLista() {
        return lista;
    }

    public Banco getBanco() {
        return banco;
    }

    public void setBanco(Banco banco) {
        this.banco = banco;
    }

    public void setLista(ObservableList<ContaCorrente> lista) {
        this.lista = lista;
    }

    public void setItenLista(ContaCorrente novaConta) {
        lista.add(novaConta);
    }

    public ObservableList<Banco> getListaBanco() {
        return listaBanco;
    }

    public void setListaBanco(ObservableList<Banco> listaBanco) {
        this.listaBanco = listaBanco;
    }

    public void insert() {
        contaCorrente.setId(contaCorrenteDAO.save(contaCorrente));
        setItenLista(contaCorrente);
        flushContaCorrente();

    }

    public void delete() {
        contaCorrenteDAO.delete(contaCorrente);
        lista.remove(contaCorrente);
        flushContaCorrente();
    }

    public void update() {
        contaCorrenteDAO.update(contaCorrente);
        flushContaCorrente();
    }

    private void flushContaCorrente() {
        contaCorrente = new ContaCorrente();
        contaCorrente.setId(0l);
    }

}
