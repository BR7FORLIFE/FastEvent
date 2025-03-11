package com.fastevent.views;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class LoginIU extends Application {
    public void start(Stage primaryStage){
        TextField username = new TextField();
        PasswordField password = new PasswordField();

        VBox vBox = new VBox(username,password);
    
        //escena de la apicacion para dibujar los diferentes nodos
        Scene scene = new Scene(vBox,1000,500);
        scene.getStylesheets().add(getClass().getResource("./css/login.css").toExternalForm());
        //mostramos el frame y establecemos la escena
        primaryStage.setScene(scene);
        primaryStage.setTitle("FastEvent");
        primaryStage.show();
    }
}
