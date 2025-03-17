package com.fastevent.views.components;

import javafx.animation.PauseTransition;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.util.Duration;

public class nextFrame {
    public static void nextFrameDuration(Stage currentStage, Class<? extends Application> nextClass, int timeToTransition){
        PauseTransition transition = new PauseTransition(Duration.seconds(timeToTransition));
        transition.setOnFinished(event ->{
            try {
                currentStage.close();
                Application nextFrame =  nextClass.getDeclaredConstructor().newInstance();
                Stage newStage = new Stage();
    
                nextFrame.start(newStage);
    
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        });
        transition.play();
    }
}
