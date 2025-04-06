package com.fastevent.controller.simpleClasses;

public class Hall {
    private final String nameOfHall;
    private final String description;
    private final String ubicationOfHall;
    private final String capacity;
    private final float dimension;
    private final Long cellphone;
    private final float priceOfHall;
    private final float valorationOfHall;
    
    public Hall(String nameOfHall, String description, String ubicationOfHall, String capacity, float dimension,
            Long cellphone, float priceOfHall, float valorationOfHall) {
        this.nameOfHall = nameOfHall;
        this.description = description;
        this.ubicationOfHall = ubicationOfHall;
        this.capacity = capacity;
        this.dimension = dimension;
        this.cellphone = cellphone;
        this.priceOfHall = priceOfHall;
        this.valorationOfHall = valorationOfHall;
    }

    public String getNameOfHall() {
        return nameOfHall;
    }

    public String getDescription() {
        return description;
    }

    public String getUbicationOfHall() {
        return ubicationOfHall;
    }

    public String getCapacity() {
        return capacity;
    }

    public float getDimension() {
        return dimension;
    }

    public Long getCellphone() {
        return cellphone;
    }

    public float getPriceOfHall() {
        return priceOfHall;
    }

    public float getValorationOfHall() {
        return valorationOfHall;
    }

    public Builder Builder(){
        return new Builder();
    }

    public static class Builder{
        private String nameOfHall;
        private String description;
        private String ubicationOfHall;
        private String capacity;
        private float dimension;
        private Long cellphone;
        private float priceOfHall;
        private float valorationOfHall;

        public Builder setNameOfHall(String nameOfHall){
            this.nameOfHall = nameOfHall;
            return this;
        }

        public Builder setDescription(String description){
            this.description = description;
            return this;
        }

        public Builder setUbicationOfHall(String ubicationOfHall){
            this.ubicationOfHall = ubicationOfHall;
            return this;
        }

        public Builder setCapacity(String capacity){
            this.capacity = capacity;
            return this;
        }

        public Builder setDimension(float dimension){
            this.dimension = dimension;
            return this;
        }

        public Builder setCellphone(Long cellphone){
            this.cellphone = cellphone;
            return this;
        }

        public Builder setPriceOfHall(float priceOfHall){
            this.priceOfHall = priceOfHall;
            return this;
        }

        public Builder setValorationOfHall(float valorationOfHall){
            this.valorationOfHall = valorationOfHall;
            return this;
        }
    }
}
