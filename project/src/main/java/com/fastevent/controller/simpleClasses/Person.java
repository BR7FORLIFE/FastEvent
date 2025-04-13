package com.fastevent.controller.simpleClasses;

public class Person {
    private String name;
    private String lastName;
    private Integer age;
    private String cellphone;
    private String gender;
    private String email;

    public Person(String name, String lastName, Integer age, String cellphone, String gender,String email) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.cellphone = cellphone;
        this.gender = gender;
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
