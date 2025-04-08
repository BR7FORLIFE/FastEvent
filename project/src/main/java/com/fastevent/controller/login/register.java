package com.fastevent.controller.login;

import java.io.FileWriter;

import com.fastevent.constants.PathConst;
import com.fastevent.controller.simpleClasses.Client;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class Register {
    private static Client client;
    private static PathConst pathConst = new PathConst();

    public static void setClient(Client client){
        Register.client = client;
        registerField();
    }

    private static void registerField() {
        try {
            // creamos el diseño del json_users
            JsonArray listOfUsers = new JsonArray();
            JsonObject users = new JsonObject();

            // añadimos sus respectivas propiedades
            users.addProperty("name:", client.getUser());
            users.addProperty("password:", client.getPassword());

            // añadimos el objeto al JsonArray
            listOfUsers.add(users);

            // escribimos el contenido en el fichero con identaciones de json
            try (FileWriter writer = new FileWriter(pathConst.userJSon)) {
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
