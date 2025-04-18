package com.fastevent.controller.core;

import java.util.ArrayList;
import java.util.List;

import com.fastevent.common.constants.PathConst;
import com.fastevent.common.constants.StylesConst;
import com.fastevent.common.simpleClasses.Hall;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;

public class SearchHallController {

    private static PathConst pathConst = new PathConst();
    private static ArrayList<VBox> vboxHallsList = new ArrayList<>();

    public static ArrayList<VBox> getNodes() {

        if (vboxHallsList.isEmpty()) {
            for (Hall hallSingle : PrincipalController.getInformationToHall()) {
                Rectangle rectangle = new Rectangle(700, 200);
                rectangle.setArcWidth(12);
                rectangle.setArcHeight(12);

                Label labelUbication = new Label("Ubicación: ");
                Label labelPrice = new Label("Precio: ");
                Label labelCapacity = new Label("Aforo: ");
                Label labelDimensions = new Label("Dimensiones: ");
                Label labelCellphone = new Label("Teléfono: ");

                Label nameLabel = new Label(hallSingle.getNameOfHall());
                Label descriptionLabel = new Label(hallSingle.getDescription());
                Label ubicationLabel = new Label(hallSingle.getUbicationOfHall());
                Label capacityLabel = new Label(String.valueOf(hallSingle.getCapacity()));
                Label dimensionLabel = new Label(String.valueOf(hallSingle.getDimension()));
                Label cellphoneLabel = new Label(String.valueOf(hallSingle.getCellphone()));
                Label priceLabel = new Label(String.valueOf(hallSingle.getPriceOfHall()));
                Label valorationLabel = new Label(String.valueOf(hallSingle.getValorationOfHall()));

                List<Label> dataLabels = List.of(nameLabel, descriptionLabel, ubicationLabel,
                        capacityLabel, dimensionLabel, cellphoneLabel,
                        priceLabel, valorationLabel);

                for (Label label : dataLabels) {
                    label.setStyle(String.format("%s %s",
                            StylesConst.getStyleForLabels(),
                            StylesConst.getFontweightToLabel()));
                }

                Image image = new Image(pathConst.getLogoFastEvent());
                ImageView imageView = new ImageView(image);
                imageView.setFitWidth(300);
                imageView.setFitHeight(170);
                imageView.setPreserveRatio(true);
                VBox imageContainer = new VBox(imageView);

                Button selectHall = new Button("Seleccionar");

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
                infoGrid.add(selectHall, 0, 6);

                GridPane.setMargin(selectHall, new Insets(10, 0, 0, 55));

                VBox fatherContainer = new VBox();
                fatherContainer.getChildren().addAll(infoGrid, imageContainer);
                fatherContainer.setMaxWidth(700);
                fatherContainer.setMinHeight(200);
                fatherContainer.setAlignment(Pos.CENTER);
                fatherContainer.setStyle(StylesConst.getStyleFatherContainer());
                fatherContainer.setClip(rectangle);

                vboxHallsList.add(fatherContainer);
            }
        }
        return vboxHallsList;
    }

    public static int getSizeVboxHallsList() {
        return vboxHallsList.size();
    }
}
