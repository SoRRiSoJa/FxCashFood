/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashf.controller.mesas;

import com.cashf.cashfood.MainApp;
import com.cashf.core.venda.VendaController;
import com.cashf.model.meiopagamento.MeioPagamento;
import com.cashf.model.mesa.Mesa;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author joao
 */
public class FecharMesaFXMLController implements Initializable {

    @FXML
    private StackPane stackPane;
    @FXML
    private Pane paneRoot;
    @FXML
    private JFXComboBox<Mesa> cbbMesa;
    @FXML
    private TableView<?> tbvComanda1;
    @FXML
    private TableColumn<?, ?> tbcCod1;
    @FXML
    private TableColumn<?, ?> tbcDescricao1;
    @FXML
    private TableColumn<?, ?> tbcQtde1;
    @FXML
    private TableColumn<?, ?> tbcPreco1;
    @FXML
    private TableColumn<?, ?> tbcTotal1;
    @FXML
    private TableColumn<?, ?> btnCancelar1;
    @FXML
    private JFXComboBox<MeioPagamento> cbbMeioPagto;
    @FXML
    private JFXTextField txtValor;
    @FXML
    private JFXButton btnFechar;
    @FXML
    private JFXButton btnCancelar;
    @FXML
    private Text txtTotal;
    @FXML
    private Text txtTroco;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        loadMeioPagamento();
        loadLIstaMesas();
    }

    @FXML
    private void onMesa(ActionEvent event) {
        if (cbbMesa.getSelectionModel().getSelectedItem() != null) {
        }
    }

    @FXML
    private void onPesquisar(KeyEvent event) {
    }

    @FXML
    private void onMeioPagto(ActionEvent event) {
        if (cbbMeioPagto.getSelectionModel().getSelectedItem() != null) {
            
        }
    }

    @FXML
    private void onFechar(ActionEvent event) {

    }

    @FXML
    private void onCancelar(ActionEvent event) {
        MainApp.janelaAberta.close();
        MainApp.janelaAberta = MainApp.janelaAnterior;
    }

    private void loadMeioPagamento() {
        cbbMeioPagto.setItems(VendaController.getInstance().getListaMeioPagto());
    }

    private void loadLIstaMesas() {
        cbbMesa.setItems(MesaController.getInstance().getLista());
    }
}
