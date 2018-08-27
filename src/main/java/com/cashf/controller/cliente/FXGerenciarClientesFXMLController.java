/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashf.controller.cliente;

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
public class FXGerenciarClientesFXMLController implements Initializable {

    @FXML
    private Pane paneRoot;
    @FXML
    private JFXTabPane TabPaneClientes;
    @FXML
    private Tab tabClientes;
    @FXML
    private Tab tabListaClientes;
    //------
    private static  JFXTabPane _tabPane;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        _tabPane=TabPaneClientes;
    }    

    public static JFXTabPane getTabPane() {
        return _tabPane;
    }

    public static void setTabPane(JFXTabPane _tabPane) {
        FXGerenciarClientesFXMLController._tabPane = _tabPane;
    }
    
}
