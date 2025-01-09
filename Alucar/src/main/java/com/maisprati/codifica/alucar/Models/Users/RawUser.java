package com.maisprati.codifica.alucar.Models.Users;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Data
@Builder
@Entity
public class RawUser {

    public RawUser() {
        //Empty constructor
    }

    public RawUser(String parameter_name , String parameter_email , String parameter_password){
        this.name = parameter_name;
        this.email = parameter_email;
        this.password = parameter_password;
        /*
          Dados provisórios para previnir NullPointerException
         */
        this.cpf = " ";
        this.birthdate = Date.valueOf("1970-01-01");
        this.phone = " ";
        this.average_rating = 0;
        this.created_at = Timestamp.valueOf(LocalDateTime.now());
        this.photo = " ".getBytes();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    ///////////////////////////////////////////////////

    /**
     * Campos "birthdate" e "cpf" não constam no protótipo para cadastro, serão atribuídos ao usuário
     * no que seria a consulta dos documentos via API que no nosso projeto será feita via JSON/Mock
     */
    @Column(nullable = false , length = 50)
    private String name;

    @Column(nullable = false , length = 50)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(/*(nullable = true)*/ length = 11 , unique = true )
    private String cpf;

    @Column(/*(nullable = true)*/)
    private java.sql.Date birthdate;

    @Column(/*(nullable = true)*/ length = 15)
    private String phone;

    @Column(/*(nullable = true)*/ length = 2)
    private Integer average_rating;

    @Column(/*(nullable = true)*/ length = 50)
    private java.sql.Timestamp created_at;

    @Column(/*(nullable = true)*/)
    private byte[] photo;

}
