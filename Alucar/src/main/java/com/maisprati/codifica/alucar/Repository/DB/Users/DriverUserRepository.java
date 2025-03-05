package com.maisprati.codifica.alucar.Repository.DB.Users;

import com.maisprati.codifica.alucar.Lambdas.GenericUserRepository;
import com.maisprati.codifica.alucar.Models.UserTypes.DriverUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

//Abstraction of the JPA Hibernate DAO and C.R.U.D functions
@Repository
public interface DriverUserRepository extends JpaRepository<DriverUser , Long> , GenericUserRepository {

    // JPQL
    @Query("SELECT p FROM DriverUser p WHERE p.email = :email")
    DriverUser findDriverUserByEmail(@Param("email") String email);

    // JPQL
    @Query("SELECT p FROM DriverUser p WHERE p.id = :id")
    DriverUser findDriverUserByID(@Param("id") Long id);
}
