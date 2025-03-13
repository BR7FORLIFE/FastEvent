package com.fastevent.views;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class RegisterIU extends Application{
    public void start(Stage primaryStage){
        //obtenemos la hoja de estilos
        String cssPath = getClass().getResource("/css/Register.css").toExternalForm();

        //campos para el formulario
        Label title = new Label("Registrarse");
        TextField username = new TextField();
        PasswordField password = new PasswordField();

        //placeholders 
        username.setPromptText("Username ej: Bryan");
        password.setPromptText("password");

        //nodos para diseñar el layout del register
        VBox vBoxNodes = new VBox(title,username, password);
        VBox vBoxImage = new VBox();
        
        //establecemos ancho y alto de cada contenedor
        vBoxNodes.setMinWidth(400);
        vBoxNodes.setMinHeight(600);
        vBoxImage.setMinWidth(600);
        vBoxImage.setMinHeight(600);

        //disposicion y espaciado de los nodos y contenedores
        vBoxNodes.setAlignment(Pos.CENTER); 
        username.setMaxWidth(350);
        password.setMaxWidth(350);
        VBox.setMargin(username, new Insets(25,0,25,0));

        //estilos a los nodos
        title.getStyleClass().add("titleRegister");
        username.getStyleClass().add("fields");
        password.getStyleClass().add("fields");

        //estilos de los contenedores
        vBoxNodes.getStyleClass().add("rightAside");
        vBoxImage.getStyleClass().add("leftAside");
        
        //usamos un grid para organizar el contenido en 2 sections
        GridPane gridPane = new GridPane();
        gridPane.add(vBoxImage, 0, 0);
        gridPane.add(vBoxNodes, 1, 0);

        //creamos la escena
        Scene scene = new Scene(gridPane);
        scene.getStylesheets().add(cssPath);

        //establecemos la escena y mostramos en la ventana
        primaryStage.setScene(scene);
        primaryStage.setTitle("FastEvent - Register");
        primaryStage.setResizable(false);
        primaryStage.show();
    }
}
