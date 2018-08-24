/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashf.controller.menu;

import com.cashf.cashfood.MainApp;
import com.cashf.controller.caixa.CaixaController;
import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import util.PoupUpUtil;

/**
 * FXML Controller class
 *
 * @author joao
 */
public class MenuFXMLController implements Initializable {

    @FXML
    private MenuBar menuBar;
    @FXML
    private HBox hBox;
    @FXML
    private JFXButton btnPrePreparo;
    @FXML
    private JFXButton btnCombos;
    @FXML
    private JFXButton btnNaUm;
    @FXML
    private JFXButton btnNaDois;
    @FXML
    private JFXButton btnNATres;
    @FXML
    private JFXButton btnCaixa;
    @FXML
    private JFXButton btnAjustarEstoque;
    @FXML
    private Pane paneBody;
    @FXML
    private StackPane rootStackPane;
    //-------------------
    private static StackPane rootAux;
    private StackPane stAux;
    private Pane paneAux;
    private Pane paneAnt;
    private boolean flag = false;
    @FXML
    private VBox rootVbox;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        MainApp.paneRoot = rootStackPane;
        rootAux = rootStackPane;
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
    private void onPrePreparo(ActionEvent event) {
        loadFXML("/fxml/prePreparo/GerenciarPrePreparoFXML.fxml");
    }

    @FXML
    private void onCombos(ActionEvent event) {
        loadFXML("/fxml/combos/GerenciarCombosFXML.fxml");
    }

    @FXML
    private void onFichaTecnica(ActionEvent event) {
        loadFXML("/fxml/fichaTecnica/GerenciarFichasTecnicasFXML.fxml");
    }

    @FXML
    private void onNaDois(ActionEvent event) {
        if (CaixaController.getInstance().getCaixaAberto().getIdCaixa() != 0) {
            loadFXML("/fxml/receberPedido/ReceberPedidoFXML.fxml");
        } else {
            PoupUpUtil.errorMessage(rootVbox, MainApp.paneRoot, "Um Caixa deve Ser aberto!");
        }
    }

    @FXML
    private void OnNaTres(ActionEvent event) {
        if (CaixaController.getInstance().getCaixaAberto().getIdCaixa() != 0) {
            loadFXML("/fxml/contasPagar/ContasPagarFXML.fxml");
        } else {
            PoupUpUtil.errorMessage(rootVbox, MainApp.paneRoot, "Um Caixa deve Ser aberto!");
        }
    }

    @FXML
    private void OnCaixa(ActionEvent event) {
        loadFXML("/fxml/caixa/GerenciarCaixaFXML.fxml");
    }

    @FXML
    private void onAjustarEstoque(ActionEvent event) {
        loadFXML("/fxml/ajusteEstoque/AjustarEstoqueFXML.fxml");
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
}
