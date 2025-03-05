package com.maisprati.codifica.alucar.Controller.PUTMappings;

import com.maisprati.codifica.alucar.Models.Products.Car;
import com.maisprati.codifica.alucar.Services.Advertisement.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class CarController_PUT {

    @PutMapping("/account/update/car")
    public ResponseEntity<Car> updateCar(
            @RequestPart Car car,
            @RequestPart(required = false) MultipartFile photo_01,
            @RequestPart(required = false) MultipartFile photo_02,
            @RequestPart(required = false) MultipartFile photo_03,
            @RequestPart(required = false) MultipartFile photo_04){
        try{
            if(photo_01 != null){car.setPhoto01(photo_01.getBytes());}
            if(photo_02 != null){car.setPhoto01(photo_02.getBytes());}
            if(photo_03 != null){car.setPhoto01(photo_03.getBytes());}
            if(photo_04 != null){car.setPhoto01(photo_04.getBytes());}
                carService.UpdateCar(car);
                return ResponseEntity.status(HttpStatus.OK).build();

        }catch (Exception e){
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    @Autowired
    CarController_PUT(CarService carService){
        this.carService = carService;
    }private final CarService carService;
}
