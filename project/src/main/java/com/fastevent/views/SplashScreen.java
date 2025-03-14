package com.fastevent.views;

import javafx.animation.FadeTransition;
import javafx.animation.Interpolator;
import javafx.animation.PauseTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class SplashScreen extends Application { 
    @Override  
    public void start(Stage primaryStage) {
        //creamos un stage para el registro de usuarios y instanciamos la clase RegisterIU
        Stage registerStage = new Stage();
        RegisterIU registerIU = new RegisterIU();

        //accedemos al css correspondiente a la pantalla de carga
        String cssPath = getClass().getResource("/css/SplashSreen.css").toExternalForm();
        
        //creamos un label para simular la carga
        Label cargando = new Label("Cargando...");

        //ajustamos posiciones y le aplicamos los estilos de la clase cargando
        cargando.setLayoutX(650);
        cargando.setLayoutY(520);
        cargando.getStyleClass().add("cargando");

        //aplicamos una transicion de desvanecimiento y aparicion al label 
        FadeTransition transition = new FadeTransition(Duration.seconds(1.5), cargando);
        transition.setFromValue(1.0);
        transition.setToValue(0);
        transition.setInterpolator(Interpolator.LINEAR);
        transition.setCycleCount(Timeline.INDEFINITE);
        transition.setAutoReverse(true);
        transition.play();

        /**
         * Pane nos ayuda a ubicar los elementos donde queramos gracias a las coordenadas cartesianas
         */
        Pane pane = new Pane(cargando);

        //aplicamos la clase contentPane de la hoja de estilos
        pane.getStyleClass().add("Contentpane");

        //añadimos el css a toda la scena en general
        Scene scene = new Scene(pane, 800, 600);
        scene.getStylesheets().add(cssPath);

        //mostramos y lanzamos la aplicacion
        primaryStage.setScene(scene);
        primaryStage.setTitle("FastEvent");
        primaryStage.setResizable(false);
        primaryStage.show();

        //esperara 3 segundos y finalizara el proceso del splash y empezara el de register
        PauseTransition delayToNextFrame = new PauseTransition(Duration.seconds(3));
        delayToNextFrame.setOnFinished(event ->{
            primaryStage.close();
            registerIU.start(registerStage);
        });

        delayToNextFrame.play();
    }
}
