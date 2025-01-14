package com.maisprati.codifica.alucar.Repository.DB.Users;

import com.maisprati.codifica.alucar.Models.Users.DriverUser;
import com.maisprati.codifica.alucar.Models.Users.RawUser;

import java.util.function.BiFunction;
import java.util.function.Function;

public interface GenericUserRepository{

    /**
     * conversion é uma variável de conversão, equivale a " RawUserRepository conversion = (RawUserRepository) jparepository; "
     */
    BiFunction<GenericUserRepository,String, Object> get_user_by_email = (jparepository , parameter_email) -> {
        if (jparepository instanceof RawUserRepository conversion){
            return conversion.findRawUserByEmail(parameter_email);
        }else
        if (jparepository instanceof DriverUserRepository conversion) {
            return conversion.findDriverUserByEmail(parameter_email);
        }else
        if (jparepository instanceof RenterUserRepository conversion) {
            return conversion.findRenterUserByEmail(parameter_email);
        }
        else return null;
    };
    Function<RawUser , DriverUser> conversion_raw_to_driver_user = (parameterRawUser) ->{
        DriverUser temp = new DriverUser(parameterRawUser.getName(), parameterRawUser.getEmail(), parameterRawUser.getPassword());
            temp.setId(parameterRawUser.getId());
            temp.setCpf(parameterRawUser.getCpf());
            temp.setBirthdate(parameterRawUser.getBirthdate());
            temp.setPhone(parameterRawUser.getPhone());
            temp.setAverage_rating(parameterRawUser.getAverage_rating());
            temp.setCreated_at(parameterRawUser.getCreated_at());
            temp.setPhoto(parameterRawUser.getPhoto());
        return temp;
    };
}
