package com.fastevent.controller.login;

import java.io.FileWriter;
import java.util.ArrayList;

import com.fastevent.common.constants.PathConst;
import com.fastevent.common.exceptions.Exceptions;
import com.fastevent.common.simpleClasses.Client;
import com.fastevent.components.NextFrame;
import com.fastevent.views.signInUp.LoginIU;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Control;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * @author BR7FORLIFE
 * 
 */

// esta clase nos permite registrar al usuario en el modelo siguiendo en el
// formulario
public class RegisterControler {
    private static PathConst pathConst = new PathConst(); // nos permite acceder a las constantes ya definidas

    // constructor vacio para poder instanciar la clase, no es necesario colocarla
    // pero es para que se vea vistoso
    private RegisterControler() {
    }

    @SuppressWarnings("unchecked") // esto nos permite asegurarnos que nos quite los warnings con los castings

    /**
     * este metodo nos permite establecer la informacion del usuario donde tenemos
     * dos parametros:
     * 
     * @param currentFrame <-- es el frame actual para poder destruirlo
     * @param informations <-- un VarArgs para obtener los diferentes datos del
     *                     formulario solo accediendo a su indice
     */
    public static void setInformationForClassUser(Stage currentFrame, Control... informations) {
        try {
            String name = ((TextField) informations[0]).getText();
            String lastName = ((TextField) informations[1]).getText();
            Integer age = ((Spinner<Integer>) informations[2]).getValue();
            String email = ((TextField) informations[3]).getText();
            String cellphone = ((TextField) informations[4]).getText();
            String gender = ((ChoiceBox<String>) informations[5]).getValue();
            String user = ((TextField) informations[6]).getText();
            String password = ((PasswordField) informations[7]).getText();
            String confirmPassword = ((PasswordField) informations[8]).getText();

            // hacemos las validaciones correspondientes por ejemplo que el correo tenga <@>
            if (!email.contains("@")) {
                throw new Exceptions.NotCorrectFormat();
            }

            Long.parseLong(cellphone);/* hacemos el parse a long si ocurre algun error irá al catch */

            // validamos que el campo contraseña sea igual al confirmar contraseña
            if (!password.equals(confirmPassword)) {
                throw new Exceptions.NotCorrectFormat();
            }

            // le pasamos los campos del formulario en la clase cliente gracias a su
            // constructor
            Client client = new Client(name, lastName, age, cellphone, gender, email);
            client.setUser(user); // establecemos usuario
            client.setPassword(password); // establecemos contraseña

            registerField(client); // es un metodo para poder agregar usuarios al modelo users.json

            // desactivamos todos los campos o TextField para que no pueda agregar o
            // modificar informacion
            for (Control nodes : informations) {
                nodes.setDisable(true);
            }

            // destruimos y pasamos al siguiente frame
            NextFrame.nextFrameDuration(currentFrame, LoginIU.class, 1);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // este metodo nos permite agregar el cliente al modelo Users.json

    /**
     * 
     * @param client <-- cliente que nos llega por parametro dentro tiene la
     *               informacion del cliente
     */
    private static void registerField(Client client) {
        try {
            ArrayList<Client> listOfUsers = new ArrayList<>(); // ArrayList para colocarlo en el JsonArray
            listOfUsers.add(client); // añadimos el cliente que nos viene por parametro

            // escribimos el contenido en el fichero con identaciones de json
            try (FileWriter writer = new FileWriter(pathConst.getUserJSon())) {
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
