package com.maisprati.codifica.alucar.Services.Users;

import com.maisprati.codifica.alucar.Models.Users.DriverUser;
import com.maisprati.codifica.alucar.Repository.DB.Users.DriverUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.function.Predicate;

import static com.maisprati.codifica.alucar.Lambdas.lbd.find_data_by_id;
import static com.maisprati.codifica.alucar.Lambdas.lbd.insert_data;
import static com.maisprati.codifica.alucar.Repository.DB.Users.GenericUserRepository.get_user_by_email;

@Service
public class DriverUserService {

    @SuppressWarnings({"unchecked" , "rawtypes"})
    public void InsertDriverUser(DriverUser parameter_driveruser){
        insert_data.apply((JpaRepository)driverUserRepository , parameter_driveruser);
    }

    @SuppressWarnings({"unchecked" , "rawtypes"})
    public void FindDriverUserById(Long parameter_id){
        find_data_by_id.apply((JpaRepository)driverUserRepository , parameter_id);
    }

    public DriverUser FindDriverUserByEmail(String parameter_email){
        return (DriverUser) get_user_by_email.apply(driverUserRepository , parameter_email);
    }

    public Predicate<String> check_available_email = (parameter_email) ->
            FindDriverUserByEmail(parameter_email) == null;

    @Autowired
    public void setDriverUserRepository(DriverUserRepository driverUserRepository) {
        this.driverUserRepository = driverUserRepository;
    }DriverUserRepository driverUserRepository;
}
