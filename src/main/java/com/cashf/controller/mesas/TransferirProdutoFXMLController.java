/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashf.controller.mesas;

import com.cashf.cashfood.MainApp;
import com.cashf.core.venda.VendaController;
import com.cashf.model.mesa.Mesa;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author joao
 */
public class TransferirProdutoFXMLController implements Initializable {

    @FXML
    private JFXButton btnTransferir;
    @FXML
    private JFXButton btnCancelar;
    @FXML
    private JFXComboBox<Mesa> cbbMesaD;
    @FXML
    private Text txtMesa;
    @FXML
    private Label lblItem;
    //----
    String erros = "";
    int aux;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        loadCbbMesa();
        lblItem.setText(VendaController.getInstance().getProdutoVendaSelecionado().getProduto().getDescriao());
    }

    @FXML
    private void onTranferir(ActionEvent event) {
        MesaController.getInstance().tranferirItemMesa(MesaController.getInstance().getMesaNum(aux), VendaController.getInstance().getProdutoVendaSelecionado());
    }

    @FXML
    private void onCancelar(ActionEvent event) {
        MainApp.janelaAberta.close();
        MainApp.janelaAberta = MainApp.janelaAnterior;
    }

    @FXML
    private void onSelecionarMesa(ActionEvent event) {
        if (cbbMesaD.getSelectionModel().getSelectedItem() != null) {
            aux = MesaController.getInstance().getMesaAtual().getNumMesa();
        }
    }

    private void loadCbbMesa() {
        cbbMesaD.setItems(MesaController.getInstance().getLista());
    }
}
