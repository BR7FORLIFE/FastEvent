package com.fastevent.views.CoreInterface;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.fastevent.common.constants.PathConst;
import com.fastevent.common.constants.StylesConst;
import com.fastevent.common.simpleClasses.Hall;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
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

//esta es la clase que nos permitira agregar los salones en favoritos
public class FavoritesOfHallIU {
    private static final PathConst pathconst = new PathConst();

    /* esto nos ayudara a tener linked de cada salon que se este seleccionando */
    private static final Map<Integer, HBox> favoritesHalls = new HashMap<>();

    /**
     * 
     * @param hall              es la informacion actual del salon que queremos
     *                          agregar
     * @param linkToCurrentHall este sera el contenedor al cual queremos linkear
     *                          para tener comunicacion entre ellos
     * @param index             esto nos permitira linkear los contenedores
     * @return ArrayList<HBox> de todas las publicaciones
     */
    public static ArrayList<HBox> favoritesHallRendering(Hall hall, HBox linkToCurrentHall, int index, Runnable runnable) {
        if (!favoritesHalls.containsKey(index)) {
            // clip
            Rectangle rectangle = new Rectangle(700, 450); // para el clip
            rectangle.setArcWidth(12);
            rectangle.setArcHeight(12);

            // creando los nodos
            Label titleOfHall = new Label(hall.getNameOfHall());
            Label labelPrice = new Label("Precio del salón: ");
            Label price = new Label(String.valueOf(hall.getPriceOfHall()));
            Button removeToFavorite = new Button("Eliminar de favoritos");
            Button linked = new Button("linked");

            Image image = new Image(pathconst.getLogoFastEvent());
            ImageView imageContainer = new ImageView(image);
            VBox vboxImage = new VBox(imageContainer);
            vboxImage.setAlignment(Pos.CENTER);

            // configuracion del ImageView
            imageContainer.setFitWidth(350);
            imageContainer.setFitHeight(200);
            imageContainer.setPreserveRatio(true);

            // creando la grilla para los elementos
            GridPane grid = new GridPane();
            grid.add(titleOfHall, 0, 0);
            grid.add(labelPrice, 0, 1);
            grid.add(price, 1, 1);
            grid.add(removeToFavorite, 0, 2);
            grid.add(linked, 1, 2);

            GridPane.setColumnSpan(titleOfHall, 2);
            grid.setAlignment(Pos.CENTER_LEFT);

            // estilos CSS
            titleOfHall.setStyle("-fx-font-size: 20px; -fx-font-weight: 800;");
            labelPrice.setStyle("-fx-font-size: 15px; -fx-font-weight: 800;");
            price.setStyle("-fx-font-size: 15px; -fx-font-weight: 800;");
            removeToFavorite.setStyle("-fx-background-color:red; -fx-font-weight: 800; -fx-text-fill: white");
            linked.setStyle(StylesConst.getStyleSelectHall());

            // margenes
            for (Node node : new Node[] {
                    titleOfHall, labelPrice, price, removeToFavorite, linked
            }) {
                GridPane.setMargin(node, new Insets(0, 15, 10, 0));
            }

            // addeventlistener
            removeToFavorite.setOnAction(e -> {
                favoritesHalls.remove(index);
                runnable.run();
            });

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

            return new ArrayList<>(favoritesHalls.values());

        } else {
            return new ArrayList<>(favoritesHalls.values());
        }
    }

    public static ArrayList<HBox> hallsContainersFavorites() {
        return new ArrayList<>(favoritesHalls.values()); // retornamos la lista de contenedores favoritos
    }

    public static int getSizeFavoritesHalls() {
        return favoritesHalls.size(); // retorna el tamaño de la lista de contenedores favoritos
    }
}
