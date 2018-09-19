/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashf.controller.report.prepreparo;

import com.cashf.model.prepreparo.PrePreparo;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;

/**
 * FXML Controller class
 *
 * @author joao
 */
public class RelatorioPrePreparoFXMLController implements Initializable {

    @FXML
    private JFXButton btnImprimir;
    @FXML
    private JFXButton btnLimpar;
    @FXML
    private JFXTextField txtTotal;
    @FXML
    private JFXTextField txtVAlorIncial;
    @FXML
    private Label lblSaldo;
    @FXML
    private JFXButton btnPesquisar;
    @FXML
    private JFXComboBox<PrePreparo> cbbPrepreparo;
    //----
    RelatorioPrePreparoController relatorioController;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        this.relatorioController = new RelatorioPrePreparoController();
        loadCbb();
    }

    @FXML
    private void onSalvar(ActionEvent event) {
        relatorioController.gerarRelatorio();
    }

    @FXML
    private void onLimpar(ActionEvent event) {
    }

    @FXML
    private void onKeyReleasedQtdeAjuste(KeyEvent event) {
    }

    @FXML
    private void onPesquisar(ActionEvent event) {
        
        txtTotal.setText("R$ "+relatorioController.getPrePreparo().getCustoTotal().toString());
        txtVAlorIncial.setText(relatorioController.getPrePreparo().getRendimento()+"");
    }

    @FXML
    private void onPrepreparo(ActionEvent event) {
        if (cbbPrepreparo.getSelectionModel().getSelectedItem() != null) {
            relatorioController.setPrePreparo(cbbPrepreparo.getItems().get(cbbPrepreparo.getSelectionModel().getSelectedIndex()));
        }
    }

    private void loadCbb() {
        cbbPrepreparo.setItems(relatorioController.getLista());
    }
}
