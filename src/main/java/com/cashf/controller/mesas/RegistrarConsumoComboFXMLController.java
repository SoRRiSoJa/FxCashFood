/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashf.controller.mesas;

import com.cashf.core.venda.VendaController;
import com.cashf.model.combo.ProdutoCombo;
import com.cashf.model.produto.Produto;
import com.cashf.model.venda.ProdutoVenda;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import java.math.BigDecimal;
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
    private JFXComboBox<Produto> cbbProduto;
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
    private TableView<ProdutoVenda> tbvProdutos;
    @FXML
    private TableColumn<ProdutoVenda, String> tbcCod;
    @FXML
    private TableColumn<ProdutoVenda, Produto> tbcDescricao;
    @FXML
    private TableColumn<ProdutoVenda, Integer> tbcQtde;
    @FXML
    private TableColumn<ProdutoVenda, BigDecimal> tbcValor;
    @FXML
    private TableColumn btnExcluirItem;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        loadCbbProduto();
        txtCombo.setText(VendaController.getInstance().getComboSelecionado().getProdutoPrincipal().getDescriao());
        btnConcluirEtapa.setText("Concluir Etapa Nº"+VendaController.getInstance().getEtapaAtual());
        
    }
    
    @FXML
    private void onProdutos(ActionEvent event) {
    }
    
    @FXML
    private void onPesquisar(KeyEvent event) {
    }
    
    @FXML
    private void onConcluirEtapa(ActionEvent event) {
        VendaController.getInstance().setEtapaAtual(VendaController.getInstance().getEtapaAtual() + 1);
        btnConcluirEtapa.setText("Concluir Etapa Nº"+VendaController.getInstance().getEtapaAtual());
        loadCbbProduto();
    }
    
    @FXML
    private void onFinalizarCombo(ActionEvent event) {
    }
    
    @FXML
    private void onAdcionar(ActionEvent event) {
    }

    private void loadCbbProduto() {
        System.out.println("Aqui--->>>>>>>>>>>>>>>>>>>" + VendaController.getInstance().getEtapaAtual());
        cbbProduto.setItems(VendaController.getInstance().getListaProdEtapa(VendaController.getInstance().getEtapaAtual()));
    }
}
