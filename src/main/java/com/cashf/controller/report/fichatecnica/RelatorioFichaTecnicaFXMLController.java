/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashf.controller.report.fichatecnica;

import com.cashf.model.fichatecnica.FichaTecnica;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author joao
 */
public class RelatorioFichaTecnicaFXMLController implements Initializable {

    @FXML
    private Pane paneRoot;
    @FXML
    private JFXButton btnImprimir;
    @FXML
    private JFXButton btnLimpar;
    @FXML
    private JFXTextField txtTotal;
    @FXML
    private JFXTextField txtVAlorIncial;
    @FXML
    private Label lblSaldo;
    @FXML
    private JFXButton btnPesquisar;
    @FXML
    private JFXComboBox<FichaTecnica> cbbFicha;

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

    @FXML
    private void onPesquisar(ActionEvent event) {
    }

    @FXML
    private void onFicha(ActionEvent event) {
    }
    
}
