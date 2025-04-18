package com.fastevent.common.simpleClasses;

/**
 * @author BR7FORLIFE
 */

/**
 * es una clase para modelar un cliente donde heredamos de person para acceder a
 * los atributos de persona
 */
public class Client extends Person {

    /**
     * atributos de la clase cliente
     */
    private String user;
    private String password;

    /**
     * parametros del cliente añadiendo los de la clase person
     * 
     * @param name
     * @param lastName
     * @param age
     * @param cellphone
     * @param gender
     * @param email
     */
    public Client(String name, String lastName, Integer age, String cellphone, String gender, String email) {
        super(name, lastName, age, cellphone, gender, email);
    }

    // setters y getters para mantener la encapsulación

    /**
     * 
     * @param user
     */
    public void setUser(String user) {
        this.user = user;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }
}
