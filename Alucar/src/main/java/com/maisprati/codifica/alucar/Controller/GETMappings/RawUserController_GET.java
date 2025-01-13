package com.maisprati.codifica.alucar.Controller.GETMappings;

import com.maisprati.codifica.alucar.Models.Users.RawUser;
import com.maisprati.codifica.alucar.Services.Users.RawUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class RawUserController_GET {

    @GetMapping("get-r-user")
    public ResponseEntity<RawUser> getRawUser_ByEmail(@RequestParam("email") String parameter_email) {
       Optional<RawUser> target = Optional.ofNullable(rawUserService.FindRawUserByEmail(parameter_email));
            return target.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    };

    @Autowired
    public RawUserController_GET(RawUserService rawUserService) {
        this.rawUserService = rawUserService;
    }private final RawUserService rawUserService;
}
