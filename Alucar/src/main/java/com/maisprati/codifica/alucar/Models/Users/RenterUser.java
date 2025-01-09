package com.maisprati.codifica.alucar.Models.Users;

import jakarta.persistence.Entity;

@Entity
public class RenterUser extends RawUser{
    /*
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
    public RenterUser() {
       super();
        /*
         * Dados provisórios para previnir NullPointerException
         */
    }
}
