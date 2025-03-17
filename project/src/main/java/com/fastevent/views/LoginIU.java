package com.fastevent.views;

import java.io.FileWriter;

import com.fastevent.controller.UserRegister.Login;
import com.fastevent.controller.UserRegister.Register;
import com.fastevent.views.components.CssRoutes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class LoginIU extends Application{
    public void start(Stage primaryStage){
        //obtenemos la hoja de estilos para RegisterIU
        CssRoutes cssRoute = new CssRoutes();
        
        //campos para el formulario
        Label title = new Label("Iniciar Sesion");
        TextField username = new TextField();
        PasswordField password = new PasswordField();
        Button submitButton = new Button("Iniciar Sesion!");

        //placeholders 
        username.setPromptText("Username");
        password.setPromptText("password");

        //nodos para diseñar el layout del register
        VBox vBoxNodes = new VBox(title,username, password,submitButton);
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
        VBox.setMargin(submitButton, new Insets(30,0,0,0));

        //estilos a los nodos
        title.getStyleClass().add("titleRegister");
        username.getStyleClass().add("fields");
        password.getStyleClass().add("fields");
        submitButton.getStyleClass().add("button");

        //estilos de los contenedores
        vBoxNodes.getStyleClass().add("rightAside");
        vBoxImage.getStyleClass().add("leftAside");
        
        //eventos para el boton de submit
        submitButton.setOnAction(event->{
            String usernameUser = username.getText();
            String passwordUser = password.getText();
            username.setDisable(true);
            password.setDisable(true);
            Login.userField(usernameUser, passwordUser);
        });

        //usamos un grid para organizar el contenido en 2 sections
        GridPane gridPane = new GridPane();
        gridPane.add(vBoxImage, 0, 0);
        gridPane.add(vBoxNodes, 1, 0);

        //creamos la escena
        Scene scene = new Scene(gridPane);
        scene.getStylesheets().add(cssRoute.register_loginCss);

        //establecemos la escena y mostramos en la ventana
        primaryStage.setScene(scene);
        primaryStage.setTitle("FastEvent - Iniciar Sesion");
        primaryStage.setResizable(false);
        primaryStage.show();

        //hacer un reset en el modelo de users
        primaryStage.setOnCloseRequest(event -> {
            JsonObject emptyJson = new JsonObject();
            try (FileWriter fileWriter = new FileWriter(Register.pathToJson)) {
                Gson gson = new GsonBuilder().setPrettyPrinting().create();
                gson.toJson(emptyJson, fileWriter);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
