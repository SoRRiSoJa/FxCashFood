/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashf.controller.registradora;

import com.cashf.cashfood.MainApp;
import com.cashf.core.venda.VendaController;
import com.cashf.model.funcionario.Funcionario;
import com.cashf.model.produto.Produto;
import com.cashf.model.produto.TipoProduto;
import com.cashf.model.venda.ProdutoVenda;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Callback;
import util.PoupUpUtil;

/**
 * FXML Controller class
 *
 * @author joao
 */
public class NRegistradoraFXMLController implements Initializable {

    @FXML
    private TextField txtMesa;
    @FXML
    private JFXComboBox<Funcionario> cbbGarcom;
    @FXML
    private JFXComboBox<Produto> cbbProduto;
    @FXML
    private TextField txtQtde;
    @FXML
    private TextField txtDescricao;
    @FXML
    private TextField txtObsItem;
    @FXML
    private Pane paneTeclado;
    @FXML
    private JFXButton btn7;
    @FXML
    private JFXButton btn8;
    @FXML
    private JFXButton btn9;
    @FXML
    private JFXButton btn4;
    @FXML
    private JFXButton btn5;
    @FXML
    private JFXButton btn6;
    @FXML
    private JFXButton btn1;
    @FXML
    private JFXButton btn2;
    @FXML
    private JFXButton btn3;
    @FXML
    private JFXButton btnLimpar;
    @FXML
    private JFXButton btn0;
    @FXML
    private JFXButton btnVirgula;
    @FXML
    private JFXButton btnPagto;
    @FXML
    private JFXButton btnEnter;
    @FXML
    private TableView<ProdutoVenda> tbvComanda;
    @FXML
    private TableColumn<ProdutoVenda, String> tbcCod;
    @FXML
    private TableColumn<ProdutoVenda, String> tbcDescricao;
    @FXML
    private TableColumn<ProdutoVenda, Integer> tbcQtde;
    @FXML
    private TableColumn<ProdutoVenda, BigDecimal> tbcPreco;
    @FXML
    private TableColumn<ProdutoVenda, BigDecimal> tbcTotal;
    @FXML
    private Label lblTrocoAnt;
    @FXML
    private Label lblTotal;
    //-----
    private String qtdeProduto;
    private String codigoProduto = "";
    private String mesa = "";
    private String erros = "";
    private Integer qtdeProd;
    private Integer nMesa;

