/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashf.controller.cliente;

import com.cashf.model.cidade.Cidade;
import com.cashf.model.pessoa.Sexo;
import com.cashf.model.telefone.Operadora;
import com.cashf.model.telefone.Telefone;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import com.sun.prism.impl.Disposer;
import controller.GenericViewController;
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
public class TabClientesFXMLController implements GenericViewController, Initializable {

    @FXML
    private JFXTextField txtObservacao;
    @FXML
    private JFXComboBox<Operadora> cbbOperadora;
    @FXML
    private JFXTextField txtDdd;
    @FXML
    private JFXTextField txtNumeroTelefone;
    @FXML
    private JFXButton btnAdicionar;
    @FXML
    private TableView<Telefone> tbvTelefones;
    @FXML
    private TableColumn<Telefone, String> tbcDDD;
    @FXML
    private TableColumn<Telefone, String> tbcTelefone;
    @FXML
    private TableColumn btnDeletar;
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
    //-----------------------------------
    private long IdCli;
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
    private String telefone;
    private String ddd;
    private String erros;
    private boolean flagButtons;
    private String observacao;
    //--
    private static JFXTextField _txtObservacao;
    private static JFXComboBox<Operadora> _cbbOperadora;
    private static JFXTextField _txtDdd;
    private static JFXTextField _txtNumeroTelefone;
    private static JFXButton _btnAdicionar;
    private static TableView<Telefone> _tbvTelefones;
    private static TableColumn<Telefone, String> _tbcDDD;
    private static TableColumn<Telefone, String> _tbcTelefone;
    private static TableColumn _btnDeletar;
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
        _cbbOperadora = cbbOperadora;
        _txtDdd = txtDdd;
        _txtNumeroTelefone = txtNumeroTelefone;
        _cbbCidade = cbbCidade;
        _cbbOperadora = cbbOperadora;
        _tbvTelefones = tbvTelefones;
        _txtObservacao = txtObservacao;
        _btnExcluir=btnExcluir;
        setInputOff();
        loadCbbOperadora();
        loadCbbCidade();
        loadCbbSexo();
        setUptableViewTelefone();
        loadTbvTelefone();
    }

    @FXML
    private void onAdicionar(ActionEvent event) {
        getDataTelefone();
        if (validateTeleofne()) {
            ClienteController.getInstance().setTelefone(0l, ddd, telefone);
            ClienteController.getInstance().inserTelefone();
            loadTbvTelefone();
        } else {
            PoupUpUtil.accessDenied(erros);
            erros = "";
        }
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
        if (cbbCidade.getSelectionModel().getSelectedItem() != null) {
            ClienteController.getInstance().setCidade(cbbCidade.getSelectionModel().getSelectedItem());
        }

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
        if (validateFields()) {
            ClienteController.getInstance().setCliente(IdCli, nome, ClienteController.getInstance().getSexo(), dataNas, endereco, bairro, numero, complemento, cep, ClienteController.getInstance().getCidade(), cpf, rg, email, flagButtons, ClienteController.getInstance().getListaTelefone(), observacao);
            if (ClienteController.getInstance().getCliente().getIdPessoa() == 0l) {
                //insert
                ClienteController.getInstance().insert();
                PoupUpUtil.poupUp("Cliente Cadastrado", "O Cliente foi cadastrado com sucesso.", "");

            } else {
                //update
                ClienteController.getInstance().update();
                PoupUpUtil.poupUp("Cliente Alterado", "O Cliente foi alterado com sucesso.", "");
            }
            ClienteController.getInstance().flushObject();
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
        if (ClienteController.getInstance().getCliente().getIdPessoa() != 0l) {
            Notifications notificationBuilder;
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Cofirmar Excluir Cliente!");
            alert.setHeaderText("Deseja realmente Excluir?");
            alert.setContentText("Nome:(" + ClienteController.getInstance().getCliente().getNome() + ")");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                ClienteController.getInstance().delete();                
                TabListaClientesFXMLController.loadTbvCli();
                
            // ... user chose OK
                
                notificationBuilder = Notifications.create().title("Cliente excluído!").
                        text("Cliente Excluido com sucesso.").
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
        txtObservacao.clear();
        cbbOperadora.setValue(null);
        txtDdd.clear();
        txtNumeroTelefone.clear();
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

    @Override
    public void getData() {
        IdCli = (ClienteController.getInstance().getCliente().getIdPessoa() != 0l) ? ClienteController.getInstance().getCliente().getIdPessoa() : 0l;
        nome = txtNome.getText();
        dataNas = dtpDataNas.getValue();
        endereco = txtEndereco.getText();
        try {
            numero = Integer.parseInt(txtNumero.getText());
        } catch (Exception ex) {

        }
        complemento = txtComplemento.getText();
        cep = txtCep.getText();
        bairro = txtBairro.getText();
        email = txtEmail.getText();
        rg = txtRg.getText();
        cpf = txtCpf.getText();
        observacao = txtObservacao.getText();
        ClienteController.getInstance().setSexo(cbbSexo.getSelectionModel().getSelectedItem());
        ClienteController.getInstance().setCidade(cbbCidade.getSelectionModel().getSelectedItem());
        ClienteController.getInstance().setOperadora(cbbOperadora.getSelectionModel().getSelectedItem());
    }

    private void getDataTelefone() {
        telefone = txtNumeroTelefone.getText();
        ddd = txtDdd.getText();
        ClienteController.getInstance().setOperadora(cbbOperadora.getSelectionModel().getSelectedItem());
    }

    @Override
    public void loadDataToScreen() {

    }

    public static void LDTS() {
        _txtNome.setText(ClienteController.getInstance().getCliente().getNome());
        _cbbSexo.setValue(ClienteController.getInstance().getCliente().getSexo());
        _dtpDataNas.setValue(ClienteController.getInstance().getCliente().getDataNas());
        _txtEndereco.setText(ClienteController.getInstance().getCliente().getEndereco());
        _txtNumero.setText(ClienteController.getInstance().getCliente().getNumero() + "");
        _txtComplemento.setText(ClienteController.getInstance().getCliente().getComplemento());
        _txtCep.setText(ClienteController.getInstance().getCliente().getCep());
        _txtBairro.setText(ClienteController.getInstance().getCliente().getBairro());
        _cbbCidade.setValue(ClienteController.getInstance().getCliente().getCidade());
        _txtEmail.setText(ClienteController.getInstance().getCliente().getEmail());
        _txtRg.setText(ClienteController.getInstance().getCliente().getRg());
        _txtCpf.setText(ClienteController.getInstance().getCliente().getCpf());
        _txtObservacao.setText(ClienteController.getInstance().getCliente().getObservacao());
    }

    public static void LDTSFone() {
        _tbvTelefones.setItems(ClienteController.getInstance().getListaTelefone());
    }

    private void loadTbvTelefone() {
        tbvTelefones.setItems(ClienteController.getInstance().getListaTelefone());
    }

    private void loadCbbSexo() {
        cbbSexo.getItems().addAll(Arrays.asList(Sexo.values()));
    }

    private void loadCbbCidade() {
        cbbCidade.getItems().addAll(ClienteController.getInstance().getListaCidade());
    }

    private void loadCbbOperadora() {
        cbbOperadora.getItems().addAll(Arrays.asList(Operadora.values()));
    }

    private void setUptableViewTelefone() {
        tbcDDD.setCellValueFactory(new PropertyValueFactory<>("ddd"));
        tbcTelefone.setCellValueFactory(new PropertyValueFactory<>("numero"));
        btnDeletar.setCellFactory(
                new Callback<TableColumn<Disposer.Record, Boolean>, TableCell<Disposer.Record, Boolean>>() {
            @Override
            public TableCell<Disposer.Record, Boolean> call(TableColumn<Disposer.Record, Boolean> p) {
                return new ButtonCellDelete();
            }
        });
        tbvTelefones.getColumns().setAll(tbcDDD, tbcTelefone, btnDeletar);
    }

    @FXML
    private void onKeyReleasedDDD(KeyEvent event) {
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
                        ClienteController.getInstance().setTelefone(currentPerson);
                        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                        alert.setTitle("Cofirmar Excluir Telefone!");
                        alert.setHeaderText("Deseja realmente Excluir?");
                        alert.setContentText("Numero:(" + currentPerson.getDdd() + ") - " + currentPerson.getNumero() + "");
                        Optional<ButtonType> result = alert.showAndWait();
                        if (result.get() == ButtonType.OK) {
                            // ... user chose OK
                            ClienteController.getInstance().deleteTelefone();
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

    public static void setBtnEX(Boolean sta) {
        _btnExcluir.setDisable(sta);
    }
}
