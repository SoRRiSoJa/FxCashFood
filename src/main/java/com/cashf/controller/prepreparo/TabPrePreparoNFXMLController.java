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
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
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
public class TabPrePreparoNFXMLController implements GenericViewController, Initializable {

    @FXML
    private Pane paneRoot;
    @FXML
    private JFXComboBox<Produto> cbbProduto;
    @FXML
    private JFXComboBox<UnidadeMedida> cbbUnidadeMedidaProd;
    @FXML
    private JFXTextField txtRendimento;
    @FXML
    private JFXButton btnSalvar;
    @FXML
    private JFXButton btnNovo;
    @FXML
    private JFXButton btnExcluir;
    @FXML
    private JFXButton btnLimpar;
    @FXML
    private JFXRadioButton rbtCod;
    @FXML
    private JFXRadioButton rbtDesc;
    @FXML
    private Label lblCustoTotal;
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
    private JFXTextField txtPesquisar;
    @FXML
    private JFXRadioButton rbtTodos;
    //-----
    private static JFXComboBox<Produto> _cbbItens;
    private static JFXComboBox<Produto> _cbbProduto;
    private static JFXComboBox<UnidadeMedida> _cbbUnidadeMedida;
    private static JFXTextField _txtqtde;
    private static JFXButton _btnAdicionar;
    private static JFXRadioButton _rbtCodigo;
    private static JFXRadioButton _rbtDescricao;
    private static TableView<ProdutoPrePreparo> _tbvItens;
    private static JFXButton _btnExcluir;
    private static JFXButton _btnSalvar;
    private static JFXButton _btnNovo;
    private static JFXButton _btnLimpar;
    private static JFXTextField _txtRendimento;
    private static JFXRadioButton _rbtCod;
    private static JFXRadioButton _rbtDesc;
    private static Label _lblCustoTotal;
    private static TableColumn _btnExcluirItem;
    private static JFXComboBox<UnidadeMedida> _cbbUnidadeMedidaProd;
    private static TableView<ProdutoPrePreparo> _tbvReceita;
    //--
    private String erros;
    private String pesquisa;
    private BigDecimal qtdeItem;
    private BigDecimal rendimentoReceita;
    private BigDecimal custoReceita;
    private boolean flagButtons;
    private NumberFormat nf = NumberFormat.getCurrencyInstance();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        _cbbUnidadeMedida = cbbUnidadeMedida;
        _txtqtde = txtqtde;
        _rbtCodigo = rbtCodigo;
        _rbtDescricao = rbtDescricao;
        _btnExcluir = btnExcluir;
        _btnSalvar = btnSalvar;
        _btnNovo = btnNovo;
        _btnLimpar = btnLimpar;
        _txtRendimento = txtRendimento;
        _rbtCod = rbtCod;
        _rbtDesc = rbtDesc;
        _lblCustoTotal = lblCustoTotal;
        _btnExcluirItem = _btnExcluirItem;
        _tbvReceita = tbvItens;
        loadCbbProdutos();
        loadCbbUnidadeMedida();
        loadCbbUnidadeMedidaProd();
        setUpTableViewItens();
        setUpTableView();
        setUpRadioButtons();
        loadTbv();
    }

    @FXML
    private void onSelecionarProdPrincipal(ActionEvent event) {
        if (cbbProduto.getSelectionModel().getSelectedItem() != null) {
            PrePreparoController.getInstance().setProdutoPrincipal(cbbProduto.getItems().get(cbbProduto.getSelectionModel().getSelectedIndex()));
            PrePreparoController.getInstance().getPrePreparo().setProdutoPrincipal(cbbProduto.getItems().get(cbbProduto.getSelectionModel().getSelectedIndex()));
        }
    }

    @FXML
    private void onSalvar(ActionEvent event) {
        getData();
        if (validateFields()) {
            PrePreparoController.getInstance().setPrePreparo(0l,
                    PrePreparoController.getInstance().getProdutoPrincipal(),
                    LocalDate.now(),
                    rendimentoReceita,
                    PrePreparoController.getInstance().getCustoTotal(),
                    PrePreparoController.getInstance().getListaItens(),
                    true);

            PrePreparoController.getInstance().insert();
            PoupUpUtil.poupUp("Pré-Preparo Cadastrado", "O Pré-Preparo foi cadastrado com sucesso.", "");
            PrePreparoController.getInstance().flushObject();
        } else {
            PoupUpUtil.errorMessage(paneRoot, MainApp.paneRoot, erros);
            erros = "";
        }
    }

    @FXML
    private void onNovo(ActionEvent event) {
        setInputOn();
        clearFields();
    }

    @FXML
    private void onExcluir(ActionEvent event) {
        if (PrePreparoController.getInstance().getPrePreparo().getIdPrepreparo()!= 0l) {
            Notifications notificationBuilder;
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Cofirmar Excluir PrePreparo!");
            alert.setHeaderText("Deseja realmente Excluir?");
            alert.setContentText("Nome:(" + PrePreparoController.getInstance().getPrePreparo().getProdutoPrincipal().getDescriao() + ")");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                PrePreparoController.getInstance().delete();
                clearFields();
                //TabListaPrePreparosFXMLController.loadTbvCli();
                // ... user chose OK

                notificationBuilder = Notifications.create().title("PrePreparo excluído!").
                        text("PrePreparo Excluido com sucesso.").
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
            PrePreparoController.getInstance().setItemAtual(tbvProdutos.getSelectionModel().getSelectedItem());
            PrePreparoController.getInstance().setListaItens(qtdeItem, ProdCalcUtil.valorPorcao(PrePreparoController.getInstance().getItemAtual(), PrePreparoController.getInstance().getUnidadeMedida(), qtdeItem));
            tbvItens.setItems(PrePreparoController.getInstance().getListaItens());
            lblCustoTotal.setText(nf.format(PrePreparoController.getInstance().getCustoTotal()));
            //--
            txtqtde.clear();
            PrePreparoController.getInstance().setItemAtual(null);
            //--
        } else {
            PoupUpUtil.errorMessage(paneRoot, MainApp.paneRoot, erros);
            erros = "";
        }
    }

    @FXML
    private void onSelecionarProduto(MouseEvent event) {
        if (tbvProdutos.getSelectionModel().getSelectedItem() != null) {
            PrePreparoController.getInstance().setItemAtual(tbvProdutos.getSelectionModel().getSelectedItem());
            txtPesquisar.setText(PrePreparoController.getInstance().getItemAtual().getDescriao());
        }
    }

    @FXML
    private void onKeyReleasedPesquisar(KeyEvent event) {
        if (txtPesquisar.getText() != null && txtPesquisar.getText().length() > 1) {
            switch (PrePreparoController.getInstance().getTipoConsulta()) {
                case 1:
                    PrePreparoController.getInstance().buscaCodRef(txtPesquisar.getText());
                    loadTbv();
                    break;
                case 2:
                    PrePreparoController.getInstance().buscaInsumosDesc(txtPesquisar.getText());
                    loadTbv();
                    break;
                default:
                    PrePreparoController.getInstance().buscaInsumosTodos();
                    loadTbv();
                    break;
            }
        }
    }

    @Override
    public void clearFields() {
        txtPesquisar.clear();
        txtRendimento.clear();
        txtqtde.clear();
        cbbUnidadeMedidaProd.setValue(null);
        cbbUnidadeMedida.setValue(null);
        cbbProduto.setValue(null);
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
        if (txtRendimento.getText().isEmpty()) {
            erros += "O Rendimento da receita deve ser Informado.\n";
            flag = false;
        }
        if (cbbProduto.getSelectionModel().getSelectedItem() == null) {
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
        try {
            rendimentoReceita = new BigDecimal(txtRendimento.getText());
        } catch (NumberFormatException e) {
            rendimentoReceita = BigDecimal.ZERO;
        }
        if (cbbProduto.getSelectionModel().getSelectedItem() != null) {
            PrePreparoController.getInstance().setProdutoPrincipal(cbbProduto.getItems().get(cbbProduto.getSelectionModel().getSelectedIndex()));
        }
    }

    public void getDataItem() {
        PrePreparoController.getInstance().setUnidadeMedida(cbbUnidadeMedida.getItems().get(cbbUnidadeMedida.getSelectionModel().getSelectedIndex()));
        try {
            qtdeItem = new BigDecimal(txtqtde.getText());
        } catch (NumberFormatException e) {
            qtdeItem = BigDecimal.ZERO;
        }
        if (tbvProdutos.getSelectionModel().getSelectedItem() != null) {
            PrePreparoController.getInstance().setItemAtual(tbvProdutos.getItems().get(tbvProdutos.getSelectionModel().getSelectedIndex()));
        }
    }

    @Override
    public void loadDataToScreen() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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

    private void setUpTableView() {
        tbcCodRef.setCellValueFactory(new PropertyValueFactory<>("codigoReferencia"));
        tbcDescricao.setCellValueFactory(new PropertyValueFactory<>("descriao"));
        tbcTipo.setCellValueFactory(new PropertyValueFactory<>("tipo"));
        tbcQtde.setCellValueFactory(new PropertyValueFactory<>("qtdeProduto"));
        tbvProdutos.getColumns().setAll(tbcCodRef, tbcDescricao, tbcTipo, tbcQtde);
    }

    private void setUpRadioButtons() {

        rbtCodigo.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                rbtDescricao.setSelected(false);
                rbtTodos.setSelected(false);
                PrePreparoController.getInstance().setTipoConsulta(1);//todos
            }
        });
        rbtDescricao.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                rbtCodigo.setSelected(false);
                rbtTodos.setSelected(false);
                PrePreparoController.getInstance().setTipoConsulta(2);//todos
            }
        });

        rbtTodos.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                rbtCodigo.setSelected(false);
                rbtDescricao.setSelected(false);
                PrePreparoController.getInstance().setTipoConsulta(0);//todos
                PrePreparoController.getInstance().buscaInsumosTodos();
                PrePreparoController.getInstance().buscaInsumosTodos();
                loadTbv();
            }
        });
    }

    public static void LDTS() {
        _cbbUnidadeMedida.setValue(PrePreparoController.getInstance().getPrePreparo().getProdutoPrincipal().getUnidadeMedida());
        _txtqtde.setText(PrePreparoController.getInstance().getProdutoPrincipal().getQtdeProduto().toString());
        _tbvItens.setItems(FXCollections.observableList(PrePreparoController.getInstance().getPrePreparo().getListaProdutos()));
        _txtRendimento.setText(PrePreparoController.getInstance().getPrePreparo().getRendimento().toString());
        _lblCustoTotal.setText(PrePreparoController.getInstance().getPrePreparo().getCustoTotal().toString());
    }

    private void loadTbv() {
        tbvProdutos.setItems(PrePreparoController.getInstance().getListaProduto());
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
                                hideAfter(Duration.seconds(1)).
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
