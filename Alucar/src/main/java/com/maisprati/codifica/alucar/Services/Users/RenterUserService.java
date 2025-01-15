package com.maisprati.codifica.alucar.Services.Users;

import com.maisprati.codifica.alucar.Repository.DB.Users.RenterUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RenterUserService {


    @Autowired
    public void setRenterUserRepository(RenterUserRepository renterUserRepository) {
        this.renterUserRepository = renterUserRepository;
    }RenterUserRepository renterUserRepository;
}
