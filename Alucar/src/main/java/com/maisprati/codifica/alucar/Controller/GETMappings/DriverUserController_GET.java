package com.maisprati.codifica.alucar.Controller.GETMappings;

import com.maisprati.codifica.alucar.Exceptions.NotFoundDataException;
import com.maisprati.codifica.alucar.Models.Users.DriverUser;
import com.maisprati.codifica.alucar.Services.Users.DriverUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DriverUserController_GET {

    //GET using Email
    @GetMapping("/get-d-user")
    public ResponseEntity<DriverUser> getDriverUser_ByEmail(@RequestParam("email") String parameter_email) {
            boolean check_one = driverUserService.check_available_email.test(parameter_email);
            boolean check_two = driverUserService.check_email_from_driveruser.test(parameter_email);
        if (!check_one && check_two){DriverUser target = driverUserService.FindDriverUserByEmail(parameter_email);
               return ResponseEntity.ok(target);
        }else {throw new NotFoundDataException("this driver user does not exist");}
    }

    //GET using ID
    @GetMapping("/get-d-user/id/")
    public ResponseEntity<DriverUser> getDriverUser_ByID(@RequestParam("id") Long parameter_id) {
        DriverUser temp = driverUserService.FindDriverUserById(parameter_id);
        if(temp != null){return ResponseEntity.ok(temp);}
        else{throw new NotFoundDataException("this driver user does not exist");}
    }


    @Autowired
    public DriverUserController_GET(DriverUserService driverUserService) {
        this.driverUserService = driverUserService;
    }private final DriverUserService driverUserService;
}
