/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashf.controller.menu;

import com.cashf.dao.produto.GrupoDAO;
import com.cashf.dao.produto.ProdutoDAO;
import com.cashf.model.produto.Grupo;
import com.cashf.model.produto.Produto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author joao
 */
public class FCMenuController {

    public static FCMenuController FCmenuController = null;
    private Produto produtoAtual;
    private Grupo grupo;
    private ObservableList<Produto> listaProdutos;
    private ObservableList<Grupo> listaGrupos;
    private final GrupoDAO grupoDAO;
    private final ProdutoDAO produtoDAO;

    private FCMenuController() {
        this.produtoDAO = new ProdutoDAO(Produto.class);
        this.grupoDAO = new GrupoDAO(Grupo.class);
        this.listaGrupos = FXCollections.observableList(grupoDAO.listNotInsumos());
        this.listaProdutos = FXCollections.observableList(produtoDAO.listAll());
        this.produtoAtual = new Produto();
        this.produtoAtual.setIdProduto(0l);
        this.grupo = new Grupo();
        this.grupo.setIdGrupo(0l);
    }

    public static synchronized FCMenuController getInstance() {
        if (FCmenuController == null) {
            FCmenuController = new FCMenuController();
        }
        return FCmenuController;
    }

    public Produto getProdutoAtual() {
        return produtoAtual;
    }

    public void setProdutoAtual(Produto produtoAtual) {
        this.produtoAtual = produtoAtual;
    }

    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }

    public ObservableList<Produto> getListaProdutos() {
        return listaProdutos;
    }

    public void setListaProdutos(ObservableList<Produto> listaProdutos) {
        this.listaProdutos = listaProdutos;
    }

    public ObservableList<Grupo> getListaGrupos() {
        return listaGrupos;
    }

    public void setListaGrupos(ObservableList<Grupo> listaGrupos) {
        this.listaGrupos = listaGrupos;
    }
    public void buscaProdutosByGrupo(String idGrupo){
        listaProdutos=FXCollections.observableList(produtoDAO.listByGrupoId(idGrupo));
    }

}
