/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashf.controller.report.contaspagar;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;

/**
 * FXML Controller class
 *
 * @author joao
 */
public class RelatorioContasPagarFXMLController implements Initializable {

    @FXML
    private JFXButton btnImprimir;
    @FXML
    private JFXButton btnLimpar;
    @FXML
    private JFXTextField txtTotalInt;
    @FXML
    private JFXTextField txtQtdeTitulos;
    @FXML
    private JFXDatePicker dtpDataIni;
    @FXML
    private Label lblSaldo;
    @FXML
    private JFXDatePicker dtpDataFin;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void onSalvar(ActionEvent event) {
    }

    @FXML
    private void onLimpar(ActionEvent event) {
    }

    @FXML
    private void onKeyReleasedQtdeAjuste(KeyEvent event) {
    }
    
}
