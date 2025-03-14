package com.maisprati.codifica.alucar.Repository.DB.Users;

import com.maisprati.codifica.alucar.Lambdas.GenericUserRepository;
import com.maisprati.codifica.alucar.Models.UserTypes.RenterUser;
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

    // JPQL
    @Query("SELECT p FROM RenterUser p WHERE p.id = :id")
    RenterUser findRenterUserByID(@Param("id") Long id);
}
