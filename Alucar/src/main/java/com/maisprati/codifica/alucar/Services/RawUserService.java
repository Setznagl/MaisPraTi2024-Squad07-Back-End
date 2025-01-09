package com.maisprati.codifica.alucar.Services;

import com.maisprati.codifica.alucar.Models.Users.RawUser;
import com.maisprati.codifica.alucar.Repository.DB.Users.RawUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.function.Consumer;

@Service
public class RawUserService {

    RawUserRepository rawUserRepository;

    public void InsertRawUser(RawUser parameter_rawuser){
        Consumer<RawUserRepository> consumer = repository -> repository.save(parameter_rawuser);
        rawUserRepository.save(parameter_rawuser);
    }

    @Autowired
    public void setRawUserRepository(RawUserRepository rawUserRepository) {
        this.rawUserRepository = rawUserRepository;
    }
}
