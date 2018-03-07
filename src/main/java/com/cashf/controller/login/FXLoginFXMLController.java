/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashf.controller.login;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Circle;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author joao
 */
public class FXLoginFXMLController implements Initializable {

    @FXML
    private StackPane rootStackPane;
    @FXML
    private Pane rootPane;
    @FXML
    private Pane paneLogin;
    @FXML
    private JFXTextField txtLogin;
    @FXML
    private JFXPasswordField txtSenha;
    @FXML
    private Circle circle;
    @FXML
    private JFXButton btnLogin;
    //-------------------------
    Image img = new Image("/Imagens/access_denied_128.png");
    Image imgOne = new Image("/Imagens/check-user.png");
    Notifications notificationBuilder;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void btnLogin(ActionEvent event) {
        LoginController.getInstance().setLogin(txtLogin.getText().trim());
        LoginController.getInstance().setSenha(txtSenha.getText().trim());

        if (LoginController.getInstance().validateUser()) {//Validando Usuario
            if (LoginController.getInstance().validatePassword()) {//Validando Senha
                StackPane menuPrincipal;
                try {//Carregando Menu Principal
                    notificationBuilder = Notifications.create().title("Login efetuado.").
                            text("Usuário:" + LoginController.getInstance().getUsuario().getLogin() + "").
                            hideAfter(Duration.seconds(5)).
                            position(Pos.BOTTOM_RIGHT).
                            darkStyle().graphic(new ImageView(imgOne));
                    LoginController.getInstance().setLoginStatus();
                    menuPrincipal = FXMLLoader.load(getClass().getResource("/fxml/FXMenuFXML.fxml"));
                    rootStackPane.getChildren().setAll(menuPrincipal);

                } catch (IOException ex) {
                    System.out.println("Erro--->>>" + ex);
                }

            } else {
                notificationBuilder = Notifications.create().title("Acesso negado - senha inválida.").
                        text("A Senha informada não está correta.").
                        hideAfter(Duration.seconds(5)).
                        position(Pos.BOTTOM_RIGHT).
                        darkStyle().graphic(new ImageView(img));
            }
        } else {
            notificationBuilder = Notifications.create().title("Acesso Negado - login inválido.").
                    text("O login informado não foi localizado.").
                    hideAfter(Duration.seconds(5)).
                    position(Pos.BOTTOM_RIGHT).
                    darkStyle().graphic(new ImageView(img));
        }
        notificationBuilder.show();
    }

}
