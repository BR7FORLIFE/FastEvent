package com.fastevent.views.CoreInterface;

import com.fastevent.common.constants.PathConst;
import com.fastevent.common.simpleClasses.Hall;
import com.fastevent.components.ResetStyleButtons;
import com.fastevent.controller.core.ReserveHallController;
import com.fastevent.views.modals.ReserveHallModalIU;

import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

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
        Button publicationOfHall = new Button("Publicar Salón de eventos");
        Button disponibilityOfHall = new Button("Eventos disponibles actualmente");
        Button nextHall = new Button("Eventos próximos a realizarse");

        // margenes entre los botones
        VBox.setMargin(searchHallOfEvent, new Insets(50, 0, 50, 0));
        VBox.setMargin(publicationOfHall, new Insets(0, 0, 50, 0));
        VBox.setMargin(disponibilityOfHall, new Insets(0, 0, 50, 0));
        VBox.setMargin(nextHall, new Insets(0, 0, 0, 0));

        // estilos de los botones
        searchHallOfEvent.setMaxWidth(250);
        searchHallOfEvent.setMinHeight(40);

        publicationOfHall.setMaxWidth(250);
        publicationOfHall.setMinHeight(40);

        disponibilityOfHall.setMaxWidth(250);
        disponibilityOfHall.setMinHeight(40);

        nextHall.setMaxWidth(250);
        nextHall.setMinHeight(40);

        searchHallOfEvent.getStyleClass().add("button-desactive");
        publicationOfHall.getStyleClass().add("button-desactive");
        disponibilityOfHall.getStyleClass().add("button-desactive");
        nextHall.getStyleClass().add("button-desactive");

        // contenedores hijos al stackpane
        VBox aside = new VBox();
        VBox main = new VBox();
        //ScrollPane scrollPane = new ScrollPane();
        HBox root = new HBox(aside, main);

        // configuracion de los contenedores hijos
        aside.getChildren().addAll(contentLogo, searchHallOfEvent, publicationOfHall, disponibilityOfHall, nextHall);
        aside.setMinSize(300, 700);
        aside.getStyleClass().add("aside");
        aside.setAlignment(Pos.TOP_CENTER);

        main.setMinSize(800, 700);
        main.getStyleClass().add("main");

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
            main.setAlignment(Pos.TOP_CENTER);
            ResetStyleButtons.reset(publicationOfHall, disponibilityOfHall, nextHall); // reseteamos los estilos
            main.getChildren().clear(); // limpiamos los nodos anteriores que tuvo el main container
            ReserveHallIU.getNodes(); // obtenemos la lista de nodos para mostrar en el campo
            searchHallOfEvent.getStyleClass().remove("button-desactive"); // removemos el estilo desactive
            searchHallOfEvent.getStyleClass().add("button-active");

            // iteramos por cada nodo devuelto por getNodes()
            for (int hboxindex = 0; hboxindex < ReserveHallIU.getSizeVboxHallsList(); hboxindex++) {
                // obtenemos cada contenedor de Search publication
                HBox container = (HBox) ReserveHallIU.getNodes().get(hboxindex);
                container.setOpacity(0); // ponemos la opacidad en 0

                // accedemos al primer hijo de cada container que es el GridPane
                GridPane childrenGrid = (GridPane) container.getChildren().get(0);
                Button selectHall = null; // guardamos el estado de l boton ver si se encuentra o no

                /*
                 * como todos los botones, textfield, label heredan de un mismo padre
                 * y no sabemos si el hijo que tipo de nodo sea recorremos cada hijo de
                 * la grilla usando un estilo de objeto mas global que es el Node porque
                 * de el heredan todos los subnodos cuando se encuentre un instancia de
                 * Button me lo guarda en el estado que se creo anteriormente
                 * (Button selectHall = null;)
                 */
                for (Node child : childrenGrid.getChildren()) {
                    if (child instanceof Button) {
                        selectHall = (Button) child;
                        break;
                    }
                }

                // si se encontro un boton le asignamos un evento y listo todo depende
                // del controlador xd
                if (selectHall != null) {
                    final int state = hboxindex;
                    selectHall.setOnAction(event -> {
                        Hall hall = ReserveHallController.getHallById(state);
                        ReserveHallModalIU.modal(principalInterfaceStage, hall);
                    });
                }

                // aplicamos una transicion de FadeTransition
                FadeTransition fadeTransition = new FadeTransition(Duration.seconds(0.5), container);
                fadeTransition.setFromValue(0.0);
                fadeTransition.setToValue(1.0);
                fadeTransition.setDelay(Duration.seconds(hboxindex * 0.2));

                // damos pargen y añadimos al main container
                VBox.setMargin(container, new Insets(10, 0, 5, 0));
                main.getChildren().addAll(container);
                fadeTransition.play();
            }
        });

        publicationOfHall.setOnAction(e -> {
            main.setAlignment(Pos.CENTER);
            ResetStyleButtons.reset(searchHallOfEvent, disponibilityOfHall, nextHall);// reseteamos los botones
            publicationOfHall.getStyleClass().remove("button-desactive"); // removemos la clase desactive
            publicationOfHall.getStyleClass().add("button-active");
            HBox node = PublicationOfHallIU.publicateHall(); // guardamos en una variable en contenedor que nos llega
            node.setAlignment(Pos.CENTER); // alineamos el contenido al centro

            // animacion de fade
            FadeTransition fadeTransition = new FadeTransition(Duration.seconds(0.5));
            fadeTransition.setNode(node);
            fadeTransition.setCycleCount(1);
            fadeTransition.setFromValue(0);
            fadeTransition.setToValue(1);
            fadeTransition.play();

            main.getChildren().clear(); // limpiamos los nodos anteriores
            main.getChildren().add(node); // añadimos el nuevo nodo
        });

        disponibilityOfHall.setOnAction(e -> {
            main.setAlignment(Pos.CENTER);
            ResetStyleButtons.reset(publicationOfHall, searchHallOfEvent, nextHall);// reseteamos los estilos
            disponibilityOfHall.getStyleClass().remove("button-desactive"); // desactivamos la clase css
            disponibilityOfHall.getStyleClass().add("button-active");
            main.getChildren().clear();
            HBox node = DisponibilityOfEvent.disponibilityOfHall();

            FadeTransition fadeTransition = new FadeTransition(Duration.seconds(0.5));
            fadeTransition.setFromValue(0);
            fadeTransition.setToValue(1);
            fadeTransition.setNode(node);
            fadeTransition.play();

            main.getChildren().add(node); // mostramos el nodo en el container
        });

        nextHall.setOnAction(e -> {
            main.setAlignment(Pos.CENTER);
            ResetStyleButtons.reset(publicationOfHall, disponibilityOfHall, searchHallOfEvent); // reseteamos css
            nextHall.getStyleClass().remove("button-desactive"); // desactivamos la clase css
            nextHall.getStyleClass().add("button-active");
            main.getChildren().clear();
            for (HBox node : UpcomingEventIU.upcomingEvent()) { // aplicamos margen y añadimos los distintos nodos
                VBox.setMargin(node, new Insets(10, 5, 10, 0));
                FadeTransition fadeTransition = new FadeTransition(Duration.seconds(1));
                fadeTransition.setFromValue(0);
                fadeTransition.setToValue(1);
                fadeTransition.setNode(node);
                fadeTransition.play();
                main.getChildren().addAll(node);
            }
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
