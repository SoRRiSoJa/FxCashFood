/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashf.controller.produto;

import com.cashf.model.produto.Categoria;
import com.cashf.model.produto.Grupo;
import com.cashf.model.produto.SituacaoTributaria;
import com.cashf.model.produto.TipoProduto;
import com.cashf.model.produto.UnidadeMedida;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
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
import javafx.scene.input.KeyEvent;
import util.PoupUpUtil;
import util.TextFieldFormatter;

/**
 * FXML Controller class
 *
 * @author joao
 */
public class TabProdutoFXMLController implements GenericViewController, Initializable {

    @FXML
    private JFXTextField txtCodigo;
    @FXML
    private JFXTextField txtCodRef;
    @FXML
    private JFXComboBox<TipoProduto> cbbProdutos;
    @FXML
    private JFXTextField txtDescricao;
    @FXML
    private JFXComboBox<UnidadeMedida> cbbUnidadeFisica;
    @FXML
    private JFXTextField txtQtdeEmbalagem;
    @FXML
    private JFXTextField txtPrecoCusto;
    @FXML
    private JFXTextField txtNcm;
    @FXML
    private JFXTextField txtPrecoVenda;
    @FXML
    private JFXTextField txtQtdeProd;
    @FXML
    private JFXComboBox<Grupo> cbbGrupo;
    @FXML
    private JFXComboBox<Categoria> cbbCategoria;
    @FXML
    private JFXComboBox<SituacaoTributaria> cbbSituacaoTributaria;
    @FXML
    private JFXTextField txtPercentualPIS;
    @FXML
    private JFXTextField txtCstPis;
    @FXML
    private JFXTextField txtPercentualConfins;
    @FXML
    private JFXTextField txtCfop;
    @FXML
    private JFXTextField txtCstConfins;
    @FXML
    private JFXTextField txtAliquotaCSOCN;
    @FXML
    private JFXTextField txtCest;
    @FXML
    private JFXTextField txtAliquotaICMS;
    @FXML
    private JFXTextField txtCSOSN;
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
    //---
    private String erros = "";
    private boolean flagButtons;
    private long idProduto;
    private String codigoReferencia;
    private String descriao;
    private BigDecimal qtdeEmbalagem = BigDecimal.ZERO;
    private BigDecimal unidadesEstoque = BigDecimal.ZERO;
    private BigDecimal qtdeProduto = BigDecimal.ZERO;
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
    //--
    private static JFXTextField _txtCodigo;
    private static JFXTextField _txtCodRef;
    private static JFXComboBox<TipoProduto> _cbbProdutos;
    private static JFXTextField _txtDescricao;
    private static JFXComboBox<UnidadeMedida> _cbbUnidadeFisica;
    private static JFXTextField _txtQtdeEmbalagem;
    private static JFXTextField _txtPrecoCusto;
    private static JFXTextField _txtNcm;
    private static JFXTextField _txtPrecoVenda;
    private static JFXTextField _txtQtdeProd;
    private static JFXComboBox<Grupo> _cbbGrupo;
    private static JFXComboBox<Categoria> _cbbCategoria;
    private static JFXComboBox<SituacaoTributaria> _cbbSituacaoTributaria;
    private static JFXTextField _txtPercentualPIS;
    private static JFXTextField _txtCstPis;
    private static JFXTextField _txtPercentualConfins;
    private static JFXTextField _txtCfop;
    private static JFXTextField _txtCstConfins;
    private static JFXTextField _txtAliquotaCSOCN;
    private static JFXTextField _txtCest;
    private static JFXTextField _txtAliquotaICMS;
    private static JFXTextField _txtCSOSN;
    private static JFXTextField _txtAliquotaMunicipal;
    private static JFXTextField _txtAliquotaEstadual;
    private static JFXTextField _txtAliquotaFederal;
    private static JFXButton _btnSalvar;
    private static JFXButton _btnNovo;
    private static JFXButton _btnExcluir;
    private static JFXButton _btnLimpar;
    private static Label _lblTotal;
    @FXML
    private Label lblTotal;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        _txtCodigo = txtCodigo;
        _txtCodRef = txtCodRef;
        _cbbProdutos = cbbProdutos;
        _txtDescricao = txtDescricao;
        _cbbUnidadeFisica = cbbUnidadeFisica;
        _txtQtdeEmbalagem = txtQtdeEmbalagem;
        _txtPrecoCusto = txtPrecoCusto;
        _txtNcm = txtNcm;
        _txtPrecoVenda = txtPrecoVenda;
        _txtQtdeProd = txtQtdeProd;
        _cbbGrupo = cbbGrupo;
        _cbbCategoria = cbbCategoria;
        _cbbSituacaoTributaria = cbbSituacaoTributaria;
        _txtPercentualPIS = txtPercentualPIS;
        _txtCstPis = txtCstPis;
        _txtPercentualConfins = txtPercentualConfins;
        _txtCfop = txtCfop;
        _txtCstConfins = txtCstConfins;
        _txtAliquotaCSOCN = txtAliquotaCSOCN;
        _txtCest = txtCest;
        _txtAliquotaICMS = txtAliquotaICMS;
        _txtCSOSN = txtCSOSN;
        _txtAliquotaMunicipal = txtAliquotaMunicipal;
        _txtAliquotaEstadual = txtAliquotaEstadual;
        _txtAliquotaFederal = txtAliquotaFederal;
        _btnSalvar = btnSalvar;
        _btnExcluir = btnExcluir;
        _btnLimpar = btnLimpar;
        _btnNovo = btnNovo;
        _lblTotal = lblTotal;
        setInputOff();
        loadCbbGrupos();
        loadCbbSituacaoTributaria();
        loadCbbTipoProduto();
        loadCbbUnidadeFisica();
        if (ProdutoController.getInstance().getProduto().getIdProduto() != 0l) {
            loadDataToScreen();
        }
    }

    @FXML
    private void onSelecionarGrupo(ActionEvent event) {
        if (cbbGrupo.getSelectionModel().getSelectedItem() != null) {
            ProdutoController.getInstance().setGrupo(cbbGrupo.getSelectionModel().getSelectedItem());
            cbbCategoria.getItems().add(ProdutoController.getInstance().getGrupo().getCategoria());
            cbbCategoria.setValue(ProdutoController.getInstance().getGrupo().getCategoria());
        }
    }

    @FXML
    private void onSalvar(ActionEvent event) {
        getData();
        if (validateFields()) {
            ProdutoController.getInstance().setProduto(idProduto, codigoReferencia, descriao, qtdeEmbalagem, unidadesEstoque, qtdeProduto, ncm, preco_custo, preco_venda, ProdutoController.getInstance().getGrupo(), ProdutoController.getInstance().getUnidadeMedida(), ProdutoController.getInstance().getTipoProduto(), Boolean.TRUE);
            ProdutoController.getInstance().setAliquotaProduto(idAliquota, percentualPis, cstpPis, cfop, cstConfins, percentualConfins, aliquotaCsosn, cest, aliquotaIcms, aliquotafederal, aliquotamunicipal, aliquotaestadual);
            if (ProdutoController.getInstance().getProduto().getIdProduto() == 0l) {

                ProdutoController.getInstance().insert();
                clearFields();
                PoupUpUtil.poupUp("Produto Cadastrado", "O Produto foi cadastrado com sucesso.", "");
            } else {

                ProdutoController.getInstance().update();
                PoupUpUtil.poupUp("Produto Alterado", "O Produto foi alterado com sucesso.", "");
            }
        } else {
            PoupUpUtil.accessDenied(erros);
            erros = "";
        }
    }

    @FXML
    private void onNovo(ActionEvent event) {
        setInputOn();
        btnNovo.setDisable(true);
        if (ProdutoController.getInstance().getProduto().getIdProduto() == 0) {
            btnExcluir.setDisable(true);
            clearFields();
        } else {
            btnExcluir.setDisable(false);
        }

    }

    @FXML
    private void onExcluir(ActionEvent event) {
        if (ProdutoController.getInstance().getProduto() != null) {
            ProdutoController.getInstance().delete();
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
        txtQtdeProd.clear();
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
        lblTotal.setText("");

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
        txtQtdeProd.setDisable(true);
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
        txtQtdeProd.setDisable(false);
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
        flagButtons = true;
    }

    @Override
    public Boolean validateFields() {
        boolean flag = true;
        if (descriao == null || descriao.equals("") || descriao.length() < 3) {
            erros += "A descrição do produto deve ser preenchida corretamente! \n";
            flag = false;
        }
        if (qtdeEmbalagem.compareTo(BigDecimal.ZERO) <= 0) {
            erros += "informe a quantidade da embalagem! \n";
            flag = false;
        }
        if (qtdeProduto.compareTo(BigDecimal.ZERO) <= 0) {
            erros += "informe a quantidade em estoque! \n";
            flag = false;
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
        idProduto = (ProdutoController.getInstance().getProduto().getIdProduto() != 0l) ? ProdutoController.getInstance().getProduto().getIdProduto() : 0l;
        idAliquota = (ProdutoController.getInstance().getAliquotaProduto().getIdAliquota() != 0l) ? ProdutoController.getInstance().getAliquotaProduto().getIdAliquota() : 0l;
        descriao = txtDescricao.getText();
        ProdutoController.getInstance().setUnidadeMedida(cbbUnidadeFisica.getSelectionModel().getSelectedItem());
        descriao = txtDescricao.getText();
        ProdutoController.getInstance().setGrupo(cbbGrupo.getSelectionModel().getSelectedItem());
        ProdutoController.getInstance().setTipoProduto(cbbProdutos.getSelectionModel().getSelectedItem());
        ncm = txtNcm.getText();
        preco_custo = new BigDecimal(txtPrecoCusto.getText());
        preco_venda = new BigDecimal(txtPrecoVenda.getText());
        codigoReferencia = txtCodRef.getText();
        qtdeEmbalagem = new BigDecimal(txtQtdeEmbalagem.getText());
        unidadesEstoque = new BigDecimal(txtQtdeProd.getText());
        qtdeProduto = unidadesEstoque.multiply(qtdeEmbalagem);
        ProdutoController.getInstance().setSituacaoTributaria(cbbSituacaoTributaria.getSelectionModel().getSelectedItem());
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
        lblTotal.setText(qtdeProduto.toString());
    }

    @Override
    public void loadDataToScreen() {
        txtDescricao.setText(ProdutoController.getInstance().getProduto().getDescriao());
        cbbUnidadeFisica.setValue(ProdutoController.getInstance().getProduto().getUnidadeMedida());
        cbbGrupo.setValue(ProdutoController.getInstance().getProduto().getGrupo());
        cbbProdutos.setValue(ProdutoController.getInstance().getProduto().getTipo());
        txtNcm.setText(ProdutoController.getInstance().getProduto().getNcm());
        txtCodigo.setText(ProdutoController.getInstance().getProduto().getIdProduto() + "");
        cbbCategoria.setValue(ProdutoController.getInstance().getProduto().getGrupo().getCategoria());
        txtPrecoCusto.setText(ProdutoController.getInstance().getProduto().getPreco_custo() + "");
        txtPrecoVenda.setText(ProdutoController.getInstance().getProduto().getPreco_venda() + "");
        txtCodRef.setText(ProdutoController.getInstance().getProduto().getCodigoReferencia());
        txtQtdeEmbalagem.setText(ProdutoController.getInstance().getProduto().getQtdeEmbalagem() + "");
        txtQtdeProd.setText(ProdutoController.getInstance().getProduto().getQtdeProduto() + "");
        cbbSituacaoTributaria.setValue(ProdutoController.getInstance().getProduto().getAliquotasProduto().getSituacaoTributaria());
        txtPercentualPIS.setText(ProdutoController.getInstance().getProduto().getAliquotasProduto().getPercentualPis() + "");
        txtAliquotaICMS.setText(ProdutoController.getInstance().getProduto().getAliquotasProduto().getAliquotaIcms() + "");
        txtCest.setText(ProdutoController.getInstance().getProduto().getAliquotasProduto().getCest() + "");
        txtCfop.setText(ProdutoController.getInstance().getProduto().getAliquotasProduto().getCfop() + "");
        txtAliquotaCSOCN.setText(ProdutoController.getInstance().getProduto().getAliquotasProduto().getAliquotaCsosn() + "");
        //txtCSOSN.setText(ProdutoController.getInstance().getProduto().getAliquotasProduto().getAliquotaCsosn());
        txtPercentualConfins.setText(ProdutoController.getInstance().getProduto().getAliquotasProduto().getPercentualConfins() + "");
        txtCstPis.setText(ProdutoController.getInstance().getProduto().getAliquotasProduto().getCstpPis() + "");
        txtCstConfins.setText(ProdutoController.getInstance().getProduto().getAliquotasProduto().getCstConfins() + "");
        txtAliquotaMunicipal.setText(ProdutoController.getInstance().getProduto().getAliquotasProduto().getAliquotamunicipal() + "");
        txtAliquotaEstadual.setText(ProdutoController.getInstance().getProduto().getAliquotasProduto().getAliquotaestadual() + "");
        txtAliquotaFederal.setText(ProdutoController.getInstance().getProduto().getAliquotasProduto().getAliquotafederal() + "");
    }

    public static void ldts() {
        _txtDescricao.setText(ProdutoController.getInstance().getProduto().getDescriao());
        _cbbUnidadeFisica.setValue(ProdutoController.getInstance().getProduto().getUnidadeMedida());
        _cbbGrupo.setValue(ProdutoController.getInstance().getProduto().getGrupo());
        _cbbProdutos.setValue(ProdutoController.getInstance().getProduto().getTipo());
        _txtNcm.setText(ProdutoController.getInstance().getProduto().getNcm());
        _txtCodigo.setText(ProdutoController.getInstance().getProduto().getIdProduto() + "");
        _cbbCategoria.setValue(ProdutoController.getInstance().getProduto().getGrupo().getCategoria());
        _txtPrecoCusto.setText(ProdutoController.getInstance().getProduto().getPreco_custo() + "");
        _txtPrecoVenda.setText(ProdutoController.getInstance().getProduto().getPreco_venda() + "");
        _txtCodRef.setText(ProdutoController.getInstance().getProduto().getCodigoReferencia());
        _txtQtdeEmbalagem.setText(ProdutoController.getInstance().getProduto().getQtdeEmbalagem() + "");
        _txtQtdeProd.setText(ProdutoController.getInstance().getProduto().getUnidadesEstoque() + "");
        _cbbSituacaoTributaria.setValue(ProdutoController.getInstance().getProduto().getAliquotasProduto().getSituacaoTributaria());
        _txtPercentualPIS.setText(ProdutoController.getInstance().getProduto().getAliquotasProduto().getPercentualPis() + "");
        _txtAliquotaICMS.setText(ProdutoController.getInstance().getProduto().getAliquotasProduto().getAliquotaIcms() + "");
        _txtCest.setText(ProdutoController.getInstance().getProduto().getAliquotasProduto().getCest() + "");
        _txtCfop.setText(ProdutoController.getInstance().getProduto().getAliquotasProduto().getCfop() + "");
        _txtAliquotaCSOCN.setText(ProdutoController.getInstance().getProduto().getAliquotasProduto().getAliquotaCsosn() + "");
        //txtCSOSN.setText(ProdutoController.getInstance().getProduto().getAliquotasProduto().getAliquotaCsosn());
        _txtPercentualConfins.setText(ProdutoController.getInstance().getProduto().getAliquotasProduto().getPercentualConfins() + "");
        _txtCstPis.setText(ProdutoController.getInstance().getProduto().getAliquotasProduto().getCstpPis() + "");
        _txtCstConfins.setText(ProdutoController.getInstance().getProduto().getAliquotasProduto().getCstConfins() + "");
        _txtAliquotaMunicipal.setText(ProdutoController.getInstance().getProduto().getAliquotasProduto().getAliquotamunicipal() + "");
        _txtAliquotaEstadual.setText(ProdutoController.getInstance().getProduto().getAliquotasProduto().getAliquotaestadual() + "");
        _txtAliquotaFederal.setText(ProdutoController.getInstance().getProduto().getAliquotasProduto().getAliquotafederal() + "");
        _lblTotal.setText(ProdutoController.getInstance().getProduto().getQtdeProduto() + "");
        _btnExcluir.setDisable(false);
    }

    private void loadCbbGrupos() {
        cbbGrupo.setItems(ProdutoController.getInstance().getListaGrupo());
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

    @FXML
    private void onKeyReleasedPrecoCusto(KeyEvent event) {
        TextFieldFormatter tff = new TextFieldFormatter();
        tff.setMask("###.##");
        tff.setCaracteresValidos("0123456789");
        tff.setTf(txtPrecoCusto);
        tff.formatter();
    }

    @FXML
    private void onKeyReleasedPrecoVenda(KeyEvent event) {
        TextFieldFormatter tff = new TextFieldFormatter();
        tff.setMask("###.##");
        tff.setCaracteresValidos("0123456789");
        tff.setTf(txtPrecoVenda);
        tff.formatter();
    }

    private void onKeyReleasedPisPercent(KeyEvent event) {
        TextFieldFormatter tff = new TextFieldFormatter();
        tff.setMask("##.###");
        tff.setCaracteresValidos("0123456789");
        tff.setTf(txtPercentualPIS);
        tff.formatter();
    }

    @FXML
    private void onKeyReleasedconfisnPercent(KeyEvent event) {
        TextFieldFormatter tff = new TextFieldFormatter();
        tff.setMask("##.###");
        tff.setCaracteresValidos("0123456789");
        tff.setTf(txtPercentualConfins);
        tff.formatter();
    }

    @FXML
    private void onKeyReleasedCFOP(KeyEvent event) {
        TextFieldFormatter tff = new TextFieldFormatter();
        tff.setMask("####");
        tff.setCaracteresValidos("0123456789");
        tff.setTf(txtCfop);
        tff.formatter();
    }

    @FXML
    private void onKeyReleasedCstConfins(KeyEvent event) {
        TextFieldFormatter tff = new TextFieldFormatter();
        tff.setMask("##");
        tff.setCaracteresValidos("0123456789");
        tff.setTf(txtCstConfins);
        tff.formatter();
    }

    @FXML
    private void onKeyReleasedALCsosn(KeyEvent event) {
        TextFieldFormatter tff = new TextFieldFormatter();
        tff.setMask("##.###");
        tff.setCaracteresValidos("0123456789");
        tff.setTf(txtAliquotaCSOCN);
        tff.formatter();
    }

    @FXML
    private void onKeyReleasedCest(KeyEvent event) {
        TextFieldFormatter tff = new TextFieldFormatter();
        tff.setMask("##.###");
        tff.setCaracteresValidos("0123456789");
        tff.setTf(txtCest);
        tff.formatter();
    }

    @FXML
    private void onKeyReleasedALIcms(KeyEvent event) {
        TextFieldFormatter tff = new TextFieldFormatter();
        tff.setMask("##.###");
        tff.setCaracteresValidos("0123456789");
        tff.setTf(txtAliquotaICMS);
        tff.formatter();
    }

    @FXML
    private void onKeyReleasedCsosn(KeyEvent event) {
        TextFieldFormatter tff = new TextFieldFormatter();
        tff.setMask("##.###");
        tff.setCaracteresValidos("0123456789");
        tff.setTf(txtCSOSN);
        tff.formatter();
    }

    @FXML
    private void onKeyReleasedALMunicipal(KeyEvent event) {
        TextFieldFormatter tff = new TextFieldFormatter();
        tff.setMask("##.###");
        tff.setCaracteresValidos("0123456789");
        tff.setTf(txtAliquotaMunicipal);
        tff.formatter();
    }

    @FXML
    private void onKeyReleasedALEstadual(KeyEvent event) {
        TextFieldFormatter tff = new TextFieldFormatter();
        tff.setMask("##.###");
        tff.setCaracteresValidos("0123456789");
        tff.setTf(txtAliquotaEstadual);
        tff.formatter();
    }

    @FXML
    private void onKeyReleasedAlFederal(KeyEvent event) {
        TextFieldFormatter tff = new TextFieldFormatter();
        tff.setMask("##.###");
        tff.setCaracteresValidos("0123456789");
        tff.setTf(txtAliquotaFederal);
        tff.formatter();
    }

    @FXML
    private void onKeyReleasedQtde(KeyEvent event) {
        TextFieldFormatter tff = new TextFieldFormatter();
        tff.setMask("####");
        tff.setCaracteresValidos("0123456789");
        tff.setTf(txtQtdeProd);
        tff.formatter();
        if (txtQtdeProd.getText().length() == 4) {
            try {
                BigDecimal qtdeAux = new BigDecimal(txtQtdeProd.getText());
                lblTotal.setText(new BigDecimal(txtQtdeEmbalagem.getText()).multiply(qtdeAux) + "");
            } catch (Exception ex) {
                System.out.println("Erro ao converter----->:" + ex);
            }
        }
    }

    @FXML
    private void onKeyReleasedPISPercent(KeyEvent event) {
        TextFieldFormatter tff = new TextFieldFormatter();
        tff.setMask("##.###");
        tff.setCaracteresValidos("0123456789");
        tff.setTf(txtPercentualPIS);
        tff.formatter();
    }

    @FXML
    private void onKeyReleasedCSTPis(KeyEvent event) {
        TextFieldFormatter tff = new TextFieldFormatter();
        tff.setMask("##");
        tff.setCaracteresValidos("0123456789");
        tff.setTf(txtCstPis);
        tff.formatter();
    }

    public static void setBtnEX(Boolean sta) {
        _btnExcluir.setDisable(sta);
    }
}
