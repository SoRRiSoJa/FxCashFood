/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashf.controller.contaspagar;

import com.cashf.cashfood.MainApp;
import com.cashf.controller.caixa.CaixaController;
import com.cashf.model.contasPagar.ContaPagar;
import com.cashf.model.contasPagar.StatusPagto;
import com.cashf.model.meiopagamento.MeioPagamento;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import com.sun.prism.impl.Disposer;
import controller.GenericViewController;
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
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
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
    private TableColumn<ContaPagar, StatusPagto> tbcStatus;
    @FXML
    private TableColumn btnQuitar;
    @FXML
    private TableColumn btnCancelar;
    //----
    private String erros = "";
    private boolean flagButtons;
    private String favorecido;
    private String descricao;
    private BigDecimal valor;
    private BigDecimal encargos;
    private BigDecimal valorDesconto;
    private BigDecimal valorTaxa;
    private BigDecimal valLiquido;
    private LocalDate dataVencimento;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

        setUpTableView();
    }

    @FXML
    private void onSalvar(ActionEvent event) {
        getData();
        if (validateFields()) {
            ContasPagarController.getInstance().setContaPAgar(0l, dataVencimento, null, favorecido, descricao, valor, encargos, valorDesconto, valorTaxa, valLiquido, null, CaixaController.getInstance().getCaixaAberto(), StatusPagto.ABERTO);
            ContasPagarController.getInstance().setItenLista(ContasPagarController.getInstance().getContaPAgar());
            loadTbv();
        } else {
            PoupUpUtil.errorMessage(paneData, MainApp.paneRoot, erros);
            erros = "";
        }
    }

    @FXML
    private void onNovo(ActionEvent event) {
    }

    @FXML
    private void onLimpar(ActionEvent event) {
        clearFields();
    }

    @FXML
    private void onMouseClickedContaPagar(MouseEvent event) {
    }

    @Override
    public void clearFields() {
        txtFavorecido.clear();
        dtpDataVencimento.setValue(null);
        txtDescricao.clear();
        txtValor.clear();
        txtEncargos.clear();
        txtValorDesconto.clear();
        txtValorTaxa.clear();
        txtLiquido.clear();
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
        boolean flag = true;
        if (descricao == null || descricao.isEmpty() || descricao.length() < 3) {
            erros += "Uma descrição valida deve ser informada \n";
            flag = false;
        }
        if (favorecido == null || favorecido.isEmpty() || favorecido.length() < 3) {
            erros += "Uma favorecido deve ser informado. \n";
            flag = false;
        }
        if (valor.compareTo(BigDecimal.ZERO) <= 0) {
            erros += "O Valor Bruto deve ser maior que 0.\n";
            flag = false;
        }
        if (encargos.compareTo(BigDecimal.ZERO) < 0) {
            erros += "O Valor dos encargos não pode ser negativo.\n";
            flag = false;
        }
        if (valorDesconto.compareTo(BigDecimal.ZERO) < 0) {
            erros += "O Valor dos descontos não pode ser negativo\n";
            flag = false;
        }
        if (valorTaxa.compareTo(BigDecimal.ZERO) < 0) {
            erros += "O Valor das taxas não pode ser negativo\n";
            flag = false;
        }

        return flag;
    }

    @Override
    public void getData() {
        favorecido = txtFavorecido.getText();
        dataVencimento = dtpDataVencimento.getValue();
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
        txtFavorecido.setText(ContasPagarController.getInstance().getContaPagar().getFavorecido());
        dtpDataVencimento.setValue(ContasPagarController.getInstance().getContaPagar().getDataVencimento());
        txtDescricao.setText(ContasPagarController.getInstance().getContaPagar().getDescricao());
        txtValor.setText(ContasPagarController.getInstance().getContaPagar().getValorBruto().toString());
        txtEncargos.setText(ContasPagarController.getInstance().getContaPagar().getEncargos().toString());
        txtValorDesconto.setText(ContasPagarController.getInstance().getContaPagar().getDesconto().toString());
        txtValorTaxa.setText(ContasPagarController.getInstance().getContaPagar().getAcrecimo().toString());
        txtLiquido.setText(ContasPagarController.getInstance().getContaPagar().getValorPago().toString());
    }

    private void loadTbv() {
        tbvContas.setItems(ContasPagarController.getInstance().getLista());
    }

    private void setUpTableView() {
        tbcFavorecido.setCellValueFactory(new PropertyValueFactory<>("favorecido"));
        tbcDescricao.setCellValueFactory(new PropertyValueFactory<>("descricao"));
        tbcVencimento.setCellValueFactory(new PropertyValueFactory<>("dataVencimento"));
        tbcValor.setCellValueFactory(new PropertyValueFactory<>("valorPago"));
        tbcStatus.setCellValueFactory(new PropertyValueFactory<>("statusPagto"));
        btnQuitar.setCellFactory(
                new Callback<TableColumn<Disposer.Record, Boolean>, TableCell<Disposer.Record, Boolean>>() {
            @Override
            public TableCell<Disposer.Record, Boolean> call(TableColumn<Disposer.Record, Boolean> p) {
                return new ButtonCellPay();
            }
        });
        btnCancelar.setCellFactory(
                new Callback<TableColumn<Disposer.Record, Boolean>, TableCell<Disposer.Record, Boolean>>() {
            @Override
            public TableCell<Disposer.Record, Boolean> call(TableColumn<Disposer.Record, Boolean> p) {
                return new ButtonCellDelete();
            }
        });
        tbvContas.getColumns().setAll(tbcFavorecido, tbcDescricao, tbcVencimento, tbcValor, tbcStatus, btnQuitar, btnCancelar);
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
                    ContaPagar currentPerson = (ContaPagar) ButtonCellDelete.this.getTableView().getItems().get(ButtonCellDelete.this.getIndex());
                    //remove selected item from the table list
                    if (currentPerson != null) {

                        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                        alert.setTitle("Cofirmar cancelar Conta !");
                        alert.setHeaderText("Deseja realmente cancelar?");
                        alert.setContentText("Produto:(" + currentPerson.getDescricao() + "");
                        Optional<ButtonType> result = alert.showAndWait();
                        if (result.get() == ButtonType.OK) {
                            // ... user chose OK
                            ContasPagarController.getInstance().getLista().remove(currentPerson);
                            ContasPagarController.getInstance().delete();
                            notificationBuilder = Notifications.create().title("Ítem excluído!").
                                    text("Ítem Excluido com sucesso.").
                                    hideAfter(Duration.seconds(2)).
                                    position(Pos.TOP_RIGHT).
                                    darkStyle();
                            notificationBuilder.showInformation();
                        } else {
                            alert.close();
                        }
                    } else {
                        notificationBuilder = Notifications.create().title("Nenhuma conta selecionada!").
                                text("Você deve selecionar uma conta para cancelar.").
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

    public class ButtonCellPay extends TableCell<Disposer.Record, Boolean> {

        Image img;
        ImageView imgv;
        JFXButton cellButton = new JFXButton("Quitar");
        Notifications notificationBuilder;

        public ButtonCellPay() {
            this.img = new Image("Imagens/ic_payment_black_24dp_1x.png");
            this.imgv = new ImageView(img);
            cellButton.setGraphic(imgv);
            cellButton.setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
            cellButton.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent t) {
                    // get Selected Item
                    ContaPagar currentPerson = (ContaPagar) ButtonCellPay.this.getTableView().getItems().get(ButtonCellPay.this.getIndex());
                    //remove selected item from the table list
                    if (currentPerson != null) {
                        ContasPagarController.getInstance().setContaPagar(currentPerson);
                        loadBox("/fxml/contasPagar/BoxQuitarContaPagarFXML.fxml", "Quitar Conta a Pagar");
                    } else {
                        notificationBuilder = Notifications.create().title("Nenhuma conta selecionada!").
                                text("Você deve selecionar uma conta para cancelar.").
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

}
