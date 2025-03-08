package com.maisprati.codifica.alucar.Controller.GETMappings;

import com.maisprati.codifica.alucar.Exceptions.NotFoundDataException;
import com.maisprati.codifica.alucar.Models.RentModels.CarRent;
import com.maisprati.codifica.alucar.Services.Rent.CarRentService;
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
public class CarRentController_GET {

    @GetMapping("/get-car-rent/id/")
    public ResponseEntity<EntityModel<CarRent>> getCarRentByID(@RequestParam Long id) {
        CarRent temp = carRentService.Find_CarRent_ById(id);
        if (temp != null) {
            EntityModel<CarRent> carRentEntityModel =
                EntityModel.of(temp,
                        linkTo(methodOn(CarRentController_GET.class).getCarRentByID(id)).withSelfRel(),
                        linkTo(methodOn(CarController_GET.class).getCarByID(temp.getAdvertisement_id())).withRel("Car:")
            );
            return ResponseEntity.status(HttpStatus.OK).body(carRentEntityModel);
        }else throw new NotFoundDataException("No one rent with this id could be found!");
    }

    @GetMapping("/get-car-rent/all/id")
    public ResponseEntity<CollectionModel<EntityModel<CarRent>>> getAllCarRentByAnyUserID(@RequestParam Long id) {
        List<CarRent> temp = carRentService.Find_All_Related_CarRent_By_Any_UserID(id);
        if (!temp.isEmpty()) {
            List<EntityModel<CarRent>> carRentEntityModels = temp.stream().map(
                    carRent -> EntityModel.of(carRent,
                        linkTo(methodOn(CarRentController_GET.class).getCarRentByID(carRent.getId())).withSelfRel(),
                        linkTo(methodOn(CarController_GET.class).getCarByID(carRent.getAdvertisement_id())).withRel("Car:")
                    )
            ).collect(Collectors.toList());

            return ResponseEntity.ok(CollectionModel.of(carRentEntityModels,
                    linkTo(methodOn(CarRentController_GET.class).getAllCarRentByAnyUserID(id)).withSelfRel()));

        }else throw new NotFoundDataException("No one rent with this id could be found!");
    }

    @Autowired
    CarRentController_GET(CarRentService carRentService){
        this.carRentService = carRentService;
    }private final CarRentService carRentService;
}
