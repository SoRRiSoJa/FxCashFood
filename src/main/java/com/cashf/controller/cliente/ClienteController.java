/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashf.controller.cliente;

import com.cashf.dao.cidade.CidadeDAO;
import com.cashf.dao.cliente.ClienteDAO;
import com.cashf.dao.telefone.TelefoneDAO;
import com.cashf.model.cidade.Cidade;
import com.cashf.model.cliente.Cliente;
import com.cashf.model.pessoa.Sexo;
import com.cashf.model.telefone.Operadora;
import com.cashf.model.telefone.Telefone;
import controller.GenericController;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author joao
 */
public class ClienteController implements GenericController<Cliente>{

    private final TelefoneDAO telefoneDAO;
    private final CidadeDAO cidadeDAO;
    private final ClienteDAO clienteDAO;
    private Cliente cliente;
    private ObservableList<Cliente> lista;
    private ObservableList<Telefone> listaTelefone;
    private ObservableList<Cidade> listaCidade;
    private List<Telefone> lt;
    private Telefone telefone;
    private Operadora operadora;
    private Cidade cidade;
    private Sexo sexo;

    public ClienteController() {
        this.lt = new ArrayList<>();
        this.clienteDAO = new ClienteDAO(Cliente.class);
        this.cidadeDAO = new CidadeDAO(Cidade.class);
        this.telefoneDAO = new TelefoneDAO(Telefone.class);
        this.lista = FXCollections.observableList(clienteDAO.listAll());
        this.listaCidade = FXCollections.observableList(cidadeDAO.listAll());
        this.listaTelefone = FXCollections.observableList(lt);
        this.telefone = new Telefone();
        this.cidade = new Cidade();
        telefone.setIdTelefone(0l);
        this.cliente = new Cliente();
        cliente.setIdPessoa(0l);
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    public void setCliente(Long id, String nome, Sexo sexo, LocalDate dataNas, String endereco, String bairro, Integer numero, String complemento, String cep, Cidade cidade, String cpf, String rg, String email,Boolean status,List<Telefone> telefones,String observacao) {
        this.cliente.setIdPessoa(id);
        this.cliente.setNome(nome);
        this.cliente.setSexo(sexo);
        this.cliente.setDataNas(dataNas);
        this.cliente.setEndereco(endereco);
        this.cliente.setBairro(bairro);
        this.cliente.setNumero(numero);
        this.cliente.setComplemento(complemento);
        this.cliente.setCep(cep);
        this.cliente.setCidade(cidade);
        this.cliente.setCpf(cpf);
        this.cliente.setRg(rg);
        this.cliente.setEmail(email);
        this.cliente.setStatus(status);
        this.cliente.setObservacao(observacao);
        this.cliente.setTelefones(telefones);
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
    public void setTelefone(long id, String ddd, String numero) {
        this.telefone = new Telefone(id, ddd, numero, operadora);
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

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }
    
    @Override
    public void insert() {
        cliente.setIdPessoa(clienteDAO.save(cliente));
        lista.add(cliente);
        flushObject();
    }

    @Override
    public void update() {
        updateTelefone();
        clienteDAO.update(cliente);
        flushObject();
    }

    @Override
    public void delete() {
        clienteDAO.delete(cliente);
        lista.remove(cliente);
        flushObject();
    }

    @Override
    public void flushObject() {
        this.cliente = new Cliente();
        cliente.setIdPessoa(0l);
    }

    @Override
    public ObservableList<Cliente> getLista() {
        return this.lista;
    }

    @Override
    public void setLista(ObservableList<Cliente> lista) {
        this.lista=lista;
    }

    @Override
    public void setItenLista(Cliente obj) {
        this.lista.add(obj);
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
    private void flushTelefone() {
        telefone = new Telefone();
        telefone.setIdTelefone(0l);
    }


}
