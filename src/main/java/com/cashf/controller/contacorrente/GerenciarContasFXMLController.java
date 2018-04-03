/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashf.controller.contacorrente;

import com.cashf.model.banco.Banco;
import com.cashf.model.contacorrente.ContaCorrente;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
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
import util.PoupUpUtil;

/**
 * FXML Controller class
 *
 * @author joao
 */
public class GerenciarContasFXMLController implements Initializable {

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
    private JFXTextField txtAgencia;
    @FXML
    private JFXTextField txtNumero;
    @FXML
    private JFXComboBox<Banco> cbbBanco;
    @FXML
    private TableView<ContaCorrente> tbvContas;
    @FXML
    private TableColumn<ContaCorrente, String> tbcDescricao;
    @FXML
    private TableColumn<ContaCorrente, String> tbcBanco;
    @FXML
    private TableColumn<ContaCorrente, String> tbcAgencia;
    @FXML
    private TableColumn<ContaCorrente, String> tbcConta;
    @FXML
    private JFXCheckBox ckbContaCaixa;
    //---------------------------------
    ContaCorrenteController controller = new ContaCorrenteController();
    private String erros;
    private boolean flagButtons;
    private boolean isCaixa=false;
    private String agencia;
    private String descricao;
    private String numero;
    private long idBanco = 0;
    private long idConta;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        loadCbbBanco();
        setInputOff();
        setUptableView();
        setUpCheckBox();
        loadTbv();
    }

    @FXML
    private void onSalvar(ActionEvent event) {
        getData();
        if (validateFields()) {
            setData();
            if (controller.getContaCorrente().getId() == 0) {
                controller.insert();
                PoupUpUtil.poupUp("Conta Corrente Cadastrada", "A conta corrente foi cadastrada com sucesso.", "");

            } else {
                controller.update();
                PoupUpUtil.poupUp("Conta Corrente Alterada", "A conta corrente foi alterada com sucesso.", "");
            }
            loadTbv();
            clearFields();
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
        if (controller.getContaCorrente() != null) {
            controller.delete();
            PoupUpUtil.poupUp("Conta Corrente Excluída", "A conta corrente foi excluída com sucesso.", "");
        }
        btnExcluir.setDisable(true);
        clearFields();
    }

    @FXML
    private void onLimpar(ActionEvent event) {
        clearFields();
    }

    @FXML
    private void onMouseClickedBanco(MouseEvent event) {
        controller.setBanco(cbbBanco.getSelectionModel().getSelectedItem());

    }

    @FXML
    private void onMouseClicked(MouseEvent event) {
        if (tbvContas.getSelectionModel().getSelectedItem() != null) {
            controller.setContaCorrente(tbvContas.getSelectionModel().getSelectedItem());
            loadDataToScreen();
            btnExcluir.setDisable(false);
        }
    }

    public void loadDataToScreen() {
        txtAgencia.setText(controller.getContaCorrente().getAgencia());
        txtDescricao.setText(controller.getContaCorrente().getDescricao());
        txtNumero.setText(controller.getContaCorrente().getContaCorrente());
        cbbBanco.setValue(controller.getContaCorrente().getBanco());
        ckbContaCaixa.selectedProperty().setValue(controller.getContaCorrente().getcCaixa());
        getData();
    }

    private void clearFields() {
        txtAgencia.clear();
        txtDescricao.clear();
        txtNumero.clear();
        cbbBanco.setValue(null);
        ckbContaCaixa.selectedProperty().setValue(false);

    }

    private void getData() {
        idConta = (controller.getContaCorrente().getId() != 0) ? idConta = controller.getContaCorrente().getId() : 0l;
        agencia = txtAgencia.getText();
        numero = txtNumero.getText();
        descricao = txtDescricao.getText();
        controller.setBanco(cbbBanco.getSelectionModel().getSelectedItem());
    }

    private void setUpCheckBox() {
        ckbContaCaixa.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                isCaixa = !isCaixa;
            }
        });

    }

    private void loadCbbBanco() {
        cbbBanco.setItems(controller.getListaBanco());
    }

    private void setInputOff() {
        btnExcluir.setDisable(true);
        btnLimpar.setDisable(true);
        btnSalvar.setDisable(true);
        txtNumero.setDisable(true);
        txtDescricao.setDisable(true);
        txtAgencia.setDisable(true);
        cbbBanco.setDisable(true);
        ckbContaCaixa.setDisable(true);
        flagButtons = false;
    }

    private void setInputON() {
        btnExcluir.setDisable(false);
        btnLimpar.setDisable(false);
        btnSalvar.setDisable(false);
        txtNumero.setDisable(false);
        txtDescricao.setDisable(false);
        txtAgencia.setDisable(false);
        cbbBanco.setDisable(false);
        ckbContaCaixa.setDisable(false);
        flagButtons = true;
    }

    private Boolean validateFields() {
        Boolean flag = true;
        if (descricao == null || descricao.equals("") || descricao.length() < 3) {
            erros += "A Descrição da conta corrente deve conter um conteúdo válido! \n";
            flag = false;
        }
        if (numero == null || numero.equals("") || numero.length() < 3) {
            erros += "O numero da conta corrente deve conter um conteúdo válido! \n";
            flag = false;
        }
        if (agencia == null || agencia.equals("") || agencia.length() < 3) {
            erros += "O numero da agencia bancária deve conter um conteúdo válido! \n";
            flag = false;
        }

        if (controller.getBanco() == null) {
            erros += "\n Selecione O  Banco para a conta.";
            flag = false;
        }
        return flag;
    }

    private void setData() {
        controller.setContaCorrente(idConta, descricao, agencia, numero, controller.getBanco(), isCaixa);
    }

    private void setUptableView() {
        tbcDescricao.setCellValueFactory(new PropertyValueFactory<>("descricao"));
        tbcBanco.setCellValueFactory(new PropertyValueFactory<>("banco"));
        tbcAgencia.setCellValueFactory(new PropertyValueFactory<>("agencia"));
        tbcConta.setCellValueFactory(new PropertyValueFactory<>("contaCorrente"));
        tbvContas.getColumns().setAll(tbcDescricao, tbcBanco, tbcAgencia, tbcConta);
    }

    private void loadTbv() {
        tbvContas.setItems(controller.getLista());
    }

}
