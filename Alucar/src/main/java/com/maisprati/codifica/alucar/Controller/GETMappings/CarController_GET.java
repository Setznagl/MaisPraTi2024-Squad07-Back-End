package com.maisprati.codifica.alucar.Controller.GETMappings;

import com.maisprati.codifica.alucar.Exceptions.NotFoundDataException;
import com.maisprati.codifica.alucar.Models.Products.Car;
import com.maisprati.codifica.alucar.Services.Advertisement.CarService;
import com.maisprati.codifica.alucar.Util.Enum.PRODUCT_STATUS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class CarController_GET {

    @GetMapping("/get-car/id/")
    public ResponseEntity<EntityModel<Car>> getCarByID(@RequestParam Long id) {
        Car temp = carService.FindCarById(id);
        if(temp != null){
            EntityModel<Car> carEntityModel = EntityModel.of(temp,
                    linkTo(methodOn(CarController_GET.class).getCarByID(id)).withSelfRel(),
                    linkTo(methodOn(CarController_GET.class).getCarsFromRenter(temp.getOwner_id())).withRel("AllCarsFromRenter")
            );
            temp.setViews_counter(temp.getViews_counter() + 1);
            return ResponseEntity.status(HttpStatus.OK).body(carEntityModel);
        }else{throw new NotFoundDataException("Car not found");}
    }

    @GetMapping("/get-cars-from-renter/id")
    public ResponseEntity<CollectionModel<EntityModel<Car>>> getCarsFromRenter(@RequestParam Long renterID) {
        List<Car> temp = carService.FindAllCarsByRenterID(renterID);
        if(temp != null){
            List<EntityModel<Car>> carEntityModels = temp.stream()
                .map(car -> EntityModel.of(car,
                   linkTo(methodOn(CarController_GET.class).getCarByID(car.getId())).withSelfRel(),
                   linkTo(methodOn(CarController_GET.class).getCarsFromRenter(renterID)).withRel("AllCarsFromRenter")))
                .collect(Collectors.toList());

            return ResponseEntity.ok(CollectionModel.of(carEntityModels,
                   linkTo(methodOn(CarController_GET.class).getCarsFromRenter(renterID)).withSelfRel()));
        }else {throw new NotFoundDataException("No one car was found for this user");}
    }

    @GetMapping("/get-available-cars-from-renter/id")
    public ResponseEntity<CollectionModel<EntityModel<Car>>> getAvailableCarsFromRenter(@RequestParam Long renterID) {
        List<Car> temp = carService.FindAllAvailableCarsByRenterID(renterID, PRODUCT_STATUS.AVAILABLE);
        if(temp != null){
            List<EntityModel<Car>> carEntityModels = temp.stream()
                    .map(car -> EntityModel.of(car,
                            linkTo(methodOn(CarController_GET.class).getCarByID(car.getId())).withSelfRel(),
                            linkTo(methodOn(CarController_GET.class).getAvailableCarsFromRenter(renterID)).withRel("AllAvailableCarsFromRenter")))
                    .collect(Collectors.toList());

            return ResponseEntity.ok(CollectionModel.of(carEntityModels,
                    linkTo(methodOn(CarController_GET.class).getCarsFromRenter(renterID)).withSelfRel()));
        }else {throw new NotFoundDataException("No one car was found for this user");}
    }

    @Autowired
    CarController_GET(CarService carService){
        this.carService = carService;
    }private final CarService carService;
}
