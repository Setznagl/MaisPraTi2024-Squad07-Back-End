package com.maisprati.codifica.alucar.Controller.POSTMappings;

import com.maisprati.codifica.alucar.Models.Users.DriverUser;
import com.maisprati.codifica.alucar.Models.Users.RawUser;
import com.maisprati.codifica.alucar.Services.Users.DriverUserService;
import com.maisprati.codifica.alucar.Services.Users.RawUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.maisprati.codifica.alucar.Repository.DB.Users.GenericUserRepository.*;

@RestController
@RequestMapping("/account")
public class DriverUserController_POST {

    @PostMapping
    @RequestMapping("/create/driver")
    public ResponseEntity<Void> createDriverUser(@RequestBody RawUser baseUser) {
        boolean check = driverUserService.check_available_email.test(baseUser.getEmail());
        if (check) {
            DriverUser tempUser = conversion_raw_to_driver_user.apply(baseUser);
            driverUserService.InsertDriverUser(tempUser);
            rawUserService.DeleteRawUserById(baseUser.getId());
        }
        return null;
    }



    @Autowired
    public DriverUserController_POST(
            DriverUserService driverUserService ,
            RawUserService rawUserService) {
        this.driverUserService = driverUserService;
        this.rawUserService = rawUserService;
    }
    private final DriverUserService driverUserService;
    private final RawUserService rawUserService ;
}
