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
            " p.location = :newUF , p.instagram = :newInstagram WHERE p.id = :id ")
        Void fromUser_updateDriverUserName
            (@Param("parameterId") Long id,
             @Param("parameterNewName") String newName,
             @Param("paremeterNewEmail") String newEmail,
             @Param("parameterNewPhone") String newPhone,
             @Param("parameterNewUF") UF newUF,
             @Param("parameterInstagram") String newInstagram);



    @Query ("UPDATE DriverUser p SET p.cnh = :newCNH")
        void updateCnh(@Param("newCNH") byte[] newCNH);


    @Query ("UPDATE DriverUser p SET p.criminal_record = :newCAC")
        void updateCAC(@Param("newCAC") byte[] newCAC);


    @Query  ("UPDATE DriverUser p SET" +
            " p.cpf = :newCPF , p.birthdate = :newBirthdate , " +
            " p.cnh_expiration_date = :newCNHexpirationDate , p.verified = :newVerified " +
            " WHERE p.id = :id ")
        Void fromAPI_updateDriverUserName
            (@Param("parameterId") Long id,
             @Param("parameterNewCPF") String newCPF,
             @Param("paremeterNewBirthdate") Date newBirthdate,
             @Param("parameterNewCNHexpirationDate") Date newCNHexpirationDate,
             @Param("parameterNewVerified") Boolean newVerified);



}
