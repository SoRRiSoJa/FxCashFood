/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashf.controller.menu;

import com.cashf.cashfood.MainApp;
import com.cashf.controller.mesas.MesaController;
import com.cashf.core.venda.VendaController;
import com.cashf.model.mesa.StatusMesa;
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
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.stage.Modality;
import javafx.stage.Stage;

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
    private StackPane stAux;
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
        jfxDrawer.open();
        loadPanelGrupo();
        menuButtonsControl();
        loadRegistradora();
        // TODO
    }

    @FXML
    private void onSair(ActionEvent event) {
        rootStackPane.getChildren().remove(0);
        try {
            stAux = FXMLLoader.load(getClass().getResource("/fxml/MenuSistemaFXML.fxml"));
            rootStackPane.getChildren().add(stAux);
        } catch (IOException ex) {
            System.out.println("Erro--->>" + ex);
        }
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

    private void menuButtonsControl() {
        String title = "";
        for (Node node : gavetas.getChildren()) {
            if (node.getAccessibleText() != null) {
                if (node.getAccessibleText().equalsIgnoreCase("FPane")) {
                    FlowPane fp = (FlowPane) node;
                    for (Node nodeFp : fp.getChildren()) {
                        nodeFp.addEventHandler(MouseEvent.MOUSE_CLICKED, (e) -> {
                            switch (nodeFp.getAccessibleText()) {
                                case "M01":
                                    GavetaMesasFXMLController.getIconM1().setFill(Paint.valueOf("RED"));
                                    MesaController.getInstance().setMesaAtual(MesaController.getInstance().getMesaNum(1));
                                    break;
                                case "M02":
                                    GavetaMesasFXMLController.getIconM2().setFill(Paint.valueOf("RED"));
                                    MesaController.getInstance().setMesaAtual(MesaController.getInstance().getMesaNum(2));
                                    break;
                                case "M03":
                                    GavetaMesasFXMLController.getIconM3().setFill(Paint.valueOf("RED"));
                                    MesaController.getInstance().setMesaAtual(MesaController.getInstance().getMesaNum(3));
                                    break;
                                case "M04":
                                    GavetaMesasFXMLController.getIconM4().setFill(Paint.valueOf("RED"));
                                    MesaController.getInstance().setMesaAtual(MesaController.getInstance().getMesaNum(4));
                                    break;
                                case "M05":
                                    GavetaMesasFXMLController.getIconM5().setFill(Paint.valueOf("RED"));
                                    MesaController.getInstance().setMesaAtual(MesaController.getInstance().getMesaNum(5));
                                    break;
                                case "M06":
                                    GavetaMesasFXMLController.getIconM6().setFill(Paint.valueOf("RED"));
                                    MesaController.getInstance().setMesaAtual(MesaController.getInstance().getMesaNum(6));
                                    break;
                                case "M07":
                                    GavetaMesasFXMLController.getIconM7().setFill(Paint.valueOf("RED"));
                                    MesaController.getInstance().setMesaAtual(MesaController.getInstance().getMesaNum(7));
                                    break;
                                case "M08":
                                    GavetaMesasFXMLController.getIconM8().setFill(Paint.valueOf("RED"));
                                    MesaController.getInstance().setMesaAtual(MesaController.getInstance().getMesaNum(8));
                                    break;
                                case "M09":
                                    GavetaMesasFXMLController.getIconM9().setFill(Paint.valueOf("RED"));
                                    MesaController.getInstance().setMesaAtual(MesaController.getInstance().getMesaNum(9));
                                    break;
                                case "M10":
                                    GavetaMesasFXMLController.getIconM10().setFill(Paint.valueOf("RED"));
                                    MesaController.getInstance().setMesaAtual(MesaController.getInstance().getMesaNum(10));
                                    break;
                                case "M11":
                                    GavetaMesasFXMLController.getIconM11().setFill(Paint.valueOf("RED"));
                                    MesaController.getInstance().setMesaAtual(MesaController.getInstance().getMesaNum(11));
                                    break;
                                case "M12":
                                    GavetaMesasFXMLController.getIconM12().setFill(Paint.valueOf("RED"));
                                    MesaController.getInstance().setMesaAtual(MesaController.getInstance().getMesaNum(12));
                                    break;
                                case "M13":
                                    GavetaMesasFXMLController.getIconM13().setFill(Paint.valueOf("RED"));
                                    MesaController.getInstance().setMesaAtual(MesaController.getInstance().getMesaNum(13));
                                    break;
                                case "M14":
                                    GavetaMesasFXMLController.getIconM14().setFill(Paint.valueOf("RED"));
                                    MesaController.getInstance().setMesaAtual(MesaController.getInstance().getMesaNum(14));
                                    break;
                                case "M15":
                                    GavetaMesasFXMLController.getIconM15().setFill(Paint.valueOf("RED"));
                                    MesaController.getInstance().setMesaAtual(MesaController.getInstance().getMesaNum(15));
                                    break;
                                case "M16":
                                    GavetaMesasFXMLController.getIconM16().setFill(Paint.valueOf("RED"));
                                    MesaController.getInstance().setMesaAtual(MesaController.getInstance().getMesaNum(16));
                                    break;
                                case "M17":
                                    GavetaMesasFXMLController.getIconM17().setFill(Paint.valueOf("RED"));
                                    MesaController.getInstance().setMesaAtual(MesaController.getInstance().getMesaNum(17));
                                    break;
                                case "M18":
                                    GavetaMesasFXMLController.getIconM18().setFill(Paint.valueOf("RED"));
                                    break;
                            }
                            VendaController.getInstance().setVenda(VendaController.getInstance().getVendaByMesa(MesaController.getInstance().getMesaAtual()));
                            if (VendaController.getInstance().getVenda().getMesa().getIdMesa() == 0) {
                                loadBox("/fxml/mesas/AbrirMesaFXML.fxml", "Mesa Nº" + MesaController.getInstance().getMesaAtual().toString());
                            } else {
                                loadBox("/fxml/mesas/RegistrarConsumoFXML.fxml", "Mesa Nº" + MesaController.getInstance().getMesaAtual().toString());
                            }
                        });
                    }

                }
            }
        }
    }

    private void loadBox(String boxPath, String title) {
        try {
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource(boxPath));
            stage.setScene(new Scene(root));
            stage.setTitle(title);
            stage.initModality(Modality.APPLICATION_MODAL);
            MainApp.janelaAnterior = MainApp.janelaAberta;
            MainApp.janelaAberta = stage;
            stage.show();
        } catch (IOException ex) {
            System.out.println("Erro---->" + ex);
        }
    }

    private void loadRegistradora() {
        try {
            paneAux = FXMLLoader.load(getClass().getResource("/fxml/registradora/NRegistradoraFXML.fxml"));
            paneCalc.getChildren().add(paneAux);
        } catch (IOException ex) {
            System.out.println("Erro:" + ex);
        }
    }

    public static void changeStatusTable(int num, StatusMesa status) {
        String statusColor = "";
        statusColor += (status.equals(StatusMesa.ABERTA)) ? "RED" : "GREEN";
        switch (num) {
            case 1:
                GavetaMesasFXMLController.getIconM1().setFill(Paint.valueOf(statusColor));
                break;
            case 2:
                GavetaMesasFXMLController.getIconM2().setFill(Paint.valueOf(statusColor));
                break;
            case 3:
                GavetaMesasFXMLController.getIconM3().setFill(Paint.valueOf(statusColor));
                break;
            case 4:
                GavetaMesasFXMLController.getIconM4().setFill(Paint.valueOf(statusColor));
                break;
            case 5:
                GavetaMesasFXMLController.getIconM5().setFill(Paint.valueOf(statusColor));
                break;
            case 6:
                GavetaMesasFXMLController.getIconM6().setFill(Paint.valueOf(statusColor));
                break;
            case 7:
                GavetaMesasFXMLController.getIconM7().setFill(Paint.valueOf(statusColor));
                break;
            case 8:
                GavetaMesasFXMLController.getIconM8().setFill(Paint.valueOf(statusColor));
                break;
            case 9:
                GavetaMesasFXMLController.getIconM9().setFill(Paint.valueOf(statusColor));
                break;
            case 10:
                GavetaMesasFXMLController.getIconM10().setFill(Paint.valueOf(statusColor));
                break;
            case 11:
                GavetaMesasFXMLController.getIconM11().setFill(Paint.valueOf(statusColor));
                break;
            case 12:
                GavetaMesasFXMLController.getIconM12().setFill(Paint.valueOf(statusColor));
                break;
            case 13:
                GavetaMesasFXMLController.getIconM13().setFill(Paint.valueOf(statusColor));
                break;
            case 14:
                GavetaMesasFXMLController.getIconM14().setFill(Paint.valueOf(statusColor));
                break;
            case 15:
                GavetaMesasFXMLController.getIconM15().setFill(Paint.valueOf(statusColor));
                break;
            case 16:
                GavetaMesasFXMLController.getIconM16().setFill(Paint.valueOf(statusColor));
                break;
            case 17:
                GavetaMesasFXMLController.getIconM17().setFill(Paint.valueOf(statusColor));
                break;
            case 18:
                GavetaMesasFXMLController.getIconM18().setFill(Paint.valueOf(statusColor));
                break;

        }

    }

}
