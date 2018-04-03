/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashf.controller.ajusteestoque;

import com.cashf.core.atualizarestoque.AtualizarEstoque;
import com.cashf.dao.produto.ProdutoDAO;
import com.cashf.model.ajusteestoque.AjusteEstoque;
import com.cashf.model.ajusteestoque.TipoAjuste;
import com.cashf.model.produto.Produto;
import com.cashf.model.produto.UnidadeMedida;
import controller.GenericController;
import java.math.BigDecimal;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author joao
 */
public class AjusteEstoqueController implements GenericController<AjusteEstoque> {

    private final ProdutoDAO produtoDAO;
    private ObservableList<Produto> listaProduto;
    private TipoAjuste tipoAjuste;
    private UnidadeMedida unidadeMedida;
    private BigDecimal qtdeAjuste;
    private final AtualizarEstoque atualizarEstoque;
    private int tipoConsulta;

    public AjusteEstoqueController() {
        this.produtoDAO = new ProdutoDAO(Produto.class);
        this.listaProduto = FXCollections.observableList(produtoDAO.listProdNotFicha());
        this.atualizarEstoque = new AtualizarEstoque();
    }

    @Override
    public void insert() {
        atualizarEstoque.atualizar();
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
        return this.atualizarEstoque.getProduto();
    }

    public void setProduto(Produto produto) {
        this.atualizarEstoque.setProduto(produto);
    }

    public TipoAjuste getTipoAjuste() {
        return tipoAjuste;
    }

    public void setTipoAjuste(TipoAjuste tipoAjuste) {
        this.tipoAjuste = tipoAjuste;
    }

    public BigDecimal getQtdeAjuste() {
        return qtdeAjuste;
    }

    public void setQtdeAjuste(BigDecimal qtdeAjuste) {
        this.qtdeAjuste = qtdeAjuste;
    }

    public AtualizarEstoque getAtualizarEstoque() {
        return atualizarEstoque;
    }

    public UnidadeMedida getUnidadeMedida() {
        return unidadeMedida;
    }

    public void setUnidadeMedida(UnidadeMedida unidadeMedida) {
        this.unidadeMedida = unidadeMedida;
    }

    public void refreshListaPRod() {
        this.listaProduto = FXCollections.observableList(produtoDAO.listProdNotFicha());
    }

    public boolean adicionarProduto() {
        return atualizarEstoque.adicionarProduto(qtdeAjuste, unidadeMedida);
    }

    public boolean retirarProduto() {
        return atualizarEstoque.retirarProduto(qtdeAjuste, unidadeMedida);
    }
    void buscaCodRef(String text) {
        this.listaProduto = FXCollections.observableList(produtoDAO.listProdInsumosCodRef(text));
    }
    void buscaInsumosDesc(String text) {
        this.listaProduto = FXCollections.observableList(produtoDAO.listProdInsumosDesc(text));
    }
    void buscaInsumosTodos() {
        this.listaProduto = FXCollections.observableList(produtoDAO.listProdInsumos());
    }

    public int getTipoConsulta() {
        return tipoConsulta;
    }

    public void setTipoConsulta(int tipoConsulta) {
        this.tipoConsulta = tipoConsulta;
    }
    
}
