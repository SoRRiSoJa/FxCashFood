/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashf.controller.fichatecnica;

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
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author joao
 */
public class TabFichaTecnicaFXMLController implements Initializable {

    @FXML
    private Pane paneRoot;
    @FXML
    private JFXComboBox<?> ccbFichaTecnica;
    @FXML
    private JFXButton btnSalvar;
    @FXML
    private JFXButton btnNovo;
    @FXML
    private JFXButton btnExcluir;
    @FXML
    private JFXButton btnLimpar;
    @FXML
    private TableView<?> tbvFicha;
    @FXML
    private TableColumn<?, ?> tbcProduto;
    @FXML
    private TableColumn<?, ?> tbcUnidade;
    @FXML
    private TableColumn<?, ?> tbcQtde;
    @FXML
    private TableColumn<?, ?> tbcValor;
    @FXML
    private Label lblCustoTotal;
    @FXML
    private JFXComboBox<?> ccbItens;
    @FXML
    private JFXComboBox<?> cbbUnidadeMedida;
    @FXML
    private JFXTextField txtqtde;
    @FXML
    private JFXButton btnAdicionar;
    @FXML
    private JFXRadioButton rbtCodigo;
    @FXML
    private JFXRadioButton rbtDescricao;
    @FXML
    private TableView<?> tbvFichaItens;
    @FXML
    private TableColumn<?, ?> tbcProdItem;
    @FXML
    private TableColumn<?, ?> tbcUnidadeItem;
    @FXML
    private TableColumn<?, ?> tbcQtdeItem;
    @FXML
    private TableColumn<?, ?> tbcValorItem;
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
    private void onFichaTecnica(ActionEvent event) {
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
