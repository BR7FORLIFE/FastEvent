package com.fastevent.controller.simpleClasses;

public class Person {
    private final String name;
    private final String lastName;
    private final int age;
    private final Long cellphone;
    private final String email;

    public Person(String name, String lastName, int age, Long cellphone, String email) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.cellphone = cellphone;
        this.email = email;
    }
    
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

    public static Builder Builder(){
        return new Builder();
    }


    public static class Builder{
        private String name;
        private String lastName;
        private int age;
        private Long cellphone;
        private String email;

        public Builder setName(String name){
            this.name = name;
            return this;
        }

        public Builder setLastName(String lastname){
            this.lastName = lastname;
            return this;
        }

        public Builder setAge(int age){
            this.age = age;
            return this;
        }

        public Builder setCellphone(Long cellphone){
            this.cellphone = cellphone;
            return this;
        }

        public Builder setEmail(String Email){
            return this;
        }
    }
}
