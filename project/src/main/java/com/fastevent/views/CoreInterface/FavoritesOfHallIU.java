package com.fastevent.views.CoreInterface;

import java.io.FileReader;
import java.text.RuleBasedCollator;
import java.util.ArrayList;

import com.fastevent.common.constants.PathConst;
import com.fastevent.common.constants.StylesConst;
import com.fastevent.common.simpleClasses.Hall;
import com.fastevent.components.UpdateFavoritesHallComponent;
import com.fastevent.controller.core.FavoritesHallControllers;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

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
    private static ArrayList<HBox> halls = new ArrayList<>();
    private static String nameOfHall = "";
    private static float priceOfHall = 0.0f; 

    //atributos globales para las actualizaciones
    private static Runnable reloadV;
    private static Hall hallV;
    private static Button favoriteHallButton;

    /**
     * 
     * @param hall              es la informacion actual del salon que queremos
     *                          agregar
     * @param linkToCurrentHall este sera el contenedor al cual queremos linkear
     *                          para tener comunicacion entre ellos
     * @param index             esto nos permitira linkear los contenedores
     * @return ArrayList<HBox> de todas las publicaciones
     */
    public static ArrayList<HBox> favoritesHallRendering(Runnable reloadWindow, Hall hall, Button favoriteHall) {
        halls.clear();
        reloadV = reloadWindow;
        hallV = hall;
        favoriteHallButton = favoriteHall;

        try (FileReader jsonFavorites = new FileReader(pathconst.getFavoritesJson())) {
            Gson gson = new Gson();
            JsonObject root = gson.fromJson(jsonFavorites, JsonObject.class);
            JsonArray favoritesHallsArray = root.get("favorites").getAsJsonArray();
        
            for(int i = 0; i < favoritesHallsArray.size(); i++){
            JsonObject favoritesHalls = favoritesHallsArray.get(i).getAsJsonObject();

                nameOfHall = favoritesHalls.get("name").getAsString();
                priceOfHall = favoritesHalls.get("price").getAsFloat();

                // clip
                Rectangle rectangle = new Rectangle(700, 450); // para el clip
                rectangle.setArcWidth(12);
                rectangle.setArcHeight(12);

                // creando los nodos
                Label titleOfHall = new Label(nameOfHall);
                Label labelPrice = new Label("Precio del salón: ");
                Label price = new Label(String.valueOf(priceOfHall));
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
                    FavoritesHallControllers.updateHallsFavorites(reloadWindow,nameOfHall);
                    favoritesHallRendering(reloadWindow, hall, favoriteHall);
                    favoriteHall.fire();
                    System.out.println(halls);
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

                // agregamos la nueva card generada al ArrayList
                halls.add(fatherContainer);

            }
         
        } catch (Exception e) {
            System.out.println(e);
        }
        return halls;
    }

    public static ArrayList<HBox> hallsContainersFavorites() {
       return halls;
    }

    public static int getSizeFavoritesHalls() {
        return halls.size(); // retorna el tamaño de la lista de contenedores favoritos
    }
}
