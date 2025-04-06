package com.fastevent.constants;

import java.io.File;

public class PathConst {
    private final String pathVideo = new File("project/src/main/resources/videos/splashScreenVideo.mp4")
            .toURI().toString();

    private final String pathToSplashScreenCss = getClass().getResource("/css/SplashScreen.css").toExternalForm();

    private final String pathToLogo = getClass().getResource("/images/logoFastEvent.png").toExternalForm();

    public String getPathVideo() {
        return pathVideo;
    }

    public String getPathToLogo() {
        return pathToLogo;
    }

    public String getPathToSplashScreenCss() {
        return pathToSplashScreenCss;
    }
}
