package com.fastevent.views.modals;

import com.fastevent.common.constants.PathConst;
import com.fastevent.common.constants.StylesConst;
import com.fastevent.common.simpleClasses.Hall;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ReserveHallModalIU {
    private static PathConst pathConst = new PathConst();

    public static void modal(Stage fatherStage, Hall hall) {
        Stage stageModal = new Stage();
        stageModal.initModality(Modality.WINDOW_MODAL);// aca decimos que la modalidad es que sea una modal
        stageModal.initOwner(fatherStage);

        Image image = new Image(pathConst.getLogoFastEvent());
        ImageView imageView = new ImageView(image);

        imageView.setFitWidth(150);
        imageView.setFitHeight(150);
        imageView.setPreserveRatio(true);

        Label title = new Label(hall.getNameOfHall());
        Label capacity = new Label(String.valueOf("Capacidad: " + hall.getCapacity() + " personas!"));
        Label dimension = new Label(String.valueOf("Dimension: " + hall.getDimension() + " metros cradrados!"));
        Label cellphone = new Label(String.valueOf("Telefono: " + hall.getCellphone()));
        Label price = new Label(String.valueOf("Precio: " + hall.getPriceOfHall() + " COP"));
        Button saveHall = new Button("Guardar en Favoritos");
        Button selectHall = new Button("Reservar Salon");

        GridPane gridPane = new GridPane();
        gridPane.add(imageView, 0, 0);
        gridPane.add(title, 0, 1);
        gridPane.add(capacity, 0, 2);
        gridPane.add(dimension, 0, 3);
        gridPane.add(cellphone, 0, 4);
        gridPane.add(price, 0, 5);
        gridPane.add(saveHall, 0, 6);
        gridPane.add(selectHall, 1, 6);

        GridPane.setColumnSpan(title, 2);
        GridPane.setColumnSpan(capacity, 2);
        GridPane.setColumnSpan(dimension, 2);
        GridPane.setColumnSpan(cellphone, 2);
        GridPane.setColumnSpan(price, 2);

        gridPane.setAlignment(Pos.CENTER);
        gridPane.setVgap(12);
        gridPane.setHgap(12);

        // estilos de los nodos
        for (Label label : new Label[] {
                title, capacity, dimension, cellphone, price
        }) {
            label.setStyle(StylesConst.getStyleForLabels());
        }

        saveHall.setStyle(StylesConst.getStyleSelectHall());
        selectHall.setStyle(StylesConst.getStyleSelectHall());

        // estilo de la grilla
        gridPane.setStyle(StylesConst.getStyleFatherContainer());

        Scene scene = new Scene(gridPane, 400, 400);

        stageModal.setTitle("Reserve Event Hall");
        stageModal.setScene(scene);
        stageModal.setWidth(400);
        stageModal.setHeight(400);
        stageModal.setResizable(false);
        stageModal.setX(900);
        stageModal.setY(400);
        stageModal.showAndWait(); // muestra y espea que cierre la ventana para continuar
    }
}
