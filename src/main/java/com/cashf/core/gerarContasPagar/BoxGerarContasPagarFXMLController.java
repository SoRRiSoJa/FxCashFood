/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashf.core.gerarContasPagar;

import com.cashf.cashfood.MainApp;
import com.cashf.controller.receberpedido.ReceberPedidoController;
import com.cashf.core.atualizarestoque.AtualizarEstoque;
import com.cashf.model.contasPagar.ContaPagar;
import com.cashf.model.meiopagamento.MeioPagamento;
import com.cashf.model.notafiscal.NotaFiscal;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import java.math.BigDecimal;
import java.net.URL;
import java.time.LocalDate;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author joao
 */
public class BoxGerarContasPagarFXMLController implements Initializable {

    @FXML
    private JFXComboBox<MeioPagamento> cbbFormaPagamento;
    @FXML
    private Label lblFavorecido;
    @FXML
    private JFXDatePicker dtpDataVencimento;
    @FXML
    private Label lblDescricao;
    @FXML
    private JFXTextField txtpaRCELAS;
    @FXML
    private JFXTextField txtIntervalo;
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
    private JFXButton btnGerar;
    @FXML
    private JFXButton btnLancar;
    @FXML
    private JFXButton btnCancelar;
    @FXML
    private JFXRadioButton rbtSim;
    @FXML
    private JFXTextField txtValorTotal;
    @FXML
    private JFXRadioButton rbtNao;
    //---
    private GerarContasPagar gerarContasPagar;
    private AtualizarEstoque atualizarEstoque;
    private LocalDate dataInicial;
    private BigDecimal valorTotal;
    private int nParcelas;
    private int intervalor;
    private String erros = "";

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        gerarContasPagar = new GerarContasPagar();
        atualizarEstoque=new AtualizarEstoque();
        loadData();
        loadCbbMeioPagto();
        setUpTableView();
        setUpRadioButtons();
    }

    @FXML
    private void onMouseClickedFormaDePagamento(MouseEvent event) {
        if (cbbFormaPagamento.getSelectionModel().getSelectedItem() != null) {
            gerarContasPagar.setMeioPagamento(cbbFormaPagamento.getSelectionModel().getSelectedItem());
        }
    }

    @FXML
    private void onMouseClickedContaPagar(MouseEvent event) {
    }

    @FXML
    private void onGerar(ActionEvent event) {
        getData();
       
        if (gerarContasPagar.isTipoParcelamento()) {
            gerarContasPagar.gerarParcelas(ReceberPedidoController.getInstance().getValTotalNota(),
                    dataInicial,
                    lblFavorecido.getText(),
                    nParcelas,
                    intervalor);
            ReceberPedidoController.getInstance().setContaPagar(gerarContasPagar.getContaPagar());
            ReceberPedidoController.getInstance().getNotaFiscal().setContaPagar(gerarContasPagar.getContaPagar());
            loadListaParcelas();
        } else {
            gerarContasPagar.gerarContaPagar(BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO, valorTotal, dataInicial, lblFavorecido.getText());
            loadListaParcelas();
        }

    }

    @FXML
    private void onAbrir(ActionEvent event) {
        Notifications notificationBuilder;
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Cofirmar O Lançamento!");
        alert.setHeaderText("Deseja Lançar a(s) contas geradas?");
        //alert.setContentText("N + ")");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            gerarContasPagar.efetuarLancamento();
            // ... user chose OK
            ReceberPedidoController.getInstance().getNotaFiscal().setContaPagar(gerarContasPagar.getLista().get(0));
            ReceberPedidoController.getInstance().salvarNota();
            ReceberPedidoController.getInstance().atualizarEstoqueProdutosNota();

            notificationBuilder = Notifications.create().title("Conta(s) Lançadas!").
                    text("Contas Lançadas com sucesso!.").
                    hideAfter(Duration.seconds(2)).
                    position(Pos.TOP_RIGHT).
                    darkStyle();
            notificationBuilder.showInformation();
        } else {
            alert.close();
        }
        MainApp.janelaAberta.close();
        MainApp.janelaAberta = MainApp.janelaAnterior;
    }

    @FXML
    private void onCancelar(ActionEvent event) {
        MainApp.janelaAberta.close();
        MainApp.janelaAberta = MainApp.janelaAnterior;
    }

    private void loadData() {
        dtpDataVencimento.setValue(LocalDate.now());
        lblFavorecido.setText(ReceberPedidoController.getInstance().getNotaFiscal().getFornecedor().getNomefantasia());
        lblDescricao.setText("Nota fiscal de compra[" + ReceberPedidoController.getInstance().getNotaFiscal().getNumero_nota() + "] em : " + LocalDate.now());
        txtValorTotal.setText(ReceberPedidoController.getInstance().getNotaFiscal().getValorTotalNota().toString());
    }

    public void loadCbbMeioPagto() {
        cbbFormaPagamento.setItems(gerarContasPagar.getListaMeioPagamento());
    }

    public void loadListaParcelas() {
        tbvContas.setItems(gerarContasPagar.getLista());
    }

    private void setUpTableView() {
        tbcFavorecido.setCellValueFactory(new PropertyValueFactory<>("favorecido"));
        tbcDescricao.setCellValueFactory(new PropertyValueFactory<>("descricao"));
        tbcVencimento.setCellValueFactory(new PropertyValueFactory<>("dataVencimento"));
        tbcValor.setCellValueFactory(new PropertyValueFactory<>("valorPago"));
        tbvContas.getColumns().setAll(tbcFavorecido, tbcDescricao, tbcVencimento, tbcValor);
    }

    private void getData() {
        try {
            nParcelas = Integer.parseInt(txtpaRCELAS.getText());
        } catch (Exception ex) {
            nParcelas = 0;
        }
        try {
            dataInicial = dtpDataVencimento.getValue();
        } catch (Exception ex) {
            dataInicial = LocalDate.now();
        }
        try {
            intervalor = Integer.parseInt(txtIntervalo.getText());
        } catch (Exception ex) {
            nParcelas = 0;
        }
        try {
            valorTotal = new BigDecimal(txtValorTotal.getText());
        } catch (Exception ex) {
            valorTotal = BigDecimal.ZERO;
        }
    }

    private boolean validateFields() {
        boolean flag = true;
        if (cbbFormaPagamento.getSelectionModel().getSelectedItem() == null) {
            erros += "Você deve selecionar um Meio de Pagamento\n";
            flag = false;
        }
        return flag;
    }

    private void setUpRadioButtons() {

        rbtSim.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                rbtNao.setSelected(false);
                gerarContasPagar.setTipoParcelamento(true);
            }
        });
        rbtNao.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                rbtSim.setSelected(false);
                gerarContasPagar.setTipoParcelamento(false);
            }
        });
    }
}
