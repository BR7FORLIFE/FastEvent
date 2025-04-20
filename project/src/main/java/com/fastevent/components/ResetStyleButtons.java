package com.fastevent.components;

import javafx.scene.control.Control;

/**
 * @author BR7FORLIFE
 * 
 */


/*  esta clase nos permite resetear los estilos de los botones cambiandoles el estilo de active a desactive 
 *  esto nos ayuda a saber por que opcion va el usuario haciendolo mas intuitivo!
*/
public class ResetStyleButtons {
    public static void reset(Control... controls) {
        for (Control control : controls) {
            control.getStyleClass().remove("button-active");
            if (!control.getStyleClass().contains("button-desactive")) {
                control.getStyleClass().add("button-desactive");
            }
        }
    }
}
