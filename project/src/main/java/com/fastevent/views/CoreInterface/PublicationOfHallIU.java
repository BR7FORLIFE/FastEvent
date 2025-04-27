package com.fastevent.views.CoreInterface;

import com.fastevent.common.constants.PathConst;
import com.fastevent.common.constants.StylesConst;
import com.fastevent.controller.core.PublicateHallController;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

//esta es la vista a la hora de subir un salon de eventos
public class PublicationOfHallIU {
        private static PathConst pathConst = new PathConst();

        public static HBox publicateHall() {
                Image image = new Image(pathConst.getPlusImage());
                ImageView imageView = new ImageView(image);

                // labels del layout
                Label nameOfHallLabel = new Label("Nombre del salón: ");
                Label descriptionOfHallLabel = new Label("Descripción del salón: ");
                Label ubicationOfHallLabel = new Label("Ubicación del salón: ");
                Label capacityOfHallLabel = new Label("Aforo del salón: ");
                Label dimensionOfHallLabel = new Label("Dimensiones del salón: ");
                Label cellphoneOfHallLabel = new Label("Telefono: ");
                Label priceOfHallLabel = new Label("Precio del salón: ");

                // estilos de los labels
                for (Label label : new Label[] {
                                nameOfHallLabel, descriptionOfHallLabel, ubicationOfHallLabel, capacityOfHallLabel, dimensionOfHallLabel, cellphoneOfHallLabel, priceOfHallLabel
                }) {
                        label.setStyle(StylesConst.getStyleForLabels());
                }

                // campos de texto para el formulario de añadidura de salones
                TextField nameOfHallField = new TextField();
                TextField descriptionOfHallField = new TextField();
                TextField ubicationOfHallField = new TextField();
                TextField capacityOfHallField = new TextField();
                TextField dimensionOfHallField = new TextField();
                TextField cellphoneOfHallField = new TextField();
                TextField priceOfHallField = new TextField();

                for (TextField textField : new TextField[] {
                                nameOfHallField, descriptionOfHallField, ubicationOfHallField, capacityOfHallField, dimensionOfHallField,cellphoneOfHallField, priceOfHallField
                }) {
                        textField.setStyle(
                                        "-fx-font-size: 13px; -fx-font-weight: 600; -fx-font-family: Cambria; -fx-border-radius: 6px; -fx-border-color:rgb(255, 255, 255); -fx-border-width: 3px; -fx-background-color: white;-fx-text-fill: black");
                }

                // boton para subir el salón
                Button publicateButton = new Button("Publicar Salón");
                publicateButton.setMaxWidth(200);
                publicateButton.setMinHeight(30);
                publicateButton.setStyle(
                                "-fx-background-color: white; -fx-text-fill: black; -fx-font-size: 12px; -fx-font-family: Cambria;");

                // grilla para ordenar los elementos
                GridPane asideIzq = new GridPane();
                asideIzq.add(nameOfHallLabel, 0, 0);
                asideIzq.add(nameOfHallField, 1, 0);
                asideIzq.add(descriptionOfHallLabel, 0, 1);
                asideIzq.add(descriptionOfHallField, 1, 1);
                asideIzq.add(ubicationOfHallLabel, 0, 2);
                asideIzq.add(ubicationOfHallField, 1, 2);
                asideIzq.add(capacityOfHallLabel, 0, 3);
                asideIzq.add(capacityOfHallField, 1, 3);        
                asideIzq.add(dimensionOfHallLabel, 0, 4);
                asideIzq.add(dimensionOfHallField, 1, 4);
                asideIzq.add(cellphoneOfHallLabel, 0, 5);
                asideIzq.add(cellphoneOfHallField, 1, 5);
                asideIzq.add(priceOfHallLabel, 0, 6);
                asideIzq.add(priceOfHallField, 1, 6);
                asideIzq.add(publicateButton, 0, 7);

                // le damos gao y aliniacion alos elementos
                GridPane.setColumnSpan(publicateButton, 2);
                GridPane.setMargin(publicateButton, new Insets(30, 0, 0, 90));
                asideIzq.setHgap(20);
                asideIzq.setVgap(20);
                asideIzq.setAlignment(Pos.CENTER);

                // boton que nos permitira agregar la imagen
                Button selectImage = new Button("", imageView);
                selectImage.setMaxWidth(200);
                selectImage.setMinHeight(200);
                selectImage.setStyle(StylesConst.getStyleSelectHall());
                Label info = new Label("Sube una imagen del salón a publicar");
                info.setStyle("-fx-text-fill: white; -fx-font-size: 14px; -fx-font-family: Cambria; -fx-font-weight: 800;");

                // contenedor para la imagen
                VBox asideDer = new VBox();
                asideDer.getChildren().addAll(selectImage, info);
                asideDer.setAlignment(Pos.TOP_CENTER);

                // margenes
                HBox.setMargin(asideDer, new Insets(0, 0, 0, 50));
                VBox.setMargin(selectImage, new Insets(157, 0, 20, 0));

                // contenedor padre
                HBox fatherContainer = new HBox();
                fatherContainer.getChildren().addAll(asideIzq, asideDer);

                DropShadow dropShadow = new DropShadow();
                dropShadow.setRadius(10);
                dropShadow.setOffsetX(4);
                dropShadow.setOffsetY(7);
                dropShadow.setColor(Color.GRAY);

                // eventos del boton
                publicateButton.setOnAction(e -> {
                        PublicateHallController.comprobateInformation(nameOfHallField,descriptionOfHallField,ubicationOfHallField,capacityOfHallField,dimensionOfHallField,cellphoneOfHallField,priceOfHallField);
                });

                fatherContainer.setMaxWidth(700);
                fatherContainer.setMinHeight(600);
                fatherContainer
                                .setStyle("-fx-background-color: linear-gradient(from 0% 0% to 100% 0%, #00e6f2, #6767eb, #2f00ff)");
                fatherContainer.setEffect(dropShadow);

                return fatherContainer;
        }
}
