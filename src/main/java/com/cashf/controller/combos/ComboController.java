/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashf.controller.combos;

import com.cashf.dao.combo.ComboDAO;
import com.cashf.dao.produto.ProdutoDAO;
import com.cashf.model.combo.Combo;
import com.cashf.model.combo.ProdutoCombo;
import com.cashf.model.produto.Produto;
import com.cashf.model.produto.UnidadeMedida;
import controller.GenericController;
import java.math.BigDecimal;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author joao
 */
public class ComboController implements GenericController<Combo> {

    public static ComboController comboController = null;
    private final ComboDAO comboDAO;
    private final ProdutoDAO produtoDAO;
    private Combo combo;
    private Produto produtoPrincipal;
    private Produto itemAtual;
    private ObservableList<Combo> lista;
    private ObservableList<Produto> listaProdutos;
    private ObservableList<Produto> listaCbb;
    private ObservableList<ProdutoCombo> listaProdutosCombo;
    private int tipoConsulta;

    private ComboController() {
        this.comboDAO = new ComboDAO(Combo.class);
        this.produtoDAO = new ProdutoDAO(Produto.class);
        this.lista = FXCollections.observableList(comboDAO.listAll());
        this.listaProdutos = FXCollections.observableList(produtoDAO.listProdToCombo());
        this.listaCbb = FXCollections.observableList(produtoDAO.listProdCombo());
        this.listaProdutosCombo = FXCollections.observableList(new ArrayList<>());
        this.produtoPrincipal = new Produto();
        this.produtoPrincipal.setIdProduto(0l);
        this.combo = new Combo();
        this.combo.setIdCombo(0l);
    }

    public ObservableList<Produto> getListaCbb() {
        return listaCbb;
    }

    public void setListaCbb(ObservableList<Produto> listaCbb) {
        this.listaCbb = listaCbb;
    }

    public int getTipoConsulta() {
        return tipoConsulta;
    }

    public void setTipoConsulta(int tipoConsulta) {
        this.tipoConsulta = tipoConsulta;
    }

    public static synchronized ComboController getInstance() {
        if (comboController == null) {
            comboController = new ComboController();
        }
        return comboController;
    }

    @Override
    public void insert() {
        combo.setIdCombo(comboDAO.save(combo));
    }

    @Override
    public void update() {
        comboDAO.update(combo);
    }

    @Override
    public void delete() {
        comboDAO.delete(combo);
    }

    @Override
    public void flushObject() {
        combo = new Combo();
        combo.setIdCombo(0);

    }

    @Override
    public ObservableList<Combo> getLista() {
        return lista;
    }

    @Override
    public void setLista(ObservableList<Combo> lista) {
        this.lista = lista;
    }

    @Override
    public void setItenLista(Combo obj) {
        this.lista.add(obj);
    }

    public Combo getCombo() {
        return combo;
    }

    public void setCombo(Combo combo) {
        this.combo = combo;
    }

    public Produto getProdutoPrincipal() {
        return produtoPrincipal;
    }

    public void setProdutoPrincipal(Produto produtoPrincipal) {
        this.produtoPrincipal = produtoPrincipal;
    }

    public Produto getItemAtual() {
        return itemAtual;
    }

    public void setItemAtual(Produto itemAtual) {
        this.itemAtual = itemAtual;
    }

    public ObservableList<Produto> getListaProdutos() {
        return listaProdutos;
    }

    public void setListaProdutos(ObservableList<Produto> listaProdutos) {
        this.listaProdutos = listaProdutos;
    }

    public ObservableList<ProdutoCombo> getListaProdutosCombo() {
        return listaProdutosCombo;
    }

    public void setListaProdutosCombo(ObservableList<ProdutoCombo> listaProdutosCombo) {
        this.listaProdutosCombo = listaProdutosCombo;
    }

    public void setListaProdutosCombo(long idProdutoCombo, Combo combo, Produto produto, UnidadeMedida unidadeMedida, BigDecimal qtdeProduto, BigDecimal valorDiferenciado, Boolean valorDif, Integer sequencia) {
        this.listaProdutosCombo.add(new ProdutoCombo(idProdutoCombo, combo, produto, UnidadeMedida.UN, qtdeProduto, BigDecimal.ZERO, false, 0));

        this.listaProdutosCombo = listaProdutosCombo;
    }
    public void buscaComboCodRef(String text) {
        this.listaProdutos = FXCollections.observableList(produtoDAO.listProdToComboCodRef(text));
    }

    public void buscaComboDesc(String text) {
        this.listaProdutos = FXCollections.observableList(produtoDAO.listProdToComboDesc(text));
    }

    public void buscaComboTodos() {
        this.listaProdutos = FXCollections.observableList(produtoDAO.listProdToCombo());
    }

    void buscaDesc(String text) {
        //lista = FXCollections.observableList(comboDAO.listByDesc(text));
    }

    

    void buscaTodos() {
        //lista = FXCollections.observableList(comboDAO.listAll());
    }


}
