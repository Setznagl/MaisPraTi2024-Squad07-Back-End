package com.maisprati.codifica.alucar.Repository.DB.Users;

import com.maisprati.codifica.alucar.Models.Users.DriverUser;
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
            " p.name = :newName , p.email = :newEmail , " +
            " p.phone = :newPhone , p.location = :newLocation , " +
            " p.photo = :newPhoto , p.instagram = :newInstagram , " +
            " p.criminal_record = :newCriminalRecord , p.cnh = :newCNH , p.cnh_expiration_date = :newCNH_Expiration_Date " +
            " WHERE p.id = :id ")
    void Repository_Update_Driver_User
            (@Param("parameterId") Long id,
             @Param("parameterNewName") String newName,
             @Param("paremeterNewEmail") String newEmail,
             @Param("parameterNewPhone") String newPhone,
             @Param("parameterNewLocation") String newLocation,
             @Param("paramterNewPhoto") byte[] newPhoto,
             @Param("parameterNewInstagram") String newInstagram,
             @Param("parameterNewCriminalRecord") byte[] newCriminalRecord,
             @Param("parameterNewCriminalRecord") byte[] newCNH,
             @Param("parameterNewCriminalRecord") Date newCNH_Expiration_Date);

}
