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
import util.PoupUpUtil;

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
    private long IdFunc;
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
        setInputOFF();
        loadCbbOperadora();
        loadCbbCidade();
        loadCbbSexo();
        loadCbbUsuNivel();
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
        getDataTelefone();
        if (validateTeleofne()) {
            controller.setTelefone(0l, ddd, telefone);
            controller.inserTelefone();
        } else {
            PoupUpUtil.accessDenied(erros);
            erros = "";
        }
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
    private void onKeyReleasedLogin(KeyEvent event) {
    }

    private void loadCbbOperadora() {
        cbbOperadora.getItems().addAll(Arrays.asList(Operadora.values()));
    }

    private void loadCbbCidade() {
        cbbCidade.getItems().addAll(controller.getListaCidade());
    }

    private void loadCbbUsuNivel() {
        ccbNIvel.getItems().addAll(Arrays.asList(UNivel.values()));
    }

    private void loadCbbSexo() {
        cbbSexo.getItems().addAll(Arrays.asList(Sexo.values()));
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
        btnExcluir.setDisable(false);
        btnLimpar.setDisable(false);
        btnSalvar.setDisable(false);

        txtNome.setDisable(false);
        cbbSexo.setDisable(false);
        dtpDataNas.setDisable(false);
        txtEndereco.setDisable(false);
        txtNumero.setDisable(false);
        txtComplemento.setDisable(false);
        txtCep.setDisable(false);
        txtBairro.setDisable(false);
        cbbCidade.setDisable(false);
        txtEmail.setDisable(false);
        txtRg.setDisable(false);
        txtCpf.setDisable(false);
        cbbOperadora.setDisable(false);
        txtDdd.setDisable(false);
        txtNumeroTelefone.setDisable(false);
        cbbFunTipo.setDisable(false);
        dtpDataAdm.setDisable(false);
        dtpDataDem.setDisable(false);
        txtCtps.setDisable(false);
        txtSalarioI.setDisable(false);
        txtsalarioF.setDisable(false);
        txtValeT.setDisable(false);
        txtValeR.setDisable(false);
        txtLogin.setDisable(false);
        txtSenha.setDisable(false);
        ccbNIvel.setDisable(false);
        cbbCidade.setDisable(false);
        cbbOperadora.setDisable(false);
        flagButtons = true;
    }

    private void setInputOFF() {
        btnExcluir.setDisable(true);
        btnLimpar.setDisable(true);
        btnSalvar.setDisable(true);
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
        flagButtons = false;
    }

    private void getDataTelefone() {
        telefone = txtNumeroTelefone.getText();
        ddd = txtDdd.getText();
        controller.setOperadora(cbbOperadora.getSelectionModel().getSelectedItem());
    }

    private void getData() {
        IdFunc = (controller.getFuncionario().getIdPessoa() != 0l) ? controller.getFuncionario().getIdPessoa() : 0l;
        nome = txtNome.getText();
        dataNas = dtpDataNas.getValue();
        endereco = txtEndereco.getText();
        txtNumero.getText();
        complemento = txtComplemento.getText();
        cep = txtCep.getText();
        bairro = txtBairro.getText();
        email = txtEmail.getText();
        rg = txtRg.getText();
        cpf = txtCpf.getText();
        dataAdmi = dtpDataAdm.getValue();
        dataDemi = dtpDataDem.getValue();
        ctps = txtCtps.getText();
        salIni = new BigDecimal(txtSalarioI.getText());
        salAtual = new BigDecimal(txtsalarioF.getText());
        vtDia = new BigDecimal(txtValeT.getText());
        vrDia = new BigDecimal(txtValeR.getText());
        cbbFunTipo.getSelectionModel().getSelectedItem();
        controller.setSexo(cbbSexo.getSelectionModel().getSelectedItem());
        controller.setCidade(cbbCidade.getSelectionModel().getSelectedItem());
        controller.setCidade(cbbCidade.getSelectionModel().getSelectedItem());
        controller.setOperadora(cbbOperadora.getSelectionModel().getSelectedItem());
    }

    private void getDataUser() {
        login = txtLogin.getText();
        senha = txtSenha.getText();
        controller.setNivel(ccbNIvel.getSelectionModel().getSelectedItem());
    }

    private boolean validateFields() {
        boolean flag = true;
        if (nome == null || nome.equals("") || nome.length() < 3) {
            erros += "O nome deve conter um conteúdo válido! \n";
            flag = false;
        }

        if (endereco == null || endereco.equals("") || endereco.length() < 3) {
            erros += "O endereço deve ser preenchido corretamente! \n";
            flag = false;
        }
        if (cep == null || cep.equals("") || cep.length() < 3) {
            erros += "O CEP deve ser preenchido corretamente! \n";
            flag = false;
        }
        if (bairro == null || bairro.equals("") || bairro.length() < 3) {
            erros += "O bairro deve ser preenchido corretamente! \n";
            flag = false;
        }
        if (email == null || email.equals("") || email.length() < 3) {
            erros += "O email deve ser preenchido corretamente! \n";
            flag = false;
        }
        if (cpf == null || cpf.equals("") || cpf.length() < 12) {
            erros += "O CPF deve ser preenchido corretamente! \n";
            flag = false;
        }
        if (rg == null || rg.equals("") || rg.length() < 3) {
            erros += "A inscrição estadual deve ser preenchida corretamente! \n";
            flag = false;
        }

        if (cbbCidade.getSelectionModel().getSelectedItem() == null) {
            erros += "Você deve selecionar uma Cidade! \n";
            flag = false;
        }
        return flag;
    }

    private boolean validateTeleofne() {
        boolean flag = true;
        if (ddd == null || ddd.equals("") || ddd.length() < 2) {
            erros += "O DDD do telefone deve conter um número válido! \n";
            flag = false;
        }
        if (telefone == null || telefone.equals("") || telefone.length() < 3) {
            erros += "O telefone do Fornecedor deve conter um número válido! \n";
            flag = false;
        }

        if (cbbOperadora.getSelectionModel().getSelectedItem() == null) {
            erros += "Você deve selecionar uma operadora para este telefone! \n";
            flag = false;
        }
        return flag;
    }

    private boolean validateUser() {
        boolean flag = true;
        if (login == null || login.equals("") || login.length() < 3) {
            erros += "O login do usuário deve conter um conteúdo válido! \n";
            flag = false;
        }else{
            
        }
        if (senha == null || senha.equals("") || senha.length() < 4) {
            erros += "A senha deve conter 4 digitos ou mais! \n";
            flag = false;
        }

        if (ccbNIvel.getSelectionModel().getSelectedItem() == null) {
            erros += "Você deve selecionar uma nível para o usuário! \n";
            flag = false;
        }
        return flag;
    }

}
