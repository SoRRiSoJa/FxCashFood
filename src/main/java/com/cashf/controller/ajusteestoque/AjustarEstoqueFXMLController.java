/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashf.controller.ajusteestoque;

import com.cashf.cashfood.MainApp;
import com.cashf.controller.prepreparo.PrePreparoController;
import com.cashf.model.ajusteestoque.TipoAjuste;
import com.cashf.model.produto.Produto;
import com.cashf.model.produto.UnidadeMedida;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTimePicker;
import controller.GenericViewController;
import java.math.BigDecimal;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import util.PoupUpUtil;
import util.TextFieldFormatter;

/**
 * FXML Controller class
 *
 * @author joao
 */
public class AjustarEstoqueFXMLController implements GenericViewController, Initializable {

    @FXML
    private Pane paneRoot;
    @FXML
    private TableView<Produto> tbvProdutos;
    @FXML
    private TableColumn<Produto, Integer> tbcCod;
    @FXML
    private TableColumn<Produto, String> tbcCodRef;
    @FXML
    private TableColumn<Produto, String> tbcDescricao;
    @FXML
    private TableColumn<Produto, String> tbcTipo;
    @FXML
    private TableColumn<Produto, Integer> tbcQtde;
    @FXML
    private JFXTextField txtConsultar;
    @FXML
    private JFXButton btnPesquisar;
    @FXML
    private JFXButton btnSalvar;
    @FXML
    private JFXTextField txtDescricao;
    @FXML
    private JFXTextField txtQtdeAjuste;
    @FXML
    private JFXComboBox<TipoAjuste> cbbTipoAjuste;
    @FXML
    private JFXTextField txtQtdeAtual;
    private JFXTextField txtSaldo;
    @FXML
    private JFXDatePicker dtpDataAjuste;
    @FXML
    private JFXTimePicker dtpHoraAjuste;
    //--
    private String erros;
    private String motivoAjuste;
    private BigDecimal qtdeAjuste;
    private boolean flagButtons;
    private AjusteEstoqueController controller = new AjusteEstoqueController();
    @FXML
    private JFXButton btnLimpar;
    @FXML
    private Label lblSaldo;
    @FXML
    private JFXComboBox<UnidadeMedida> cbbUnidadeMedida;
    @FXML
    private JFXTextField txtMotivo;
    @FXML
    private JFXRadioButton rbtDesc;
    @FXML
    private JFXRadioButton rbtCod;
    @FXML
    private JFXRadioButton rbtTodos;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

