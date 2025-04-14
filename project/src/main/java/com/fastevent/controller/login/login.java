package com.fastevent.controller.login;

import java.io.FileReader;

import com.fastevent.common.constants.PathConst;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class Login {
    private static PathConst pathConst = new PathConst();
    private static String nameField;
    private static String passwordField;


    public static void credentials(String user, String password){
        userField(user, password);
    }

    private static void userField(String userCredential , String passwordCredential) {

        try (FileReader reader = new FileReader(pathConst.getUserJSon())) {
            Gson gson = new Gson();
            JsonObject root = gson.fromJson(reader, JsonObject.class);

            JsonArray user = root.get("users:").getAsJsonArray();

            for (int i = 0; i < user.size(); i++) {
                JsonObject fields = user.get(i).getAsJsonObject();
                nameField = fields.get("name:").getAsString();
                passwordField = fields.get("password:").getAsString();
            }

            if (nameField.equals(userCredential) && passwordField.equals(passwordCredential)) {
                System.out.println("Sesion iniciada con exito!");
            } else {
                System.out.println("usuario incorrecto!");
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
