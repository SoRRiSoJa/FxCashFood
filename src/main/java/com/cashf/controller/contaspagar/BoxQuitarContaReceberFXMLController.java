/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashf.controller.contaspagar;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

/**
 * FXML Controller class
 *
 * @author joao
 */
public class BoxQuitarContaReceberFXMLController implements Initializable {

    @FXML
    private StackPane paneRoot;
    @FXML
    private Pane paneCentral;
    @FXML
    private JFXDatePicker dtpDataVencimento;
    @FXML
    private Label lblFavorecido;
    @FXML
    private JFXButton btnQuitar;
    @FXML
    private JFXButton btnCancelar;
    @FXML
    private JFXTextField txtValor;
    @FXML
    private JFXDatePicker dtpDataPagamento;
    @FXML
    private JFXTextField txtAcrecimos;
    @FXML
    private JFXComboBox<?> cbbFormaPagamento;
    @FXML
    private Label lblDescricao;
    @FXML
    private JFXTextField txtDescontos;

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
    }

    @FXML
    private void onKeyReleasedAcrecimos(KeyEvent event) {
    }

    @FXML
    private void onMouseClickedFormaDePagamento(MouseEvent event) {
    }

    @FXML
    private void onKeyReleasedDescontos(KeyEvent event) {
    }
    
}
