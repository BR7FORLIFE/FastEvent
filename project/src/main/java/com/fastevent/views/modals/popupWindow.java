package com.fastevent.views.modals;

import java.awt.Insets;

import javax.lang.model.element.Element;

import com.fastevent.common.constants.StylesConst;
import com.fastevent.common.simpleClasses.Hall;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class popupWindow {
    public static void showMessage(Stage stageModal, Hall hall, String timezone) {
        Stage stagePopupWindows = new Stage();
        stagePopupWindows.initModality(Modality.WINDOW_MODAL);// aca decimos que la modalidad es que sea una modal
        stagePopupWindows.initOwner(stageModal);

        Label messageLabel = new Label("Ha rentado el salon de eventos!! felicidades :=D");
        Label nameLabel = new Label("Nombre del salon: " + hall.getNameOfHall());
        Label timezoneLabel = new Label("Rango horario: " + timezone);
        Button closeWindows = new Button("Cerrar");

        closeWindows.setStyle(StylesConst.getStyleSelectHall());

        GridPane grid = new GridPane();
        grid.add(messageLabel, 0, 0);
        grid.add(nameLabel, 0, 1);
        grid.add(timezoneLabel, 0, 2);
        grid.add(closeWindows, 0, 3);

        GridPane.setColumnSpan(messageLabel, 2);
        grid.setStyle(StylesConst.getStyleFatherContainer());

        for (Label label : new Label[] {
                messageLabel, nameLabel, timezoneLabel
        }) {
            label.setStyle(StylesConst.getStyleForLabels());
        }

        grid.setAlignment(Pos.CENTER);

        closeWindows.setOnAction(e -> {
            stagePopupWindows.close();
            stageModal.close();
        });
    
        Scene scene = new Scene(grid);

        stagePopupWindows.setTitle("Message Dialog");
        stagePopupWindows.setScene(scene);
        stagePopupWindows.setWidth(400);
        stagePopupWindows.setHeight(300);
        stagePopupWindows.setResizable(false);
        stagePopupWindows.setX(450);
        stagePopupWindows.setY(300);
        stagePopupWindows.showAndWait(); // muestra y espea que cierre la ventana para continuar
    }
}
