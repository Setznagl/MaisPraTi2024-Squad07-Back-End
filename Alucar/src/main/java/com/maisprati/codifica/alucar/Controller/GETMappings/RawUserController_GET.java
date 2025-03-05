package com.maisprati.codifica.alucar.Controller.GETMappings;

import com.maisprati.codifica.alucar.Exceptions.NotFoundDataException;
import com.maisprati.codifica.alucar.Models.UserTypes.RawUser;
import com.maisprati.codifica.alucar.Services.Users.RawUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RawUserController_GET {

    //GET using Email
    @GetMapping("/get-r-user")
    public ResponseEntity<RawUser> getRawUser_ByEmail(@RequestParam("email") String parameter_email) {
           boolean check_one = rawUserService.check_available_email.test(parameter_email);
           boolean check_two = rawUserService.check_email_from_rawuser.test(parameter_email);
       if (!check_one && check_two){RawUser target = rawUserService.FindRawUserByEmail(parameter_email);
              return ResponseEntity.ok(target);
       }else {throw new NotFoundDataException("This user does not exist");}
    }

    //GET using ID
    @GetMapping("/get-r-user/id/")
    public ResponseEntity<RawUser> getRawUser_ByID(@RequestParam("id") Long parameter_id) {
        RawUser temp = rawUserService.FindRawUserById(parameter_id);
        if(temp != null){return ResponseEntity.ok(temp);}
        else{throw new NotFoundDataException("This user does not exist");}
    }



    @Autowired
    public RawUserController_GET(RawUserService rawUserService) {
        this.rawUserService = rawUserService;
    }private final RawUserService rawUserService;
}
