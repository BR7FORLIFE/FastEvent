package com.fastevent;

import com.fastevent.views.splashScreen.SplashScreen;

public class main {
    public static void main(String[] args) {
        /*
         * en este apartado ejecutamos o lanzamos nuestra aplicacion gracias a launch
         * donde el primer argumento sea
         * el .class de la clase y segundo los argumentos necesarios
         */

        SplashScreen.launch(SplashScreen.class, args);
        //PrincipalInterfaceIU.launch(PrincipalInterfaceIU.class,args);
        //RegisterIU.launch(RegisterIU.class, args);
        // LoginIU.launch(LoginIU.class, args);
    }
}
