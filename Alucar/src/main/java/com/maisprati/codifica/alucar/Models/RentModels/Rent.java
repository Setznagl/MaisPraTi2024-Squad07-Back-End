package com.maisprati.codifica.alucar.Models.RentModels;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;

import java.sql.Date;

@MappedSuperclass
public abstract class Rent {
    protected Rent() {/*Empty constructor*/};
    public Rent(
       Long parameter_renter_id,
       Long parameter_driver_id,
       Date parameter_start_date,
       Date parameter_end_date
    ){
        this.renter_id = parameter_renter_id;
        this.driver_id = parameter_driver_id;
        this.start_date = parameter_start_date;
        this.end_date = parameter_end_date;
    }

    @Column(nullable = false)
    private Long renter_id;

    @Column()
    private Long driver_id;

    @Column(nullable = false)
    private Date start_date;

    @Column(nullable = false)
    private Date end_date;

    ////////////////////////////////////////////////////////////////////////////

    public Long getRenter_id() {return renter_id;}
    public void setRenter_id(Long renter_id) {this.renter_id = renter_id;}

    public Long getDriver_id() {return driver_id;}
    public void setDriver_id(Long driver_id) {this.driver_id = driver_id;}

    public Date getStart_date() {return start_date;}
    public void setStart_date(Date start_date) {this.start_date = start_date;}

    public Date getEnd_date() {return end_date;}
    public void setEnd_date(Date end_date) {this.end_date = end_date;}

}
