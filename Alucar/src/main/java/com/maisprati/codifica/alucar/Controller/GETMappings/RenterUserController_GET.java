package com.maisprati.codifica.alucar.Controller.GETMappings;

import com.maisprati.codifica.alucar.Models.UserTypes.RenterUser;
import com.maisprati.codifica.alucar.Services.Users.RenterUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RenterUserController_GET {

    //GET using Email
    @GetMapping("/get-re-user")
    public ResponseEntity<RenterUser> getRenterUser_ByEmail(@RequestParam("email") String parameter_email) {
            boolean check_one = renterUserService.check_available_email.test(parameter_email);
            boolean check_two = renterUserService.check_email_from_renteruser.test(parameter_email);
        if (!check_one && check_two){ RenterUser target = renterUserService.FindRenterUserByEmail(parameter_email);
            return ResponseEntity.ok(target);
        }else {return ResponseEntity.notFound().build();}
    }

    //GET using ID
    @GetMapping("/get-re-user/id/")
    public ResponseEntity<RenterUser> getRenterUser_ByID(@RequestParam("id") Long parameter_id) {
        RenterUser temp = renterUserService.FindRenterUserById(parameter_id);
        if(temp != null){return ResponseEntity.ok(temp);}
        else{return ResponseEntity.notFound().build();}
    }

    @Autowired
    public RenterUserController_GET(RenterUserService renterUserService) {
        this.renterUserService = renterUserService;
    }private final RenterUserService renterUserService;
}
