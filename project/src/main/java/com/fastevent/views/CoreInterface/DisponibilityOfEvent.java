package com.fastevent.views.CoreInterface;

import com.fastevent.common.constants.PathConst;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

//esta clase es la section de los eventos disponibles que se estan dando actualmente en la ciudad
public class DisponibilityOfEvent {
    // accedemos a las contantes ya defindas
    private static PathConst pathConst = new PathConst();

    // este metodo retorna un HBox que nos permite ver los eventos disponibles
    public static HBox disponibilityOfHall() {
        // image1 -> es la imagen que yo adjunte para este evento disponible
        Image image1 = new Image(pathConst.getCircoImage());
        // este es el contenedor el cual tendra la imagen
        ImageView imageContent1 = new ImageView(image1);

        // estos son los labels para mostrar la informacion del primer evento disponible
        // actualmente
        Label title1 = new Label("Circo de los hermanos Gasca");
        Label description1 = new Label("Sumergete en otra realidad, vive la emoción en la gran pantalla!");
        Label ubication1 = new Label("El country - Cartagena");
        Label hour1 = new Label("6pm - 11pm");

        // esta es la segunda imagen del evento disponible el cual es HayFestival
        Image image2 = new Image(pathConst.getHayFestivalImage());
        // contenedor para la imagen 2
        ImageView imageContent2 = new ImageView(image2);

        // aca mostramos la informacion del segundo evento disponible
        Label title2 = new Label("Hay festival RCN");
        Label description2 = new Label("Un encuentro de ideas, cultura, y conversaciones!");
        Label ubication2 = new Label("El centro - Cartagena");
        Label hour2 = new Label("9am - 3pm");

        // escalamos el ancho y alto de los contenedores de la imagen además de
        // preservar su radio
        imageContent1.setFitWidth(50);
        imageContent1.setFitHeight(50);
        imageContent1.setPreserveRatio(true);

        imageContent2.setFitWidth(50);
        imageContent2.setFitHeight(50);
        imageContent2.setPreserveRatio(true);

        // los dos distintos contenedores para poner los distintos labels
        VBox hall1 = new VBox();
        hall1.getChildren().addAll(imageContent1, title1, description1, ubication1, hour1);
        VBox hall2 = new VBox();
        hall2.getChildren().addAll(imageContent2, title2, description2, ubication2, hour2);

        // contenedor padre que tendrá a los otros 2 contenedores VBox
        HBox hallContainer = new HBox();
        hallContainer.getChildren().addAll(hall1, hall2);

        return hallContainer; // retornamos el contenedor padre para mostrarlo
    }
}
