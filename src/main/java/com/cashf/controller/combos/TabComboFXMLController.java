/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashf.controller.combos;

import com.cashf.model.combo.ProdutoCombo;
import com.cashf.model.produto.Produto;
import com.cashf.model.produto.UnidadeMedida;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import controller.GenericViewController;
import java.math.BigDecimal;
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
public class TabComboFXMLController implements GenericViewController, Initializable {

    @FXML
    private JFXTextField txtqtde;
    @FXML
    private JFXButton btnAdicionar;
    @FXML
    private JFXRadioButton rbtCodigo;
    @FXML
    private JFXRadioButton rbtDescricao;
    @FXML
    private TableView<Produto> tbvProdutos;
    @FXML
    private TableColumn<Produto, String> tbcCodRef;
    @FXML
    private TableColumn<Produto, String> tbcDescricao;
    @FXML
    private TableColumn<Produto, String> tbcTipo;
    @FXML
    private TableColumn<Produto, BigDecimal> tbcQtde;
    @FXML
    private JFXTextField txtPesquisar;
    @FXML
    private JFXRadioButton rbtTodos;
    @FXML
    private JFXComboBox<Produto> cbbProduto;
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
    private TableView<ProdutoCombo> tbvItens;
    @FXML
    private TableColumn<ProdutoCombo, Produto> tbcItem;
    @FXML
    private TableColumn<ProdutoCombo, BigDecimal> tbcQtdIten;
    @FXML
    private TableColumn<ProdutoCombo, UnidadeMedida> tbcUnidadeItem;
    @FXML
    private TableColumn<ProdutoCombo, BigDecimal> tbcCustoItem;
    @FXML
    private TableColumn btnExcluirItem;
    @FXML
    private JFXTextField txtValCusto;
    //-----
    private String erros;
    private boolean flagButtons;
    private BigDecimal precoCusto;
    private BigDecimal precoVenda;
    private BigDecimal qtde;

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

    @Override
    public void clearFields() {
        txtPesquisar.clear();
        txtValCusto.clear();
        txtValVenda.clear();
        txtqtde.clear();
        cbbProduto.setValue(null);
    }

    @Override
    public void setInputOff() {
        txtPesquisar.setDisable(true);
        txtValCusto.setDisable(true);
        txtValVenda.setDisable(true);
        txtqtde.setDisable(true);
        cbbProduto.setDisable(true);
        btnAdicionar.setDisable(true);
        btnExcluir.setDisable(true);
        btnLimpar.setDisable(true);
        btnSalvar.setDisable(true);
    }

    @Override
    public void setInputOn() {
        txtPesquisar.setDisable(false);
        txtValCusto.setDisable(false);
        txtValVenda.setDisable(false);
        txtqtde.setDisable(false);
        cbbProduto.setDisable(false);
        btnAdicionar.setDisable(false);
        btnExcluir.setDisable(false);
        btnLimpar.setDisable(false);
        btnSalvar.setDisable(false);
    }

    public Boolean validateFieldsProdutoCombo() {
        boolean flag = true;

        if (qtde == null || qtde.compareTo(BigDecimal.ZERO) <= 0) {
            erros += "A quantidade deve ser maior que 0";
            flag = false;
        }
        if (tbvProdutos.getSelectionModel().getSelectedItem() == null) {
            erros += "Selecione um Produto  para compor os ítens deste combo.";
            flag = false;
        }
        return flag;
    }

    @Override
    public Boolean validateFields() {
        boolean flag = true;
        if (precoCusto == null || precoCusto.compareTo(BigDecimal.ZERO) < 0) {
            erros += "O valor de custo deve ser maior ou igual a 0";
            flag = false;
        }
        if (precoVenda == null || precoVenda.compareTo(BigDecimal.ZERO) <= 0) {
            erros += "O valor de venda deve ser maior que 0.";
            flag = false;
        }
        if (cbbProduto.getSelectionModel().getSelectedItem() == null) {
            erros += "Um produto deve ser selecionado como Produto Principal.";
            flag = false;
        }

        return flag;
    }

    public void getDataItem() {
        try {
            qtde = new BigDecimal(txtqtde.getText());
        } catch (Exception ex) {
            System.out.println("Erro ao converter:" + ex);
        }
        if (tbvProdutos.getSelectionModel().getSelectedItem() != null) {
            ComboController.getInstance().setItemAtual(tbvProdutos.getItems().get(tbvProdutos.getSelectionModel().getSelectedIndex()));
        }

    }

    @Override
    public void getData() {
        try {
            precoCusto = new BigDecimal(txtValCusto.getText());
        } catch (Exception ex) {
            System.out.println("Erro ao converter:" + ex);
        }
        try {
            precoVenda = new BigDecimal(txtValVenda.getText());
        } catch (Exception ex) {
            System.out.println("Erro ao converter:" + ex);
        }
        if (cbbProduto.getSelectionModel().getSelectedItem() != null) {
            ComboController.getInstance().setProdutoPrincipal(cbbProduto.getItems().get(cbbProduto.getSelectionModel().getSelectedIndex()));
        }
    }

    @Override
    public void loadDataToScreen() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
