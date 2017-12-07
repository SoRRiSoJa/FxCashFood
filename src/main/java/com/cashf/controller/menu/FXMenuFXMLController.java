/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashf.controller.menu;

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
import javafx.scene.Node;
import javafx.scene.control.MenuBar;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;

/**
 * FXML Controller class
 *
 * @author joao
 */
public class FXMenuFXMLController implements Initializable {

    @FXML
    private StackPane rootSatackPane;
    @FXML
    private AnchorPane rootAcnhorPane;
    @FXML
    private MenuBar menuBar;
    @FXML
    private Pane paneHeader;
    @FXML
    private JFXHamburger jfxHamburguer;
    @FXML
    private JFXButton btnSair;
    @FXML
    private FontAwesomeIconView iconSair;
    @FXML
    private HBox hBox;
    @FXML
    private Pane paneBody;
    @FXML
    private JFXDrawer drawer;
    //-------------------
    private static StackPane rootAux;
    private VBox gavetas;
    private HamburgerNextArrowBasicTransition burgerTask2;
    private Pane paneAux;
    private Pane paneAnt;
    private boolean flag = false;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        rootAux=rootSatackPane;
        loadDrawer();
        burgerTask2 = new HamburgerNextArrowBasicTransition(jfxHamburguer);
        burgerTask2.setRate(-1);
        jfxHamburguer.addEventHandler(MouseEvent.MOUSE_PRESSED, (e) -> {
            burgerTask2.setRate(burgerTask2.getRate() * -1);
            burgerTask2.play();
            if (drawer.isHidden()) {
                if (flag) {
                    paneBody.getChildren().remove(paneAux);
                }
                drawer.open();
                drawer.setMinWidth(180);
            } else {
                drawer.close();
                drawer.setMinWidth(0);
            }
        });
        menuButtonsControl();
    }

    @FXML
    private void onClientes(ActionEvent event) {
    loadClientes();
    }

    @FXML
    private void onFornecedores(ActionEvent event) {
    loadFornecedor();
    }

    @FXML
    private void onProdutos(ActionEvent event) {
    loadProdutos();
    }

    @FXML
    private void onGrupos(ActionEvent event) {
    loadGrupos();
    }

    @FXML
    private void onContaCorrente(ActionEvent event) {
    loadContaCorrente();
    }

    @FXML
    private void onMeioPagamento(ActionEvent event) {
    loadMeioPagamento();
    }

    @FXML
    private void onFuncionarios(ActionEvent event) {
    loadFuncionario();
    }

    @FXML
    private void onSair(ActionEvent event) {
        System.exit(0);
    }

    //----------------------------------------------
    private void loadDrawer() {
        try {
            gavetas = FXMLLoader.load(getClass().getResource("/fxml/GavetaMesasFXML.fxml"));
            drawer.setSidePane(gavetas);
        } catch (IOException ex) {
            System.out.println("Erro:" + ex);
        }
    }

    //------------------------
    private void loadContaCorrente() {
        try {
            flag = true;
            paneAnt = paneAux;
            paneAux = FXMLLoader.load(getClass().getResource("/fxml/contaCorrente/GerenciarContasFXML.fxml"));
            paneBody.getChildren().remove(paneAnt);
            paneBody.getChildren().add(paneAux);
        } catch (IOException ex) {
            System.out.println("Erro:" + ex);
        }
    }

    //------------------------
    private void loadMeioPagamento() {
        try {
            flag = true;
            paneAnt = paneAux;
            paneAux = FXMLLoader.load(getClass().getResource("/fxml/meioPagamento/MeioPagamentoFXML.fxml"));
            paneBody.getChildren().remove(paneAnt);
            paneBody.getChildren().add(paneAux);
        } catch (IOException ex) {
            System.out.println("Erro:" + ex);
        }
    }

    //------------------------
    private void loadFuncionario() {
        try {
            flag = true;
            paneAnt = paneAux;
            paneAux = FXMLLoader.load(getClass().getResource("/fxml/funcionario/GerenciarFuncionariosFXML.fxml"));
            paneBody.getChildren().remove(paneAnt);
            paneBody.getChildren().add(paneAux);
        } catch (IOException ex) {
            System.out.println("Erro:" + ex);
        }
    }

    //------------------------
    private void loadFornecedor() {
        try {
            flag = true;
            paneAnt = paneAux;
            paneAux = FXMLLoader.load(getClass().getResource("/fxml/fornecedores/FXGerenciarFornecedoresFXML.fxml"));
            paneBody.getChildren().remove(paneAnt);
            paneBody.getChildren().add(paneAux);
        } catch (IOException ex) {
            System.out.println("Erro:" + ex);
        }
    }

    private void loadGrupos() {
        try {
            flag = true;
            paneAnt = paneAux;
            paneAux = FXMLLoader.load(getClass().getResource("/fxml/produto/GerenciarGruposFXML.fxml"));
            paneBody.getChildren().remove(paneAnt);
            paneBody.getChildren().add(paneAux);
        } catch (IOException ex) {
            System.out.println("Erro:" + ex);
        }
    }

    //------------------------
    private void loadProdutos() {
        try {
            flag = true;
            paneAnt = paneAux;
            paneAux = FXMLLoader.load(getClass().getResource("/fxml/produto/FXGerenciarProdutosFXML.fxml"));
            paneBody.getChildren().remove(paneAnt);
            paneBody.getChildren().add(paneAux);
        } catch (IOException ex) {
            System.out.println("Erro:" + ex);
        }
    }

    //------------------------
    private void loadClientes() {
        try {
            flag = true;
            paneAnt = paneAux;
            paneAux = FXMLLoader.load(getClass().getResource("/fxml/clientes/FXGerenciarClientesFXML.fxml"));
            paneBody.getChildren().remove(paneAnt);
            paneBody.getChildren().add(paneAux);
        } catch (IOException ex) {
            System.out.println("Erro:" + ex);
        }
    }
    //---------------------------------------------

    private void menuButtonsControl() {
        for (Node node : gavetas.getChildren()) {
            if (node.getAccessibleText() != null) {
                if (node.getAccessibleText().equalsIgnoreCase("FPane")) {
                    FlowPane fp = (FlowPane) node;
                    for (Node nodeFp : fp.getChildren()) {
                        nodeFp.addEventHandler(MouseEvent.MOUSE_CLICKED, (e) -> {
                            switch (nodeFp.getAccessibleText()) {
                                case "M01":
                                    GavetaMesasFXMLController.getIconM1().setFill(Paint.valueOf("RED"));
                                    System.out.println("Mesa1");
                                    break;
                                case "M02":
                                    GavetaMesasFXMLController.getIconM2().setFill(Paint.valueOf("RED"));
                                    System.out.println("Mesa2");
                                    drawer.close();
                                    break;
                                case "M03":
                                    GavetaMesasFXMLController.getIconM3().setFill(Paint.valueOf("RED"));
                                    System.out.println("Mesa3");
                                    drawer.close();
                                    break;
                                case "M04":
                                    GavetaMesasFXMLController.getIconM4().setFill(Paint.valueOf("RED"));
                                    drawer.close();
                                    break;
                                case "M05":
                                    GavetaMesasFXMLController.getIconM5().setFill(Paint.valueOf("RED"));
                                    drawer.close();
                                    break;
                                case "M06":
                                    GavetaMesasFXMLController.getIconM6().setFill(Paint.valueOf("RED"));
                                    drawer.close();
                                    break;
                                case "M07":
                                    GavetaMesasFXMLController.getIconM7().setFill(Paint.valueOf("RED"));
                                    drawer.close();
                                    break;
                                case "M08":
                                    GavetaMesasFXMLController.getIconM8().setFill(Paint.valueOf("RED"));
                                    drawer.close();
                                    break;
                                case "M09":
                                    GavetaMesasFXMLController.getIconM9().setFill(Paint.valueOf("RED"));
                                    drawer.close();
                                    break;
                                case "M10":
                                    GavetaMesasFXMLController.getIconM10().setFill(Paint.valueOf("RED"));
                                    drawer.close();
                                    break;
                                case "M11":
                                    GavetaMesasFXMLController.getIconM11().setFill(Paint.valueOf("RED"));
                                    drawer.close();
                                    break;
                                case "M12":
                                    GavetaMesasFXMLController.getIconM12().setFill(Paint.valueOf("RED"));
                                    drawer.close();
                                    break;
                                case "M13":
                                    GavetaMesasFXMLController.getIconM13().setFill(Paint.valueOf("RED"));
                                    drawer.close();
                                    break;
                                case "M14":
                                    GavetaMesasFXMLController.getIconM14().setFill(Paint.valueOf("RED"));
                                    drawer.close();
                                    break;
                                case "M15":
                                    GavetaMesasFXMLController.getIconM15().setFill(Paint.valueOf("RED"));
                                    drawer.close();
                                    break;
                                case "M16":
                                    GavetaMesasFXMLController.getIconM16().setFill(Paint.valueOf("RED"));
                                    drawer.close();
                                    break;
                                case "M17":
                                    GavetaMesasFXMLController.getIconM17().setFill(Paint.valueOf("RED"));
                                    drawer.close();
                                    break;
                                case "M18":
                                    GavetaMesasFXMLController.getIconM18().setFill(Paint.valueOf("RED"));
                                    drawer.close();
                                    break;
                            }
                        });
                    }

                }
            }
        }
    }

    public static StackPane getRootAux() {
        return rootAux;
    }

}
