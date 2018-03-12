/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashf.controller.receberpedido;

import com.cashf.controller.prepreparo.PrePreparoController;
import com.cashf.model.fornecedor.Fornecedor;
import com.cashf.model.notafiscal.ProdutoNotaFiscal;
import com.cashf.model.prepreparo.ProdutoPrePreparo;
import com.cashf.model.produto.Produto;
import com.cashf.model.produto.UnidadeMedida;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import com.sun.prism.impl.Disposer;
import controller.GenericViewController;
import java.math.BigDecimal;
import java.net.URL;
import java.time.LocalDate;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Callback;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;
import util.PoupUpUtil;

/**
 * FXML Controller class
 *
 * @author joao
 */
public class ReceberPedidoFXMLController implements GenericViewController, Initializable {

    @FXML
    private JFXButton btnSalvar;
    @FXML
    private JFXButton btnNovo;
    @FXML
    private JFXButton btnLimpar;
    @FXML
    private JFXComboBox<Fornecedor> cbbFornecedor;
    @FXML
    private JFXDatePicker dtpDataNota;
    @FXML
    private JFXTextField txtNumeroNota;
    @FXML
    private JFXTextField txtValorIcms;
    @FXML
    private JFXTextField txtBaseCalculoIcms;
    @FXML
    private JFXTextField txtValorTotalIpi;
    @FXML
    private JFXTextField txtBaseIcmsSubst;
    @FXML
    private JFXTextField txtValorIcmsSubst;
    @FXML
    private JFXTextField txtOutrasDespesas;
    @FXML
    private JFXTextField txtDesconto;
    @FXML
    private JFXTextField txtValorTotalProdutos;
    @FXML
    private JFXTextField txtValorTotalNota;
    @FXML
    private JFXTextField txtObservacao;
    @FXML
    private JFXDatePicker dtpDataRecebimento;
    @FXML
    private JFXComboBox<Produto> cbbProduto;
    @FXML
    private JFXComboBox<UnidadeMedida> cbbUnidadeFisica;
    @FXML
    private JFXTextField txtValorIpi;
    @FXML
    private JFXTextField txtValorIcmsSubstProd;
    @FXML
    private JFXTextField txtQtdeCompra;
    @FXML
    private JFXTextField txtQtdeRecebida;
    @FXML
    private JFXTextField txtPrcoCompra;
    @FXML
    private JFXTextField txtOutrasDespesasProd;
    @FXML
    private JFXTextField txtDescontoProd;
    @FXML
    private JFXTextField txtEmbalagemDeCompra;
    @FXML
    private TableView<ProdutoNotaFiscal> tbvProdutos;
    @FXML
    private TableColumn<ProdutoNotaFiscal, String> tbcProduto;
    @FXML
    private TableColumn<ProdutoNotaFiscal, Integer> tbcQtde;
    @FXML
    private TableColumn<ProdutoNotaFiscal, BigDecimal> tbcValUnid;
    @FXML
    private TableColumn<ProdutoNotaFiscal, BigDecimal> tbcTotal;
    @FXML
    private TableColumn btnExcluirProd;
    @FXML
    private JFXButton btnAdicionar;
    //----
    private LocalDate dataNota;
    private LocalDate dataRecebimento;
    private String numeroNota;
    private String observacao;
    private BigDecimal qtdeCompra;
    private BigDecimal qtdeRecebida;
    private BigDecimal prcoCompra;
    private BigDecimal embalagemDeCompra;
    private BigDecimal valorIcms;
    private BigDecimal baseCalculoIcms;
    private BigDecimal valorTotalIpi;
    private BigDecimal valorIpi;
    private BigDecimal baseIcmsSubst;
    private BigDecimal valorIcmsSubst;
    private BigDecimal outrasDespesas;
    private BigDecimal desconto;
    private BigDecimal valorTotalProdutos;
    private BigDecimal valorTotalNota;
    private BigDecimal valorIcmsSubstProd;
    private BigDecimal outrasDespesasProd;
    private BigDecimal descontoProd;

