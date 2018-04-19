/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashf.controller.combos;

import com.cashf.cashfood.MainApp;
import com.cashf.model.combo.Combo;
import com.cashf.model.combo.ProdutoCombo;
import com.cashf.model.produto.Produto;
import com.cashf.model.produto.UnidadeMedida;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import com.sun.prism.impl.Disposer;
import controller.GenericViewController;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import java.math.BigDecimal;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.util.Callback;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;
import util.PoupUpUtil;

/**
 * FXML Controller class
 *
 * @author joao
 */
public class TabComboFXMLController implements GenericViewController, Initializable {

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
    @FXML
    private JFXComboBox<Produto> cbbProduto;
    @FXML
    private JFXTextField txtValVenda;
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
    private TableView<ProdutoCombo> tbvItens;
    @FXML
    private TableColumn<ProdutoCombo, Produto> tbcItem;
    @FXML
    private TableColumn<ProdutoCombo, BigDecimal> tbcQtdIten;
    @FXML
    private TableColumn<ProdutoCombo, BigDecimal> tbcCustoItem;
    @FXML
    private TableColumn<ProdutoCombo, Integer> tbcEtapa;
    @FXML
    private TableColumn btnExcluirItem;
    @FXML
    private JFXTextField txtValCusto;
    //-----
    private String erros;
    private boolean flagButtons;
    private BigDecimal precoCusto;
    private BigDecimal precoVenda;
    private BigDecimal qtde;
    private BigDecimal valDif;
    private boolean difVal;
    private static TableView<ProdutoCombo> _tbvItens;
    private static JFXComboBox<Produto> _cbbProduto;
    private static JFXTextField _txtValCusto;
    private static JFXTextField _txtValVenda;
    @FXML
    private Pane paneRoot;
    @FXML
    private Text txtEtapa;
    @FXML
    private JFXRadioButton rbtGrupo;
    @FXML
    private JFXButton btnFinalizarEtapa;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        _tbvItens = tbvItens;
        _cbbProduto = cbbProduto;
        _txtValCusto = txtValCusto;
        _txtValVenda = txtValVenda;
        setUpTableView();
        setUptableViewItens();
        setUpRadioButtons();
        loadTbvProdutos();
        loadCbb();
        loadEtapa();

    }

    @FXML
    private void onAdicionar(ActionEvent event) {
        getDataItem();
        if (validateFieldsProdutoCombo()) {
            ComboController.getInstance().setItemAtual(tbvProdutos.getItems().get(tbvProdutos.getSelectionModel().getSelectedIndex()));
            ComboController.getInstance().setListaProdutosCombo(0l,
                    ComboController.getInstance().getCombo(),
                    ComboController.getInstance().getItemAtual(),
                    UnidadeMedida.UN,
                    qtde,
                    valDif,
                    difVal,
                    ComboController.getInstance().getEtapa());
            tbvItens.setItems(ComboController.getInstance().getListaProdutosCombo());
            ComboController.getInstance().setItemAtual(null);
            txtPesquisar.clear();
            txtqtde.clear();
        } else {
            PoupUpUtil.errorMessage(paneRoot, MainApp.paneRoot, erros);
            erros = "";
        }
    }

    @FXML
    private void onSelecionarProduto(MouseEvent event) {
        if (tbvProdutos.getSelectionModel().getSelectedItem() != null) {
            ComboController.getInstance().setItemAtual(tbvProdutos.getItems().get(tbvProdutos.getSelectionModel().getSelectedIndex()));
            txtPesquisar.setText(ComboController.getInstance().getItemAtual().getDescriao());
        }

    }

    @FXML
    private void onKeyReleasedPesquisar(KeyEvent event) {
        if (txtPesquisar.getText() != null && txtPesquisar.getText().length() > 1) {
            switch (ComboController.getInstance().getTipoConsulta()) {
                case 1:
                    ComboController.getInstance().buscaComboCodRef(txtPesquisar.getText());
                    tbvProdutos.refresh();
                    break;
                case 2:
                    ComboController.getInstance().buscaComboDesc(txtPesquisar.getText());
                    tbvProdutos.refresh();
                    // loadTbv();
                    break;
                default:
                    ComboController.getInstance().buscaComboTodos();
                    tbvProdutos.refresh();
                    break;
            }
        }
    }

    @FXML
    private void onSelecionarProdPrincipal(ActionEvent event) {
        if (cbbProduto.getSelectionModel().getSelectedItem() != null) {
            ComboController.getInstance().setProdutoPrincipal(cbbProduto.getItems().get(cbbProduto.getSelectionModel().getSelectedIndex()));
        }
    }

    @FXML
    private void onSalvar(ActionEvent event) {
        getData();
        if (validateFields()) {
            ComboController.getInstance().setCombo(0,
                    ComboController.getInstance().getProdutoPrincipal(),
                    precoCusto,
                    precoVenda,
                    difVal,
                    ComboController.getInstance().getListaProdutosCombo());
            ComboController.getInstance().insert();

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
    }

    @FXML
    private void onFinalizarEtapa(ActionEvent event) {

        if (ComboController.getInstance().getTotalEtapa(ComboController.getInstance().getEtapa()) == 0) {
            erros = "Adicione produtos antes de finalizar uma etapa.";
            PoupUpUtil.errorMessage(paneRoot, MainApp.paneRoot, erros);
            erros = "";
        } else {
            ComboController.getInstance().setEtapa(ComboController.getInstance().getEtapa() + 1);
            loadEtapa();
        }

    }

    @Override
    public void clearFields() {
        txtPesquisar.clear();
        txtValCusto.clear();
        txtValVenda.clear();
        txtqtde.clear();
        cbbProduto.setValue(null);
    }

    @Override
    public void setInputOff() {
        txtPesquisar.setDisable(true);
        txtValCusto.setDisable(true);
        txtValVenda.setDisable(true);
        txtqtde.setDisable(true);
        cbbProduto.setDisable(true);
        btnAdicionar.setDisable(true);
        btnExcluir.setDisable(true);
        btnLimpar.setDisable(true);
        btnSalvar.setDisable(true);
    }

    @Override
    public void setInputOn() {
        txtPesquisar.setDisable(false);
        txtValCusto.setDisable(false);
        txtValVenda.setDisable(false);
        txtqtde.setDisable(false);
        cbbProduto.setDisable(false);
        btnAdicionar.setDisable(false);
        btnExcluir.setDisable(false);
        btnLimpar.setDisable(false);
        btnSalvar.setDisable(false);
    }

    public Boolean validateFieldsProdutoCombo() {
        boolean flag = true;
        if (cbbProduto.getSelectionModel().getSelectedItem() == null) {
            erros += "Um produto deve ser selecionado como Produto Principal.";
            flag = false;
        }

        if (qtde == null || qtde.compareTo(BigDecimal.ZERO) <= 0) {
            erros += "A quantidade deve ser maior que 0";
            flag = false;
        }
        if (tbvProdutos.getSelectionModel().getSelectedItem() == null) {
            erros += "Selecione um Produto  para compor os ítens deste combo.";
            flag = false;
        }
        return flag;
    }

    @Override
    public Boolean validateFields() {
        boolean flag = true;
        if (precoCusto == null || precoCusto.compareTo(BigDecimal.ZERO) < 0) {
            erros += "O valor de custo deve ser maior ou igual a 0";
            flag = false;
        }
        if (precoVenda == null || precoVenda.compareTo(BigDecimal.ZERO) <= 0) {
            erros += "O valor de venda deve ser maior que 0.";
            flag = false;
        }
        if (cbbProduto.getSelectionModel().getSelectedItem() == null) {
            erros += "Um produto deve ser selecionado como Produto Principal.";
            flag = false;
        }

        return flag;
    }

    public void getDataItem() {
        try {
            qtde = new BigDecimal(txtqtde.getText());
        } catch (Exception ex) {
            System.out.println("Erro ao converter:" + ex);
        }
        if (tbvProdutos.getSelectionModel().getSelectedItem() != null) {
            ComboController.getInstance().setItemAtual(tbvProdutos.getItems().get(tbvProdutos.getSelectionModel().getSelectedIndex()));
        }
        if (cbbProduto.getSelectionModel().getSelectedItem() != null) {
            if (ComboController.getInstance().getProdutoPrincipal().getIdProduto() == 0l) {
                ComboController.getInstance().setProdutoPrincipal(cbbProduto.getItems().get(cbbProduto.getSelectionModel().getSelectedIndex()));
            }
        }

    }

    @Override
    public void getData() {
        try {
            precoCusto = new BigDecimal(txtValCusto.getText());
        } catch (Exception ex) {
            System.out.println("Erro ao converter:" + ex);
        }
        try {
            precoVenda = new BigDecimal(txtValVenda.getText());
        } catch (Exception ex) {
            System.out.println("Erro ao converter:" + ex);
        }
        if (cbbProduto.getSelectionModel().getSelectedItem() != null) {
            ComboController.getInstance().setProdutoPrincipal(cbbProduto.getItems().get(cbbProduto.getSelectionModel().getSelectedIndex()));
        }
    }

    @Override
    public void loadDataToScreen() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static void LDTS() {
        _tbvItens.setItems(ComboController.getInstance().getListaProdutosCombo());
        _cbbProduto.getSelectionModel().select(ComboController.getInstance().getCombo().getProdutoPrincipal());
        _txtValCusto.setText(ComboController.getInstance().getCombo().getCustoTotal().toString());
        _txtValVenda.setText(ComboController.getInstance().getCombo().getValorVenda().toString());
    }

    private void setUpRadioButtons() {

        rbtCodigo.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                rbtDescricao.setSelected(false);
                rbtGrupo.setSelected(false);
                rbtTodos.setSelected(false);
                ComboController.getInstance().setTipoConsulta(1);//todos
                loadTbvProdutos();
            }
        });
        rbtDescricao.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                rbtCodigo.setSelected(false);
                rbtGrupo.setSelected(false);
                rbtTodos.setSelected(false);
                ComboController.getInstance().setTipoConsulta(2);//todos
                loadTbvProdutos();
            }
        });
        rbtGrupo.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                rbtCodigo.setSelected(false);
                rbtDescricao.setSelected(false);
                rbtTodos.setSelected(false);
                ComboController.getInstance().setTipoConsulta(3);//todos
                loadTbvProdutos();
            }
        });

        rbtTodos.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                rbtCodigo.setSelected(false);
                rbtDescricao.setSelected(false);
                rbtGrupo.setSelected(false);
                ComboController.getInstance().setTipoConsulta(0);//todos
                loadTbvProdutos();
            }
        });
    }

    private void loadTbvProdutos() {
        tbvProdutos.setItems(ComboController.getInstance().getListaProdutos());
    }

    private void setUpTableView() {
        tbcCodRef.setCellValueFactory(new PropertyValueFactory<>("codigoReferencia"));
        tbcDescricao.setCellValueFactory(new PropertyValueFactory<>("descriao"));
        tbcTipo.setCellValueFactory(new PropertyValueFactory<>("tipo"));
        tbcQtde.setCellValueFactory(new PropertyValueFactory<>("grupo"));
        tbvProdutos.getColumns().setAll(tbcCodRef, tbcDescricao, tbcTipo, tbcQtde);
    }

    private void setUptableViewItens() {
        tbcItem.setCellValueFactory(new PropertyValueFactory<>("produto"));
        tbcQtdIten.setCellValueFactory(new PropertyValueFactory<>("qtdeProduto"));
        tbcEtapa.setCellValueFactory(new PropertyValueFactory<>("etapa"));
        tbcCustoItem.setCellValueFactory(new PropertyValueFactory<>("valorDiferenciado"));
        btnExcluirItem.setCellFactory(
                new Callback<TableColumn<Disposer.Record, Boolean>, TableCell<Disposer.Record, Boolean>>() {
            @Override
            public TableCell<Disposer.Record, Boolean> call(TableColumn<Disposer.Record, Boolean> p) {
                return new ButtonCellDelete();
            }
        });
        tbvItens.getColumns().setAll(tbcItem, tbcQtdIten, tbcEtapa, tbcCustoItem, btnExcluirItem);
    }

    private void loadCbb() {
        cbbProduto.setItems(ComboController.getInstance().getListaCbb());
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
                    ProdutoCombo currentPerson = (ProdutoCombo) ButtonCellDelete.this.getTableView().getItems().get(ButtonCellDelete.this.getIndex());
                    //remove selected item from the table list
                    if (currentPerson != null) {
                        // ... user chose OK
                        ComboController.getInstance().getListaProdutosCombo().remove(currentPerson);

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

    private void loadEtapa() {
        txtEtapa.setText(ComboController.getInstance().getEtapa() + "");
        btnFinalizarEtapa.setText("FInalizar etapa: " + ComboController.getInstance().getEtapa() + "");
    }
}
