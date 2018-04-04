/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashf.controller.prepreparo;

import com.cashf.model.prepreparo.PrePreparo;
import com.cashf.model.produto.Produto;
import com.cashf.model.produto.UnidadeMedida;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import java.math.BigDecimal;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author joao
 */
public class TapListaPrePreparoFXMLController implements Initializable {

    @FXML
    private TableView<PrePreparo> tbvProdutos;
    @FXML
    private TableColumn<PrePreparo, Produto> tbcDescricao;
    @FXML
    private TableColumn<PrePreparo, LocalDate> tbcData;
    @FXML
    private TableColumn<PrePreparo, BigDecimal> tbcCusto;
    @FXML
    private TableColumn<PrePreparo, UnidadeMedida> tbcUnidade;
    @FXML
    private TableColumn<PrePreparo, BigDecimal> tbcQtde;
    @FXML
    private JFXTextField txtConsultar;
    @FXML
    private JFXButton btnPesquisar;
    @FXML
    private JFXRadioButton rdbDesc;
    @FXML
    private JFXRadioButton rdbData;
    @FXML
    private JFXRadioButton rdbTodos;
    //----
    private static TableView<PrePreparo> _tbvProdutos;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        _tbvProdutos = tbvProdutos;
        setUpRadioButtons();
        setUpTableView();
        loadTbv();
    }

    @FXML
    private void onSelecionarProduto(MouseEvent event) {
        if (tbvProdutos.getSelectionModel().getSelectedItem() != null) {
            PrePreparoController.getInstance().setPrePreparo(tbvProdutos.getItems().get(tbvProdutos.getSelectionModel().getSelectedIndex()));
            
            System.out.println("Aqui---...............>>>>" + PrePreparoController.getInstance().getPrePreparo().toString());
            PrePreparoController.getInstance().getPrePreparo().getListaProdutos().forEach((pp) -> {
                System.out.println("PR:" + pp.getProduto().getDescriao() + "- qtde:" + pp.getQtdeProduto());
            });
            PrePreparoController.getInstance().setListaItens(FXCollections.observableList(PrePreparoController.getInstance().getPrePreparo().getListaProdutos()));
            TabPrePreparoNFXMLController.LDTS();
        }
    }

    @FXML
    private void onPesquisar(ActionEvent event) {
        switch (PrePreparoController.getInstance().getTipoConsulta()) {
            case 1:
                PrePreparoController.getInstance().buscaDesc(txtConsultar.getText());
                loadTbv();
                break;
            case 2:
                PrePreparoController.getInstance().buscaData(LocalDate.now());
                loadTbv();
                break;
            default:
                PrePreparoController.getInstance().buscaTodos();
                loadTbv();
                break;
        }
    }

    private void setUpTableView() {
        tbcDescricao.setCellValueFactory(new PropertyValueFactory<>("produtoPrincipal"));
        tbcData.setCellValueFactory(new PropertyValueFactory<>("dataProducao"));
        tbcCusto.setCellValueFactory(new PropertyValueFactory<>("custoTotal"));
        tbcUnidade.setCellValueFactory(new PropertyValueFactory<>("produtoPrincipal.unidadeMedida"));
        tbcQtde.setCellValueFactory(new PropertyValueFactory<>("produtoPrincipal.qtdeProduto"));
        tbvProdutos.getColumns().setAll(tbcDescricao, tbcData, tbcCusto, tbcUnidade, tbcQtde);
    }
    public static void loadTbvPP() {
        _tbvProdutos.setItems(PrePreparoController.getInstance().getLista());
    }
    private void loadTbv() {
        tbvProdutos.setItems(PrePreparoController.getInstance().getLista());
    }

    private void setUpRadioButtons() {

        rdbDesc.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                rdbData.setSelected(false);
                rdbTodos.setSelected(false);
                PrePreparoController.getInstance().setTipoConsulta(1);//todos
            }
        });
        rdbData.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                rdbDesc.setSelected(false);
                rdbTodos.setSelected(false);
                PrePreparoController.getInstance().setTipoConsulta(2);//todos
            }
        });

        rdbTodos.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                rdbData.setSelected(false);
                rdbDesc.setSelected(false);
                PrePreparoController.getInstance().setTipoConsulta(0);//todos
            }
        });
    }
    public static void refreshList(){
        
        _tbvProdutos.refresh();
    }

    
}