    private int foco = 1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        loadCbbFunc();
        loadCbbProd();
        setUptableViewProdutos();
    }

    @FXML
    private void onMouseClickMesa(MouseEvent event) {
        foco = 1;
    }

    @FXML
    private void onBtn_7(ActionEvent event) {
        concatResult("7", foco);
    }

    @FXML
    private void onBtn_8(ActionEvent event) {
        concatResult("8", foco);
    }

    @FXML
    private void onBtn_9(ActionEvent event) {
        concatResult("9", foco);
    }

    @FXML
    private void onBtn_4(ActionEvent event) {
        concatResult("4", foco);
    }

    @FXML
    private void onBtn_5(ActionEvent event) {
        concatResult("5", foco);
    }

    @FXML
    private void onBtn_6(ActionEvent event) {
        concatResult("6", foco);
    }

    @FXML
    private void onBtn_1(ActionEvent event) {
        concatResult("1", foco);
    }

    @FXML
    private void onBtn_2(ActionEvent event) {
        concatResult("2", foco);
    }

    @FXML
    private void onBtn_3(ActionEvent event) {
        concatResult("3", foco);
    }

    @FXML
    private void onLimpar(ActionEvent event) {
    }

    @FXML
    private void onBtn_0(ActionEvent event) {
        concatResult("0", foco);
    }

    @FXML
    private void onBtn_Virgula(ActionEvent event) {
        concatResult(",", foco);
    }

    @FXML
    private void onPagar(ActionEvent event) {
    }

    @FXML
    private void onEnter(ActionEvent event) {
        if (validateFields()) {
            getData();
            tbvComanda.setItems(RegistradoraController.getInstance().getListaProdutoVenda());
        } else {
            PoupUpUtil.accessDenied(erros);
            //PoupUpUtil.errorMessage(MainApp.paneRoot,rootStackPane, erros);
            erros = "";
        }
    }

    private void concatResult(String num, int foco) {
        switch (foco) {
            case 1:
                if (txtMesa.getText() == null || txtMesa.getText().isEmpty()) {
                    txtMesa.setText(num);
                } else {
                    txtMesa.setText(txtMesa.getText() + num);
                }
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                if (txtQtde.getText() == null || txtQtde.getText().isEmpty()) {
                    txtQtde.setText(num);
                } else {
                    txtQtde.setText(txtQtde.getText() + num);
                }
                break;
        }

    }

    @FXML
    private void onBuscarCodigo(KeyEvent event) {
    }

    @FXML
    private void onMouseClickQtde(MouseEvent event) {
        foco = 4;
    }

    private void loadCbbFunc() {
        cbbGarcom.setItems(RegistradoraController.getInstance().getListaFuncioanrio());
    }

    private void loadCbbProd() {
        cbbProduto.setItems(RegistradoraController.getInstance().getLista());
        cbbProduto.setCellFactory(
                new Callback<ListView<Produto>, ListCell<Produto>>() {
            @Override
            public ListCell<Produto> call(ListView<Produto> p) {
                ListCell cell = new ListCell<Produto>() {
                    @Override
                    protected void updateItem(Produto item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setText("");
                        } else {
                            setText(item.getCodigoReferencia());
                        }
                    }
                };
                return cell;
            }
        });
    }

    private void setUptableViewProdutos() {
        tbcCod.setCellValueFactory((param) -> new SimpleStringProperty(param.getValue().getProduto().getCodigoReferencia()));
        tbcDescricao.setCellValueFactory(new PropertyValueFactory<>("produto"));
        tbcQtde.setCellValueFactory(new PropertyValueFactory<>("qtde"));
        tbcPreco.setCellValueFactory(new PropertyValueFactory<>("precoUnit"));
        tbcTotal.setCellValueFactory((param) -> new SimpleObjectProperty<BigDecimal>(param.getValue().getPrecoUnit().multiply(param.getValue().getQtde())));
        tbvComanda.getColumns().setAll(tbcCod, tbcDescricao, tbcQtde, tbcPreco, tbcTotal);
    }

    @FXML
    private void onKeyReleasedMesa(KeyEvent event) {

    }

    @FXML
    private void onCodigoProduto(ActionEvent event) {
        if (cbbProduto.getSelectionModel().getSelectedItem() != null) {
            txtDescricao.setText(cbbProduto.getSelectionModel().getSelectedItem().getDescriao());
        }
    }

    private boolean validateFields() {
        boolean flag = true;
        mesa = txtMesa.getText();
        qtdeProduto = txtQtde.getText();
        if (cbbProduto.getSelectionModel().getSelectedItem() == null) {
            erros = "Selecione um produto para lançar \n";
            flag = false;
        }
        if (mesa.isEmpty()) {
            erros = "Selecione uma mesa para o lançamento. \n";
            flag = false;
        }
        try {
            nMesa = Integer.parseInt(mesa);
            if (nMesa <= 0 || nMesa > 18) {
                erros = "Mesa não existe. \n";
                flag = false;
            }
        } catch (Exception ex) {
            erros = "Mesa Inválida verifique o número informado. \n";
            flag = false;
        }

        if (qtdeProduto.isEmpty()) {
            erros = "Informe a quantidade a ser lançada. \n";
            flag = false;
        }
        try {
            qtdeProd = Integer.parseInt(qtdeProduto);
            if (qtdeProd <= 0) {
                erros = "Informe uma quantidade para o produto. \n";
                flag = false;
            }
        } catch (Exception ex) {
            erros = "Quantidade inválida verifique o númeor informado. \n";
            flag = false;
        }
        return flag;
    }

    private void getData() {
        RegistradoraController.getInstance().setVenda(nMesa);
        VendaController.getInstance().setProdutoSelecionado(cbbProduto.getItems().get(cbbProduto.getSelectionModel().getSelectedIndex()));
        if (VendaController.getInstance().getProdutoSelecionado().getTipo().equals(TipoProduto.COMBO)) {
            VendaController.getInstance().selCombo();
            loadBox("/fxml/mesas/RegistrarConsumoComboFXML.fxml", "COMBO");

        }
        VendaController.getInstance().setListaProduosVenda(0l, VendaController.getInstance().getVenda(),
                VendaController.getInstance().getProdutoSelecionado(),
                BigDecimal.valueOf(qtdeProd),
                VendaController.getInstance().getProdutoSelecionado().getPreco_venda());
        VendaController.getInstance().getVenda().setValorTotal(VendaController.getInstance().getVenda().getValorTotal().add(BigDecimal.valueOf(qtdeProd).multiply(VendaController.getInstance().getProdutoSelecionado().getPreco_venda())));
        RegistradoraController.getInstance().setFuncionario(cbbGarcom.getItems().get(cbbGarcom.getSelectionModel().getSelectedIndex()));
        RegistradoraController.getInstance().setListaProduosVenda(0l,
                cbbProduto.getItems().get(cbbProduto.getSelectionModel().getSelectedIndex()),
                BigDecimal.valueOf(qtdeProd));
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

}
