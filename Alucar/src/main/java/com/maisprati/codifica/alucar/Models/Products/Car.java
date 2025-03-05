package com.maisprati.codifica.alucar.Models.Products;

import com.maisprati.codifica.alucar.Util.Enum.Status;
import jakarta.persistence.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Arrays;

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
    public Car (
            Long parameter_owner_id,
            String parameter_brand,
            String parameter_model ,
            java.sql.Date parameter_year,
            String parameter_license_plate
    ){
        super(parameter_owner_id, parameter_brand, parameter_model, parameter_year, parameter_license_plate);
        this.title = " ";
        this.location = " ";
        this.transmission = " ";
        this.mileage = " ";
        this.main_fuel = " ";
        this.secondary_fuel = " ";
        this.engine_power = " ";
        this.steering_system = " ";
        this.number_of_seats = " ";
        this.daily_rent_value = 0D;
        this.created_at = Timestamp.valueOf(LocalDateTime.now());
        this.description = " ";
        /////////////////////////////////////////
        this.views_counter = 0L;
        this.status = Status.AVAILABLE;
        this.photo01 = " ".getBytes();
        this.photo02 = " ".getBytes();
        this.photo03 = " ".getBytes();
        this.photo04 = " ".getBytes();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column()
    private String title;

    @Column()
    private String location;

    @Column()
    private String transmission;

    @Column()
    private String mileage;

    @Column(nullable = false)
    private String main_fuel;

    @Column()
    private String secondary_fuel;

    @Column()
    private String engine_power;

    @Column()
    private String steering_system;

    @Column()
    private String number_of_seats;

    @Column()
    private Double daily_rent_value;

    @Column()
    private Long views_counter;

    @Column()
    private java.sql.Timestamp created_at;

    @Column()
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

    public Double getDaily_rent_value() {return daily_rent_value;}
    public void setDaily_rent_value(Double daily_rent_value) {this.daily_rent_value = daily_rent_value;}

    public Long getViews_counter() {return views_counter;}
    public void setViews_counter(Long views_counter) {this.views_counter = views_counter;}

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

    @Override
    public String toString() {
        return "\n\nCar{" +"\n" +
                "id=" + id +"\n" +
                "owner_id" + this.getOwner_id() +"\n" +
                "brand" + this.getBrand() +"\n" +
                "model " + this.getModel() +"\n" +
                "year" + this.getYear() +"\n" +
                "license_plate" + this.getLicense_plate() +"\n" +
                "title='" + title +"\n" +
                "location='" + location +"\n" +
                "transmission='" + transmission +"\n" +
                "mileage='" + mileage +"\n" +
                "main_fuel='" + main_fuel +"\n" +
                "secondary_fuel='" + secondary_fuel +"\n" +
                "engine_power='" + engine_power +"\n" +
                "steering_system='" + steering_system +"\n" +
                "number_of_seats='" + number_of_seats +"\n" +
                "daily_rent_value=" + daily_rent_value +"\n" +
                "views_counter=" + views_counter +"\n" +
                "created_at=" + created_at +"\n" +
                "status=" + status +"\n" +
                "description='" + description +"\n" +
                "photo01=" + Arrays.toString(photo01) +"\n" +
                "photo02=" + Arrays.toString(photo02) +"\n" +
                "photo03=" + Arrays.toString(photo03) +"\n" +
                "photo04=" + Arrays.toString(photo04) +"\n" +
                "\n\n"+
                '}';
    }

    /////////////////////////////////////////////////////////////////////////////////
}
