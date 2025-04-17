package com.fastevent.common.simpleClasses;

public class Hall {
    private String nameOfHall;
    private String description;
    private String ubicationOfHall;
    private Integer capacity;
    private Integer dimension;
    private Long cellphone;
    private float priceOfHall;
    private float valorationOfHall;
    
    public Hall(String nameOfHall, String description, String ubicationOfHall, Integer capacity, Integer dimension,
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

    public Integer getCapacity() {
        return capacity;
    }

    public Integer getDimension() {
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
}
