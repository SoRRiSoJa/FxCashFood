/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashf.controller.fornecedor;

import com.cashf.model.fornecedor.Fornecedor;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
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
public class TabListaFornecedoresFXMLController implements Initializable {

    @FXML
    private JFXTextField txtConsultar;
    @FXML
    private JFXButton btnPesquisar;
    @FXML
    private JFXRadioButton rdbNome;
    @FXML
    private JFXRadioButton rdbRazao;
    @FXML
    private JFXRadioButton rdbTodos;
    @FXML
    private TableView<Fornecedor> tbvFornecedores;
    @FXML
    private TableColumn<Fornecedor, String> tbcNome;
    @FXML
    private TableColumn<Fornecedor, String> tbcEmail;
    private static TableView<Fornecedor> _tbvFornecedores;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        setUptableView();
        setUpRadioButtons();
        loadTbv();
        _tbvFornecedores=tbvFornecedores;
    }

    @FXML
    private void onPesquisar(ActionEvent event) {
        switch (FornecedorController.getInstance().getTipoConsulta()) {
            case 1:
                FornecedorController.getInstance().buscaNome(txtConsultar.getText());
                loadTbv();
                break;
            case 2:
                FornecedorController.getInstance().buscaRazao(txtConsultar.getText());
                loadTbv();
                break;
            default:
                FornecedorController.getInstance().buscaTodos();
                break;
        }
    }

    @FXML
    private void onMouseClickedFornecedor(MouseEvent event) {
        FornecedorController.getInstance().setFornecedor(tbvFornecedores.getSelectionModel().getSelectedItem());
        FornecedorController.getInstance().setListaTelefone(FXCollections.observableList(FornecedorController.getInstance().getFornecedor().getTelefones()));
        TabFornecedorFXMLController.LDTS();
        TabFornecedorFXMLController.LDTSPhone();
        TabFornecedorFXMLController.setBtnEX(Boolean.FALSE);
    }

    private void setUptableView() {
        tbcNome.setCellValueFactory(new PropertyValueFactory<>("nomefantasia"));
        tbcEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        tbvFornecedores.getColumns().setAll(tbcNome, tbcEmail);
    }

    private void loadTbv() {
        tbvFornecedores.setItems(FornecedorController.getInstance().getLista());
    }
    public static void loadTbvFornecedor() {
        _tbvFornecedores.setItems(FornecedorController.getInstance().getLista());
    }

    private void setUpRadioButtons() {

        rdbNome.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                rdbRazao.setSelected(false);
                rdbTodos.setSelected(false);
                FornecedorController.getInstance().setTipoConsulta(1);//todos
            }
        });
        rdbRazao.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                rdbNome.setSelected(false);
                rdbTodos.setSelected(false);
                FornecedorController.getInstance().setTipoConsulta(2);//todos
            }
        });

        rdbTodos.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                rdbRazao.setSelected(false);
                rdbNome.setSelected(false);
                FornecedorController.getInstance().setTipoConsulta(0);//todos
            }
        });
    }
}
