package com.fastevent.controller.core;


import java.io.FileReader;
import java.io.FileWriter;

import com.fastevent.common.constants.PathConst;
import com.fastevent.common.simpleClasses.Hall;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class FavoritesHallControllers { 
    private static final PathConst pathConst = new PathConst();

    public static void readFavorites(Hall hall){
        Boolean isEqualHallFavorites = false;

        try(FileReader jsonFavorites =  new FileReader(pathConst.getFavoritesJson())){
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            JsonObject root = gson.fromJson(jsonFavorites, JsonObject.class);   
            JsonArray arrayFavorites = root.get("favorites").getAsJsonArray();

            for(int i = 0; i < arrayFavorites.size(); i++){
                JsonObject objectsHalls = arrayFavorites.get(i).getAsJsonObject();
                String nameOfHall = objectsHalls.get("name").getAsString();

                if(nameOfHall.equals(hall.getNameOfHall())){
                    isEqualHallFavorites = true;
                }
            }

            if(!isEqualHallFavorites){
                JsonObject newFavoritesHall = new JsonObject();
                newFavoritesHall.addProperty("name", hall.getNameOfHall());
                newFavoritesHall.addProperty("description", hall.getDescription());
                newFavoritesHall.addProperty("ubication", hall.getUbicationOfHall());   
                newFavoritesHall.addProperty("capacity", hall.getCapacity());
                newFavoritesHall.addProperty("dimension", hall.getDimension());
                newFavoritesHall.addProperty("cellphone", hall.getCellphone());
                newFavoritesHall.addProperty("price", hall.getPriceOfHall());
                newFavoritesHall.addProperty("valoration", hall.getValorationOfHall());
                newFavoritesHall.addProperty("timezone", hall.getTimezone());

                arrayFavorites.add(newFavoritesHall);

                try (FileWriter saveJson = new FileWriter(pathConst.getFavoritesJson())) {
                    gson.toJson(root,saveJson);
                } catch (Exception e) {
                System.out.println(e);
                }

            }else{
                System.out.println("Esta en favoritos!!");
            }
           

        }catch(Exception e){
            System.out.println(e);
        }
    }

    public static void updateHallsFavorites(Runnable reloadWindow, String nameOfHall){
        try (FileReader reader = new FileReader(pathConst.getFavoritesJson())) {
                    Gson gson = new GsonBuilder().setPrettyPrinting().create();
                    JsonObject root = gson.fromJson(reader, JsonObject.class);
                    JsonArray favoritesArray = root.get("favorites").getAsJsonArray();

                    // Crear un nuevo arreglo sin el salón que se desea eliminar
                    JsonArray updatedArray = new JsonArray();
                    for (int j = 0; j < favoritesArray.size(); j++) {
                        JsonObject obj = favoritesArray.get(j).getAsJsonObject();
                        if (!obj.get("name").getAsString().equals(nameOfHall)) {
                            updatedArray.add(obj);
                        }
                    }

                    // Reemplazar el array y guardar el archivo
                    root.add("favorites", updatedArray);

                    try (FileWriter writer = new FileWriter(pathConst.getFavoritesJson())) {
                        gson.toJson(root, writer);
                    }

                    // Recargar ventana
                    reloadWindow.run();

                } catch (Exception e) {
                    System.out.println("Error al eliminar favorito: " + e.getMessage());
                }
            reloadWindow.run();
    }
}
