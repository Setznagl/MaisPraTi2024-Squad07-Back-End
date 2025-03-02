package com.maisprati.codifica.alucar.Controller.PUTMappings;

import com.maisprati.codifica.alucar.Models.Users.RenterUser;
import com.maisprati.codifica.alucar.Services.Users.RenterUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class RenterUserController_PUT {

    //CRUD - Update Simple data according FIGMA
    @PutMapping("account/update/renter")
    public ResponseEntity<Void> UpdateRenterUser(
            @RequestPart RenterUser user,
            @RequestPart(required = false) MultipartFile photo
    ){
        try{
            if(photo != null){user.setPhoto(photo.getBytes());}
                renterUserService.UpdateRenterUser(user);
                return ResponseEntity.status(HttpStatus.OK).build();}
        catch (Exception e){throw new IllegalArgumentException(e.getMessage());}
    }

    @Autowired
    RenterUserController_PUT(RenterUserService renterUserService){
        this.renterUserService = renterUserService;
    }private final RenterUserService renterUserService;
}
