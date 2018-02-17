/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashf.controller.receberpedido;

import com.cashf.dao.fornecedor.FornecedorDAO;
import com.cashf.dao.produto.ProdutoDAO;
import com.cashf.model.fornecedor.Fornecedor;
import com.cashf.model.produto.Produto;
import com.cashf.model.produto.UnidadeMedida;
import java.util.Arrays;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author joao
 */
public class ReceberPedidoController {

    private final ProdutoDAO produtoDAO;
    private final FornecedorDAO fornecedorDAO;
    private Fornecedor fornecedor;
    private Produto produtoAtual;

    public ReceberPedidoController() {
        this.produtoDAO = new ProdutoDAO(Produto.class);
        this.fornecedorDAO = new FornecedorDAO(Fornecedor.class);
        this.fornecedor = new Fornecedor();
        this.produtoAtual = new Produto();
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public Produto getProdutoAtual() {
        return produtoAtual;
    }

    public void setProdutoAtual(Produto produtoAtual) {
        this.produtoAtual = produtoAtual;
    }

    public ObservableList<Fornecedor> loadComboFornecedor() {
        return FXCollections.observableList(fornecedorDAO.listAll());
    }

    public ObservableList<Produto> loadComboProduto() {
        return FXCollections.observableList(produtoDAO.listAll());
    }

    public List<UnidadeMedida> loadComboUnidadeMedida() {
        return Arrays.asList(UnidadeMedida.values());
    }

}
