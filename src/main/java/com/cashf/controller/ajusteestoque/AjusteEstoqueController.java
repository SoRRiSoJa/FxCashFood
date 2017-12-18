/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashf.controller.ajusteestoque;

import com.cashf.dao.ajusteestoque.AjusteEstoqueDAO;
import com.cashf.dao.produto.ProdutoDAO;
import com.cashf.model.ajusteestoque.AjusteEstoque;
import com.cashf.model.ajusteestoque.TipoAjuste;
import com.cashf.model.produto.Produto;
import controller.GenericController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author joao
 */
public class AjusteEstoqueController implements GenericController<AjusteEstoque> {

    private final AjusteEstoqueDAO ajusteEstoqueDAO;
    private final ProdutoDAO produtoDAO;
    private ObservableList<Produto> listaProduto;
    private Produto produto;
    private AjusteEstoque ajusteEstoque;
    private TipoAjuste tipoAjuste;

    public AjusteEstoqueController() {
        this.produtoDAO = new ProdutoDAO(Produto.class);
        this.ajusteEstoqueDAO=new AjusteEstoqueDAO(AjusteEstoque.class);
        this.listaProduto = FXCollections.observableList(produtoDAO.listInsumosAndPrepreparo());
        this.produto = new Produto();
        produto.setIdProduto(0l);
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
    public ObservableList<AjusteEstoque> getLista() {
        return null;
    }

    @Override
    public void setLista(ObservableList<AjusteEstoque> lista) {

    }

    @Override
    public void setItenLista(AjusteEstoque obj) {

    }

    public ObservableList<Produto> getListaProduto() {
        return listaProduto;
    }

    public void setListaProduto(ObservableList<Produto> listaProduto) {
        this.listaProduto = listaProduto;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public AjusteEstoque getAjusteEstoque() {
        return ajusteEstoque;
    }

    public void setAjusteEstoque(AjusteEstoque ajusteEstoque) {
        this.ajusteEstoque = ajusteEstoque;
    }

    public TipoAjuste getTipoAjuste() {
        return tipoAjuste;
    }

    public void setTipoAjuste(TipoAjuste tipoAjuste) {
        this.tipoAjuste = tipoAjuste;
    }
    
}
