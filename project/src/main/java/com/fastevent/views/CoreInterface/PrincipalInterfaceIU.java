package com.fastevent.views.CoreInterface;

import com.fastevent.common.constants.PathConst;
import com.fastevent.common.simpleClasses.Hall;
import com.fastevent.components.NextFrame;
import com.fastevent.components.ResetStyleButtons;
import com.fastevent.controller.core.ReserveHallController;
import com.fastevent.views.modals.ReserveHallModalIU;
import com.fastevent.views.signInUp.LoginIU;

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

/**
 * @author BR7FORLIFE
 * 
 */

// esta es la raiz de todo el proyecto aca vemos la interfaz principales y los
// distintos botones
// y disparadores, botones como son reservar, publicar, eventos proximos,
// eventos actuales y favoritos
public class PrincipalInterfaceIU extends Application {
    private final PathConst pathConst = new PathConst();

    @Override
    public void start(Stage principalInterfaceStage) {
        Rectangle rectangle = new Rectangle(); // creamos un rectangulo esto sera util para algún clip
        rectangle.setWidth(1100); // definimos ancho del rectangulo
        rectangle.setHeight(700); // definimos el alto del rectangulo
        rectangle.setArcWidth(15); // definimos el ancho del arco que se traduce como border radius
        rectangle.setArcHeight(15); // definimos el alto del arco

        Image logo = new Image(pathConst.getLogoFastEvent()); // esta es una clase que nos permite adjuntar imagenes en
                                                              // un solo contenedor
        ImageView contentLogo = new ImageView(logo); // este es el contenedor correspondiente para las imagenes

        contentLogo.setFitWidth(300); // esto es para redimensionar el ancho de la imagen
        contentLogo.setFitHeight(300); // esto es para redimensionar el alto de la imagen
        contentLogo.setPreserveRatio(true); // mantenemos la relacion de aspecto o el aspect ratio

        // estos son los diferentes botones que se muestran en el aside izquierdo
        Button searchHallOfEvent = new Button("Reservar Salón de eventos"); // boton para buscar salones
        Button publicationOfHall = new Button("Publicar Salón de eventos"); // boton para publicar salones
        Button disponibilityOfHall = new Button("Eventos disponibles actualmente");// boton para los eventos disponibles
                                                                                   // actualmente
        Button nextHall = new Button("Eventos próximos a realizarse"); // boton para los eventos proximos a realizarse
        Button favoritesHall = new Button("Favoritos"); // boton de favoritos

        Button closeSesion = new Button("Cerrar Sesión!");// boton para cerrar sesión
        // estos son los diferentes margenes para los distintos botones
        for (Node node : new Node[] {
                searchHallOfEvent, publicationOfHall, disponibilityOfHall, nextHall, favoritesHall, closeSesion
        }) {
            VBox.setMargin(node, new Insets(0, 0, 35, 0));
        }

        // esto es una espeche de for-each donde para cada boton le aplicamos los
        // siguientes metodos:
        for (Button button : new Button[] {
                searchHallOfEvent, publicationOfHall, disponibilityOfHall, nextHall, favoritesHall, closeSesion
        }) {
            button.setMaxWidth(250); // ancho maximo de los botones
            button.setMinHeight(40); // altura maxima de los botones
            button.getStyleClass().add("button-desactive"); // desactivamos por defecto los estilos de los botones

            // esto nos permite mostrar los botones del mismo tamaño y estilos
        }

        // parte de los contenedores

        /**
         * el maquetado para el principal Interface IU es la siguiente:
         * 
         * aside <- el contenedor que muestra los botones y el logo a la izquierda del
         * todo
         * main <- donde se renderiza la logica de los botones
         * scrollpane <- contenedor que nos permite hacer scroll sobre las distintas
         * publicaciones
         * root <- contenedor principal de toda la interfaz donde estan los contenedores
         * anteriores
         * 
         */
        VBox aside = new VBox();
        VBox main = new VBox();
        ScrollPane scrollPane = new ScrollPane();
        HBox root = new HBox(aside, scrollPane);

        // añadimos los hijos o los notos al aside en este caso los botones
        aside.getChildren().addAll(contentLogo, searchHallOfEvent, publicationOfHall, disponibilityOfHall, nextHall,
                favoritesHall, closeSesion);
        aside.setMinSize(300, 700); // definimos ancho y alto minimo para el aside
        aside.getStyleClass().add("aside"); // la estilamos con la clase CSS correspondiente
        aside.setAlignment(Pos.TOP_CENTER); // le damos una alineacion arriba del todo

        main.setMinSize(800, 700); // definimos ancho y alto minimo del contenedor padre que tiene a todos los
                                   // demas contenedores como sus hijos
        main.getStyleClass().add("main"); // añadimos su respectiva clase CSS

        scrollPane.setContent(main); // le decimos que el contenedor al cual le vas aplicar el scroll sea el main
        scrollPane.setFitToWidth(true); // ajustamos el ancho automaticamente con el main
        scrollPane.setPrefSize(800, 700); // ajustamos el ancho y alto del scrollPane
        scrollPane.setStyle("-fx-background: transparent;"); // aplicamos un estilo CSS para que se haga transparente

        root.setMaxSize(1100, 700); // definimos el ancho y alto maximo del root el cual es toda la ventana
        root.setClip(rectangle); // añadimos el rectangulo como clip
        root.getStyleClass().add("root-container"); // le aplicamos su respectiva clase CSS

        StackPane stackPane = new StackPane(); // este es un contenedor de apilamiento
        stackPane.setMaxWidth(principalInterfaceStage.getWidth()); // definimos el ancho maximo de dicho stackpane el
                                                                   // cual es el ancho del stage completo
        stackPane.setMaxHeight(principalInterfaceStage.getHeight()); // definimos el alto maximo del stackpane el cual
                                                                     // es el alto del stage completo
        stackPane.setAlignment(Pos.CENTER); // alineamos los contenedores o nodos al centro
        stackPane.getChildren().add(root);// añadimos el root al stackpane
        stackPane.getStyleClass().add("stackpane"); // le aplicamos su respectiva clase CSS

        /**
         * EVENT HANDLES o DISPARADORES
         * 
         * aca vemos las diferentes logicas para los distintos botones
         */

        searchHallOfEvent.setOnAction(e -> {

            Runnable refreshIU = () -> {
                favoritesLayoutAndLogic(main, favoritesHall, publicationOfHall, disponibilityOfHall, nextHall,
                        searchHallOfEvent);
            };

            // definimos el evento para el boton de buscar
            main.setAlignment(Pos.TOP_CENTER);// alineamos los elementos del main en lo alto del todo

            // reseteamos estilos CSS
            ResetStyleButtons.reset(publicationOfHall, disponibilityOfHall, nextHall, favoritesHall);
            main.getChildren().clear(); // limpiamos el main para que el contenedor este vacio
            ReserveHallIU.getNodes(); // obtenemos el ArrayList de HBOX o de los diferentes salones
            searchHallOfEvent.getStyleClass().remove("button-desactive"); // le removemos la clase por defecto CSS
            searchHallOfEvent.getStyleClass().add("button-active"); // y le aplicamos la clase CSS el cual es el estado
                                                                    // activo

            // iteramos el ARRAYLIST de HBOX osea de las distintos salones en el json
            for (int hboxindex = 0; hboxindex < ReserveHallIU.getSizeVboxHallsList(); hboxindex++) {
                HBox container = (HBox) ReserveHallIU.getNodes().get(hboxindex); // de cada uno de los contenedores
                                                                                 // horizontales recuperamos cada uno de
                                                                                 // ellos gracias al indice y hacemos su
                                                                                 // respectivo casting para que java
                                                                                 // sepa que nos esta llegando son HBox
                container.setOpacity(0); // establecemos la opacidad de cada contenedor a 0 ya vera pq

                /**
                 * dentro del contenedor HBox tiene dentro sus respectivos contenedores es como
                 * una familia de arboles donde esta el container como padre y sus hijos el
                 * GridPane y otro contenedor.
                 */
                GridPane childrenGrid = (GridPane) container.getChildren().get(0);
                Button selectHall = null; // esto es para poder obtener el boton en este caso el reservar salon

                for (Node child : childrenGrid.getChildren()) { // como no sabemos que tipo de nodo estamos iterando lo
                                                                // que hacemos es iterar por la clase padre el cual
                                                                // heredan todos los nodos
                    if (child instanceof Button button) { // aca verificamos que si uno de los nodos es un boton
                                                          // igualamos con la variable que creamos anteriormente
                        selectHall = button;
                        break; // rompemos el bucle
                    }
                }

                // si hay un boton lo que hacemos es recuperar e indice para saber que boton se
                // presionó
                if (selectHall != null) {
                    final int stateIndex = hboxindex;
                    selectHall.setOnAction(event -> {
                        /*
                         * utilizamos el metodo reserveHallController para obtener la informacion
                         * encapsulada del salon actual
                         */
                        Hall hall = ReserveHallController.getHallById(stateIndex);

                        /* le pasamos los diferentes parametros a la modal */
                        ReserveHallModalIU.modal(principalInterfaceStage, hall, container, stateIndex, refreshIU);
                    });
                }
                // aplicamos un efecto de fadeTransition con una duracion de 0.5 y el contedor
                // el cual queremos aplicarle
                FadeTransition fadeTransition = new FadeTransition(Duration.seconds(0.5), container);
                fadeTransition.setFromValue(0.0); // empezamos invisible
                fadeTransition.setToValue(1.0); // hacemos la transicion de aparcicion

                /* aca le aplicamos un efecto de cascada o de fade para cada contenedor */
                fadeTransition.setDelay(Duration.seconds(hboxindex * 0.2));

                // aplicamos margenes aca contendor de aparicion
                VBox.setMargin(container, new Insets(10, 0, 5, 0));
                main.getChildren().addAll(container); // añadimos el contenedor HBox al mani
                fadeTransition.play(); // empezamos la transicion
            }
        });

        publicationOfHall.setOnAction(e -> {
            main.setAlignment(Pos.CENTER); // alineamos los elementos del main en lo alto del todo

            //// reseteamos estilos CSS
            ResetStyleButtons.reset(searchHallOfEvent, disponibilityOfHall, nextHall, favoritesHall);
            publicationOfHall.getStyleClass().remove("button-desactive");// le removemos la clase por defecto CSS
            publicationOfHall.getStyleClass().add("button-active");// y le aplicamos la clase CSS el cual es el estado

            // este es el formulario que sirve para publicar un salon
            HBox node = PublicationOfHallIU.publicateHall();
            node.setAlignment(Pos.CENTER); // alineamos todo el formualrio al centro

            /* aca le aplicamos un efecto de cascada o de fade para cada contenedor */
            FadeTransition fadeTransition = new FadeTransition(Duration.seconds(0.5));
            fadeTransition.setNode(node); // definimos el nodo al cual le aplicamos el efecto
            fadeTransition.setCycleCount(1); // lo aplica una sola vez
            fadeTransition.setFromValue(0);// empezamos invisible
            fadeTransition.setToValue(1);// hacemos la transicion de aparcicion
            fadeTransition.play();// empezamos la transicion

            main.getChildren().clear(); // limpiamos el main para que quede vacio

            // añadimos el nuevo nodo al main en este caso el formulario
            main.getChildren().add(node);
        });

        // boton para mostrar los eventos disponibles que suceden actualmente
        disponibilityOfHall.setOnAction(e -> {
            main.setAlignment(Pos.CENTER); // alineamos el main al centro

            // reseteamos estilos
            ResetStyleButtons.reset(publicationOfHall, searchHallOfEvent, nextHall, favoritesHall);
            disponibilityOfHall.getStyleClass().remove("button-desactive"); // removemos la clase desactive
            disponibilityOfHall.getStyleClass().add("button-active");// y le aplicamos el CSS de activo
            main.getChildren().clear(); // limpiamos el main
            HBox node = DisponibilityOfEvent.disponibilityOfHall(); // obtenemos el HBox con el diseño

            // transicion de fade
            FadeTransition fadeTransition = new FadeTransition(Duration.seconds(0.5));
            fadeTransition.setFromValue(0);
            fadeTransition.setToValue(1);
            fadeTransition.setNode(node);
            fadeTransition.play(); // reproducimos la animacion

            main.getChildren().add(node); // añadimos el contenedor al main
        });

        // boton para ver los events proximos a realizarse
        nextHall.setOnAction(e -> {
            main.setAlignment(Pos.CENTER); // alineamos el main al centro

            // reseteamos estilos
            ResetStyleButtons.reset(publicationOfHall, disponibilityOfHall, searchHallOfEvent, favoritesHall);
            nextHall.getStyleClass().remove("button-desactive");// removemos desactive
            nextHall.getStyleClass().add("button-active"); // activamos la clase active
            main.getChildren().clear(); // limpiamos el main

            for (HBox node : UpcomingEventIU.upcomingEvent()) { // aca iteramos los diferenets HBox diseñados
                // establecemos el margen
                VBox.setMargin(node, new Insets(5, 5, 10, 0));

                // su respectiva transicion de fade
                FadeTransition fadeTransition = new FadeTransition(Duration.seconds(1));
                fadeTransition.setFromValue(0);
                fadeTransition.setToValue(1);
                fadeTransition.setNode(node);
                fadeTransition.play(); // reproducimos el efecto
                main.getChildren().addAll(node); // añadimos los diferentes HBox al main
            }
        });

        // boton de los favoritos
        favoritesHall.setOnAction((var e) -> {
            favoritesLayoutAndLogic(main, favoritesHall, publicationOfHall, disponibilityOfHall, nextHall,
                    searchHallOfEvent);
        });

        closeSesion.setOnAction(e -> {
            NextFrame.nextFrameDuration(principalInterfaceStage, LoginIU.class, 1);
            System.out.println("Se ha cerrado la sesión del usuario!");
        });

        // escena
        Scene scene = new Scene(stackPane);
        scene.getStylesheets().add(pathConst.getPrincipalInterfaceCSS()); // hoja de estilos CSS

        // configuracion del stage
        principalInterfaceStage.setTitle("Principal Interface - FastEvent");
        principalInterfaceStage.setResizable(false);
        principalInterfaceStage.setWidth(1200);
        principalInterfaceStage.setHeight(800);
        principalInterfaceStage.setScene(scene);
        principalInterfaceStage.show();
    }

