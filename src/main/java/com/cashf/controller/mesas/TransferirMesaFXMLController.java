/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashf.controller.mesas;

import com.cashf.cashfood.MainApp;
import com.cashf.controller.menu.FXMenuFCaixaFXMLController;
import com.cashf.controller.menu.GavetaMesasFXMLController;
import com.cashf.model.mesa.Mesa;
import com.cashf.model.mesa.StatusMesa;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author joao
 */
public class TransferirMesaFXMLController implements Initializable {

    @FXML
    private JFXButton btnTransferir;
    @FXML
    private JFXButton btnCancelar;
    @FXML
    private JFXComboBox<Mesa> cbbMesaD;
    @FXML
    private Text txtMesa;
    //-----
    String erros = "";

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        loadCbbMesa();
        txtMesa.setText(MesaController.getInstance().getMesaAtual().getNumMesa() + "");
    }

    @FXML
    private void onTranferir(ActionEvent event) {

        if (cbbMesaD.getSelectionModel().getSelectedItem() != null) {
            int aux = MesaController.getInstance().getMesaAtual().getNumMesa();
            if (MesaController.getInstance().tranferirMesa(cbbMesaD.getItems().get(cbbMesaD.getSelectionModel().getSelectedIndex()))) {
                FXMenuFCaixaFXMLController.changeStatusTable(aux, StatusMesa.FECHADA);
                FXMenuFCaixaFXMLController.changeStatusTable(cbbMesaD.getItems().get(cbbMesaD.getSelectionModel().getSelectedIndex()).getNumMesa(), StatusMesa.ABERTA);
            }

        }
    }

    @FXML
    private void onCancelar(ActionEvent event) {
        MainApp.janelaAberta.close();
        MainApp.janelaAberta = MainApp.janelaAnterior;
    }

    @FXML
    private void onSelecionarMesa(ActionEvent event) {

    }

    private void loadCbbMesa() {
        cbbMesaD.setItems(MesaController.getInstance().getLista());

    }

}
