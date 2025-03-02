package com.maisprati.codifica.alucar.Lambdas;

import com.maisprati.codifica.alucar.Models.Users.DriverUser;
import com.maisprati.codifica.alucar.Models.Users.RawUser;
import com.maisprati.codifica.alucar.Models.Users.RenterUser;
import com.maisprati.codifica.alucar.Repository.DB.Users.DriverUserRepository;
import com.maisprati.codifica.alucar.Repository.DB.Users.RawUserRepository;
import com.maisprati.codifica.alucar.Repository.DB.Users.RenterUserRepository;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

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
    BiFunction<GenericUserRepository,Long, Object> get_user_by_id = (jparepository , parameter_id) -> {
        if (jparepository instanceof RawUserRepository conversion){
            return conversion.findRawUserByID(parameter_id);
        }else
        if (jparepository instanceof DriverUserRepository conversion) {
            return conversion.findDriverUserByID(parameter_id);
        }else
        if (jparepository instanceof RenterUserRepository conversion) {
            return conversion.findRenterUserByID(parameter_id);
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
        DriverUser treatedData = new DriverUser(" ", " ", " ");
        treatedData.setId(previousData.getId());
        if (submittedChanges.getName() == null) {treatedData.setName(previousData.getName());}
            else {treatedData.setName(submittedChanges.getName());}
        if (submittedChanges.getEmail() == null) {treatedData.setEmail(previousData.getEmail());}
            else {treatedData.setEmail(submittedChanges.getEmail());}
        if (submittedChanges.getPhone() == null) {treatedData.setPhone(previousData.getPhone());}
            else {treatedData.setPhone(submittedChanges.getPhone());}
        if (submittedChanges.getLocation() == null) {treatedData.setLocation(previousData.getLocation());}
            else {treatedData.setLocation(submittedChanges.getLocation());}
        if (submittedChanges.getPhoto() == null) {treatedData.setPhoto(previousData.getPhoto());}
            else {treatedData.setPhoto(submittedChanges.getPhoto());}
        if (submittedChanges.getInstagram() == null) {treatedData.setInstagram(previousData.getInstagram());}
            else {treatedData.setInstagram(submittedChanges.getInstagram());}
        if (submittedChanges.getCriminal_record() == null) {treatedData.setCriminal_record(previousData.getCriminal_record());}
            else {treatedData.setCriminal_record(submittedChanges.getCriminal_record());
        if (submittedChanges.getCnh() == null) {treatedData.setCnh(previousData.getCnh());}
            else {treatedData.setCnh(submittedChanges.getCnh());}
        if (submittedChanges.getCnh_expiration_date() == null) {treatedData.setCnh_expiration_date(previousData.getCnh_expiration_date());}
            else {treatedData.setCnh_expiration_date(submittedChanges.getCnh_expiration_date());}
        treatedData.setVerified(submittedChanges.getCnh() != null && submittedChanges.getCnh_expiration_date() != null && submittedChanges.getCriminal_record() != null);}
        return treatedData;
    };
    BiFunction<RenterUser, RenterUser, RenterUser> treat_renter_update = (previousData, submittedChanges) -> {
        RenterUser treatedData = new RenterUser(" "," "," ");
        treatedData.setId(previousData.getId());
        if(submittedChanges.getName() == null){treatedData.setName(previousData.getName());}
            else {treatedData.setName(submittedChanges.getName());}
        if(submittedChanges.getEmail() == null){treatedData.setEmail(previousData.getEmail());}
            else {treatedData.setEmail(submittedChanges.getEmail());}
        if(submittedChanges.getPhone() == null){treatedData.setPhone(previousData.getPhone());}
            else {treatedData.setPhone(submittedChanges.getPhone());}
        if(submittedChanges.getLocation() == null){treatedData.setLocation(previousData.getLocation());}
            else {treatedData.setLocation(submittedChanges.getLocation());}
        if(submittedChanges.getPhoto() == null){treatedData.setPhoto(previousData.getPhoto());}
            else {treatedData.setPhoto(submittedChanges.getPhoto());}
        if(submittedChanges.getInstagram() == null){treatedData.setInstagram(previousData.getInstagram());}
            else {treatedData.setInstagram(submittedChanges.getInstagram());}
        return treatedData;
    };

    Supplier<RenterUser> equals_comparable_renter = () -> {
        return new RenterUser(" "," "," ");
    };
}
