/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashf.controller.menu;

import com.cashf.cashfood.MainApp;
import com.cashf.controller.caixa.CaixaController;
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
import util.PoupUpUtil;

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
    private StackPane stAux;
    private VBox gavetas;
    private HamburgerNextArrowBasicTransition burgerTask2;
    private Pane paneAux;
    private Pane paneAnt;
    private boolean flag = false;
    @FXML
    private JFXButton btnPrePreparo;
    @FXML
    private JFXButton btnAjustarEstoque;
    @FXML
    private JFXButton btnNaUm;
    @FXML
    private JFXButton btnNaDois;
    @FXML
    private JFXButton btnNATres;
    @FXML
    private JFXButton btnCaixa;
    @FXML
    private JFXButton btnCombos;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        MainApp.paneRoot = rootSatackPane;
        rootAux = rootSatackPane;
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
        loadFXML("/fxml/clientes/FXGerenciarClientesFXML.fxml");
    }

    @FXML
    private void onFornecedores(ActionEvent event) {
        loadFXML("/fxml/fornecedores/FXGerenciarFornecedoresFXML.fxml");
    }

    @FXML
    private void onProdutos(ActionEvent event) {
        loadFXML("/fxml/produto/FXGerenciarProdutosFXML.fxml");
    }

    @FXML
    private void onGrupos(ActionEvent event) {
        loadFXML("/fxml/produto/GerenciarGruposFXML.fxml");
    }

    @FXML
    private void onContaCorrente(ActionEvent event) {
        loadFXML("/fxml/contaCorrente/GerenciarContasFXML.fxml");
    }

    @FXML
    private void onMeioPagamento(ActionEvent event) {
        loadFXML("/fxml/meioPagamento/MeioPagamentoFXML.fxml");
    }

    @FXML
    private void onFuncionarios(ActionEvent event) {
        loadFXML("/fxml/funcionario/FXGerenciarFuncionariosFXML.fxml");
    }

    @FXML
    private void onSair(ActionEvent event) {
        rootSatackPane.getChildren().remove(0);
        try {
            stAux = FXMLLoader.load(getClass().getResource("/fxml/MenuSistemaFXML.fxml"));
            rootSatackPane.getChildren().add(stAux);
        } catch (IOException ex) {
            System.out.println("Erro--->>" + ex);
        }
    }

    //----------------------------------------------
    private void loadDrawer() {
        try {
            gavetas = FXMLLoader.load(getClass().getResource("/fxml/GavetasERPFXML.fxml"));
            drawer.setSidePane(gavetas);
        } catch (IOException ex) {
            System.out.println("Erro:" + ex);
        }
    }

    //------------------------
    private void loadFXML(String path) {
        try {
            flag = true;
            paneAnt = paneAux;
            paneAux = FXMLLoader.load(getClass().getResource(path));
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

    @FXML
    private void onPrePreparo(ActionEvent event) {
        loadFXML("/fxml/prePreparo/GerenciarPrePreparoFXML.fxml");
    }

    @FXML
    private void onAjustarEstoque(ActionEvent event) {
        loadFXML("/fxml/ajusteEstoque/AjustarEstoqueFXML.fxml");
    }

    @FXML
    private void onFichaTecnica(ActionEvent event) {

        loadFXML("/fxml/fichaTecnica/GerenciarFichasTecnicasFXML.fxml");
    }

    @FXML
    private void onNaDois(ActionEvent event) {
        loadFXML("/fxml/receberPedido/ReceberPedidoFXML.fxml");
    }

    @FXML
    private void OnNaTres(ActionEvent event) {
        if (CaixaController.getInstance().getCaixaAberto().getIdCaixa() != 0) {
            loadFXML("/fxml/contasPagar/ContasPagarFXML.fxml");
        } else {
            PoupUpUtil.errorMessage(rootAcnhorPane, MainApp.paneRoot, "Um Caixa deve Ser aberto!");
        }
    }

    @FXML
    private void OnCaixa(ActionEvent event) {
        loadFXML("/fxml/caixa/GerenciarCaixaFXML.fxml");
    }

    @FXML
    private void onCombos(ActionEvent event) {
        loadFXML("/fxml/combos/GerenciarCombosFXML.fxml");
    }
    
}
