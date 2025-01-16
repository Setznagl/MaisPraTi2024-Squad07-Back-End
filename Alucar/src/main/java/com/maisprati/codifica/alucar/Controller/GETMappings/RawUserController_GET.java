package com.maisprati.codifica.alucar.Controller.GETMappings;

import com.maisprati.codifica.alucar.Models.Users.RawUser;
import com.maisprati.codifica.alucar.Services.Users.RawUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RawUserController_GET {

    @GetMapping("get-r-user")
    public ResponseEntity<RawUser> getRawUser_ByEmail(@RequestParam("email") String parameter_email) {
           boolean check_one = rawUserService.check_available_email.test(parameter_email);
           boolean check_two = rawUserService.check_email_from_rawuser.test(parameter_email);
       if (!check_one && check_two){RawUser target = rawUserService.FindRawUserByEmail(parameter_email);
              return ResponseEntity.ok(target);
       }else {return ResponseEntity.notFound().build();}
    }


    @Autowired
    public RawUserController_GET(RawUserService rawUserService) {
        this.rawUserService = rawUserService;
    }private final RawUserService rawUserService;
}
