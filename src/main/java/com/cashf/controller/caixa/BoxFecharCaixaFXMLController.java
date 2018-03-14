
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashf.controller.caixa;

import com.cashf.cashfood.MainApp;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTimePicker;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author joao
 */
public class BoxFecharCaixaFXMLController implements Initializable {

    @FXML
    private Pane paneRoot;
    @FXML
    private JFXDatePicker dtpDataFechamento;
    @FXML
    private JFXTimePicker dtpHoraFechamento;
    @FXML
    private Label lblUsuario;
    @FXML
    private JFXButton btnFecharCaixa;
    @FXML
    private JFXButton btnCancelar;
    @FXML
    private JFXTextField txtSaldo;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void onAbrir(ActionEvent event) {
    }

    @FXML
    private void onCancelar(ActionEvent event) {
        MainApp.janelaAberta.close();
        MainApp.janelaAberta = MainApp.janelaAnterior;
    }

}
