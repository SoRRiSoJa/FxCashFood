/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashf.controller.produto;

import com.cashf.dao.produto.CategoriaDAO;
import com.cashf.dao.produto.GrupoDAO;
import com.cashf.model.produto.Categoria;
import com.cashf.model.produto.Grupo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author joao
 */
public class GrupoController {

    private final GrupoDAO grupoDAO;
    private final CategoriaDAO categoriaDAO;
    private ObservableList<Grupo> lista;
    private ObservableList<Categoria> listaCategria;
    private Grupo grupo;
    private Categoria categoria;

    public GrupoController() {
        this.grupoDAO = new GrupoDAO(Grupo.class);
        this.categoriaDAO = new CategoriaDAO(Categoria.class);
        this.lista = FXCollections.observableList(grupoDAO.listAll());
        this.listaCategria = FXCollections.observableList(categoriaDAO.listAll());
        this.grupo = new Grupo();
        this.categoria = new Categoria();
        this.grupo.setIdGrupo(0);
        this.categoria.setIdCategoria(0);
    }

    public ObservableList<Grupo> getLista() {
        return lista;
    }

    public void setLista(ObservableList<Grupo> lista) {
        this.lista = lista;
    }

    public void setItemLista(Grupo item) {
        this.lista.add(item);
    }

    public ObservableList<Categoria> getListaCategria() {
        return listaCategria;
    }

    public void setListaCategria(ObservableList<Categoria> listaCategria) {
        this.listaCategria = listaCategria;
    }

    public void setItemListaCategria(Categoria categria) {
        this.listaCategria.add(categria);
    }

    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }

    public void setGrupo(long id, String descricao) {
        this.grupo = new Grupo(id, descricao, categoria);
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public void setCategoria(long id, String descricao) {
        this.categoria = new Categoria(id, descricao);
    }

    public void insert() {
        grupoDAO.save(grupo);
        setItemLista(grupo);
    }
    public void inssertCategoria(){
        categoriaDAO.save(categoria);
        listaCategria.add(categoria);
    }
    public void deleteCategoria(){
        categoriaDAO.delete(categoria);
        listaCategria.remove(categoria);
    }
    public void uppdateCategoria(){
        categoriaDAO.update(categoria);
    }

    public void delete() {
        grupoDAO.delete(grupo);
        lista.remove(grupo);
    }

    public void update() {
        grupoDAO.update(grupo);
    }

}
