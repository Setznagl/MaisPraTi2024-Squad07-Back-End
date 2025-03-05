package com.maisprati.codifica.alucar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class AlucarApplication implements CommandLineRunner {

    @Autowired
    public AlucarApplication(ApplicationArguments springApplicationArguments, Environment enviroment) {
        this.springApplicationArguments = springApplicationArguments;
        this.env = enviroment;
    }private final ApplicationArguments springApplicationArguments;private final Environment env;


    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(AlucarApplication.class);
        app.setAdditionalProfiles("test"); // Define o perfil ativo como "test"
        app.run(args);
    }

    @Override
    public void run(String... args) throws Exception {
        String[] activeProfiles = env.getActiveProfiles();
        System.out.println("\nSelected Profile: " + String.join(", ", activeProfiles) + "\n");
    }

    //spring.profiles.active=test
}
