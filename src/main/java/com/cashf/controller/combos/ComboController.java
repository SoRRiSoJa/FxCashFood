/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashf.controller.combos;

import com.cashf.dao.combo.ComboDAO;
import com.cashf.model.combo.Combo;
import controller.GenericController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author joao
 */
public class ComboController implements GenericController<Combo> {

    public static ComboController comboController = null;
    private final ComboDAO comboDAO;
    private Combo combo;
    private ObservableList<Combo> lista;

    private ComboController() {
        this.comboDAO = new ComboDAO(Combo.class);
        this.lista = FXCollections.observableList(comboDAO.listAll());
        this.combo = new Combo();
        this.combo.setIdCombo(0l);
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ObservableList<Combo> getLista() {
        return lista;
    }

    @Override
    public void setLista(ObservableList<Combo> lista) {
        this.lista=lista;
    }

    @Override
    public void setItenLista(Combo obj) {
        this.lista.add(obj);
    }

}
