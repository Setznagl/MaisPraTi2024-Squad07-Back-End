package com.maisprati.codifica.alucar.Controller.POSTMappings;

import com.maisprati.codifica.alucar.Models.Users.RawUser;
import com.maisprati.codifica.alucar.Repository.DB.Users.RawUserRepository;
import com.maisprati.codifica.alucar.Services.Users.RawUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.maisprati.codifica.alucar.Repository.DB.Users.RawUserRepository.*;

@RestController
@RequestMapping("/account")
public class RawUserController_POST {

    @PostMapping
    @RequestMapping("/create")
    public ResponseEntity<Void> createRawUser(@RequestBody RawUser parameter_rawuser) {
        boolean check = check_available_email.test(rawUserRepository , parameter_rawuser.getEmail());
            if (check) {
                rawUserService.InsertRawUser(parameter_rawuser);
                return ResponseEntity.status(HttpStatus.CREATED).build();
            }
            else {
                return ResponseEntity.status(HttpStatus.IM_USED).build();
            }
    }




    @Autowired
    public RawUserController_POST(RawUserService rawUserService , RawUserRepository rawUserRepository) {
        this.rawUserService = rawUserService;
        this.rawUserRepository = rawUserRepository;
    }private final RawUserService rawUserService;private final RawUserRepository rawUserRepository;
}
