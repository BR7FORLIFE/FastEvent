package com.fastevent.common.constants;

/**
 * @author BR7FORLIFE
 * 
 */

/**
 * la creacion de esta clase se dio por la necesidad de poder poner estilos en
 * linea en una clase que no iba a
 * heredar de Aplicaction para que no se comportara como un frame mas sino como
 * un generador de contenedores
 * verticales. la clase SearchPublication es la clase a la cual se le aplica
 * estos estilos en linea
 */
public class StylesConst {

    /**
     * aca tenemos los diferentes estilos en linea que son:
     * 
     * - styleForLabels <-- son estilos en linea para todos los labels que indican
     * la informacion ejemplo name,
     * description etc etc
     * 
     * - styleSelectHall <-- son estilos para el boton de seleccionar de los
     * diferentes contenedores
     * 
     * - styleInformationHall <-- son los estilos que se le aplicara a los datos que
     * le lleguen del modelo
     * 
     * - styleFatherContainer <-- son los estilos para los distintos contenedores
     * que se vayan creando en la clase
     * generadora de VBox
     * 
     * - styleTitleHall <-- son los estilos para los distintos titulos de cada salon
     * publicado
     */
    private static String styleForLabels = "-fx-text-fill: white; -fx-font-size: 15px; -fx-font-weight: 800; -fx-font-family: Cochin, Georgia, Times, 'Times New Roman', serif;";

    private static String fontweightToLabel = "-fx-font-weight: 800;";

    private static String styleSelectHall = "-fx-background-color:rgb(255, 255, 255); -fx-font-size: 12px; -fx-font-weight: 600; -fx-font-family: fantasy; -fx-border-radius: 4px;  -fx-border-color: linear-gradient(from 0% 0% to 100% 0%, #00e6f2, #6767eb, #2f00ff); -fx-text-fill: black; -fx-border-width: 3px;";

    private static String styleInformationHall = " -fx-font-size: 15px; -fx-font-family: Cochin, Georgia, Times, 'Times New Roman', serif; ";
    private static String styleFatherContainer = "-fx-background-color: linear-gradient(from 0% 0% to 100% 0%, #00e6f2, #6767eb, #2f00ff);";
    private static String styleTitleHall = "-fx-text-fill: white; -fx-font-size: 17px; -fx-font-weight: 700; -fx-font-family: Cochin, Georgia, Times, 'Times New Roman', serif;";

    /**
     * 
     * @return devulve los diferentes estilos de una forma estatica sin necesidad de
     *         instanciar objetos
     */
    public static String getStyleForLabels() {
        return styleForLabels;
    }

    public static String getFontweightToLabel() {
        return fontweightToLabel;
    }

    public static String getStyleSelectHall() {
        return styleSelectHall;
    }

    public static String getStyleInformationHall() {
        return styleInformationHall;
    }

    public static String getStyleFatherContainer() {
        return styleFatherContainer;
    }

    public static String getStyleTitleHall() {
        return styleTitleHall;
    }
}
