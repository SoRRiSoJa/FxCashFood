/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashf.controller.contaspagar;

import com.cashf.model.contasPagar.ContaPagar;
import com.cashf.model.meiopagamento.MeioPagamento;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import controller.GenericViewController;
import java.math.BigDecimal;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author joao
 */
public class ContasPagarFXMLController implements GenericViewController, Initializable {

    @FXML
    private Pane paneData;
    @FXML
    private JFXButton btnSalvar;
    @FXML
    private JFXButton btnNovo;
    @FXML
    private JFXButton btnLimpar;
    @FXML
    private JFXTextField txtFavorecido;
    @FXML
    private JFXComboBox<MeioPagamento> cbbFormaPagamento;
    @FXML
    private JFXDatePicker dtpDataVencimento;
    @FXML
    private JFXTextField txtDescricao;
    @FXML
    private JFXTextField txtValor;
    @FXML
    private JFXTextField txtEncargos;
    @FXML
    private JFXTextField txtValorDesconto;
    @FXML
    private JFXTextField txtValorTaxa;
    @FXML
    private JFXTextField txtLiquido;

    @FXML
    private TableView<ContaPagar> tbvContas;
    @FXML
    private TableColumn<ContaPagar, String> tbcFavorecido;
    @FXML
    private TableColumn<ContaPagar, String> tbcDescricao;
    @FXML
    private TableColumn<ContaPagar, LocalDate> tbcVencimento;
    @FXML
    private TableColumn<ContaPagar, BigDecimal> tbcValor;
    @FXML
    private TableColumn<ContaPagar, Boolean> tbcStatus;
    @FXML
    private TableColumn btnQuitar;
    @FXML
    private TableColumn btnCancelar;
    //----
    private String erros;
    private boolean flagButtons;
    private String favorecido;
    private String descricao;
    private BigDecimal valor;
    private BigDecimal encargos;
    private BigDecimal valorDesconto;
    private BigDecimal valorTaxa;
    private BigDecimal valLiquido;

    private final ContasPagarController controller = new ContasPagarController();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void onSalvar(ActionEvent event) {
    }

    @FXML
    private void onNovo(ActionEvent event) {
    }

    @FXML
    private void onLimpar(ActionEvent event) {
    }

    @FXML
    private void onMouseClickedFormaDePagamento(MouseEvent event) {
        if (cbbFormaPagamento.getSelectionModel().getSelectedItem() != null) {
            controller.setMeioPagamento(cbbFormaPagamento.getSelectionModel().getSelectedItem());
        }
    }

    @FXML
    private void onMouseClickedContaPagar(MouseEvent event) {
    }

    @Override
    public void clearFields() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setInputOff() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setInputOn() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean validateFields() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void getData() {
        favorecido = txtFavorecido.getText();
        cbbFormaPagamento.getValue();
        dtpDataVencimento.getValue();
        descricao = txtDescricao.getText();
        try {
            valor = new BigDecimal(txtValor.getText());
        } catch (Exception ex) {
            valor = BigDecimal.ZERO;
        }
        try {
            encargos = new BigDecimal(txtEncargos.getText());
        } catch (Exception ex) {
            encargos = BigDecimal.ZERO;
        }
        try {
            valorDesconto = new BigDecimal(txtValorDesconto.getText());
        } catch (Exception ex) {
            valorDesconto = BigDecimal.ZERO;
        }
        try {
            valorTaxa = new BigDecimal(txtValorTaxa.getText());
        } catch (Exception ex) {
            valorTaxa = BigDecimal.ZERO;
        }
        try {
            valLiquido = new BigDecimal(txtLiquido.getText());
        } catch (Exception ex) {
            valLiquido = BigDecimal.ZERO;
        }
    }

    @Override
    public void loadDataToScreen() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void loadCbbFormaPagto() {
        cbbFormaPagamento.setItems(controller.getMeioPagamentoLista());
    }

}
