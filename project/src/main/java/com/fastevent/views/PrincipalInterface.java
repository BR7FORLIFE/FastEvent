package com.fastevent.views;

import com.fastevent.views.components.CssRoutes;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PrincipalInterface extends Application{
    public void start(Stage principalStage){
        //ruta css para el PrincipalInterface
        CssRoutes cssRoutes = new CssRoutes();

        //nodos de la aplicación
        TextField search = new TextField();
        search.setPromptText("Search");

        //layout de la aplicación
        VBox leftAside = new VBox();
        HBox headerImage = new HBox();
        HBox headerSearch = new HBox(search);
        ScrollPane mainPublications = new ScrollPane();
        VBox ScrollPublications = new VBox();

        //alineamiento de los nodos en el contenedor headerSearch y padding de los nodos
        headerSearch.setAlignment(Pos.CENTER);
       
        GridPane gridContent = new GridPane();
        GridPane.setColumnSpan(headerSearch, 2);

        gridContent.add(headerImage, 0, 0);
        gridContent.add(headerSearch, 1, 0);
        gridContent.add(leftAside, 0, 1);
        gridContent.add(mainPublications, 1, 1);

        Scene scene = new Scene(gridContent,1200,800);
        scene.getStylesheets().add(cssRoutes.PrincipalInterface);

        //tamaños de los contenedores
        leftAside.setMinWidth(200);
        mainPublications.setMinWidth(1000);
        headerSearch.setMinWidth(800);
        headerImage.setMinWidth(400);

        leftAside.setMinHeight(700);
        mainPublications.setMinHeight(700);
        headerSearch.setMinHeight(100);
        headerImage.setMinHeight(100);

        //estilos de los diferentes contenedores
        leftAside.getStyleClass().add("leftAside");
        headerSearch.getStyleClass().add("header");
        ScrollPublications.getStyleClass().add("scrollPublication");

        //estilos de los nodos
        headerImage.getStyleClass().add("headerImage");

        //mostramos el stage con la scena
        principalStage.setScene(scene);
        principalStage.setResizable(false);
        principalStage.setTitle("Principal-Stage!");
        principalStage.show();
    }
}
