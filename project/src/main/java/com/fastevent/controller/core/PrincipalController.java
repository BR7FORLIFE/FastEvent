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

    // accdemos a las diferentes constantes
    private static final PathConst pathConst = new PathConst();
    // es un arrayList de Hall para poder guardar la informacion mas facilmente
    private static final ArrayList<Hall> hallInformation = new ArrayList<>();

    // incializar las variables para tener un salon por lo menos la informacion
    // basica
    private static String name, description, ubication, timezone;
    private static Integer capacity, dimension;
    private static Long cellphone;
    private static Float price, valoration;

    /*
     * es un metodo ue nos devuelve una lista de Hall para poder tener la
     * informacion de cada uno de los salones
     * y este metodo lo utiliza SearchPublication tanto controller como Iu
     */

    public static ArrayList<Hall> getInformationToHall() {
        /*
         * limpiamos el array list cada vez que se llama al metodo para guardar la nueva
         * informacion ya agregada!
         */
        hallInformation.clear();

        // leemos el Json que es el modelo de las publicaciones
        try (FileReader reader = new FileReader(pathConst.getPublicationJson())) {
            Gson gson = new Gson();
            JsonObject root = gson.fromJson(reader, JsonObject.class);
            JsonArray publicationOfHall = root.get("publication").getAsJsonArray();

            // leemos cada elemento del Json
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
                timezone = singlePublicationHall.get("timezone").getAsString();

                /*
                 * almacenamos dichos valores dentro del array de salones donde creamos una
                 * nueva instancia de hall y le pasamos los parametros basicos como name ,
                 * description, capacity, dimension, cellphone, price,
                 * y valoration
                 */
                hallInformation.add(
                        new Hall(name, description, ubication, capacity, dimension, cellphone, price, valoration,timezone));
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return hallInformation; // retonamos la lista de salones de eventos
    }

    // este metodo lo utilizara PublicateHallController para guardar nueva
    // informacion al modelo
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
