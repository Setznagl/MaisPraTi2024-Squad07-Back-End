package com.maisprati.codifica.alucar.Controller.GETMappings;

import com.maisprati.codifica.alucar.Models.Users.DriverUser;
import com.maisprati.codifica.alucar.Models.Users.RawUser;
import com.maisprati.codifica.alucar.Services.Users.RawUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

import static com.maisprati.codifica.alucar.Lambdas.lbd.find_data_by_id;
import static com.maisprati.codifica.alucar.Repository.DB.Users.GenericUserRepository.get_user_by_email;

@RestController
public class RawUserController_GET {

    @GetMapping("get-r-user")
    public ResponseEntity<RawUser> getRawUser_ByEmail(@RequestParam("email") String parameter_email) {
       boolean check_one = rawUserService.check_available_email.test(parameter_email);
            /*
            RawUser extracted_user = rawUserService.FindRawUserByEmail(parameter_email);
            RawUser check_two = new RawUser("","","");
            Long extracted_id = extracted_user.getId();
            check_two.equals(find_data_by_id.apply(r));
             */
       if (!check_one){RawUser target = rawUserService.FindRawUserByEmail(parameter_email);
              return ResponseEntity.ok(target);
       }else {return ResponseEntity.notFound().build();}
    }


    @Autowired
    public RawUserController_GET(RawUserService rawUserService) {
        this.rawUserService = rawUserService;
    }private final RawUserService rawUserService;
}
