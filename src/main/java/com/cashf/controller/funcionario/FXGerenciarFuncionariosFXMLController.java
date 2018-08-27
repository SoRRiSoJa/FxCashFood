/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashf.controller.funcionario;

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
public class FXGerenciarFuncionariosFXMLController implements Initializable {

    @FXML
    private Pane rootPane;
    @FXML
    private JFXTabPane tabPane;
    @FXML
    private Tab tabFuncionario;
    @FXML
    private Tab tabListaFuncionarios;
    //-----------
    private static Tab  _tabFuncionario;
    private static Tab _tabListaFuncionarios;
    private static JFXTabPane _tabPane;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        _tabFuncionario=tabFuncionario;
        _tabListaFuncionarios=tabListaFuncionarios;
        _tabPane=tabPane;
    }

    public static Tab getTabFuncionario() {
        return _tabFuncionario;
    }

    public static void setTabFuncionario(Tab _tabFuncionario) {
        FXGerenciarFuncionariosFXMLController._tabFuncionario = _tabFuncionario;
    }

    public static Tab getTabListaFuncionarios() {
        return _tabListaFuncionarios;
    }

    public static void setTabListaFuncionarios(Tab _tabListaFuncionarios) {
        FXGerenciarFuncionariosFXMLController._tabListaFuncionarios = _tabListaFuncionarios;
    }

    public static JFXTabPane getTabPane() {
        return _tabPane;
    }

    public static void setTabPane(JFXTabPane _tabPane) {
        FXGerenciarFuncionariosFXMLController._tabPane = _tabPane;
    }
    
    
}
