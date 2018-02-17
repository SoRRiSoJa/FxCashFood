/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashf.controller.receberpedido;

import com.cashf.model.fornecedor.Fornecedor;
import com.cashf.model.notafiscal.ProdutoNotaFiscal;
import com.cashf.model.produto.Produto;
import com.cashf.model.produto.UnidadeMedida;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import controller.GenericViewController;
import java.math.BigDecimal;
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
public class ReceberPedidoFXMLController implements GenericViewController, Initializable {

    @FXML
    private JFXButton btnSalvar;
    @FXML
    private JFXButton btnNovo;
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
    private JFXDatePicker dtpDataRecebimento;
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
    private TableView<ProdutoNotaFiscal> tbvProdutos;
    @FXML
    private TableColumn<ProdutoNotaFiscal, String> tbcProduto;
    @FXML
    private TableColumn<ProdutoNotaFiscal, Integer> tbcQtde;
    @FXML
    private TableColumn<ProdutoNotaFiscal, BigDecimal> tbcValUnid;
    @FXML
    private TableColumn<ProdutoNotaFiscal, BigDecimal> tbcTotal;
    @FXML
    private TableColumn btnExcluirProd;
    @FXML
    private JFXButton btnAdicionar;
    //----
    private String erros;
    private boolean flagButtons;
    private final ReceberPedidoController controller = new ReceberPedidoController();
    //----
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        loadCbbFornecedor();
        loadCbbProdutos();
        loadCbbUnidadeMedida();
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
    private void onAdicionar(ActionEvent event) {
    }

    @Override
    public void clearFields() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setInputOff() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setInputOn() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean validateFields() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void getData() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void loadDataToScreen() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void loadCbbProdutos() {
        cbbProduto.setItems(controller.loadComboProduto());
    }

    private void loadCbbFornecedor() {
        cbbFornecedor.setItems(controller.loadComboFornecedor());
    }
    private void loadCbbUnidadeMedida() {
        cbbUnidadeFisica.getItems().addAll(controller.loadComboUnidadeMedida());
    }
}
