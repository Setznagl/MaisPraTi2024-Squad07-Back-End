package com.maisprati.codifica.alucar.Models.Advertisement;

import com.maisprati.codifica.alucar.Models.Product.Vehicle;
import com.maisprati.codifica.alucar.Util.Enum.Status;
import jakarta.persistence.*;

import java.sql.Timestamp;

/* Attributes inherited from "Vehicle"
/////////////////////////////////////
   private Long owner_id
   private String brand;
   private String model;
   private java.sql.Date year;
   private String license_plate;
*/
@Entity
public class Car extends Vehicle {
    protected Car(/*Empty constructor*/){}
    public Car
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
       Long daily_rent_value,
       String parameter_description,
       byte[] parameter_photo01,
       byte[] parameter_photo02,
       byte[] parameter_photo03,
       byte[] parameter_photo04
    )
    {
        super(parameter_owner_id , parameter_brand , parameter_model , parameter_year , parameter_license_plate);
        this.title = parameter_title;
        this.location = parameter_location;
        this.transmission = parameter_transmission;
        this.mileage = parameter_mileage;
        this.main_fuel = parameter_main_fuel;
        this.secondary_fuel = parameter_secondary_fuel;
        this.engine_power = parameter_engine_Power;
        this.steering_system = parameter_steering_system;
        this.number_of_seats = parameter_number_of_seats;
        this.daily_rent_value = daily_rent_value;
        this.description = parameter_description;
        /////////////////////////////////////////
        this.views_counter = 0L;
        this.status = Status.AVAILABLE;
        this.photo01 = parameter_photo01;
        this.photo02 = parameter_photo02;
        this.photo03 = parameter_photo03;
        this.photo04 = parameter_photo04;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String location;

    @Column()
    private String transmission;

    @Column()
    private String mileage;

    @Column(nullable = false)
    private String main_fuel;

    @Column()
    private String secondary_fuel;

    @Column(nullable = false)
    private String engine_power;

    @Column()
    private String steering_system;

    @Column(nullable = false)
    private String number_of_seats;

    @Column()
    private Long daily_rent_value;

    @Column()
    private Long views_counter;

    @Column()
    private java.sql.Timestamp created_at;

    @Column(nullable = false)
    private Status status;

    @Column()
    private String description;

    @Lob private byte[] photo01;
    @Lob private byte[] photo02;
    @Lob private byte[] photo03;
    @Lob private byte[] photo04;

    //////////////////////////////////////////

    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}

    public String getTitle() {return title;}
    public void setTitle(String title) {this.title = title;}

    public String getLocation() {return location;}
    public void setLocation(String location) {this.location = location;}

    public String getTransmission() {return transmission;}
    public void setTransmission(String transmission) {this.transmission = transmission;}

    public String getMileage() {return mileage;}
    public void setMileage(String mileage) {this.mileage = mileage;}

    public String getMain_fuel() {return main_fuel;}
    public void setMain_fuel(String main_fuel) {this.main_fuel = main_fuel;}

    public String getSecondary_fuel() {return secondary_fuel;}
    public void setSecondary_fuel(String secondary_fuel) {this.secondary_fuel = secondary_fuel;}

    public String getEngine_power() {return engine_power;}
    public void setEngine_power(String engine_power) {this.engine_power = engine_power;}

    public String getSteering_system() {return steering_system;}
    public void setSteering_system(String steering_system) {this.steering_system = steering_system;}

    public String getNumber_of_seats() {return number_of_seats;}
    public void setNumber_of_seats(String number_of_seats) {this.number_of_seats = number_of_seats;}

    public Long getDaily_rent_value() {return daily_rent_value;}
    public void setDaily_rent_value(Long daily_rent_value) {this.daily_rent_value = daily_rent_value;}

    public Long getViews_counter() {return views_counter;}
    public void setViews_counter(Long views_counter) {this.views_counter = views_counter;}

    public Timestamp getCreated_at() {return created_at;}
    public void setCreated_at(Timestamp created_at) {this.created_at = created_at;}

    public Status getStatus() {return status;}
    public void setStatus(Status status) {this.status = status;}

    public String getDescription() {return description;}
    public void setDescription(String description) {this.description = description;}

    public byte[] getPhoto01() {return photo01;}
    public void setPhoto01(byte[] photo01) {this.photo01 = photo01;}

    public byte[] getPhoto02() {return photo02;}
    public void setPhoto02(byte[] photo02) {this.photo02 = photo02;}

    public byte[] getPhoto03() {return photo03;}
    public void setPhoto03(byte[] photo03) {this.photo03 = photo03;}

    public byte[] getPhoto04() {return photo04;}
    public void setPhoto04(byte[] photo04) {this.photo04 = photo04;}

    /////////////////////////////////////////////////////////////////////////////////
}
