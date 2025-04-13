package com.fastevent.views.signInUp;

import com.fastevent.constants.PathConst;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class LoginIU extends Application {
    private PathConst pathConst = new PathConst();

    @Override
    public void start(Stage LoginStage) {
        // video y contenedor de video
        Media video = new Media(pathConst.getLoginVideo());
        MediaPlayer contentVideo = new MediaPlayer(video);
        MediaView contentMediaView = new MediaView(contentVideo);

        // imagen y contenedor de imagen
        Image image = new Image(pathConst.getLogoFastEvent());
        ImageView contentImage = new ImageView(image);

        // formulario de login
        Label title = new Label("SIGN UP");
        TextField userField = new TextField();
        PasswordField passwordField = new PasswordField();
        Button loginButton = new Button("Iniciar Sesión");

        // redondeo del formulario
        Rectangle clip = new Rectangle(450, 300);
        clip.setArcWidth(30);
        clip.setArcHeight(30);

        // contenedores
        VBox formContent = new VBox(title, userField, passwordField, loginButton);
        Pane content = new Pane(contentImage, formContent);
        StackPane stackPane = new StackPane();
        stackPane.getChildren().addAll(contentMediaView, content);

        // escena
        Scene scene = new Scene(stackPane);

        // configuracion de los nodos
        userField.setMaxSize(250, 40);
        userField.setPromptText("Usuario");
        passwordField.setMaxSize(250, 40);
        passwordField.setPromptText("Contraseña");
        loginButton.setMinWidth(40);

        // configuraciones de los contenedores
        contentImage.setFitWidth(500);
        contentImage.setFitHeight(500);
        contentImage.setPreserveRatio(true);

        contentVideo.setAutoPlay(true);
        contentVideo.setCycleCount(MediaPlayer.INDEFINITE);
        contentMediaView.fitWidthProperty().bind(scene.widthProperty());
        contentMediaView.fitHeightProperty().bind(scene.heightProperty());

        formContent.setLayoutX(40);
        formContent.setLayoutY(350);
        formContent.setMinSize(450, 300);
        formContent.setAlignment(Pos.TOP_CENTER);
        formContent.setClip(clip);
        VBox.setMargin(title, new Insets(20, 0, 20, 0));
        VBox.setMargin(userField, new Insets(0, 0, 20, 0));
        VBox.setMargin(passwordField, new Insets(0, 0, 20, 0));
        VBox.setMargin(loginButton, new Insets(0, 0, 0, 0));

        // estilos de los nodos
        title.getStyleClass().add("title");
        userField.getStyleClass().add("inputForm");
        passwordField.getStyleClass().add("inputForm");
        loginButton.getStyleClass().add("button");

        // estilos de los contenedores
        content.getStyleClass().add("pane");
        formContent.getStyleClass().add("vbox");

        // estilos globales
        scene.getStylesheets().add(pathConst.getLoginCss());

        // configuracion del stage
        LoginStage.setTitle("Login - FatEvent");
        LoginStage.setWidth(1200);
        LoginStage.setHeight(800);
        LoginStage.setResizable(false);
        LoginStage.setScene(scene);
        LoginStage.show();
    }
}
