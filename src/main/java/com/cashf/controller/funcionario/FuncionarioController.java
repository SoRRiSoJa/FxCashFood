/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashf.controller.funcionario;

import com.cashf.dao.cidade.CidadeDAO;
import com.cashf.dao.funcionario.FuncionarioDAO;
import com.cashf.dao.telefone.TelefoneDAO;
import com.cashf.dao.usuario.UsuarioDAO;
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
import util.SafePass;

/**
 *
 * @author Aluno
 */
public class FuncionarioController implements GenericController<Funcionario> {
    public static FuncionarioController funcionarioController=null;
    private final FuncionarioDAO funcionarioDAO;
    private final UsuarioDAO usuarioDAO;
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
    private Usuario usuario;
    private int tipoConsulta;

    private FuncionarioController() {
        this.funcionarioDAO = new FuncionarioDAO(Funcionario.class);
        this.usuario = new Usuario();
        this.usuarioDAO = new UsuarioDAO(Usuario.class);
        this.funcionario = new Funcionario();
        this.lista=FXCollections.observableList(funcionarioDAO.listAll());
        this.lt = new ArrayList<>();
        this.cidadeDAO = new CidadeDAO(Cidade.class);
        this.telefoneDAO = new TelefoneDAO(Telefone.class);
        this.listaCidade = FXCollections.observableList(cidadeDAO.listAll());
        this.listaTelefone = FXCollections.observableList(lt);
        this.telefone = new Telefone();
        this.cidade = new Cidade();
        telefone.setIdTelefone(0l);
        funcionario.setIdPessoa(0l);
        this.usuario=new Usuario();
        usuario.setId(0l);
    }
    public static synchronized FuncionarioController getInstance() {
        if (funcionarioController == null) {
            funcionarioController = new FuncionarioController();
        }
        return funcionarioController;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public void setFuncionario(Long id, String nome, Sexo sexo, LocalDate dataNas, String endereco, String bairro, Integer numero, String complemento, String cep, Cidade cidade, String cpf, String rg, String email, List<Telefone> telefones, Boolean status, String ctps, BigDecimal salarioIncial, BigDecimal salarioAtual, BigDecimal vrDia, BigDecimal vtDia, LocalDate dataAdimissao, LocalDate dataDemissao, Usuario usuario) {
        this.funcionario.setIdPessoa(id);
        this.funcionario.setNome(nome);
        this.funcionario.setEndereco(endereco);
        this.funcionario.setSexo(sexo);
        this.funcionario.setDataNas(dataNas);
        this.funcionario.setBairro(bairro);
        this.funcionario.setNumero(numero);
        this.funcionario.setComplemento(complemento);
        this.funcionario.setCep(cep);
        this.funcionario.setCidade(cidade);
        this.funcionario.setCpf(cpf);
        this.funcionario.setRg(rg);
        this.funcionario.setEmail(email);
        //--
        this.funcionario.setCtps(ctps);
        this.funcionario.setDataAdimissao(dataAdimissao);
        this.funcionario.setDataDemissao(dataDemissao);
        this.funcionario.setSalarioIncial(salarioIncial);
        this.funcionario.setSalarioAtual(salarioAtual);
        this.funcionario.setVrDia(vrDia);
        this.funcionario.setVtDia(vtDia);
        this.funcionario.setUsuario(usuario);
    }

    public ObservableList<Telefone> getListaTelefone() {
        return listaTelefone;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    public void setUsuario(Long id,String login,String senha,UNivel nivel,Boolean status) {
        this.usuario = new Usuario(id, login, SafePass.crypPass(senha), nivel, status);
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
        funcionario.setUsuario(usuario);
        funcionario.setTelefones(listaTelefone);
        funcionario.setIdPessoa(funcionarioDAO.save(funcionario));
        lista.add(funcionario);
        flushObject();
        flushUsuario();
        flushTelefone();
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
        listaTelefone.remove(telefone);
        funcionario.getTelefones().clear();
        funcionario.setTelefones(listaTelefone);
        funcionarioDAO.update(funcionario);
        telefoneDAO.delete(telefone);
        flushTelefone();
    }

    public void updateTelefone() {
        telefoneDAO.update(telefone);
        flushTelefone();
    }
    public void inserUsuario() {
        usuario.setId(usuarioDAO.save(usuario));
    }

    public void deleteUsuario() {
        usuarioDAO.delete(usuario);
        flushUsuario();
    }

    public void updateUsuario() {
        usuarioDAO.update(usuario);
        flushUsuario();
    }
    public void flushUsuario() {
        usuario = new Usuario();
        usuario.setId(0l);
    }


    @Override
    public void flushObject() {
        this.lista=FXCollections.observableList(funcionarioDAO.listAll());
        this.lt = new ArrayList<>();
        this.listaCidade = FXCollections.observableList(cidadeDAO.listAll());
        this.listaTelefone = FXCollections.observableList(lt);
        this.usuario = new Usuario();
        funcionario = new Funcionario();
        funcionario.setIdPessoa(0l);
        this.telefone = new Telefone();
        this.cidade = new Cidade();
        telefone.setIdTelefone(0l);
        funcionario.setIdPessoa(0l);
        this.usuario=new Usuario();
        usuario.setId(0l);
    }

    @Override
    public ObservableList<Funcionario> getLista() {
        return this.lista;
    }

    @Override
    public void setLista(ObservableList<Funcionario> lista) {

    }

    @Override
    public void setItenLista(Funcionario obj) {

    }

    public int getTipoConsulta() {
        return tipoConsulta;
    }

    public void setTipoConsulta(int tipoConsulta) {
        this.tipoConsulta = tipoConsulta;
    }
    public void buscaNome(String nome){
        lista=FXCollections.observableList(funcionarioDAO.listByName(nome));
    }
    public void buscaCpf(String cpf){
        lista=FXCollections.observableList(funcionarioDAO.listByCPF(cpf));
    }

}
