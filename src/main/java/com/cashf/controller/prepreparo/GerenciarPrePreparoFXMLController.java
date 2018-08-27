/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashf.controller.prepreparo;

import com.jfoenix.controls.JFXTabPane;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author joao
 */
public class GerenciarPrePreparoFXMLController implements Initializable {

    @FXML
    private JFXTabPane tabPane;
    private static JFXTabPane _tabPane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        _tabPane = tabPane;
    }

    public static JFXTabPane getTabPane() {
        return _tabPane;
    }

    public static void setTabPane(JFXTabPane _tabPane) {
        GerenciarPrePreparoFXMLController._tabPane = _tabPane;
    }

}
