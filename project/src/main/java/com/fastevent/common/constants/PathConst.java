package com.fastevent.common.constants;

import java.io.File;

public class PathConst {
    // archivos
    private String userJSon = "project/src/main/java/com/fastevent/models/users.json";

    // archivos css
    private final String splashScreenCss = getClass().getResource("/css/SplashScreen.css").toExternalForm();
    private final String registerCss = getClass().getResource("/css/RegisterIU.css").toExternalForm();
    private final String loginCss = getClass().getResource("/css/Login.css").toExternalForm();

    // recursos(imagenes,videos etc etc)
    private final String logoFastEvent = getClass().getResource("/images/logoFastEvent.png").toExternalForm();

    private final String videoSplashScreen = new File("project/src/main/resources/videos/splashScreenVideo.mp4")
            .toURI().toString();

    private final String loginVideo = new File("project/src/main/resources/videos/loginVideo.mp4")
            .toURI().toString();

    // getters y setters para las constantes
    public String getSplashScreenCSs() {
        return splashScreenCss;
    }

    public String getRegisterCss() {
        return registerCss;
    }

    public String getLoginCss() {
        return loginCss;
    }

    public String getLogoFastEvent() {
        return logoFastEvent;
    }

    public String getVideoSplashScreen() {
        return videoSplashScreen;
    }

    public String getLoginVideo() {
        return loginVideo;
    }

    public String getUserJSon() {
        return userJSon;
    }
}
