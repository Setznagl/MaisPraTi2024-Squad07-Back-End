package com.maisprati.codifica.alucar.Controller.DELETEMappings;

import com.maisprati.codifica.alucar.Exceptions.NotFoundDataException;
import com.maisprati.codifica.alucar.Models.Advertisement.Car;
import com.maisprati.codifica.alucar.Services.Advertisement.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CarController_DELETE {

    @DeleteMapping("/delete/car/id/")
    public ResponseEntity<String> deleteCar(@RequestParam Long id) {
        Car temp = carService.FindCarById(id);
        if (temp != null) {
            carService.DeleteCarById(id);
            return ResponseEntity.status(HttpStatus.OK).body("Car deleted successfully!");
        }else {throw new NotFoundDataException("Car not found!");}
    }

    @Autowired
    CarController_DELETE(CarService carService){
        this.carService = carService;
    }private final CarService carService;
}
