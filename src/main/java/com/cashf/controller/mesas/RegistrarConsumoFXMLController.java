/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashf.controller.mesas;

import com.cashf.cashfood.MainApp;
import com.cashf.core.venda.VendaController;
import com.cashf.model.produto.Produto;
import com.cashf.model.produto.TipoProduto;
import com.cashf.model.venda.ProdutoVenda;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import com.sun.prism.impl.Disposer;
import controller.GenericViewController;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
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
public class RegistrarConsumoFXMLController implements GenericViewController, Initializable {

    @FXML
    private Text txtEtapa;
    @FXML
    private JFXComboBox<Produto> cbbProduto;
    @FXML
    private JFXRadioButton rbtCodigo;
    @FXML
    private JFXRadioButton rbtDescricao;
    @FXML
    private JFXRadioButton rbtGrupo;
    @FXML
    private JFXRadioButton rbtTodos;
    @FXML
    private JFXTextField txtqtde;
    @FXML
    private JFXButton btnAdicionar;
    @FXML
    private JFXButton btnConcluirSel;
    @FXML
    private TableView<ProdutoVenda> tbvProdutos;
    @FXML
    private TableColumn<ProdutoVenda, String> tbcCod;
    @FXML
    private TableColumn<ProdutoVenda, String> tbcDescricao;
    @FXML
    private TableColumn<ProdutoVenda, BigDecimal> tbcQtde;
    @FXML
    private TableColumn<ProdutoVenda, BigDecimal> tbcValor;
    @FXML
    private TableColumn btnExcluirItem;
    //------------
    private BigDecimal qtde = BigDecimal.ZERO;
    private Boolean flag;
    private String erros = "";
    @FXML
    private StackPane rootStackPane;
    @FXML
    private Pane pane;

