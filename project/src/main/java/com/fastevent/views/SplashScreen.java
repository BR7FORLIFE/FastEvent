package com.fastevent.views;

import javafx.animation.FadeTransition;
import javafx.animation.Interpolator;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class SplashScreen extends Application {
    public void start(Stage primaryStage) {
        String cssPath = getClass().getResource("/css/SplashSreen.css").toExternalForm();
        Label cargando = new Label("Cargando...");

        cargando.setLayoutX(650);
        cargando.setLayoutY(520);
        cargando.getStyleClass().add("cargando");

        FadeTransition transition = new FadeTransition(Duration.seconds(1.5), cargando);
        transition.setFromValue(1.0);
        transition.setToValue(0);
        transition.setInterpolator(Interpolator.LINEAR);
        transition.setCycleCount(Timeline.INDEFINITE);
        transition.setAutoReverse(true);
        transition.play();

        Pane vbox = new Pane(cargando);

        vbox.getStyleClass().add("Contentpane");

        Scene scene = new Scene(vbox, 800, 600);
        scene.getStylesheets().add(cssPath);

        primaryStage.setScene(scene);
        primaryStage.setTitle("FastEvent");
        primaryStage.setResizable(false);
        primaryStage.show();
    }
}
