package com.fastevent.views.CoreInterface;

import java.util.ArrayList;
import java.util.List;

import com.fastevent.common.constants.PathConst;
import com.fastevent.common.constants.StylesConst;
import com.fastevent.common.simpleClasses.Hall;
import com.fastevent.controller.core.PrincipalController;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class ReserveHallIU {
    private static PathConst pathConst = new PathConst();
    private static ArrayList<HBox> hboxHallsList = new ArrayList<>();

    public static ArrayList<HBox> getNodes() {
        hboxHallsList.clear();

        if (hboxHallsList.isEmpty()) {
            for (Hall hallSingle : PrincipalController.getInformationToHall()) {
                Rectangle rectangle = new Rectangle(700, 450);
                rectangle.setArcWidth(12);
                rectangle.setArcHeight(12);

                Label labelUbication = new Label("Ubicación: ");
                Label labelPrice = new Label("Precio: ");
                Label labelCapacity = new Label("Aforo: ");
                Label labelDimensions = new Label("Dimensiones: ");
                Label labelCellphone = new Label("Teléfono: ");
                Label labelZoneHour = new Label("Zona Horaria: ");

                Label nameLabel = new Label(hallSingle.getNameOfHall());
                Label descriptionLabel = new Label(hallSingle.getDescription());
                Label ubicationLabel = new Label(hallSingle.getUbicationOfHall());
                Label capacityLabel = new Label(String.valueOf(hallSingle.getCapacity()));
                Label dimensionLabel = new Label(String.valueOf(hallSingle.getDimension()));
                Label cellphoneLabel = new Label(String.valueOf(hallSingle.getCellphone()));
                Label priceLabel = new Label(String.valueOf(hallSingle.getPriceOfHall()));
                Label valorationLabel = new Label(String.valueOf(hallSingle.getValorationOfHall()));
                ChoiceBox<String> timeZone = new ChoiceBox<>();

                //configuracion de choiceBox (timeZone)
                timeZone.getItems().addAll("6:00am - 8:00am", "8:00am - 10:00am","10:30am - 12:00pm","1:00pm - 3:00pm","3:00pm - 5:00pm","5:15pm - 7:30pm", "7:30pm - 10:30pm");
                timeZone.setValue("6:00am - 8:00am");

                nameLabel.setStyle(StylesConst.getStyleForLabelsTitle());

                List<Label> dataLabels = List.of(descriptionLabel, ubicationLabel,
                        capacityLabel, dimensionLabel, cellphoneLabel,
                        priceLabel, valorationLabel);

                for (Label label : dataLabels) {
                    label.setStyle(String.format("%s", StylesConst.getStyleForLabels()));
                }

                for (Label label : new Label[] {
                        labelUbication, labelPrice, labelCapacity, labelDimensions, labelCellphone, labelZoneHour
                }) {
                    label.setStyle(StylesConst.getFontweightToLabel());
                }

                Image image = new Image(pathConst.getLogoFastEvent());
                ImageView imageView = new ImageView(image);
                imageView.setFitWidth(350);
                imageView.setFitHeight(200);
                imageView.setPreserveRatio(true);
                HBox.setMargin(imageView, new Insets(0, 20, 0, 0));
                VBox imageContainer = new VBox(imageView);

                Button selectHall = new Button("Reservar");
                selectHall.setStyle(StylesConst.getStyleSelectHall());

                GridPane infoGrid = new GridPane();
                infoGrid.setStyle(StylesConst.getStyleInformationHall());
                infoGrid.setAlignment(Pos.CENTER);
                infoGrid.setMinWidth(486);
                infoGrid.setMinHeight(100);

                infoGrid.add(nameLabel, 0, 0);
                infoGrid.add(labelUbication, 0, 1);
                infoGrid.add(ubicationLabel, 1, 1);
                infoGrid.add(labelPrice, 0, 2);
                infoGrid.add(priceLabel, 1, 2);
                infoGrid.add(labelCapacity, 0, 3);
                infoGrid.add(capacityLabel, 1, 3);
                infoGrid.add(labelDimensions, 0, 4);
                infoGrid.add(dimensionLabel, 1, 4);
                infoGrid.add(labelCellphone, 0, 5);
                infoGrid.add(cellphoneLabel, 1, 5);
                infoGrid.add(labelZoneHour, 0, 6);
                infoGrid.add(timeZone, 1, 6);
                infoGrid.add(selectHall, 0, 7);

                GridPane.setMargin(selectHall, new Insets(10, 0, 0, 55));

                HBox fatherContainer = new HBox();
                fatherContainer.getChildren().addAll(infoGrid, imageContainer);
                fatherContainer.setMaxWidth(700);
                fatherContainer.setMinHeight(250);
                fatherContainer.setAlignment(Pos.CENTER);
                fatherContainer.setStyle(StylesConst.getStyleFatherContainer());
                fatherContainer.setClip(rectangle);
                fatherContainer.setEffect(new DropShadow(10, Color.rgb(0, 0, 0, 0.3)));

                hboxHallsList.add(fatherContainer);
            }
        }
        return hboxHallsList;
    }

    public static int getSizeVboxHallsList() {
        return hboxHallsList.size();
    }
}
