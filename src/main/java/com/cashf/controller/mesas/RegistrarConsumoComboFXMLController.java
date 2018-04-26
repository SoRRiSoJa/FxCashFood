/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashf.controller.mesas;

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
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author joao
 */
public class RegistrarConsumoComboFXMLController implements Initializable {

    @FXML
    private Text txtCombo;
    @FXML
    private JFXComboBox<?> cbbProduto;
    @FXML
    private JFXRadioButton rbtCodigo;
    @FXML
    private JFXRadioButton rbtDescricao;
    @FXML
    private JFXRadioButton rbtGrupo;
    @FXML
    private JFXRadioButton rbtTodos;
    @FXML
    private JFXTextField txtQtde;
    @FXML
    private JFXButton btnConcluirEtapa;
    @FXML
    private JFXButton btnConcluirSel;
    @FXML
    private JFXButton btnAdicionar;
    @FXML
    private TableView<?> tbvProdutos;
    @FXML
    private TableColumn<?, ?> tbcCod;
    @FXML
    private TableColumn<?, ?> tbcDescricao;
    @FXML
    private TableColumn<?, ?> tbcQtde;
    @FXML
    private TableColumn<?, ?> tbcValor;
    @FXML
    private TableColumn<?, ?> btnExcluirItem;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void onProdutos(ActionEvent event) {
    }

    @FXML
    private void onPesquisar(KeyEvent event) {
    }

    @FXML
    private void onConcluirEtapa(ActionEvent event) {
    }

    @FXML
    private void onFinalizarCombo(ActionEvent event) {
    }

    @FXML
    private void onAdcionar(ActionEvent event) {
    }
    
}
