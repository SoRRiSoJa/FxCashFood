/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashf.controller.meiopagamento;

import com.cashf.model.contacorrente.ContaCorrente;
import com.cashf.model.meiopagamento.MeioPagamento;
import com.cashf.model.meiopagamento.TPPagto;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import java.math.BigDecimal;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import util.PoupUpUtil;

/**
 * FXML Controller class
 *
 * @author joao
 */
public class MeioPagamentoFXMLController implements Initializable {

    @FXML
    private Pane paneData;
    @FXML
    private JFXComboBox<ContaCorrente> cbbContaCorrente;
    @FXML
    private JFXTextField txtNome;
    @FXML
    private JFXTextField txtPrazo;
    @FXML
    private JFXRadioButton rdbDinheiro;
    @FXML
    private JFXRadioButton rdbDebito;
    @FXML
    private JFXRadioButton rdbCredito;
    @FXML
    private JFXTextField txtTaxa;
    @FXML
    private JFXButton btnSalvar;
    @FXML
    private JFXButton btnNovo;
    @FXML
    private JFXButton btnExcluir;
    @FXML
    private JFXButton btnLimpar;
    @FXML
    private TableView<MeioPagamento> tbvCartoes;
    @FXML
    private TableColumn<MeioPagamento, String> tbcCartao;
    @FXML
    private TableColumn<MeioPagamento, String> tbcConta;
    //---------------------
    private MeioPagamentoController controller = new MeioPagamentoController();
    private String erros;
    private boolean flagButtons;
    private long idMeio = 0;
    private String descricao;
    private Integer prazoRecebimento;
    private BigDecimal taxa;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        setInputOff();
        setUptableView();
        setUpRadioButtons();
        loadCbbContaCorrente();
        loadTbv();
    }

    @FXML
    private void onSalvar(ActionEvent event) {
        getData();
        if (validateFields()) {
            setData();
            if (controller.getMeioPagamento().getIdMeio() == 0) {
                controller.insert();
                PoupUpUtil.poupUp("Meio de Pagamento Cadastrado", "O Meio de Pagamento foi cadastrado com sucesso.", "");

            } else {
                controller.update();
                PoupUpUtil.poupUp("Meio de Pagamento Alterado", "O Meio de Pagamento foi alterado com sucesso.", "");
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
        if (controller.getMeioPagamento() != null) {
            controller.delete();
            PoupUpUtil.poupUp("Meio de Pagamento Excluído", "O Meio de Pagamento foi excluído com sucesso.", "");
        }
        btnExcluir.setDisable(true);
        clearFields();
    }

    @FXML
    private void onLimpar(ActionEvent event) {
        clearFields();
    }

    @FXML
    private void onMouseClicked(MouseEvent event) {
        if (tbvCartoes.getSelectionModel().getSelectedItem() != null) {
            controller.setMeioPagamento(tbvCartoes.getSelectionModel().getSelectedItem());
            loadDataToScreen();
            getData();
        }
    }

    public void loadDataToScreen() {
        txtNome.setText(controller.getMeioPagamento().getDescricao());
        txtPrazo.setText(controller.getMeioPagamento().getPrazoRecebimento().toString());
        txtTaxa.setText(controller.getMeioPagamento().getTaxa().toString());
        cbbContaCorrente.setValue(controller.getMeioPagamento().getContaCorrente());
        switch (controller.getMeioPagamento().getTipoPagto()) {
            case CARTAO_CREDITO:
                rdbCredito.setSelected(true);
                rdbDinheiro.setSelected(false);
                rdbDebito.setSelected(false);
                break;
            case CARTAO_DEBITO:
                rdbCredito.setSelected(false);
                rdbDinheiro.setSelected(false);
                rdbDebito.setSelected(true);
                break;
            default:
                rdbCredito.setSelected(false);
                rdbDinheiro.setSelected(true);
                rdbDebito.setSelected(false);
                break;
        }
        getData();
    }

    private void clearFields() {
        txtNome.clear();
        txtPrazo.clear();
        txtTaxa.clear();
        cbbContaCorrente.setValue(null);

    }

    private void setUpRadioButtons() {

        rdbCredito.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                rdbDebito.setSelected(false);
                rdbDinheiro.setSelected(false);
                controller.setTpPagto(TPPagto.CARTAO_CREDITO);
            }
        });
        rdbDebito.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                rdbCredito.setSelected(false);
                rdbDinheiro.setSelected(false);
                controller.setTpPagto(TPPagto.CARTAO_DEBITO);
            }
        });

        rdbDinheiro.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                rdbCredito.setSelected(false);
                rdbDebito.setSelected(false);
                controller.setTpPagto(TPPagto.DINHEIRO);
            }
        });
    }

    private void setInputOff() {
        btnExcluir.setDisable(true);
        btnLimpar.setDisable(true);
        btnSalvar.setDisable(true);
        txtNome.setDisable(true);
        txtPrazo.setDisable(true);
        txtTaxa.setDisable(true);
        cbbContaCorrente.setDisable(true);
        flagButtons = false;
    }

    private void setInputON() {
        btnExcluir.setDisable(false);
        btnLimpar.setDisable(false);
        btnSalvar.setDisable(false);
        txtNome.setDisable(false);
        txtPrazo.setDisable(false);
        txtTaxa.setDisable(false);
        cbbContaCorrente.setDisable(false);
        flagButtons = true;
    }

    private void loadCbbContaCorrente() {
        cbbContaCorrente.setItems(controller.getListaConta());
    }

    private void getData() {
        idMeio = (controller.getMeioPagamento().getIdMeio() != 0) ? idMeio = controller.getMeioPagamento().getIdMeio() : 0l;
        prazoRecebimento = Integer.parseUnsignedInt(txtPrazo.getText());
        taxa = new BigDecimal(txtTaxa.getText());
        descricao = txtNome.getText();
        controller.setContaCorrente(cbbContaCorrente.getSelectionModel().getSelectedItem());
    }

    private void setData() {
        controller.setMeioPagamento(idMeio, descricao, prazoRecebimento, taxa, controller.getTpPagto(), controller.getContaCorrente());
    }

    private Boolean validateFields() {
        Boolean flag = true;
        if (descricao == null || descricao.equals("") || descricao.length() < 3) {
            erros += "A Descrição do meio de pagamento deve conter um conteúdo válido! \n";
            flag = false;
        }
        if (prazoRecebimento == null || prazoRecebimento.equals("") || prazoRecebimento.compareTo(new Integer(0)) <= 0) {
            erros += "O prazo de recebimento deve ser maior que 0! \n";
            flag = false;
        }
        if (taxa == null || taxa.equals("")) {
            erros += "A taxa deve conter um conteúdo válido! \n";
            flag = false;
        }

        if (controller.getContaCorrente() == null) {
            erros += "\n Selecione uma Conta Corrente.";
            flag = false;
        }
        return flag;
    }

    private void setUptableView() {
        tbcCartao.setCellValueFactory(new PropertyValueFactory<>("descricao"));
        tbcConta.setCellValueFactory(new PropertyValueFactory<>("contaCorrente"));
        tbvCartoes.getColumns().setAll(tbcCartao, tbcConta);
    }

    private void loadTbv() {
        tbvCartoes.setItems(controller.getLista());
    }

}
