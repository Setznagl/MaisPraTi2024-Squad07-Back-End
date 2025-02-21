package com.maisprati.codifica.alucar.Repository.DB.Advertisement;

import com.maisprati.codifica.alucar.Models.Advertisement.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;

public interface CarRepository extends JpaRepository<Car, Long> {

    // JPQL
    @Query("SELECT p FROM Car p WHERE p.owner_id = :ownerID")
    List<Car> Repository_FindAll_by_renterID(@Param("owner_id") Long ownerID);

    // JPQL
    @Query("SELECT p FROM Car p WHERE p.owner_id = :ownerID and p.license_plate = :licensePlate")
    Car Repository_Find_By_RenterID_and_License_Plate(@Param("owner_id") Long ownerID, @Param("license_plate") String licensePlate);

    BiFunction<Car, Car, Car> treat_car_update = (previousData, submittedChanges) -> {
        Car treatedData = new Car(0L, "", "", Date.valueOf("0000"),
                "","", "", "","","",
                "","","","", 0L,
                "",new ArrayList<byte[]>(4));
        if(submittedChanges.getOwner_id() == null){treatedData.setOwner_id(previousData.getOwner_id());};
        if(submittedChanges.getBrand() == null){treatedData.setBrand(previousData.getBrand());};
        if(submittedChanges.getModel() == null){treatedData.setModel(previousData.getModel());};
        if(submittedChanges.getYear() == null){treatedData.setYear(previousData.getYear());};
        if(submittedChanges.getLicense_plate() == null){treatedData.setLicense_plate(previousData.getLicense_plate());};
        if(submittedChanges.getTitle() == null){treatedData.setTitle(previousData.getTitle());};
        if(submittedChanges.getLocation() == null){treatedData.setLocation(previousData.getLocation());};
        if(submittedChanges.getTransmission() == null){treatedData.setTransmission(previousData.getTransmission());};
        if(submittedChanges.getMileage() == null){treatedData.setMileage(previousData.getMileage());};
        if(submittedChanges.getMain_fuel() == null){treatedData.setMain_fuel(previousData.getMain_fuel());};
        if(submittedChanges.getSecondary_fuel() == null){treatedData.setSecondary_fuel(previousData.getSecondary_fuel());};
        if(submittedChanges.getEngine_power() == null){treatedData.setEngine_power(previousData.getEngine_power());};
        if(submittedChanges.getSteering_system() == null){treatedData.setSteering_system(previousData.getSteering_system());};
        if(submittedChanges.getNumber_of_seats() == null){treatedData.setNumber_of_seats(previousData.getNumber_of_seats());};
        if(submittedChanges.getDaily_rent_value() == null){treatedData.setDaily_rent_value(previousData.getDaily_rent_value());};
        if(submittedChanges.getDescription() == null){treatedData.setDescription(previousData.getDescription());};
        if(submittedChanges.getPhoto01() == null){treatedData.setPhoto01(previousData.getPhoto01());};
        if(submittedChanges.getPhoto02() == null){treatedData.setPhoto01(previousData.getPhoto02());};
        if(submittedChanges.getPhoto03() == null){treatedData.setPhoto01(previousData.getPhoto03());};
        if(submittedChanges.getPhoto04() == null){treatedData.setPhoto01(previousData.getPhoto04());};
        return treatedData;
    };
}
