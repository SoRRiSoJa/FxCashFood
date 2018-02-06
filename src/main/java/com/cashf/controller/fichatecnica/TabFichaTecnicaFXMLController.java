/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashf.controller.fichatecnica;

import com.cashf.model.fichatecnica.ProdutoFichaTecnica;
import com.cashf.model.produto.Produto;
import com.cashf.model.produto.UnidadeMedida;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import controller.GenericViewController;
import java.math.BigDecimal;
import java.net.URL;
import java.util.Arrays;
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
public class TabFichaTecnicaFXMLController implements Initializable,GenericViewController {

    @FXML
    private Pane paneRoot;
    @FXML
    private JFXComboBox<Produto> ccbFichaTecnica;
    @FXML
    private JFXButton btnSalvar;
    @FXML
    private JFXButton btnNovo;
    @FXML
    private JFXButton btnExcluir;
    @FXML
    private JFXButton btnLimpar;
    @FXML
    private TableView<ProdutoFichaTecnica> tbvFicha;
    @FXML
    private TableColumn<ProdutoFichaTecnica, String> tbcProduto;
    @FXML
    private TableColumn<ProdutoFichaTecnica, UnidadeMedida> tbcUnidade;
    @FXML
    private TableColumn<ProdutoFichaTecnica, BigDecimal> tbcQtde;
    @FXML
    private TableColumn<ProdutoFichaTecnica, BigDecimal> tbcValor;
    @FXML
    private Label lblCustoTotal;
    @FXML
    private JFXComboBox<Produto> ccbItens;
    @FXML
    private JFXComboBox<UnidadeMedida> cbbUnidadeMedida;
    @FXML
    private JFXTextField txtqtde;
    @FXML
    private JFXButton btnAdicionar;
    @FXML
    private JFXRadioButton rbtCodigo;
    @FXML
    private JFXRadioButton rbtDescricao;
    @FXML
    private TableView<ProdutoFichaTecnica> tbvFichaItens;
    @FXML
    private TableColumn<ProdutoFichaTecnica, String> tbcProdItem;
    @FXML
    private TableColumn<ProdutoFichaTecnica, UnidadeMedida> tbcUnidadeItem;
    @FXML
    private TableColumn<ProdutoFichaTecnica, BigDecimal> tbcQtdeItem;
    @FXML
    private TableColumn<ProdutoFichaTecnica, BigDecimal> tbcValorItem;
    @FXML
    private TableColumn btnExcluirItem;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        loadCbbUnidadeMedida();
        loadCbbFicha();
        loadCbbItens();
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
    private void loadCbbItens() {
        ccbItens.setItems(FichaTecnicaController.getInstance().getComboBoxItensFicha());
    }
    private void loadCbbFicha() {
        ccbFichaTecnica.setItems(FichaTecnicaController.getInstance().getComboBoxFichaTecnica());
    }
    private void loadCbbUnidadeMedida() {
        cbbUnidadeMedida.getItems().addAll(Arrays.asList(UnidadeMedida.values()));
    }
}
