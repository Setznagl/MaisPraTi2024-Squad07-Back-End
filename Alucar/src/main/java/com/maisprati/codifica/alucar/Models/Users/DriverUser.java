package com.maisprati.codifica.alucar.Models.Users;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;

@Data
@Builder
@Entity
@EqualsAndHashCode(callSuper = false)
public class DriverUser extends RawUser{

    public DriverUser() {
        //Empty constructor
    }

    public DriverUser(RawUser parameter_rawuser) {
        this.setId(parameter_rawuser.getId());
        this.setName(parameter_rawuser.getName());
        this.setEmail(parameter_rawuser.getEmail());
        this.setPassword(parameter_rawuser.getPassword());
        this.setCpf(parameter_rawuser.getCpf());
        this.setBirthdate(parameter_rawuser.getBirthdate());
        this.setPhone(parameter_rawuser.getPhone());
        this.setAverage_rating(parameter_rawuser.getAverage_rating());
        this.setCreated_at(parameter_rawuser.getCreated_at());
        this.setPhoto(parameter_rawuser.getPhoto());
        /*
         * Dados provisórios para previnir NullPointerException
         */
        this.criminal_record = " ".getBytes();
        this.cnh = " ".getBytes();
        this.cnh_expiration_date = Date.valueOf("1970-01-01");
        this.verified = false;

    }
    /**
     * Atributos Herdados:
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

    @Column/*(nullable = true)*/
    private byte[] criminal_record;

    @Column/*(nullable = true)*/
    private byte[] cnh;

    @Column/*(nullable = true)*/
    private java.sql.Date cnh_expiration_date;

    @Column(nullable = false)
    private Boolean verified;

}
