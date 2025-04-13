package com.fastevent.controller.login;

import java.io.FileWriter;
import java.util.HashMap;

import com.fastevent.constants.PathConst;
import com.fastevent.controller.simpleClasses.Client;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import javafx.scene.control.Control;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class Register {
    private static PathConst pathConst = new PathConst();
    private static HashMap<String, String> informationsForUser = new HashMap<>();

    private Register(){}

    public static void setInformationForClassUser(Control... informations) {
        String name = ((TextField) informations[0]).getText();
        String lastName = ((TextField)informations[1]).getText();
        String age = ((TextField)informations[2]).getText();
        String email = ((TextField)informations[3]).getText();
        String cellphone = ((TextField)informations[4]).getText();
        String gender;
        String usuario = ((TextField)informations[5]).getText();
        String password = ((PasswordField)informations[6]).getText();
        String confirmPassword = ((PasswordField)informations[7]).getText();

        informationsForUser.put("name: ", name);
        informationsForUser.put("lastName: ", lastName);
        informationsForUser.put("age: ", age);
        informationsForUser.put("email: ", email);
        informationsForUser.put("cellphone: ", cellphone);
        informationsForUser.put("usuario: ", usuario);
        informationsForUser.put("password: ", password);
        informationsForUser.put("confirmPassword: ", confirmPassword);



        
        //Client client = new Client(name, lastName, age, cellphone, email);

    }

    private static void registerField() {
        try {
            // creamos el diseño del json_users
            JsonArray listOfUsers = new JsonArray();
            JsonObject users = new JsonObject();

            // añadimos sus respectivas propiedades
            users.addProperty("name:", "hola");
            users.addProperty("password:", "hola");

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
