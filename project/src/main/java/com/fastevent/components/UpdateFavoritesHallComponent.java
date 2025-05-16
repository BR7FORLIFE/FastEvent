package com.fastevent.components;

import com.fastevent.common.simpleClasses.Hall;
import com.fastevent.controller.core.FavoritesHallControllers;
import com.fastevent.views.CoreInterface.FavoritesOfHallIU;

import javafx.scene.control.Button;

public class UpdateFavoritesHallComponent {
    public static void refresh(Runnable reloadWindow, Hall hall, Button favoriteHall){
        FavoritesHallControllers.readFavorites(hall);
        FavoritesOfHallIU.favoritesHallRendering(reloadWindow, hall, favoriteHall);
    }
}
