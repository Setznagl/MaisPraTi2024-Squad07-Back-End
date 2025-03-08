package com.maisprati.codifica.alucar.Repository.DB.Rent;

import com.maisprati.codifica.alucar.Models.RentModels.CarRent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.function.BiPredicate;


@Repository
public interface CarRentRepository extends JpaRepository<CarRent, Long> {

    // JPQL
    @Query("SELECT p FROM CarRent p WHERE p.id = :id")
    CarRent RepositoryFindCarRentByID(@Param("id") Long id);

    // JPQL
    @Query("SELECT p FROM CarRent p WHERE p.driver_id = :id OR p.renter_id = :id")
    List<CarRent> RepositoryFind_All_Related_CarRent_By_Any_UserID(@Param("id") Long id);

    BiPredicate<CarRent, Long> rentRoleRenter = (submittedRent , id) -> submittedRent.getRenter_id().equals(id);

    BiPredicate<CarRent, Long> rentRoleDriver = (submittedRent, id) -> submittedRent.getDriver_id().equals(id);

    BiPredicate<List<CarRent>, CarRent> rentDoesntExist = (submittedCarRentList, submittedRentTry) -> {
        if(submittedCarRentList == null) return true;
        submittedCarRentList = submittedCarRentList.stream()
                .filter(n -> !(n.getAdvertisement_id().equals(submittedRentTry.getAdvertisement_id())))
        .toList();
        return submittedCarRentList.isEmpty();
    };

}
