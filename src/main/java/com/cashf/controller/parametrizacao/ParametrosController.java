/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashf.controller.parametrizacao;

import com.cashf.dao.cidade.CidadeDAO;
import com.cashf.dao.parametros.ParametrosDAO;
import com.cashf.dao.usuario.UsuarioDAO;
import com.cashf.model.cidade.Cidade;
import com.cashf.model.parametros.Parametros;
import com.cashf.model.usuario.UNivel;
import com.cashf.model.usuario.Usuario;
import controller.GenericController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author joao
 */
public class ParametrosController implements GenericController<Parametros> {

    public static ParametrosController parametrosController = null;
    private final ParametrosDAO parametrosDAO;
    private final UsuarioDAO usuarioDAO;
    private final CidadeDAO cidadeDAO;
    private ObservableList<Parametros> lista;
    private ObservableList<Cidade> listaCidade;
    private Cidade cidade;
    private Parametros parametro;
    private Usuario usuario;

    private ParametrosController() {
        this.parametrosDAO = new ParametrosDAO(Parametros.class);
        this.usuarioDAO = new UsuarioDAO(Usuario.class);
        this.cidadeDAO = new CidadeDAO(Cidade.class);
        this.lista = FXCollections.observableList(parametrosDAO.listAll());
        this.parametro = new Parametros();
        this.usuario = new Usuario();
        this.parametro.setIdParametro(0l);
        this.usuario.setId(0l);
        this.cidade = new Cidade();
    }

    public static synchronized ParametrosController getInstance() {
        if (parametrosController == null) {
            parametrosController = new ParametrosController();
        }
        return parametrosController;
    }

    public Parametros getParametro() {
        return parametro;
    }

    public void setParametro(Parametros parametro) {
        this.parametro = parametro;
    }

    public void setParametro(long idParametro, String cnpj, String inscrEst, String nomefantasia, String razaoSocial, String endereco, String complemento, int numero, String cep, String bairro, String email, String telefone, Cidade cidade, byte[] foto) {
        this.parametro = new Parametros(idParametro, cnpj, inscrEst, nomefantasia, razaoSocial, endereco, complemento, numero, cep, bairro, email, telefone, cidade, foto);
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void setUsuario(Long id, String login, String senha, UNivel nivel, Boolean status) {
        this.usuario = new Usuario(id, login, senha, nivel, status);
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

    @Override
    public void insert() {
        parametrosDAO.save(parametro);
    }

    @Override
    public void update() {
        parametrosDAO.update(parametro);
    }

    @Override
    public void delete() {
        if (parametro.getIdParametro() != 0l) {
            parametrosDAO.delete(parametro);
        }
    }

    @Override
    public void flushObject() {
        this.parametro = new Parametros();
        this.parametro.setIdParametro(0l);
    }

    @Override
    public ObservableList<Parametros> getLista() {
        return lista;
    }

    @Override
    public void setLista(ObservableList<Parametros> lista) {
        this.lista = lista;
    }

    @Override
    public void setItenLista(Parametros obj) {
        this.lista.add(obj);
    }
}
