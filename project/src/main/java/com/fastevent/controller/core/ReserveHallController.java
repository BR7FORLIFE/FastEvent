package com.fastevent.controller.core;

import java.io.FileReader;

import com.fastevent.common.constants.PathConst;
import com.fastevent.common.simpleClasses.Hall;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

/**
 * @author BR7FORLIFE
 * 
 */

// esta clase es el controlador encargado de poder reservar un salon de eventos
// se utiliza en dos casos
// tanto como en el boton que aparece en cada salon de ventos como en la modal
// individual de cada uno
public class ReserveHallController {
    private static final PathConst pathConst = new PathConst();
    private static Hall hall; // <-- esto nos ayudara a obtener la informacion encapsulada del salon

    /**
     * 
     * @param index
     * @return
     * 
     *         habia un problema en si se encapsulan multiples salones en la clase
     *         Hall asi que la unica forma
     *         de acceder al que yo queria era a traves de un indice lo cual hice
     * 
     *         index <-- es el indice el cual voy a buscar la informacion del salon
     *         que yo quiero
     *         y retornamos dicha informacion
     */
    public static Hall getHallById(int index) {
        try (FileReader reader = new FileReader(pathConst.getPublicationJson())) { // leemos el json de las
                                                                                   // publicaciones
            Gson gson = new Gson(); // instanciamos gson
            JsonObject root = gson.fromJson(reader, JsonObject.class); // deserializamos el json
            JsonArray publications = root.get("publication").getAsJsonArray(); // en el root accedemos a su JsonArray
                                                                               // interno

            JsonObject selectHall = publications.get(index).getAsJsonObject(); // seleccionamos el objeto referente a la
                                                                               // informacion que necesito gracias al
                                                                               // indice

            // obtenemos la diferentes informacion del objeto actual
            String nameHall = selectHall.get("name").getAsString();
            String descriptionHall = selectHall.get("description").getAsString();
            String ubicationHall = selectHall.get("ubication").getAsString();
            int capacityHall = selectHall.get("capacity").getAsInt();
            int dimensionHall = selectHall.get("dimension").getAsInt();
            Long cellphoneHall = selectHall.get("cellphone").getAsLong();
            float priceOfHall = selectHall.get("price").getAsFloat();
            float valorationHall = selectHall.get("valoration").getAsFloat();
            String timezone = selectHall.get("timezone").getAsString();

            // creamos una nueva instancia de hall para ser retornada
            hall = new Hall(nameHall, descriptionHall, ubicationHall, capacityHall, dimensionHall, cellphoneHall,
                    priceOfHall, valorationHall, timezone);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return hall; // retornamos
    }
}
