/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashf.controller.produto;

import com.cashf.model.produto.Categoria;
import com.cashf.model.produto.Grupo;
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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author joao
 */
public class GerenciarGruposFXMLController implements Initializable {

    //----------------------------------------------
    private GrupoController controller = new GrupoController();
    private String erros;
    private boolean flagButtons;
    private String descricao;
    private String descricaoCategoria;
    private long idGrupo = 0;
    private long idCat = 0;
    @FXML
    private TableColumn<Categoria, String> tbcDescricaoCat;
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
    private JFXComboBox<Categoria> cbbCategoria;
    @FXML
    private JFXTextField txtDescCat;
    @FXML
    private JFXButton btnAdicionar;
    @FXML
    private TableView<Categoria> tbvCategoria;
    @FXML
    private TableColumn<Categoria, Integer> tbcCodCat;
    @FXML
    private TableColumn btnDeletar;
    @FXML
    private TableView<Grupo> tbvGrupos;
    @FXML
    private TableColumn<Grupo, String> tbcDescricaoGrupo;
    @FXML
    private TableColumn<Grupo, String> tbcCategoriaGrupo;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        loadCbbCategoria();
        setInputOff();
    }
    
    @FXML
    private void onSalvar(ActionEvent event) {
    }
    
    @FXML
    private void onNovo(ActionEvent event) {
        setInputON();
        clearFields();
        btnNovo.setDisable(true);
        btnExcluir.setDisable(true);
    }
    
    @FXML
    private void onExcluir(ActionEvent event) {
    }
    
    @FXML
    private void onLimpar(ActionEvent event) {
        clearFields();
    }
    
    @FXML
    private void onAdicionar(ActionEvent event) {
    }
    
    @FXML
    private void onMouseClicked(MouseEvent event) {
    }
    
    private void clearFields() {
        txtDescricao.clear();
        txtDescCat.clear();
        cbbCategoria.setValue(null);
    }
    
    private void setInputON() {
        btnExcluir.setDisable(false);
        btnLimpar.setDisable(false);
        btnSalvar.setDisable(false);
        txtDescricao.setDisable(false);
        txtDescCat.setDisable(false);
        cbbCategoria.setDisable(false);
        flagButtons = true;
    }
    
    private void setInputOff() {
        btnExcluir.setDisable(true);
        btnLimpar.setDisable(true);
        btnSalvar.setDisable(true);
        txtDescCat.setDisable(true);
        txtDescricao.setDisable(true);
        cbbCategoria.setDisable(true);
        flagButtons = false;
    }
    
    private void setUptableView() {
        tbcDescricaoGrupo.setCellValueFactory(new PropertyValueFactory<>("descricao"));
        tbcCategoriaGrupo.setCellValueFactory(new PropertyValueFactory<>("categoria"));
        tbvGrupos.getColumns().setAll(tbcDescricaoGrupo, tbcCategoriaGrupo);
    }

    private void loadtbv() {
        tbvGrupos.setItems(controller.getLista());
    }
    
    private void loadCbbCategoria() {
        cbbCategoria.setItems(controller.getListaCategria());
    }
}
