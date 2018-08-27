/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashf.controller.fornecedor;

import com.jfoenix.controls.JFXTabPane;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Tab;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author joao
 */
public class FXGerenciarFornecedoresFXMLController implements Initializable {

    @FXML
    private Pane paneFornecedor;
    @FXML
    private JFXTabPane tabPane;
    @FXML
    private Tab tabFornecedor;
    @FXML
    private Tab tabListaFornecedores;
    //------
    private static  JFXTabPane _tabPane;;
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
        FXGerenciarFornecedoresFXMLController._tabPane = _tabPane;
    }

    
    
}
