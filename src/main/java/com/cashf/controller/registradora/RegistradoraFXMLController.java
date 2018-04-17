/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashf.controller.registradora;

import com.cashf.model.produto.Produto;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author joao
 */
public class RegistradoraFXMLController implements Initializable {

    @FXML
    private TextField txtMesa;
    @FXML
    private JFXComboBox<?> cbbGarcom;
    @FXML
    private TextField txtQtde;
    @FXML
    private TextField txtObsItem;
    @FXML
    private Pane paneTeclado;
    @FXML
    private JFXButton btn7;
    @FXML
    private JFXButton btn8;
    @FXML
    private JFXButton btn9;
    @FXML
    private JFXButton btn4;
    @FXML
    private JFXButton btn5;
    @FXML
    private JFXButton btn6;
    @FXML
    private JFXButton btn1;
    @FXML
    private JFXButton btn2;
    @FXML
    private JFXButton btn3;
    @FXML
    private JFXButton btnLimpar;
    @FXML
    private JFXButton btn0;
    @FXML
    private JFXButton btnVirgula;
    @FXML
    private JFXButton btnPagto;
    @FXML
    private JFXButton btnEnter;
    @FXML
    private TableView<?> tbvComanda;
    @FXML
    private Label txtTroco;
    @FXML
    private Label txtTotal;
    @FXML
    private TextField txtDescricao;
    @FXML
    private JFXComboBox<Produto> cbbCodigo;
    private String qtdeProduto;
    private String codigoProduto = "";
    private String mesa = "";
    private int foco = 1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void onBtn_7(ActionEvent event) {
        concatResult("7", foco);
    }

    @FXML
    private void onBtn_8(ActionEvent event) {
        concatResult("8", foco);
    }

    @FXML
    private void onBtn_9(ActionEvent event) {
        concatResult("9", foco);
    }

    @FXML
    private void onBtn_4(ActionEvent event) {
        concatResult("4", foco);
    }

    @FXML
    private void onBtn_5(ActionEvent event) {
        concatResult("5", foco);
    }

    @FXML
    private void onBtn_6(ActionEvent event) {
        concatResult("6", foco);
    }

    @FXML
    private void onBtn_1(ActionEvent event) {
        concatResult("1", foco);
    }

    @FXML
    private void onBtn_2(ActionEvent event) {
        concatResult("2", foco);
    }

    @FXML
    private void onBtn_3(ActionEvent event) {
        concatResult("3", foco);
    }

    @FXML
    private void onLimpar(ActionEvent event) {
    }

    @FXML
    private void onBtn_0(ActionEvent event) {
        concatResult("0", foco);
    }

    @FXML
    private void onBtn_Virgula(ActionEvent event) {
       concatResult(",", foco);
    }

    @FXML
    private void onPagar(ActionEvent event) {
    }

    @FXML
    private void onEnter(ActionEvent event) {
    }

    private void concatResult(String num, int foco) {
        switch (foco) {
            case 1:
                if (txtMesa.getText() == null || txtMesa.getText().isEmpty()) {
                    txtMesa.setText(num);
                } else {
                    txtMesa.setText(txtMesa.getText() + num);
                }
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                if (txtQtde.getText() == null || txtQtde.getText().isEmpty()) {
                    txtQtde.setText(num);
                } else {
                    txtQtde.setText(txtQtde.getText() + num);
                }
                break;
        }

    }

    @FXML
    private void onBuscarCodigo(KeyEvent event) {
    }

    @FXML
    private void onMouseClickMesa(MouseEvent event) {
        foco = 1;
        System.out.println("Foco" + foco);
    }

    @FXML
    private void onMouseClickQtde(MouseEvent event) {
        foco = 4;
        System.out.println("Foco" + foco);
    }

}
