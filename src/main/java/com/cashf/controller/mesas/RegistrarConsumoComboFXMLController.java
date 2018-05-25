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
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Text;
import javafx.util.Callback;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author joao
 */
public class RegistrarConsumoComboFXMLController implements GenericViewController, Initializable {

    @FXML
    private Text txtCombo;
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
    private JFXTextField txtQtde;
    @FXML
    private JFXButton btnConcluirEtapa;
    @FXML
    private JFXButton btnConcluirSel;
    @FXML
    private JFXButton btnAdicionar;
    @FXML
    private TableView<ProdutoVenda> tbvProdutos;
    @FXML
    private TableColumn<ProdutoVenda, String> tbcCod;
    @FXML
    private TableColumn<ProdutoVenda, Produto> tbcDescricao;
    @FXML
    private TableColumn<ProdutoVenda, Integer> tbcQtde;
    @FXML
    private TableColumn<ProdutoVenda, BigDecimal> tbcValor;
    @FXML
    private TableColumn btnExcluirItem;
    //---
    private String erros = "";
    private BigDecimal qtde = BigDecimal.ZERO;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        loadCbbProduto();
        setUptableViewProdutos();
        loadTbv();
        txtCombo.setText(VendaController.getInstance().getComboSelecionado().getProdutoPrincipal().getDescriao());
        btnConcluirEtapa.setText("Concluir Etapa Nº" + VendaController.getInstance().getEtapaAtual());

    }

    @FXML
    private void onProdutos(ActionEvent event) {
        if (cbbProduto.getSelectionModel().getSelectedItem() != null) {
            // VendaController.getInstance().setProdutoSelecionado(cbbProduto.getItems().get(cbbProduto.getSelectionModel().getSelectedIndex()));
        }
    }

    @FXML
    private void onConcluirEtapa(ActionEvent event) {
        VendaController.getInstance().setEtapaAtual(VendaController.getInstance().getEtapaAtual() + 1);
        btnConcluirEtapa.setText("Concluir Etapa Nº" + VendaController.getInstance().getEtapaAtual());
        loadCbbProduto();
    }

    @FXML
    private void onFinalizarCombo(ActionEvent event) {
        MainApp.janelaAberta.close();
        MainApp.janelaAberta = MainApp.janelaAnterior;
        GerenciarMesasFXMLController.refreshTbvComanda();
    }

    @FXML
    private void onAdcionar(ActionEvent event) {
        getData();
        if (validateFields()) {
            VendaController.getInstance().addProdutoComboToProdutoVenda(qtde);
            loadTbv();
        }
    }

    private void loadCbbProduto() {
        cbbProduto.setItems(VendaController.getInstance().getListaProdEtapa(VendaController.getInstance().getEtapaAtual()));
    }

    @FXML
    private void onProdutoEtapa(KeyEvent event) {
        //pesquisa
    }

    @Override
    public void clearFields() {
        txtQtde.clear();

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
        if (cbbProduto.getSelectionModel().getSelectedItem() == null) {
            flag = false;
            erros += "Você deve selecionar um produto para esta etapa.\n";
        }
        if (qtde.compareTo(BigDecimal.ZERO) <= 0) {
            flag = false;
            erros += "A quntidade não pode ser 0.\n";
        }/*
        if (qtde.compareTo(VendaController.getInstance().getByProduto(VendaController.getInstance().getProdutoSelecionado()).getQtdeProduto()) > 0) {
            flag = false;
            erros += "Quantidade informada maior que a permitida.\n";

        }*/
        return flag;
    }

    @Override
    public void getData() {
        if (cbbProduto.getSelectionModel().getSelectedItem() != null) {
            VendaController.getInstance().setProdutoSelecionado(cbbProduto.getItems().get(cbbProduto.getSelectionModel().getSelectedIndex()));
        }
        try {
            qtde = new BigDecimal(txtQtde.getText());
        } catch (Exception ex) {
            qtde = BigDecimal.ZERO;
            System.out.println("Erro ao converter qtde:" + ex);
        }
    }

    private void loadTbv() {
        tbvProdutos.setItems(VendaController.getInstance().getListaProduosVenda());
    }

    @Override
    public void loadDataToScreen() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
