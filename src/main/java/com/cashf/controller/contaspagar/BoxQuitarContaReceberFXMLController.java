/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashf.controller.contaspagar;

import com.cashf.cashfood.MainApp;
import com.cashf.core.venda.ContaReceberController;
import com.cashf.model.contasPagar.StatusPagto;
import com.cashf.model.meiopagamento.MeioPagamento;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import java.math.BigDecimal;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import util.PoupUpUtil;

/**
 * FXML Controller class
 *
 * @author joao
 */
public class BoxQuitarContaReceberFXMLController implements Initializable {

    @FXML
    private StackPane paneRoot;
    @FXML
    private Pane paneCentral;
    @FXML
    private JFXDatePicker dtpDataVencimento;
    @FXML
    private Label lblFavorecido;
    @FXML
    private JFXButton btnQuitar;
    @FXML
    private JFXButton btnCancelar;
    @FXML
    private JFXTextField txtValor;
    @FXML
    private JFXDatePicker dtpDataPagamento;
    @FXML
    private JFXTextField txtAcrecimos;
    @FXML
    private JFXComboBox<MeioPagamento> cbbFormaPagamento;
    @FXML
    private Label lblDescricao;
    @FXML
    private JFXTextField txtDescontos;
    //-----
    private String erros = "";
    private boolean flagButtons;
    private BigDecimal valor;
    private BigDecimal valorDesconto;
    private BigDecimal valorAcrecimos;
    private BigDecimal vallorPago;
    private LocalDate dataPagamento;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        loadCbbMeioPagto();
    }

    @FXML
    private void onAbrir(ActionEvent event) {
        getData();
        if (true) {
            ContaReceberController.getInstance().quitarContaReceber(dataPagamento,
                    valor,
                    valorDesconto,
                    valorAcrecimos,
                    vallorPago,
                    ContaReceberController.getInstance().getContaReceber().getMeioPagamento(),
                    StatusPagto.RECEBIDA);
        } else {
            PoupUpUtil.accessDenied(erros);
            //PoupUpUtil.errorMessage(paneRoot, paneRoot, erros);
            erros = "";
        }
    }

    @FXML
    private void onCancelar(ActionEvent event) {
        MainApp.janelaAberta.close();
        MainApp.janelaAberta = MainApp.janelaAnterior;
    }

    @FXML
    private void onKeyReleasedAcrecimos(KeyEvent event) {
    }

    @FXML
    private void onMouseClickedFormaDePagamento(MouseEvent event) {
        if (cbbFormaPagamento.getSelectionModel().getSelectedItem() != null) {
            ContaReceberController.getInstance().getContaReceber().setMeioPagamento(cbbFormaPagamento.getItems().get(cbbFormaPagamento.getSelectionModel().getSelectedIndex()));
        }
    }

    @FXML
    private void onKeyReleasedDescontos(KeyEvent event) {
    }

    public void loadCbbMeioPagto() {
        cbbFormaPagamento.setItems(ContaReceberController.getInstance().getListaMeioPagamento());
    }

    public void getData() {

        dataPagamento = dtpDataPagamento.getValue();

        try {
            valor = new BigDecimal(txtValor.getText());
        } catch (Exception ex) {
            valor = BigDecimal.ZERO;
        }
        try {
            valorAcrecimos = new BigDecimal(txtAcrecimos.getText());
        } catch (Exception ex) {
            valorAcrecimos = BigDecimal.ZERO;
        }
        try {
            valorDesconto = new BigDecimal(txtDescontos.getText());
        } catch (Exception ex) {
            valorDesconto = BigDecimal.ZERO;
        }
        ContaReceberController.getInstance().getContaReceber().setMeioPagamento(cbbFormaPagamento.getItems().get(cbbFormaPagamento.getSelectionModel().getSelectedIndex()));

    }

    public void loadData() {
        lblDescricao.setText(ContaReceberController.getInstance().getContaReceber().getDescricao());
        lblFavorecido.setText(ContaReceberController.getInstance().getContaReceber().getFavorecido());
        txtValor.setText(ContaReceberController.getInstance().getContaReceber().getValorPago().toString());
        dtpDataPagamento.setValue(LocalDate.now());
        dtpDataVencimento.setValue(ContasPagarController.getInstance().getContaPAgar().getDataVencimento());
        try {
            valor = new BigDecimal(txtValor.getText());
            vallorPago = valor;
        } catch (Exception ex) {
            valor = BigDecimal.ZERO;
        }
    }
}
