package com.fastevent.common.nextframe;

import javafx.animation.PauseTransition;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * @author BR7FORLIFE
 * 
 */

/**
 * esta clase me permite destruir un frame anterior e instanciar una nueva
 * ventana con las nuevas vistas
 */
public class NextFrame {

    /**
     * 
     * @param currentStage     // el es frame anterior que nos permite destruir y
     *                         seguir al siguiente
     * @param nextClass        //es una clase que hereda de Aplication para poder
     *                         crear una nueva instancia y moctrar el nuevo frame
     * @param timeToTransition // este es el tiempo transitorio o tiempo de la
     *                         transicion para cambiar de frame
     * 
     * 
     */
    public static void nextFrameDuration(Stage currentStage, Class<? extends Application> nextClass,
            int timeToTransition) {

        /**
         * este es una clase que nos permite hacer transisiones donde le pasamos como
         * parametro la duracion
         * de la transición
         * 
         * cabe recalcar que Duration es una clase de java util para cuestiones de
         * tiempo en segundos,
         * milisegundos etc etc
         */
        PauseTransition transition = new PauseTransition(Duration.seconds(timeToTransition));

        /**
         * este es el evento de la transicion donde cerramos el frame anterior , crea
         * una nueva instancia de
         * la siguiente clase que herede de Aplication, ademas inicializamos el nuevo
         * frame!
         */
        transition.setOnFinished(event -> {
            try {
                currentStage.close();
                Application nextFrame = nextClass.getDeclaredConstructor().newInstance();
                Stage newStage = new Stage();

                nextFrame.start(newStage);

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        });
        transition.play();
    }
}
