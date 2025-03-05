package com.maisprati.codifica.alucar.Lambdas;

import com.maisprati.codifica.alucar.Models.Advertisement.Car;
import com.maisprati.codifica.alucar.Repository.DB.Advertisement.CarRepository;

import java.sql.Date;
import java.util.function.BiFunction;

public interface GenericAdvertisementRepository {

    BiFunction<Car, Car, Car> treat_car_update = (previousData , submittedChanges) -> {
        Car treatedData = new Car(
                0L,
                " ",
                " ",
                Date.valueOf("2000-2-2"),
                " "
        );
        treatedData.setId(previousData.getId());
        if(submittedChanges.getOwner_id() == null){treatedData.setOwner_id(previousData.getOwner_id());}
            else{treatedData.setOwner_id(submittedChanges.getOwner_id());}
        if(submittedChanges.getBrand() == null){treatedData.setBrand(previousData.getBrand());}
            else{treatedData.setBrand(submittedChanges.getBrand());}
        if(submittedChanges.getModel() == null){treatedData.setModel(previousData.getModel());}
            else{treatedData.setModel(submittedChanges.getModel());}
        if(submittedChanges.getYear() == null){treatedData.setYear(previousData.getYear());}
            else{treatedData.setYear(submittedChanges.getYear());}
        if(submittedChanges.getLicense_plate() == null){treatedData.setLicense_plate(previousData.getLicense_plate());}
            else{treatedData.setLicense_plate(submittedChanges.getLicense_plate());}
        if(submittedChanges.getTitle() == null){treatedData.setTitle(previousData.getTitle());}
            else{treatedData.setTitle(submittedChanges.getTitle());}
        if(submittedChanges.getLocation() == null){treatedData.setLocation(previousData.getLocation());}
            else{treatedData.setLocation(submittedChanges.getLocation());}
        if(submittedChanges.getTransmission() == null){treatedData.setTransmission(previousData.getTransmission());}
            else{treatedData.setTransmission(submittedChanges.getTransmission());}
        if(submittedChanges.getMileage() == null){treatedData.setMileage(previousData.getMileage());}
            else{treatedData.setMileage(submittedChanges.getMileage());}
        if(submittedChanges.getMain_fuel() == null){treatedData.setMain_fuel(previousData.getMain_fuel());}
            else{treatedData.setMain_fuel(submittedChanges.getMain_fuel());}
        if(submittedChanges.getSecondary_fuel() == null){treatedData.setSecondary_fuel(previousData.getSecondary_fuel());}
            else{treatedData.setSecondary_fuel(submittedChanges.getSecondary_fuel());}
        if(submittedChanges.getEngine_power() == null){treatedData.setEngine_power(previousData.getEngine_power());}
            else{treatedData.setEngine_power(submittedChanges.getEngine_power());}
        if(submittedChanges.getSteering_system() == null){treatedData.setSteering_system(previousData.getSteering_system());}
            else{treatedData.setSteering_system(submittedChanges.getSteering_system());}
        if(submittedChanges.getNumber_of_seats() == null){treatedData.setNumber_of_seats(previousData.getNumber_of_seats());}
            else{treatedData.setNumber_of_seats(submittedChanges.getNumber_of_seats());}
        if(submittedChanges.getDaily_rent_value() == null){treatedData.setDaily_rent_value(previousData.getDaily_rent_value());}
            else{treatedData.setDaily_rent_value(submittedChanges.getDaily_rent_value());}
        if(submittedChanges.getDescription() == null){treatedData.setDescription(previousData.getDescription());}
            else{treatedData.setDescription(submittedChanges.getDescription());}
        if(submittedChanges.getPhoto01() == null){treatedData.setPhoto01(previousData.getPhoto01());}
            else{treatedData.setPhoto01(submittedChanges.getPhoto01());}
        if(submittedChanges.getPhoto02() == null){treatedData.setPhoto02(previousData.getPhoto02());}
            else{treatedData.setPhoto02(submittedChanges.getPhoto02());}
        if(submittedChanges.getPhoto03() == null){treatedData.setPhoto03(previousData.getPhoto03());}
            else{treatedData.setPhoto03(submittedChanges.getPhoto03());}
        if(submittedChanges.getPhoto04() == null){treatedData.setPhoto04(previousData.getPhoto04());}
            else{treatedData.setPhoto04(submittedChanges.getPhoto04());}
        return treatedData;
    };

    BiFunction<GenericAdvertisementRepository,Long, Object> get_car_by_id = (jparepository , parameter_id) -> {
        if (jparepository instanceof CarRepository conversion){
            return conversion.Repository_findCarByID(parameter_id);
        }else return null;
    };
}
