/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashf.controller.fichatecnica;

import com.cashf.cashfood.MainApp;
import com.cashf.controller.prepreparo.PrePreparoController;
import com.cashf.model.fichatecnica.ProdutoFichaTecnica;
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
import javafx.event.EventHandler;
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
public class TabFichaTecnicaFXMLController implements Initializable, GenericViewController {

    @FXML
    private Pane paneRoot;
    @FXML
    private JFXComboBox<Produto> ccbFichaTecnica;
    @FXML
    private JFXButton btnSalvar;
    @FXML
    private JFXButton btnNovo;
    @FXML
    private JFXButton btnExcluir;
    @FXML
    private JFXButton btnLimpar;
    @FXML
    private TableView<ProdutoFichaTecnica> tbvFicha;
    @FXML
    private TableColumn<ProdutoFichaTecnica, String> tbcProduto;
    @FXML
    private TableColumn<ProdutoFichaTecnica, UnidadeMedida> tbcUnidade;
    @FXML
    private TableColumn<ProdutoFichaTecnica, BigDecimal> tbcQtde;
    @FXML
    private TableColumn<ProdutoFichaTecnica, BigDecimal> tbcValor;
    @FXML
    private Label lblCustoTotal;
    @FXML
    private JFXComboBox<Produto> ccbItens;
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
    private TableView<ProdutoFichaTecnica> tbvFichaItens;
    @FXML
    private TableColumn<ProdutoFichaTecnica, String> tbcProdItem;
    @FXML
    private TableColumn<ProdutoFichaTecnica, UnidadeMedida> tbcUnidadeItem;
    @FXML
    private TableColumn<ProdutoFichaTecnica, BigDecimal> tbcQtdeItem;
    @FXML
    private TableColumn<ProdutoFichaTecnica, BigDecimal> tbcValorItem;
    @FXML
    private TableColumn btnExcluirItem;
    //---
    BigDecimal qtdeItem = BigDecimal.ZERO;
    private String erros;
    private BigDecimal custoReceita;
    private boolean flagButtons;
    private NumberFormat nf = NumberFormat.getCurrencyInstance();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        loadCbbUnidadeMedida();
        loadCbbFicha();
        loadCbbItens();
        setUpTableViewItens();
        setuUpTbleViewFicha();
    }

    @FXML
    private void onFichaTecnica(ActionEvent event) {
        if (ccbFichaTecnica.getSelectionModel().getSelectedItem() != null) {
            FichaTecnicaController.getInstance().setProdutoPrincipal(ccbFichaTecnica.getItems().get(ccbFichaTecnica.getSelectionModel().getSelectedIndex()));
            FichaTecnicaController.getInstance().getFichaTecnica().setProdutoPrincipal(FichaTecnicaController.getInstance().getProdutoPrincipal());
        }
    }

    @FXML
    private void onSalvar(ActionEvent event) {
        getData();
        if (validateFields()) {
            FichaTecnicaController.getInstance().setFichaTecnica(0l, FichaTecnicaController.getInstance().getProdutoPrincipal(), Boolean.TRUE);
            FichaTecnicaController.getInstance().insert();
            PoupUpUtil.poupUp("Ficha Técnica Cadastrada", "A Ficha Técnica foi cadastrada com sucesso.", "");
            FichaTecnicaController.getInstance().flushObject();
        } else {
            PoupUpUtil.errorMessage(paneRoot, MainApp.paneRoot, erros);
            erros = "";
        }
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

    @FXML
    private void onAdicionar(ActionEvent event) {
        getDataItem();
        if (validateItemFields()) {
            FichaTecnicaController.getInstance().setItemAtual(ccbItens.getItems().get(ccbItens.getSelectionModel().getSelectedIndex()));
            FichaTecnicaController.getInstance().setListaItens(qtdeItem, ProdCalcUtil.valorPorcao(FichaTecnicaController.getInstance().getItemAtual(), FichaTecnicaController.getInstance().getUnidadeMedida(), qtdeItem));
            tbvFichaItens.setItems(FichaTecnicaController.getInstance().getListaItensFicha());
            tbvFicha.setItems(FichaTecnicaController.getInstance().getListaItensFicha());
            lblCustoTotal.setText(nf.format(FichaTecnicaController.getInstance().getCustoTotal()));
            //--
            txtqtde.clear();
            ccbItens.setValue(null);
            PrePreparoController.getInstance().setItemAtual(null);
        } else {
            PoupUpUtil.errorMessage(paneRoot, MainApp.paneRoot, erros);
            erros = "";
        }
    }

    public Boolean validateItemFields() {
        boolean flag = true;
        if (qtdeItem.compareTo(BigDecimal.ZERO) <= 0) {
            erros += "A quatidade do item deve ser maior que 0 \n";
            flag = false;
        }
        if (ccbItens.getSelectionModel().getSelectedItem() == null) {
            erros += "Você deve selecionar Um Produto para adicionar a lista \n";
            flag = false;
        }

        return flag;
    }

    public void getDataItem() {
        FichaTecnicaController.getInstance().setUnidadeMedida(cbbUnidadeMedida.getItems().get(cbbUnidadeMedida.getSelectionModel().getSelectedIndex()));
        try {
            qtdeItem = new BigDecimal(txtqtde.getText());
        } catch (NumberFormatException e) {
            qtdeItem = BigDecimal.ZERO;
        }
        if (ccbItens.getSelectionModel().getSelectedItem() != null) {
            FichaTecnicaController.getInstance().setItemAtual(ccbItens.getItems().get(ccbItens.getSelectionModel().getSelectedIndex()));

        }
    }

    @Override
    public void clearFields() {
        txtqtde.clear();
        ccbItens.setValue(null);
        cbbUnidadeMedida.setValue(null);
        ccbFichaTecnica.setValue(null);
    }

    @Override
    public void setInputOff() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setInputOn() {

    }

    @Override
    public Boolean validateFields() {
        Boolean flag = true;

        if (ccbFichaTecnica.getSelectionModel().getSelectedItem() == null) {
            erros += "Voce deve selecionar o produto principal da receita.\n";
            flag = false;
        }
        return flag;
    }

    @Override
    public void getData() {
        if (ccbFichaTecnica.getSelectionModel().getSelectedItem() != null) {
            FichaTecnicaController.getInstance().setProdutoPrincipal(ccbFichaTecnica.getItems().get(ccbFichaTecnica.getSelectionModel().getSelectedIndex()));

        }

    }

    @Override
    public void loadDataToScreen() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void loadCbbItens() {
        ccbItens.setItems(FichaTecnicaController.getInstance().getComboBoxItensFicha());
    }

    private void loadCbbFicha() {
        ccbFichaTecnica.setItems(FichaTecnicaController.getInstance().getComboBoxFichaTecnica());
    }

    private void loadCbbUnidadeMedida() {
        cbbUnidadeMedida.getItems().addAll(Arrays.asList(UnidadeMedida.values()));
    }

    private void setuUpTbleViewFicha() {
        tbcProduto.setCellValueFactory(new PropertyValueFactory<>("produto"));
        tbcQtde.setCellValueFactory(new PropertyValueFactory<>("qtdeProduto"));
        tbcUnidade.setCellValueFactory(new PropertyValueFactory<>("unidadeMedida"));
        tbcValor.setCellValueFactory(new PropertyValueFactory<>("valorPorcao"));
        tbvFicha.getColumns().setAll(tbcProduto, tbcQtde, tbcUnidade, tbcValor);
    }

    private void setUpTableViewItens() {
        tbcProdItem.setCellValueFactory(new PropertyValueFactory<>("produto"));
        tbcQtdeItem.setCellValueFactory(new PropertyValueFactory<>("qtdeProduto"));
        tbcUnidadeItem.setCellValueFactory(new PropertyValueFactory<>("unidadeMedida"));
        tbcValorItem.setCellValueFactory(new PropertyValueFactory<>("valorPorcao"));
        btnExcluirItem.setCellFactory(
                new Callback<TableColumn<Disposer.Record, Boolean>, TableCell<Disposer.Record, Boolean>>() {
            @Override
            public TableCell<Disposer.Record, Boolean> call(TableColumn<Disposer.Record, Boolean> p) {
                return new ButtonCellDelete();
            }
        });
        tbvFichaItens.getColumns().setAll(tbcProdItem, tbcQtdeItem, tbcUnidadeItem, tbcValorItem, btnExcluirItem);
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
                    ProdutoFichaTecnica currentPerson = (ProdutoFichaTecnica) ButtonCellDelete.this.getTableView().getItems().get(ButtonCellDelete.this.getIndex());
                    //remove selected item from the table list
                    if (currentPerson != null) {

                        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                        alert.setTitle("Cofirmar Excluir Produto da lista!");
                        alert.setHeaderText("Deseja realmente Excluir?");
                        alert.setContentText("Produto:(" + currentPerson.getFichaTecnica().getProdutoPrincipal().getDescriao() + ")");
                        Optional<ButtonType> result = alert.showAndWait();
                        if (result.get() == ButtonType.OK) {
                            // ... user chose OK
                            FichaTecnicaController.getInstance().getListaItensFicha().remove(currentPerson);
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
                        notificationBuilder = Notifications.create().title("Nenhum item selecionado!").
                                text("Você deve selecionar um produto da lista para remover.").
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
