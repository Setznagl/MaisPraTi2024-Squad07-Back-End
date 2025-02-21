package com.maisprati.codifica.alucar.Util.Queries_Camila;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public class teste {

    // Lista de Anúncios por ID do Locador

    /*
    @Query("""
    SELECT a.id, a.title, a.description, a.views, a.status, a.location, a.mileage, a.main_fuel, a.secondary_fuel
    FROM Ad a
    JOIN Vehicle v ON v.id = a.vehicle_id
    JOIN Renter_User ru ON v.owner_id = ru.id
    WHERE ru.id = :renterId
""")
    List<Object[]> findAdDetailsByRenterId(@Param("renterId") Long renterId);
     */


    //Lista de Avaliações por ID do usuário

    /*
    @Query("SELECT r FROM Rating r WHERE r.reviewerId = :userId OR r.revieweredId = :userId")
    List<Rating> findRatingsByUserId(@Param("userId") Long userId);
     */
}
