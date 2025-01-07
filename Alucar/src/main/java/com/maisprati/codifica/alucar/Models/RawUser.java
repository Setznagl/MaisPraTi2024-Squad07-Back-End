package com.maisprati.codifica.alucar.Models;

import jakarta.persistence.*;
import lombok.*;

@Data
@Builder
@Entity
@AllArgsConstructor
public class RawUser {

    public RawUser() {
        //Empty constructor
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    ///////////////////////////////////////////////////

    /**
     *
     */
    @Column(nullable = true , length = 11 , unique = true )
    private String cpf;

    @Column(nullable = false , length = 50)
    private String name;

    @Column(nullable = false)
    private java.sql.Date birthdate;

}
