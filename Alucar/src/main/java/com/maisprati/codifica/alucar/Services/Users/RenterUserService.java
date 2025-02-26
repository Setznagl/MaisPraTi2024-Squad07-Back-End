package com.maisprati.codifica.alucar.Services.Users;

import com.maisprati.codifica.alucar.Models.Users.RenterUser;
import com.maisprati.codifica.alucar.Repository.DB.Users.RenterUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.function.Predicate;

import static com.maisprati.codifica.alucar.Lambdas.lbd.*;
import static com.maisprati.codifica.alucar.Lambdas.GenericUserRepository.*;

@Service
public class RenterUserService {
    @Autowired
    public void setRenterUserRepository(RenterUserRepository renterUserRepository) {
        this.renterUserRepository = renterUserRepository;
    }RenterUserRepository renterUserRepository;
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //CRUD - Create
    @SuppressWarnings({"unchecked","rawtypes"})
    public void InsertRenterUser(RenterUser renterUser) {
        insert_data.apply((JpaRepository)renterUserRepository , renterUser);
    }

    //CRUD - Read
    @SuppressWarnings({"unchecked","rawtypes","unused"})
    public RenterUser FindRenterUserById(Long parameter_id){
        return (RenterUser) find_data_by_id.apply((JpaRepository)renterUserRepository , parameter_id);
    }

    //CRUD - Read
    public RenterUser FindRenterUserByEmail(String parameter_email){
        return (RenterUser) get_user_by_email.apply(renterUserRepository , parameter_email);
    }

    //CRUD - Update
    public void UpdateRenterUser(RenterUser submittedUser){
        //Besides the ID is the same the submitted data probably will change
        RenterUser previousData = FindRenterUserById(submittedUser.getId());
        //Submit to lambda validate changes, null field new values will return previous actual data
        RenterUser treatedData = treat_renter_update.apply(previousData, submittedUser);
        try {renterUserRepository.save(treatedData);}
        catch (Exception e){System.out.println(e.getMessage());}
    }

    //CRUD - Delete
    public void DeleteRenterUserById(Long parameter_id) throws HttpClientErrorException {
        RenterUser temp = FindRenterUserById(parameter_id);
        if(temp != null){
            try{renterUserRepository.delete(temp);}
            catch (Exception e){throw new HttpClientErrorException(
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    e.getMessage());}
        }else{throw new HttpClientErrorException(HttpStatus.NOT_FOUND);}
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public Predicate<String> check_available_email = (parameter_email) -> FindRenterUserByEmail(parameter_email) == null;
    public Predicate<String> check_email_from_renteruser = (parameter_email ) -> {
        RenterUser extracted_user = FindRenterUserByEmail(parameter_email);
        boolean not_null_user = extracted_user != null;
        if(not_null_user){
            RenterUser example = new RenterUser("","","");
            return extracted_user.equals(example);
        } else return false;
    };

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
}