        dtpDataAjuste.setValue(LocalDate.now());
        dtpHoraAjuste.setValue(LocalTime.now());
        setUpRadioButtons();
        setUpTableView();
        loadCbbTipo();
        loadCbbUnidadeFisica();
        loadTbv();

    }

    @FXML
    private void onSelecionarProduto(MouseEvent event) {
        if (tbvProdutos.getSelectionModel().getSelectedItem() != null) {
            controller.setProduto(tbvProdutos.getSelectionModel().getSelectedItem());
            controller.setUnidadeMedida(controller.getProduto().getUnidadeMedida());
            loadDataToScreen();
        }
    }

    @FXML
    private void onPesquisar(ActionEvent event) {
        if (txtConsultar.getText() != null && txtConsultar.getText().length() > 1) {
            switch (controller.getTipoConsulta()) {
                case 1:
                    controller.buscaCodRef(txtConsultar.getText());
                    loadTbv();
                    break;
                case 2:
                    controller.buscaInsumosDesc(txtConsultar.getText());
                    loadTbv();
                    break;
                default:
                    controller.buscaInsumosTodos();
                    loadTbv();
                    break;
            }
        }
    }

    @FXML
    private void onSalvar(ActionEvent event) {
        if (validateFields()) {
            getData();
            controller.setTipoAjuste(cbbTipoAjuste.getSelectionModel().getSelectedItem());
            TipoAjuste aux = controller.getTipoAjuste();
            controller.setUnidadeMedida(cbbUnidadeMedida.getSelectionModel().getSelectedItem());
            controller.setQtdeAjuste(qtdeAjuste);
            switch (aux) {
                case E:
                    controller.adicionarProduto();
                    break;
                case S:
                    controller.retirarProduto();
                    break;
            }
            controller.getAtualizarEstoque().setTipoAjuste(controller.getTipoAjuste());
            controller.getAtualizarEstoque().setAjusteEstoque(motivoAjuste, LocalDate.now(), LocalTime.now(), qtdeAjuste);

            controller.insert();
            controller.refreshListaPRod();
            lblSaldo.setText(controller.getProduto().getQtdeProduto() + "");
            tbvProdutos.refresh();
        } else {
            PoupUpUtil.errorMessage(paneRoot, MainApp.paneRoot, erros);
            erros = "";
        }

    }

    @Override
    public void clearFields() {
        txtConsultar.clear();
        txtDescricao.clear();
        txtQtdeAjuste.clear();
        txtMotivo.clear();
        cbbTipoAjuste.setValue(null);
        txtQtdeAtual.clear();
        lblSaldo.setText("");
        dtpDataAjuste.setValue(LocalDate.now());
        dtpHoraAjuste.setValue(LocalTime.now());

    }

    @Override
    public void setInputOff() {
        tbvProdutos.setDisable(true);
        txtConsultar.setDisable(true);
        btnPesquisar.setDisable(true);
        btnSalvar.setDisable(true);
        txtDescricao.setDisable(true);
        txtQtdeAjuste.setDisable(true);
        cbbTipoAjuste.setDisable(true);
        txtQtdeAtual.setDisable(true);
        lblSaldo.setDisable(true);
        dtpDataAjuste.setDisable(true);
        dtpHoraAjuste.setDisable(true);
        flagButtons = false;
    }

    @Override
    public void setInputOn() {
        tbvProdutos.setDisable(false);
        txtConsultar.setDisable(false);
        btnPesquisar.setDisable(false);
        btnSalvar.setDisable(false);
        txtDescricao.setDisable(false);
        txtQtdeAjuste.setDisable(false);
        cbbTipoAjuste.setDisable(false);
        txtQtdeAtual.setDisable(false);
        txtSaldo.setDisable(false);
        dtpDataAjuste.setDisable(false);
        dtpHoraAjuste.setDisable(false);
        lblSaldo.setDisable(false);
        flagButtons = true;

    }

    @Override
    public Boolean validateFields() {
        boolean flag = true;
        if (txtQtdeAjuste.getText() == null || txtQtdeAjuste.getText().equals("")) {
            erros += "A quntidade a ser ajustada deve ser informada!\n";
            flag = false;
        }
        if (txtQtdeAjuste.getText().contains("-") || txtQtdeAjuste.getText().equals("0")) {
            erros += "A quantidade a ser ajustada deve positiva e maior que 0!\n";
            flag = false;
        }
        if (cbbTipoAjuste.getSelectionModel().getSelectedItem() == null) {
            erros += "Voce deve selecionar o Tipo de ajuste a realizar Entrada/Saída !\n";
            flag = false;
        }
        if (txtMotivo.getText() == null || txtMotivo.getText().equals("")) {
            erros += "Voce deve informar um motivo par ao ajuste !\n";
            flag = false;
        }
        if (cbbUnidadeMedida.getSelectionModel().getSelectedItem() == null) {
            erros += "Voce deve informar uma unidade de medida !\n";
            flag = false;
        }
        return flag;
    }

    @Override
    public void getData() {
        qtdeAjuste = new BigDecimal(txtQtdeAjuste.getText());
        motivoAjuste = txtMotivo.getText();

    }

    @Override
    public void loadDataToScreen() {
        txtDescricao.setText(controller.getProduto().getDescriao());
        txtQtdeAtual.setText(controller.getProduto().getQtdeProduto() + "");
        cbbUnidadeMedida.getSelectionModel().select(controller.getProduto().getUnidadeMedida());
    }

    @FXML
    private void onMouseClickedTipo(MouseEvent event) {
        if (cbbTipoAjuste.getSelectionModel().getSelectedItem() != null) {
            controller.setTipoAjuste(cbbTipoAjuste.getSelectionModel().getSelectedItem());
        }
    }

    private void loadCbbTipo() {
        cbbTipoAjuste.getItems().addAll(Arrays.asList(TipoAjuste.values()));
    }

    private void setUpTableView() {
        tbcCod.setCellValueFactory(new PropertyValueFactory<>("idProduto"));
        tbcCodRef.setCellValueFactory(new PropertyValueFactory<>("codigoReferencia"));
        tbcDescricao.setCellValueFactory(new PropertyValueFactory<>("descriao"));
        tbcTipo.setCellValueFactory(new PropertyValueFactory<>("tipo"));
        tbcQtde.setCellValueFactory(new PropertyValueFactory<>("qtdeProduto"));
        tbvProdutos.getColumns().setAll(tbcCod, tbcCodRef, tbcDescricao, tbcTipo, tbcQtde);
    }

    private void loadTbv() {
        tbvProdutos.setItems(controller.getListaProduto());
    }

    @FXML
    private void onLimpar(ActionEvent event) {
        clearFields();
    }

    @FXML
    private void onKeyReleasedQtdeAjuste(KeyEvent event) {
        TextFieldFormatter tff = new TextFieldFormatter();
        tff.setMask("###.##");
        tff.setCaracteresValidos("0123456789");
        tff.setTf(txtQtdeAjuste);
        tff.formatter();
    }

    private void loadCbbUnidadeFisica() {
        cbbUnidadeMedida.getItems().addAll(Arrays.asList(UnidadeMedida.values()));
    }

    @FXML
    private void onMouseClickedMedida(MouseEvent event) {
        if (cbbUnidadeMedida.getSelectionModel().getSelectedItem() != null) {
            controller.setUnidadeMedida(cbbUnidadeMedida.getSelectionModel().getSelectedItem());
        }
    }

    private void setUpRadioButtons() {
        rbtCod.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                rbtDesc.setSelected(false);
                rbtTodos.setSelected(false);
                controller.setTipoConsulta(1);//todos
            }
        });
        rbtDesc.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                rbtCod.setSelected(false);
                rbtTodos.setSelected(false);
                controller.setTipoConsulta(2);//todos
            }
        });

        rbtTodos.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                rbtCod.setSelected(false);
                rbtDesc.setSelected(false);
                controller.setTipoConsulta(0);//todos
                controller.buscaInsumosTodos();
                loadTbv();
            }
        });
    }
}
