/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashf.controller.fichatecnica;

import com.cashf.dao.fichatecnica.FichaTecnicaDAO;
import com.cashf.dao.produto.ProdutoDAO;
import com.cashf.model.fichatecnica.FichaTecnica;
import com.cashf.model.fichatecnica.ProdutoFichaTecnica;
import com.cashf.model.produto.Produto;
import com.cashf.model.produto.UnidadeMedida;
import controller.GenericController;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author joao
 */
public class FichaTecnicaController implements GenericController<FichaTecnica> {
    public static FichaTecnicaController controller;
    private FichaTecnicaDAO fichaTecnicaDAO;
    private ProdutoDAO produtoDAO;
    private FichaTecnica fichaTecnica;
    private ObservableList<ProdutoFichaTecnica> listaItensFicha;
    private ObservableList<FichaTecnica> lista;
    private ObservableList<Produto> comboBoxItensFicha;
    private UnidadeMedida unidadeMedida;
    private FichaTecnicaController(){
        this.fichaTecnicaDAO=new FichaTecnicaDAO(FichaTecnica.class);
        this.produtoDAO=new ProdutoDAO(Produto.class);
        this.lista=FXCollections.observableList(fichaTecnicaDAO.listAll());
        this.comboBoxItensFicha=FXCollections.observableList(produtoDAO.listProdNotFicha());
    }
    public static synchronized FichaTecnicaController getInstance() {
        if (controller == null) {
            controller = new FichaTecnicaController();
        }
        return controller;
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
    public ObservableList<FichaTecnica> getLista() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setLista(ObservableList<FichaTecnica> lista) {
        
    }

    @Override
    public void setItenLista(FichaTecnica obj) {
        
    }

    public FichaTecnica getFichaTecnica() {
        return fichaTecnica;
    }

    public void setFichaTecnica(FichaTecnica fichaTecnica) {
        this.fichaTecnica = fichaTecnica;
    }

    public ObservableList<Produto> getComboBoxItensFicha() {
        return comboBoxItensFicha;
    }
    public ObservableList<Produto> getComboBoxFichaTecnica() {
        return FXCollections.observableList(produtoDAO.listProdFichaTecnica());
    }

    public UnidadeMedida getUnidadeMedida() {
        return unidadeMedida;
    }

    public void setUnidadeMedida(UnidadeMedida unidadeMedida) {
        this.unidadeMedida = unidadeMedida;
    }
    

   
    
    
}
