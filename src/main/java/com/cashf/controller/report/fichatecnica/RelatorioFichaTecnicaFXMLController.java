/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashf.controller.report.fichatecnica;

import com.cashf.model.fichatecnica.FichaTecnica;
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
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author joao
 */
public class RelatorioFichaTecnicaFXMLController implements Initializable {

    @FXML
    private Pane paneRoot;
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
    private JFXComboBox<FichaTecnica> cbbFicha;
    //----
    private RelatorioFichaTecnicaController relatorioController;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.relatorioController=new RelatorioFichaTecnicaController();
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
        txtTotal.setText("R$ "+relatorioController.getFichaTecnica().getCustoTotal().toString());
        txtVAlorIncial.setText(relatorioController.getFichaTecnica().getDataProducao().toString());
    }

    @FXML
    private void onFicha(ActionEvent event) {
         if (cbbFicha.getSelectionModel().getSelectedItem() != null) {
            relatorioController.setFichaTecnica(cbbFicha.getItems().get(cbbFicha.getSelectionModel().getSelectedIndex()));
        }
    }
    private void loadCbb(){
        cbbFicha.setItems(relatorioController.getLista());
    }
    
}
