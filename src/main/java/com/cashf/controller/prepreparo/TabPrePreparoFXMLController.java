/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashf.controller.prepreparo;

import com.cashf.cashfood.MainApp;
import com.cashf.model.prepreparo.ProdutoPrePreparo;
import com.cashf.model.produto.Produto;
import com.cashf.model.produto.UnidadeMedida;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import com.sun.prism.impl.Disposer;
import controller.GenericViewController;
import java.math.BigDecimal;
import java.net.URL;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
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
import javafx.util.Callback;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;
import util.PoupUpUtil;
import util.ProdCalcUtil;

/**
 * FXML Controller class
 *
 * @author joao
 */
public class TabPrePreparoFXMLController implements GenericViewController, Initializable {

    @FXML
    private JFXComboBox<Produto> ccbItens;
    @FXML
    private JFXComboBox<Produto> cbbProduto;
    @FXML
    private JFXComboBox<UnidadeMedida> cbbUnidadeMedida;
    @FXML
    private JFXTextField txtqtde;
    @FXML
    private JFXButton btnAdicionar;
    @FXML
    private JFXRadioButton rbtCodigo;
    @FXML
    private JFXRadioButton rbtDescricao;
    @FXML
    private TableView<ProdutoPrePreparo> tbvItens;
    @FXML
    private TableColumn<ProdutoPrePreparo, String> tbcItem;
    @FXML
    private TableColumn<ProdutoPrePreparo, BigDecimal> tbcQtdIten;
    @FXML
    private TableColumn<ProdutoPrePreparo, String> tbcUnidadeItem;
    @FXML
    private TableColumn<ProdutoPrePreparo, BigDecimal> tbcCustoItem;
    @FXML
    private JFXButton btnExcluir;
    @FXML
    private JFXButton btnSalvar;
    @FXML
    private JFXButton btnNovo;
    @FXML
    private JFXButton btnLimpar;
    @FXML
    private JFXTextField txtRendimento;
    @FXML
    private JFXRadioButton rbtCod;
    @FXML
    private JFXRadioButton rbtDesc;
    @FXML
    private Label lblCustoTotal;
    @FXML
    private TableColumn btnExcluirItem;
    @FXML
    private Pane paneRoot;
    @FXML
    private JFXComboBox<UnidadeMedida> cbbUnidadeMedidaProd;
    @FXML
    private TableView<ProdutoPrePreparo> tbvReceita;
    @FXML
    private TableColumn<ProdutoPrePreparo, String> tbcProduto;
    @FXML
    private TableColumn<ProdutoPrePreparo, BigDecimal> tbcQtde;
    @FXML
    private TableColumn<ProdutoPrePreparo, String> tbcUnidade;
    @FXML
    private TableColumn<ProdutoPrePreparo, BigDecimal> tbcCusto;
    //-----
    //--
    private String erros;
    private BigDecimal qtdeItem;
    private String rendimento;
    private BigDecimal rendimentoReceita;
    private BigDecimal custoReceita;
    private String custoTotal;
    private boolean flagButtons;
    private NumberFormat nf = NumberFormat.getCurrencyInstance();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        loadCbbItens();
        loadCbbProdutos();
        loadCbbUnidadeMedida();
        loadCbbUnidadeMedidaProd();
        setUpTableViewItens();
        setuUpTbleViewReceita();
    }

    @FXML
    private void onAdicionar(ActionEvent event) {
        getDataItem();
        if (validateItemFields()) {

            PrePreparoController.getInstance().setItemAtual(ccbItens.getItems().get(ccbItens.getSelectionModel().getSelectedIndex()));
            PrePreparoController.getInstance().setListaItens(qtdeItem, ProdCalcUtil.valorPorcao(PrePreparoController.getInstance().getItemAtual(), PrePreparoController.getInstance().getUnidadeMedida(), qtdeItem));
            tbvItens.setItems(PrePreparoController.getInstance().getListaItens());
            tbvReceita.setItems(PrePreparoController.getInstance().getListaItens());
            lblCustoTotal.setText(nf.format(PrePreparoController.getInstance().getCustoTotal()));
            //--
            txtqtde.clear();
            ccbItens.setValue(null);
            PrePreparoController.getInstance().setItemAtual(null);

            //--
        } else {
            PoupUpUtil.errorMessage(paneRoot, MainApp.paneRoot, erros);
            erros = "";
        }
    }

    @FXML
    private void onSalvar(ActionEvent event) {
    }

    @FXML
    private void onNovo(ActionEvent event) {
    }

    @FXML
    private void onExcluir(ActionEvent event) {
    }

    @FXML
    private void onLimpar(ActionEvent event) {
        clearFields();
    }

    @Override
    public void clearFields() {
        txtRendimento.clear();
        txtqtde.clear();
        ccbItens.setValue(null);
        cbbUnidadeMedida.setValue(null);
        cbbProduto.setValue(null);
    }

    @Override
    public void setInputOff() {

    }

    @Override
    public void setInputOn() {

    }

    @Override
    public Boolean validateFields() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void getData() {
        rendimento = txtRendimento.getText();
        PrePreparoController.getInstance().setProdutoPrincipal(cbbProduto.getSelectionModel().getSelectedItem());
    }

    public void getDataItem() {
        PrePreparoController.getInstance().setUnidadeMedida(cbbUnidadeMedida.getItems().get(cbbUnidadeMedida.getSelectionModel().getSelectedIndex()));
        try {
            qtdeItem = new BigDecimal(txtqtde.getText());
        } catch (NumberFormatException e) {
            qtdeItem = BigDecimal.ZERO;
        }
        if (ccbItens.getSelectionModel().getSelectedItem() != null) {
            PrePreparoController.getInstance().setItemAtual(ccbItens.getItems().get(ccbItens.getSelectionModel().getSelectedIndex()));
        }
    }

    public Boolean validateItemFields() {
        boolean flag = true;

        if (qtdeItem.compareTo(BigDecimal.ZERO) <= 0) {
            erros += "a quatidade do item deve ser maior que 0 \n";
            flag = false;
        }

        return flag;
    }

    @Override
    public void loadDataToScreen() {

    }

    private void loadCbbUnidadeMedida() {
        cbbUnidadeMedida.getItems().addAll(Arrays.asList(UnidadeMedida.values()));
    }

    private void loadCbbUnidadeMedidaProd() {
        cbbUnidadeMedidaProd.getItems().addAll(Arrays.asList(UnidadeMedida.values()));
    }

    private void loadCbbProdutos() {
        cbbProduto.setItems(PrePreparoController.getInstance().getListaPrePreparo());
    }

    private void loadCbbItens() {
        ccbItens.setItems(PrePreparoController.getInstance().getListaProduto());
    }

    private void loadTbvReceita() {
        tbvReceita.setItems(PrePreparoController.getInstance().getListaItens());
    }

    private void setuUpTbleViewReceita() {
        tbcProduto.setCellValueFactory(new PropertyValueFactory<>("produto"));
        tbcQtde.setCellValueFactory(new PropertyValueFactory<>("qtdeProduto"));
        tbcUnidade.setCellValueFactory(new PropertyValueFactory<>("unidadeMedida"));
        tbcCusto.setCellValueFactory(new PropertyValueFactory<>("valorPorcao"));
        tbvReceita.getColumns().setAll(tbcProduto, tbcQtde, tbcUnidade, tbcCusto);
    }

    private void setUpTableViewItens() {
        tbcItem.setCellValueFactory(new PropertyValueFactory<>("produto"));
        tbcQtdIten.setCellValueFactory(new PropertyValueFactory<>("qtdeProduto"));
        tbcUnidadeItem.setCellValueFactory(new PropertyValueFactory<>("unidadeMedida"));
        tbcCustoItem.setCellValueFactory(new PropertyValueFactory<>("valorPorcao"));
        btnExcluirItem.setCellFactory(
                new Callback<TableColumn<Disposer.Record, Boolean>, TableCell<Disposer.Record, Boolean>>() {
            @Override
            public TableCell<Disposer.Record, Boolean> call(TableColumn<Disposer.Record, Boolean> p) {
                return new ButtonCellDelete();
            }
        });
        tbvItens.getColumns().setAll(tbcItem, tbcQtdIten, tbcUnidadeItem, tbcCustoItem, btnExcluirItem);
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
            cellButton.setOnAction((ActionEvent t) -> {
                // get Selected Item
                ProdutoPrePreparo currentPerson = (ProdutoPrePreparo) ButtonCellDelete.this.getTableView().getItems().get(ButtonCellDelete.this.getIndex());
                //remove selected item from the table list
                if (currentPerson != null) {
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("Cofirmar Excluir Item da Lista!");
                    alert.setHeaderText("Deseja realmente Excluir?");
                    alert.setContentText("Produto:(" + currentPerson.getProduto().getDescriao() + ")");
                    Optional<ButtonType> result = alert.showAndWait();
                    if (result.get() == ButtonType.OK) {
                        // ... user chose OK
                        PrePreparoController.getInstance().getListaItens().remove(currentPerson);
                        lblCustoTotal.setText(nf.format(PrePreparoController.getInstance().getCustoTotal()));
                        notificationBuilder = Notifications.create().title("Produto excluído!").
                                text("Produto Excluido com sucesso.").
                                hideAfter(Duration.seconds(2)).
                                position(Pos.TOP_RIGHT).
                                darkStyle();
                        notificationBuilder.showInformation();
                    } else {
                        alert.close();
                    }
                } else {
                    notificationBuilder = Notifications.create().title("Nenhum item selecionado!").
                            text("Você deve selecionar Um produto para Cancelar.").
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
