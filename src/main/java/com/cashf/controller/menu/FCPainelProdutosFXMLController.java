/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashf.controller.menu;

import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;

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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        loadPanelGrupo();
        buttonsControlGrupos();
    }

    private void loadPanelGrupo() {
        FCMenuController.getInstance().getListaGrupos().forEach((gr) -> {
            JFXButton lb = new JFXButton();
            lb.setText(gr.getDescricao());
            lb.setAccessibleText(gr.getIdGrupo()+"");
            flowPane.getChildren().add(lb);
        });
    }
     private void loadPanelProduto() {
        FCMenuController.getInstance().getListaProdutos().forEach((pr) -> {
            JFXButton lb = new JFXButton();
            lb.setText(pr.getDescriao());
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

}
