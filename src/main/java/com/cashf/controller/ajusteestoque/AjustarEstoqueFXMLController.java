/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashf.controller.ajusteestoque;

import com.cashf.model.ajusteestoque.TipoAjuste;
import com.cashf.model.produto.Produto;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTimePicker;
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
public class AjustarEstoqueFXMLController implements Initializable {

    @FXML
    private Pane paneRoot;
    @FXML
    private TableView<Produto> tbvProdutos;
    @FXML
    private TableColumn<Produto, Integer> tbcCod;
    @FXML
    private TableColumn<Produto, String> tbcCodRef;
    @FXML
    private TableColumn<Produto, String> tbcDescricao;
    @FXML
    private TableColumn<Produto, String> tbcTipo;
    @FXML
    private TableColumn<Produto, Integer> tbcQtde;
    @FXML
    private JFXTextField txtConsultar;
    @FXML
    private JFXRadioButton rdbDesc;
    @FXML
    private JFXRadioButton rdbGrupo;
    @FXML
    private JFXRadioButton rdbTodos;
    @FXML
    private JFXButton btnPesquisar;
    @FXML
    private JFXButton btnSalvar;
    @FXML
    private JFXTextField txtDescricao;
    @FXML
    private JFXTextField txtQtdeAjuste;
    @FXML
    private JFXComboBox<TipoAjuste> cbbTipoAjuste;
    @FXML
    private JFXTextField txtQtdeAtual;
    @FXML
    private JFXTextField txtSaldo;
    @FXML
    private JFXDatePicker dtpDataAjuste;
    @FXML
    private JFXTimePicker dtpHoraAjuste;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void onSelecionarProduto(MouseEvent event) {
    }

    @FXML
    private void onPesquisar(ActionEvent event) {
    }

    @FXML
    private void onSalvar(ActionEvent event) {
    }

    @FXML
    private void onMouseClickedBanco(MouseEvent event) {
    }
    
}
