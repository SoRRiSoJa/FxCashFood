/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashf.controller.mesas;

import com.cashf.cashfood.MainApp;
import com.cashf.controller.menu.FXMenuFCaixaFXMLController;
import com.cashf.model.cliente.Cliente;
import com.cashf.model.mesa.Mesa;
import com.cashf.model.mesa.StatusMesa;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author joao
 */
public class AbrirMesaFXMLController implements Initializable {

    @FXML
    private Pane paneRoot;
    @FXML
    private JFXComboBox<Cliente> cbbCliente;
    @FXML
    private JFXRadioButton rbtNome;
    @FXML
    private JFXRadioButton rbtCpf;
    @FXML
    private JFXRadioButton rbtEmail;
    @FXML
    private JFXRadioButton rbtTodos;
    @FXML
    private JFXTextField txtPax;
    @FXML
    private JFXButton btnAbrir;
    @FXML
    private JFXComboBox<Mesa> cbbMesa;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        loadCbbMesa();
        loadCbbCliente();
    }

    private void loadCbbMesa() {
        cbbMesa.setItems(MesaController.getInstance().getLista());
    }

    private void loadCbbCliente() {
        cbbCliente.setItems(MesaController.getInstance().getListaCli());
    }

    @FXML
    private void onSelecionarMesa(ActionEvent event) {
        if (cbbMesa.getSelectionModel().getSelectedItem() != null) {
            MesaController.getInstance().setMesaAtual(cbbMesa.getItems().get(cbbMesa.getSelectionModel().getSelectedIndex()));
            cbbMesa.getSelectionModel().select(MesaController.getInstance().getMesaAtual());
        }
    }

    @FXML
    private void onSelecionarCliente(ActionEvent event) {
        if (cbbCliente.getSelectionModel().getSelectedItem() != null) {
            MesaController.getInstance().setCliente(cbbCliente.getItems().get(cbbCliente.getSelectionModel().getSelectedIndex()));
        }
    }

    @FXML
    private void onAbrir(ActionEvent event) {
        MesaController.getInstance().abrirMesa();
        MainApp.janelaAberta.close();
        MainApp.janelaAberta = MainApp.janelaAnterior;
        FXMenuFCaixaFXMLController.changeStatusTable(MesaController.getInstance().getMesaAtual().getNumMesa(), StatusMesa.ABERTA);
        loadBox("/fxml/mesas/GerenciarMesasFXML.fxml", "Mesa Nº" + MesaController.getInstance().getMesaAtual().getNumMesa());
    }

    

    private void loadBox(String boxPath, String title) {
        try {
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource(boxPath));
            stage.setScene(new Scene(root));
            stage.setTitle(title);
            stage.initModality(Modality.APPLICATION_MODAL);
            MainApp.janelaAnterior = MainApp.janelaAberta;
            MainApp.janelaAberta = stage;
            stage.show();
        } catch (IOException ex) {
            System.out.println("Erro---->" + ex);
        }
    }
}
