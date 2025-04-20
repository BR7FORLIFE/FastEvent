package com.fastevent.common.constants;

import java.io.File;

/**
 * @author BR7FORLIFE
 * 
 */

/*
 * aca tenemos las constantes que nos permitira evitar la repeticion de codigo
 * donde aca vemos las diferentes rutas de los dos modelos, los css y los
 * recursos como imagenes videos etc
 */
public class PathConst {

    /**
     * en este apartado nosotros tenemos dos path o rutas que nos ayudara a acceder
     * a los distintos modelos o json
     * en este caso tenemos dos que userJson que se encarga de guardar la sesion de
     * los usarios y tambien tenemos publicationJson que es un json que nos
     * permitira guardar la informacion de los distintos salones como su
     * nombre, descripcion, capacidad, dimensiones, precio, valoracion etc.
     */
    // archivos
    private String userJSon = "project/src/main/java/com/fastevent/models/users.json";
    private String publicationJson = "project/src/main/java/com/fastevent/models/publications.json";

    /**
     * aca tenemos las distintas rutas de los archivos css como el css del
     * splashScreen, del register, login, y pricipal interface que es el css
     * encargado de la vista de los distintos salones y funcionalidades
     */
    // archivos css
    private final String splashScreenCss = getClass().getResource("/css/SplashScreen.css").toExternalForm();
    private final String registerCss = getClass().getResource("/css/RegisterIU.css").toExternalForm();
    private final String loginCss = getClass().getResource("/css/Login.css").toExternalForm();
    private final String PrincipalInterfaceCSS = getClass().getResource("/css/PrincipalInterfaceIU.css")
            .toExternalForm();

    /**
     * vemos los recursos como las imagenes que nos permite adjuntar en el
     * splasscreen y el login, de una manera mas limpia podemos acceder a ella ya
     * sea para pruebas o colocarlo en una vista
     */

    // recursos(imagenes,videos etc etc)
    private final String logoFastEvent = getClass().getResource("/images/logoFastEvent.png").toExternalForm();
    private final String logoFastEventOsc = getClass().getResource("/images/logoOscurecido.png").toExternalForm();
    private final String logoFastEventRemaster = getClass().getResource("/images/logoFastEventRemaster.jpeg").toExternalForm();
    private final String logoFastEventBlanco = getClass().getResource("/images/logoFastEventClaro.jpeg").toExternalForm();
    private final String circoImage = getClass().getResource("/images/ImageCirco.jpg").toExternalForm();
    private final String hayFestivalImage = getClass().getResource("/images/hayFestivalImage.jpeg").toExternalForm();
    private final String festivalCaribeImage = getClass().getResource("/images/festivalCaribeImage.jpeg").toExternalForm();
    private final String festivalDulceImage = getClass().getResource("/images/festivalDulceImage.jpg").toExternalForm();
    private final String festivalVeranoImage = getClass().getResource("/images/FestivalVeranoImage.jpg").toExternalForm();
    

    private final String videoSplashScreen = new File("project/src/main/resources/videos/splashScreenVideo.mp4")
            .toURI().toString();

    private final String loginVideo = new File("project/src/main/resources/videos/loginVideo.mp4")
            .toURI().toString();

    private final String registerVideo = new File("project/src/main/resources/videos/registerVideo.mp4")
            .toURI().toString();

    /**
     * 
     * @return getters y setters para acceder a las diferentes constantes
     *         encapsuladas
     * 
     */

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

    public String getPrincipalInterfaceCSS() {
        return PrincipalInterfaceCSS;
    }

    public String getPublicationJson() {
        return publicationJson;
    }

    public String getRegisterVideo() {
        return registerVideo;
    }

    public String getLogoFastEventOsc() {
        return logoFastEventOsc;
    }
    
    public String getLogoFastEventRemaster() {
        return logoFastEventRemaster;
    }

    public String getCircoImage() {
        return circoImage;
    }

    public String getHayFestivalImage() {
        return hayFestivalImage;
    }

    public String getFestivalCaribeImage() {
        return festivalCaribeImage;
    }

    public String getFestivalDulceImage() {
        return festivalDulceImage;
    }

    public String getFestivalVeranoImage() {
        return festivalVeranoImage;
    }

    public String getLogoFastEventBlanco() {
        return logoFastEventBlanco;
    }
}
