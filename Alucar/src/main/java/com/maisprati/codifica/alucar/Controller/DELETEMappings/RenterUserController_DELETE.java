package com.maisprati.codifica.alucar.Controller.DELETEMappings;

import com.maisprati.codifica.alucar.Services.Users.RenterUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RenterUserController_DELETE {

    //CRUD - Delete
    @DeleteMapping("delete-re-user/id/")
    public ResponseEntity<String> deleteRenterUser(@RequestParam Long id) {
        try {renterUserService.DeleteRenterUserById(id);}
        catch(Exception e){return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());}
        return ResponseEntity.status(HttpStatus.TOO_EARLY).build();
    }

    @Autowired
    RenterUserController_DELETE(RenterUserService renterUserService){
        this.renterUserService = renterUserService;
    }private final RenterUserService renterUserService;
}
