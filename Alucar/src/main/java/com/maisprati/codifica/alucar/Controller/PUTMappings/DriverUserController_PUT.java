package com.maisprati.codifica.alucar.Controller.PUTMappings;

import com.maisprati.codifica.alucar.Models.UserTypes.DriverUser;
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
            @RequestPart(required = false) MultipartFile photo,
            @RequestPart(required = false) MultipartFile cnh,
            @RequestPart(required = false) MultipartFile criminal_record){
        try{
            if(photo != null){user.setPhoto(photo.getBytes());}
            if(cnh != null){user.setCnh(cnh.getBytes());}
            if(criminal_record != null){user.setCriminal_record(criminal_record.getBytes());}
                driverUserService.UpdateDriverUser(user);
                return ResponseEntity.status(HttpStatus.OK).build();}
        catch (Exception e){throw new IllegalArgumentException(e.getMessage());}
    }


    @Autowired
    public DriverUserController_PUT(DriverUserService driverUserService){
        this.driverUserService = driverUserService;
    }private final DriverUserService driverUserService;
}
