package com.fastevent.views.splashScreen;

import com.fastevent.common.constants.PathConst;
import com.fastevent.components.NextFrame;
import com.fastevent.views.signInUp.LoginIU;

import javafx.animation.FadeTransition;
import javafx.animation.Interpolator;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import javafx.util.Duration;

public class SplashScreen extends Application {
    private final PathConst pathConst = new PathConst();

    @Override
    public void start(Stage SplashScreenStage) {
        // video player media and mediaplayer || image and imageview
        Media video = new Media(pathConst.getVideoSplashScreen());
        MediaPlayer mediaPlayerVideo = new MediaPlayer(video);

        Image image = new Image(pathConst.getLogoFastEvent());
        ImageView imageView = new ImageView(image);

        // nodos
        Label changeLabel = new Label("Cargando...");
        MediaView videoNode = new MediaView(mediaPlayerVideo);

        // contenedores
        StackPane videoStackpane = new StackPane();
        Pane imageFont = new Pane();

        // animaciones
        FadeTransition transitionChangeLabel = new FadeTransition(Duration.seconds(1.0), changeLabel);

        transitionChangeLabel.setFromValue(0.0);
        transitionChangeLabel.setToValue(1.0);
        transitionChangeLabel.setCycleCount(Timeline.INDEFINITE);
        transitionChangeLabel.setAutoReverse(true);
        transitionChangeLabel.setInterpolator(Interpolator.LINEAR);
        transitionChangeLabel.play();

        FadeTransition transitionLogo = new FadeTransition(Duration.seconds(1.5), imageView);

        transitionLogo.setFromValue(0.0);
        transitionLogo.setToValue(1.0);
        transitionLogo.setCycleCount(1);
        transitionLogo.setInterpolator(Interpolator.EASE_IN);
        transitionLogo.play();

        // scenes
        Scene scene = new Scene(videoStackpane);
        scene.getStylesheets().add(pathConst.getSplashScreenCSs());

        // configuracion de nodos y escenas
        mediaPlayerVideo.setOnReady(() -> {
            mediaPlayerVideo.play();
        });
        mediaPlayerVideo.setCycleCount(MediaPlayer.INDEFINITE);
        videoNode.fitWidthProperty().bind(scene.widthProperty());
        videoNode.fitHeightProperty().bind(scene.heightProperty());
        videoNode.setPreserveRatio(false);

        videoStackpane.getChildren().addAll(videoNode, imageFont);
        videoStackpane.setMaxWidth(1200);
        videoStackpane.setMaxHeight(800);

        imageFont.setMaxWidth(1200);
        imageFont.setMaxHeight(800);
        changeLabel.setLayoutX(1070);
        changeLabel.setLayoutY(720);
        imageView.setLayoutX(720);
        imageView.setLayoutY(50);
        imageView.setPreserveRatio(true);
        imageFont.getChildren().addAll(changeLabel, imageView);

        // clases y estilos de css
        imageFont.getStyleClass().add("imageFont");
        changeLabel.getStyleClass().add("charge");

        // stage
        SplashScreenStage.setTitle("FastEvent");
        SplashScreenStage.setWidth(1200);
        SplashScreenStage.setHeight(800);
        SplashScreenStage.setResizable(false);
        SplashScreenStage.setScene(scene);
        SplashScreenStage.show();

        NextFrame.nextFrameDuration(SplashScreenStage, LoginIU.class, 3);
    }
}
