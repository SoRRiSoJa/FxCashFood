/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashf.controller.funcionario;

import com.cashf.model.cidade.Cidade;
import com.cashf.model.pessoa.Sexo;
import com.cashf.model.telefone.Operadora;
import com.cashf.model.telefone.Telefone;
import com.cashf.model.usuario.UNivel;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.math.BigDecimal;
import java.net.URL;
import java.time.LocalDate;
import java.util.Arrays;
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
public class GerenciarFuncionariosFXMLController implements Initializable {

    @FXML
    private JFXTextField txtNome;
    @FXML
    private JFXComboBox<Sexo> cbbSexo;
    @FXML
    private JFXDatePicker dtpDataNas;
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
    private JFXTextField txtRg;
    @FXML
    private JFXTextField txtCpf;
    @FXML
    private Pane panePhone;
    @FXML
    private JFXComboBox<Operadora> cbbOperadora;
    @FXML
    private JFXTextField txtDdd;
    @FXML
    private JFXTextField txtNumeroTelefone;
    @FXML
    private JFXButton btnAdicionar;
    @FXML
    private TableView<Telefone> tbvTelefone;
    @FXML
    private TableColumn<Telefone, String> tbcDdd;
    @FXML
    private TableColumn<Telefone, String> tbcTelefone;
    @FXML
    private TableColumn btnDeletar;
    @FXML
    private JFXButton btnSalvar;
    @FXML
    private JFXButton btnNovo;
    @FXML
    private JFXButton btnExcluir;
    @FXML
    private JFXButton btnLimpar;
    @FXML
    private JFXComboBox<?> cbbFunTipo;
    @FXML
    private JFXDatePicker dtpDataAdm;
    @FXML
    private JFXDatePicker dtpDataDem;
    @FXML
    private JFXTextField txtCtps;
    @FXML
    private JFXTextField txtSalarioI;
    @FXML
    private JFXTextField txtsalarioF;
    @FXML
    private JFXTextField txtValeT;
    @FXML
    private JFXTextField txtValeR;
    @FXML
    private JFXTextField txtLogin;
    @FXML
    private JFXPasswordField txtSenha;
    @FXML
    private JFXComboBox<UNivel> ccbNIvel;
    //-----------------------------------
    private String nome;
    private String endereco;
    private String complemento;
    private Integer numero;
    private String cep;
    private String bairro;
    private String email;
    private String rg;
    private String cpf;
    private LocalDate dataNas;
    //---
    private String ctps;
    private LocalDate dataAdmi;
    private LocalDate dataDemi;
    private BigDecimal salIni;
    private BigDecimal vrDia;
    private BigDecimal vtDia;
    private BigDecimal salAtual;
    //---
    private String telefone;
    private String ddd;
    //---
    private String login;
    private String senha;
    //---
    private String erros;
    private boolean flagButtons;
    FuncionarioController controller = new FuncionarioController();

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
    private void onKeyReleasedRG(KeyEvent event) {
    }

    @FXML
    private void onKeyReleasedCpf(KeyEvent event) {
    }

