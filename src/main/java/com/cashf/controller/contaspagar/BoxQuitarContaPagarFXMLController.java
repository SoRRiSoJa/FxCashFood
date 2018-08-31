/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashf.controller.contaspagar;

import com.cashf.cashfood.MainApp;
import com.cashf.controller.caixa.CaixaController;
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
import util.TextFieldFormatter;

/**
 * FXML Controller class
 *
 * @author joao
 */
public class BoxQuitarContaPagarFXMLController implements Initializable {

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
        loadData();
        loadCbbMeioPagto();
    }

    @FXML
    private void onAbrir(ActionEvent event) {
        getData();
        if (validateFields()) {
            ContasPagarController.getInstance().quitarConta(lblDescricao.getText(), dataPagamento,valorAcrecimos,valorDesconto, vallorPago);
        } else {
            PoupUpUtil.errorMessage(MainApp.paneRoot, paneRoot, erros);
            erros = "";
        }
        MainApp.janelaAberta.close();
        MainApp.janelaAberta = MainApp.janelaAnterior;
    }

    @FXML
    private void onCancelar(ActionEvent event) {
        MainApp.janelaAberta.close();
        MainApp.janelaAberta = MainApp.janelaAnterior;
    }

    @FXML
    private void onMouseClickedFormaDePagamento(MouseEvent event) {
        if (cbbFormaPagamento.getSelectionModel().getSelectedItem() != null) {
            ContasPagarController.getInstance().setMeioPagamento(cbbFormaPagamento.getItems().get(cbbFormaPagamento.getSelectionModel().getSelectedIndex()));
        }
    }

    public void loadData() {
        lblDescricao.setText(ContasPagarController.getInstance().getContaPAgar().getDescricao());
        lblFavorecido.setText(ContasPagarController.getInstance().getContaPAgar().getFavorecido());
        txtValor.setText(ContasPagarController.getInstance().getContaPAgar().getValorPago().toString());
        dtpDataPagamento.setValue(LocalDate.now());
        dtpDataVencimento.setValue(ContasPagarController.getInstance().getContaPAgar().getDataVencimento());
        try {
            valor = new BigDecimal(txtValor.getText());
            vallorPago = valor;
        } catch (Exception ex) {
            valor = BigDecimal.ZERO;
        }
    }

    public void loadCbbMeioPagto() {
        cbbFormaPagamento.setItems(ContasPagarController.getInstance().getMeioPagamentoLista());
    }

    @FXML
    private void onKeyReleasedAcrecimos(KeyEvent event) {
        TextFieldFormatter tff = new TextFieldFormatter();
        tff.setMask("###.##");
        tff.setCaracteresValidos("0123456789");
        tff.setTf(txtAcrecimos);
        tff.formatter();
        if (txtAcrecimos.getText().length() == 6) {
            try {
                valorAcrecimos = new BigDecimal(txtAcrecimos.getText());
            } catch (Exception exx) {

            }
            try {
                vallorPago = vallorPago.add(valorAcrecimos);
                txtValor.setText(vallorPago.toString());
            } catch (Exception ex) {

            }
        }
    }

    @FXML
    private void onKeyReleasedDescontos(KeyEvent event) {
        TextFieldFormatter tff = new TextFieldFormatter();
        tff.setMask("###.##");
        tff.setCaracteresValidos("0123456789");
        tff.setTf(txtDescontos);
        tff.formatter();
        if (txtDescontos.getText().length() == 6) {
            try {
                try {
                    valorDesconto = new BigDecimal(txtDescontos.getText());
                } catch (Exception exx) {

                }
                vallorPago = vallorPago.subtract(valorDesconto);
                txtValor.setText(vallorPago.toString());
            } catch (Exception ex) {

            }
        }
    }

    public boolean validateValue(BigDecimal val) {
        return (val.compareTo(CaixaController.getInstance().getSaldoConta()) <= 0);
    }

    public Boolean validateFields() {
        boolean flag = true;

        if (valor.compareTo(BigDecimal.ZERO) <= 0) {
            erros += "O Valor Bruto deve ser maior que 0.\n";
            flag = false;
        }
        if (valorAcrecimos.compareTo(BigDecimal.ZERO) < 0) {
            erros += "O Valor dos encargos não pode ser negativo.\n";
            flag = false;
        }
        if (valorDesconto.compareTo(BigDecimal.ZERO) < 0) {
            erros += "O Valor dos descontos não pode ser negativo\n";
            flag = false;
        }
        if (cbbFormaPagamento.getSelectionModel().getSelectedItem() == null) {
            erros += "Uma forma de pagamento ser informada \n";
            flag = false;
        }
        if (!validateValue(vallorPago)) {
            erros += "O valor é superior ao saldo de caixa \n";
            flag = false;
        }
        return flag;
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
        ContasPagarController.getInstance().setMeioPagamento(cbbFormaPagamento.getItems().get(cbbFormaPagamento.getSelectionModel().getSelectedIndex()));

    }

}