    // este es un metodo que nos servira para reutilizar codigo
    private static void favoritesLayoutAndLogic(VBox main,
            Button favoritesHall,
            Button publicationOfHall, // estos son los demas botones de reservar, publicar, etc..
            Button disponibilityOfHall,
            Button nextHall,
            Button searchHallOfEvent) {

        main.setAlignment(Pos.TOP_CENTER); // alineamos al centr0
        ResetStyleButtons.reset(publicationOfHall, disponibilityOfHall, nextHall, searchHallOfEvent);
        favoritesHall.getStyleClass().remove("button-desactive");
        favoritesHall.getStyleClass().add("button-active");
        main.getChildren().clear(); // limpiamos el main

        // iteramos los diferentes HBox que son los salones que son favoritos por el
        // usuario
        for (int hboxindex = 0; hboxindex < FavoritesOfHallIU.getSizeFavoritesHalls(); hboxindex++) {
            // obtenemos cada uno de los salones favoritos
            HBox container = (HBox) FavoritesOfHallIU.hallsContainersFavorites().get(hboxindex);
            container.setOpacity(0); // establecemos opacidad a 0

            // transiciones y margenes
            FadeTransition fadeTransition = new FadeTransition(Duration.seconds(0.5), container);
            fadeTransition.setFromValue(0.0);
            fadeTransition.setToValue(1.0);
            fadeTransition.setDelay(Duration.seconds(hboxindex * 0.2));

            VBox.setMargin(container, new Insets(10, 0, 5, 0));
            main.getChildren().addAll(container);
            fadeTransition.play();
        }
    }
}
