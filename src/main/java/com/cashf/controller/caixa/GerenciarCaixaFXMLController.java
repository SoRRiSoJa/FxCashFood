/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashf.controller.caixa;

import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author joao
 */
public class GerenciarCaixaFXMLController implements Initializable {

    @FXML
    private TableView<?> tbvMovimentacoes;
    @FXML
    private TableColumn<?, ?> tbcDescricao;
    @FXML
    private TableColumn<?, ?> tbcTipo;
    @FXML
    private TableColumn<?, ?> tbcValor;
    @FXML
    private TableColumn<?, ?> tbcSaldo;
    @FXML
    private JFXButton btnAbrirCaixa;
    @FXML
    private JFXButton btnSuprir;
    @FXML
    private JFXButton btnSangrar;
    @FXML
    private JFXButton btnFecharCaixa;
    @FXML
    private Label lblTotalRecebido;
    @FXML
    private Label lblTotalPago;
    @FXML
    private Label lblSaldo;
    @FXML
    private TableView<?> tbvLista;
    @FXML
    private TableColumn<?, ?> tbcDataAb;
    @FXML
    private TableColumn<?, ?> tbcDataFe;
    @FXML
    private Pane paneRoot;

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
    private void onNovo(ActionEvent event) {
    }

    @FXML
    private void onExcluir(ActionEvent event) {
    }

    @FXML
    private void onLimpar(ActionEvent event) {
    }
    
}
