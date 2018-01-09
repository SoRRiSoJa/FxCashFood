/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashf.controller.prepreparo;

import com.cashf.cashfood.MainApp;
import com.cashf.model.prepreparo.PrePreparo;
import com.cashf.model.prepreparo.ProdutoPrePreparo;
import com.cashf.model.produto.Produto;
import com.cashf.model.produto.UnidadeMedida;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import controller.GenericViewController;
import java.math.BigDecimal;
import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.Pane;
import util.PoupUpUtil;

/**
 * FXML Controller class
 *
 * @author joao
 */
public class TabPrePreparoFXMLController implements GenericViewController, Initializable {

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
    private TableView<ProdutoPrePreparo> tbvReceita;
    @FXML
    private TableColumn<ProdutoPrePreparo, String> tbcProduto;
    @FXML
    private TableColumn<ProdutoPrePreparo, BigDecimal> tbcQtde;
    @FXML
    private TableColumn<ProdutoPrePreparo, String> tbcUnidade;
    @FXML
    private JFXComboBox<Produto> cbbProduto;
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
    //-----
    private static JFXComboBox<Produto> _ccbItens;
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
    private static TableView<ProdutoPrePreparo> _tbvReceita;
    private static JFXComboBox<Produto> _cbbProduto;
    private static JFXTextField _txtRendimento;
    private static JFXRadioButton _rbtCod;
    private static JFXRadioButton _rbtDesc;
    private static Label _lblCustoTotal;
    private static TableColumn _btnExcluirItem;
    //--
    private String erros;
    private String qtde;
    private BigDecimal qtdeItem;
    private String rendimento;
    private BigDecimal rendimentoReceita;
    private BigDecimal custoReceita;
    private String custoTotal;
    private boolean flagButtons;
    @FXML
    private Pane paneRoot;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        _ccbItens = ccbItens;
        _cbbUnidadeMedida = cbbUnidadeMedida;
        _txtqtde = txtqtde;
        _btnAdicionar = btnAdicionar;
        _rbtCodigo = rbtCodigo;
        _rbtDescricao = rbtDescricao;
        _tbvItens = tbvItens;
        _btnExcluir = btnExcluir;
        _btnSalvar = btnSalvar;
        _btnNovo = btnNovo;
        _btnLimpar = btnLimpar;
        _tbvReceita = tbvReceita;
        _cbbProduto = cbbProduto;
        _txtRendimento = txtRendimento;
        _rbtCod = rbtCod;
        _rbtDesc = rbtDesc;
        _lblCustoTotal = lblCustoTotal;
        _btnExcluirItem = btnExcluirItem;

        loadCbbItens();
        loadCbbProdutos();
        loadCbbUnidadeMedida();
    }

    @FXML
    private void onAdicionar(ActionEvent event) {
        getDataItem();
        if (validateItemFields()) {
            ProdutoPrePreparo pp = new ProdutoPrePreparo(0l, PrePreparoController.getInstance().getItemAtual(), qtdeItem);
            
            tbvItens.setItems(PrePreparoController.getInstance().getListaItens());
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
    }

    @Override
    public void clearFields() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void getData() {
        rendimento = txtRendimento.getText();
        PrePreparoController.getInstance().setProdutoPrincipal(cbbProduto.getSelectionModel().getSelectedItem());
    }

    public void getDataItem() {
        PrePreparoController.getInstance().setUnidadeMedida(cbbUnidadeMedida.getSelectionModel().getSelectedItem());
        try {
            qtdeItem = new BigDecimal(qtde);
        } catch (NumberFormatException e) {
            qtdeItem = BigDecimal.ZERO;
        }
        if (ccbItens.getSelectionModel().getSelectedItem() != null) {
            PrePreparoController.getInstance().setItemAtual(ccbItens.getSelectionModel().getSelectedItem());
        }
    }

    public Boolean validateItemFields() {
        boolean flag = true;
        if (PrePreparoController.getInstance().getListaItens().isEmpty()) {
            erros += "Você deve selecionar um item para inserir na receita! \n";
            flag = false;
        }
        if (qtdeItem.compareTo(BigDecimal.ZERO) <= 0) {
            erros += "a quatidade do item deve ser maior que 0 \n";
            flag = false;
        }

        return flag;
    }

    @Override
    public void loadDataToScreen() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void loadCbbUnidadeMedida() {
        cbbUnidadeMedida.getItems().addAll(Arrays.asList(UnidadeMedida.values()));
    }

    private void loadCbbProdutos() {
        cbbProduto.setItems(PrePreparoController.getInstance().getListaPrePreparo());
    }

    private void loadCbbItens() {
        ccbItens.setItems(PrePreparoController.getInstance().getListaProduto());
    }

    private void setUpTableViewItens() {
        
    }
}
