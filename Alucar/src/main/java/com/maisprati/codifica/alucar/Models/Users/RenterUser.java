package com.maisprati.codifica.alucar.Models.Users;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class RenterUser extends RawUser{
    protected RenterUser(){/*Empty constructor*/}
    /**
     * Atributos Herdados de RawUser:
     *      private String cpf;
     *      private String name;
     *      private java.sql.Date birthdate;
     *      private String phone;
     *      private String email;
     *      private String password;
     *      private Integer average_rating;
     *      private java.sql.Timestamp created_at;
     *      private byte[] photo;
     */
    public RenterUser(String parameter_name , String parameter_email , String parameter_password) {
        super(parameter_name , parameter_email , parameter_password);
        /*
         * Dados provisórios para previnir NullPointerException
         */
        this.location = " ";
        this.instagram = " ";
    }

    @Column/*(nullable = true)*/
    private String location;

    @Column/*(nullable = true)*/
    private String instagram;

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public String getLocation(){return location;}
    public void setLocation(String location){this.location = location;}

    public String getInstagram(){return instagram;}
    public void setInstagram(String instagram){this.instagram = instagram;}
}
