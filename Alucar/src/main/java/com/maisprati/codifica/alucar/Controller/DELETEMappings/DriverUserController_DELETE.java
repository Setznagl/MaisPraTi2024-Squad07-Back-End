package com.maisprati.codifica.alucar.Controller.DELETEMappings;

import com.maisprati.codifica.alucar.Services.Users.DriverUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DriverUserController_DELETE {

    //CRUD - Delete
    @DeleteMapping("delete-d-user/id/")
    public ResponseEntity<String> deleteDriverUser(@RequestParam Long id) {
        try {driverUserService.DeleteDriverUserById(id);}
        catch (Exception e){return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());}
        return ResponseEntity.status(HttpStatus.OK).body("User deleted successfully!");
    }

    @Autowired
    DriverUserController_DELETE(DriverUserService driverUserService){
        this.driverUserService = driverUserService;
    }private final DriverUserService driverUserService;
}
