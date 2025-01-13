package com.maisprati.codifica.alucar.Services.Users;

import com.maisprati.codifica.alucar.Models.Users.RawUser;
import com.maisprati.codifica.alucar.Repository.DB.Users.RawUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import static com.maisprati.codifica.alucar.Lambdas.lbd.*;
import static com.maisprati.codifica.alucar.Repository.DB.Users.RawUserRepository.*;

@Service
public class RawUserService {

    @SuppressWarnings({"unchecked" , "rawtypes"})
    public void InsertRawUser(RawUser parameter_rawuser){
        insert_data.apply((JpaRepository)rawUserRepository , parameter_rawuser);
    }

    @SuppressWarnings({"unchecked" , "rawtypes"})
    public void FindRawUserById(Long parameter_id){
        find_data_by_id.apply((JpaRepository)rawUserRepository , parameter_id);
    }

    public RawUser FindRawUserByEmail(String parameter_email){
        return get_user_by_email.apply(rawUserRepository , parameter_email);
    }

    @Autowired
    public void setRawUserRepository(RawUserRepository rawUserRepository) {
        this.rawUserRepository = rawUserRepository;
    }RawUserRepository rawUserRepository;
}
