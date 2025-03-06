package com.maisprati.codifica.alucar.Repository.DB.Advertisement;

import com.maisprati.codifica.alucar.Lambdas.GenericAdvertisementRepository;
import com.maisprati.codifica.alucar.Models.Products.Car;
import com.maisprati.codifica.alucar.Util.Enum.PRODUCT_STATUS;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface CarRepository extends JpaRepository<Car, Long>, GenericAdvertisementRepository {

    // JPQL
    @Query("SELECT p FROM Car p WHERE p.owner_id = :owner_id")
    List<Car> Repository_FindAll_by_renterID(@Param("owner_id") Long owner_id);

    // JPQL
    @Query("SELECT p FROM Car p WHERE p.owner_id = :owner_id AND p.status = :status")
    List<Car> Repository_FindAll_Available_by_renterID(@Param("owner_id") Long owner_id, @Param("status") PRODUCT_STATUS PRODUCTSTATUS);

    // JPQL
    @Query("SELECT p FROM Car p WHERE p.license_plate = :license_plate")
    Car Repository_Find_By_License_Plate(@Param("license_plate") String license_plate);

    // JPQL
    @Query("SELECT p FROM Car p WHERE p.id = :id")
    Car Repository_findCarByID(@Param("id") Long id);
}
