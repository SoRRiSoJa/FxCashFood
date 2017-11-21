/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashf.controller.meiopagamento;

import com.cashf.model.contacorrente.ContaCorrente;
import com.cashf.model.meiopagamento.MeioPagamento;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXRadioButton;
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
public class MeioPagamentoFXMLController implements Initializable {

    @FXML
    private Pane paneData;
    @FXML
    private JFXComboBox<ContaCorrente> cbbContaCorrente;
    @FXML
    private JFXTextField txtNome;
    @FXML
    private JFXTextField txtPrazo;
    @FXML
    private JFXRadioButton rdbDinheiro;
    @FXML
    private JFXRadioButton rdbDebito;
    @FXML
    private JFXRadioButton rdbCredito;
    @FXML
    private JFXTextField txtTaxa;
    @FXML
    private JFXButton btnSalvar;
    @FXML
    private JFXButton btnNovo;
    @FXML
    private JFXButton btnExcluir;
    @FXML
    private JFXButton btnLimpar;
    @FXML
    private TableView<MeioPagamento> tbvCartoes;
    @FXML
    private TableColumn<MeioPagamento, String> tbcCartao;
    @FXML
    private TableColumn<MeioPagamento, String> tbcConta;

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

    @FXML
    private void onMouseClicked(MouseEvent event) {
    }
    
}
