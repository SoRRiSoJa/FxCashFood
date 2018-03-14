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
import javafx.scene.layout.StackPane;
import util.PoupUpUtil;

/**
 * FXML Controller class
 *
 * @author joao
 */
public class BoxAbrirCaixaNFXMLController implements Initializable {

    @FXML
    private StackPane paneRoot;
    @FXML
    private Pane paneCentral;
    @FXML
    private JFXDatePicker dtpDataAbertura;
    @FXML
    private JFXTimePicker dtpHoraAbertura;
    @FXML
    private Label lblUsuario;
    @FXML
    private JFXButton btnAbrirCaixa;
    @FXML
    private JFXButton btnCancelar;
    @FXML
    private JFXTextField txtValor;

    /**
     * Initializes the controller class.
     */
    //---
    private BigDecimal valorInicial;
    private String erros = "";

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void onAbrir(ActionEvent event) {
        getData();
        if (validateField()) {
            CaixaController.getInstance().abrirCaixa(LocalDate.now(), LocalTime.now(), valorInicial);
            PoupUpUtil.poupUp("Novo Caixa Aberto", "O Novo Caixa foi iniciado.", "");
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
            valorInicial = new BigDecimal(txtValor.getText());
        } catch (Exception ex) {
            System.out.println("Erro ao converter Valor Inicial ---->>>>" + ex);
        }
    }

    private boolean validateField() {
        boolean flag = true;
        if (txtValor.getText() == null || txtValor.getText().isEmpty()) {
            erros += "Você deve informar o valor incial para abertura do caixa.";
            flag = false;
        }
        if (valorInicial.compareTo(BigDecimal.ZERO) < 0) {
            erros += "O valor inicial não pode ser negativo.";
            flag = false;
        }
        return flag;
    }

    private void loadDateTime() {
        dtpDataAbertura.setValue(LocalDate.now());
        dtpHoraAbertura.setValue(LocalTime.now());
    }

    private void loadUser() {
        lblUsuario.setText(LoginController.getInstance().getUsuario().getLogin());
    }

}
