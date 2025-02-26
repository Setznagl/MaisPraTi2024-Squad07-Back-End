package com.maisprati.codifica.alucar.Controller.PUTMappings;

import com.maisprati.codifica.alucar.Models.Users.DriverUser;
import com.maisprati.codifica.alucar.Services.Users.DriverUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class DriverUserController_PUT {

    //CRUD - Update Simple data according FIGMA
    @PutMapping("account/update/driver")
    public ResponseEntity<Void> UpdateDriverUser(
            @RequestPart DriverUser user,
            @RequestPart MultipartFile photo,
            @RequestPart MultipartFile cnh,
            @RequestPart MultipartFile criminal_record){
        try {
            user.setPhoto(photo.getBytes());
            user.setCnh(cnh.getBytes());
            user.setCriminal_record(criminal_record.getBytes());
            try{driverUserService.UpdateDriverUser(user);}
            catch (Exception e){ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());}
            return ResponseEntity.status(HttpStatus.OK).build();
        }catch (Exception e){return ResponseEntity.status(HttpStatus.UNSUPPORTED_MEDIA_TYPE).build();}
    }


    @Autowired
    public DriverUserController_PUT(DriverUserService driverUserService){
        this.driverUserService = driverUserService;
    }private final DriverUserService driverUserService;
}
