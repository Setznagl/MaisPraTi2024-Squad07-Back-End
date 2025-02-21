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
    @Autowired
    public void setRenterUserRepository(RenterUserRepository renterUserRepository) {
        this.renterUserRepository = renterUserRepository;
    }RenterUserRepository renterUserRepository;
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

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

    public void UpdateRenterUser(RenterUser submittedUser){
        //Besides the ID is the same the submitted data probably will change
        RenterUser previousData = FindRenterUserById(submittedUser.getId());
        //Submit to lambda validate changes, null field new values will return previous actual data
        RenterUser treatedData = treat_renter_update.apply(previousData, submittedUser);

        renterUserRepository.Repository_Update_Renter_User(
                treatedData.getId(),
                treatedData.getName(),
                treatedData.getEmail(),
                treatedData.getPhone(),
                treatedData.getLocation(),
                treatedData.getPhoto(),
                treatedData.getInstagram()
        );
      }

    @SuppressWarnings({"unchecked","rawtypes","unused"})
    public void DeleteRenterUserById(Long parameter_id){delete_data_by_id.accept((JpaRepository) renterUserRepository , parameter_id);}

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
