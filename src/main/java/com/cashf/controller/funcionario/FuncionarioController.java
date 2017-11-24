/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashf.controller.funcionario;

import com.cashf.dao.cidade.CidadeDAO;
import com.cashf.dao.funcionario.FuncionarioDAO;
import com.cashf.dao.telefone.TelefoneDAO;
import com.cashf.model.cidade.Cidade;
import com.cashf.model.funcionario.Funcionario;
import com.cashf.model.telefone.Operadora;
import com.cashf.model.telefone.Telefone;
import controller.GenericController;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Aluno
 */
public class FuncionarioController implements GenericController<Funcionario> {

    private final FuncionarioDAO funcionarioDAO;
    private Funcionario funcionario;
    private ObservableList<Funcionario> lista;
    private final TelefoneDAO telefoneDAO;
    private final CidadeDAO cidadeDAO;
    private ObservableList<Telefone> listaTelefone;
    private ObservableList<Cidade> listaCidade;
    private List<Telefone> lt;
    private Telefone telefone;
    private Operadora operadora;
    private Cidade cidade;

    public FuncionarioController() {
        this.funcionarioDAO=new FuncionarioDAO(Funcionario.class);
        this.funcionario=new Funcionario();
        this.lt = new ArrayList<>();
        this.cidadeDAO = new CidadeDAO(Cidade.class);
        this.telefoneDAO = new TelefoneDAO(Telefone.class);
        this.listaCidade = FXCollections.observableList(cidadeDAO.listAll());
        this.listaTelefone = FXCollections.observableList(lt);
        this.telefone = new Telefone();
        this.cidade = new Cidade();
        telefone.setIdTelefone(0l);
        funcionario.setIdPessoa(0l);
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public ObservableList<Telefone> getListaTelefone() {
        return listaTelefone;
    }

    public void setListaTelefone(ObservableList<Telefone> listaTelefone) {
        this.listaTelefone = listaTelefone;
    }

    public ObservableList<Cidade> getListaCidade() {
        return listaCidade;
    }

    public void setListaCidade(ObservableList<Cidade> listaCidade) {
        this.listaCidade = listaCidade;
    }

    public Telefone getTelefone() {
        return telefone;
    }

    public void setTelefone(Telefone telefone) {
        this.telefone = telefone;
    }

    public Operadora getOperadora() {
        return operadora;
    }

    public void setOperadora(Operadora operadora) {
        this.operadora = operadora;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }
    
    @Override
    public void insert() {

    }

    @Override
    public void update() {

    }

    @Override
    public void delete() {

    }

    @Override
    public void flushObject() {

    }

    @Override
    public ObservableList<Funcionario> getLista() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setLista(ObservableList<Funcionario> lista) {

    }

    @Override
    public void setItenLista(Funcionario obj) {

    }

}
