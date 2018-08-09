/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashf.controller.mesas;

import com.cashf.cashfood.MainApp;
import com.cashf.controller.caixa.GerenciarCaixaFXMLController;
import com.cashf.core.venda.VendaController;
import com.cashf.model.meiopagamento.MeioPagamento;
import com.cashf.model.mesa.Mesa;
import com.cashf.model.venda.ProdutoVenda;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import com.sun.prism.impl.Disposer;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import java.math.BigDecimal;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.util.Callback;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author joao
 */
public class FecharMesaFXMLController implements Initializable {

    @FXML
    private StackPane stackPane;
    @FXML
    private Pane paneRoot;
    @FXML
    private JFXComboBox<Mesa> cbbMesa;
    @FXML
    private TableView<ProdutoVenda> tbvComanda;
    @FXML
    private TableColumn<ProdutoVenda, String> tbcCod;
    @FXML
    private TableColumn<ProdutoVenda, String> tbcDescricao;
    @FXML
    private TableColumn<ProdutoVenda, BigDecimal> tbcQtde;
    @FXML
    private TableColumn<ProdutoVenda, BigDecimal> tbcPreco;
    @FXML
    private TableColumn<ProdutoVenda, BigDecimal> tbcTotal;
    @FXML
    private TableColumn btnCancelar1;
    @FXML
    private JFXComboBox<MeioPagamento> cbbMeioPagto;
    @FXML
    private JFXTextField txtValor;
    @FXML
    private JFXButton btnFechar;

    @FXML
    private Text txtTotal;
    @FXML
    private Text txtTroco;
    @FXML
    private JFXButton btnCancelar;
    //--------------
    String valorRecebido = "";
    BigDecimal vRecebido;
    BigDecimal vTroco;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        loadMeioPagamento();
        loadLIstaMesas();
        setUptableViewProdutos();
        loadTbv();
        loadData();
    }

    @FXML
    private void onMesa(ActionEvent event) {
        if (cbbMesa.getSelectionModel().getSelectedItem() != null) {
            MesaController.getInstance().setMesaAtual(cbbMesa.getItems().get(cbbMesa.getSelectionModel().getSelectedIndex()));
            VendaController.getInstance().setVenda(VendaController.getInstance().getVendaByMesa(MesaController.getInstance().getMesaAtual()));
            tbvComanda.refresh();
            loadTbv();
            loadData();
        }
    }

    @FXML
    private void onPesquisar(KeyEvent event) {
    }

    @FXML
    private void onMeioPagto(ActionEvent event) {
        if (cbbMeioPagto.getSelectionModel().getSelectedItem() != null) {
            VendaController.getInstance().setMeioPagto(cbbMeioPagto.getItems().get(cbbMeioPagto.getSelectionModel().getSelectedIndex()));
        }
    }

    @FXML
    private void onFechar(ActionEvent event) {
        MesaController.getInstance().fecharMesa();
        GerenciarCaixaFXMLController.refreshTbv();
    }

    @FXML
    private void onCancelar(ActionEvent event) {
        MainApp.janelaAberta.close();
        MainApp.janelaAberta = MainApp.janelaAnterior;
    }

    private void loadMeioPagamento() {
        cbbMeioPagto.setItems(VendaController.getInstance().getListaMeioPagto());
    }

    private void loadTbv() {
        tbvComanda.setItems(FXCollections.observableList(VendaController.getInstance().getVenda().getListaProdutos()));
    }

    private void loadLIstaMesas() {
        cbbMesa.setItems(MesaController.getInstance().getLista());
    }

    private void loadData() {
        txtTotal.setText(VendaController.getInstance().getVendaByMesa(MesaController.getInstance().getMesaAtual()).getValorTotal().toString());
    }

    private void setUptableViewProdutos() {
        tbcCod.setCellValueFactory((param) -> new SimpleStringProperty(param.getValue().getProduto().getCodigoReferencia()));
        tbcDescricao.setCellValueFactory(new PropertyValueFactory<>("produto"));
        tbcQtde.setCellValueFactory(new PropertyValueFactory<>("qtde"));
        tbcPreco.setCellValueFactory(new PropertyValueFactory<>("precoUnit"));

        tbcTotal.setCellValueFactory((param) -> new SimpleObjectProperty<>(param.getValue().getPrecoUnit().multiply(param.getValue().getQtde())));
        btnCancelar1.setCellFactory(
                new Callback<TableColumn<Disposer.Record, Boolean>, TableCell<Disposer.Record, Boolean>>() {
            @Override
            public TableCell<Disposer.Record, Boolean> call(TableColumn<Disposer.Record, Boolean> p) {
                return new ButtonCellDelete();
            }
        });

        tbvComanda.getColumns().setAll(tbcCod, tbcDescricao, tbcQtde, tbcPreco, tbcTotal, btnCancelar1);
    }

    @FXML
    private void onValorRecebido(KeyEvent event) {
        valorRecebido = txtValor.getText();
        if (event.getCode() == KeyCode.ENTER) {
            vRecebido= new BigDecimal(valorRecebido);
            vTroco=vRecebido.subtract(VendaController.getInstance().getValTotal());
            txtTroco.setText(vTroco.toString());
        }
        
    }

    public class ButtonCellDelete extends TableCell<Disposer.Record, Boolean> {

        JFXButton cellButton = new JFXButton("Excluir");
        Notifications notificationBuilder;
        FontAwesomeIconView auxff = new FontAwesomeIconView(FontAwesomeIcon.TRASH);

        public ButtonCellDelete() {
            auxff.setSize("2em");
            cellButton.setGraphic(auxff);
            cellButton.setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
            cellButton.setOnAction((ActionEvent t) -> {
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