    @FXML
    private void onAdicionar(ActionEvent event) {
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
    private void onKeyReleasedLogin(KeyEvent event) {
    }

    private void loadCbbOperadora() {
        cbbOperadora.getItems().addAll(Arrays.asList(Operadora.values()));
    }

    private void loadCbbUsuNivel() {
        //cbb.getItems().addAll(Arrays.asList(UNivel.values()));
    }

    private void clearFields() {
        txtNome.clear();
        cbbSexo.setValue(null);
        dtpDataNas.setValue(null);
        txtEndereco.clear();
        txtNumero.clear();
        txtComplemento.clear();
        txtCep.clear();
        txtBairro.clear();
        cbbCidade.setValue(null);
        txtEmail.clear();
        txtRg.clear();
        txtCpf.clear();
        cbbOperadora.setValue(null);
        txtDdd.clear();
        txtNumeroTelefone.clear();
        cbbFunTipo.setValue(null);
        dtpDataAdm.setValue(null);
        dtpDataDem.setValue(null);
        txtCtps.clear();
        txtSalarioI.clear();
        txtsalarioF.clear();
        txtValeT.clear();
        txtValeR.clear();
        txtLogin.clear();
        txtSenha.clear();
        ccbNIvel.setValue(null);
        cbbCidade.setValue(null);
        cbbOperadora.setValue(null);
    }

    private void setInputON() {
        txtNome.setDisable(false);
        cbbSexo.setDisable(true);
        dtpDataNas.setDisable(true);
        txtEndereco.setDisable(false);
        txtNumero.setDisable(false);
        txtComplemento.setDisable(false);
        txtCep.setDisable(false);
        txtBairro.setDisable(false);
        cbbCidade.setValue(null);
        txtEmail.setDisable(false);
        txtRg.setDisable(false);
        txtCpf.setDisable(false);
        cbbOperadora.setDisable(true);
        txtDdd.setDisable(false);
        txtNumeroTelefone.setDisable(false);
        cbbFunTipo.setDisable(true);
        dtpDataAdm.setDisable(true);
        dtpDataDem.setDisable(true);
        txtCtps.setDisable(false);
        txtSalarioI.setDisable(false);
        txtsalarioF.setDisable(false);
        txtValeT.setDisable(false);
        txtValeR.setDisable(false);
        txtLogin.setDisable(false);
        txtSenha.setDisable(false);
        ccbNIvel.setDisable(true);
        cbbCidade.setDisable(true);
        cbbOperadora.setDisable(true);
    }

    private void setInputOFF() {
        txtNome.setDisable(true);
        cbbSexo.setDisable(true);
        dtpDataNas.setDisable(true);
        txtEndereco.setDisable(true);
        txtNumero.setDisable(true);
        txtComplemento.setDisable(true);
        txtCep.setDisable(true);
        txtBairro.setDisable(true);
        cbbCidade.setDisable(true);
        txtEmail.setDisable(true);
        txtRg.setDisable(true);
        txtCpf.setDisable(true);
        cbbOperadora.setDisable(true);
        txtDdd.setDisable(true);
        txtNumeroTelefone.setDisable(true);
        cbbFunTipo.setDisable(true);
        dtpDataAdm.setDisable(true);
        dtpDataDem.setDisable(true);
        txtCtps.setDisable(true);
        txtSalarioI.setDisable(true);
        txtsalarioF.setDisable(true);
        txtValeT.setDisable(true);
        txtValeR.setDisable(true);
        txtLogin.setDisable(true);
        txtSenha.setDisable(true);
        ccbNIvel.setDisable(true);
        cbbCidade.setDisable(true);
        cbbOperadora.setDisable(true);
    }

    private void getData() {
        
   
   
     
   
    //---
        nome=txtNome.getText();
        dtpDataNas.setValue(null);
        endereco=txtEndereco.getText();
        txtNumero.getText();
        complemento=txtComplemento.getText();
        cep=txtCep.getText();
        bairro=txtBairro.getText();
        email=txtEmail.getText();
        rg=txtRg.getText();
        cpf=txtCpf.getText();
        ddd=txtDdd.getText();
        txtNumeroTelefone.getText();
        cbbFunTipo.getSelectionModel().getSelectedItem();
        dtpDataAdm.setValue(null);
        dtpDataDem.setValue(null);
        ctps=txtCtps.getText();
        
        txtSalarioI.getText();
        txtsalarioF.getText();
        txtValeT.getText();
        txtValeR.getText();
        login=txtLogin.getText();
        senha=txtSenha.getText();
        
        controller.setOperadora(cbbOperadora.getSelectionModel().getSelectedItem());
        controller.setSexo(cbbSexo.getSelectionModel().getSelectedItem());
        controller.setCidade(cbbCidade.getSelectionModel().getSelectedItem());
        controller.setNivel(ccbNIvel.getSelectionModel().getSelectedItem());
        controller.setCidade(cbbCidade.getSelectionModel().getSelectedItem());
        controller.setOperadora(cbbOperadora.getSelectionModel().getSelectedItem());
    }
}