    /**
     * Initializes the controller class.
     */
    @Override

    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        loadCbbProd();
        setUpRadioButtons();
        setUptableViewProdutos();
        loadTbv();
    }

    @FXML
    private void onProdutos(ActionEvent event) {
        if (cbbProduto.getSelectionModel().getSelectedItem() != null) {
            VendaController.getInstance().setProdutoSelecionado(cbbProduto.getItems().get(cbbProduto.getSelectionModel().getSelectedIndex()));
        }
    }

    @FXML
    private void onPesquisar(KeyEvent event) {
        if (cbbProduto.getEditor().getText() != null && cbbProduto.getEditor().getText().length() > 1) {
            switch (VendaController.getInstance().getTipoConsulta()) {
                case 1:
                    //MesaController.getInstance().buscaCodRef(cbbProduto.getEditor().getText());
                    loadCbbProd();
                    break;
                case 2:
                    //MesaController.getInstance().buscaInsumosDesc(cbbProduto.getEditor().getText());
                    loadCbbProd();
                    break;
                case 3:
                    //MesaController.getInstance().buscaInsumosTodos();
                    loadCbbProd();
                    break;
                default:
                    loadCbbProd();
                    break;
            }
        }
    }

    @FXML
    private void onAdicionar(ActionEvent event) {
        getData();
        if (VendaController.getInstance().getProdutoSelecionado().getTipo().equals(TipoProduto.COMBO)) {
            VendaController.getInstance().selCombo();
            MainApp.janelaAberta.close();
            MainApp.janelaAberta = MainApp.janelaAnterior;
            loadBox("/fxml/mesas/RegistrarConsumoComboFXML.fxml", "COMBO");

        }
        if (validateFields()) {
            VendaController.getInstance().setListaProduosVenda(0l,
                    VendaController.getInstance().getVenda(),
                    VendaController.getInstance().getProdutoSelecionado(),
                    qtde,
                    VendaController.getInstance().getProdutoSelecionado().getPreco_venda());
            VendaController.getInstance().getVenda().setValorTotal(VendaController.getInstance().getVenda().getValorTotal().add(qtde.multiply(VendaController.getInstance().getProdutoSelecionado().getPreco_venda())));
            loadTbv();
        } else {
            PoupUpUtil.accessDenied(erros);
            //PoupUpUtil.errorMessage(MainApp.paneRoot,rootStackPane, erros);
            erros = "";
        }

    }

    @FXML
    private void onConcluirSel(ActionEvent event) {
        GerenciarMesasFXMLController.refreshTbvComanda();
        MainApp.janelaAberta.close();
        MainApp.janelaAberta = MainApp.janelaAnterior;
    }

    private void loadCbbProd() {
        cbbProduto.setItems(VendaController.getInstance().getListaProd());
    }

    @Override
    public void clearFields() {
        txtqtde.clear();
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
        if (cbbProduto.getSelectionModel().getSelectedItem() == null) {
            flag = false;
            erros += "Um produto deve ser selecionado.";

        }
        if (qtde != null && qtde.compareTo(BigDecimal.ZERO) <= 0) {
            flag = false;

            erros += "A quantidade deve ser amior que 0";
        }
        if (flag && qtde.compareTo(VendaController.getInstance().getProdutoSelecionado().getUnidadesEstoque()) > 0) {
            erros += "A quantidade informada é maior que o total em estoque.";
            flag = false;
        }
        return flag;
    }

    @Override
    public void getData() {
        if (cbbProduto.getSelectionModel().getSelectedItem() != null) {
            VendaController.getInstance().setProdutoSelecionado(cbbProduto.getItems().get(cbbProduto.getSelectionModel().getSelectedIndex()));
        }
        try {
            qtde = new BigDecimal(txtqtde.getText());
        } catch (Exception ex) {
            System.out.println("Erro ao converte qtde:" + ex);
        }
    }

    private void loadTbv() {
        tbvProdutos.setItems(VendaController.getInstance().getListaProduosVenda());
    }

    @Override
    public void loadDataToScreen() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void setUpRadioButtons() {

        rbtCodigo.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                rbtDescricao.setSelected(false);
                rbtGrupo.setSelected(false);
                rbtTodos.setSelected(false);
                MesaController.getInstance().setTipoConsulta(1);//todos
            }
        });
        rbtDescricao.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                rbtCodigo.setSelected(false);
                rbtGrupo.setSelected(false);
                rbtTodos.setSelected(false);
                MesaController.getInstance().setTipoConsulta(2);//todos
            }
        });
        rbtGrupo.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                rbtCodigo.setSelected(false);
                rbtDescricao.setSelected(false);
                rbtTodos.setSelected(false);
                MesaController.getInstance().setTipoConsulta(2);//todos
            }
        });

        rbtTodos.selectedProperty().addListener((ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) -> {
            if (newValue) {
                rbtCodigo.setSelected(false);
                rbtGrupo.setSelected(false);
                rbtDescricao.setSelected(false);
                MesaController.getInstance().setTipoConsulta(0);//todos
                //FichaTecnicaController.getInstance().buscaInsumosTodos();
                //loadTbv();
            }
        });
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

    private void setUptableViewProdutos() {
        tbcCod.setCellValueFactory((param) -> new SimpleStringProperty(param.getValue().getProduto().getCodigoReferencia()));
        tbcDescricao.setCellValueFactory(new PropertyValueFactory<>("produto"));
        tbcQtde.setCellValueFactory(new PropertyValueFactory<>("qtde"));
        tbcValor.setCellValueFactory((param) -> new SimpleObjectProperty<BigDecimal>(param.getValue().getPrecoUnit().multiply(param.getValue().getQtde())));
        btnExcluirItem.setCellFactory(
                new Callback<TableColumn<Disposer.Record, Boolean>, TableCell<Disposer.Record, Boolean>>() {
            @Override
            public TableCell<Disposer.Record, Boolean> call(TableColumn<Disposer.Record, Boolean> p) {
                return new ButtonCellDelete();
            }
        });
        tbvProdutos.getColumns().setAll(tbcCod, tbcDescricao, tbcQtde, tbcValor, btnExcluirItem);
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

}
