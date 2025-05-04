package com.fastevent.controller.core;

import java.io.FileReader;

import com.fastevent.common.constants.PathConst;
import com.fastevent.common.simpleClasses.Hall;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class ReserveHallController {
    private static PathConst pathConst = new PathConst();
    private static Hall hall;

    public static Hall getHallById(int index) {
        try (FileReader reader = new FileReader(pathConst.getPublicationJson())) {
            Gson gson = new Gson();
            JsonObject root = gson.fromJson(reader, JsonObject.class);
            JsonArray publications = root.get("publication").getAsJsonArray();

            JsonObject selectHall = publications.get(index).getAsJsonObject();

            String nameHall = selectHall.get("name").getAsString();
            String descriptionHall = selectHall.get("description").getAsString();
            String ubicationHall = selectHall.get("ubication").getAsString();
            int capacityHall = selectHall.get("capacity").getAsInt();
            int dimensionHall = selectHall.get("dimension").getAsInt();
            Long cellphoneHall = selectHall.get("cellphone").getAsLong();
            float priceOfHall = selectHall.get("price").getAsFloat();
            float valorationHall = selectHall.get("valoration").getAsFloat();
            String timezone = selectHall.get("timezone").getAsString();

            hall = new Hall(nameHall, descriptionHall, ubicationHall, capacityHall, dimensionHall, cellphoneHall,
                    priceOfHall, valorationHall,timezone);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return hall;
    }
}
