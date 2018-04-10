/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashf.controller.menu;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

/**
 * FXML Controller class
 *
 * @author joao
 */
public class MenuSistemaFXMLController implements Initializable {

    //-------------------
    private static StackPane rootAux;
    private Pane paneAux;
    private Pane paneAnt;
    private boolean flag = false;
    @FXML
    private StackPane rootStackPane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    private void loadFxml(String path) {
        StackPane menuPrincipal;
        try {
            menuPrincipal = FXMLLoader.load(getClass().getResource(path));
            rootStackPane.getChildren().setAll(menuPrincipal);
        } catch (IOException ex) {
            System.out.println("Erro--->>" + ex);
        }

    }

    @FXML
    private void onPdv(ActionEvent event) {
        loadFxml("/fxml/FXMenuFCaixaFXML.fxml");
    }

    @FXML
    private void onErp(ActionEvent event) {
        loadFxml("/fxml/FXMenuFXML.fxml");
    }

    @FXML
    private void onSistema(ActionEvent event) {
    }

    @FXML
    private void onSair(ActionEvent event) {
    System.exit(0);
    }
}
