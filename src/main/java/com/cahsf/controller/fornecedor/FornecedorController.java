/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cahsf.controller.fornecedor;

import com.cahsf.dao.fornecedor.FornecedorDAO;
import com.cashf.dao.telefone.TelefoneDAO;
import com.cashf.model.fornecedor.Fornecedor;
import com.cashf.model.telefone.Operadora;
import com.cashf.model.telefone.Telefone;
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
    private ObservableList<Fornecedor> lista;
    private ObservableList<Telefone> listaTelefone;
    private Telefone telefone;
    private Operadora operadora;
    private Fornecedor fornecedor;

    public FornecedorController() {
        this.telefoneDAO=new TelefoneDAO(Telefone.class);
        this.fornecedorDAO=new FornecedorDAO(Fornecedor.class);
        this.lista = FXCollections.observableList(fornecedorDAO.listAll());
        this.telefone = new Telefone();
        this.fornecedor = new Fornecedor();
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
    public void setTelefone(long id,Operadora operadora, String ddd,String numero) {
        this.telefone =new Telefone(id, ddd, numero, operadora);
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
    public void setFornecedor(long id, String cnpj, String nomefantasia, String razaoSocial, String endereco, String complemento, int numero, String cep, String bairro, String email, String Observacao, List<Telefone> telefones) {
        this.fornecedor = new Fornecedor(id, cnpj, nomefantasia, razaoSocial, endereco, complemento, numero, cep, bairro, email, Observacao, telefones);
    }
    
    public void insert(){
        fornecedorDAO.save(fornecedor);
        setItemLista(fornecedor);
    }
    public void delete(){
        fornecedorDAO.delete(fornecedor);
        lista.remove(fornecedor);
    }
    public void update(){
        fornecedorDAO.update(fornecedor);
    }
    
    
}
