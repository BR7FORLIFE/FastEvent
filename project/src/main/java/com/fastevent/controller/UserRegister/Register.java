package com.fastevent.controller.UserRegister;

import java.io.FileWriter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class Register {
    public static String pathToJson = "project/src/main/java/com/fastevent/Model/users.json";

    public static void registerField(String name, String password) {
        try {
            // creamos el diseño del json_users
            JsonArray listOfUsers = new JsonArray();
            JsonObject users = new JsonObject();

            //añadimos sus respectivas propiedades
            users.addProperty("name:", name);
            users.addProperty("password:", password);

            //añadimos el objeto al JsonArray
            listOfUsers.add(users);

            //escribimos el contenido en el fichero con identaciones de json
            try (FileWriter writer = new FileWriter(pathToJson)) {
                Gson gson = new GsonBuilder().setPrettyPrinting().create();
                JsonObject root = new JsonObject();
                root.add("users:", listOfUsers);
                gson.toJson(root, writer);

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
