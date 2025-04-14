package com.fastevent.common.exceptions;

public class Exceptions {
    public static class NotCorrectFormat extends Exception {
        public NotCorrectFormat(){
            super("<NotCorrectFormat> algún campo del formulario tiene un mal formato, como un correo,un telefono entre otras. o un campo requere un prompt especial");
        }
    }
}
