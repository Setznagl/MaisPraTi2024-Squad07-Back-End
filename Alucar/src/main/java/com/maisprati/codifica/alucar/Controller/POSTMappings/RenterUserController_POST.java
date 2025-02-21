package com.maisprati.codifica.alucar.Controller.POSTMappings;

import com.maisprati.codifica.alucar.Models.Users.DriverUser;
import com.maisprati.codifica.alucar.Models.Users.RawUser;
import com.maisprati.codifica.alucar.Models.Users.RenterUser;
import com.maisprati.codifica.alucar.Services.Users.RawUserService;
import com.maisprati.codifica.alucar.Services.Users.RenterUserService;
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
public class RenterUserController_POST {

    //CRUD - Create
    @PostMapping
    @RequestMapping("/create/renter")
    public ResponseEntity<Void> createRenterUser(@RequestBody RawUser baseUser) {
        boolean check = renterUserService.check_available_email.test(baseUser.getEmail());
        if (check) {
            RenterUser tempUser = conversion_raw_to_renter_user.apply(baseUser);
            rawUserService.DeleteRawUserById(baseUser.getId());
            renterUserService.InsertRenterUser(tempUser);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }else {
            return ResponseEntity.status(HttpStatus.IM_USED).build();
        }
    }

    //CRUD - Delete
    @PostMapping @RequestMapping("/delete/renter")
    public ResponseEntity<Void> deleteDriverUser(@RequestBody RenterUser baseUser) {
        try {
            renterUserService.DeleteRenterUserById(baseUser.getId());
            return ResponseEntity.status(HttpStatus.OK).build();
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    //CRUD - Update Simple data according FIGMA
    @PostMapping @RequestMapping("/update/renter")
    public ResponseEntity<Void> updateDriverUser(@RequestBody RenterUser submittedUser) {
        try {
            renterUserService.UpdateRenterUser(submittedUser);
            return ResponseEntity.status(HttpStatus.OK).build();
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @Autowired
    public RenterUserController_POST(RenterUserService renterUserService , RawUserService rawUserService) {
        this.renterUserService = renterUserService;
        this.rawUserService = rawUserService;
    }private final RenterUserService renterUserService;private final RawUserService rawUserService ;
}
