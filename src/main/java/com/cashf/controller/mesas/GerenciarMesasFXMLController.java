/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashf.controller.mesas;

import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

/**
 * FXML Controller class
 *
 * @author joao
 */
public class GerenciarMesasFXMLController implements Initializable {

    @FXML
    private StackPane rootStackPane;
    @FXML
    private Pane paneCentral;
    @FXML
    private JFXButton btnRegistrar;
    @FXML
    private JFXButton btnTransferir;
    @FXML
    private JFXButton btnFechar;
    @FXML
    private JFXButton btnFecharParcial;
    @FXML
    private TableView<?> tbvComanda;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void onRegistrar(ActionEvent event) {
    }

    @FXML
    private void onTransferir(ActionEvent event) {
    }

    @FXML
    private void onFechar(ActionEvent event) {
    }

    @FXML
    private void onFecharParcial(ActionEvent event) {
    }
    
}
