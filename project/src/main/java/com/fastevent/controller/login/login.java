package com.fastevent.controller.login;

import java.io.FileReader;

import com.fastevent.common.constants.PathConst;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import javafx.scene.control.Control;
import javafx.scene.control.TextField;

public class Login {
    private static PathConst pathConst = new PathConst();
    private static String userField;
    private static String passwordField;

    public static void credentials(Control... fields) {
        String username = ((TextField) fields[0]).getText();
        String password = ((TextField) fields[1]).getText();

        userField(username, password);
    }

    private static void userField(String user, String password) {

        try (FileReader reader = new FileReader(pathConst.getUserJSon())) {
            Gson gson = new Gson();
            JsonObject root = gson.fromJson(reader, JsonObject.class);

            JsonArray users = root.get("users:").getAsJsonArray();

            for (int i = 0; i < users.size(); i++) {
                JsonObject information = users.get(i).getAsJsonObject();
                userField = information.get("user").getAsString();
                passwordField = information.get("password").getAsString();
            }

            if (userField.equals(user) && passwordField.equals(password)) {
                System.out.println("Sesion iniciada con exito!");
            } else {
                System.out.println("usuario incorrecto!");
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
