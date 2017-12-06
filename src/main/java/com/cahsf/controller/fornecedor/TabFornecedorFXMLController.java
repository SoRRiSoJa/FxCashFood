/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cahsf.controller.fornecedor;

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
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author joao
 */
public class TabFornecedorFXMLController implements Initializable {

    @FXML
    private JFXDatePicker dtpDataCad;
    @FXML
    private JFXTextField txtRazao;
    @FXML
    private JFXTextField txtNome;
    @FXML
    private JFXTextField txtEndereco;
    @FXML
    private JFXTextField txtNumero;
    @FXML
    private JFXTextField txtComplemento;
    @FXML
    private JFXTextField txtCep;
    @FXML
    private JFXTextField txtBairro;
    @FXML
    private JFXComboBox<?> cbbCidade;
    @FXML
    private JFXTextField txtEmail;
    @FXML
    private JFXButton btnSalvar;
    @FXML
    private JFXButton btnNovo;
    @FXML
    private JFXButton btnExcluir;
    @FXML
    private JFXButton btnLimpar;
    @FXML
    private JFXTextField txtCnpj;
    @FXML
    private JFXTextField txtInscrEst;
    @FXML
    private JFXTextField txtObs;
    @FXML
    private Pane panePhone;
    @FXML
    private JFXComboBox<?> cbbOperadora;
    @FXML
    private JFXTextField txtDdd;
    @FXML
    private JFXTextField txtTelefone;
    @FXML
    private JFXButton btnAdicionar;
    @FXML
    private TableView<?> tbvTelefone;
    @FXML
    private TableColumn<?, ?> tbcDdd;
    @FXML
    private TableColumn<?, ?> tbcNumero;
    @FXML
    private TableColumn<?, ?> btnDeletar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void onKeyReleasedCep(KeyEvent event) {
    }

    @FXML
    private void onSelectCidade(ActionEvent event) {
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
    private void onAdicionar(ActionEvent event) {
    }
    
}
