/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cahsf.controller.fornecedor;

import com.cahsf.dao.fornecedor.FornecedorDAO;
import com.cashf.dao.cidade.CidadeDAO;
import com.cashf.dao.telefone.TelefoneDAO;
import com.cashf.model.cidade.Cidade;
import com.cashf.model.fornecedor.Fornecedor;
import com.cashf.model.telefone.Operadora;
import com.cashf.model.telefone.Telefone;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author joao
 */
public class FornecedorController {

    private final FornecedorDAO fornecedorDAO;
    private final TelefoneDAO telefoneDAO;
    private final CidadeDAO cidadeDAO;
    private ObservableList<Fornecedor> lista;
    private ObservableList<Telefone> listaTelefone;
    private ObservableList<Cidade> listaCidade;
    private List<Telefone> lt;
    private Telefone telefone;
    private Operadora operadora;
    private Fornecedor fornecedor;
    private Cidade cidade;

    public FornecedorController() {
        this.lt = new ArrayList<>();
        this.cidadeDAO = new CidadeDAO(Cidade.class);
        this.telefoneDAO = new TelefoneDAO(Telefone.class);
        this.fornecedorDAO = new FornecedorDAO(Fornecedor.class);
        this.listaCidade = FXCollections.observableList(cidadeDAO.listAll());
        this.lista = FXCollections.observableList(fornecedorDAO.listAll());
        this.listaTelefone = FXCollections.observableList(lt);
        this.telefone = new Telefone();
        this.fornecedor = new Fornecedor();
        this.cidade = new Cidade();
        telefone.setIdTelefone(0l);
        fornecedor.setIdFornecedor(0l);
    }

    public ObservableList<Cidade> getListaCidade() {
        return listaCidade;
    }

    public void setListaCidade(ObservableList<Cidade> listaCidade) {
        this.listaCidade = listaCidade;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public ObservableList<Fornecedor> getLista() {
        return lista;
    }

    public void setItemLista(Fornecedor item) {
        this.lista.add(item);
    }

    public ObservableList<Telefone> getListaTelefone() {
        return listaTelefone;
    }

    public void setListaTelefone(ObservableList<Telefone> listaTelefone) {
        this.listaTelefone = listaTelefone;
    }

    public void setItemListaTelefone(Telefone telefone) {
        this.listaTelefone.add(telefone);
    }

    public Telefone getTelefone() {
        return telefone;
    }

    public void setTelefone(Telefone telefone) {
        this.telefone = telefone;
    }

    public void setTelefone(long id, String ddd, String numero) {
        this.telefone = new Telefone(id, ddd, numero, operadora);
    }

    public Operadora getOperadora() {
        return operadora;
    }

    public void setOperadora(Operadora operadora) {
        this.operadora = operadora;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public void setFornecedor(long id, String cnpj, String nomefantasia, String razaoSocial, String endereco, String complemento, int numero, String cep, String bairro, String email, String Observacao, Cidade cidade, List<Telefone> telefones) {
        this.fornecedor = new Fornecedor(id, cnpj, nomefantasia, razaoSocial, endereco, complemento, numero, cep, bairro, email, Observacao, cidade, telefones);
    }

    public void insert() {
        fornecedor.setIdFornecedor(fornecedorDAO.save(fornecedor));
        setItemLista(fornecedor);
        flushFornecedor();
    }

    public void inserTelefone() {
        telefone.setIdTelefone(telefoneDAO.save(telefone));
        setItemListaTelefone(telefone);
        flushTelefone();
    }

    public void deleteTelefone() {
        telefoneDAO.delete(telefone);
        listaTelefone.remove(telefone);
        flushTelefone();
    }

    public void updateTelefone() {
        telefoneDAO.update(telefone);
        flushTelefone();
    }

    public void delete() {
        fornecedorDAO.delete(fornecedor);
        lista.remove(fornecedor);
        flushFornecedor();
    }

    public void update() {
        fornecedorDAO.update(fornecedor);
        flushFornecedor();
    }

    private void flushFornecedor() {
        fornecedor = new Fornecedor();
        fornecedor.setIdFornecedor(0l);
    }

    private void flushTelefone() {
        telefone = new Telefone();
        telefone.setIdTelefone(0l);
    }

}
