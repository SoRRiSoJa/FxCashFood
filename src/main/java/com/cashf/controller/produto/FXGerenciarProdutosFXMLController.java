/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashf.controller.produto;

import com.jfoenix.controls.JFXTabPane;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Tab;

/**
 * FXML Controller class
 *
 * @author joao
 */
public class FXGerenciarProdutosFXMLController implements Initializable {

    @FXML
    private JFXTabPane tabPane;
    @FXML
    private Tab tabProdutos;
    @FXML
    private Tab tabListaProdutos;
    //------
    private static JFXTabPane _tabPane;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        _tabPane=tabPane;
    }    

    public static JFXTabPane getTabPane() {
        return _tabPane;
    }

    public static void setTabPane(JFXTabPane _tabPane) {
        FXGerenciarProdutosFXMLController._tabPane = _tabPane;
    }
    
}
