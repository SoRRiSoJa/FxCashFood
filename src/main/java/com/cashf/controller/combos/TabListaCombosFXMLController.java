/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashf.controller.combos;

import com.cashf.model.combo.Combo;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import java.math.BigDecimal;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author joao
 */
public class TabListaCombosFXMLController implements Initializable {

    @FXML
    private TableView<Combo> tbvProdutos;
    @FXML
    private TableColumn<Combo, String> tbcDescricao;
    @FXML
    private TableColumn<Combo, BigDecimal> tbcCusto;
    @FXML
    private TableColumn<Combo, BigDecimal> tbcVenda;
    @FXML
    private JFXTextField txtConsultar;
    @FXML
    private JFXButton btnPesquisar;
    @FXML
    private JFXRadioButton rdbDesc;
    @FXML
    private JFXRadioButton rdbData;
    @FXML
    private JFXRadioButton rdbTodos;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        setUpTableView();
        loadTbv();
    }

    @FXML
    private void onSelecionarProduto(MouseEvent event) {
        if (tbvProdutos.getSelectionModel().getSelectedItem() != null) {
            ComboController.getInstance().setCombo(tbvProdutos.getItems().get(tbvProdutos.getSelectionModel().getSelectedIndex()));
            ComboController.getInstance().setLista(FXCollections.observableList(ComboController.getInstance().getLista()));
            TabComboFXMLController.LDTS();
        }
    }

    @FXML
    private void onPesquisar(ActionEvent event) {
    }

    private void setUpTableView() {
        tbcDescricao.setCellValueFactory(new PropertyValueFactory<>("produtoPrincipal"));
        tbcCusto.setCellValueFactory(new PropertyValueFactory<>("custoTotal"));
        tbcVenda.setCellValueFactory(new PropertyValueFactory<>("valorVenda"));
        tbvProdutos.getColumns().setAll(tbcDescricao, tbcCusto, tbcVenda);
    }

    private void loadTbv() {
        tbvProdutos.setItems(ComboController.getInstance().getLista());
    }
}
