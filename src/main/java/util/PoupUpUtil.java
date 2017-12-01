/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import com.jfoenix.controls.events.JFXDialogEvent;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.effect.BoxBlur;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;

/**
 *
 * @author joao
 */
public class PoupUpUtil {

    public static void poupUp(String titulo, String texto, String caminhoImagen) {
        caminhoImagen = (caminhoImagen == null || caminhoImagen.equals("")) ? "/Imagens/saveicon.png" : caminhoImagen;
        Image img;
        try {
            img = new Image(caminhoImagen);
            Notifications notificationBulder = Notifications.create().
                    title(titulo).
                    text(texto).
                    hideAfter(Duration.seconds(1)).
                    position(Pos.BOTTOM_RIGHT).
                    graphic(new ImageView(img));
            notificationBulder.show();
        } catch (Exception ex) {
            System.out.println("Erro crinado imagen:" + ex);
        }
    }

    public static void accessDenied(String erros) {
        Image img;
        try {
            img = new Image("Imagens/confirmed_yes_check_ok_accept_positiv_green.png");
            Notifications notificationBuilder = Notifications.create().title("Verifique o Preenchimento ").
                    text(erros).
                    hideAfter(Duration.seconds(4)).
                    position(Pos.TOP_CENTER).
                    darkStyle()
                    .graphic(new ImageView(img));
            notificationBuilder.show();
        } catch (Exception ex) {
            System.out.println("Erro crinado imagen:" + ex);
        }

    }

    public static void errorMessage(Pane rootContainer, StackPane dialogContainer, String erros) {
        BoxBlur blur = new BoxBlur(3, 3, 3);
        JFXDialogLayout dialogLayout = new JFXDialogLayout();
        JFXDialog dialog = new JFXDialog(dialogContainer, dialogLayout, JFXDialog.DialogTransition.TOP);
        JFXButton button = new JFXButton("OK!");
        button.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent eve) -> {
            dialog.close();
        });
        dialogLayout.setBody(new Label(erros));
        dialogLayout.setActions(button);
        dialog.setOnDialogClosed((JFXDialogEvent event1) -> {
            rootContainer.setEffect(null);
        });
        rootContainer.setEffect(blur);
        dialog.show();
    }
}
