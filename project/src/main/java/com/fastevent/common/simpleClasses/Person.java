package com.fastevent.common.simpleClasses;

/**
 * @author BR7FORLIFE
 * 
 */

/*
 * esta es la clase que nos permite modelar una persona mas NO un cliente esta
 * clase
 * solo establece los atributos basicos de una persona para utlizarla en la
 * clase cliente
 */

public class Person {

    // atributos de la clase
    private String name;
    private String lastName;
    private Integer age;
    private String cellphone;
    private String gender;
    private String email;

    /**
     * parametros del constructor persona
     * 
     * @param name
     * @param lastName
     * @param age
     * @param cellphone
     * @param gender
     * @param email
     */
    public Person(String name, String lastName, Integer age, String cellphone, String gender, String email) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.cellphone = cellphone;
        this.gender = gender;
        this.email = email;
    }

    // getters
    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public String getCellphone() {
        return cellphone;
    }

    public String getEmail() {
        return email;
    }

    public String getGender() {
        return gender;
    }
}