    private String erros;
    private boolean flagButtons;
    private final ReceberPedidoController controller = new ReceberPedidoController();
    //----

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        loadCbbFornecedor();
        loadCbbProdutos();
        loadCbbUnidadeMedida();
        setInputOff();
        setUpTableViewItens();
    }

    @FXML
    private void onSalvar(ActionEvent event) {
        getData();
        if (validateFields()) {
            controller.setNotaFiscal(0l, numeroNota, dataNota, dataRecebimento, baseCalculoIcms, valorIcms, baseIcmsSubst, valorIcmsSubst, outrasDespesas, desconto, valorTotalProdutos, valorTotalNota, observacao);
            System.out.println("NOTA:"+controller.getNotaFiscal().toString());
        } else {
            PoupUpUtil.accessDenied(erros);
            erros = "";
        }
    }

    @FXML
    private void onNovo(ActionEvent event) {
        setInputOn();
        clearFields();
        btnNovo.setDisable(true);
    }

    @FXML
    private void onLimpar(ActionEvent event) {
        clearFields();
    }

    @FXML
    private void onAdicionar(ActionEvent event) {
        getDataProd();
        if (validateFieldsProd()) {
            controller.setListaProdutosNota(0l, qtdeRecebida.intValue(),valorIpi,valorIcmsSubstProd, prcoCompra,outrasDespesasProd,descontoProd);
            controller.getListaProdutosNota().forEach((pn) -> {
                System.out.println("P.Nota:" + pn.toString());
            });
            controller.setProdutoAtual(null);
            System.out.println("Fim lista ---->>>>>>");
            System.out.println("Tott IPI ----:"+controller.getValTotalIPI());
            System.out.println("Tott icms ----:"+controller.getValTotalIcmsProd());
            tbvProdutos.setItems(controller.getListaProdutosNota());
        } else {
            PoupUpUtil.accessDenied(erros);
            erros = "";
        }
    }

    @Override
    public void clearFields() {
        cbbFornecedor.setValue(null);
        dtpDataNota.setValue(null);;
        txtNumeroNota.clear();
        txtValorIcms.clear();
        txtBaseCalculoIcms.clear();
        txtValorTotalIpi.clear();
        txtBaseIcmsSubst.clear();
        txtValorIcmsSubst.clear();
        txtOutrasDespesas.clear();
        txtDesconto.clear();
        txtValorTotalProdutos.clear();
        txtValorTotalNota.clear();
        txtObservacao.clear();
        dtpDataRecebimento.setValue(null);;
        cbbProduto.setValue(null);
        cbbUnidadeFisica.setValue(null);
        txtValorIpi.clear();
        txtValorIcmsSubstProd.clear();
        txtQtdeCompra.clear();
        txtQtdeRecebida.clear();
        txtPrcoCompra.clear();
        txtOutrasDespesasProd.clear();
        txtDescontoProd.clear();
        txtEmbalagemDeCompra.clear();
    }

    @Override
    public void setInputOff() {
        cbbFornecedor.setDisable(true);
        dtpDataNota.setDisable(true);
        txtNumeroNota.setDisable(true);
        txtValorIcms.setDisable(true);
        txtBaseCalculoIcms.setDisable(true);
        txtValorTotalIpi.setDisable(true);
        txtBaseIcmsSubst.setDisable(true);
        txtValorIcmsSubst.setDisable(true);
        txtOutrasDespesas.setDisable(true);
        txtDesconto.setDisable(true);
        txtValorTotalProdutos.setDisable(true);
        txtValorTotalNota.setDisable(true);
        txtObservacao.setDisable(true);
        dtpDataRecebimento.setDisable(true);
        cbbProduto.setDisable(true);
        cbbUnidadeFisica.setDisable(true);
        txtValorIpi.setDisable(true);
        txtValorIcmsSubstProd.setDisable(true);
        txtQtdeCompra.setDisable(true);
        txtQtdeRecebida.setDisable(true);
        txtPrcoCompra.setDisable(true);
        txtOutrasDespesasProd.setDisable(true);
        txtDescontoProd.setDisable(true);
        txtEmbalagemDeCompra.setDisable(true);
        btnSalvar.setDisable(true);
        //btnNovo.setDisable(true);
        btnLimpar.setDisable(true);
        tbvProdutos.setDisable(true);
        btnAdicionar.setDisable(true);
        flagButtons = false;
    }

    @Override
    public void setInputOn() {
        cbbFornecedor.setDisable(false);
        dtpDataNota.setDisable(false);
        txtNumeroNota.setDisable(false);
        txtValorIcms.setDisable(false);
        txtBaseCalculoIcms.setDisable(false);
        txtValorTotalIpi.setDisable(false);
        txtBaseIcmsSubst.setDisable(false);
        txtValorIcmsSubst.setDisable(false);
        txtOutrasDespesas.setDisable(false);
        txtDesconto.setDisable(false);
        txtValorTotalProdutos.setDisable(false);
        txtValorTotalNota.setDisable(false);
        txtObservacao.setDisable(false);
        dtpDataRecebimento.setDisable(false);
        cbbProduto.setDisable(false);
        cbbUnidadeFisica.setDisable(false);
        txtValorIpi.setDisable(false);
        txtValorIcmsSubstProd.setDisable(false);
        txtQtdeCompra.setDisable(false);
        txtQtdeRecebida.setDisable(false);
        txtPrcoCompra.setDisable(false);
        txtOutrasDespesasProd.setDisable(false);
        txtDescontoProd.setDisable(false);
        txtEmbalagemDeCompra.setDisable(false);
        btnSalvar.setDisable(false);
        btnNovo.setDisable(false);
        btnLimpar.setDisable(false);
        tbvProdutos.setDisable(false);
        btnAdicionar.setDisable(false);
        flagButtons = true;
    }

    @Override
    public Boolean validateFields() {
        boolean flag = true;

        //dataNota 
        //numeroNota 
        if (cbbProduto.getSelectionModel().getSelectedItem() == null) {
            erros += "Você deve selecionar um produto para adicionar a lista. \n";
            flag = false;
        }
        if (numeroNota == null || numeroNota.isEmpty()) {
            erros += "O Número da nota deve ser informado. \n";
            flag = false;
        }
        if (valorIcms.compareTo(BigDecimal.ZERO) < 0) {
            erros += "O Valor do ICMS do produto ser maior ou = 0 \n";
            flag = false;
        }
        if (baseCalculoIcms.compareTo(BigDecimal.ZERO) < 0) {
            erros += "O Valor da Base de Calculo ICMS Nota deve ser maior ou = 0 \n";
            flag = false;
        }
        if (baseIcmsSubst.compareTo(BigDecimal.ZERO) < 0) {
            erros += "O Valor da Base de ICMS Subst da Nota deve ser maior ou = 0 \n";
            flag = false;
        }
        if (valorIcmsSubst.compareTo(BigDecimal.ZERO) < 0) {
            erros += "O Valor do ICMS Subst da Nota deve ser maior ou = 0 \n";
            flag = false;
        }
        if (outrasDespesas.compareTo(BigDecimal.ZERO) < 0) {
            erros += "O Valor de outras despesas deve ser maior ou = 0 \n";
            flag = false;
        }
        if (desconto.compareTo(BigDecimal.ZERO) < 0) {
            erros += "O Valor do desconto deve ser maior ou = 0 \n";
            flag = false;
        }
        //valorTotalProdutos 
        //valorTotalNota 
        //observacao 
        //dataRecebimento
        return flag;
    }

    public Boolean validateFieldsProd() {
        boolean flag = true;
        if (valorIpi.compareTo(BigDecimal.ZERO) < 0) {
            erros += "O Valor do IPI do produto ser maior ou = 0 \n";
            flag = false;
        }
        if (valorIcmsSubstProd.compareTo(BigDecimal.ZERO) < 0) {
            erros += "O Valor do ICMS Subst do produto ser maior ou = 0 \n";
            flag = false;
        }
        if (qtdeCompra.compareTo(BigDecimal.ZERO) <= 0) {
            erros += "O Valor da quantidade de compra do produto ser maior que 0 \n";
            flag = false;
        }
        if (qtdeRecebida.compareTo(BigDecimal.ZERO) <= 0) {
            erros += "O Valor da quantidade recebida do produto ser maior que 0 \n";
            flag = false;
        }
        if (prcoCompra.compareTo(BigDecimal.ZERO) <= 0) {
            erros += "O Valor de compra do produto deve ser maior que 0 \n";
            flag = false;
        }
        if (outrasDespesasProd.compareTo(BigDecimal.ZERO) < 0) {
            erros += "O Valor da das despesas não pode ser negativo  \n";
            flag = false;
        }
        if (descontoProd.compareTo(BigDecimal.ZERO) < 0) {
            erros += "O Valor do desconto não pode ser negativo.  \n";
            flag = false;
        }
        if (embalagemDeCompra.compareTo(BigDecimal.ZERO) <= 0) {
            erros += "O Valor da embalagem de compra nao pode ser 0 . \n";
            flag = false;
        }
        if (cbbProduto.getSelectionModel().getSelectedItem() == null) {
            erros += "Você deve selecionar Um Produto para adicionar a lista \n";
            flag = false;
        }
        if (cbbUnidadeFisica.getSelectionModel().getSelectedItem() == null) {
            erros += "Você deve selecionar Uma unidade de medida para o produto \n";
            flag = false;
        }
        return flag;
    }

    @Override
    public void getData() {
        controller.setFornecedor(cbbFornecedor.getValue());
        dataNota = dtpDataNota.getValue();
        numeroNota = txtNumeroNota.getText();
        valorIcms = new BigDecimal(txtValorIcms.getText());
        baseCalculoIcms = new BigDecimal(txtBaseCalculoIcms.getText());
        valorTotalIpi = new BigDecimal(txtValorTotalIpi.getText());
        baseIcmsSubst = new BigDecimal(txtBaseIcmsSubst.getText());
        valorIcmsSubst = new BigDecimal(txtValorIcmsSubst.getText());
        outrasDespesas = new BigDecimal(txtOutrasDespesas.getText());
        desconto = new BigDecimal(txtDesconto.getText());
        valorTotalProdutos = new BigDecimal(txtValorTotalProdutos.getText());
        valorTotalNota = new BigDecimal(txtValorTotalNota.getText());
        observacao = txtObservacao.getText();
        dataRecebimento = dtpDataRecebimento.getValue();
    }

    public void getDataProd() {
        controller.setProdutoAtual(cbbProduto.getSelectionModel().getSelectedItem());
        controller.setUnidadeMedida(cbbUnidadeFisica.getSelectionModel().getSelectedItem());
        try {
            valorIpi = new BigDecimal(txtValorIpi.getText());
        } catch (Exception ex) {
            System.out.println("Erro ao converter --->>> IPI Prod:" + ex);
            valorIpi = BigDecimal.ZERO;
        }
        try {
            valorIcmsSubstProd = new BigDecimal(txtValorIcmsSubstProd.getText());
        } catch (Exception ex) {
            System.out.println("Erro ao converter --->>> icms subs Prod:" + ex);
            valorIcmsSubstProd = BigDecimal.ZERO;
        }
        try {
            qtdeCompra = new BigDecimal(txtQtdeCompra.getText());
        } catch (Exception ex) {
            System.out.println("Erro ao converter --->>> qtde comp Prod:" + ex);
            qtdeCompra = BigDecimal.ZERO;
        }
        try {
            qtdeRecebida = new BigDecimal(txtQtdeRecebida.getText());
        } catch (Exception ex) {
            System.out.println("Erro ao converter --->>> qtde rece:" + ex);
            qtdeRecebida = BigDecimal.ZERO;
        }
        try {
            prcoCompra = new BigDecimal(txtPrcoCompra.getText());
        } catch (Exception ex) {
            System.out.println("Erro ao converter --->>> preco comp:" + ex);
            prcoCompra = BigDecimal.ZERO;
        }
        try {
            outrasDespesasProd = new BigDecimal(txtOutrasDespesasProd.getText());
        } catch (Exception ex) {
            System.out.println("Erro ao converter --->>> despesas outras:" + ex);
            outrasDespesasProd = BigDecimal.ZERO;
        }
        try {
            descontoProd = new BigDecimal(txtDescontoProd.getText());
        } catch (Exception ex) {
            System.out.println("Erro ao converter --->>> desconto prod:" + ex);
            descontoProd = BigDecimal.ZERO;
        }
        try {
            embalagemDeCompra = new BigDecimal(txtEmbalagemDeCompra.getText());
        } catch (Exception ex) {
            System.out.println("Erro ao converter --->>> embalagem comp:" + ex);
            embalagemDeCompra = BigDecimal.ZERO;
        }
    }

    @Override
    public void loadDataToScreen() {
        //cbbFornecedor.setValue();
        //dtpDataNota.setValue();;
        //txtNumeroNota.setText();;
        //txtValorIcms.setText();;
        //txtBaseCalculoIcms.setText();;
        //txtValorTotalIpi.setText();;
        //txtBaseIcmsSubst.setText();;
        //txtValorIcmsSubst.setText();;
        //txtOutrasDespesas.setText();;
        //txtDesconto.setText();;
        //txtValorTotalProdutos.setText();;
        //txtValorTotalNota.setText();;
        //txtObservacao.setText();;
        //dtpDataRecebimento.setValue(null);;
        //cbbProduto.setValue(null);
        //cbbUnidadeFisica.setValue(null);
        //txtValorIpi.setText();;
        //txtValorIcmsSubstProd.setText();;
        // txtQtdeCompra.setText();;
        // txtQtdeRecebida.setText();;
        // txtPrcoCompra.setText();;
        // txtOutrasDespesasProd.setText();;
        //txtDescontoProd.setText();;
        //txtEmbalagemDeCompra.setText();;
    }

    private void loadCbbProdutos() {
        cbbProduto.setItems(controller.loadComboProduto());
    }

    private void loadCbbFornecedor() {
        cbbFornecedor.setItems(controller.loadComboFornecedor());
    }

    private void loadCbbUnidadeMedida() {
        cbbUnidadeFisica.getItems().addAll(controller.loadComboUnidadeMedida());
    }

    private void setUpTableViewItens() {
        tbcProduto.setCellValueFactory(new PropertyValueFactory<>("produto"));
        tbcQtde.setCellValueFactory(new PropertyValueFactory<>("qtdeProduto"));
        tbcValUnid.setCellValueFactory(new PropertyValueFactory<>("valorUnitario"));
        tbcTotal.setCellValueFactory(new PropertyValueFactory<>("valorTotal"));
        btnExcluirProd.setCellFactory(
                new Callback<TableColumn<Disposer.Record, Boolean>, TableCell<Disposer.Record, Boolean>>() {
            @Override
            public TableCell<Disposer.Record, Boolean> call(TableColumn<Disposer.Record, Boolean> p) {
                return new ButtonCellDelete();
            }
        });
        tbvProdutos.getColumns().setAll(tbcProduto, tbcQtde, tbcValUnid, tbcTotal, btnExcluirProd);
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
                ProdutoNotaFiscal currentPerson = (ProdutoNotaFiscal) ButtonCellDelete.this.getTableView().getItems().get(ButtonCellDelete.this.getIndex());
                //remove selected item from the table list
                if (currentPerson != null) {
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("Cofirmar Excluir Item da Lista!");
                    alert.setHeaderText("Deseja realmente Excluir?");
                    alert.setContentText("Produto:(" + currentPerson.getProduto().getDescriao() + ")");
                    Optional<ButtonType> result = alert.showAndWait();
                    if (result.get() == ButtonType.OK) {
                        // ... user chose OK
                        controller.getListaProdutosNota().remove(currentPerson);
                        //lblCustoTotal.setText(nf.format(PrePreparoController.getInstance().getCustoTotal()));
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
