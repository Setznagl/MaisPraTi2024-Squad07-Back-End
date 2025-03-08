package com.maisprati.codifica.alucar.Controller.POSTMappings;

import com.maisprati.codifica.alucar.Exceptions.BusinessRuleException;
import com.maisprati.codifica.alucar.Exceptions.DataPersistenceException;
import com.maisprati.codifica.alucar.Models.Products.Car;
import com.maisprati.codifica.alucar.Models.RentModels.CarRent;
import com.maisprati.codifica.alucar.Services.Advertisement.CarService;
import com.maisprati.codifica.alucar.Services.Rent.CarRentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.maisprati.codifica.alucar.Repository.DB.Rent.CarRentRepository.rentDoesntExist;

@RestController
public class CarRentController_POST {

    @PostMapping("/car-rent-order/create")
    public ResponseEntity<Void> insertCarRent(@RequestBody CarRent submitted_rent){
        Car temp_car = carService.FindCarById(submitted_rent.getAdvertisement_id());
        List<CarRent> temp_list = carRentService.Find_All_Related_CarRent_By_Any_UserID(submitted_rent.getDriver_id());
            if(temp_car == null) throw new DataPersistenceException("Referred car couldn't be found, try again later!");
            boolean check_one = rentDoesntExist.test(temp_list, submitted_rent);
            boolean check_two = submitted_rent.getStart_date().before(submitted_rent.getEnd_date());
            if(check_one && check_two){
                carRentService.InsertCarRent(submitted_rent);
                return ResponseEntity.status(HttpStatus.CREATED).build();
            }else throw new BusinessRuleException("""
                    Something went wrong, possible reasons:
                    
                    This rent already exist!
                    Start-date cannot be after end-date or at the same day!""");
    }


    @Autowired
    CarRentController_POST(CarRentService carRentService, CarService carService){
        this.carRentService = carRentService;
        this.carService = carService;
    }private final CarRentService carRentService;private final CarService carService;
}
