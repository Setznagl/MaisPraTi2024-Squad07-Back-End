package com.maisprati.codifica.alucar.Repository.DB.Users;

import com.maisprati.codifica.alucar.Models.Users.RenterUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

//Abstraction of the JPA Hibernate DAO and C.R.U.D functions
@Repository
public interface
RenterUserRepository extends JpaRepository<RenterUser, Long> , GenericUserRepository {

    // JPQL
    @Query("SELECT p FROM RenterUser p WHERE p.email = :email")
    RenterUser findRenterUserByEmail(@Param("email") String email);

    @Query  ("UPDATE RenterUser p SET" +
            " p.name = :newName , p.email = :newEmail , " +
            " p.phone = :newPhone , p.location = :newLocation , " +
            " p.photo = :newPhoto , p.instagram = :newInstagram " +
            " WHERE p.id = :id ")
    void Repository_Update_Renter_User
            (@Param("parameterId") Long id,
             @Param("parameterNewName") String newName,
             @Param("paremeterNewEmail") String newEmail,
             @Param("parameterNewPhone") String newPhone,
             @Param("parameterNewLocation") String newLocation,
             @Param("paramterNewPhoto") byte[] newPhoto,
             @Param("parameterNewInstagram") String newInstagram);
}
