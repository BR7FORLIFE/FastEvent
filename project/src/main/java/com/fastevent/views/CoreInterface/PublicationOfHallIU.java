package com.fastevent.views.CoreInterface;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class PublicationOfHallIU {

    public static HBox publicateHall(){
        Label nameOfHallLabel = new Label("Nombre del salón: ");
        Label ubicationOfHallLabel = new Label("Ubicación del salón: ");
        Label priceOfHallLabel = new Label("Precio del salón: ");
        Label capacityOfHallLabel = new Label("Aforo del salón: ");
        Label dimensionOfHallLabel = new Label("Dimensiones del salón: ");
        
        TextField nameOfHallField = new TextField();
        TextField ubicationOfHallField = new TextField();
        TextField priceOfHallField = new TextField();
        TextField capacityOfHallField = new TextField();
        TextField dimensionOfHallField = new TextField();

        Button publicateButton = new Button("Publicar Salón");

        GridPane asideIzq = new GridPane();
        asideIzq.add(nameOfHallLabel, 0, 0);
        asideIzq.add(nameOfHallField, 1, 0);
        asideIzq.add(ubicationOfHallLabel, 0, 1);
        asideIzq.add(ubicationOfHallField, 1, 1);
        asideIzq.add(priceOfHallLabel, 0, 2);
        asideIzq.add(priceOfHallField, 1, 2);
        asideIzq.add(capacityOfHallLabel, 0, 3);
        asideIzq.add(capacityOfHallField, 1, 3);
        asideIzq.add(dimensionOfHallLabel, 0, 4);
        asideIzq.add(dimensionOfHallField, 1, 4);
        asideIzq.add(publicateButton, 0, 5);

        GridPane.setColumnSpan(publicateButton, 2);
        asideIzq.setHgap(20);
        asideIzq.setVgap(20);
        asideIzq.setAlignment(Pos.CENTER);


        Button selectImage = new Button();
        Label info = new Label("Sube una imagen del salón a publicar");
        
        VBox asideDer = new VBox();
        asideDer.getChildren().addAll(selectImage, info);


        HBox fatherContainer = new HBox();
        fatherContainer.getChildren().addAll(asideIzq,asideDer);

        
        return fatherContainer;
    }
}
