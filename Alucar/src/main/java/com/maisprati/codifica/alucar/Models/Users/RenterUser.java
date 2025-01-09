package com.maisprati.codifica.alucar.Models.Users;

import jakarta.persistence.Entity;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Builder
@Entity
@EqualsAndHashCode(callSuper = false)
public class RenterUser extends RawUser{

    public RenterUser() {
        //Empty constructor
    }

    public RenterUser(RawUser parameter_rawuser) {
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

    }
    /*
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


}
