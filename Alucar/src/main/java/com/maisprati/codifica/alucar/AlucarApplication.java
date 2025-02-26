package com.maisprati.codifica.alucar;

import com.maisprati.codifica.alucar.Repository.DB.Users.RawUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AlucarApplication implements CommandLineRunner {

    @Autowired
    RawUserRepository rawUserRepository;

    public static void main(String[] args) {
        SpringApplication.run(AlucarApplication.class, args);
    }

    @Override
    public void run(String... args) {
        rawUserRepository.deleteAll();
    }

}
