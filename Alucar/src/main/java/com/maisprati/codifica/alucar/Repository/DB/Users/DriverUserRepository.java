package com.maisprati.codifica.alucar.Repository.DB.Users;

import com.maisprati.codifica.alucar.Models.Users.DriverUser;
import com.maisprati.codifica.alucar.Util.UF;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;

//Abstraction of the JPA Hibernate DAO and C.R.U.D functions
@Repository
public interface DriverUserRepository extends JpaRepository<DriverUser , Long> , GenericUserRepository{

    // JPQL
    @Query("SELECT p FROM DriverUser p WHERE p.email = :email")
    DriverUser findDriverUserByEmail(@Param("email") String email);


    @Query  ("UPDATE DriverUser p SET" +
            " p.name =  :newName  ,  p.email = :newEmail , p.phone = :newPhone ," +
            " p.location = :newUF , p.instagram = :newInstagram ," +
            " p.criminal_record = :newCAC , p.cnh = :newCNH " +
            " WHERE p.id = :id ")
    Void fromUser_updateDriverUserName
            (@Param("parameterId") Long id,
             @Param("parameterNewName") String newName,
             @Param("paremeterNewEmail") String newEmail,
             @Param("parameterNewPhone") String newPhone,
             @Param("parameterNewUF") UF newUF,
             @Param("parameterInstagram") String newInstagram,
             @Param("parameterCAC") byte[] newCAC,
             @Param("parameterCNH") byte[] newCNH);



    @Query  ("UPDATE DriverUser p SET" +
            " p.cpf = :newCPF , p.birthdate = :newBirthdate , p.cnh_expiration_date = :newCNHexpirationDate WHERE p.id = :id ")
    Void fromAPI_updateDriverUserName
            (@Param("parameterId") Long id,
             @Param("parameterCPF") String newCPF,
             @Param("paremeterNewBirthdate") Date newBirthdate,
             @Param("parameterNewCNHexpirationDate") Date newCNHexpirationDate);



}
