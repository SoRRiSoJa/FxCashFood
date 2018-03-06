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
import javafx.beans.value.ObservableValue;
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
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
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
public class TabFichaTecniaNFXMLController implements Initializable, GenericViewController {

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
    private Label lblCustoTotal;
    @FXML
    private TableView<ProdutoFichaTecnica> tbvFicha;
    @FXML
    private TableColumn<ProdutoFichaTecnica, String> tbcProdItem;
    @FXML
    private TableColumn<ProdutoFichaTecnica, String> tbcUnidadeItem;
    @FXML
    private TableColumn<ProdutoFichaTecnica, BigDecimal> tbcQtdeItem;
    @FXML
    private TableColumn<ProdutoFichaTecnica, BigDecimal> tbcValorItem;
    @FXML
    private TableColumn btnExcluirItem;
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
    private TableView<Produto> tbvProdutos;
    @FXML
    private TableColumn<Produto, String> tbcCodRef;
    @FXML
    private TableColumn<Produto, String> tbcDescricao;
    @FXML
    private TableColumn<Produto, String> tbcTipo;
    @FXML
    private TableColumn<Produto, BigDecimal> tbcQtde;
    @FXML
    private JFXRadioButton rbtTodos;
    @FXML
    private JFXTextField txtPesquisar;
    //---
    BigDecimal qtdeItem = BigDecimal.ZERO;
    private String erros;
    private BigDecimal custoReceita;
    private boolean flagButtons;
    private final NumberFormat nf = NumberFormat.getCurrencyInstance();
    //----
    private static TableView<ProdutoFichaTecnica> _tbvFicha;
    private static JFXComboBox<Produto> _ccbFichaTecnica;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        setUpTableView();
        setUpTableViewItens();
        setUpRadioButtons();
        loadCbbFicha();
        loadCbbUnidadeMedida();
        loadTbv();
    }

    @FXML
    private void onFichaTecnica(ActionEvent event) {
        if (ccbFichaTecnica.getSelectionModel().getSelectedItem() != null) {
            FichaTecnicaController.getInstance().setProdutoPrincipal(ccbFichaTecnica.getItems().get(ccbFichaTecnica.getSelectionModel().getSelectedIndex()));
            FichaTecnicaController.getInstance().getFichaTecnica().setProdutoPrincipal(FichaTecnicaController.getInstance().getProdutoPrincipal());
        }
    }
    public static void LDTS() {
        //_cbbUnidadeMedidaProd.setValue(PrePreparoController.getInstance().getPrePreparo().getProdutoPrincipal().getUnidadeMedida());
        
       // _tbvFicha.setItems(FichaTecnicaController.getInstance().getFichaTecnica());
        //_txtRendimento.setText(PrePreparoController.getInstance().getPrePreparo().getRendimento().toString());
        //_lblCustoTotal.setText(PrePreparoController.getInstance().getPrePreparo().getCustoTotal().toString());
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
        if (FichaTecnicaController.getInstance().getFichaTecnica().getIdFichaTecnica() != 0l) {
            Notifications notificationBuilder;
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Cofirmar Excluir FichaTecnica!");
            alert.setHeaderText("Deseja realmente Excluir?");
            alert.setContentText("Nome:(" + FichaTecnicaController.getInstance().getFichaTecnica().getProdutoPrincipal().getDescriao() + ")");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                FichaTecnicaController.getInstance().delete();
                clearFields();
                //TabListaFichaTecnicasFXMLController.loadTbvCli();
                // ... user chose OK

                notificationBuilder = Notifications.create().title("FichaTecnica excluído!").
                        text("FichaTecnica Excluido com sucesso.").
                        hideAfter(Duration.seconds(2)).
                        position(Pos.TOP_RIGHT).
                        darkStyle();
                notificationBuilder.showInformation();
            } else {
                alert.close();
            }
        }
    }

    @FXML
    private void onLimpar(ActionEvent event) {
        clearFields();
    }

    @FXML
    private void onAdicionar(ActionEvent event) {
        getDataItem();
        if (validateItemFields()) {
            FichaTecnicaController.getInstance().setItemAtual(tbvProdutos.getItems().get(tbvProdutos.getSelectionModel().getSelectedIndex()));
            FichaTecnicaController.getInstance().setListaItens(qtdeItem, ProdCalcUtil.valorPorcao(FichaTecnicaController.getInstance().getItemAtual(), FichaTecnicaController.getInstance().getUnidadeMedida(), qtdeItem));
            tbvFicha.setItems(FichaTecnicaController.getInstance().getListaItensFicha());
            lblCustoTotal.setText(nf.format(FichaTecnicaController.getInstance().getCustoTotal()));
            //--
            txtqtde.clear();
            txtPesquisar.clear();
            PrePreparoController.getInstance().setItemAtual(null);
        } else {
            PoupUpUtil.errorMessage(paneRoot, MainApp.paneRoot, erros);
            erros = "";
        }
    }

    @FXML
    private void onSelecionarProduto(MouseEvent event) {
        if (tbvProdutos.getSelectionModel().getSelectedItem() != null) {
            FichaTecnicaController.getInstance().setItemAtual(tbvProdutos.getSelectionModel().getSelectedItem());
            txtPesquisar.setText(FichaTecnicaController.getInstance().getItemAtual().getDescriao());
        }
    }

    @FXML
    private void onKeyReleasedPesquisar(KeyEvent event) {
        if (txtPesquisar.getText() != null && txtPesquisar.getText().length() > 1) {
            switch (FichaTecnicaController.getInstance().getTipoConsulta()) {
                case 1:
                    FichaTecnicaController.getInstance().buscaCodRef(txtPesquisar.getText());
                    loadTbv();
                    break;
                case 2:
                    FichaTecnicaController.getInstance().buscaInsumosDesc(txtPesquisar.getText());
                    loadTbv();
                    break;
                default:
                    FichaTecnicaController.getInstance().buscaInsumosTodos();
                    loadTbv();
                    break;
            }
        }
    }

    @Override
    public void clearFields() {
        txtPesquisar.clear();
        txtqtde.clear();
        cbbUnidadeMedida.setValue(null);
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
        Boolean flag = true;

        if (ccbFichaTecnica.getSelectionModel().getSelectedItem() == null) {
            erros += "Voce deve selecionar o produto principal da receita.\n";
            flag = false;
        }
        return flag;
    }

    public Boolean validateItemFields() {
        boolean flag = true;
        if (qtdeItem.compareTo(BigDecimal.ZERO) <= 0) {
            erros += "A quatidade do item deve ser maior que 0 \n";
            flag = false;
        }
        if (tbvProdutos.getSelectionModel().getSelectedItem() == null) {
            erros += "Você deve selecionar Um Produto para adicionar a lista \n";
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

    public void getDataItem() {
        FichaTecnicaController.getInstance().setUnidadeMedida(cbbUnidadeMedida.getItems().get(cbbUnidadeMedida.getSelectionModel().getSelectedIndex()));
        try {
            qtdeItem = new BigDecimal(txtqtde.getText());
        } catch (NumberFormatException e) {
            qtdeItem = BigDecimal.ZERO;
        }
        if (tbvProdutos.getSelectionModel().getSelectedItem() != null) {
            FichaTecnicaController.getInstance().setItemAtual(tbvProdutos.getItems().get(tbvProdutos.getSelectionModel().getSelectedIndex()));

        }
    }

    @Override
    public void loadDataToScreen() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void loadCbbFicha() {
        ccbFichaTecnica.setItems(FichaTecnicaController.getInstance().getComboBoxFichaTecnica());
    }

    private void loadCbbUnidadeMedida() {
        cbbUnidadeMedida.getItems().addAll(Arrays.asList(UnidadeMedida.values()));
    }

    private void loadTbv() {
        tbvProdutos.setItems(FichaTecnicaController.getInstance().getComboBoxItensFicha());
    }

    private void setUpRadioButtons() {

        rbtCodigo.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                rbtDescricao.setSelected(false);
                rbtTodos.setSelected(false);
                FichaTecnicaController.getInstance().setTipoConsulta(1);//todos
            }
        });
        rbtDescricao.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                rbtCodigo.setSelected(false);
                rbtTodos.setSelected(false);
                FichaTecnicaController.getInstance().setTipoConsulta(2);//todos
            }
        });

        rbtTodos.selectedProperty().addListener((ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) -> {
            if (newValue) {
                rbtCodigo.setSelected(false);
                rbtDescricao.setSelected(false);
                FichaTecnicaController.getInstance().setTipoConsulta(0);//todos
                FichaTecnicaController.getInstance().buscaInsumosTodos();
                loadTbv();
            }
        });
    }

    private void setUpTableView() {
        tbcCodRef.setCellValueFactory(new PropertyValueFactory<>("codigoReferencia"));
        tbcDescricao.setCellValueFactory(new PropertyValueFactory<>("descriao"));
        tbcTipo.setCellValueFactory(new PropertyValueFactory<>("tipo"));
        tbcQtde.setCellValueFactory(new PropertyValueFactory<>("qtdeProduto"));
        tbvProdutos.getColumns().setAll(tbcCodRef, tbcDescricao, tbcTipo, tbcQtde);
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
        tbvFicha.getColumns().setAll(tbcProdItem, tbcQtdeItem, tbcUnidadeItem, tbcValorItem, btnExcluirItem);
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
                        alert.setContentText("Produto:(" + currentPerson.getProduto().getDescriao() + ")");
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
