package com.fastevent.views.CoreInterface;

import java.util.ArrayList;

import com.fastevent.common.constants.PathConst;
import com.fastevent.common.constants.StylesConst;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class UpcomingEventIU {
    private static final PathConst pathConst = new PathConst();
    private static final ArrayList<HBox> containers = new ArrayList<>();

    public static ArrayList<HBox> upcomingEvent() {
        containers.clear(); //limpiamos el arrayList cada vez que llamamos al metodo

        //clip 
        Rectangle rectangle1 = new Rectangle();
        rectangle1.setArcHeight(12);
        rectangle1.setArcWidth(12);
        rectangle1.setWidth(750);
        rectangle1.setHeight(250);

        //clips
        Rectangle rectangle2 = new Rectangle();
        rectangle2.setArcHeight(12);
        rectangle2.setArcWidth(12);
        rectangle2.setWidth(750);
        rectangle2.setHeight(250);

        Rectangle rectangle3 = new Rectangle();
        rectangle3.setArcHeight(12);
        rectangle3.setArcWidth(12);
        rectangle3.setWidth(750);
        rectangle3.setHeight(250);

        //DropShadow
        DropShadow dropShadow = new DropShadow();
        dropShadow.setColor(Color.GRAY);
        dropShadow.setOffsetX(10);
        dropShadow.setOffsetY(10);
        dropShadow.setRadius(10);

        Label upcoming = new Label("upcoming");

        //contenedores y imagenes 
        Image image1 = new Image(pathConst.getFestivalCaribeImage());
        ImageView imageView1 = new ImageView(image1);
        Label title1 = new Label("Festival de musica del caribe");
        Label description1 = new Label("Siente la musica, vibra con el ritmo!");
        VBox info1 = new VBox(title1, description1, upcoming);
        VBox imageContainer1 = new VBox(imageView1);

        Image image2 = new Image(pathConst.getFestivalDulceImage());
        ImageView imageView2 = new ImageView(image2);
        Label title2 = new Label("Festival del dulce");
        Label description2 = new Label("Endulzate la vida y disfruta cada bocado!");
        VBox info2 = new VBox(title2, description2, upcoming);
        VBox imageContainer2 = new VBox(imageView2);

        Image image3 = new Image(pathConst.getFestivalVeranoImage());
        ImageView imageView3 = new ImageView(image3);
        Label title3 = new Label("Festival de Verano");
        Label description3 = new Label("sol, diversion y aventura te esperan en el festival!");
        VBox info3 = new VBox(title3, description3, upcoming);
        VBox imageContainer3 = new VBox(imageView3);

        //ancho , alto y aspect ratio
        imageView1.setFitWidth(150);
        imageView1.setFitHeight(150);
        imageView1.setPreserveRatio(true);

        imageView2.setFitWidth(250);
        imageView2.setFitHeight(250);
        imageView2.setPreserveRatio(true);

        imageView3.setFitWidth(250);
        imageView3.setFitHeight(250);
        imageView3.setPreserveRatio(true);

        //for -each que aplica estilos para los labels
        for (Label label : new Label[] {
                upcoming, title1, title2, title3, description1, description2, description3
        }) {
            label.setStyle(StylesConst.getStyleForLabels());
        }
        //los 3 contenedores para las distintas cards
        HBox container1 = new HBox(info1, imageContainer1);
        HBox container2 = new HBox(info2, imageContainer2);
        HBox container3 = new HBox(info3, imageContainer3);

        // estilo general de los contenedores padres
        container1.setMaxWidth(700);
        container1.setMinHeight(200);
        container1.setStyle("-fx-background-color: #d3a2ff");
        container1.setAlignment(Pos.CENTER);
        container1.setClip(rectangle1);
        container1.setEffect(dropShadow);

        container2.setMaxWidth(700);
        container2.setMinHeight(200);
        container2.setStyle("-fx-background-color:rgb(141, 124, 241)");
        container2.setAlignment(Pos.CENTER);
        container2.setClip(rectangle2);
        container2.setEffect(dropShadow);

        container3.setMaxWidth(700);
        container3.setMinHeight(200);
        container3.setStyle("-fx-background-color:rgb(162, 202, 255)");
        container3.setAlignment(Pos.CENTER);
        container3.setClip(rectangle3);
        container3.setEffect(dropShadow);

        // estilos de los contenedores hijos
        info1.setMaxWidth(500);
        info1.setMinHeight(200);
        info1.setAlignment(Pos.CENTER);
        imageContainer1.setMaxWidth(200);
        imageContainer1.setMinHeight(200);
        imageContainer1.setAlignment(Pos.CENTER);
        HBox.setMargin(info1, new Insets(0, 50, 0, 0));

        info2.setMaxWidth(500);
        info2.setMinHeight(200);
        info2.setAlignment(Pos.CENTER);
        imageContainer2.setMaxWidth(200);
        imageContainer2.setMinHeight(200);
        imageContainer2.setAlignment(Pos.CENTER);
        HBox.setMargin(info2, new Insets(0, 50, 0, 0));

        info3.setMaxWidth(500);
        info3.setMinHeight(200);
        info3.setAlignment(Pos.CENTER);
        imageContainer3.setMaxWidth(200);
        imageContainer3.setMinHeight(200);
        imageContainer3.setAlignment(Pos.CENTER);
        HBox.setMargin(info3, new Insets(0, 50, 0, 0));

        containers.add(container1);
        containers.add(container2);
        containers.add(container3);

        return containers; //retornamos las 3 cards!
    }
}
