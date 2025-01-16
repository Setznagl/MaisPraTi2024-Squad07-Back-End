package com.maisprati.codifica.alucar.Services.Users;

import com.maisprati.codifica.alucar.Models.Users.RawUser;
import com.maisprati.codifica.alucar.Repository.DB.Users.RawUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.function.Predicate;

import static com.maisprati.codifica.alucar.Lambdas.lbd.*;
import static com.maisprati.codifica.alucar.Repository.DB.Users.RawUserRepository.*;

@Service
public class RawUserService {
    @Autowired
    public void setRawUserRepository(RawUserRepository rawUserRepository) {
        this.rawUserRepository = rawUserRepository;
    }RawUserRepository rawUserRepository;
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @SuppressWarnings({"unchecked","rawtypes"})
    public void InsertRawUser(RawUser parameter_rawuser){
        insert_data.apply((JpaRepository)rawUserRepository , parameter_rawuser);
    }

    @SuppressWarnings({"unchecked","rawtypes","unused"})
    public RawUser FindRawUserById(Long parameter_id){
        return (RawUser) find_data_by_id.apply((JpaRepository)rawUserRepository , parameter_id);
    }

    public RawUser FindRawUserByEmail(String parameter_email){
        return (RawUser) get_user_by_email.apply(rawUserRepository , parameter_email);
    }

    @SuppressWarnings({"unchecked","rawtypes"})
    public void DeleteRawUserById(Long parameter_id){delete_data_by_id.accept((JpaRepository) rawUserRepository , parameter_id);}

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public Predicate<String> check_available_email = (parameter_email ) -> FindRawUserByEmail(parameter_email) == null;

    /**
     * Método Equals() sobrescrito da classe RawUser compara a classe para retornar se é igual ou não, caso sejam duas
     * classes distintas irá retornar false e negar o acesso ao get-email por rotas GET de outros tipos de usuário
     */
    public Predicate<String> check_email_from_rawuser = (parameter_email ) -> {
        RawUser extracted_user = FindRawUserByEmail(parameter_email);
        boolean not_null_user = extracted_user != null;
        if(not_null_user){
            RawUser example = new RawUser("","","");
            return extracted_user.equals(example);
        } else return false;
    };

}
