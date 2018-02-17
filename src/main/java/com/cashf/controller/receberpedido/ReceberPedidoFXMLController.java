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
    private BigDecimal valorIpi;
    private BigDecimal valorIcmsSubstProd;
    private Integer qtdeCompra;
    private Integer qtdeRecebida;
    private BigDecimal prcoCompra;
    private BigDecimal outrasDespesasProd;
    private BigDecimal descontoProd;
    private BigDecimal embalagemDeCompra;

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
        setInputOff();
    }

    @FXML
    private void onSalvar(ActionEvent event) {
    }

    @FXML
    private void onNovo(ActionEvent event) {
        setInputOn();
        clearFields();
        btnNovo.setDisable(true);
    }

    @FXML
    private void onLimpar(ActionEvent event) {
        clearFields();
    }

    @FXML
    private void onAdicionar(ActionEvent event) {
    }

    @Override
    public void clearFields() {
        cbbFornecedor.setValue(null);
        dtpDataNota.setValue(null);;
        txtNumeroNota.clear();
        txtValorIcms.clear();
        txtBaseCalculoIcms.clear();
        txtValorTotalIpi.clear();
        txtBaseIcmsSubst.clear();
        txtValorIcmsSubst.clear();
        txtOutrasDespesas.clear();
        txtDesconto.clear();
        txtValorTotalProdutos.clear();
        txtValorTotalNota.clear();
        txtObservacao.clear();
        dtpDataRecebimento.setValue(null);;
        cbbProduto.setValue(null);
        cbbUnidadeFisica.setValue(null);
        txtValorIpi.clear();
        txtValorIcmsSubstProd.clear();
        txtQtdeCompra.clear();
        txtQtdeRecebida.clear();
        txtPrcoCompra.clear();
        txtOutrasDespesasProd.clear();
        txtDescontoProd.clear();
        txtEmbalagemDeCompra.clear();
    }

    @Override
    public void setInputOff() {
        cbbFornecedor.setDisable(true);
        dtpDataNota.setDisable(true);
        txtNumeroNota.setDisable(true);
        txtValorIcms.setDisable(true);
        txtBaseCalculoIcms.setDisable(true);
        txtValorTotalIpi.setDisable(true);
        txtBaseIcmsSubst.setDisable(true);
        txtValorIcmsSubst.setDisable(true);
        txtOutrasDespesas.setDisable(true);
        txtDesconto.setDisable(true);
        txtValorTotalProdutos.setDisable(true);
        txtValorTotalNota.setDisable(true);
        txtObservacao.setDisable(true);
        dtpDataRecebimento.setDisable(true);
        cbbProduto.setDisable(true);
        cbbUnidadeFisica.setDisable(true);
        txtValorIpi.setDisable(true);
        txtValorIcmsSubstProd.setDisable(true);
        txtQtdeCompra.setDisable(true);
        txtQtdeRecebida.setDisable(true);
        txtPrcoCompra.setDisable(true);
        txtOutrasDespesasProd.setDisable(true);
        txtDescontoProd.setDisable(true);
        txtEmbalagemDeCompra.setDisable(true);
        btnSalvar.setDisable(true);
        btnNovo.setDisable(true);
        btnLimpar.setDisable(true);
        tbvProdutos.setDisable(true);
        btnAdicionar.setDisable(true);
        flagButtons = false;
    }

    @Override
    public void setInputOn() {
        cbbFornecedor.setDisable(false);
        dtpDataNota.setDisable(false);
        txtNumeroNota.setDisable(false);
        txtValorIcms.setDisable(false);
        txtBaseCalculoIcms.setDisable(false);
        txtValorTotalIpi.setDisable(false);
        txtBaseIcmsSubst.setDisable(false);
        txtValorIcmsSubst.setDisable(false);
        txtOutrasDespesas.setDisable(false);
        txtDesconto.setDisable(false);
        txtValorTotalProdutos.setDisable(false);
        txtValorTotalNota.setDisable(false);
        txtObservacao.setDisable(false);
        dtpDataRecebimento.setDisable(false);
        cbbProduto.setDisable(false);
        cbbUnidadeFisica.setDisable(false);
        txtValorIpi.setDisable(false);
        txtValorIcmsSubstProd.setDisable(false);
        txtQtdeCompra.setDisable(false);
        txtQtdeRecebida.setDisable(false);
        txtPrcoCompra.setDisable(false);
        txtOutrasDespesasProd.setDisable(false);
        txtDescontoProd.setDisable(false);
        txtEmbalagemDeCompra.setDisable(false);
        btnSalvar.setDisable(false);
        btnNovo.setDisable(false);
        btnLimpar.setDisable(false);
        tbvProdutos.setDisable(false);
        btnAdicionar.setDisable(false);
        flagButtons = true;
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
