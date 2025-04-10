package com.fastevent.controller.simpleClasses;

public class Person {
    private String name;
    private String lastName;
    private int age;
    private Long cellphone;
    private String email;

    public Person(String name, String lastName, int age, Long cellphone, String email) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.cellphone = cellphone;
        this.email = email;
    }

    //getters
    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public Long getCellphone() {
        return cellphone;
    }

    public String getEmail() {
        return email;
    }
}
