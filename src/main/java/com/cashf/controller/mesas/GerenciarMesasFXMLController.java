/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashf.controller.mesas;

import com.cashf.cashfood.MainApp;
import com.cashf.core.venda.VendaController;
import com.cashf.model.produto.Produto;
import com.cashf.model.venda.ProdutoVenda;
import com.jfoenix.controls.JFXButton;
import com.sun.prism.impl.Disposer;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author joao
 */
public class GerenciarMesasFXMLController implements Initializable {

    @FXML
    private StackPane rootStackPane;
    @FXML
    private Pane paneCentral;
    @FXML
    private JFXButton btnRegistrar;
    @FXML
    private JFXButton btnTransferir;
    @FXML
    private JFXButton btnFechar;
    @FXML
    private JFXButton btnFecharParcial;
    @FXML
    private TableView<ProdutoVenda> tbvComanda;
    @FXML
    private Label lblNumMesa;
    @FXML
    private TableColumn<ProdutoVenda, String> tbcCod;
    @FXML
    private TableColumn<ProdutoVenda, Produto> tbcDescricao;
    @FXML
    private TableColumn<ProdutoVenda, BigDecimal> tbcQtde;
    @FXML
    private TableColumn<ProdutoVenda, BigDecimal> tbcPreco;

    @FXML
    private TableColumn<ProdutoVenda, BigDecimal> tbcTotal;
    @FXML
    private TableColumn btnCancelar;
    @FXML
    private TableColumn btnTransferirM;
    //----
    private static TableView<ProdutoVenda> _tbvComanda;
    private Label lblTotalMesa;
    @FXML
    private Label lblTotal;
    @FXML
    private Label lblPagtoParc;
    @FXML
    private Label lblSaldoAtual;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        _tbvComanda = tbvComanda;
        setUptableViewProdutos();
        loadTbv();
        lblNumMesa.setText(MesaController.getInstance().getMesaAtual().getNumMesa() + "");
        loadData();
    }

    @FXML
    private void onRegistrar(ActionEvent event) {
        loadBox("/fxml/mesas/RegistrarConsumoFXML.fxml", "Lançar Consumo na Mesa");
    }

    @FXML
    private void onTransferir(ActionEvent event) {
        loadBox("/fxml/mesas/TransferirMesaFXML.fxml", "Transferir Mesa");
    }

    @FXML
    private void onFechar(ActionEvent event) {
    }

    @FXML
    private void onFecharParcial(ActionEvent event) {
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

    private void loadData() {
        lblTotal.setText(VendaController.getInstance().getVendaByMesa(MesaController.getInstance().getMesaAtual()).getValorTotal().toString());
    }

    private void loadTbv() {
        tbvComanda.setItems(VendaController.getInstance().getListaProduosVenda());
    }

    public static void refreshTbvComanda() {
        _tbvComanda.setItems(VendaController.getInstance().getListaProduosVenda());
        _tbvComanda.refresh();
    }

    private void setUptableViewProdutos() {
        tbcCod.setCellValueFactory((param) -> new SimpleStringProperty(param.getValue().getProduto().getCodigoReferencia()));
        tbcDescricao.setCellValueFactory(new PropertyValueFactory<>("produto"));
        tbcQtde.setCellValueFactory(new PropertyValueFactory<>("qtde"));
        tbcPreco.setCellValueFactory(new PropertyValueFactory<>("precoUnit"));

        tbcTotal.setCellValueFactory((param) -> new SimpleObjectProperty<BigDecimal>(param.getValue().getPrecoUnit().multiply(param.getValue().getQtde())));
        btnCancelar.setCellFactory(
                new Callback<TableColumn<Disposer.Record, Boolean>, TableCell<Disposer.Record, Boolean>>() {
            @Override
            public TableCell<Disposer.Record, Boolean> call(TableColumn<Disposer.Record, Boolean> p) {
                return new ButtonCellDelete();
            }
        });
        btnTransferirM.setCellFactory(
                new Callback<TableColumn<Disposer.Record, Boolean>, TableCell<Disposer.Record, Boolean>>() {
            @Override
            public TableCell<Disposer.Record, Boolean> call(TableColumn<Disposer.Record, Boolean> p) {
                return new ButtonCellShift();
            }
        });
        tbvComanda.getColumns().setAll(tbcCod, tbcDescricao, tbcQtde, tbcPreco, tbcTotal, btnCancelar, btnTransferirM);
    }

    public class ButtonCellDelete extends TableCell<Disposer.Record, Boolean> {

        JFXButton cellButton = new JFXButton("Excluir");
        Notifications notificationBuilder;
        FontAwesomeIconView auxff = new FontAwesomeIconView(FontAwesomeIcon.TRASH);

        public ButtonCellDelete() {
            auxff.setSize("2em");
            cellButton.setGraphic(auxff);
            cellButton.setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
            cellButton.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent t) {
                    // get Selected Item
                    ProdutoVenda currentPerson = (ProdutoVenda) ButtonCellDelete.this.getTableView().getItems().get(ButtonCellDelete.this.getIndex());
                    //remove selected item from the table list
                    if (currentPerson != null) {
                        // ... user chose OK
                        VendaController.getInstance().getListaProd().remove(currentPerson);

                    } else {
                        notificationBuilder = Notifications.create().title("Nenhum contato selecionado!").
                                text("Você deve selecionar um contato para editar.").
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

    public class ButtonCellShift extends TableCell<Disposer.Record, Boolean> {

        JFXButton cellButton = new JFXButton("Transferir");
        Notifications notificationBuilder;
        FontAwesomeIconView auxff = new FontAwesomeIconView(FontAwesomeIcon.ARROWS_H);

        public ButtonCellShift() {
            auxff.setSize("2em");
            cellButton.setGraphic(auxff);
            cellButton.setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
            cellButton.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent t) {
                    // get Selected Item
                    ProdutoVenda currentPerson = (ProdutoVenda) ButtonCellShift.this.getTableView().getItems().get(ButtonCellShift.this.getIndex());
                    //remove selected item from the table list
                    if (currentPerson != null) {
                        // ... user chose OK
                        VendaController.getInstance().getListaProd().remove(currentPerson);

                    } else {
                        notificationBuilder = Notifications.create().title("Nenhum contato selecionado!").
                                text("Você deve selecionar um contato para editar.").
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
