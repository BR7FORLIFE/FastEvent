package com.fastevent.controller.core;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

import com.fastevent.common.constants.PathConst;
import com.fastevent.common.simpleClasses.Hall;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

/**
 * esta clase nos permite obtener y establecer la información de los salones
 * recurriendo al modelo
 */
public class PrincipalController {

    private static PathConst pathConst = new PathConst();
    private static ArrayList<Hall> hallInformation = new ArrayList<>();

    private static String name, description, ubication;
    private static Integer capacity, dimension;
    private static Long cellphone;
    private static Float price, valoration;

    public static ArrayList<Hall> getInformationToHall() {
        hallInformation.clear();

        try (FileReader reader = new FileReader(pathConst.getPublicationJson())) {
            Gson gson = new Gson();
            JsonObject root = gson.fromJson(reader, JsonObject.class);
            JsonArray publicationOfHall = root.get("publication").getAsJsonArray();

            for (int i = 0; i < publicationOfHall.size(); i++) {
                JsonObject singlePublicationHall = publicationOfHall.get(i).getAsJsonObject();
                name = singlePublicationHall.get("name").getAsString();
                description = singlePublicationHall.get("description").getAsString();
                ubication = singlePublicationHall.get("ubication").getAsString();
                capacity = singlePublicationHall.get("capacity").getAsInt();
                dimension = singlePublicationHall.get("dimension").getAsInt();
                cellphone = singlePublicationHall.get("cellphone").getAsLong();
                price = singlePublicationHall.get("price").getAsFloat();
                valoration = singlePublicationHall.get("valoration").getAsFloat();

                hallInformation.add(
                        new Hall(name, description, ubication, capacity, dimension, cellphone, price, valoration));
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

    public static int getSizeHallInformation() {
        return hallInformation.size();
    }
}
