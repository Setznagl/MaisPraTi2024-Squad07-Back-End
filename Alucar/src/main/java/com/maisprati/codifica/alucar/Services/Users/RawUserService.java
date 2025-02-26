package com.maisprati.codifica.alucar.Services.Users;

import com.maisprati.codifica.alucar.Models.Users.RawUser;
import com.maisprati.codifica.alucar.Repository.DB.Users.RawUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.function.Predicate;

import static com.maisprati.codifica.alucar.Repository.DB.Users.RawUserRepository.*;

@Service
public class RawUserService {
    @Autowired
    public void setRawUserRepository(RawUserRepository rawUserRepository) {
        this.rawUserRepository = rawUserRepository;
    }RawUserRepository rawUserRepository;
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //CRUD - Create
    public void InsertRawUser(RawUser parameter_rawuser){rawUserRepository.save(parameter_rawuser);}

    //CRUD - Read
    public RawUser FindRawUserById(Long parameter_id){
        return (RawUser) get_user_by_id.apply(rawUserRepository , parameter_id);
    }

    //CRUD - Read
    public RawUser FindRawUserByEmail(String parameter_email){
        return (RawUser) get_user_by_email.apply(rawUserRepository , parameter_email);
    }

    //CRUD - Delete
    public void DeleteRawUserById(Long parameter_id) throws HttpClientErrorException{
        RawUser temp = rawUserRepository.findRawUserByID(parameter_id);
        if(temp != null){
            try {rawUserRepository.delete(temp);}
            catch (Exception e){throw new HttpClientErrorException(
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    e.getMessage());}
        }else{throw new HttpClientErrorException(HttpStatus.NOT_FOUND);}
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public Predicate<String> check_available_email = (parameter_email ) -> FindRawUserByEmail(parameter_email) == null;
    public Predicate<String> check_email_from_rawuser = (parameter_email ) -> {
        RawUser extracted_user = FindRawUserByEmail(parameter_email);
        boolean not_null_user = extracted_user != null;
        if(not_null_user){
            RawUser example = new RawUser("","","");
            return extracted_user.equals(example);
        } else return false;
    };

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
}
