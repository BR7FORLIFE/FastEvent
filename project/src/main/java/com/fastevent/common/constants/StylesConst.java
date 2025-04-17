package com.fastevent.common.constants;

public class StylesConst {
    private static String styleForLabels = "-fx-text-fill: white; -fx-font-size: 15px; -fx-font-weight: 700; -fx-font-family: Cochin, Georgia, Times, 'Times New Roman', serif;";
    private static String fontweightToLabel = "-fx-font-weight: 800;";

    private static String styleSelectHall = "-fx-background-color:rgb(255, 255, 255); -fx-font-size: 14px; -fx-font-weight: 600; -fx-font-family: fantasy; -fx-border-radius: 4px;  -fx-border-color: linear-gradient(from 0% 0% to 100% 0%, #00e6f2, #6767eb, #2f00ff); -fx-text-fill: black; -fx-border-width: 3px;";

    private static String styleInformationHall = " -fx-font-size: 15px; -fx-font-family: Cochin, Georgia, Times, 'Times New Roman', serif; ";
    private static String styleFatherContainer = "-fx-background-color: linear-gradient(from 0% 0% to 100% 0%, #00e6f2, #6767eb, #2f00ff);";
    private static String styleTitleHall = "-fx-text-fill: white; -fx-font-size: 17px; -fx-font-weight: 700; -fx-font-family: Cochin, Georgia, Times, 'Times New Roman', serif;";

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
