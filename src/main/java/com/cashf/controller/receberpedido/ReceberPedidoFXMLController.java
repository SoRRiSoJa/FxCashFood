/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashf.controller.receberpedido;

import com.cashf.model.fornecedor.Fornecedor;
import com.cashf.model.produto.Produto;
import com.cashf.model.produto.UnidadeMedida;
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

/**
 * FXML Controller class
 *
 * @author joao
 */
public class ReceberPedidoFXMLController implements Initializable {

    @FXML
    private JFXButton btnSalvar;
    @FXML
    private JFXButton btnNovo;
    @FXML
    private JFXButton btnExcluir;
    @FXML
    private JFXButton btnLimpar;
    @FXML
    private JFXComboBox<Fornecedor> cbbFornecedor;
    @FXML
    private JFXDatePicker dtpDataNota;
    @FXML
    private JFXTextField txtNumeroNota;
    @FXML
    private JFXTextField txtValorIcms;
    @FXML
    private JFXTextField txtBaseCalculoIcms;
    @FXML
    private JFXTextField txtValorTotalIpi;
    @FXML
    private JFXTextField txtBaseIcmsSubst;
    @FXML
    private JFXTextField txtValorIcmsSubst;
    @FXML
    private JFXTextField txtOutrasDespesas;
    @FXML
    private JFXTextField txtDesconto;
    @FXML
    private JFXTextField txtValorTotalProdutos;
    @FXML
    private JFXTextField txtValorTotalNota;
    @FXML
    private JFXTextField txtObservacao;
    @FXML
    private JFXComboBox<Produto> cbbProduto;
    @FXML
    private JFXComboBox<UnidadeMedida> cbbUnidadeFisica;
    @FXML
    private JFXTextField txtValorIpi;
    @FXML
    private JFXTextField txtValorIcmsSubstProd;
    @FXML
    private JFXTextField txtQtdeCompra;
    @FXML
    private JFXTextField txtQtdeRecebida;
    @FXML
    private JFXTextField txtPrcoCompra;
    @FXML
    private JFXTextField txtOutrasDespesasProd;
    @FXML
    private JFXTextField txtDescontoProd;
    @FXML
    private JFXTextField txtEmbalagemDeCompra;
    @FXML
    private JFXButton btnAdicionar;
    @FXML
    private TableView<?> tbvProdutos;
    @FXML
    private TableColumn<?, ?> tbcProduto;
    @FXML
    private TableColumn<?, ?> tbcQtde;
    @FXML
    private TableColumn<?, ?> tbcUnidade;
    @FXML
    private TableColumn<?, ?> tbcTotal;

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
    private void onAdicionar(ActionEvent event) {
    }
    
}
