package com.fastevent.views.signInUp;

import com.fastevent.common.constants.PathConst;
import com.fastevent.controller.login.RegisterControler;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Control;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class RegisterIU extends Application {
    private PathConst pathConst = new PathConst();

    @Override
    public void start(Stage registerStage) {
        Circle circle = new Circle(100);

        // Imagen del logo
        Image image = new Image(pathConst.getLogoFastEventBlanco());
        ImageView logo = new ImageView(image);
        logo.setFitWidth(300);
        logo.setFitHeight(300);
        logo.setPreserveRatio(true);
        logo.setClip(circle);
        circle.setCenterX(145);
        circle.setCenterY(130);

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
        gender.getItems().addAll( "masculino", "femenino");
        gender.setValue("masculino");
        inputUser.setPromptText("Escriba un nombre de usuario");
        inputPassword.setPromptText("Escriba una contraseña");
        inputConfirmPassword.setPromptText("Confirme su contraseña");
        gender.setMinWidth(250);
        inputAge.setMinWidth(250);
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
        inputsContentBox.setHgap(40);
        inputsContentBox.setVgap(30);
        GridPane.setMargin(inputName, new Insets(0, 0, 0, 30));
        GridPane.setMargin(inputEmail, new Insets(0, 0, 0, 30));
        GridPane.setMargin(inputUser, new Insets(0, 0, 0, 30));
        GridPane.setMargin(buttonRegister, new Insets(0, 0, 0, 40));
        inputsContentBox.setMaxWidth(700);
        inputsContentBox.setMinHeight(200);


        // VBox del logo
        VBox logoContentBox = new VBox(logo);
        logoContentBox.setAlignment(Pos.CENTER);
        VBox.setMargin(logoContentBox, new Insets(50, 0, 100, 0));

        // VBox principal
        VBox contentBox = new VBox(logoContentBox, inputsContentBox);
        contentBox.setAlignment(Pos.TOP_CENTER);
        VBox.setMargin(inputsContentBox, new Insets(0, 0, 50, 0));
        contentBox.setStyle("-fx-background-color: transparent;");

        // StackPane con video al fondo
        StackPane stackPane = new StackPane(mediaView, contentBox);
        Scene scene = new Scene(stackPane, 1200, 800);

        buttonRegister.getStyleClass().add("button");

        for (Control input : new Control[] {
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
