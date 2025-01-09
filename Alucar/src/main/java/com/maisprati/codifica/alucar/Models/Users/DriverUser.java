package com.maisprati.codifica.alucar.Models.Users;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.Arrays;

@Entity
public class DriverUser extends RawUser{
    public DriverUser(){/*Empty constructor*/}
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
    public DriverUser(String parameter_name , String parameter_email , String parameter_password) {
        super(parameter_name , parameter_email , parameter_password);
        /*
         * Dados provisórios para previnir NullPointerException
         */
        this.criminal_record = " ".getBytes();
        this.cnh = " ".getBytes();
        this.cnh_expiration_date = Date.valueOf("1970-01-01");
        this.verified = false;
    }

    @Column/*(nullable = true)*/
    private byte[] criminal_record;

    @Column/*(nullable = true)*/
    private byte[] cnh;

    @Column/*(nullable = true)*/
    private java.sql.Date cnh_expiration_date;

    @Column(nullable = false)
    private Boolean verified;

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public byte[] getCriminal_record(){return criminal_record;}
    public void setCriminal_record(byte[] criminal_record){this.criminal_record = criminal_record;}

    public byte[] getCnh(){return cnh;}
    public void setCnh(byte[] cnh){this.cnh = cnh;}

    public Date getCnh_expiration_date(){return cnh_expiration_date;}
    public void setCnh_expiration_date(Date cnh_expiration_date){this.cnh_expiration_date = cnh_expiration_date;}

    public Boolean getVerified(){return verified;}
    public void setVerified(Boolean verified){this.verified = verified;}

    @Override
    public String toString() {
        return "DriverUser{" +
                "id=" + super.getId() +
                ", name='" + super.getName() + '\'' +
                ", email='" + super.getEmail() + '\'' +
                ", password='" + super.getPassword() + '\'' +
                ", cpf='" + super.getCpf() + '\'' +
                ", birthdate=" + super.getBirthdate() +
                ", phone='" + super.getPhone() + '\'' +
                ", average_rating=" + super.getAverage_rating() + '\'' +
                ", created_at=" + super.getCreated_at() + '\'' +
                ", photo=" + Arrays.toString(super.getPhoto()) +
                "criminal_record=" + Arrays.toString(criminal_record) +
                ", cnh=" + Arrays.toString(cnh) +
                ", cnh_expiration_date=" + cnh_expiration_date +
                ", verified=" + verified +
                '}';
    }
}
