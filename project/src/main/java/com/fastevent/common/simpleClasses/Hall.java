package com.fastevent.common.simpleClasses;

/**
 * @author BR7FORLIFE
 * 
 */

/**
 * esta es la clase que nos permitira modelar los diferentes salones para
 * mostrarlos
 */

public class Hall {

    /**
     * atributos de la clase salon
     */
    private String nameOfHall;
    private String description;
    private String ubicationOfHall;
    private Integer capacity;
    private Integer dimension;
    private Long cellphone;
    private float priceOfHall;
    private float valorationOfHall;
    private String timezone;

    /**
     * constructor de la clase salon
     * 
     * @param nameOfHall
     * @param description
     * @param ubicationOfHall
     * @param capacity
     * @param dimension
     * @param cellphone
     * @param priceOfHall
     * @param valorationOfHall
     */
    public Hall(String nameOfHall, String description, String ubicationOfHall, Integer capacity, Integer dimension,
            Long cellphone, float priceOfHall, float valorationOfHall, String timezone) {
        this.nameOfHall = nameOfHall;
        this.description = description;
        this.ubicationOfHall = ubicationOfHall;
        this.capacity = capacity;
        this.dimension = dimension;
        this.cellphone = cellphone;
        this.priceOfHall = priceOfHall;
        this.valorationOfHall = valorationOfHall;
        this.timezone = timezone;
    }

    // getters y setters de la clase salon

    /**
     * 
     * @param nameOfHall
     */
    public void setNameOfHall(String nameOfHall) {
        this.nameOfHall = nameOfHall;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setUbicationOfHall(String ubicationOfHall) {
        this.ubicationOfHall = ubicationOfHall;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public void setDimension(Integer dimension) {
        this.dimension = dimension;
    }

    public void setCellphone(Long cellphone) {
        this.cellphone = cellphone;
    }

    public void setPriceOfHall(float priceOfHall) {
        this.priceOfHall = priceOfHall;
    }

    public void setValorationOfHall(float valorationOfHall) {
        this.valorationOfHall = valorationOfHall;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
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

    public String getTimezone() {
        return timezone;
    }
}
