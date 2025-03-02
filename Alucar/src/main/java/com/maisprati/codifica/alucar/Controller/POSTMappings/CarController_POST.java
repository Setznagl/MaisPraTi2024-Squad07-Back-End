package com.maisprati.codifica.alucar.Controller.POSTMappings;

import com.maisprati.codifica.alucar.Models.Advertisement.Car;
import com.maisprati.codifica.alucar.Services.Advertisement.CarService;
import com.maisprati.codifica.alucar.Services.Users.RenterUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import static com.maisprati.codifica.alucar.Lambdas.GenericUserRepository.equals_comparable_renter;

@RestController
public class CarController_POST {

    @PostMapping("/advertisement/create/car")
    public ResponseEntity<Car> insertCar(
            @RequestPart Car submitted_car,
            @RequestPart(required = false) MultipartFile photo_01,
            @RequestPart(required = false) MultipartFile photo_02,
            @RequestPart(required = false) MultipartFile photo_03,
            @RequestPart(required = false) MultipartFile photo_04
    ){
        boolean check = carService.check_available_car_license_plate.test(submitted_car.getLicense_plate());
        boolean check_two = renterUserService.FindRenterUserById(submitted_car.getOwner_id()).equals(equals_comparable_renter.get());
        if(check && check_two){
            try{
                if (photo_01 != null){submitted_car.setPhoto01(photo_01.getBytes());}
                if (photo_02 != null){submitted_car.setPhoto02(photo_02.getBytes());}
                if (photo_03 != null){submitted_car.setPhoto03(photo_03.getBytes());}
                if (photo_04 != null){submitted_car.setPhoto04(photo_04.getBytes());}
                    carService.InsertCar(submitted_car);
                    return ResponseEntity.status(HttpStatus.CREATED).build();
            }catch (Exception e){throw new IllegalArgumentException(e.getMessage());}
        }else if(!check && check_two){return ResponseEntity.status(HttpStatus.IM_USED).build();
        }else{return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();}
    }

    @Autowired
    CarController_POST(CarService carService, RenterUserService renterUserService){
        this.carService = carService;
        this.renterUserService = renterUserService;
    }private final CarService carService;private final RenterUserService renterUserService;
}
