package com.fastevent.controller.core;

import java.io.FileReader;
import java.io.FileWriter;

import com.fastevent.common.constants.PathConst;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import javafx.scene.control.TextField;

/** @author BR7FORLIFE */

// esta es la clase que nos permite publicar un nuevo salon de eventos para ser
// rentado
public class PublicateHallController {
    private static final PathConst pathConst = new PathConst();

    /**
     * 
     * @param infoToHall <-- este VarArgs nos permite recuperar los diferentes
     *                   TextField y recuperar
     *                   la informacion que ha digitado el usuario. solo eso
     *                   recupera y guarda en Strings , int, long y float
     */
    public static void comprobateInformation(TextField... infoToHall) {
        try {
            String nameOfHall = infoToHall[0].getText();
            String descriptionOfHall = infoToHall[1].getText();
            String ubicationOfHall = infoToHall[2].getText();
            int capacityOfHall = Integer.parseInt(infoToHall[3].getText());
            int dimensionOfHall = Integer.parseInt(infoToHall[4].getText());
            long cellphone = Long.parseLong(infoToHall[5].getText());
            float priceOfHall = Float.parseFloat(infoToHall[6].getText());

            for (TextField field : infoToHall) { // desactivamos todos los TextField para evitar y errores
                field.setDisable(true);
            }

            saveHall(nameOfHall, descriptionOfHall, ubicationOfHall, capacityOfHall, dimensionOfHall, cellphone,
                    priceOfHall); // aca le pasamos los diferentes Strings al metodo saveHall

            System.out.println("Salón agregado exitosamente!");

        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * 
     * @param informationTohall <-- este VarArgs son los diferentes tipos de datos
     *                          que nos llegan para
     *                          poder validarlos y guardarlo en el modelo
     *                          Publication.json
     */
    private static void saveHall(Object... informationTohall) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create(); // identaciones y formateo del json
        JsonArray publicationArray = new JsonArray(); // creamos unu nuevo jsonArray para las publicaciones de los
                                                      // salones
        JsonObject root = new JsonObject(); // este es el root el objeto el cual en su interior tiene el jsonArray()

        try (FileReader reader = new FileReader(pathConst.getPublicationJson())) {// leemos el json
            root = gson.fromJson(reader, JsonObject.class); // deserializamos el json a JsonObject
            publicationArray = root.getAsJsonArray("publication"); // accedemos a la key publication del jsonArray()
            System.out.println(publicationArray); // imprimimos el jsonArray para ver su contenido o si se guardo!
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // creamos desde 0 una nueva publicacion para añadirlo al jsonArray()
        JsonObject newPublication = new JsonObject();

        // diferentes pares key - value donde la key es los distintos atributos que
        // puede tener un salon de eventos y el value son los diferentes valores que nos
        // llegan como argumento
        newPublication.addProperty("name", (String) informationTohall[0]);
        newPublication.addProperty("description", (String) informationTohall[1]);
        newPublication.addProperty("ubication", (String) informationTohall[2]);
        newPublication.addProperty("capacity", (int) informationTohall[3]);
        newPublication.addProperty("dimension", (int) informationTohall[4]);
        newPublication.addProperty("cellphone", (long) informationTohall[5]);
        newPublication.addProperty("price", (float) informationTohall[6]);
        newPublication.addProperty("valoration", Math.random() * 6.0);
        newPublication.addProperty("timezone", "");

        // añadimos el nuevo jsonObject al JsonArray() donde el primer elemento de dicho
        // array es el primer objeto escrito en el Publication.Json
        publicationArray.add(newPublication);

        // añadimos el JsonArray al root osea al objeto padre
        root.add("publication", publicationArray);

        try (FileWriter writer = new FileWriter(pathConst.getPublicationJson())) {// modo append mas no de
                                                                                  // sobreescritura
            gson.toJson(root, writer); // escribimos en el json el nuevo root escrito
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
