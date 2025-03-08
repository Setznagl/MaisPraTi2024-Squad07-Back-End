package com.maisprati.codifica.alucar.Controller.DELETEMappings;

import com.maisprati.codifica.alucar.Exceptions.DataPersistenceException;
import com.maisprati.codifica.alucar.Models.RentModels.CarRent;
import com.maisprati.codifica.alucar.Services.Advertisement.CarService;
import com.maisprati.codifica.alucar.Services.Rent.CarRentService;
import com.maisprati.codifica.alucar.Util.Enum.PRODUCT_STATUS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CarRentController_DELETE {

    @DeleteMapping("/delete/car-rent/id/")
    public ResponseEntity<String> deleteCarRent(@RequestParam Long id) {
        CarRent parameter_rent = carRentService.Find_CarRent_ById(id);
        PRODUCT_STATUS temp_PRODUCTSTATUS = carService.FindCarById(parameter_rent.getAdvertisement_id()).getStatus();
        boolean check = temp_PRODUCTSTATUS != null && temp_PRODUCTSTATUS != PRODUCT_STATUS.RENTED;
        if(check){
            carRentService.Delete_CarRent_ById(id);
            return ResponseEntity.status(HttpStatus.OK).body("Rent order deleted successfully!");
        }else{throw new DataPersistenceException("This rent doesn't exist anymore or you're trying to delete an active rent!");}
    }

    @Autowired
    CarRentController_DELETE(CarRentService carRentService, CarService carService){
        this.carRentService = carRentService;
        this.carService = carService;
    }private final CarRentService carRentService;private final CarService carService;
}
