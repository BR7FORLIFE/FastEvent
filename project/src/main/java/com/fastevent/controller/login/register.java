package com.fastevent.controller.login;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;

import com.fastevent.constants.PathConst;
import com.fastevent.controller.simpleClasses.Client;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Control;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;

public class Register {
    private static PathConst pathConst = new PathConst();

    private Register(){}

    @SuppressWarnings("unchecked")
    public static void setInformationForClassUser(Control... informations) {
        String name = ((TextField) informations[0]).getText();
        String lastName = ((TextField) informations[1]).getText();
        Integer age = ((Spinner<Integer>) informations[2]).getValue();
        String email = ((TextField) informations[3]).getText();
        String cellphone = ((TextField) informations[4]).getText();
        String gender = ((ChoiceBox<String>) informations[5]).getValue();
        String user = ((TextField) informations[6]).getText();
        String password = ((PasswordField) informations[7]).getText();
        String confirmPassword = ((PasswordField) informations[8]).getText();

        Client client = new Client(name, lastName, age, cellphone, gender, email);
        client.setUser(user);
        client.setPassword(password);

        registerField(client);
    }

    private static void registerField(Client client) {
        try {
            ArrayList<Client> listOfUsers = new ArrayList<>();
            listOfUsers.add(client);
            // escribimos el contenido en el fichero con identaciones de json
            try (FileWriter writer = new FileWriter(pathConst.userJSon)) {
                Gson gson = new GsonBuilder().setPrettyPrinting().create();
                JsonObject root = new JsonObject();
                JsonElement usersJson = gson.toJsonTree(listOfUsers); // aca convertimos de ArrayList a JsonElement:)
                root.add("users:", usersJson);
                gson.toJson(root, writer);

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
