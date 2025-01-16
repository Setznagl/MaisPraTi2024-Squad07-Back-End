package com.maisprati.codifica.alucar.Models.Users;

import jakarta.persistence.*;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Objects;

@Entity
public class RawUser {
    protected RawUser(){/*Empty constructor*/}
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

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public Long getId(){return id;}
    public void setId(Long id){this.id = id;}

    public String getName(){return name;}
    public void setName(String name){this.name = name;}

    public String getEmail(){return email;}
    public void setEmail(String email){this.email = email;}

    public String getPassword(){return password;}
    public void setPassword(String password){this.password = password;}

    public String getCpf(){return cpf;}
    public void setCpf(String cpf){this.cpf = cpf;}

    public Date getBirthdate(){return birthdate;}
    public void setBirthdate(Date birthdate){this.birthdate = birthdate;}

    public String getPhone(){return phone;}
    public void setPhone(String phone){this.phone = phone;}

    public Integer getAverage_rating(){return average_rating;}
    public void setAverage_rating(Integer average_rating){this.average_rating = average_rating;}

    public Timestamp getCreated_at(){return created_at;}
    public void setCreated_at(Timestamp created_at){this.created_at = created_at;}

    public byte[] getPhoto(){return photo;}
    public void setPhoto(byte[] photo){this.photo = photo;}

    @Override
    public boolean equals(Object o) {return this == o || this.getClass() == o.getClass();}
}

