/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashf.controller.caixa;

import com.cashf.cashfood.MainApp;
import com.cashf.model.caixa.Caixa;
import com.cashf.model.caixa.CaixaMovimento;
import com.cashf.model.caixa.TPMov;
import com.jfoenix.controls.JFXButton;
import com.sun.prism.impl.Disposer;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.URL;
import java.time.LocalDate;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;
import util.PoupUpUtil;

/**
 * FXML Controller class
 *
 * @author joao
 */
public class GerenciarCaixaFXMLController implements Initializable {

    @FXML
    private TableView<CaixaMovimento> tbvMovimentacoes;
    @FXML
    private TableColumn<CaixaMovimento, String> tbcDescricao;
    @FXML
    private TableColumn<CaixaMovimento, TPMov> tbcTipo;
    @FXML
    private TableColumn<CaixaMovimento, BigDecimal> tbcValor;
    @FXML
    private TableColumn<CaixaMovimento, LocalDate> tbcDataMov;
    @FXML
    private TableColumn btnEstornar;
    @FXML
    private JFXButton btnAbrirCaixa;
    @FXML
    private JFXButton btnSuprir;
    @FXML
    private JFXButton btnSangrar;
    @FXML
    private JFXButton btnFecharCaixa;
    @FXML
    private Label lblTotalRecebido;
    @FXML
    private Label lblTotalPago;
    @FXML
    private Label lblSaldo;
    @FXML
    private TableView<Caixa> tbvLista;
    @FXML
    private TableColumn<Caixa, LocalDate> tbcDataAb;
    @FXML
    private TableColumn<Caixa, LocalDate> tbcDataFe;
    @FXML
    private Pane paneRoot;
    //---
    private static TableView<CaixaMovimento> _tbvMovimentacoes;
    private static Label _lblTotalRecebido;
    private static Label _lblTotalPago;
    private static Label _lblSaldo;
    private static Label _lblSaldoInicial;

    @FXML
    private Label lblSaldoInicial;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        _tbvMovimentacoes = tbvMovimentacoes;
        _lblSaldo = lblSaldo;
        _lblTotalPago = lblTotalPago;
        _lblTotalRecebido = lblTotalRecebido;
        _lblSaldoInicial = lblSaldoInicial;
        setUpTbv();

        if (CaixaController.getInstance().getCaixaAberto().getIdCaixa() != 0) {
            lblSaldo.setText(CaixaController.getInstance().getSaldoFinal().toString());
            lblTotalPago.setText(CaixaController.getInstance().getTotalDebitos().toString());
            lblTotalRecebido.setText(CaixaController.getInstance().getTotalCreditos().toString());
            lblSaldoInicial.setText(CaixaController.getInstance().getCaixaAberto().getValorInicial().toString());
        }

        loadTbv();

    }

    @FXML
    private void onSalvar(ActionEvent event) {
        if (CaixaController.getInstance().getCaixaAberto().getIdCaixa() == 0) {
            loadBox("/fxml/caixa/BoxAbrirCaixaNFXML.fxml", "Abrir Caixa");
            loadTbv();
        } else {
            PoupUpUtil.accessDenied("Um caixa já se encontra aberto");
        }
    }

    @FXML
    private void onNovo(ActionEvent event) {
        loadBox("/fxml/caixa/BoxSuprirCaixaFXML.fxml", "Suprir Caixa");
    }

    @FXML
    private void onExcluir(ActionEvent event) {
        loadBox("/fxml/caixa/BoxSangrarCaixaFXML.fxml", "Sangrar Caixa");
    }

    @FXML
    private void onLimpar(ActionEvent event) {
        loadBox("/fxml/caixa/BoxFecharCaixaFXML.fxml", "Fechar Caixa");
    }

    private void loadTbv() {
        tbvMovimentacoes.setItems(CaixaController.getInstance().getListaMov());
    }

    private void loadBox(String boxPath, String title) {
        try {
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource(boxPath));
            stage.setScene(new Scene(root));
            stage.setTitle(title);
            stage.initModality(Modality.APPLICATION_MODAL);
            MainApp.janelaAnterior = MainApp.janelaAberta;
            MainApp.janelaAberta = stage;
            stage.show();
        } catch (IOException ex) {
            System.out.println("Erro---->" + ex);
        }
    }

    private void setUpTbv() {
        tbcDescricao.setCellValueFactory(new PropertyValueFactory<>("observacao"));
        tbcDataMov.setCellValueFactory(new PropertyValueFactory<>("dataMovimento"));
        tbcTipo.setCellValueFactory(new PropertyValueFactory<>("tipoMovimento"));
        tbcValor.setCellValueFactory(new PropertyValueFactory<>("valor"));
        btnEstornar.setCellFactory(
                new Callback<TableColumn<Disposer.Record, Boolean>, TableCell<Disposer.Record, Boolean>>() {
            @Override
            public TableCell<Disposer.Record, Boolean> call(TableColumn<Disposer.Record, Boolean> p) {
                return new ButtonCellCashBack();
            }
        });
        tbvMovimentacoes.getColumns().setAll(tbcDescricao, tbcDataMov, tbcTipo, tbcValor, btnEstornar);
    }

    public class ButtonCellCashBack extends TableCell<Disposer.Record, Boolean> {

        Image img;
        ImageView imgv;
        JFXButton cellButton = new JFXButton("Estornar");
        Notifications notificationBuilder;

        public ButtonCellCashBack() {
            this.img = new Image("Imagens/ban-circle-symbol.png");
            this.imgv = new ImageView(img);
            cellButton.setGraphic(imgv);
            cellButton.setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
            cellButton.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent t) {
                    // get Selected Item
                    CaixaMovimento currentPerson = (CaixaMovimento) ButtonCellCashBack.this.getTableView().getItems().get(ButtonCellCashBack.this.getIndex());
                    //remove selected item from the table list
                    if (currentPerson != null) {

                        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                        alert.setTitle("Cofirmar Estornar Lançamento!");
                        alert.setHeaderText("Deseja realmente Estornar?");
                        alert.setContentText("Movimento:(" + currentPerson.getDataMovimento() + "|" + currentPerson.getObservacao());
                        Optional<ButtonType> result = alert.showAndWait();
                        if (result.get() == ButtonType.OK) {
                            // ... user chose OK
                            CaixaController.getInstance().getListaMov().remove(currentPerson);
                            notificationBuilder = Notifications.create().title("MOvimento Estornado!").
                                    text("Estorno realizado com sucesso.").
                                    hideAfter(Duration.seconds(2)).
                                    position(Pos.TOP_RIGHT).
                                    darkStyle();
                            notificationBuilder.showInformation();
                        } else {
                            alert.close();
                        }
                    } else {
                        notificationBuilder = Notifications.create().title("Nenhum item selecionado!").
                                text("Você deve selecionar uma movimentação da lista para estornar.").
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

    public static void refreshTbv() {
        _tbvMovimentacoes.setItems(CaixaController.getInstance().getListaMov());
    }

    public static void refreshTotal() {
        _lblSaldo.setText(CaixaController.getInstance().getSaldoFinal().toString());
        _lblTotalPago.setText(CaixaController.getInstance().getTotalDebitos().toString());
        _lblTotalRecebido.setText(CaixaController.getInstance().getTotalCreditos().toString());
        if (CaixaController.getInstance().getCaixaAberto() != null && CaixaController.getInstance().getCaixaAberto().getValorInicial() != null) {
            _lblSaldoInicial.setText(CaixaController.getInstance().getCaixaAberto().getValorInicial().toString());
        } else {
            _lblSaldoInicial.setText("N/A");
        }
    }
}
