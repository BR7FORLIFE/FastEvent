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

//esta es la clase encargada de crear los distintas cards de los salones
public class ReserveHallIU {
    private static final PathConst pathConst = new PathConst();
    private static final ArrayList<HBox> hboxHallsList = new ArrayList<>();

    public static ArrayList<HBox> getNodes() {
        hboxHallsList.clear(); // limpiamos despues de cada llamada al metodo el arrayList

        // si efectivamente esta vacia emepzamos a inyectar la informacion
        if (hboxHallsList.isEmpty()) {
            for (Hall hallSingle : PrincipalController.getInformationToHall()) {
                Rectangle rectangle = new Rectangle(700, 450); // para el clip
                rectangle.setArcWidth(12);
                rectangle.setArcHeight(12);

                // diferentes labels para los titulos de cada card
                Label labelUbication = new Label("Ubicación: ");
                Label labelPrice = new Label("Precio: ");
                Label labelCapacity = new Label("Aforo: ");
                Label labelDimensions = new Label("Dimensiones: ");
                Label labelCellphone = new Label("Teléfono: ");
                Label labelZoneHour = new Label("Zona Horaria: ");

                // inyectamos la informacion en nuevos label gracias a la clase hall
                Label nameLabel = new Label(hallSingle.getNameOfHall());
                Label descriptionLabel = new Label(hallSingle.getDescription());
                Label ubicationLabel = new Label(hallSingle.getUbicationOfHall());
                Label capacityLabel = new Label(String.valueOf(hallSingle.getCapacity()));
                Label dimensionLabel = new Label(String.valueOf(hallSingle.getDimension()));
                Label cellphoneLabel = new Label(String.valueOf(hallSingle.getCellphone()));
                Label priceLabel = new Label(String.valueOf(hallSingle.getPriceOfHall()));
                Label valorationLabel = new Label(String.valueOf(hallSingle.getValorationOfHall()));
                ChoiceBox<String> timeZone = new ChoiceBox<>();

                // configuracion de choiceBox (timeZone)
                timeZone.getItems().addAll("6:00am - 8:00am", "8:00am - 10:00am", "10:30am - 12:00pm",
                        "1:00pm - 3:00pm", "3:00pm - 5:00pm", "5:15pm - 7:30pm", "7:30pm - 10:30pm");
                timeZone.setValue("6:00am - 8:00am");

                nameLabel.setStyle(StylesConst.getStyleForLabelsTitle());

                // label los cuales fueron inyectadas la informacion
                List<Label> dataLabels = List.of(descriptionLabel, ubicationLabel,
                        capacityLabel, dimensionLabel, cellphoneLabel,
                        priceLabel, valorationLabel);

                for (Label label : dataLabels) { // para cada label le aplicamos su estilo
                    label.setStyle(String.format("%s", StylesConst.getStyleForLabels()));
                }

                for (Label label : new Label[] { // y para los titulos de la card
                        labelUbication, labelPrice, labelCapacity, labelDimensions, labelCellphone, labelZoneHour
                }) {
                    label.setStyle(StylesConst.getFontweightToLabel());// aplicamos un font-weight
                }

                // imagen y contenedor de imagen
                Image image = new Image(pathConst.getLogoFastEvent());
                ImageView imageView = new ImageView(image);
                imageView.setFitWidth(350);
                imageView.setFitHeight(200);
                imageView.setPreserveRatio(true);
                HBox.setMargin(imageView, new Insets(0, 20, 0, 0));
                VBox imageContainer = new VBox(imageView); // contenedor para guardar el contenedor
                // de imagen

                // boton para reservar
                Button selectHall = new Button("Reservar");
                selectHall.setStyle(StylesConst.getStyleSelectHall());// aplicamos el estilo

                // grillap para ubicar los elementps
                GridPane infoGrid = new GridPane();
                infoGrid.setStyle(StylesConst.getStyleInformationHall());
                // alineaciones y ancho - alto minimo
                infoGrid.setAlignment(Pos.CENTER);
                infoGrid.setMinWidth(486);
                infoGrid.setMinHeight(100);

                // organizacion de los labels en la grilla
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

                // margen para el boton de seleccionar
                GridPane.setMargin(selectHall, new Insets(10, 0, 0, 55));

                // contenedor padre al cual le agregamos la grilla y la imagen
                HBox fatherContainer = new HBox();
                fatherContainer.getChildren().addAll(infoGrid, imageContainer);
                fatherContainer.setMaxWidth(700);
                fatherContainer.setMinHeight(250);
                fatherContainer.setAlignment(Pos.CENTER);
                fatherContainer.setStyle(StylesConst.getStyleFatherContainer());
                fatherContainer.setClip(rectangle);

                // aplicamos efecto de sombra a las cards
                fatherContainer.setEffect(new DropShadow(10, Color.rgb(0, 0, 0, 0.3)));

                hboxHallsList.add(fatherContainer); // añadimos los HBox al arraylist
            }
        }
        return hboxHallsList; //retornamos
    }

    public static int getSizeVboxHallsList() {
        return hboxHallsList.size(); // retornamos el tamaño del ARRAYLIST
    }
}
