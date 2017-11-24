/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashf.controller.funcionario;

import com.cashf.model.cidade.Cidade;
import com.cashf.model.funcionario.Funcionario;
import com.cashf.model.pessoa.Sexo;
import com.cashf.model.telefone.Operadora;
import com.cashf.model.telefone.Telefone;
import com.cashf.model.usuario.UNivel;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import controller.GenericController;
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
}
