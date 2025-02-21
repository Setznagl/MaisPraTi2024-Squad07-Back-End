package com.maisprati.codifica.alucar.Models.Product;

import java.sql.Date;

public abstract class Vehicle {
    protected Vehicle(){/*Empty constructor*/}
    public Vehicle
    (
        Long parameterOwnerID,
        String parameterBrand,
        String parameterModel,
        java.sql.Date parameterYear,
        String parameterLicensePlate
    )
    {
        this.owner_id = parameterOwnerID;
        this.brand = parameterBrand;
        this.model = parameterModel;
        this.year = parameterYear;
        this.license_plate = parameterLicensePlate;
    }

    private Long owner_id;
    private String brand;
    private String model;
    private java.sql.Date year;
    private String license_plate;

    ////////////////////////////////////////////////////////////////////////////

    public Long getOwner_id() {return owner_id;}
    public void setOwner_id(Long owner_id) {this.owner_id = owner_id;}

    public String getBrand() {return brand;}
    public void setBrand(String brand) {this.brand = brand;}

    public String getModel() {return model;}
    public void setModel(String model) {this.model = model;}

    public Date getYear() {return year;}
    public void setYear(Date year) {this.year = year;}

    public String getLicense_plate() {return license_plate;}
    public void setLicense_plate(String license_plate) {this.license_plate = license_plate;}
}
