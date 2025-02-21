package com.maisprati.codifica.alucar.Services.Advertisement;

import com.maisprati.codifica.alucar.Models.Advertisement.Car;
import com.maisprati.codifica.alucar.Repository.DB.Advertisement.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.maisprati.codifica.alucar.Lambdas.lbd.*;

@Service
public class CarService {

    @Autowired
    public void setCarRepository(CarRepository carRepository) {
        this.carRepository = carRepository;
    }CarRepository carRepository;

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //CRUD - Create
    @SuppressWarnings({"unchecked", "rawtypes"})
    public boolean InsertCar
    (
            Long parameter_owner_id,
            String parameter_brand,
            String parameter_model ,
            java.sql.Date parameter_year,
            String parameter_license_plate,
            String parameter_title,
            String parameter_location,
            String parameter_transmission,
            String parameter_mileage,
            String parameter_main_fuel,
            String parameter_secondary_fuel,
            String parameter_engine_Power,
            String parameter_steering_system,
            String parameter_number_of_seats,
            Long parameter_daily_rent_value,
            String parameter_description,
            ArrayList<byte[]> parameter_photos
    )
    {
        //Trying to insert car
        try {
            Car tempCar = new Car(
                    parameter_owner_id,
                    parameter_brand,
                    parameter_model,
                    parameter_year,
                    parameter_license_plate,
                    parameter_title,
                    parameter_location,
                    parameter_transmission,
                    parameter_mileage,
                    parameter_main_fuel,
                    parameter_secondary_fuel,
                    parameter_engine_Power,
                    parameter_steering_system,
                    parameter_number_of_seats,
                    parameter_daily_rent_value,
                    parameter_description,
                    parameter_photos
            );
            insert_data.apply((JpaRepository) carRepository, tempCar);
            return true;
        }catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    //CRUD - Read
    @SuppressWarnings({"unchecked", "rawtypes", "unused"})
    public Car FindCarById(Long parameter_id) {
        return (Car) find_data_by_id.apply((JpaRepository) carRepository, parameter_id);
    }

    //CRUD - Read
    public List<Car> FindAllCarsByRenterID(Long renter_id) {
        try {
            return carRepository.Repository_FindAll_by_renterID(renter_id);
        } catch (Exception e) {
            return null;
        }
    }

    //CRUD - Update ( will be made only at the AD )

    //CRUD - Delete
    @SuppressWarnings({"unchecked", "rawtypes", "unused"})
    public void DeleteCarById(Long parameter_id) {
        delete_data_by_id.accept((JpaRepository) carRepository, parameter_id);
    }
}
