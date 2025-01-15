package com.maisprati.codifica.alucar.Services.Users;

import com.maisprati.codifica.alucar.Models.Users.RenterUser;
import com.maisprati.codifica.alucar.Repository.DB.Users.RenterUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.function.Predicate;

import static com.maisprati.codifica.alucar.Lambdas.lbd.*;
import static com.maisprati.codifica.alucar.Repository.DB.Users.GenericUserRepository.*;

@Service
public class RenterUserService {
    public Predicate<String> check_available_email = (parameter_email) -> FindRenterUserByEmail(parameter_email) == null;

    @SuppressWarnings({"unchecked","rawtypes"})
    public void InsertRenterUser(RenterUser renterUser) {
        insert_data.apply((JpaRepository)renterUserRepository , renterUser);
    }

    @SuppressWarnings({"unchecked","rawtypes","unused"})
    public RenterUser FindRenterUserById(Long parameter_id){
        return (RenterUser) find_data_by_id.apply((JpaRepository)renterUserRepository , parameter_id);
    }

    public RenterUser FindRenterUserByEmail(String parameter_email){
        return (RenterUser) get_user_by_email.apply(renterUserRepository , parameter_email);
    }

    @SuppressWarnings({"unchecked","rawtypes","unused"})
    public void DeleteRenterUserById(Long parameter_id){delete_data_by_id.accept((JpaRepository) renterUserRepository , parameter_id);}

    @Autowired
    public void setRenterUserRepository(RenterUserRepository renterUserRepository) {
        this.renterUserRepository = renterUserRepository;
    }RenterUserRepository renterUserRepository;
}
