/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashf.controller.registradora;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
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
    private JFXComboBox<?> cbbCodigo;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
