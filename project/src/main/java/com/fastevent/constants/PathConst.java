package com.fastevent.constants;

import java.io.File;

public class PathConst {
    //archivos
    public String userJSon = "project/src/main/java/com/fastevent/models/users.json";

    // archivos css
    private final String pathToSplashScreenCss = getClass().getResource("/css/SplashScreen.css").toExternalForm();

    // recursos(imagenes,videos etc etc)
    private final String pathToLogo = getClass().getResource("/images/logoFastEvent.png").toExternalForm();

    private final String pathVideo = new File("project/src/main/resources/videos/splashScreenVideo.mp4")
    .toURI().toString();

    public String getPathVideo() {
        return pathVideo;
    }

    public String getPathToLogo() {
        return pathToLogo;
    }

    public String getPathToSplashScreenCss() {
        return pathToSplashScreenCss;
    }

    public String getUserJSon() {
        return userJSon;
    }
}
