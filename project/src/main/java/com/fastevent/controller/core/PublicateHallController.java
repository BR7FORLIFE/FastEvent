package com.fastevent.controller.core;

import java.io.FileReader;
import java.io.FileWriter;

import com.fastevent.common.constants.PathConst;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import javafx.scene.control.TextField;

public class PublicateHallController {
    private static PathConst pathConst = new PathConst();

    public static void comprobateInformation(TextField... infoToHall) {
        try {
            String nameOfHall = infoToHall[0].getText();
            String descriptionOfHall = infoToHall[1].getText();
            String ubicationOfHall = infoToHall[2].getText();
            int capacityOfHall = Integer.parseInt(infoToHall[3].getText());
            int dimensionOfHall = Integer.parseInt(infoToHall[4].getText());
            long cellphone = Long.parseLong(infoToHall[5].getText());
            float priceOfHall = Float.parseFloat(infoToHall[6].getText());

            for (TextField field : infoToHall) {
                field.setDisable(true);
            }

            saveHall(nameOfHall, descriptionOfHall, ubicationOfHall, capacityOfHall, dimensionOfHall, cellphone,
                    priceOfHall);

            System.out.println("Salón agregado exitosamente!");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void saveHall(Object... informationTohall) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        JsonArray publicationArray = new JsonArray();
        JsonObject root = new JsonObject();

        try (FileReader reader = new FileReader(pathConst.getPublicationJson())) {
            root = gson.fromJson(reader, JsonObject.class);
            publicationArray = root.getAsJsonArray("publication");
            System.out.println(publicationArray);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        JsonObject newPublication = new JsonObject();
        newPublication.addProperty("name", (String) informationTohall[0]);
        newPublication.addProperty("description", (String) informationTohall[1]);
        newPublication.addProperty("ubication", (String) informationTohall[2]);
        newPublication.addProperty("capacity", (int) informationTohall[3]);
        newPublication.addProperty("dimension", (int) informationTohall[4]);
        newPublication.addProperty("cellphone", (long) informationTohall[5]);
        newPublication.addProperty("price", (float) informationTohall[6]);
        newPublication.addProperty("valoration", Math.random() * 6.0);
        newPublication.addProperty("timezone", "");

        publicationArray.add(newPublication);

        root.add("publication", publicationArray);

        try (FileWriter writer = new FileWriter(pathConst.getPublicationJson())) {
            gson.toJson(root, writer);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
