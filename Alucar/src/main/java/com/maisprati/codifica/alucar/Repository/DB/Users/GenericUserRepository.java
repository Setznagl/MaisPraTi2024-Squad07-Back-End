package com.maisprati.codifica.alucar.Repository.DB.Users;

import com.maisprati.codifica.alucar.Models.Users.DriverUser;
import com.maisprati.codifica.alucar.Models.Users.RawUser;
import com.maisprati.codifica.alucar.Models.Users.RenterUser;

import java.util.function.BiFunction;
import java.util.function.Function;

public interface GenericUserRepository{

    BiFunction<GenericUserRepository,String, Object> get_user_by_email = (jparepository , parameter_email) -> {
        if (jparepository instanceof RawUserRepository conversion){
            return conversion.findRawUserByEmail(parameter_email);
        }else
        if (jparepository instanceof DriverUserRepository conversion) {
            return conversion.findDriverUserByEmail(parameter_email);
        }else
        if (jparepository instanceof RenterUserRepository conversion) {
            return conversion.findRenterUserByEmail(parameter_email);
        } else return null;
    };

    Function<RawUser , DriverUser> conversion_raw_to_driver_user = (parameterRawUser) ->{
        DriverUser temp = new DriverUser(parameterRawUser.getName(), parameterRawUser.getEmail(), parameterRawUser.getPassword());
            temp.setCpf(parameterRawUser.getCpf());
            temp.setBirthdate(parameterRawUser.getBirthdate());
            temp.setPhone(parameterRawUser.getPhone());
            temp.setAverage_rating(parameterRawUser.getAverage_rating());
            temp.setCreated_at(parameterRawUser.getCreated_at());
            temp.setPhoto(parameterRawUser.getPhoto());
        return temp;
    };
    Function<RawUser , RenterUser> conversion_raw_to_renter_user = (parameterRawUser) ->{
        RenterUser temp = new RenterUser(parameterRawUser.getName(), parameterRawUser.getEmail(), parameterRawUser.getPassword());
        temp.setCpf(parameterRawUser.getCpf());
        temp.setBirthdate(parameterRawUser.getBirthdate());
        temp.setPhone(parameterRawUser.getPhone());
        temp.setAverage_rating(parameterRawUser.getAverage_rating());
        temp.setCreated_at(parameterRawUser.getCreated_at());
        temp.setPhoto(parameterRawUser.getPhoto());
        return temp;
    };

    BiFunction<DriverUser, DriverUser, DriverUser> treat_driver_update = (previousData, submittedChanges) -> {
        DriverUser treatedData = new DriverUser(" "," "," ");
            if(submittedChanges.getName() == null){treatedData.setName(previousData.getName());}
            if(submittedChanges.getEmail() == null){treatedData.setEmail(previousData.getEmail());}
            if(submittedChanges.getPhone() == null){treatedData.setPhone(previousData.getPhone());}
            if(submittedChanges.getLocation() == null){treatedData.setLocation(previousData.getLocation());}
            if(submittedChanges.getPhoto() == null){treatedData.setPhoto(previousData.getPhoto());}
            if(submittedChanges.getInstagram() == null){treatedData.setInstagram(previousData.getInstagram());}
            if(submittedChanges.getCriminal_record() == null){treatedData.setCriminal_record(previousData.getCriminal_record());}
            if(submittedChanges.getCnh() == null){treatedData.setCnh(previousData.getCnh());}
            if(submittedChanges.getCnh_expiration_date() == null){treatedData.setCnh_expiration_date(previousData.getCnh_expiration_date());}
                if(submittedChanges.getCnh() != null &&
                   submittedChanges.getCnh_expiration_date() != null &&
                   submittedChanges.getCriminal_record() != null
                ){treatedData.setVerified(true);}
        return treatedData;
    };
    BiFunction<RenterUser, RenterUser, RenterUser> treat_renter_update = (previousData, submittedChanges) -> {
        RenterUser treatedData = new RenterUser(" "," "," ");
        if(submittedChanges.getName() == null){treatedData.setName(previousData.getName());}
        if(submittedChanges.getEmail() == null){treatedData.setEmail(previousData.getEmail());}
        if(submittedChanges.getPhone() == null){treatedData.setPhone(previousData.getPhone());}
        if(submittedChanges.getLocation() == null){treatedData.setLocation(previousData.getLocation());}
        if(submittedChanges.getPhoto() == null){treatedData.setPhoto(previousData.getPhoto());}
        if(submittedChanges.getInstagram() == null){treatedData.setInstagram(previousData.getInstagram());}
        return treatedData;
    };

}
