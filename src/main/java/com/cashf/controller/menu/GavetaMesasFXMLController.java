/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashf.controller.menu;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
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
public class GavetaMesasFXMLController implements Initializable {

    @FXML
    private VBox vBox;
    @FXML
    private Pane pane;
    @FXML
    private Circle circleImg;
    @FXML
    private FontAwesomeIconView iconM1;
    @FXML
    private FontAwesomeIconView iconM2;
    @FXML
    private FontAwesomeIconView iconM3;
    @FXML
    private FontAwesomeIconView iconM4;
    @FXML
    private FontAwesomeIconView iconM5;
    @FXML
    private FontAwesomeIconView iconM6;
    @FXML
    private FontAwesomeIconView iconM7;
    @FXML
    private FontAwesomeIconView iconM8;
    @FXML
    private FontAwesomeIconView iconM9;
    @FXML
    private FontAwesomeIconView iconM10;
    @FXML
    private FontAwesomeIconView iconM11;
    @FXML
    private FontAwesomeIconView iconM12;
    @FXML
    private FontAwesomeIconView iconM13;
    @FXML
    private FontAwesomeIconView iconM14;
    @FXML
    private FontAwesomeIconView iconM15;
    @FXML
    private FontAwesomeIconView iconM16;
    @FXML
    private FontAwesomeIconView iconM17;
    @FXML
    private FontAwesomeIconView iconM18;

    //-----------------------
    private Image image = new Image("Imagens/logo.png");
    private static FontAwesomeIconView _iconM1;
    private static FontAwesomeIconView _iconM2;
    private static FontAwesomeIconView _iconM3;
    private static FontAwesomeIconView _iconM4;
    private static FontAwesomeIconView _iconM5;
    private static FontAwesomeIconView _iconM6;
    private static FontAwesomeIconView _iconM7;
    private static FontAwesomeIconView _iconM8;
    private static FontAwesomeIconView _iconM9;
    private static FontAwesomeIconView _iconM10;
    private static FontAwesomeIconView _iconM11;
    private static FontAwesomeIconView _iconM12;
    private static FontAwesomeIconView _iconM13;
    private static FontAwesomeIconView _iconM14;
    private static FontAwesomeIconView _iconM15;
    private static FontAwesomeIconView _iconM16;
    private static FontAwesomeIconView _iconM17;
    private static FontAwesomeIconView _iconM18;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        _iconM1 = iconM1;
        _iconM2 = iconM2;
        _iconM3 = iconM3;
        _iconM4 = iconM4;
        _iconM5 = iconM5;
        _iconM6 = iconM6;
        _iconM7 = iconM7;
        _iconM8 = iconM8;
        _iconM9 = iconM9;
        _iconM10 = iconM10;
        _iconM11 = iconM11;
        _iconM12 = iconM12;
        _iconM13 = iconM13;
        _iconM14 = iconM14;
        _iconM15 = iconM15;
        _iconM16 = iconM16;
        _iconM17 = iconM17;
        _iconM18 = iconM18;

        circleImg.setFill(new ImagePattern(image));
        circleImg.setEffect(new DropShadow(+25d, 0d, +2d, Color.DARKSLATEBLUE));
    }

    public static FontAwesomeIconView getIconM1() {
        return _iconM1;
    }

    public static FontAwesomeIconView getIconM2() {
        return _iconM2;
    }

    public static FontAwesomeIconView getIconM3() {
        return _iconM3;
    }

    public static FontAwesomeIconView getIconM4() {
        return _iconM4;
    }

    public static FontAwesomeIconView getIconM5() {
        return _iconM5;
    }

    public static FontAwesomeIconView getIconM6() {
        return _iconM6;
    }

    public static FontAwesomeIconView getIconM7() {
        return _iconM7;
    }

    public static FontAwesomeIconView getIconM8() {
        return _iconM8;
    }

    public static FontAwesomeIconView getIconM9() {
        return _iconM9;
    }

    public static FontAwesomeIconView getIconM10() {
        return _iconM10;
    }

    public static FontAwesomeIconView getIconM11() {
        return _iconM11;
    }

    public static FontAwesomeIconView getIconM12() {
        return _iconM12;
    }

    public static FontAwesomeIconView getIconM13() {
        return _iconM13;
    }

    public static FontAwesomeIconView getIconM14() {
        return _iconM14;
    }

    public static FontAwesomeIconView getIconM15() {
        return _iconM15;
    }

    public static FontAwesomeIconView getIconM16() {
        return _iconM16;
    }

    public static FontAwesomeIconView getIconM17() {
        return _iconM17;
    }

    public static FontAwesomeIconView getIconM18() {
        return _iconM18;
    }
    

}
