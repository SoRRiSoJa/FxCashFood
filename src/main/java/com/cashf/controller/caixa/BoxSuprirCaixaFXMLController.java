/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashf.controller.caixa;

import com.cashf.cashfood.MainApp;
import com.cashf.controller.login.LoginController;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTimePicker;
import java.math.BigDecimal;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import util.PoupUpUtil;

/**
 * FXML Controller class
 *
 * @author joao
 */
public class BoxSuprirCaixaFXMLController implements Initializable {

    @FXML
    private Pane paneRoot;
    @FXML
    private JFXDatePicker dtpDataSangria;
    @FXML
    private JFXTimePicker dtpHoraSangria;
    @FXML
    private Label lblUsuario;
    @FXML
    private JFXButton btnSuprirCaixa;
    @FXML
    private JFXButton btnCancelar;
    @FXML
    private JFXTextField txtSaldoAnterior;
    @FXML
    private JFXTextField txtValor;
    @FXML
    private Label lblSaldoFinal;
    //---
    private BigDecimal valor;
    private String erros = "";

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        txtSaldoAnterior.setText(CaixaController.getInstance().getSaldoFinal().toString());
        loadDateTime();
        loadUser();
    }

    @FXML
    private void onAbrir(ActionEvent event) {
        getData();
        if (validateField()) {
            CaixaController.getInstance().suprirCaixa(valor);
            GerenciarCaixaFXMLController.refreshTbv();
            GerenciarCaixaFXMLController.refreshTotal();
            MainApp.janelaAberta.close();
            MainApp.janelaAberta = MainApp.janelaAnterior;
        } else {
            PoupUpUtil.accessDenied(erros);
            erros = "";
        }
    }

    @FXML
    private void onCancelar(ActionEvent event) {
        MainApp.janelaAberta.close();
        MainApp.janelaAberta = MainApp.janelaAnterior;
    }

    private void getData() {
        try {
            valor = new BigDecimal(txtValor.getText());
        } catch (Exception ex) {
            System.out.println("Erro ao converter Valor Suprimento ---->>>>" + ex);
        }
    }

    private boolean validateField() {
        boolean flag = true;
        if (txtValor.getText() == null || txtValor.getText().isEmpty()) {
            erros += "Você deve informar o valor para suprimento do caixa.";
            flag = false;
        }
        if (valor.compareTo(BigDecimal.ZERO) < 0) {
            erros += "O valor não pode ser negativo.";
            flag = false;
        }
        return flag;
    }

    private void loadDateTime() {
        dtpDataSangria.setValue(LocalDate.now());
        dtpHoraSangria.setValue(LocalTime.now());
    }

    private void loadUser() {
        lblUsuario.setText(LoginController.getInstance().getUsuario().getLogin());
    }

}
