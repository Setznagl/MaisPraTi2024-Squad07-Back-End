package com.maisprati.codifica.alucar.Services.Advertisement;

import com.maisprati.codifica.alucar.Models.Advertisement.Car;
import com.maisprati.codifica.alucar.Repository.DB.Advertisement.CarRepository;
import com.maisprati.codifica.alucar.Util.Enum.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Predicate;

import static com.maisprati.codifica.alucar.Lambdas.GenericAdvertisementRepository.get_car_by_id;
import static com.maisprati.codifica.alucar.Lambdas.GenericAdvertisementRepository.treat_car_update;

@Service
public class CarService {
    @Autowired
    public void setCarRepository(CarRepository carRepository) {
        this.carRepository = carRepository;
    }CarRepository carRepository;
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //CRUD - Create
    public void InsertCar(Car parameter_car){
        carRepository.save(parameter_car);
    }

    //CRUD - Read
    public Car FindCarById(Long parameter_id){
        return (Car) get_car_by_id.apply(carRepository , parameter_id);
    }

    //CRUD - Read
    public Car FindCarByLicensePlate(String parameter_license_plate){
        return carRepository.Repository_Find_By_License_Plate(parameter_license_plate);
    }

    //CRUD - Read
    public List<Car> FindAllCarsByRenterID(Long renter_id) {
        return carRepository.Repository_FindAll_by_renterID(renter_id);
    }

    //CRUD - Read
    public List<Car> FindAllAvailableCarsByRenterID(Long renter_id, Status expected_status) {
        return carRepository.Repository_FindAll_Available_by_renterID(renter_id , expected_status);
    }

    //CRUD - Update
    public void UpdateCar(Car submitted_car){
            System.out.println("submitted_car\n" + submitted_car);
        Car previousData = FindCarByLicensePlate(submitted_car.getLicense_plate());
            System.out.println("previoudata\n" + previousData);
        //Submit to lambda validate changes, null field new values will return previous actual data
        Car treatedData = treat_car_update.apply(previousData , submitted_car);
            System.out.println("treateddata\n" + treatedData);
        carRepository.save(treatedData);
    }

    //CRUD - Delete
    public void DeleteCarById(Long parameter_id) {
        carRepository.deleteById(parameter_id);
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public Predicate<String> check_available_car_license_plate = (parameter_license_plate) ->
            carRepository.Repository_Find_By_License_Plate(parameter_license_plate) == null;

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
}
