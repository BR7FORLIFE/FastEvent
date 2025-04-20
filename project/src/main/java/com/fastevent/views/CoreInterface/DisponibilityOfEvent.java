package com.fastevent.views.CoreInterface;

import com.fastevent.common.constants.PathConst;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class DisponibilityOfEvent {
    private static PathConst pathConst = new PathConst();

    public static HBox disponibilityOfHall() {
        Image image1 = new Image(pathConst.getCircoImage());
        ImageView imageContent1 = new ImageView(image1);

        Label title1 = new Label("Circo de los hermanos Gasca");
        Label description1 = new Label("Sumergete en otra realidad, vive la emoción en la gran pantalla!");
        Label ubication1 = new Label("El country - Cartagena");
        Label hour1 = new Label("6pm - 11pm");

        Image image2 = new Image(pathConst.getHayFestivalImage());
        ImageView imageContent2 = new ImageView(image2);

        Label title2 = new Label("Hay festival RCN");
        Label description2 = new Label("Un encuentro de ideas, cultura, y conversaciones!");
        Label ubication2 = new Label("El centro - Cartagena");
        Label hour2 = new Label("9am - 3pm");

        imageContent1.setFitWidth(50);
        imageContent1.setFitHeight(50);
        imageContent1.setPreserveRatio(true);

        imageContent2.setFitWidth(50);
        imageContent2.setFitHeight(50);
        imageContent2.setPreserveRatio(true);


        VBox hall1 = new VBox();
        hall1.getChildren().addAll(imageContent1, title1, description1, ubication1, hour1);
        VBox hall2 = new VBox();
        hall2.getChildren().addAll(imageContent2, title2, description2, ubication2, hour2);

        HBox hallContainer = new HBox();
        hallContainer.getChildren().addAll(hall1, hall2);

        return hallContainer;
    }
}
