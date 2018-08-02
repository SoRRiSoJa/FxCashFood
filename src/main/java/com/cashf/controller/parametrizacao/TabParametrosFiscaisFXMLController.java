/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashf.controller.parametrizacao;

import com.cashf.model.parametros.ParametrosFiscais;
import com.cashf.model.produto.SituacaoTributaria;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.KeyEvent;

/**
 * FXML Controller class
 *
 * @author joao
 */
public class TabParametrosFiscaisFXMLController implements GenericViewController, Initializable {
    
    @FXML
    private JFXComboBox<SituacaoTributaria> cbbSituacaoTributaria;
    @FXML
    private TableView<ParametrosFiscais> tbvSituacao;
    @FXML
    private TableColumn<ParametrosFiscais, String> tbcSituacao;
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
    //----
    String erros = "";
    BigDecimal PercentualPIS;
    BigDecimal CstPis;
    BigDecimal PercentualConfins;
    BigDecimal Cfop;
    BigDecimal CstConfins;
    BigDecimal AliquotaCSOCN;
    BigDecimal Cest;
    BigDecimal AliquotaICMS;
    BigDecimal CSOSN;
    BigDecimal AliquotaMunicipal;
    BigDecimal AliquotaEstadual;
    BigDecimal AliquotaFederal;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        loadCBBST();
    }
    
    @FXML
    private void onKeyReleasedPISPercent(KeyEvent event) {
    }
    
    @FXML
    private void onKeyReleasedCSTPis(KeyEvent event) {
    }
    
    @FXML
    private void onKeyReleasedconfisnPercent(KeyEvent event) {
    }
    
    @FXML
    private void onKeyReleasedCFOP(KeyEvent event) {
    }
    
    @FXML
    private void onKeyReleasedCstConfins(KeyEvent event) {
    }
    
    @FXML
    private void onKeyReleasedALCsosn(KeyEvent event) {
    }
    
    @FXML
    private void onKeyReleasedCest(KeyEvent event) {
    }
    
    @FXML
    private void onKeyReleasedALIcms(KeyEvent event) {
    }
    
    @FXML
    private void onKeyReleasedCsosn(KeyEvent event) {
    }
    
    @FXML
    private void onKeyReleasedALMunicipal(KeyEvent event) {
    }
    
    @FXML
    private void onKeyReleasedALEstadual(KeyEvent event) {
    }
    
    @FXML
    private void onKeyReleasedAlFederal(KeyEvent event) {
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
        txtPercentualPIS.clear();
        txtCstPis.clear();
        txtPercentualConfins.clear();
        txtCfop.clear();
        txtCstConfins.clear();
        txtAliquotaCSOCN.clear();
        txtCest.clear();
        txtAliquotaICMS.clear();
        txtCSOSN.clear();
        txtAliquotaMunicipal.clear();
        txtAliquotaEstadual.clear();
        txtAliquotaFederal.clear();
    }
    
    @Override
    public void setInputOff() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void setInputOn() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private void setInputStatus(boolean status) {
        txtPercentualPIS.setDisable(status);
        txtCstPis.setDisable(status);
        txtPercentualConfins.setDisable(status);
        txtCfop.setDisable(status);
        txtCstConfins.setDisable(status);
        txtAliquotaCSOCN.setDisable(status);
        txtCest.setDisable(status);
        txtAliquotaICMS.setDisable(status);
        txtCSOSN.setDisable(status);
        txtAliquotaMunicipal.setDisable(status);
        txtAliquotaEstadual.setDisable(status);
        txtAliquotaFederal.setDisable(status);
    }
    
    @Override
    public Boolean validateFields() {
        Boolean flag = true;
        try {
            PercentualPIS = new BigDecimal(txtPercentualPIS.getText());
        } catch (Exception ex) {
            erros += "Percentual do PIS  - Valor inválido ou nulo, verifique o valor. ";
            flag = false;
        }
        try {
            CstPis = new BigDecimal(txtCstPis.getText());
        } catch (Exception ex) {
            erros += "CstPis  - Valor inválido ou nulo, verifique o valor. ";
            flag = false;
        }
        try {
            Cfop = new BigDecimal(txtCfop.getText());
        } catch (Exception ex) {
            erros += "Cfop - Valor inválido ou nulo, verifique o valor. ";
            flag = false;
        }
        try {
            CstPis = new BigDecimal(txtCstPis.getText());
        } catch (Exception ex) {
            erros += "CstPis  - Valor inválido ou nulo, verifique o valor. ";
            flag = false;
        }
        try {
            CstConfins = new BigDecimal(txtCstConfins.getText());
        } catch (Exception ex) {
            erros += "Cst Confins  - Valor inválido ou nulo, verifique o valor. ";
            flag = false;
        }
        try {
            AliquotaCSOCN = new BigDecimal(txtAliquotaCSOCN.getText());
        } catch (Exception ex) {
            erros += "Aliquota CSOCN  - Valor inválido ou nulo, verifique o valor. ";
            flag = false;
        }
        try {
            Cest = new BigDecimal(txtCest.getText());
        } catch (Exception ex) {
            erros += "Cest  - Valor inválido ou nulo, verifique o valor. ";
            flag = false;
        }
        try {
            AliquotaICMS = new BigDecimal(txtAliquotaICMS.getText());
        } catch (Exception ex) {
            erros += "Aliquota ICMS  - Valor inválido ou nulo, verifique o valor. ";
            flag = false;
        }
        try {
            CSOSN = new BigDecimal(txtCSOSN.getText());
        } catch (Exception ex) {
            erros += "CSOSN  - Valor inválido ou nulo, verifique o valor. ";
            flag = false;
        }
        try {
            AliquotaMunicipal = new BigDecimal(txtAliquotaMunicipal.getText());
        } catch (Exception ex) {
            erros += "Aliquota Municipal  - Valor inválido ou nulo, verifique o valor. ";
            flag = false;
        }
        try {
            AliquotaEstadual = new BigDecimal(txtAliquotaEstadual.getText());
        } catch (Exception ex) {
            erros += "Aliquota Estadual  - Valor inválido ou nulo, verifique o valor. ";
            flag = false;
        }
        try {
            AliquotaFederal = new BigDecimal(txtAliquotaFederal.getText());
        } catch (Exception ex) {
            erros += "Aliquota Federal  - Valor inválido ou nulo, verifique o valor. ";
            flag = false;
        }
        return flag;
    }
    
    @Override
    public void getData() {
        txtPercentualPIS.getText();
        txtCstPis.getText();
        txtPercentualConfins.getText();
        txtCfop.getText();
        txtCstConfins.getText();
        txtAliquotaCSOCN.getText();
        txtCest.getText();
        txtAliquotaICMS.getText();
        txtCSOSN.getText();
        txtAliquotaMunicipal.getText();
        txtAliquotaEstadual.getText();
        txtAliquotaFederal.getText();
    }
    
    @Override
    public void loadDataToScreen() {
        txtPercentualPIS.setText(ParametrosController.getInstance().getParametrosFiscais().getPercentualPis().toString());
        txtCstPis.setText(ParametrosController.getInstance().getParametrosFiscais().getCstpPis().toString());
        txtPercentualConfins.setText(ParametrosController.getInstance().getParametrosFiscais().getPercentualConfins().toString());
        txtCfop.setText(ParametrosController.getInstance().getParametrosFiscais().getCfop().toString());
        txtCstConfins.setText(ParametrosController.getInstance().getParametrosFiscais().getCstConfins().toString());
        txtAliquotaCSOCN.setText(ParametrosController.getInstance().getParametrosFiscais().getAliquotaCsosn().toString());
        txtCest.setText(ParametrosController.getInstance().getParametrosFiscais().getCest().toString());
        txtAliquotaICMS.setText(ParametrosController.getInstance().getParametrosFiscais().getAliquotaIcms().toString());
        txtCSOSN.setText("");
        txtAliquotaMunicipal.setText(ParametrosController.getInstance().getParametrosFiscais().getAliquotamunicipal().toString());
        txtAliquotaEstadual.setText(ParametrosController.getInstance().getParametrosFiscais().getAliquotaestadual().toString());
        txtAliquotaFederal.setText(ParametrosController.getInstance().getParametrosFiscais().getAliquotafederal().toString());
    }
    
    private void loadCBBST() {
        cbbSituacaoTributaria.getItems().addAll(Arrays.asList(SituacaoTributaria.values()));
    }
    
    @FXML
    private void onSelectST(ActionEvent event) {
        if (cbbSituacaoTributaria.getSelectionModel().getSelectedItem() != null) {
            ParametrosController.getInstance().setSituacaoTributaria(cbbSituacaoTributaria.getItems().get(cbbSituacaoTributaria.getSelectionModel().getSelectedIndex()));
        }
        onSituacaoTributaria();
    }
    
    private void onSituacaoTributaria() {
        switch (ParametrosController.getInstance().getSituacaoTributaria()) {
            case ISENTO:
                ParametrosController.getInstance().setParametrosFiscais(ParametrosController.getInstance().consultaST(SituacaoTributaria.ISENTO));
                break;
            case NAO_INCIDENTE:
                ParametrosController.getInstance().setParametrosFiscais(ParametrosController.getInstance().consultaST(SituacaoTributaria.NAO_INCIDENTE));
                break;
            case SERVICO:
                ParametrosController.getInstance().setParametrosFiscais(ParametrosController.getInstance().consultaST(SituacaoTributaria.SERVICO));
                break;
            case SUBSTITUICAO_TRIBUTARIA:
                ParametrosController.getInstance().setParametrosFiscais(ParametrosController.getInstance().consultaST(SituacaoTributaria.SUBSTITUICAO_TRIBUTARIA));
                break;
            case TRIBUTADO:
                ParametrosController.getInstance().setParametrosFiscais(ParametrosController.getInstance().consultaST(SituacaoTributaria.TRIBUTADO));
                break;
        }
        if (ParametrosController.getInstance().getParametrosFiscais() != null) {
            loadDataToScreen();
        } else {
            ParametrosController.getInstance().setParametrosFiscais(new ParametrosFiscais());
            ParametrosController.getInstance().getParametrosFiscais().setIdParametroFiscal(0l);
        }
        
    }
}
