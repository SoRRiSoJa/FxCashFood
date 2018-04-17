/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashf.controller.menu;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;

/**
 * FXML Controller class
 *
 * @author joao
 */
public class GavetasERPFXMLController implements Initializable {

    @FXML
    private VBox vBox;
    @FXML
    private Pane pane;
    @FXML
    private Circle circleImg;
    //-----------------------
    private Image image = new Image("Imagens/logo.png");

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        circleImg.setFill(new ImagePattern(image));
        circleImg.setEffect(new DropShadow(+25d, 0d, +2d, Color.DARKSLATEBLUE));
    }

}
