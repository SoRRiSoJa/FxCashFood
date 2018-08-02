package com.cashf.cashfood;

import com.cashf.controller.parametrizacao.ParametrosController;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import util.BDInsert;

public class MainApp extends Application {

    public static Stage janelaAberta, janelaAnterior;
    public static StackPane paneRoot;

    @Override
    public void start(Stage stage) throws Exception {
        Parent root;
        if (!ParametrosController.getInstance().getLista().isEmpty()) {
            //BDInsert bdInsert = new BDInsert();
            //bdInsert.insertData();
            root = FXMLLoader.load(getClass().getResource("/fxml/parametrizacao/GerenciarParametrizacaoFXML.fxml"));
        } else {
            root = FXMLLoader.load(getClass().getResource("/fxml/login/FXLoginFXML.fxml"));
        }
        Scene scene = new Scene(root);
        stage.setTitle("ERP - Cash Food v.1.0 Copyright (c) 2017 By João André Martins Dias e Silva");
        stage.setScene(scene);
        janelaAnterior = janelaAberta;
        janelaAberta = stage;
        stage.show();
    }

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
