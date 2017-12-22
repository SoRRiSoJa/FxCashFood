/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashf.controller.prepreparo;

import com.cashf.dao.prepreparo.PrePreparoDAO;
import com.cashf.dao.produto.ProdutoDAO;
import com.cashf.model.prepreparo.PrePreparo;
import com.cashf.model.prepreparo.ProdutoPrePreparo;
import com.cashf.model.produto.Produto;
import com.cashf.model.produto.UnidadeMedida;
import controller.GenericController;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author joao
 */
public class PrePreparoController implements GenericController<PrePreparo> {

    public static PrePreparoController prePreparoController = null;
    private PrePreparoDAO prePreparoDAO;
    private ProdutoDAO produtoDAO;
    private ObservableList<PrePreparo> lista;
    private ObservableList<Produto> listaCbbPrePreparo;
    private ObservableList<Produto> listaCbbItens;
    private ObservableList<ProdutoPrePreparo> listaItens;
    private Produto produtoPrincipal;
    private Produto itemAtual;
    private PrePreparo prePreparo;
    private UnidadeMedida unidadeMedida;

    private PrePreparoController() {
        this.produtoDAO = new ProdutoDAO(Produto.class);
        this.prePreparoDAO = new PrePreparoDAO(PrePreparo.class);
        this.lista = FXCollections.observableList(prePreparoDAO.listAll());
        this.listaCbbItens = FXCollections.observableList(produtoDAO.listProdInsumos());
        this.listaCbbPrePreparo = FXCollections.observableList(produtoDAO.listProdPrePreparo());
        this.listaItens = FXCollections.observableList(new ArrayList<>());
        this.prePreparo = new PrePreparo();
        this.prePreparo.setIdPrepreparo(0l);
        this.produtoPrincipal = new Produto();
        produtoPrincipal.setIdProduto(0l);
        this.itemAtual = new Produto();
        itemAtual.setIdProduto(0l);
    }

    public static synchronized PrePreparoController getInstance() {
        if (prePreparoController == null) {
            prePreparoController = new PrePreparoController();
        }
        return prePreparoController;
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
        this.produtoPrincipal = new Produto();
        produtoPrincipal.setIdProduto(0l);
        this.prePreparo = new PrePreparo();
        this.prePreparo.setIdPrepreparo(0l);
    }

    @Override
    public ObservableList<PrePreparo> getLista() {
        return lista;
    }

    @Override
    public void setLista(ObservableList<PrePreparo> lista) {
        this.lista = lista;
    }

    @Override
    public void setItenLista(PrePreparo obj) {
        lista.add(obj);
    }

    public PrePreparoDAO getPrePreparoDAO() {
        return prePreparoDAO;
    }

    public void setPrePreparoDAO(PrePreparoDAO prePreparoDAO) {
        this.prePreparoDAO = prePreparoDAO;
    }

    public ProdutoDAO getProdutoDAO() {
        return produtoDAO;
    }

    public void setProdutoDAO(ProdutoDAO produtoDAO) {
        this.produtoDAO = produtoDAO;
    }

    public ObservableList<Produto> getListaPrePreparo() {
        return listaCbbPrePreparo;
    }

    public void setListaPrePreparo(ObservableList<Produto> listaPrePreparo) {
        this.listaCbbPrePreparo = listaPrePreparo;
    }

    public ObservableList<Produto> getListaProduto() {
        return listaCbbItens;
    }

    public void setListaProduto(ObservableList<Produto> listaProduto) {
        this.listaCbbItens = listaProduto;
    }

    public ObservableList<ProdutoPrePreparo> getListaItens() {
        return listaItens;
    }

    public void setListaItens(ObservableList<ProdutoPrePreparo> listaItens) {
        this.listaItens = listaItens;
    }

    public void setListaItens(ProdutoPrePreparo item) {
        this.listaItens.add(item);
    }

    public PrePreparo getPrePreparo() {
        return prePreparo;
    }

    public void setPrePreparo(PrePreparo prePreparo) {
        this.prePreparo = prePreparo;
    }

    public UnidadeMedida getUnidadeMedida() {
        return unidadeMedida;
    }

    public void setUnidadeMedida(UnidadeMedida unidadeMedida) {
        this.unidadeMedida = unidadeMedida;
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
    

}
