/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashf.controller.produto;

import com.cashf.model.produto.Categoria;
import com.cashf.model.produto.Grupo;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import com.sun.prism.impl.Disposer;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
import javafx.scene.input.MouseEvent;
import javafx.util.Callback;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;
import util.PoupUpUtil;

/**
 * FXML Controller class
 *
 * @author joao
 */
public class GerenciarGruposFXMLController implements Initializable {

    //----------------------------------------------
    private GrupoController controller = new GrupoController();
    private String erros;
    private boolean flagButtons;
    private String descricao;
    private String descricaoCategoria;
    private long idGrupo = 0;
    private long idCat = 0;
    @FXML
    private TableColumn<Categoria, String> tbcDescricaoCat;
    @FXML
    private JFXButton btnSalvar;
    @FXML
    private JFXButton btnNovo;
    @FXML
    private JFXButton btnExcluir;
    @FXML
    private JFXButton btnLimpar;
    @FXML
    private JFXTextField txtDescricao;
    @FXML
    private JFXComboBox<Categoria> cbbCategoria;
    @FXML
    private JFXTextField txtDescCat;
    @FXML
    private JFXButton btnAdicionar;
    @FXML
    private TableView<Categoria> tbvCategoria;
    @FXML
    private TableColumn<Categoria, Integer> tbcCodCat;
    @FXML
    private TableColumn btnDeletar;
    @FXML
    private TableView<Grupo> tbvGrupos;
    @FXML
    private TableColumn<Grupo, String> tbcDescricaoGrupo;
    @FXML
    private TableColumn<Grupo, String> tbcCategoriaGrupo;
    @FXML
    private TableColumn<?, ?> tbcDescricao1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        loadCbbCategoria();
        setUptableView();
        setUptableViewCategoria();
        loadtbv();
        setInputOff();
    }

    @FXML
    private void onSalvar(ActionEvent event) {
        getData();
        if (validateFields()) {
            controller.setGrupo(idGrupo, descricao);
            if (controller.getGrupo().getIdGrupo() == 0) {
                controller.insert();
                clearFields();
                PoupUpUtil.poupUp("Grupo Cadastrado", "O Grupo foi cadastrado com sucesso.", "");
                loadCbbCategoria();
            } else {
                controller.update();
                PoupUpUtil.poupUp("Grupo Alterado", "O Grupo foi alterado com sucesso.", "");
            }
            btnAdicionar.setDisable(false);
        } else {
            PoupUpUtil.accessDenied(erros);
            erros = "";
        }
    }

    @FXML
    private void onNovo(ActionEvent event) {
        setInputON();
        clearFields();
        btnNovo.setDisable(true);
        btnExcluir.setDisable(true);
    }

    @FXML
    private void onExcluir(ActionEvent event) {
        if (controller.getGrupo() != null) {
            controller.delete();
            PoupUpUtil.poupUp("Grupo Excluído", "O Grupo foi excluído com sucesso.", "");
        }
        btnExcluir.setDisable(true);
        clearFields();
    }

    @FXML
    private void onLimpar(ActionEvent event) {
        clearFields();
    }

    @FXML
    private void onAdicionar(ActionEvent event) {
        getDataCategoria();
        if (validateFieldsCategoria()) {
            controller.setCategoria(idCat, descricaoCategoria);
            controller.inssertCategoria();
            loadCbbCategoria();
            loadTbvCategoria();
            btnAdicionar.setDisable(true);
        } else {
            PoupUpUtil.accessDenied(erros);
            erros = "";
        }
    }

    @FXML
    private void onMouseClicked(MouseEvent event) {
        if (tbvGrupos.getSelectionModel().getSelectedItem() != null) {
            controller.setGrupo(tbvGrupos.getSelectionModel().getSelectedItem());
            controller.setCategoria(controller.getGrupo().getCategoria());
            controller.flushListaCategoria();
            controller.setItemListaCategria(controller.getCategoria());
            txtDescricao.setText(controller.getGrupo().getDescricao());
            txtDescCat.setText(controller.getGrupo().getCategoria().getDescricao());
            loadTbvCategoria();
            getData();
            getDataCategoria();
            btnExcluir.setDisable(false);

        }
    }

    private void clearFields() {
        txtDescricao.clear();
        txtDescCat.clear();
        cbbCategoria.setValue(null);
    }

    private void setInputON() {
        btnExcluir.setDisable(false);
        btnLimpar.setDisable(false);
        btnSalvar.setDisable(false);
        btnAdicionar.setDisable(false);
        txtDescricao.setDisable(false);
        txtDescCat.setDisable(false);
        cbbCategoria.setDisable(false);
        flagButtons = true;
    }

    private void setInputOff() {
        btnExcluir.setDisable(true);
        btnLimpar.setDisable(true);
        btnSalvar.setDisable(true);
        btnAdicionar.setDisable(true);
        txtDescCat.setDisable(true);
        txtDescricao.setDisable(true);
        cbbCategoria.setDisable(true);
        flagButtons = false;
    }

    public void loadDataToScreen() {
        txtDescricao.setText(controller.getGrupo().getDescricao());
        loadTbvCategoria();
    }

    private void getData() {
        idGrupo = (controller.getGrupo().getIdGrupo() != 0) ? idGrupo = controller.getGrupo().getIdGrupo() : 0l;
        descricao = txtDescricao.getText();
        controller.setCategoria(cbbCategoria.getSelectionModel().getSelectedItem());
    }

    private void getDataCategoria() {
        idCat = (controller.getCategoria() != null && controller.getCategoria().getIdCategoria() != 0) ? idCat = controller.getCategoria().getIdCategoria() : 0l;
        descricaoCategoria = txtDescCat.getText();
    }

    private boolean validateFields() {
        boolean flag = true;
        if (descricao == null || descricao.equals("") || descricao.length() < 3) {
            erros += "A Descrição do grupo de produtos deve conter um conteúdo válido! \n";
            flag = false;
        }
        return flag;
    }

    private boolean validateFieldsCategoria() {
        boolean flag = true;
        if (descricaoCategoria == null || descricaoCategoria.equals("") || descricaoCategoria.length() < 3) {
            erros += "A Descrição da categoria do grupo de produtos deve conter um conteúdo válido! \n";
            flag = false;
        }
        return flag;
    }

    private void setUptableView() {
        tbcDescricaoGrupo.setCellValueFactory(new PropertyValueFactory<>("descricao"));
        tbcCategoriaGrupo.setCellValueFactory(new PropertyValueFactory<>("categoria"));
        tbvGrupos.getColumns().setAll(tbcDescricaoGrupo, tbcCategoriaGrupo);
    }

    private void setUptableViewCategoria() {
        tbcCodCat.setCellValueFactory(new PropertyValueFactory<>("idCategoria"));
        tbcDescricaoCat.setCellValueFactory(new PropertyValueFactory<>("descricao"));
        btnDeletar.setCellFactory(new Callback<TableColumn<Disposer.Record, Boolean>, TableCell<Disposer.Record, Boolean>>() {
            @Override
            public TableCell<Disposer.Record, Boolean> call(TableColumn<Disposer.Record, Boolean> p) {
                return new ButtonCellDelete();
            }
        });
        tbvCategoria.getColumns().setAll(tbcCodCat, tbcDescricaoCat, btnDeletar);
    }

    private void loadtbv() {
        tbvGrupos.setItems(controller.getLista());
    }

    private void loadTbvCategoria() {
        tbvCategoria.setItems(controller.getListaCategria());
    }

    private void loadCbbCategoria() {
        cbbCategoria.setItems(controller.getListaCategria());
    }

    @FXML
    private void onCbbCategoria(ActionEvent event) {
        if (cbbCategoria.getSelectionModel().getSelectedItem() != null) {
            controller.setCategoria(cbbCategoria.getSelectionModel().getSelectedItem());
            controller.getGrupo().setCategoria(controller.getCategoria());
        }
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
            cellButton.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent t) {
                    // get Selected Item
                    Categoria currentPerson = (Categoria) ButtonCellDelete.this.getTableView().getItems().get(ButtonCellDelete.this.getIndex());
                    //remove selected item from the table list
                    if (currentPerson != null) {
                        controller.setCategoria(currentPerson);
                        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                        alert.setTitle("Cofirmar Excluir Categoria!");
                        alert.setHeaderText("Deseja realmente Excluir?");
                        alert.setContentText("Codigo:(" + currentPerson.getIdCategoria() + ") - " + currentPerson.getDescricao() + "");
                        Optional<ButtonType> result = alert.showAndWait();
                        if (result.get() == ButtonType.OK) {
                            // ... user chose OK
                            controller.deleteCategoria();
                            notificationBuilder = Notifications.create().title("Categoria excluída!").
                                    text("Categoria Excluida com sucesso.").
                                    hideAfter(Duration.seconds(2)).
                                    position(Pos.TOP_RIGHT).
                                    darkStyle();
                            notificationBuilder.showInformation();
                        } else {
                            alert.close();
                        }
                    } else {
                        notificationBuilder = Notifications.create().title("Nenhum item selecionado!").
                                text("Você deve selecionar Uma conta para Cancelar.").
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
