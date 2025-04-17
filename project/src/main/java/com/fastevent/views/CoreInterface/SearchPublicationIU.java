package com.fastevent.views.CoreInterface;

import java.util.ArrayList;

import com.fastevent.common.constants.PathConst;
import com.fastevent.common.constants.StylesConst;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;

public class SearchPublicationIU {
    private static ArrayList<HBox> hboxContainers = new ArrayList<>();
    private static PathConst pathConst = new PathConst();

    public static ArrayList<HBox> getNodes() {
        // clip para el nodo padre
        Rectangle rectangle = new Rectangle(700, 200);
        rectangle.setArcWidth(12);
        rectangle.setArcHeight(12);

        // titulos de la informacion
        Label labelUbicationOfHall = new Label("Ubicacion: ");
        Label labelPriceOfHall = new Label("Precio: ");
        Label labelCapacityOfHall = new Label("Aforo: ");
        Label labelDimensionsOfHall = new Label("Dimensiones: ");
        Label labelCellphoneToHall = new Label("Telefono: ");
        Image image = new Image(pathConst.getLogoFastEvent()); // nodo para la imagen!

        // informacion recuperada del modelo (esto es solo para ver si funciona!)
        Label titleOfHall = new Label("Marella Bodas y Eventos");
        Label ubicationOfHall = new Label("Manga Caller real #22-06");
        Label priceOfHall = new Label("500.000/hora");
        Label capacityOfHall = new Label("20 - 24 personas");
        Label dimensionsOfHall = new Label("20 x 24");
        Label cellphoneToHall = new Label("3106320086");
        Button selectHall = new Button("Seleccionar");

        // contenedores
        ImageView imageView = new ImageView(image);
        VBox imageContainer = new VBox(imageView);
        GridPane informationToHall = new GridPane();
        HBox fatherContainer = new HBox(); // este sera el contenedor final que sera retornado y mostrado!

        // estilos de los contenedores y nodos

        // boton de selecccionar salón
        selectHall.setStyle(StylesConst.getStyleSelectHall());
        selectHall.setPadding(new Insets(2, 25, 0, 25));

        // titulo del salon de evento
        titleOfHall.setStyle(StylesConst.getStyleTitleHall());

        ubicationOfHall.setStyle(StylesConst.getStyleForLabels());
        priceOfHall.setStyle(StylesConst.getStyleForLabels());
        capacityOfHall.setStyle(StylesConst.getStyleForLabels());
        dimensionsOfHall.setStyle(StylesConst.getStyleForLabels());
        cellphoneToHall.setStyle(StylesConst.getStyleForLabels());

        labelUbicationOfHall.setStyle(StylesConst.getFontweightToLabel());
        labelCapacityOfHall.setStyle(StylesConst.getFontweightToLabel());
        labelCellphoneToHall.setStyle(StylesConst.getFontweightToLabel());
        labelDimensionsOfHall.setStyle(StylesConst.getFontweightToLabel());
        labelPriceOfHall.setStyle(StylesConst.getFontweightToLabel());

        // contenedor de la informacion de los salones s
        informationToHall.setStyle(StylesConst.getStyleInformationHall());

        // configuracion de la grilla
        informationToHall.add(titleOfHall, 0, 0);
        informationToHall.add(labelUbicationOfHall, 0, 1);
        informationToHall.add(ubicationOfHall, 1, 1);
        informationToHall.add(labelPriceOfHall, 0, 2);
        informationToHall.add(priceOfHall, 1, 2);
        informationToHall.add(labelCapacityOfHall, 0, 3);
        informationToHall.add(capacityOfHall, 1, 3);
        informationToHall.add(labelDimensionsOfHall, 0, 4);
        informationToHall.add(dimensionsOfHall, 1, 4);
        informationToHall.add(labelCellphoneToHall, 0, 5);
        informationToHall.add(cellphoneToHall, 1, 5);
        informationToHall.add(selectHall, 0, 6);
        informationToHall.setAlignment(Pos.CENTER);

        GridPane.setMargin(titleOfHall, new Insets(0, 0, 15, 50));
        GridPane.setMargin(selectHall, new Insets(10, 0, 0, 55));

        // configuracion del contenedor padre
        fatherContainer.setMaxWidth(700);
        fatherContainer.setMinHeight(200);
        fatherContainer.setStyle(StylesConst.getStyleFatherContainer());
        fatherContainer.setClip(rectangle);
        fatherContainer.setAlignment(Pos.CENTER);

        // configuracion de los contenedores hijos
        imageView.setFitWidth(300);
        imageView.setFitHeight(170);
        imageView.setPreserveRatio(true);

        informationToHall.setMinWidth(486);
        informationToHall.setMinHeight(100);

        // configuraciones de los nodos

        // añadiendo los contenedores hijos la padre
        fatherContainer.getChildren().addAll(informationToHall, imageContainer);
        hboxContainers.add(fatherContainer);

        return hboxContainers;
    }
}
