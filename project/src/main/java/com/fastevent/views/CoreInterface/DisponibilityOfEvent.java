package com.fastevent.views.CoreInterface;

import com.fastevent.common.constants.PathConst;
import com.fastevent.common.constants.StylesConst;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

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
        Label description1 = new Label("Sumergete en otra realidad");
        Label ubication1 = new Label("El country - Cartagena");
        Label hour1 = new Label("HOY!! 6pm - 11pm");

        // esta es la segunda imagen del evento disponible el cual es HayFestival
        Image image2 = new Image(pathConst.getHayFestivalImage());
        // contenedor para la imagen 2
        ImageView imageContent2 = new ImageView(image2);

        // aca mostramos la informacion del segundo evento disponible
        Label title2 = new Label("Hay festival RCN");
        Label description2 = new Label("Un encuentro de ideas y cultura");
        Label ubication2 = new Label("El centro - Cartagena");
        Label hour2 = new Label("HOY!!! 9am - 3pm");

        // estilos de los labels 
        for(Label label : new Label[]{
            title1,title2,description1,description2,ubication1,ubication2,hour1,hour2
        }){
            label.setStyle(StylesConst.getStyleForLabels());
            label.setWrapText(true);
            VBox.setMargin(label, new Insets(0, 0, 20, 0));
        }

        // escalamos el ancho y alto de los contenedores de la imagen además de
        // preservar su radio
        imageContent1.setFitWidth(200);
        imageContent1.setFitHeight(200);
        imageContent1.setPreserveRatio(true);
    
        imageContent2.setFitWidth(250);
        imageContent2.setFitHeight(250);
        imageContent2.setPreserveRatio(true);

        // los dos distintos contenedores para poner los distintos labels y un clip
        Rectangle rectangle1 = new Rectangle();
        rectangle1.setWidth(300);
        rectangle1.setHeight(500);
        rectangle1.setArcWidth(12);
        rectangle1.setArcHeight(12);

        Rectangle rectangle2 = new Rectangle();
        rectangle2.setWidth(300);
        rectangle2.setHeight(500);
        rectangle2.setArcWidth(12);
        rectangle2.setArcHeight(12);

        VBox hall1 = new VBox();
        hall1.getChildren().addAll(imageContent1, title1, description1, ubication1, hour1);
        VBox hall2 = new VBox();
        hall2.getChildren().addAll(imageContent2, title2, description2, ubication2, hour2);

        // estilos de los contenedores hijos        
        hall1.setMinWidth(300);
        hall1.setMaxHeight(500);
        hall1.setAlignment(Pos.TOP_CENTER);
        hall1.setStyle("-fx-background-color: #1077eb");
        hall1.setClip(rectangle1);
        VBox.setMargin(imageContent1, new Insets(30, 0, 10, 0));

        hall2.setMinWidth(300);
        hall2.setMaxHeight(500);
        hall2.setAlignment(Pos.TOP_CENTER);
        hall2.setStyle("-fx-background-color: #8410eb");
        hall2.setClip(rectangle2);
        VBox.setMargin(imageContent2, new Insets(30, 0, 10, 0));

        HBox.setMargin(hall2, new Insets(0, 40, 0, 20));

        // contenedor padre que tendrá a los otros 2 contenedores VBox
        DropShadow dropShadow = new DropShadow();
        dropShadow.setRadius(10);
        dropShadow.setOffsetX(10);
        dropShadow.setOffsetY(8);
        dropShadow.setBlurType(BlurType.THREE_PASS_BOX);
        dropShadow.setColor(Color.GRAY);

        HBox hallContainer = new HBox();
        hallContainer.setMaxWidth(700);
        hallContainer.setMinHeight(600);
        hallContainer.getChildren().addAll(hall1, hall2);
        hallContainer.setStyle("-fx-background-color:rgb(243, 243, 243);");
        hallContainer.setEffect(dropShadow);
        hallContainer.setAlignment(Pos.CENTER);

        HBox.setMargin(hall1, new Insets(0, 0, 0, 20));

        return hallContainer; // retornamos el contenedor padre para mostrarlo
    }
}
