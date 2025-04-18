package com.fastevent.views.signInUp;

import com.fastevent.common.constants.PathConst;
import com.fastevent.controller.login.RegisterControler;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

public class RegisterIU extends Application {
    private PathConst pathConst = new PathConst();

    @Override
    public void start(Stage registerStage) {
        // Imagen del logo
        Image image = new Image(pathConst.getLogoFastEvent());
        ImageView logo = new ImageView(image);
        logo.setFitWidth(450);
        logo.setFitHeight(450);
        logo.setPreserveRatio(true);

        // Video de fondo
        Media media = new Media(pathConst.getRegisterVideo());
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        MediaView mediaView = new MediaView(mediaPlayer);

        mediaPlayer.setAutoPlay(true);
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);

        mediaView.setPreserveRatio(false);
        mediaView.setFitWidth(1200);
        mediaView.setFitHeight(800);

        // Inputs del formulario
        TextField inputName = new TextField();
        TextField inputLastname = new TextField();
        Spinner<Integer> inputAge = new Spinner<>(18, 100, 18);
        TextField inputEmail = new TextField();
        TextField inputCellPhone = new TextField();
        ChoiceBox<String> gender = new ChoiceBox<>();
        TextField inputUser = new TextField();
        PasswordField inputPassword = new PasswordField();
        PasswordField inputConfirmPassword = new PasswordField();

        Button buttonRegister = new Button("Registrarse!");

        // Placeholder
        inputName.setPromptText("Escribe tu nombre");
        inputLastname.setPromptText("Escribe tus apellidos");
        inputAge.setPromptText("Escribe tu edad");
        inputEmail.setPromptText("Escriba su correo");
        inputCellPhone.setPromptText("Escriba su teléfono");
        gender.getItems().addAll("genero...", "masculino", "femenino");
        gender.setValue("genero...");
        inputUser.setPromptText("Escriba un nombre de usuario");
        inputPassword.setPromptText("Escriba una contraseña");
        inputConfirmPassword.setPromptText("Confirme su contraseña");

        gender.setMinWidth(200);
        inputAge.setMinWidth(200);
        inputAge.setEditable(true);

        // Contenedor Grid
        GridPane inputsContentBox = new GridPane();
        inputsContentBox.add(inputName, 0, 0);
        inputsContentBox.add(inputLastname, 1, 0);
        inputsContentBox.add(inputAge, 2, 0);
        inputsContentBox.add(inputEmail, 0, 1);
        inputsContentBox.add(inputCellPhone, 1, 1);
        inputsContentBox.add(gender, 2, 1);
        inputsContentBox.add(inputUser, 0, 2);
        inputsContentBox.add(inputPassword, 1, 2);
        inputsContentBox.add(inputConfirmPassword, 2, 2);
        inputsContentBox.add(buttonRegister, 1, 3, 3, 1);

        inputsContentBox.setAlignment(Pos.CENTER);
        inputsContentBox.setHgap(50);
        inputsContentBox.setVgap(30);
        GridPane.setMargin(buttonRegister, new Insets(0, 0, 0, 40));
        inputsContentBox.setMaxWidth(700);
        inputsContentBox.setMinHeight(200);

        // VBox del logo
        VBox logoContentBox = new VBox(logo);
        logoContentBox.setAlignment(Pos.TOP_CENTER);

        // VBox principal
        VBox contentBox = new VBox(logoContentBox, inputsContentBox);
        contentBox.setAlignment(Pos.TOP_CENTER);
        VBox.setMargin(inputsContentBox, new Insets(0, 0, 50, 0));
        contentBox.setStyle("-fx-background-color: transparent;");

        // StackPane con video al fondo
        StackPane stackPane = new StackPane(mediaView, contentBox);
        Scene scene = new Scene(stackPane, 1200, 800);

        buttonRegister.getStyleClass().add("button");
        
        for (Control input : new Control[]{
                inputName, inputLastname, inputAge, inputEmail,
                inputCellPhone, gender, inputUser, inputPassword, inputConfirmPassword
        }) {
            input.getStyleClass().add("inputForm");
        }

        contentBox.getStyleClass().add("contentbox");
        inputsContentBox.getStyleClass().add("grid");
        scene.getStylesheets().add(pathConst.getRegisterCss());

        // Evento de registro
        buttonRegister.setOnAction(e -> {
            RegisterControler.setInformationForClassUser(registerStage, inputName, inputLastname, inputAge, inputEmail,
                    inputCellPhone, gender, inputUser, inputPassword, inputConfirmPassword);
        });

        // Configuración del Stage
        registerStage.setTitle("Field - Register");
        registerStage.setWidth(1200);
        registerStage.setHeight(800);
        registerStage.setResizable(false);
        registerStage.setScene(scene);
        registerStage.show();
    }
}
