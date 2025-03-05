package com.maisprati.codifica.alucar.Repository.DB.Rent;

import com.maisprati.codifica.alucar.Models.RentModels.CarRent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRentRepository extends JpaRepository<CarRent, Long> {

    // JPQL
    @Query("SELECT p FROM CarRent p WHERE p.id = :id")
    CarRent RepositoryFindCarRentByID(@Param("id") Long id);

    // JPQL
    @Query("SELECT p FROM CarRent p WHERE p.driver_id = :id OR p.renter_id = :id")
    List<CarRent> RepositoryFind_All_Related_CarRent_By_Any_UserID(@Param("id") Long id);

}
