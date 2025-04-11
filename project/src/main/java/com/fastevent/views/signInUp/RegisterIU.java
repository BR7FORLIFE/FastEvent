package com.fastevent.views.signInUp;

import com.fastevent.constants.PathConst;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class RegisterIU extends Application {
    // constantes
    PathConst pathConst = new PathConst();

    @Override
    public void start(Stage registerStage) {
        // contenedor y imagen (logo)
        Image image = new Image(pathConst.getPathToLogo());
        ImageView logo = new ImageView(image);
        logo.setFitWidth(450);//ajustar el ancho de la imagen 
        logo.setFitHeight(450);//ajustar el alto de la imagen
        logo.setPreserveRatio(true); //mantener la razon o proporcion de la imagen 

        // inputs del formulario
        TextField inputName = new TextField();
        TextField inputLastname = new TextField();
        TextField inputAge = new TextField();
        TextField inputEmail = new TextField();
        TextField inputCellPhone = new TextField();
        ChoiceBox<String> gender = new ChoiceBox<>();//para los generos masculino y femenino
        TextField inputUser = new TextField();
        PasswordField inputPassword = new PasswordField();
        PasswordField inputConfirmPassword = new PasswordField();

        // botón para registrarse
        Button buttonRegister = new Button("Registrarse!");

        // configuración de los inputs
        inputName.setPromptText("Escribe tu nombre");
        inputLastname.setPromptText("Escribe tus apellidos");
        inputAge.setPromptText("Escribe tu edad");
        inputEmail.setPromptText("Escriba su correo");
        inputCellPhone.setPromptText("Escriba su teléfono");
        gender.getItems().addAll("masculino", "femenino");
        inputUser.setPromptText("Escriba un nombre de usuario");
        inputPassword.setPromptText("Escriba una contraseña");
        inputConfirmPassword.setPromptText("Confirme su contraseña");

        // contenedores
        GridPane inputsContentBox = new GridPane();
        VBox logoContentBox = new VBox(logo);
        VBox contentBox = new VBox(logoContentBox,inputsContentBox);
        Scene scene = new Scene(contentBox, 1200, 800);

        // configuración del grid con nodos
        inputsContentBox.add(inputName, 0, 0);
        inputsContentBox.add(inputLastname, 1, 0);
        inputsContentBox.add(inputAge, 2, 0);
        inputsContentBox.add(inputEmail, 0, 1);
        inputsContentBox.add(inputCellPhone, 1, 1);
        inputsContentBox.add(gender, 2, 1);
        inputsContentBox.add(inputUser, 0, 2);
        inputsContentBox.add(inputPassword, 1, 2);
        inputsContentBox.add(inputConfirmPassword, 2, 2);
        inputsContentBox.add(buttonRegister, 0, 3, 3, 1); 

        //ancho y alto del grid
        inputsContentBox.setMaxWidth(1000);
        inputsContentBox.setMinHeight(300);

        //alineaciones
        logoContentBox.setAlignment(Pos.TOP_CENTER);
        contentBox.setAlignment(Pos.TOP_CENTER);
        VBox.setMargin(inputsContentBox, new Insets(0, 0, 50, 0));

        //clases css para los contenedores y la escena
        contentBox.getStyleClass().add("contentbox");
        inputsContentBox.getStyleClass().add("grid");
        scene.getStylesheets().add(pathConst.getPathToRegisterIU());

        // configuración del stage
        registerStage.setTitle("Field - Register");
        registerStage.setWidth(1200);
        registerStage.setHeight(800);
        registerStage.setResizable(false);
        registerStage.setScene(scene);
        registerStage.show();
    }
}
