/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashf.controller.parametrizacao;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.KeyEvent;

/**
 * FXML Controller class
 *
 * @author joao
 */
public class TabParametrosFiscaisFXMLController implements Initializable {

    @FXML
    private JFXComboBox<?> cbbSituacaoTributaria;
    @FXML
    private JFXTextField txtPercentualPIS;
    @FXML
    private JFXTextField txtCstPis;
    @FXML
    private JFXTextField txtPercentualConfins;
    @FXML
    private JFXTextField txtCfop;
    @FXML
    private JFXTextField txtCstConfins;
    @FXML
    private JFXTextField txtAliquotaCSOCN;
    @FXML
    private JFXTextField txtCest;
    @FXML
    private JFXTextField txtAliquotaICMS;
    @FXML
    private JFXTextField txtCSOSN;
    @FXML
    private JFXTextField txtAliquotaMunicipal;
    @FXML
    private JFXTextField txtAliquotaEstadual;
    @FXML
    private JFXTextField txtAliquotaFederal;
    @FXML
    private JFXButton btnSalvar;
    @FXML
    private JFXButton btnNovo;
    @FXML
    private JFXButton btnExcluir;
    @FXML
    private JFXButton btnLimpar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void onKeyReleasedPISPercent(KeyEvent event) {
    }

    @FXML
    private void onKeyReleasedCSTPis(KeyEvent event) {
    }

    @FXML
    private void onKeyReleasedconfisnPercent(KeyEvent event) {
    }

    @FXML
    private void onKeyReleasedCFOP(KeyEvent event) {
    }

    @FXML
    private void onKeyReleasedCstConfins(KeyEvent event) {
    }

    @FXML
    private void onKeyReleasedALCsosn(KeyEvent event) {
    }

    @FXML
    private void onKeyReleasedCest(KeyEvent event) {
    }

    @FXML
    private void onKeyReleasedALIcms(KeyEvent event) {
    }

    @FXML
    private void onKeyReleasedCsosn(KeyEvent event) {
    }

    @FXML
    private void onKeyReleasedALMunicipal(KeyEvent event) {
    }

    @FXML
    private void onKeyReleasedALEstadual(KeyEvent event) {
    }

    @FXML
    private void onKeyReleasedAlFederal(KeyEvent event) {
    }

    @FXML
    private void onSalvar(ActionEvent event) {
    }

    @FXML
    private void onNovo(ActionEvent event) {
    }

    @FXML
    private void onExcluir(ActionEvent event) {
    }

    @FXML
    private void onLimpar(ActionEvent event) {
    }
    
}
