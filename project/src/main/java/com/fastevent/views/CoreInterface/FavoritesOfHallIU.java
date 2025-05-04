package com.fastevent.views.CoreInterface;

import java.util.ArrayList;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class FavoritesOfHallIU {
    private static ArrayList<HBox> favoritesHalls = new ArrayList<>();

    public static ArrayList<HBox> favoritesHallRendering(HBox favoritesPublication){
        GridPane elementsGrid = (GridPane) favoritesPublication.getChildren().get(0);
        
        Button removeToFavorites = new Button("Eliminar de favoritos");
        removeToFavorites.setStyle("-fx-background-color:red; -fx-font-weight: 800");
        GridPane.setMargin(removeToFavorites, new Insets(15, 0, 0, 0));
        elementsGrid.add(removeToFavorites, 1, 7);
        favoritesHalls.add(favoritesPublication);
        
        return favoritesHalls;
    }

    public static ArrayList<HBox> hallsContainersFavorites(){
        return favoritesHalls;
    }

    public static int getSizeFavoritesHalls(){
        return  favoritesHalls.size();
    }
}
