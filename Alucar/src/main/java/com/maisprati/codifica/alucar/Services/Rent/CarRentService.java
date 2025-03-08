package com.maisprati.codifica.alucar.Services.Rent;

import com.maisprati.codifica.alucar.Models.Products.Car;
import com.maisprati.codifica.alucar.Models.RentModels.CarRent;
import com.maisprati.codifica.alucar.Repository.DB.Advertisement.CarRepository;
import com.maisprati.codifica.alucar.Repository.DB.Rent.CarRentRepository;
import com.maisprati.codifica.alucar.Util.Enum.PRODUCT_STATUS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.maisprati.codifica.alucar.Repository.DB.Rent.CarRentRepository.rentRoleDriver;
import static com.maisprati.codifica.alucar.Repository.DB.Rent.CarRentRepository.rentRoleRenter;

@Service
public class CarRentService {

    //CRUD - Create
    public void InsertCarRent(CarRent parameter_rent){
        carRentRepository.save(parameter_rent);
    }

    //CRUD - Read
    public CarRent Find_CarRent_ById(Long parameter_id){
        return carRentRepository.RepositoryFindCarRentByID(parameter_id);
    }

    //CRUD - Read
    public List<CarRent> Find_All_Related_CarRent_By_Any_UserID(Long parameter_id){
        List<CarRent> temp = carRentRepository.RepositoryFind_All_Related_CarRent_By_Any_UserID(parameter_id);
        List<CarRent> RenterRelated = temp.stream().filter(n -> rentRoleRenter.test(n , parameter_id)).toList();
        List<CarRent> DriverRelated = temp.stream().filter(n -> rentRoleDriver.test(n , parameter_id)).toList();
        boolean check_renter = !RenterRelated.isEmpty();
        boolean check_driver = !DriverRelated.isEmpty();
        if(check_renter){return RenterRelated;}
        else if(check_driver){return DriverRelated;}
        else return null;
    }

    //CRUD - Update
    public void ApproveCarRent(CarRent parameter_rent, Car parameter_car){
        parameter_car.setStatus(PRODUCT_STATUS.RENTED);
        carRentRepository.save(parameter_rent);
        carRepository.save(parameter_car);
    }

    //CRUD - Delete ( Future implemented by Spring Batch )
    public void Delete_CarRent_ById(Long parameter_rent_id){
        carRentRepository.deleteById(parameter_rent_id);
    }


    @Autowired
    CarRentService(CarRentRepository carRentRepository, CarRepository carRepository){
        this.carRentRepository = carRentRepository;
        this.carRepository = carRepository;
    }private final CarRentRepository carRentRepository;private final CarRepository carRepository;
}
