package com.maisprati.codifica.alucar.Repository.DB.Users;

import com.maisprati.codifica.alucar.Models.Users.RawUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.function.BiFunction;
import java.util.function.BiPredicate;

//Abstraction of the JPA Hibernate DAO and C.R.U.D functions
@Repository
public interface RawUserRepository extends JpaRepository<RawUser, Long> , GenericUserRepository{

    // JPQL
    @Query("SELECT p FROM RawUser p WHERE p.email = :email")
    RawUser findRawUserByEmail(@Param("email") String email);
}

