/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashf.controller.produto;

import com.cashf.model.produto.Categoria;
import com.cashf.model.produto.Grupo;
import com.cashf.model.produto.Produto;
import com.cashf.model.produto.SituacaoTributaria;
import com.cashf.model.produto.TipoProduto;
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
import javafx.scene.control.TableView;
import util.PoupUpUtil;

/**
 * FXML Controller class
 *
 * @author joao
 */
public class GerenciarProdutosFXMLController implements GenericViewController, Initializable {

    @FXML
    private JFXComboBox<UnidadeMedida> cbbUnidadeFisica;
    @FXML
    private JFXTextField txtDescricao;
    @FXML
    private JFXComboBox<Grupo> cbbGrupo;
    @FXML
    private JFXComboBox<TipoProduto> cbbProdutos;
    @FXML
    private JFXTextField txtNcm;
    @FXML
    private JFXTextField txtCodigo;
    @FXML
    private JFXComboBox<Categoria> cbbCategoria;
    @FXML
    private JFXTextField txtPrecoCusto;
    @FXML
    private JFXTextField txtPrecoVenda;
    @FXML
    private JFXTextField txtCodRef;
    @FXML
    private JFXTextField txtQtdeEmbalagem;
    @FXML
    private JFXComboBox<SituacaoTributaria> cbbSituacaoTributaria;
    @FXML
    private JFXTextField txtPercentualPIS;
    @FXML
    private JFXTextField txtAliquotaICMS;
    @FXML
    private JFXTextField txtCest;
    @FXML
    private JFXTextField txtCfop;
    @FXML
    private JFXTextField txtAliquotaCSOCN;
    @FXML
    private JFXTextField txtCSOSN;
    @FXML
    private JFXTextField txtPercentualConfins;
    @FXML
    private JFXTextField txtCstPis;
    @FXML
    private JFXTextField txtCstConfins;
    @FXML
    private JFXTextField txtAliquotaMunicipal;
    @FXML
    private JFXTextField txtAliquotaEstadual;
    @FXML
    private JFXTextField txtAliquotaFederal;
    @FXML
    private JFXButton btnSalvar;
    @FXML
    private JFXButton btnNovo;
    @FXML
    private JFXButton btnExcluir;
    @FXML
    private JFXButton btnLimpar;
    @FXML
    private TableView<Produto> tbvProdutos;
    @FXML
    private JFXTextField txtConsultar;
    @FXML
    private JFXButton btnPesquisar;
    @FXML
    private JFXRadioButton rdbDesc;
    @FXML
    private JFXRadioButton rdbGrupo;
    @FXML
    private JFXRadioButton rdbTodos;
    //---
    ProdutoController controller = new ProdutoController();
    private String erros;
    private boolean flagButtons;
    private long idProduto;
    private String codigoReferencia;
    private String descriao;
    private int qtdeEmbalagem = 0;
    private String ncm;
    private BigDecimal preco_custo;
    private BigDecimal preco_venda;
    private int aliquotasProdutoId;
    private boolean status;
//---
    private long idAliquota;
    private BigDecimal percentualPis;
    private BigDecimal cstpPis;
    private BigDecimal cfop;
    private BigDecimal cstConfins;
    private BigDecimal percentualConfins;
    private BigDecimal aliquotaCsosn;
    private BigDecimal cest;
    private BigDecimal aliquotaIcms;
    private BigDecimal aliquotafederal;
    private BigDecimal aliquotaestadual;
    private BigDecimal aliquotamunicipal;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        setInputOff();
        loadCbbGrupos();
        loadCbbSituacaoTributaria();
        loadCbbTipoProduto();
        loadCbbUnidadeFisica();
    }

    @FXML
    private void onSalvar(ActionEvent event) {
    }

    @FXML
    private void onNovo(ActionEvent event) {
        setInputOn();
        clearFields();
        btnNovo.setDisable(true);
        btnExcluir.setDisable(true);
    }

    @FXML
    private void onExcluir(ActionEvent event) {
        if (controller.getProduto() != null) {
            controller.delete();
            PoupUpUtil.poupUp("Produto Excluído", "O Produto foi excluído com sucesso.", "");
        }
        btnExcluir.setDisable(true);
        clearFields();
    }

    @FXML
    private void onLimpar(ActionEvent event) {
        clearFields();
    }

    @Override
    public void clearFields() {
        cbbUnidadeFisica.setValue(null);
        txtDescricao.clear();
        cbbGrupo.setValue(null);
        cbbProdutos.setValue(null);
        txtNcm.clear();
        txtCodigo.clear();
        cbbCategoria.setValue(null);
        txtPrecoCusto.clear();
        txtPrecoVenda.clear();
        txtCodRef.clear();
        txtQtdeEmbalagem.clear();
        cbbSituacaoTributaria.setValue(null);
        txtPercentualPIS.clear();
        txtAliquotaICMS.clear();
        txtCest.clear();
        txtCfop.clear();
        txtAliquotaCSOCN.clear();
        txtCSOSN.clear();
        txtPercentualConfins.clear();
        txtCstPis.clear();
        txtCstConfins.clear();
        txtAliquotaMunicipal.clear();
        txtAliquotaEstadual.clear();
        txtAliquotaFederal.clear();
        txtConsultar.clear();
    }

    @Override
    public void setInputOff() {
        btnExcluir.setDisable(true);
        btnLimpar.setDisable(true);
        btnSalvar.setDisable(true);
        txtDescricao.setDisable(true);
        txtDescricao.setDisable(true);
        cbbUnidadeFisica.setDisable(true);
        txtDescricao.setDisable(true);
        cbbGrupo.setDisable(true);
        cbbProdutos.setDisable(true);
        txtNcm.setDisable(true);
        txtCodigo.setDisable(true);
        cbbCategoria.setDisable(true);
        txtPrecoCusto.setDisable(true);
        txtPrecoVenda.setDisable(true);
        txtCodRef.setDisable(true);
        txtQtdeEmbalagem.setDisable(true);
        cbbSituacaoTributaria.setDisable(true);
        txtPercentualPIS.setDisable(true);
        txtAliquotaICMS.setDisable(true);
        txtCest.setDisable(true);
        txtCfop.setDisable(true);
        txtAliquotaCSOCN.setDisable(true);
        txtCSOSN.setDisable(true);
        txtPercentualConfins.setDisable(true);
        txtCstPis.setDisable(true);
        txtCstConfins.setDisable(true);
        txtAliquotaMunicipal.setDisable(true);
        txtAliquotaEstadual.setDisable(true);
        txtAliquotaFederal.setDisable(true);
        txtConsultar.setDisable(true);
        rdbDesc.setDisable(true);
        rdbGrupo.setDisable(true);
        rdbTodos.setDisable(true);
        flagButtons = false;
    }

    @Override
    public void setInputOn() {
        btnExcluir.setDisable(false);
        btnLimpar.setDisable(false);
        btnSalvar.setDisable(false);
        txtDescricao.setDisable(false);
        cbbUnidadeFisica.setDisable(false);
        txtDescricao.setDisable(false);
        cbbGrupo.setDisable(false);
        cbbProdutos.setDisable(false);
        txtNcm.setDisable(false);
        txtCodigo.setDisable(false);
        cbbCategoria.setDisable(false);
        txtPrecoCusto.setDisable(false);
        txtPrecoVenda.setDisable(false);
        txtCodRef.setDisable(false);
        txtQtdeEmbalagem.setDisable(false);
        cbbSituacaoTributaria.setDisable(false);
        txtPercentualPIS.setDisable(false);
        txtAliquotaICMS.setDisable(false);
        txtCest.setDisable(false);
        txtCfop.setDisable(false);
        txtAliquotaCSOCN.setDisable(false);
        txtCSOSN.setDisable(false);
        txtPercentualConfins.setDisable(false);
        txtCstPis.setDisable(false);
        txtCstConfins.setDisable(false);
        txtAliquotaMunicipal.setDisable(false);
        txtAliquotaEstadual.setDisable(false);
        txtAliquotaFederal.setDisable(false);
        txtConsultar.setDisable(false);
        rdbDesc.setDisable(false);
        rdbGrupo.setDisable(false);
        rdbTodos.setDisable(false);
        flagButtons = true;
    }

    @Override
    public Boolean validateFields() {
        boolean flag = true;
        if (descriao == null || descriao.equals("") || descriao.length() < 3) {
            erros += "A descrição do produto deve ser preenchida corretamente! \n";
            flag = false;
        }
        if (qtdeEmbalagem <= 0) {
            erros += "informe a quantidade da embalagem! \n";
            flag = false;
        }
        if (ncm == null || ncm.equals("")) {
            ncm = "N/D";
        }
        if (preco_custo == null || preco_custo.compareTo(BigDecimal.ZERO) <= 0) {
            erros += "O preço de custo deve ser maio que 0! \n";
            flag = false;
        }
        if (preco_venda == null || preco_venda.compareTo(BigDecimal.ZERO) <= 0) {
            erros += "O preço de venda deve ser maio que 0! \n";
            flag = false;
        }
        //--
        if (percentualConfins == null || percentualConfins.compareTo(BigDecimal.ZERO) < 0) {
            erros += "O preço de venda deve ser maio que 0! \n";
            flag = false;
        }
        if (cstpPis == null || cstpPis.compareTo(BigDecimal.ZERO) < 0) {
            erros += "O preço de venda deve ser maio que 0! \n";
            flag = false;
        }
        if (cfop == null || cfop.compareTo(BigDecimal.ZERO) < 0) {
            erros += "O preço de venda deve ser maio que 0! \n";
            flag = false;
        }
        if (cstConfins == null || cstConfins.compareTo(BigDecimal.ZERO) < 0) {
            erros += "O preço de venda deve ser maio que 0! \n";
            flag = false;
        }
        if (percentualConfins == null || percentualConfins.compareTo(BigDecimal.ZERO) < 0) {
            erros += "O preço de venda deve ser maio que 0! \n";
            flag = false;
        }
        if (aliquotaCsosn == null || aliquotaCsosn.compareTo(BigDecimal.ZERO) < 0) {
            erros += "O valor da aliquota deve ser maior ou igual a 0! \n";
            flag = false;
        }
        if (cest == null || cest.compareTo(BigDecimal.ZERO) < 0) {
            erros += "O preço de venda deve ser maio que 0! \n";
            flag = false;
        }
        if (aliquotaIcms == null || aliquotaIcms.compareTo(BigDecimal.ZERO) < 0) {
            erros += "O valor da aliquota deve ser maior ou igual a 0! \n";
            flag = false;
        }
        if (aliquotafederal == null || aliquotafederal.compareTo(BigDecimal.ZERO) < 0) {
            erros += "O valor da aliquota deve ser maior ou igual a 0! \n";
            flag = false;
        }
        if (aliquotaestadual == null || aliquotaestadual.compareTo(BigDecimal.ZERO) < 0) {
            erros += "O valor da aliquota deve ser maior ou igual a 0! \n";
            flag = false;
        }
        if (aliquotamunicipal == null || aliquotamunicipal.compareTo(BigDecimal.ZERO) < 0) {
            erros += "O valor da aliquota deve ser maior ou igual a 0! \n";
            flag = false;
        }
        //--

        if (cbbSituacaoTributaria.getSelectionModel().getSelectedItem() == null) {
            erros += "Você deve selecionar uma Situação tirubutária! \n";
            flag = false;
        }
        if (cbbUnidadeFisica.getSelectionModel().getSelectedItem() == null) {
            erros += "Você deve selecionar uma Unidade física para o produto! \n";
            flag = false;
        }
        if (cbbProdutos.getSelectionModel().getSelectedItem() == null) {
            erros += "Você deve selecionar uma tipo para este produto! \n";
            flag = false;
        }
        if (cbbGrupo.getSelectionModel().getSelectedItem() == null) {
            erros += "Você deve selecionar uma Grupo! \n";
            flag = false;
        }
        return flag;

    }

    @Override
    public void getData() {
        descriao = txtDescricao.getText();
        controller.setUnidadeMedida(cbbUnidadeFisica.getSelectionModel().getSelectedItem());
        descriao = txtDescricao.getText();
        controller.setGrupo(cbbGrupo.getSelectionModel().getSelectedItem());
        controller.setTipoProduto(cbbProdutos.getSelectionModel().getSelectedItem());
        ncm = txtNcm.getText();
        txtCodigo.getText();
        preco_custo = new BigDecimal(txtPrecoCusto.getText());
        preco_venda = new BigDecimal(txtPrecoVenda.getText());
        codigoReferencia = txtCodRef.getText();
        qtdeEmbalagem = new Integer(txtQtdeEmbalagem.getText());
        controller.setSituacaoTributaria(cbbSituacaoTributaria.getSelectionModel().getSelectedItem());
        percentualPis = new BigDecimal(txtPercentualPIS.getText());
        aliquotaIcms = new BigDecimal(txtAliquotaICMS.getText());
        cest = new BigDecimal(txtCest.getText());
        cfop = new BigDecimal(txtCfop.getText());
        aliquotaCsosn = new BigDecimal(txtAliquotaCSOCN.getText());
        aliquotaCsosn = new BigDecimal(txtCSOSN.getText());
        percentualConfins = new BigDecimal(txtPercentualConfins.getText());
        cstpPis = new BigDecimal(txtCstPis.getText());
        cstConfins = new BigDecimal(txtCstConfins.getText());
        aliquotamunicipal = new BigDecimal(txtAliquotaMunicipal.getText());
        aliquotaestadual = new BigDecimal(txtAliquotaEstadual.getText());
        aliquotafederal = new BigDecimal(txtAliquotaFederal.getText());

        txtConsultar.getText();

    }

    @Override
    public void loadDataToScreen() {

    }

    private void loadCbbGrupos() {
        cbbGrupo.setItems(controller.getListaGrupo());
    }

    private void loadCbbTipoProduto() {

        cbbProdutos.getItems().addAll(Arrays.asList(TipoProduto.values()));
    }

    private void loadCbbSituacaoTributaria() {
        cbbSituacaoTributaria.getItems().addAll(Arrays.asList(SituacaoTributaria.values()));
    }

    private void loadCbbUnidadeFisica() {
        cbbUnidadeFisica.getItems().addAll(Arrays.asList(UnidadeMedida.values()));
    }
}
