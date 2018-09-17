/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashf.controller.report.fluxocaixa;

import com.cashf.model.caixa.Caixa;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
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
public class RelatorioFluxoCaixaFXMLController implements Initializable {

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
    private JFXDatePicker dtpDataAbertura;
    @FXML
    private JFXButton btnPesquisar;
    @FXML
    private JFXComboBox<Caixa> cbbCaixa;
    //---
    private RelatorioFLuxoCaixaController relatorioController;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        relatorioController = new RelatorioFLuxoCaixaController();
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
        if (dtpDataAbertura.getValue() != null) {
            relatorioController.setDataAbertura(dtpDataAbertura.getValue());
        }
        loadCbbCixa();
    }

    public boolean getData() {
        boolean flag = true;
        if (dtpDataAbertura.getValue() != null) {
            relatorioController.setDataAbertura(dtpDataAbertura.getValue());
        } else {
            flag = false;
        }
        if (cbbCaixa.getSelectionModel().getSelectedItem() != null) {
            relatorioController.setCaixa(cbbCaixa.getSelectionModel().getSelectedItem());
        } else {
            flag = false;
        }
        return flag;
    }

    private void loadCbbCixa() {
        relatorioController.loadCaixaList();
        cbbCaixa.setItems(relatorioController.getLista());
    }

    @FXML
    private void onCaixa(ActionEvent event) {
        getData();
        relatorioController.gerarDados();
    }
}
