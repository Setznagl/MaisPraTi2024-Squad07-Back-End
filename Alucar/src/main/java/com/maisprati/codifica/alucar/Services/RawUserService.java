package com.maisprati.codifica.alucar.Services;

import com.maisprati.codifica.alucar.Models.Users.RawUser;
import com.maisprati.codifica.alucar.Repository.DB.Users.RawUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import static com.maisprati.codifica.alucar.Lambdas.lbd.insert_data;

@Service
public class RawUserService {

    @SuppressWarnings({"unchecked" , "rawtypes"})
    public void InsertRawUser(RawUser parameter_rawuser){ insert_data.apply((JpaRepository)rawUserRepository , parameter_rawuser);}

    RawUserRepository rawUserRepository;
    @Autowired
    public void setRawUserRepository(RawUserRepository rawUserRepository) {
        this.rawUserRepository = rawUserRepository;
    }
}
