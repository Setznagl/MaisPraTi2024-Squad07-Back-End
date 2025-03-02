package com.maisprati.codifica.alucar.Services.Users;

import com.maisprati.codifica.alucar.Exceptions.NotFoundDataException;
import com.maisprati.codifica.alucar.Models.Users.DriverUser;
import com.maisprati.codifica.alucar.Repository.DB.Users.DriverUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.function.Predicate;

import static com.maisprati.codifica.alucar.Lambdas.GenericUserRepository.*;

@Service
public class DriverUserService {
    @Autowired
    public void setDriverUserRepository(DriverUserRepository driverUserRepository) {
        this.driverUserRepository = driverUserRepository;
    }DriverUserRepository driverUserRepository;
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //CRUD - Create
    public void InsertDriverUser(DriverUser parameter_driveruser){
        driverUserRepository.save(parameter_driveruser);
    }

    //CRUD - Read
    public DriverUser FindDriverUserById(Long parameter_id){
        return (DriverUser) get_user_by_id.apply(driverUserRepository , parameter_id);
    }

    //CRUD - Read
    public DriverUser FindDriverUserByEmail(String parameter_email){
        return (DriverUser) get_user_by_email.apply(driverUserRepository , parameter_email);
    }

    //CRUD - Update
    public void UpdateDriverUser(DriverUser submittedUser){
        //Besides the ID is the same the submitted data can be changed
        DriverUser previousData = FindDriverUserById(submittedUser.getId());
        //Submit to lambda validate changes, null field new values will return previous actual data
        DriverUser treatedData = treat_driver_update.apply(previousData, submittedUser);
        driverUserRepository.save(treatedData);
    }

    //CRUD - Delete
    public void DeleteDriverUserById(Long parameter_id) throws HttpClientErrorException {
        DriverUser temp = driverUserRepository.findDriverUserByID(parameter_id);
        if(temp != null){driverUserRepository.delete(temp);
        }else {throw new NotFoundDataException("driver user with this id was not found");}
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public Predicate<String> check_available_email = (parameter_email) -> FindDriverUserByEmail(parameter_email) == null;
    public Predicate<String> check_email_from_driveruser = (parameter_email ) -> {
        DriverUser extracted_user = FindDriverUserByEmail(parameter_email);
        boolean not_null_user = extracted_user != null;
        if(not_null_user){
            DriverUser example = new DriverUser("","","");
            return extracted_user.equals(example);
        } else return false;
    };

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
}
