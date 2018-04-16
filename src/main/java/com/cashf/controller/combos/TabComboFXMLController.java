/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashf.controller.combos;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author joao
 */
public class TabComboFXMLController implements Initializable {

    @FXML
    private JFXTextField txtqtde;
    @FXML
    private JFXButton btnAdicionar;
    @FXML
    private JFXRadioButton rbtCodigo;
    @FXML
    private JFXRadioButton rbtDescricao;
    @FXML
    private TableView<?> tbvProdutos;
    @FXML
    private TableColumn<?, ?> tbcCodRef;
    @FXML
    private TableColumn<?, ?> tbcDescricao;
    @FXML
    private TableColumn<?, ?> tbcTipo;
    @FXML
    private TableColumn<?, ?> tbcQtde;
    @FXML
    private JFXTextField txtPesquisar;
    @FXML
    private JFXRadioButton rbtTodos;
    @FXML
    private JFXComboBox<?> cbbProduto;
    @FXML
    private JFXTextField txtValVenda;
    @FXML
    private JFXButton btnSalvar;
    @FXML
    private JFXButton btnNovo;
    @FXML
    private JFXButton btnExcluir;
    @FXML
    private JFXButton btnLimpar;
    @FXML
    private JFXRadioButton rbtCod;
    @FXML
    private JFXRadioButton rbtDesc;
    @FXML
    private Label lblCustoTotal;
    @FXML
    private TableView<?> tbvItens;
    @FXML
    private TableColumn<?, ?> tbcItem;
    @FXML
    private TableColumn<?, ?> tbcQtdIten;
    @FXML
    private TableColumn<?, ?> tbcUnidadeItem;
    @FXML
    private TableColumn<?, ?> tbcCustoItem;
    @FXML
    private TableColumn<?, ?> btnExcluirItem;
    @FXML
    private JFXTextField txtValCusto;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void onAdicionar(ActionEvent event) {
    }

    @FXML
    private void onSelecionarProduto(MouseEvent event) {
    }

    @FXML
    private void onKeyReleasedPesquisar(KeyEvent event) {
    }

    @FXML
    private void onSelecionarProdPrincipal(ActionEvent event) {
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
