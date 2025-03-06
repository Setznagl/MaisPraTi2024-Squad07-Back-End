package com.maisprati.codifica.alucar.Services.Rent;

import com.maisprati.codifica.alucar.Exceptions.DataPersistenceException;
import com.maisprati.codifica.alucar.Exceptions.NotFoundDataException;
import com.maisprati.codifica.alucar.Models.RentModels.CarRent;
import com.maisprati.codifica.alucar.Repository.DB.Rent.CarRentRepository;
import com.maisprati.codifica.alucar.Services.Advertisement.CarService;
import com.maisprati.codifica.alucar.Util.Enum.PRODUCT_STATUS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
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
        CarRent parameter_rent = Find_CarRent_ById(parameter_rent_id);
        PRODUCT_STATUS temp_PRODUCTSTATUS = carService.FindCarById(parameter_rent.getAdvertisement_id()).getStatus();
        LocalDate today = LocalDate.now();
        boolean check = temp_PRODUCTSTATUS != null && temp_PRODUCTSTATUS != PRODUCT_STATUS.UNAVAILABLE;
        boolean check_two = today.isAfter(parameter_rent.getEnd_date().toLocalDate());
        if(check && check_two){carRentRepository.delete(carRentRepository.RepositoryFindCarRentByID(parameter_rent_id));
        }else{throw new DataPersistenceException("This rent doesn't exist anymore or you're trying to delete an active rent!");}
    }


    @Autowired
    CarRentService(CarRentRepository carRentRepository, CarService carService){
        this.carRentRepository = carRentRepository;
        this.carService = carService;
    }private final CarRentRepository carRentRepository;private final CarService carService;
}
