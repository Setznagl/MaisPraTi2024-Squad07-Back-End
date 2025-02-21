package com.maisprati.codifica.alucar.Controller.POSTMappings;

import com.maisprati.codifica.alucar.Models.Users.DriverUser;
import com.maisprati.codifica.alucar.Models.Users.RawUser;
import com.maisprati.codifica.alucar.Services.Users.DriverUserService;
import com.maisprati.codifica.alucar.Services.Users.RawUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.maisprati.codifica.alucar.Repository.DB.Users.GenericUserRepository.*;

@RestController
@RequestMapping("/account")
public class DriverUserController_POST {

    //CRUD - Create
    @PostMapping
    @RequestMapping("/create/driver")
    public ResponseEntity<Void> createDriverUser(@RequestBody RawUser baseUser) {
        boolean check = driverUserService.check_available_email.test(baseUser.getEmail());
        try {
            if (check) {
                DriverUser tempUser = conversion_raw_to_driver_user.apply(baseUser);
                rawUserService.DeleteRawUserById(baseUser.getId());
                driverUserService.InsertDriverUser(tempUser);
                return ResponseEntity.status(HttpStatus.CREATED).build();
            }else {
                return ResponseEntity.status(HttpStatus.IM_USED).build();
            }
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    //CRUD - Delete
    @PostMapping @RequestMapping("/delete/driver")
    public ResponseEntity<Void> deleteDriverUser(@RequestBody DriverUser baseUser) {
        try {
            driverUserService.DeleteDriverUserById(baseUser.getId());
            return ResponseEntity.status(HttpStatus.OK).build();
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    //CRUD - Update Simple data according FIGMA
    @PostMapping @RequestMapping("/update/driver")
    public ResponseEntity<Void> updateDriverUser(@RequestBody DriverUser submittedUser) {
        try {
            driverUserService.UpdateDriverUser(submittedUser);
            return ResponseEntity.status(HttpStatus.OK).build();
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @Autowired
    public DriverUserController_POST(DriverUserService driverUserService, RawUserService rawUserService) {
        this.driverUserService = driverUserService;
        this.rawUserService = rawUserService;
    }private final DriverUserService driverUserService;private final RawUserService rawUserService ;
}
