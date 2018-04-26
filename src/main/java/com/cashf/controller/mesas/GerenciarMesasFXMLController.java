/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashf.controller.mesas;

import com.cashf.cashfood.MainApp;
import com.cashf.model.produto.Produto;
import com.cashf.model.venda.ProdutoVenda;
import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.math.BigDecimal;
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
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author joao
 */
public class GerenciarMesasFXMLController implements Initializable {

    @FXML
    private StackPane rootStackPane;
    @FXML
    private Pane paneCentral;
    @FXML
    private JFXButton btnRegistrar;
    @FXML
    private JFXButton btnTransferir;
    @FXML
    private JFXButton btnFechar;
    @FXML
    private JFXButton btnFecharParcial;
    @FXML
    private TableView<ProdutoVenda> tbvComanda;
    @FXML
    private Label lblNumMesa;
    @FXML
    private TableColumn<ProdutoVenda, String> tbcCod;
    @FXML
    private TableColumn<ProdutoVenda, Produto> tbcDescricao;
    @FXML
    private TableColumn<ProdutoVenda, BigDecimal> tbcQtde;
    @FXML
    private TableColumn<ProdutoVenda, BigDecimal> tbcPreco;
    @FXML
    private TableColumn btnAdicionar;
    @FXML
    private TableColumn btnSubtrair;
    @FXML
    private TableColumn<ProdutoVenda, BigDecimal> tbcTotal;
    @FXML
    private TableColumn btnCancelar;
    @FXML
    private TableColumn btnTransferirM;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        //colunaNome.setCellValueFactory((param) -> new SimpleStringProperty(param.getValue().getPessoa().getNome()));
        lblNumMesa.setText(MesaController.getInstance().getMesaAtual().getNumMesa() + "");
    }

    @FXML
    private void onRegistrar(ActionEvent event) {
        loadBox("/fxml/mesas/RegistrarConsumoFXML.fxml", "Lançar Consumo na Mesa");
    }

    @FXML
    private void onTransferir(ActionEvent event) {
    }

    @FXML
    private void onFechar(ActionEvent event) {
    }

    @FXML
    private void onFecharParcial(ActionEvent event) {
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
