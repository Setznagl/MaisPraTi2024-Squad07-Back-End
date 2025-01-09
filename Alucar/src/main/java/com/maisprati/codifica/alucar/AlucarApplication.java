package com.maisprati.codifica.alucar;

import com.maisprati.codifica.alucar.Models.Users.RawUser;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AlucarApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(AlucarApplication.class, args);
    }

    @Override
    public void run(String... args){
        RawUser Teste01 = new RawUser("C" , "G" , "A");

        System.out.println(Teste01);
    }
}
