package com.fastevent.views.CoreInterface;

import java.util.ArrayList;

import com.fastevent.common.simpleClasses.Hall;

import javafx.scene.layout.HBox;

public class FavoritesOfHallIU {
    private static ArrayList<HBox> favoritesHalls = new ArrayList<>();

    public static ArrayList<HBox> favoritesHallRendering(Hall hall) {
        


        return favoritesHalls;
    }

    public static ArrayList<HBox> hallsContainersFavorites() {
        return favoritesHalls;
    }

    public static int getSizeFavoritesHalls() {
        return favoritesHalls.size();
    }
}
