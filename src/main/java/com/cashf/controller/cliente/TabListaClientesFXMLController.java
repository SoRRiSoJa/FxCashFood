/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashf.controller.cliente;

import com.cashf.controller.cliente.ClienteController;
import com.cashf.model.cliente.Cliente;
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
public class TabListaClientesFXMLController implements Initializable {

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
    private TableView<Cliente> tbvClientes;
    @FXML
    private TableColumn<Cliente, String> tbcNome;
    @FXML
    private TableColumn<Cliente, String> tbcEmail;
    @FXML
    private TableColumn<Cliente, String> tbcEndereco;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void onPesquisar(ActionEvent event) {
    }

    @FXML
    private void onMouseClickedCliente(MouseEvent event) {
        ClienteController.getInstance().setCliente(tbvClientes.getSelectionModel().getSelectedItem());
        ClienteController.getInstance().setListaTelefone(FXCollections.observableList(ClienteController.getInstance().getCliente().getTelefones()));
        //TabClienteFXMLController.LDTS();
    }
     private void setUptableView() {
        tbcNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        tbcEndereco.setCellValueFactory(new PropertyValueFactory<>("endereco"));
        tbcEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        tbvClientes.getColumns().setAll(tbcNome,tbcEndereco ,tbcEmail);
    }

    private void loadTbv() {
     //   tbvClientes.setItems(ClienteController.getInstance().getLista());
    }
}
