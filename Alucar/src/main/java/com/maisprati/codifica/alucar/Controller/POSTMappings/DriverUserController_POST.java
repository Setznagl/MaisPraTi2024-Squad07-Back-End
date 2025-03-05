package com.maisprati.codifica.alucar.Controller.POSTMappings;

import com.maisprati.codifica.alucar.Models.UserTypes.DriverUser;
import com.maisprati.codifica.alucar.Models.UserTypes.RawUser;
import com.maisprati.codifica.alucar.Services.Users.DriverUserService;
import com.maisprati.codifica.alucar.Services.Users.RawUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.maisprati.codifica.alucar.Lambdas.GenericUserRepository.*;

@RestController
public class DriverUserController_POST {

    //CRUD - Create
    @PostMapping
    @RequestMapping("/account/create/driver")
    public ResponseEntity<Void> createDriverUser(@RequestBody RawUser baseUser) {
        boolean check = driverUserService.check_available_email.test(baseUser.getEmail());
        if(check){
            DriverUser tempUser = conversion_raw_to_driver_user.apply(baseUser);
            rawUserService.DeleteRawUserById(baseUser.getId());
            driverUserService.InsertDriverUser(tempUser);
            return ResponseEntity.status(HttpStatus.CREATED).build();
       }else {return ResponseEntity.status(HttpStatus.IM_USED).build();}
    }

    @Autowired
    public DriverUserController_POST(DriverUserService driverUserService, RawUserService rawUserService) {
        this.driverUserService = driverUserService;
        this.rawUserService = rawUserService;
    }private final DriverUserService driverUserService;private final RawUserService rawUserService ;
}
