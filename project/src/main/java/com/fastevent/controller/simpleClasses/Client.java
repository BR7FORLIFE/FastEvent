package com.fastevent.controller.simpleClasses;

public class Client extends Person {
    private String user;
    private String password;

    public Client(String name, String lastName, int age, Long cellphone, String email) {
        super(name, lastName, age, cellphone, email);
    }

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
    