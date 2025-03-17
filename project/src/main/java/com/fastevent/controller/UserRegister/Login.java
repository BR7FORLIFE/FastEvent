package com.fastevent.controller.UserRegister;

import java.io.FileReader;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class Login {
    private static String nameField;
    private static String passwordField;

    public static void userField(String username, String password) {
        try (FileReader reader = new FileReader(Register.pathToJson)) {
            Gson gson = new Gson();
            JsonObject root = gson.fromJson(reader, JsonObject.class);

            JsonArray user = root.get("users:").getAsJsonArray();

            for (int i = 0; i < user.size(); i++) {
                JsonObject fields = user.get(i).getAsJsonObject();
                nameField = fields.get("name:").getAsString();
                passwordField = fields.get("password:").getAsString();
            }

            if (nameField.equals(username) && passwordField.equals(password)) {
                System.out.println("Sesion iniciada con exito!");
            } else {
                System.out.println("usuario incorrecto!");
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
