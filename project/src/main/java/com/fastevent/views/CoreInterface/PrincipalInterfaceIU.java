package com.fastevent.views.CoreInterface;

import com.fastevent.common.constants.PathConst;
import com.fastevent.controller.core.SearchHallController;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class PrincipalInterfaceIU extends Application {
    private PathConst pathConst = new PathConst();

    @Override
    public void start(Stage principalInterfaceStage) {
        /* shapes */

        // rectangulo para el clip en el root contenedor y contenedor de imagen
        Rectangle rectangle = new Rectangle();
        rectangle.setWidth(1100);
        rectangle.setHeight(700);
        rectangle.setArcWidth(15);
        rectangle.setArcHeight(15);

        Image logo = new Image(pathConst.getLogoFastEvent());// imagen y su contenedor
        ImageView contentLogo = new ImageView(logo);

        // ajustes del contenedor de la imagen
        contentLogo.setFitWidth(300);
        contentLogo.setFitHeight(300);
        contentLogo.setPreserveRatio(true);

        // botones del aside
        Button searchHallOfEvent = new Button("Buscar Salón de eventos");
        Button postHallOfEvent = new Button("Publicar Salón de eventos");
        Button disponibilityOfHall = new Button("Eventos disponibles actualmente");
        Button nextHall = new Button("Eventos próximos a realizarse");

        // margenes entre los botones
        VBox.setMargin(searchHallOfEvent, new Insets(50, 0, 50, 0));
        VBox.setMargin(postHallOfEvent, new Insets(0, 0, 50, 0));
        VBox.setMargin(disponibilityOfHall, new Insets(0, 0, 50, 0));
        VBox.setMargin(nextHall, new Insets(0, 0, 0, 0));

        // estilos de los botones
        searchHallOfEvent.setMaxWidth(250);
        searchHallOfEvent.setMinHeight(40);

        postHallOfEvent.setMaxWidth(250);
        postHallOfEvent.setMinHeight(40);

        disponibilityOfHall.setMaxWidth(250);
        disponibilityOfHall.setMinHeight(40);

        nextHall.setMaxWidth(250);
        nextHall.setMinHeight(40);

        searchHallOfEvent.getStyleClass().add("button");
        postHallOfEvent.getStyleClass().add("button");
        disponibilityOfHall.getStyleClass().add("button");
        nextHall.getStyleClass().add("button");

        // contenedores hijos al stackpane
        VBox aside = new VBox();
        VBox main = new VBox();
        HBox root = new HBox(aside, main);

        // configuracion de los contenedores hijos
        aside.getChildren().addAll(contentLogo, searchHallOfEvent, postHallOfEvent, disponibilityOfHall, nextHall);
        aside.setMinSize(300, 700);
        aside.getStyleClass().add("aside");
        aside.setAlignment(Pos.TOP_CENTER);

        main.setMinSize(800, 700);
        main.getStyleClass().add("main");
        main.setAlignment(Pos.TOP_CENTER);

        root.setMaxSize(1100, 700);
        root.setClip(rectangle);
        root.getStyleClass().add("root-container");

        // contenedor base para apilar y su configuracion
        StackPane stackPane = new StackPane();
        stackPane.setMaxWidth(principalInterfaceStage.getWidth());
        stackPane.setMaxHeight(principalInterfaceStage.getHeight());
        stackPane.setAlignment(Pos.CENTER);
        stackPane.getChildren().add(root);
        stackPane.getStyleClass().add("stackpane");

        // eventos de los botones
        searchHallOfEvent.setOnAction(e -> {
            SearchHallController.getNodes();
            for (int hboxindex = 0; hboxindex < SearchHallController.getSizeVboxHallsList(); hboxindex++) {
                HBox node = (HBox) SearchHallController.getNodes().get(hboxindex);
                VBox.setMargin(node, new Insets(10, 0, 5, 0));
                main.getChildren().addAll(node);
            }
        });

        postHallOfEvent.setOnAction(e -> {
        });

        disponibilityOfHall.setOnAction(e -> {
        });

        nextHall.setOnAction(e -> {
        });

        // escena
        Scene scene = new Scene(stackPane);
        scene.getStylesheets().add(pathConst.getPrincipalInterfaceCSS());

        // configuracion del stage
        principalInterfaceStage.setTitle("Principal Interface - FastEvent");
        principalInterfaceStage.setResizable(false);
        principalInterfaceStage.setWidth(1200);
        principalInterfaceStage.setHeight(800);
        principalInterfaceStage.setScene(scene);
        principalInterfaceStage.show();
    }
}
