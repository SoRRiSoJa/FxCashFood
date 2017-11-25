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
import com.cashf.model.pessoa.Sexo;
import com.cashf.model.telefone.Operadora;
import com.cashf.model.telefone.Telefone;
import com.cashf.model.usuario.UNivel;
import com.cashf.model.usuario.Usuario;
import controller.GenericController;
import java.math.BigDecimal;
import java.time.LocalDate;
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
    private Sexo sexo;
    private UNivel nivel;

    public FuncionarioController() {
        this.funcionarioDAO = new FuncionarioDAO(Funcionario.class);
        this.funcionario = new Funcionario();
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

    public void setFuncionario(Long id, String nome, Sexo sexo, LocalDate dataNas, String endereco, String bairro, Integer numero, String complemento, String cep, Cidade cidade, String cpf, String rg, String email, List<Telefone> telefones, Boolean status, long id_funcionario, String ctps, BigDecimal salarioIncial, BigDecimal salarioAtual, BigDecimal vrDia, BigDecimal vtDia, LocalDate dataAdimissao, LocalDate dataDemissao, Usuario usuario) {
        this.funcionario = new Funcionario(id, nome, sexo, dataNas, endereco, bairro, numero, complemento, cep, cidade, cpf, rg, email, telefones, status, 0, ctps, salarioIncial, salarioAtual, vrDia, vtDia, dataAdimissao, dataDemissao, usuario);
    }

    public ObservableList<Telefone> getListaTelefone() {
        return listaTelefone;
    }

    public void setItemListaTelefone(Telefone telefone) {
        this.listaTelefone.add(telefone);
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

    private void flushTelefone() {
        telefone = new Telefone();
        telefone.setIdTelefone(0l);
    }

    public void setTelefone(long id, String ddd, String numero) {
        this.telefone = new Telefone(id, ddd, numero, operadora);
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

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public UNivel getNivel() {
        return nivel;
    }

    public void setNivel(UNivel nivel) {
        this.nivel = nivel;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    @Override
    public void insert() {
        funcionario.setIdPessoa(funcionarioDAO.save(funcionario));
        lista.add(funcionario);
        flushObject();

    }

    @Override
    public void update() {
        funcionarioDAO.update(funcionario);
        flushObject();
    }

    @Override
    public void delete() {
        if (funcionario.getIdPessoa() != 0l) {
            funcionarioDAO.delete(funcionario);
            lista.remove(funcionario);
            flushObject();
        }
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

    @Override
    public void flushObject() {
        funcionario = new Funcionario();
        funcionario.setIdPessoa(0l);
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
