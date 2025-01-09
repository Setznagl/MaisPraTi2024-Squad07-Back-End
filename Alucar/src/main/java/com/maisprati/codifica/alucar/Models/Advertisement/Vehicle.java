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

}
