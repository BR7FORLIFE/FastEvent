package com.fastevent.views.CoreInterface;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.fastevent.common.constants.PathConst;
import com.fastevent.common.constants.StylesConst;
import com.fastevent.common.simpleClasses.Hall;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class FavoritesOfHallIU {
    private static final PathConst pathconst = new PathConst();
    private static final Map<Integer, HBox> favoritesHalls = new HashMap<>();
    private static final ArrayList<HBox> hboxes = new ArrayList<>();

    public static ArrayList<HBox> favoritesHallRendering(Hall hall, HBox linkToCurrentHall, int index) {
        if (!favoritesHalls.containsKey(index)) {
            // clip
            Rectangle rectangle = new Rectangle(700, 450); // para el clip
            rectangle.setArcWidth(12);
            rectangle.setArcHeight(12);

            // creando los nodos
            Label titleOfHall = new Label(hall.getNameOfHall());
            Label price = new Label(String.valueOf(hall.getPriceOfHall()));
            Button removeToFavorite = new Button("Eliminar de favoritos");

            Image image = new Image(pathconst.getLogoFastEvent());
            ImageView imageContainer = new ImageView(image);
            VBox vboxImage = new VBox(imageContainer);

            // configuracion del ImageView
            imageContainer.setFitWidth(350);
            imageContainer.setFitHeight(200);
            imageContainer.setPreserveRatio(true);

            // creando la grilla para los elementos
            GridPane grid = new GridPane();
            grid.add(titleOfHall, 0, 0);
            grid.add(price, 0, 1);
            grid.add(removeToFavorite, 0, 2);

            // contenedor padre
            HBox fatherContainer = new HBox();
            fatherContainer.getChildren().addAll(grid, vboxImage);
            fatherContainer.setMaxWidth(700);
            fatherContainer.setMinHeight(250);
            fatherContainer.setAlignment(Pos.CENTER);
            fatherContainer.setStyle(StylesConst.getStyleFatherContainer());
            fatherContainer.setClip(rectangle);

            // aplicamos efecto de sombra a las cards
            fatherContainer.setEffect(new DropShadow(10, Color.rgb(0, 0, 0, 0.3)));

            // agregamos la nueva card generada al HashMap
            favoritesHalls.put(index, fatherContainer);
            hboxes.add(favoritesHalls.get(index));

            return hboxes;

        } else {
            return hboxes;
        }
    }

    public static ArrayList<HBox> hallsContainersFavorites() {
        return hboxes;
    }

    public static int getSizeFavoritesHalls() {
        return favoritesHalls.size();
    }
}
