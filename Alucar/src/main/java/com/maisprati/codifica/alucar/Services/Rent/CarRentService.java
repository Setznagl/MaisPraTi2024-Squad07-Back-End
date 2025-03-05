package com.maisprati.codifica.alucar.Services.Rent;

import com.maisprati.codifica.alucar.Models.RentModels.CarRent;
import com.maisprati.codifica.alucar.Repository.DB.Rent.CarRentRepository;
import com.maisprati.codifica.alucar.Services.Advertisement.CarService;
import com.maisprati.codifica.alucar.Util.Enum.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
        return carRentRepository.RepositoryFind_All_Related_CarRent_By_Any_UserID(parameter_id);
    }

    //CRUD - Delete ( Future implemented by Spring Batch )
    public void Delete_CarRent_ById(Long parameter_rent_id){
        Status temp_status = carService.FindCarById(
            carRentRepository.RepositoryFindCarRentByID(parameter_rent_id).getAdvertisement_id()
        ).getStatus();
        boolean check = temp_status != null && temp_status != Status.UNAVAILABLE;
    }


    @Autowired
    CarRentService(CarRentRepository carRentRepository, CarService carService){
        this.carRentRepository = carRentRepository;
        this.carService = carService;
    }private final CarRentRepository carRentRepository;private final CarService carService;
}
