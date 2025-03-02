package com.maisprati.codifica.alucar.Controller.POSTMappings;

import com.maisprati.codifica.alucar.Models.Users.RawUser;
import com.maisprati.codifica.alucar.Services.Users.RawUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RawUserController_POST {

    @PostMapping
    @RequestMapping("/account/create")
    public ResponseEntity<Void> createRawUser(@RequestBody RawUser parameter_rawuser) {
        boolean check = rawUserService.check_available_email.test(parameter_rawuser.getEmail());
        if(check){
           rawUserService.InsertRawUser(parameter_rawuser);
           return ResponseEntity.status(HttpStatus.CREATED).build();
        }else{return ResponseEntity.status(HttpStatus.IM_USED).build();}
    }


    @Autowired
    public RawUserController_POST(RawUserService rawUserService) {
        this.rawUserService = rawUserService;
    }private final RawUserService rawUserService;
}
