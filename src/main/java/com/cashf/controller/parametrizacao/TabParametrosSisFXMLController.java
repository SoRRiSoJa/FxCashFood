/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashf.controller.parametrizacao;

import com.cashf.controller.fornecedor.FornecedorController;
import com.cashf.model.cidade.Cidade;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import controller.GenericViewController;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import util.TextFieldFormatter;

/**
 * FXML Controller class
 *
 * @author joao
 */
public class TabParametrosSisFXMLController implements GenericViewController, Initializable {

    @FXML
    private JFXDatePicker dtpDataCad;
    @FXML
    private JFXTextField txtRazao;
    @FXML
    private JFXTextField txtNome;
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
    private JFXButton btnSalvar;
    @FXML
    private JFXButton btnNovo;
    @FXML
    private JFXButton btnExcluir;
    @FXML
    private JFXButton btnLimpar;
    @FXML
    private JFXTextField txtCnpj;
    @FXML
    private JFXTextField txtInscrEst;
    @FXML
    private JFXTextField txtLogin;
    @FXML
    private JFXPasswordField txtSenha;
    @FXML
    private JFXTextField txtDdd;
    @FXML
    private JFXTextField txtTelefone;
    @FXML
    private JFXPasswordField txtConfirmaSenha;
    @FXML
    private ImageView imgLogo;
    @FXML
    private JFXButton btnAddLogo;
    //--
    //--------------------------------
    private String erros;
    private boolean flagButtons;
    private long idParametro = 0;
    private String cnpj;
    private String nomefantasia;
    private String razaoSocial;
    private String endereco;
    private String complemento;
    private Integer numero;
    private String cep;
    private String bairro;
    private String email;
    private String Observacao;
    private String inscrEst;
    //---
    private String telefone;
    private static JFXDatePicker _dtpDataCad;
    private static JFXTextField _txtRazao;
    private static JFXTextField _txtNome;
    private static JFXTextField _txtEndereco;
    private static JFXTextField _txtNumero;
    private static JFXTextField _txtComplemento;
    private static JFXTextField _txtCep;
    private static JFXTextField _txtBairro;
    private static JFXComboBox<Cidade> _cbbCidade;
    private static JFXTextField _txtEmail;
    private static JFXButton _btnSalvar;
    private static JFXButton _btnNovo;
    private static JFXButton _btnExcluir;
    private static JFXButton _btnLimpar;
    private static JFXTextField _txtCnpj;
    private static JFXTextField _txtInscrEst;
    private static JFXTextField _txtTelefone;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        _dtpDataCad = dtpDataCad;
        _txtRazao = txtRazao;
        _txtNome = txtNome;
        _txtEndereco = txtEndereco;
        _txtNumero = txtNumero;
        _txtComplemento = txtComplemento;
        _txtCep = txtCep;
        _txtBairro = txtBairro;
        _cbbCidade = cbbCidade;
        _txtEmail = txtEmail;
        _btnSalvar = btnSalvar;
        _btnNovo = btnNovo;
        _btnExcluir = btnExcluir;
        _btnLimpar = btnLimpar;
        _txtCnpj = txtCnpj;
        _txtInscrEst = txtInscrEst;
        _txtTelefone = txtTelefone;
        setInputOff();
        loadCbbCidade();
        _dtpDataCad.setValue(LocalDate.now());
        _dtpDataCad.setDisable(true);
    }

    @FXML
    private void onKeyReleasedCep(KeyEvent event) {
        TextFieldFormatter tff = new TextFieldFormatter();
        tff.setMask("#####-###");
        tff.setCaracteresValidos("0123456789");
        tff.setTf(txtCep);
        tff.formatter();
    }

    @FXML
    private void onSelectCidade(ActionEvent event) {
        ParametrosController.getInstance().setCidade(cbbCidade.getSelectionModel().getSelectedItem());
    }

    @FXML
    private void onSalvar(ActionEvent event) {
    }

    @FXML
    private void onNovo(ActionEvent event) {
        setInputOn();
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
    private void onKeyReleasedCnpj(KeyEvent event) {
        TextFieldFormatter tff = new TextFieldFormatter();
        tff.setMask("##.###.###/####-##");
        tff.setCaracteresValidos("0123456789");
        tff.setTf(txtCnpj);
        tff.formatter();
    }

    @FXML
    private void onKeyReleasedLogin(KeyEvent event) {
    }

    @FXML
    private void onKeyreleasedDdd(KeyEvent event) {
    }

    @FXML
    private void onKeyreleasedTelefone(KeyEvent event) {
    }

    @Override
    public void clearFields() {
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
        cbbCidade.setValue(null);
    }

    @Override
    public void setInputOff() {
        btnExcluir.setDisable(true);
        btnLimpar.setDisable(true);
        btnSalvar.setDisable(true);
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
        cbbCidade.setDisable(true);
        flagButtons = false;
    }

    @Override
    public void setInputOn() {
        btnExcluir.setDisable(false);
        btnLimpar.setDisable(false);
        btnSalvar.setDisable(false);
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
        cbbCidade.setDisable(false);
        flagButtons = true;
    }

    @Override
    public Boolean validateFields() {
        boolean flag = true;
        if (nomefantasia == null || nomefantasia.equals("") || nomefantasia.length() < 3) {
            erros += "O nome fantasia deve conter um conteúdo válido! \n";
            flag = false;
        }
        if (razaoSocial == null || razaoSocial.equals("") || razaoSocial.length() < 3) {
            erros += "A razão social deve conter um nome válido! \n";
            flag = false;
        }
        if (endereco == null || endereco.equals("") || endereco.length() < 3) {
            erros += "O endereço deve ser preenchido corretamente! \n";
            flag = false;
        }

        if (bairro == null || bairro.equals("") || bairro.length() < 3) {
            erros += "O bairro deve ser preenchido corretamente! \n";
            flag = false;
        }
        if (cep == null || cep.equals("") || cep.length() < 3) {
            erros += "O CEP deve ser preenchido corretamente! \n";
            flag = false;
        }
        if (cnpj == null || cnpj.equals("") || cnpj.length() < 3) {
            erros += "O CNPJ deve ser preenchido corretamente! \n";
            flag = false;
        }
        if (email == null || email.equals("") || email.length() < 3) {
            erros += "O email deve ser preenchido corretamente! \n";
            flag = false;
        }
        if (inscrEst == null || inscrEst.equals("") || inscrEst.length() < 3) {
            erros += "A inscrição estadual deve ser preenchida corretamente! \n";
            flag = false;
        }

        if (cbbCidade.getSelectionModel().getSelectedItem() == null) {
            erros += "Você deve selecionar uma Cidade! \n";
            flag = false;
        }
        return flag;
    }

    @Override
    public void getData() {
        idParametro = (ParametrosController.getInstance().getParametro().getIdParametro() != 0) ? idParametro = ParametrosController.getInstance().getParametro().getIdParametro() : 0l;
        nomefantasia = txtNome.getText();
        razaoSocial = txtRazao.getText();
        endereco = txtEndereco.getText();
        complemento = txtComplemento.getText();
        numero = new Integer(txtNumero.getText());
        bairro = txtBairro.getText();
        cep = txtCep.getText();
        cnpj = txtCnpj.getText();
        email = txtEmail.getText();
        inscrEst = txtInscrEst.getText();
        ParametrosController.getInstance().setCidade(cbbCidade.getSelectionModel().getSelectedItem());
    }

    @Override
    public void loadDataToScreen() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void loadCbbCidade() {
        cbbCidade.setItems(ParametrosController.getInstance().getListaCidade());
    }

}
