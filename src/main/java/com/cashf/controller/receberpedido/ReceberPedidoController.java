/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashf.controller.receberpedido;

import com.cashf.dao.fornecedor.FornecedorDAO;
import com.cashf.dao.produto.ProdutoDAO;
import com.cashf.model.fornecedor.Fornecedor;
import com.cashf.model.notafiscal.NotaFiscal;
import com.cashf.model.notafiscal.ProdutoNotaFiscal;
import com.cashf.model.produto.Produto;
import com.cashf.model.produto.UnidadeMedida;
import controller.GenericController;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author joao
 */
public class ReceberPedidoController implements GenericController<NotaFiscal>{

    private final ProdutoDAO produtoDAO;
    private final FornecedorDAO fornecedorDAO;
    private Fornecedor fornecedor;
    private Produto produtoAtual;
    private NotaFiscal notaFiscal;
    private UnidadeMedida unidadeMedida;
    private ObservableList<ProdutoNotaFiscal> listaProdutosNota;

    public ReceberPedidoController() {
        this.produtoDAO = new ProdutoDAO(Produto.class);
        this.fornecedorDAO = new FornecedorDAO(Fornecedor.class);
        this.fornecedor = new Fornecedor();
        this.produtoAtual = new Produto();
        this.listaProdutosNota=FXCollections.observableList(new ArrayList<>());
        this.notaFiscal=new NotaFiscal();
        this.notaFiscal.setIdNota(0l);
        this.produtoAtual.setIdProduto(0l);
        this.fornecedor.setIdFornecedor(0l);
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

    @Override
    public void insert() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void flushObject() {
        this.fornecedor = new Fornecedor();
        this.produtoAtual = new Produto();
        this.listaProdutosNota=FXCollections.observableList(new ArrayList<>());
        this.notaFiscal=new NotaFiscal();
        this.notaFiscal.setIdNota(0l);
        this.produtoAtual.setIdProduto(0l);
        this.fornecedor.setIdFornecedor(0l);
    }

    @Override
    public ObservableList<NotaFiscal> getLista() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setLista(ObservableList<NotaFiscal> lista) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setItenLista(NotaFiscal obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public NotaFiscal getNotaFiscal() {
        return notaFiscal;
    }

    public void setNotaFiscal(NotaFiscal notaFiscal) {
        this.notaFiscal = notaFiscal;
    }

    public ObservableList<ProdutoNotaFiscal> getListaProdutosNota() {
        return listaProdutosNota;
    }

    public void setListaProdutosNota(ObservableList<ProdutoNotaFiscal> listaProdutosNota) {
        this.listaProdutosNota = listaProdutosNota;
    }
    public void setListaProdutosNota(Long idProdutoNotaFiscal,Integer qtdeProduto, BigDecimal valoruUnitario) {
        this.listaProdutosNota.add(new ProdutoNotaFiscal(idProdutoNotaFiscal, notaFiscal, produtoAtual, qtdeProduto,valoruUnitario,valoruUnitario.multiply(BigDecimal.valueOf(qtdeProduto.doubleValue()))));
    }

    public UnidadeMedida getUnidadeMedida() {
        return unidadeMedida;
    }

    public void setUnidadeMedida(UnidadeMedida unidadeMedida) {
        this.unidadeMedida = unidadeMedida;
    }

}
