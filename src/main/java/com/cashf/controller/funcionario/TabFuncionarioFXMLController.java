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
import com.sun.prism.impl.Disposer;
import controller.GenericViewController;
import java.math.BigDecimal;
import java.net.URL;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.util.Callback;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;
import util.PoupUpUtil;
import util.TextFieldFormatter;

/**
 * FXML Controller class
 *
 * @author joao
 */
public class TabFuncionarioFXMLController implements GenericViewController, Initializable {

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
    private JFXButton btnSalvar;
    @FXML
    private JFXButton btnNovo;
    @FXML
    private JFXButton btnExcluir;
    @FXML
    private JFXButton btnLimpar;
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
    private long IdUsu;
    private String login;
    private String senha;
    //---
    private String erros;
    private boolean flagButtons;
    //--
    private static JFXTextField _txtNome;
    private static JFXComboBox<Sexo> _cbbSexo;
    private static JFXDatePicker _dtpDataNas;
    private static JFXTextField _txtEndereco;
    private static JFXTextField _txtNumero;
    private static JFXTextField _txtComplemento;
    private static JFXTextField _txtCep;
    private static JFXTextField _txtBairro;
    private static JFXComboBox<Cidade> _cbbCidade;
    private static JFXTextField _txtEmail;
    private static JFXTextField _txtRg;
    private static JFXTextField _txtCpf;
    private static JFXButton _btnSalvar;
    private static JFXButton _btnNovo;
    private static JFXButton _btnExcluir;
    private static JFXButton _btnLimpar;
    private static JFXDatePicker _dtpDataAdm;
    private static JFXDatePicker _dtpDataDem;
    private static JFXTextField _txtCtps;
    private static JFXTextField _txtSalarioI;
    private static JFXTextField _txtsalarioF;
    private static JFXTextField _txtValeT;
    private static JFXTextField _txtValeR;
    private static JFXTextField _txtLogin;
    private static JFXPasswordField _txtSenha;
    private static JFXComboBox<UNivel> _ccbNIvel;
    private static JFXComboBox<Operadora> _cbbOperadora;
    private static JFXTextField _txtDdd;
    private static JFXTextField _txtNumeroTelefone;
    private static JFXButton _btnAdicionar;
    private static TableView<Telefone> _tbvTelefone;
    private static TableColumn<Telefone, String> _tbcDdd;
    private static TableColumn<Telefone, String> _tbcTelefone;
    private static TableColumn _btnDeletar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        _txtNome = txtNome;
        _cbbSexo = cbbSexo;
        _dtpDataNas = dtpDataNas;
        _txtEndereco = txtEndereco;
        _txtNumero = txtNumero;
        _txtComplemento = txtComplemento;
        _txtCep = txtCep;
        _txtBairro = txtBairro;
        _cbbCidade = cbbCidade;
        _txtEmail = txtEmail;
        _txtRg = txtRg;
        _txtCpf = txtCpf;
        _btnSalvar = btnSalvar;
        _btnNovo = btnNovo;
        _btnExcluir = btnExcluir;
        _btnLimpar = btnLimpar;
        _dtpDataAdm = dtpDataAdm;
        _dtpDataDem = dtpDataDem;
        _txtCtps = txtCtps;
        _txtSalarioI = txtSalarioI;
        _txtsalarioF = txtsalarioF;
        _txtValeT = txtValeT;
        _txtValeR = txtValeR;
        _txtLogin = txtLogin;
        _txtSenha = txtSenha;
        ccbNIvel = ccbNIvel;
        _cbbOperadora = cbbOperadora;
        _txtDdd = txtDdd;
        _txtNumeroTelefone = txtNumeroTelefone;
        _tbvTelefone = tbvTelefone;
        _btnAdicionar = btnAdicionar;
        _tbvTelefone = tbvTelefone;
        _tbcDdd = tbcDdd;
        _tbcTelefone = tbcTelefone;
        _btnDeletar = btnDeletar;
        setInputOff();
        loadCbbOperadora();
        loadCbbCidade();
        loadCbbSexo();
        loadCbbUsuNivel();
        setUptableViewTelefone();
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
        FuncionarioController.getInstance().setCidade(cbbCidade.getSelectionModel().getSelectedItem());
    }

    @FXML
    private void onKeyReleasedRG(KeyEvent event) {
    }

    @FXML
    private void onKeyReleasedCpf(KeyEvent event) {
        TextFieldFormatter tff = new TextFieldFormatter();
        tff.setMask("###.###.###-##");
        tff.setCaracteresValidos("0123456789");
        tff.setTf(txtCpf);
        tff.formatter();
    }

    @FXML
    private void onSalvar(ActionEvent event) {
        getData();
        getDataUser();
        if (validateUser() && validateFields()) {
            FuncionarioController.getInstance().setUsuario(IdUsu, login, senha, FuncionarioController.getInstance().getNivel(), true);
            FuncionarioController.getInstance().setFuncionario(IdFunc, nome, FuncionarioController.getInstance().getSexo(), dataNas, endereco, bairro, numero, complemento, cep, FuncionarioController.getInstance().getCidade(), cpf, rg, email, FuncionarioController.getInstance().getListaTelefone(), true, ctps, salIni, salAtual, vrDia, vtDia, dataAdmi, dataDemi, FuncionarioController.getInstance().getUsuario());
            if (FuncionarioController.getInstance().getFuncionario().getIdPessoa() == 0l) {
                FuncionarioController.getInstance().inserUsuario();
                FuncionarioController.getInstance().insert();
                PoupUpUtil.poupUp("Funcionario Cadastrado", "O Funcionario foi cadastrado com sucesso.", "");
            } else {
                FuncionarioController.getInstance().updateUsuario();
                FuncionarioController.getInstance().update();
                PoupUpUtil.poupUp("Funcionario Alterado", "O Funcionario foi alterado com sucesso.", "");
            }
            FuncionarioController.getInstance().flushObject();
            loadTbvTelefone();
            clearFields();
        } else {
            PoupUpUtil.accessDenied(erros);
            erros = "";
        }

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
        if (FuncionarioController.getInstance().getFuncionario().getIdPessoa() != 0) {
            Notifications notificationBuilder;
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Cofirmar Excluir Funcionário!");
            alert.setHeaderText("Deseja realmente Excluir?");
            alert.setContentText("Nome:(" + FuncionarioController.getInstance().getFuncionario().getNome() + ")");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                FuncionarioController.getInstance().delete();
                // ... user chose OK
                FuncionarioController.getInstance().deleteTelefone();
                notificationBuilder = Notifications.create().title("Funcionário excluído!").
                        text("Funcionário Excluido com sucesso.").
                        hideAfter(Duration.seconds(2)).
                        position(Pos.TOP_RIGHT).
                        darkStyle();
                notificationBuilder.showInformation();
            } else {
                alert.close();
            }
        }
    }

    @FXML
    private void onLimpar(ActionEvent event) {
        clearFields();
    }

    @FXML
    private void onKeyReleasedLogin(KeyEvent event) {
    }

    @FXML
    private void onAdicionar(ActionEvent event) {
        getDataTelefone();
        if (validateTeleofne()) {
            FuncionarioController.getInstance().setTelefone(0l, ddd, telefone);
            FuncionarioController.getInstance().inserTelefone();
            loadTbvTelefone();
        } else {
            PoupUpUtil.accessDenied(erros);
            erros = "";
        }
    }

    @Override
    public void clearFields() {
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

    @Override
    public void setInputOff() {
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

    @Override
    public void setInputOn() {
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

    @Override
    public Boolean validateFields() {
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
        if (cpf == null || cpf.equals("") || cpf.length() < 3) {
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
        } else {

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

    @Override
    public void getData() {
        IdFunc = (FuncionarioController.getInstance().getFuncionario().getIdPessoa() != 0l) ? FuncionarioController.getInstance().getFuncionario().getIdPessoa() : 0l;
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
        FuncionarioController.getInstance().setSexo(cbbSexo.getSelectionModel().getSelectedItem());
        FuncionarioController.getInstance().setCidade(cbbCidade.getSelectionModel().getSelectedItem());

        FuncionarioController.getInstance().setOperadora(cbbOperadora.getSelectionModel().getSelectedItem());
    }

    private void getDataTelefone() {
        telefone = txtNumeroTelefone.getText();
        ddd = txtDdd.getText();
        FuncionarioController.getInstance().setOperadora(cbbOperadora.getSelectionModel().getSelectedItem());
    }

    private void getDataUser() {
        IdUsu = (FuncionarioController.getInstance().getUsuario().getId() != 0l) ? FuncionarioController.getInstance().getUsuario().getId() : 0l;
        login = txtLogin.getText();
        senha = txtSenha.getText();
        FuncionarioController.getInstance().setNivel(ccbNIvel.getSelectionModel().getSelectedItem());
    }

    @Override
    public void loadDataToScreen() {

    }

    public static void LDTS() {
        _txtNome.setText(FuncionarioController.getInstance().getFuncionario().getNome());
        _cbbSexo.setValue(FuncionarioController.getInstance().getFuncionario().getSexo());
        _dtpDataNas.setValue(FuncionarioController.getInstance().getFuncionario().getDataNas());
        _txtEndereco.setText(FuncionarioController.getInstance().getFuncionario().getEndereco());
        _txtNumero.setText(FuncionarioController.getInstance().getFuncionario().getNumero() + "");
        _txtComplemento.setText(FuncionarioController.getInstance().getFuncionario().getComplemento());
        _txtCep.setText(FuncionarioController.getInstance().getFuncionario().getCep());
        _txtBairro.setText(FuncionarioController.getInstance().getFuncionario().getBairro());
        _cbbCidade.setValue(FuncionarioController.getInstance().getFuncionario().getCidade());
        _txtEmail.setText(FuncionarioController.getInstance().getFuncionario().getEmail());
        _txtRg.setText(FuncionarioController.getInstance().getFuncionario().getRg());
        _txtCpf.setText(FuncionarioController.getInstance().getFuncionario().getCpf());
        _btnExcluir.setDisable(false);
        ///------
        _dtpDataAdm.setValue(FuncionarioController.getInstance().getFuncionario().getDataAdimissao());
        _dtpDataDem.setValue(FuncionarioController.getInstance().getFuncionario().getDataDemissao());
        _txtCtps.setText(FuncionarioController.getInstance().getFuncionario().getCtps());
        _txtSalarioI.setText(FuncionarioController.getInstance().getFuncionario().getSalarioIncial().toString());
        _txtsalarioF.setText(FuncionarioController.getInstance().getFuncionario().getSalarioAtual().toString());
        _txtValeT.setText(FuncionarioController.getInstance().getFuncionario().getVtDia().toString());
        _txtValeR.setText(FuncionarioController.getInstance().getFuncionario().getVrDia().toString());
        _txtLogin.setText(FuncionarioController.getInstance().getFuncionario().getUsuario().getLogin());
        //_txtSenha.setText(FuncionarioController.getInstance().getFuncionario();
        _ccbNIvel.setValue(FuncionarioController.getInstance().getFuncionario().getUsuario().getNivel());

    }

    private void setUptableViewTelefone() {
        tbcDdd.setCellValueFactory(new PropertyValueFactory<>("ddd"));
        tbcTelefone.setCellValueFactory(new PropertyValueFactory<>("numero"));
        btnDeletar.setCellFactory(
                new Callback<TableColumn<Disposer.Record, Boolean>, TableCell<Disposer.Record, Boolean>>() {
            @Override
            public TableCell<Disposer.Record, Boolean> call(TableColumn<Disposer.Record, Boolean> p) {
                return new ButtonCellDelete();
            }
        });
        tbvTelefone.getColumns().setAll(tbcDdd, tbcTelefone, btnDeletar);
    }

    public static void LDTSPhone() {
        _tbvTelefone.setItems(FuncionarioController.getInstance().getListaTelefone());
    }

    private void loadCbbOperadora() {
        cbbOperadora.getItems().addAll(Arrays.asList(Operadora.values()));
    }

    private void loadCbbCidade() {
        cbbCidade.getItems().addAll(FuncionarioController.getInstance().getListaCidade());
    }

    private void loadCbbUsuNivel() {
        ccbNIvel.getItems().addAll(Arrays.asList(UNivel.values()));
    }

    private void loadCbbSexo() {
        cbbSexo.getItems().addAll(Arrays.asList(Sexo.values()));
    }

    private void loadTbvTelefone() {
        tbvTelefone.setItems(FuncionarioController.getInstance().getListaTelefone());
    }

    @FXML
    private void onKeyreleasedCtps(KeyEvent event) {
    }

    @FXML
    private void onKeyreleasedSalIni(KeyEvent event) {
    }

    @FXML
    private void onKeyreleasedSalAtual(KeyEvent event) {
    }

    @FXML
    private void onKeyreleasedValeTrans(KeyEvent event) {
    }

    @FXML
    private void onKeyreleasedValeRef(KeyEvent event) {
    }

    @FXML
    private void onKeyreleasedDdd(KeyEvent event) {
        TextFieldFormatter tff = new TextFieldFormatter();
        tff.setMask("(##)");
        tff.setCaracteresValidos("0123456789");
        tff.setTf(txtDdd);
        tff.formatter();
    }

    @FXML
    private void onKeyreleasedTelefone(KeyEvent event) {
        TextFieldFormatter tff = new TextFieldFormatter();
        tff.setMask("#####-#####");
        tff.setCaracteresValidos("0123456789");
        tff.setTf(txtNumeroTelefone);
        tff.formatter();
    }

    public class ButtonCellDelete extends TableCell<Disposer.Record, Boolean> {

        Image img;
        ImageView imgv;
        JFXButton cellButton = new JFXButton("Desativar");
        Notifications notificationBuilder;

        public ButtonCellDelete() {
            this.img = new Image("Imagens/ic_delete_forever_black_24dp_1x.png");
            this.imgv = new ImageView(img);
            cellButton.setGraphic(imgv);
            cellButton.setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
            cellButton.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent t) {
                    // get Selected Item
                    Telefone currentPerson = (Telefone) ButtonCellDelete.this.getTableView().getItems().get(ButtonCellDelete.this.getIndex());
                    //remove selected item from the table list
                    if (currentPerson != null) {
                        FuncionarioController.getInstance().setTelefone(currentPerson);
                        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                        alert.setTitle("Cofirmar Excluir Telefone!");
                        alert.setHeaderText("Deseja realmente Excluir?");
                        alert.setContentText("Numero:(" + currentPerson.getDdd() + ") - " + currentPerson.getNumero() + "");
                        Optional<ButtonType> result = alert.showAndWait();
                        if (result.get() == ButtonType.OK) {
                            // ... user chose OK
                            FuncionarioController.getInstance().deleteTelefone();
                            notificationBuilder = Notifications.create().title("Telefone excluído!").
                                    text("telefone Excluido com sucesso.").
                                    hideAfter(Duration.seconds(2)).
                                    position(Pos.TOP_RIGHT).
                                    darkStyle();
                            notificationBuilder.showInformation();
                        } else {
                            alert.close();
                        }
                    } else {
                        notificationBuilder = Notifications.create().title("Nenhum item selecionado!").
                                text("Você deve selecionar Uma conta para Cancelar.").
                                hideAfter(Duration.seconds(2)).
                                position(Pos.TOP_RIGHT).
                                darkStyle();
                        notificationBuilder.showConfirm();
                    }

                }
            });
        }

        @Override
        protected void updateItem(Boolean t, boolean empty) {
            super.updateItem(t, empty);
            if (!empty) {
                setGraphic(cellButton);
            } else {
                setGraphic(null);
            }
        }
    }

}
