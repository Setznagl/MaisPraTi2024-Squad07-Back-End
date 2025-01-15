package com.maisprati.codifica.alucar.Controller.GETMappings;

import com.maisprati.codifica.alucar.Models.Users.RenterUser;
import com.maisprati.codifica.alucar.Services.Users.RenterUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RenterUserController_GET {

    @GetMapping("get-re-user")
    public ResponseEntity<RenterUser> getDriverUser_ByEmail(@RequestParam("email") String parameter_email) {
        boolean check = renterUserService.check_available_email.test(parameter_email);
        if (!check){ RenterUser target = renterUserService.FindRenterUserByEmail(parameter_email);
            return ResponseEntity.ok(target);
        }else {return ResponseEntity.notFound().build();}
    }


    @Autowired
    public RenterUserController_GET(RenterUserService renterUserService) {
        this.renterUserService = renterUserService;
    }private final RenterUserService renterUserService;
}
