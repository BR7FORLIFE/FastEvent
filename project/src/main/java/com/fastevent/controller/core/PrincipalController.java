package com.fastevent.controller.core;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

import com.fastevent.common.constants.PathConst;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import javafx.scene.control.Label;

public class PrincipalController {
    private static PathConst pathConst = new PathConst();
    private static ArrayList<Label> hallInformation = new ArrayList<>();

    // atributos de la informacion de los diferentes salones

    private static String name, description, ubication;
    private static Integer capacity, dimension;
    private static Long cellphone;
    private static Float price, valoration;

    public static ArrayList<Label> getInformationToHall() {

        try (FileReader reader = new FileReader(pathConst.getPublicationJson())) {
            Gson gson = new Gson();
            JsonObject root = gson.fromJson(reader, JsonObject.class);
            JsonArray publicationOfHall = root.get("publication").getAsJsonArray();

            for (int i = 0; i < publicationOfHall.size(); i++) {
                JsonObject singlePublicationHall = publicationOfHall.get(i).getAsJsonObject();
                name = singlePublicationHall.get("name").getAsString();
                description = singlePublicationHall.get("description").getAsString();
                ubication = singlePublicationHall.get("ubication").getAsString();
                capacity = singlePublicationHall.get("ubication").getAsInt();
                dimension = singlePublicationHall.get("dimension").getAsInt();
                cellphone = singlePublicationHall.get("cellphone").getAsLong();
                price = singlePublicationHall.get("price").getAsFloat();
                valoration = singlePublicationHall.get("valoration").getAsFloat();
            }

            String parseCapacity = String.valueOf(capacity);
            String parseDimension = String.valueOf(dimension);
            String parseCellphone = String.valueOf(cellphone);
            String parsePrice = String.valueOf(price);
            String parseValoration = String.valueOf(valoration);

            hallInformation.add(new Label(name));
            hallInformation.add(new Label(description));
            hallInformation.add(new Label(ubication));
            hallInformation.add(new Label(parseCapacity));
            hallInformation.add(new Label(parseDimension));
            hallInformation.add(new Label(parseCellphone));
            hallInformation.add(new Label(parsePrice));
            hallInformation.add(new Label(parseValoration));

            reader.close();

            for(Label label : hallInformation ){
                System.out.println(label);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return hallInformation;
    }

    public static void sendInformationToHall() {
        try (FileWriter writer = new FileWriter("")) {

            writer.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
