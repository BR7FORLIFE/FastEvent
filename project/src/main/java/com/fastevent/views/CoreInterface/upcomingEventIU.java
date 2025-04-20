package com.fastevent.views.CoreInterface;

import java.util.ArrayList;

import com.fastevent.common.constants.PathConst;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class UpcomingEventIU {
    private static PathConst pathConst = new PathConst();
    private static ArrayList<HBox> containers = new ArrayList<>();

    public static ArrayList<HBox> upcomingEvent() {
        containers.clear();
        Label upcoming = new Label("upcoming");

        Image image1 = new Image(pathConst.getFestivalCaribeImage());
        ImageView imageView1 = new ImageView(image1);
        Label title1 = new Label("Festival de musica del caribe");
        Label description1 = new Label("Siente la musica, vibra con el ritmo!");
        VBox info1 = new VBox(title1, description1, upcoming);
        VBox imageContainer1 = new VBox(imageView1);

        Image image2 = new Image(pathConst.getFestivalDulceImage());
        ImageView imageView2 = new ImageView(image2);
        Label title2 = new Label("Festival del dulce");
        Label description2 = new Label("Endulzate la vida y disfruta cada bocado!");
        VBox info2 = new VBox(title2, description2, upcoming);
        VBox imageContainer2 = new VBox(imageView2);

        Image image3 = new Image(pathConst.getFestivalVeranoImage());
        ImageView imageView3 = new ImageView(image3);
        Label title3 = new Label("Festival de Verano");
        Label description3 = new Label("sol, diversion y aventura te esperan en el festival!");
        VBox info3 = new VBox(title3, description3, upcoming);
        VBox imageContainer3 = new VBox(imageView3);

        imageView1.setFitWidth(50);
        imageView1.setFitHeight(50);
        imageView1.setPreserveRatio(true);

        imageView2.setFitWidth(50);
        imageView2.setFitHeight(50);
        imageView2.setPreserveRatio(true);

        imageView3.setFitWidth(50);
        imageView3.setFitHeight(50);
        imageView3.setPreserveRatio(true);
        
        HBox container1 = new HBox(info1, imageContainer1);
        HBox container2 = new HBox(info2, imageContainer2);
        HBox container3 = new HBox(info3, imageContainer3);

        containers.add(container1);
        containers.add(container2);
        containers.add(container3);

        return containers;
    }
}
