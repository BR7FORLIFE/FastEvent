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
import javafx.scene.control.ScrollPane;
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
        Rectangle rectangle = new Rectangle();
        rectangle.setWidth(1100);
        rectangle.setHeight(700);
        rectangle.setArcWidth(15);
        rectangle.setArcHeight(15);

        Image logo = new Image(pathConst.getLogoFastEvent());
        ImageView contentLogo = new ImageView(logo);

        contentLogo.setFitWidth(300);
        contentLogo.setFitHeight(300);
        contentLogo.setPreserveRatio(true);

        Button searchHallOfEvent = new Button("Reservar Salón de eventos");
        Button publicationOfHall = new Button("Publicar Salón de eventos");
        Button disponibilityOfHall = new Button("Eventos disponibles actualmente");
        Button nextHall = new Button("Eventos próximos a realizarse");
        Button favoritesHall = new Button("Favoritos");

        VBox.setMargin(searchHallOfEvent, new Insets(0, 0, 50, 0));
        VBox.setMargin(publicationOfHall, new Insets(0, 0, 50, 0));
        VBox.setMargin(disponibilityOfHall, new Insets(0, 0, 50, 0));
        VBox.setMargin(nextHall, new Insets(0, 0, 50, 0));
        VBox.setMargin(favoritesHall, new Insets(0, 0, 50, 0));

        for (Button button : new Button[] {
                searchHallOfEvent, publicationOfHall, disponibilityOfHall, nextHall, favoritesHall
        }) {
            button.setMaxWidth(250);
            button.setMinHeight(40);
            button.getStyleClass().add("button-desactive");
        }

        VBox aside = new VBox();
        VBox main = new VBox();
        ScrollPane scrollPane = new ScrollPane();
        HBox root = new HBox(aside, scrollPane);

        aside.getChildren().addAll(contentLogo, searchHallOfEvent, publicationOfHall, disponibilityOfHall, nextHall,
                favoritesHall);
        aside.setMinSize(300, 700);
        aside.getStyleClass().add("aside");
        aside.setAlignment(Pos.TOP_CENTER);

        main.setMinSize(800, 700);
        main.getStyleClass().add("main");

        scrollPane.setContent(main);
        scrollPane.setFitToWidth(true);
        scrollPane.setPrefSize(800, 700);
        scrollPane.setStyle("-fx-background: transparent;");

        root.setMaxSize(1100, 700);
        root.setClip(rectangle);
        root.getStyleClass().add("root-container");

        StackPane stackPane = new StackPane();
        stackPane.setMaxWidth(principalInterfaceStage.getWidth());
        stackPane.setMaxHeight(principalInterfaceStage.getHeight());
        stackPane.setAlignment(Pos.CENTER);
        stackPane.getChildren().add(root);
        stackPane.getStyleClass().add("stackpane");

        searchHallOfEvent.setOnAction(e -> {
            main.setAlignment(Pos.TOP_CENTER);
            ResetStyleButtons.reset(publicationOfHall, disponibilityOfHall, nextHall,favoritesHall);
            main.getChildren().clear();
            ReserveHallIU.getNodes();
            searchHallOfEvent.getStyleClass().remove("button-desactive");
            searchHallOfEvent.getStyleClass().add("button-active");

            for (int hboxindex = 0; hboxindex < ReserveHallIU.getSizeVboxHallsList(); hboxindex++) {
                HBox container = (HBox) ReserveHallIU.getNodes().get(hboxindex);
                container.setOpacity(0);
                GridPane childrenGrid = (GridPane) container.getChildren().get(0);
                Button selectHall = null;

                for (Node child : childrenGrid.getChildren()) {
                    if (child instanceof Button) {
                        selectHall = (Button) child;
                        break;
                    }
                }

                if (selectHall != null) {
                    final int state = hboxindex;
                    selectHall.setOnAction(event -> {
                        Hall hall = ReserveHallController.getHallById(state);
                        ReserveHallModalIU.modal(principalInterfaceStage, hall, container);
                    });
                }

                FadeTransition fadeTransition = new FadeTransition(Duration.seconds(0.5), container);
                fadeTransition.setFromValue(0.0);
                fadeTransition.setToValue(1.0);
                fadeTransition.setDelay(Duration.seconds(hboxindex * 0.2));

                VBox.setMargin(container, new Insets(10, 0, 5, 0));
                main.getChildren().addAll(container);
                fadeTransition.play();
            }
        });

        publicationOfHall.setOnAction(e -> {
            main.setAlignment(Pos.CENTER);
            ResetStyleButtons.reset(searchHallOfEvent, disponibilityOfHall, nextHall, favoritesHall);
            publicationOfHall.getStyleClass().remove("button-desactive");
            publicationOfHall.getStyleClass().add("button-active");
            HBox node = PublicationOfHallIU.publicateHall();
            node.setAlignment(Pos.CENTER);

            FadeTransition fadeTransition = new FadeTransition(Duration.seconds(0.5));
            fadeTransition.setNode(node);
            fadeTransition.setCycleCount(1);
            fadeTransition.setFromValue(0);
            fadeTransition.setToValue(1);
            fadeTransition.play();

            main.getChildren().clear();
            main.getChildren().add(node);
        });

        disponibilityOfHall.setOnAction(e -> {
            main.setAlignment(Pos.CENTER);
            ResetStyleButtons.reset(publicationOfHall, searchHallOfEvent, nextHall, favoritesHall);
            disponibilityOfHall.getStyleClass().remove("button-desactive");
            disponibilityOfHall.getStyleClass().add("button-active");
            main.getChildren().clear();
            HBox node = DisponibilityOfEvent.disponibilityOfHall();

            FadeTransition fadeTransition = new FadeTransition(Duration.seconds(0.5));
            fadeTransition.setFromValue(0);
            fadeTransition.setToValue(1);
            fadeTransition.setNode(node);
            fadeTransition.play();

            main.getChildren().add(node);
        });

        nextHall.setOnAction(e -> {
            main.setAlignment(Pos.CENTER);
            ResetStyleButtons.reset(publicationOfHall, disponibilityOfHall, searchHallOfEvent, favoritesHall);
            nextHall.getStyleClass().remove("button-desactive");
            nextHall.getStyleClass().add("button-active");
            main.getChildren().clear();
            for (HBox node : UpcomingEventIU.upcomingEvent()) {
                VBox.setMargin(node, new Insets(5, 5, 10, 0));
                FadeTransition fadeTransition = new FadeTransition(Duration.seconds(1));
                fadeTransition.setFromValue(0);
                fadeTransition.setToValue(1);
                fadeTransition.setNode(node);
                fadeTransition.play();
                main.getChildren().addAll(node);
            }
        });

        favoritesHall.setOnAction(e ->{
            main.setAlignment(Pos.TOP_CENTER);
            ResetStyleButtons.reset(publicationOfHall, disponibilityOfHall, nextHall,searchHallOfEvent);
            favoritesHall.getStyleClass().remove("button-desactive");
            favoritesHall.getStyleClass().add("button-active");
            main.getChildren().clear();

            for (int hboxindex = 0; hboxindex < FavoritesOfHallIU.getSizeFavoritesHalls(); hboxindex++) {
                HBox container = (HBox) FavoritesOfHallIU.hallsContainersFavorites().get(hboxindex);
                container.setOpacity(0);
                GridPane childrenGrid = (GridPane) container.getChildren().get(0);
                Button removeToFavorites = null;

                int secondButton = 1; //esto es una bandera para yo poder recuperar el segundo botón

                for (Node child : childrenGrid.getChildren()) {
                    if (child instanceof Button) {
                        secondButton++;

                        if (secondButton == 2) {
                            removeToFavorites = (Button) child;
                            break;
                        }
                    }
                }

                if (removeToFavorites != null) {
                    final int state = hboxindex;
                    removeToFavorites.setOnAction(event -> {
                        System.out.println("Ha sido presionado el boton de eliminar de favoritos");
                    });
                }

                FadeTransition fadeTransition = new FadeTransition(Duration.seconds(0.5), container);
                fadeTransition.setFromValue(0.0);
                fadeTransition.setToValue(1.0);
                fadeTransition.setDelay(Duration.seconds(hboxindex * 0.2));

                VBox.setMargin(container, new Insets(10, 0, 5, 0));
                main.getChildren().addAll(container);
                fadeTransition.play();
            }
        });

        Scene scene = new Scene(stackPane);
        scene.getStylesheets().add(pathConst.getPrincipalInterfaceCSS());

        principalInterfaceStage.setTitle("Principal Interface - FastEvent");
        principalInterfaceStage.setResizable(false);
        principalInterfaceStage.setWidth(1200);
        principalInterfaceStage.setHeight(800);
        principalInterfaceStage.setScene(scene);
        principalInterfaceStage.show();
    }
}
