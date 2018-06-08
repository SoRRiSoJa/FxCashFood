/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashf.controller.menu;

import com.cashf.cashfood.MainApp;
import com.cashf.controller.mesas.MesaController;
import com.cashf.controller.registradora.NRegistradoraFXMLController;
import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author joao
 */
public class FCPainelProdutosFXMLController implements Initializable {

    @FXML
    private Pane paneProdutos;
    @FXML
    private FlowPane flowPane;
    @FXML
    private FlowPane flowPaneProd;
    @FXML
    private JFXButton btnAbrirMesa;
    @FXML
    private JFXButton btnFecharMesa;
    @FXML
    private JFXButton btnTransferirMesa;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        loadPanelGrupo();
        buttonsControlGrupos();
        setBtnKeys();
    }

    private void loadPanelGrupo() {
        FCMenuController.getInstance().getListaGrupos().forEach((gr) -> {
            JFXButton lb = new JFXButton();
            lb.setMinSize(200, 40);
            lb.setText(gr.getDescricao());
            lb.setAccessibleText(gr.getIdGrupo() + "");
            flowPane.getChildren().add(lb);
        });
    }

    private void loadPanelProduto() {
        FCMenuController.getInstance().getListaProdutos().forEach((pr) -> {
            JFXButton lb = new JFXButton();
            lb.setText(pr.getDescriao());
            lb.setAccessibleText(pr.getIdProduto() + "");
            lb.setMinSize(200, 40);
            lb.addEventHandler(MouseEvent.MOUSE_CLICKED, (e) -> {
                FCMenuController.getInstance().buscaProdutoById(pr.getIdProduto());
                NRegistradoraFXMLController._cbbProduto.getSelectionModel().select(FCMenuController.getInstance().getProdutoAtual());

            });
            flowPaneProd.getChildren().add(lb);
        });
    }

    private void buttonsControlGrupos() {
        flowPane.getChildren().stream().filter((node) -> (node.getAccessibleText() != null)).forEachOrdered((node) -> {
            node.addEventHandler(MouseEvent.MOUSE_CLICKED, (e) -> {
                FCMenuController.getInstance().buscaProdutosByGrupo(node.getAccessibleText());
                loadPanelProduto();
            });
        });
    }

    @FXML
    private void onAbrirMesa(ActionEvent event) {
        loadBox("/fxml/mesas/AbrirMesaFXML.fxml", "Mesa Nº" + MesaController.getInstance().getMesaAtual().toString());
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

    private void setBtnKeys() {
        MainApp.janelaAberta.addEventHandler(KeyEvent.KEY_PRESSED, (KeyEvent t) -> {
            if (t.getCode() == KeyCode.F2) {
                loadBox("/fxml/mesas/AbrirMesaFXML.fxml", "Mesa Nº" + MesaController.getInstance().getMesaAtual().toString());
            }
        });
        MainApp.janelaAberta.addEventHandler(KeyEvent.KEY_PRESSED, (KeyEvent t) -> {
            if (t.getCode() == KeyCode.F3) {
                //loadBox("/fxml/mesas/AbrirMesaFXML.fxml", "Mesa Nº" + MesaController.getInstance().getMesaAtual().toString());
            }
        });
        MainApp.janelaAberta.addEventHandler(KeyEvent.KEY_PRESSED, (KeyEvent t) -> {
            if (t.getCode() == KeyCode.F4) {
                //loadBox("/fxml/mesas/AbrirMesaFXML.fxml", "Mesa Nº" + MesaController.getInstance().getMesaAtual().toString());
            }
        });

    }

    @FXML
    private void onFecharMesa(ActionEvent event) {
    }

    @FXML
    private void onTransferirMesa(ActionEvent event) {
    }
}
