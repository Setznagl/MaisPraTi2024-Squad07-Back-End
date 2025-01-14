package com.maisprati.codifica.alucar.Models.Users;

import jakarta.persistence.Entity;

@Entity
public class RenterUser extends RawUser{
    public RenterUser(){/*Empty constructor*/}
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
    }
}
