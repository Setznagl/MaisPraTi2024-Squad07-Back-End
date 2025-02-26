package com.maisprati.codifica.alucar.Controller.DELETEMappings;

import com.maisprati.codifica.alucar.Services.Users.RawUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RawUserController_DELETE {

    //CRUD - Delete
    @DeleteMapping("delete-r-user/id/")
    public ResponseEntity<String> DeleteRawUser(@RequestParam Long id) {
        try{rawUserService.DeleteRawUserById(id);}
        catch (Exception e){return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());}
        return ResponseEntity.status(HttpStatus.OK).body("User deleted successfully!");
    }

    @Autowired
    RawUserController_DELETE(RawUserService rawUserService){
        this.rawUserService = rawUserService;
    }private final RawUserService rawUserService;
}
