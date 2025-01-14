package com.maisprati.codifica.alucar.Controller.GETMappings;

import com.maisprati.codifica.alucar.Models.Users.DriverUser;
import com.maisprati.codifica.alucar.Services.Users.DriverUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class DriverUserController_GET {

    @GetMapping("get-d-user")
    public ResponseEntity<DriverUser>  getDriverUser_ByEmail(@RequestParam("email") String parameter_email) {
        Optional<DriverUser> target = Optional.ofNullable(driverUserService.FindDriverUserByEmail(parameter_email));
        return target.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    };


    @Autowired
    public DriverUserController_GET(DriverUserService driverUserService) {
        this.driverUserService = driverUserService;
    }private final DriverUserService driverUserService;
}
