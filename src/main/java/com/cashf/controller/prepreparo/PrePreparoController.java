/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashf.controller.prepreparo;

import com.cashf.dao.prepreparo.PrePreparoDAO;
import com.cashf.dao.produto.ProdutoDAO;
import com.cashf.model.prepreparo.PrePreparo;
import com.cashf.model.produto.Produto;
import com.cashf.model.produto.UnidadeMedida;
import controller.GenericController;
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
    private ObservableList<Produto> listaProduto;
    private ObservableList<Produto> listaItens;
    private PrePreparo prePreparo;
    private UnidadeMedida unidadeMedida;
    private Produto produtoPrincipal;
    private Produto itemAtual;

    private PrePreparoController() {
        this.produtoDAO = new ProdutoDAO(Produto.class);
        this.prePreparoDAO = new PrePreparoDAO(PrePreparo.class);
        this.listaProduto = FXCollections.observableList(produtoDAO.listProdNotFicha());
        this.prePreparo = new PrePreparo();
        this.prePreparo.setIdPrepreparo(0l);
        this.produtoPrincipal = new Produto();
        produtoPrincipal.setIdProduto(0l);
        this.itemAtual = new Produto();
        itemAtual.setIdProduto(0l);
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
        this.itemAtual = new Produto();
        itemAtual.setIdProduto(0l);
        this.prePreparo = new PrePreparo();
        this.prePreparo.setIdPrepreparo(0l);
    }

    @Override
    public ObservableList<PrePreparo> getLista() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setLista(ObservableList<PrePreparo> lista) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setItenLista(PrePreparo obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
