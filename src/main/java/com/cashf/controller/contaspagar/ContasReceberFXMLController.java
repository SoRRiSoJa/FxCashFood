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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author joao
 */
public class ContasReceberFXMLController implements Initializable {

    @FXML
    private Pane rootPane;
    @FXML
    private Pane paneData;
    @FXML
    private JFXDatePicker dtpDataVencimento;
    @FXML
    private JFXComboBox<?> cbbFormaPagamento;
    @FXML
    private JFXTextField txtFavorecido;
    @FXML
    private JFXTextField txtDescricao;
    @FXML
    private JFXTextField txtValor;
    @FXML
    private JFXTextField txtEncargos;
    @FXML
    private JFXTextField txtValorDesconto;
    @FXML
    private JFXTextField txtValorTaxa;
    @FXML
    private JFXTextField txtLiquido;
    @FXML
    private JFXButton btnSalvar;
    @FXML
    private JFXButton btnNovo;
    @FXML
    private JFXButton btnLimpar;
    @FXML
    private Pane paneData1;
    @FXML
    private TableView<?> tbvContas;
    @FXML
    private TableColumn<?, ?> tbcFavorecido;
    @FXML
    private TableColumn<?, ?> tbcDescricao;
    @FXML
    private TableColumn<?, ?> tbcVencimento;
    @FXML
    private TableColumn<?, ?> tbcValor;
    @FXML
    private TableColumn<?, ?> tbcStatus;
    @FXML
    private TableColumn<?, ?> btnQuitar;
    @FXML
    private TableColumn<?, ?> btnCancelar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void onMouseClickedFormaDePagamento(MouseEvent event) {
    }

    @FXML
    private void onSalvar(ActionEvent event) {
    }

    @FXML
    private void onNovo(ActionEvent event) {
    }

    @FXML
    private void onLimpar(ActionEvent event) {
    }

    @FXML
    private void onMouseClickedContaPagar(MouseEvent event) {
    }
    
}
