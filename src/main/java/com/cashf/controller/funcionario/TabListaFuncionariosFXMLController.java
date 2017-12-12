/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashf.controller.funcionario;

import com.cashf.controller.fornecedor.TabFornecedorFXMLController;
import com.cashf.model.funcionario.Funcionario;
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
public class TabListaFuncionariosFXMLController implements Initializable {

    @FXML
    private JFXTextField txtConsultar;
    @FXML
    private JFXButton btnPesquisar;
    @FXML
    private JFXRadioButton rdbNome;
    @FXML
    private JFXRadioButton rdbCpf;
    @FXML
    private JFXRadioButton rdbTodos;
    @FXML
    private TableView<Funcionario> tbvFuncionarios;
    @FXML
    private TableColumn<Funcionario, String> tbcNome;
    @FXML
    private TableColumn<Funcionario, String> tbcEndereco;
    @FXML
    private TableColumn<Funcionario, String> tbcEmail;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        setUptableView();
        loadTbv();
    }

    @FXML
    private void onPesquisar(ActionEvent event) {
    }

    @FXML
    private void onMouseClickedCliente(MouseEvent event) {
        if (tbvFuncionarios.getSelectionModel().getSelectedItem() != null) {
            FuncionarioController.getInstance().setFuncionario(tbvFuncionarios.getSelectionModel().getSelectedItem());
            FuncionarioController.getInstance().setListaTelefone(FXCollections.observableList(FuncionarioController.getInstance().getFuncionario().getTelefones()));
            TabFornecedorFXMLController.LDTS();
        }
    }

    private void setUptableView() {
        tbcNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        tbcEndereco.setCellValueFactory(new PropertyValueFactory<>("endereco"));
        tbcEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        tbvFuncionarios.getColumns().setAll(tbcNome, tbcEndereco, tbcEmail);
    }

    private void loadTbv() {
        tbvFuncionarios.setItems(FuncionarioController.getInstance().getLista());
    }
}
