/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashf.controller.produto;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author joao
 */
public class GerenciarGruposFXMLController implements Initializable {

        
    @FXML
    private JFXButton btnSalvar;
    @FXML
    private JFXButton btnNovo;
    @FXML
    private JFXButton btnExcluir;
    @FXML
    private JFXButton btnLimpar;
    @FXML
    private JFXTextField txtDescricao;
    @FXML
    private JFXComboBox<?> cbbCategoria;
    @FXML
    private JFXTextField txtDescCat;
    @FXML
    private JFXButton btnAdicionar;
    @FXML
    private TableView<?> tbvCategoria;
    @FXML
    private TableColumn<?, ?> tbcCod;
    @FXML
    private TableColumn<?, ?> tbcDescricao;
    @FXML
    private TableColumn<?, ?> btnDeletar;
    @FXML
    private TableView<?> tbvGrupos;
    @FXML
    private TableColumn<?, ?> tbcCategoria;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void onSalvar(ActionEvent event) {
    }

    @FXML
    private void onNovo(ActionEvent event) {
    }

    @FXML
    private void onExcluir(ActionEvent event) {
    }

    @FXML
    private void onLimpar(ActionEvent event) {
    }

    @FXML
    private void onAdicionar(ActionEvent event) {
    }

    @FXML
    private void onMouseClicked(MouseEvent event) {
    }
    
}
