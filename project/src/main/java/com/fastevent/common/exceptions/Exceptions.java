package com.fastevent.common.exceptions;

/**
 * @author BR7FORLIFE
 * 
 */

 /**
  * aca manejamos excepciones personalizadas con en fin de poder decirle al usuario lo que ha hecho mal, 
  * ejemplo un campo que no debe en el formulario de register 
  *
  */
public class Exceptions {
    public static class NotCorrectFormat extends Exception {
        public NotCorrectFormat(){
            super("<NotCorrectFormat> algún campo del formulario tiene un mal formato, como un correo,un telefono entre otras. o un campo requere un prompt especial");
        }
    }
}
