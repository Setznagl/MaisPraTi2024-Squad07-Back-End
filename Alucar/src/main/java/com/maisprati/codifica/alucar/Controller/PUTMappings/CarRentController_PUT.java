package com.maisprati.codifica.alucar.Controller.PUTMappings;

import com.maisprati.codifica.alucar.Exceptions.BusinessRuleException;
import com.maisprati.codifica.alucar.Models.Products.Car;
import com.maisprati.codifica.alucar.Models.RentModels.CarRent;
import com.maisprati.codifica.alucar.Services.Advertisement.CarService;
import com.maisprati.codifica.alucar.Services.Rent.CarRentService;
import com.maisprati.codifica.alucar.Util.Enum.PRODUCT_STATUS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;

import static com.maisprati.codifica.alucar.Repository.DB.Rent.CarRentRepository.rentRoleDriver;
import static com.maisprati.codifica.alucar.Repository.DB.Rent.CarRentRepository.rentRoleRenter;

@RestController
public class CarRentController_PUT {

    @PutMapping("/car-rent/approve/id")
    public ResponseEntity<Void> approveCarRentOrder(
            @RequestPart CarRent submittedOrder,
            @RequestPart Long renter_id) throws Exception
    {
        boolean isDriver = rentRoleDriver.test(submittedOrder, renter_id);
        boolean isRenter = rentRoleRenter.test(submittedOrder, renter_id);
        boolean integrityAssurance = submittedOrder.getRenter_id().equals(renter_id);

        if(isDriver) throw new BusinessRuleException("Drivers are not allowed to update a pending rent!");
        else if(isRenter && integrityAssurance){
            Car temp = carService.FindCarById(submittedOrder.getAdvertisement_id());
            if(temp.getStatus() != PRODUCT_STATUS.RENTED){
                carRentService.ApproveCarRent(submittedOrder, temp);
                return ResponseEntity.status(HttpStatus.OK).build();
            }else throw new BusinessRuleException("The referred car is already rented!");
        }else{throw new Exception("The user cannot be identified!");}
    }


    @Autowired
    CarRentController_PUT(CarRentService carRentService, CarService carService) {
        this.carRentService = carRentService;
        this.carService = carService;
    }private final CarRentService carRentService;private final CarService carService;
}
