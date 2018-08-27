/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashf.controller.produto;

import com.cashf.model.produto.Grupo;
import com.cashf.model.produto.Produto;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import java.math.BigDecimal;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author joao
 */
public class TabListaProdutosFXMLController implements Initializable {

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
    private TableColumn<Produto, BigDecimal> tbcCusto;
    @FXML
    private TableColumn<Produto, BigDecimal> tbcVenda;
    @FXML
    private TableColumn<Produto, Integer> tbcQtde;
    @FXML
    private TableColumn<Produto, Grupo> tbcGrupo;
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
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        setUpTableView();
        setUpRadioButtons();
        loadTbv();
    }

    @FXML
    private void onSelecionarProduto(MouseEvent event) {
        if (tbvProdutos.getSelectionModel().getSelectedItem() != null) {
            ProdutoController.getInstance().setProduto(tbvProdutos.getSelectionModel().getSelectedItem());
            TabProdutoFXMLController.ldts();
            TabProdutoFXMLController.setBtnEX(Boolean.FALSE);

        }
    }

    @FXML
    private void onPesquisar(ActionEvent event) {
        switch (ProdutoController.getInstance().getTipoConsulta()) {
            case 1:
                ProdutoController.getInstance().buscaDesc(txtConsultar.getText());
                loadTbv();
                break;
            case 2:
                ProdutoController.getInstance().buscaGrupo(txtConsultar.getText());
                loadTbv();
                break;
            default:
                ProdutoController.getInstance().buscaTodos();
                loadTbv();
                break;
        }

    }

    private void setUpTableView() {
        tbcCod.setCellValueFactory(new PropertyValueFactory<>("idProduto"));
        tbcCodRef.setCellValueFactory(new PropertyValueFactory<>("codigoReferencia"));
        tbcDescricao.setCellValueFactory(new PropertyValueFactory<>("descriao"));
        tbcTipo.setCellValueFactory(new PropertyValueFactory<>("tipo"));
        tbcCusto.setCellValueFactory(new PropertyValueFactory<>("preco_custo"));
        tbcVenda.setCellValueFactory(new PropertyValueFactory<>("preco_venda"));
        tbcQtde.setCellValueFactory(new PropertyValueFactory<>("unidadesEstoque"));
        tbcGrupo.setCellValueFactory(new PropertyValueFactory<>("grupo"));
        tbvProdutos.getColumns().setAll(tbcCod, tbcCodRef, tbcDescricao, tbcTipo, tbcCusto, tbcVenda, tbcQtde,tbcGrupo);
        tbvProdutos.setRowFactory(tv -> {
            TableRow<Produto> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 2 && (!row.isEmpty())) {
                    ProdutoController.getInstance().setProduto(row.getItem());
                    TabProdutoFXMLController.setBtnEX(Boolean.FALSE);
                    FXGerenciarProdutosFXMLController.getTabPane().getSelectionModel().selectFirst();
                }
            });
            return row;
        });         
    }

    private void loadTbv() {
        tbvProdutos.setItems(ProdutoController.getInstance().getLista());
    }

    private void setUpRadioButtons() {

        rdbDesc.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                rdbGrupo.setSelected(false);
                rdbTodos.setSelected(false);
                ProdutoController.getInstance().setTipoConsulta(1);//todos
            }
        });
        rdbGrupo.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                rdbDesc.setSelected(false);
                rdbTodos.setSelected(false);
                ProdutoController.getInstance().setTipoConsulta(2);//todos
            }
        });

        rdbTodos.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                rdbGrupo.setSelected(false);
                rdbDesc.setSelected(false);
                ProdutoController.getInstance().setTipoConsulta(0);//todos
            }
        });
    }
}
