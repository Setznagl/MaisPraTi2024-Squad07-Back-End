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
public interface RawUserRepository extends JpaRepository<RawUser, Long>{

    // JPQL
    @Query("SELECT p FROM RawUser p WHERE p.email = :email")
    RawUser findByEmail(@Param("email") String email);

    //@Query("UPDATE RawUser p SET p.name = :newName WHERE p.id = :id")
    //Void updateName(@Param("id") Long id, @Param("novoNome") String newName);

    BiPredicate<RawUserRepository,String> check_available_email = (jparepository , parameter_email ) -> {
        return jparepository.findByEmail(parameter_email) == null;
    };

    BiFunction<RawUserRepository,String, RawUser> get_user_by_email = RawUserRepository::findByEmail;
}


