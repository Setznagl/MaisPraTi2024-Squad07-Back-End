package com.maisprati.codifica.alucar.Models.RentModels;

import jakarta.persistence.*;

import java.sql.Date;

/* Attributes inherited from "Rent"
/////////////////////////////////////
   private Long renter_id
   private Long driver_id
   private Date start_date
   private Date end_date
   private String total_price
*/
@Entity
public class CarRent extends Rent {
    protected CarRent(){/*Empty constructor*/}
    public CarRent(
            Long parameter_renter_id,
            Long parameter_driver_id,
            Date parameter_start_date,
            Date parameter_end_date,
            Long advertisement_id
    ){
        super(parameter_renter_id,parameter_driver_id,parameter_start_date,parameter_end_date);
        this.advertisement_id = advertisement_id;
        this.total_price = 0D;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long advertisement_id;

    @Column(nullable = false)
    private Double total_price;

    /////////////////////////////////////////////////////////////////////////////////////////////////

    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}

    public Long getAdvertisement_id() {return advertisement_id;}
    public void setAdvertisement_id(Long advertisement_id) {this.advertisement_id = advertisement_id;}

    public Double getTotal_price() {return total_price;}
    public void setTotal_price(Double total_price) {this.total_price = total_price;}

}
