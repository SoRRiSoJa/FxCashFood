/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javafx.collections.ObservableList;

/**
 *
 * @author Aluno
 */
public interface GenericController <T>{
    public void insert();
    public void update();
    public void delete();
    public void flushObject();
    ObservableList<T> getLista();
    public void setLista(ObservableList<T> lista);
    public void setItenLista(T obj);
    
}
