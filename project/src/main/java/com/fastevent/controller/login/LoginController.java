package com.fastevent.controller.login;

import java.io.FileReader;

import com.fastevent.common.constants.PathConst;
import com.fastevent.components.NextFrame;
import com.fastevent.views.CoreInterface.PrincipalInterfaceIU;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import javafx.scene.control.Control;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * @author BR7FORLIFE
 * 
 */


/* esta clase nos permite iniciar sesion al usuario con su nameUser y password previamente */
public class LoginController {
    private static PathConst pathConst = new PathConst();
    private static String userField;
    private static String passwordField;

    /**
     * este metodo nos permite recuperar tanto el nombre de usuario y contraseña de un VarArgs
     * 
     * VarArgs = numero arbitrarios de argumentos 
     * 
     * @param currentFrame // frame actual o anterior que nos permite destruir y ejecutar el siguiente
     * @param fields  // numero arbitrarios de nodos que vienen del paquete javafx.scene.control.Control
     */
    public static void credentials(Stage currentFrame,Control... fields) {
        String username = ((TextField) fields[0]).getText();
        String password = ((TextField) fields[1]).getText();

        ClientLogin(currentFrame,username, password);
    }

    /** este metodo nos permite registrar el usuario en el modelo  
     * 
     * se coloca de manera privada para que ninguna clase pueda acceder a ella de manera arbitraraia
    */
    private static void ClientLogin(Stage currenFrame,String user, String password) {

        try (FileReader reader = new FileReader(pathConst.getUserJSon())) {
            Gson gson = new Gson();
            JsonObject root = gson.fromJson(reader, JsonObject.class);

            JsonArray users = root.get("users:").getAsJsonArray();

            for (int i = 0; i < users.size(); i++) {
                JsonObject information = users.get(i).getAsJsonObject();
                userField = information.get("user").getAsString();
                passwordField = information.get("password").getAsString();
            }

            if (userField.equals(user) && passwordField.equals(password)) {
                System.out.println("Sesion iniciada con exito!");
                NextFrame.nextFrameDuration(currenFrame, PrincipalInterfaceIU.class, 2);
            } else {
                System.out.println("usuario incorrecto!");
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
