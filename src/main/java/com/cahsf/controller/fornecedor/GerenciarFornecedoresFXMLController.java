/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cahsf.controller.fornecedor;

import com.cashf.model.cidade.Cidade;
import com.cashf.model.fornecedor.Fornecedor;
import com.cashf.model.telefone.Operadora;
import com.cashf.model.telefone.Telefone;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author joao
 */
public class GerenciarFornecedoresFXMLController implements Initializable {

    @FXML
    private JFXTextField txtCnpj;
    @FXML
    private JFXTextField txtInscrEst;
    @FXML
    private JFXTextField txtObs;
    @FXML
    private TableView<Fornecedor> tbvFornecedores;
    @FXML
    private TableColumn<Fornecedor, String> tbcNome;
    @FXML
    private TableColumn<Fornecedor, String> tbcEmail;
    @FXML
    private JFXTextField txtNome;
    @FXML
    private JFXDatePicker dtpDataCad;
    @FXML
    private JFXTextField txtEndereco;
    @FXML
    private JFXTextField txtNumero;
    @FXML
    private JFXTextField txtComplemento;
    @FXML
    private JFXTextField txtCep;
    @FXML
    private JFXTextField txtBairro;
    @FXML
    private JFXComboBox<Cidade> cbbCidade;
    @FXML
    private JFXTextField txtEmail;
    @FXML
    private Pane panePhone;
    @FXML
    private JFXComboBox<Operadora> cbbOperadora;
    @FXML
    private JFXTextField txtDdd;
    @FXML
    private JFXTextField txtTelefone;
    @FXML
    private JFXButton btnAdicionar;
    @FXML
    private TableView<Telefone> tbvTelefone;
    @FXML
    private TableColumn<Telefone, String> tbcDdd;
    @FXML
    private TableColumn<Telefone, String> tbcNumero;
    @FXML
    private TableColumn<?, ?> btnDeletar;
    @FXML
    private JFXTextField txtRazao;
    @FXML
    private JFXButton btnSalvar;
    @FXML
    private JFXButton btnNovo;
    @FXML
    private JFXButton btnExcluir;
    @FXML
    private JFXButton btnLimpar;
    //--------------------------------
    private FornecedorController controller = new FornecedorController();
    private String erros;
    private boolean flagButtons;
    private long idFornecedor = 0;
    private String cnpj;
    private String nomefantasia;
    private String razaoSocial;
    private String endereco;
    private String complemento;
    private int numero;
    private String cep;
    private String bairro;
    private String email;
    private String Observacao;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void onKeyReleasedCep(KeyEvent event) {
    }

    @FXML
    private void onSelectCidade(ActionEvent event) {
    }

    @FXML
    private void onAdicionar(ActionEvent event) {
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

    private void clearFields() {
        txtNome.clear();
        txtRazao.clear();
        txtEndereco.clear();
        txtComplemento.clear();
        txtNumero.clear();
        txtBairro.clear();
        txtCep.clear();
        txtCnpj.clear();
        txtDdd.clear();
        txtTelefone.clear();
        txtEmail.clear();
        txtInscrEst.clear();
        txtObs.clear();
        cbbCidade.setValue(null);
        cbbOperadora.setValue(null);
    }

    private void setInputON() {
        txtNome.setDisable(false);
        txtRazao.setDisable(false);
        txtEndereco.setDisable(false);
        txtComplemento.setDisable(false);
        txtNumero.setDisable(false);
        txtBairro.setDisable(false);
        txtCep.setDisable(false);
        txtCnpj.setDisable(false);
        txtDdd.setDisable(false);
        txtTelefone.setDisable(false);
        txtEmail.setDisable(false);
        txtInscrEst.setDisable(false);
        txtObs.setDisable(false);
        cbbCidade.setDisable(false);
        cbbOperadora.setDisable(false);
        flagButtons = true;
    }

    private void setInputOff() {
        txtNome.setDisable(true);
        txtRazao.setDisable(true);
        txtEndereco.setDisable(true);
        txtComplemento.setDisable(true);
        txtNumero.setDisable(true);
        txtBairro.setDisable(true);
        txtCep.setDisable(true);
        txtCnpj.setDisable(true);
        txtDdd.setDisable(true);
        txtTelefone.setDisable(true);
        txtEmail.setDisable(true);
        txtInscrEst.setDisable(true);
        txtObs.setDisable(true);
        cbbCidade.setDisable(true);
        cbbOperadora.setDisable(true);
        flagButtons = false;
    }

}
