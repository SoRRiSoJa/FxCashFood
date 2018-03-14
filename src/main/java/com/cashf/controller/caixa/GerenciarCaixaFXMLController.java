/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashf.controller.caixa;

import com.cashf.cashfood.MainApp;
import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import util.PoupUpUtil;

/**
 * FXML Controller class
 *
 * @author joao
 */
public class GerenciarCaixaFXMLController implements Initializable {

    @FXML
    private TableView<?> tbvMovimentacoes;
    @FXML
    private TableColumn<?, ?> tbcDescricao;
    @FXML
    private TableColumn<?, ?> tbcTipo;
    @FXML
    private TableColumn<?, ?> tbcValor;
    @FXML
    private TableColumn<?, ?> tbcSaldo;
    @FXML
    private JFXButton btnAbrirCaixa;
    @FXML
    private JFXButton btnSuprir;
    @FXML
    private JFXButton btnSangrar;
    @FXML
    private JFXButton btnFecharCaixa;
    @FXML
    private Label lblTotalRecebido;
    @FXML
    private Label lblTotalPago;
    @FXML
    private Label lblSaldo;
    @FXML
    private TableView<?> tbvLista;
    @FXML
    private TableColumn<?, ?> tbcDataAb;
    @FXML
    private TableColumn<?, ?> tbcDataFe;
    @FXML
    private Pane paneRoot;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void onSalvar(ActionEvent event) {
        if (CaixaController.getInstance().getCaixaAberto().getIdCaixa() == 0) {
            loadBox("/fxml/caixa/BoxAbrirCaixaNFXML.fxml", "Abrir Caixa");
        } else {
            PoupUpUtil.accessDenied("Um caixa já se encontra aberto");
        }
    }

    @FXML
    private void onNovo(ActionEvent event) {
        loadBox("/fxml/caixa/BoxSuprirCaixaFXML.fxml", "Suprir Caixa");
    }

    @FXML
    private void onExcluir(ActionEvent event) {
        loadBox("/fxml/caixa/BoxSangrarCaixaFXML.fxml", "Sangrar Caixa");
    }

    @FXML
    private void onLimpar(ActionEvent event) {
        loadBox("/fxml/caixa/BoxFecharCaixaFXML.fxml", "Fechar Caixa");
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
