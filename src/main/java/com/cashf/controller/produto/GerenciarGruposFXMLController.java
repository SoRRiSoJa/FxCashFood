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
import jdk.nashorn.internal.runtime.ListAdapter;
import util.PoupUpUtil;

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
    @FXML
    private TableColumn<?, ?> tbcDescricao1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        loadCbbCategoria();
        setUptableView();
        loadtbv();
        setInputOff();
    }

    @FXML
    private void onSalvar(ActionEvent event) {
        getData();
        if (validateFields()) {
            controller.setGrupo(idGrupo, descricao);
            if (controller.getGrupo().getIdGrupo() == 0) {
                controller.insert();
                clearFields();
                PoupUpUtil.poupUp("Grupo Cadastrado", "O Grupo foi cadastrado com sucesso.", "");
            } else {

                controller.update();
                PoupUpUtil.poupUp("Grupo Alterado", "O Grupo foi alterado com sucesso.", "");
            }
        } else {
            PoupUpUtil.accessDenied(erros);
            erros = "";
        }
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
        if (controller.getGrupo() != null) {
            controller.delete();
            PoupUpUtil.poupUp("Grupo Excluído", "O Grupo foi excluído com sucesso.", "");
        }
        btnExcluir.setDisable(true);
        clearFields();
    }

    @FXML
    private void onLimpar(ActionEvent event) {
        clearFields();
    }

    @FXML
    private void onAdicionar(ActionEvent event) {
        getDataCategoria();
        if (validateFieldsCategoria()) {
            controller.setCategoria(idCat, descricaoCategoria);
            controller.inssertCategoria();
            loadCbbCategoria();
            btnAdicionar.setDisable(true);
        } else {
            PoupUpUtil.accessDenied(erros);
            erros = "";
        }
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

    private void getData() {
        idGrupo = (controller.getGrupo().getIdGrupo() != 0) ? idGrupo = controller.getGrupo().getIdGrupo() : 0l;
        descricao = txtDescricao.getText();
        controller.setCategoria(cbbCategoria.getSelectionModel().getSelectedItem());
    }

    private void getDataCategoria() {
        idCat = (controller.getCategoria().getIdCategoria() != 0) ? idCat = controller.getCategoria().getIdCategoria() : 0l;
        descricaoCategoria = txtDescCat.getText();
    }

    private boolean validateFields() {
        boolean flag = true;
        if (descricao == null || descricao.equals("") || descricao.length() < 3) {
            erros += "A Descrição do grupo de produtos deve conter um conteúdo válido! \n";
            flag = false;
        }
        return flag;
    }

    private boolean validateFieldsCategoria() {
        boolean flag = true;
        if (descricaoCategoria == null || descricaoCategoria.equals("") || descricaoCategoria.length() < 3) {
            erros += "A Descrição da categoria do grupo de produtos deve conter um conteúdo válido! \n";
            flag = false;
        }
        return flag;
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

    @FXML
    private void onCbbCategoria(ActionEvent event) {
        if (cbbCategoria.getSelectionModel().getSelectedItem() != null) {
            controller.setCategoria(cbbCategoria.getSelectionModel().getSelectedItem());
            controller.getGrupo().setCategoria(controller.getCategoria());
        }
    }
}
