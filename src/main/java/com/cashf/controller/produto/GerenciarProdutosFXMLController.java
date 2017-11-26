/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashf.controller.produto;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;

/**
 * FXML Controller class
 *
 * @author joao
 */
public class GerenciarProdutosFXMLController implements Initializable {

    @FXML
    private JFXComboBox<?> cbbUnidadeFisica;
    @FXML
    private JFXTextField txtDescricao;
    @FXML
    private JFXComboBox<?> cbbGrupo;
    @FXML
    private JFXComboBox<?> cbbProdutos;
    @FXML
    private JFXTextField txtNcm;
    @FXML
    private JFXTextField txtCodigo;
    @FXML
    private JFXComboBox<?> cbbCategoria;
    @FXML
    private JFXTextField txtPrecoCusto;
    @FXML
    private JFXTextField txtPrecoVenda;
    @FXML
    private JFXTextField txtCodRef;
    @FXML
    private JFXTextField txtQtdeEmbalagem;
    @FXML
    private JFXComboBox<?> cbbSituacaoTributaria;
    @FXML
    private JFXTextField txtPercentualPIS;
    @FXML
    private JFXTextField txtAliquotaICMS;
    @FXML
    private JFXTextField txtCest;
    @FXML
    private JFXTextField txtCfop;
    @FXML
    private JFXTextField txtAliquotaCSOCN;
    @FXML
    private JFXTextField txtCSOSN;
    @FXML
    private JFXTextField txtPercentualConfins;
    @FXML
    private JFXTextField txtCstPis;
    @FXML
    private JFXTextField txtCstConfins;
    @FXML
    private JFXTextField txtAliquotaMunicipal;
    @FXML
    private JFXTextField txtAliquotaEstadual;
    @FXML
    private JFXTextField txtAliquotaFederal;
    @FXML
    private JFXButton btnSalvar;
    @FXML
    private JFXButton btnNovo;
    @FXML
    private JFXButton btnExcluir;
    @FXML
    private JFXButton btnLimpar;
    @FXML
    private TableView<?> tbvProdutos;
    @FXML
    private JFXTextField txtConsultar;
    @FXML
    private JFXButton btnPesquisar;
    @FXML
    private JFXRadioButton rdbDesc;
    @FXML
    private JFXRadioButton rdbGrupo;
    @FXML
    private JFXRadioButton rdbTodos;

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
