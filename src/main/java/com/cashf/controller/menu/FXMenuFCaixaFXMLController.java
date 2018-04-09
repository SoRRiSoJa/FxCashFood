/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashf.controller.menu;

import com.cashf.cashfood.MainApp;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.transitions.hamburger.HamburgerNextArrowBasicTransition;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author joao
 */
public class FXMenuFCaixaFXMLController implements Initializable {

    @FXML
    private Pane paneHeader;
    @FXML
    private JFXHamburger jfxHamburguer;
    @FXML
    private JFXButton btnSair;
    @FXML
    private FontAwesomeIconView iconSair;
    @FXML
    private JFXDrawer jfxDrawer;
    @FXML
    private Pane paneCalc;
    @FXML
    private Pane paneProdutos;
    //-------------------
    private static StackPane rootAux;
    private VBox gavetas;
    private HamburgerNextArrowBasicTransition burgerTask2;
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
        MainApp.paneRoot = rootStackPane;
        rootAux = rootStackPane;
        loadDrawer();
        burgerTask2 = new HamburgerNextArrowBasicTransition(jfxHamburguer);
        burgerTask2.setRate(-1);
        jfxHamburguer.addEventHandler(MouseEvent.MOUSE_PRESSED, (e) -> {
            burgerTask2.setRate(burgerTask2.getRate() * -1);
            burgerTask2.play();
            if (jfxDrawer.isHidden()) {
                if (flag) {
                    paneHeader.getChildren().remove(paneAux);
                }
                jfxDrawer.open();
                jfxDrawer.setMinWidth(180);
            } else {
                jfxDrawer.close();
                jfxDrawer.setMinWidth(0);
            }
        });
        loadPanelGrupo();
        // TODO
    }

    @FXML
    private void onSair(ActionEvent event) {
        System.exit(0);
    }

    private void loadPanelGrupo() {
        Pane auxPane;
        try {
            auxPane = FXMLLoader.load(getClass().getResource("/fxml/FCPainelProdutosFXML.fxml"));
            paneProdutos.getChildren().add(auxPane);
        } catch (IOException ex) {
            System.out.println("Erro ao abrir:" + ex);
        }

    }

    private void loadDrawer() {
        try {
            gavetas = FXMLLoader.load(getClass().getResource("/fxml/GavetaMesasFXML.fxml"));
            jfxDrawer.setSidePane(gavetas);
        } catch (IOException ex) {
            System.out.println("Erro:" + ex);
        }
    }

}
