package com.maisprati.codifica.alucar.Models.Advertisement;

import jakarta.persistence.*;

@Entity
public class Vehicle {

    public Vehicle(){
        //Empty constructor
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long owner_id;

    @Column(nullable = false)
    private String brand;

    @Column(nullable = false)
    private String model;

    @Column(nullable = false)
    private String year;

    @Column(nullable = false)
    private String license_plate;

    @Column(/*(nullable = true)*/)
    private byte[] photos;

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public Long getId(){return id;}
    public void setId(Long id){this.id = id;}

    public Long getOwner_id(){return owner_id;}
    public void setOwner_id(Long owner_id){this.owner_id = owner_id;}

    public String getBrand(){return brand;}
    public void setBrand(String brand){this.brand = brand;}

    public String getModel(){return model;}
    public void setModel(String model){this.model = model;}

    public String getYear(){return year;}
    public void setYear(String year){this.year = year;}

    public String getLicense_plate(){return license_plate;}
    public void setLicense_plate(String license_plate){this.license_plate = license_plate;}

    public byte[] getPhotos(){return photos;}
    public void setPhotos(byte[] photos){this.photos = photos;}
}
