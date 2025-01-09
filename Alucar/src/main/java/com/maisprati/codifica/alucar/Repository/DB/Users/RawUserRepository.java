package com.maisprati.codifica.alucar.Repository.DB.Users;

import com.maisprati.codifica.alucar.Models.Users.RawUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RawUserRepository extends JpaRepository<RawUser, Long> {
    //Abstraction of the JPA Hibernate DAO and C.R.U.D functions
}


