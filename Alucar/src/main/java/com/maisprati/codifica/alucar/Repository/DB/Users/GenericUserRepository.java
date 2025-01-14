package com.maisprati.codifica.alucar.Repository.DB.Users;

import com.maisprati.codifica.alucar.Models.Users.RawUser;

import java.util.function.BiFunction;
import java.util.function.BiPredicate;

public interface GenericUserRepository{

    /**
     * conversion é uma variável de conversão, equivale a " RawUserRepository conversion = (RawUserRepository) jparepository; "
     */
    BiFunction<GenericUserRepository,String, RawUser> get_user_by_email = (jparepository , parameter_email) -> {
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
    BiPredicate<GenericUserRepository, String> check_available_email = (jparepository , parameter_email ) -> {
        if(jparepository instanceof RawUserRepository conversion){
            return conversion.findRawUserByEmail(parameter_email) == null;
        }else
        if (jparepository instanceof DriverUserRepository conversion) {
            return conversion.findDriverUserByEmail(parameter_email) == null;
        }else
        if (jparepository instanceof RenterUserRepository conversion) {
            return conversion.findRenterUserByEmail(parameter_email) == null;
        }
        else return false;
    };

}
