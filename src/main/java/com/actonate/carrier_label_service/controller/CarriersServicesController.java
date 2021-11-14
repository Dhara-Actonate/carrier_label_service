package com.actonate.carrier_label_service.controller;

import com.actonate.carrier_label_service.exceptions.BadRequestException;
import com.actonate.carrier_label_service.exceptions.NotFoundException;
import com.actonate.carrier_label_service.model.CarrierAPIProviders;
import com.actonate.carrier_label_service.model.CarrierServices;
import com.actonate.carrier_label_service.responses.StandardResponse;
import com.actonate.carrier_label_service.responses.StandardResponseBuilder;
import com.actonate.carrier_label_service.service.CarrierAPIProvidersService;
import com.actonate.carrier_label_service.service.CarrierServicesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CarriersServicesController {
    /**
     * StandardResponseBuilder to build standard responses for client.
     */
    @Autowired
    private StandardResponseBuilder standardResponseBuilder;

    /**
     * CarrierServicesService instance.
     */
    @Autowired
    private CarrierServicesService carrierServicesService;

    @PostMapping("/carrier-services")
    public ResponseEntity<StandardResponse<CarrierServices>> create(
            @RequestBody final CarrierServices toCreate
    ) throws BadRequestException, NotFoundException {

        System.out.println("CREATE CarrierServices API IS CALLED");
        CarrierServices entity = this.carrierServicesService.create(toCreate);
        System.out.println("CarrierServices CREATED SUCCESSFUL");

        StandardResponse<CarrierServices> standardResponse =
                standardResponseBuilder.createSuccessResponse(
                        entity,
                        HttpStatus.OK.getReasonPhrase(),
                        HttpStatus.OK.value(),
                        "CarrierServices created"
                );
        return new ResponseEntity<>(standardResponse, HttpStatus.OK);
    }

    @GetMapping("/carrier-services")
    public ResponseEntity<StandardResponse<List<CarrierServices>>> getAllData() throws BadRequestException {
        List<CarrierServices> documents = this.carrierServicesService.findAll();
        StandardResponse<List<CarrierServices>> standardResponse =
                standardResponseBuilder.createSuccessResponse(
                        documents,
                        HttpStatus.OK.getReasonPhrase(),
                        HttpStatus.OK.value(),
                        "Fetched CarrierServices."
                );
        return new ResponseEntity<>(standardResponse, HttpStatus.OK);
    }

    @GetMapping("/carrier-services/{id}")
    public ResponseEntity<StandardResponse<CarrierServices>> getSingleData(@PathVariable String id) throws BadRequestException {
        CarrierServices documents = this.carrierServicesService.findById(id);
        StandardResponse<CarrierServices> standardResponse =
                standardResponseBuilder.createSuccessResponse(
                        documents,
                        HttpStatus.OK.getReasonPhrase(),
                        HttpStatus.OK.value(),
                        "Fetched CarrierServices."
                );
        return new ResponseEntity<>(standardResponse, HttpStatus.OK);
    }

    @PutMapping("/carrier-services/{id}")
    public ResponseEntity<StandardResponse<CarrierServices>> update(
            @PathVariable final String id,
            @RequestBody final CarrierServices toCreate
    ) throws BadRequestException, NotFoundException {

        System.out.println("UPDATE CarrierServices API IS CALLED");
        CarrierServices document = this.carrierServicesService.update(toCreate,id);
        System.out.println("CarrierServices UPDATED SUCCESSFUL");

        StandardResponse<CarrierServices> standardResponse =
                standardResponseBuilder.createSuccessResponse(
                        document,
                        HttpStatus.OK.getReasonPhrase(),
                        HttpStatus.OK.value(),
                        "CarrierServices Updated"
                );
        return new ResponseEntity<>(standardResponse, HttpStatus.OK);
    }

    @DeleteMapping("/carrier-services/{id}")
    public ResponseEntity<StandardResponse<Boolean>> delete(@PathVariable String id) throws BadRequestException, NotFoundException {
        System.out.println("DELETE CarrierServices API IS CALLED");
        Boolean isDeleted = this.carrierServicesService.delete(id);
        System.out.println("CarrierServices DELETED SUCCESSFUL");

        StandardResponse<Boolean> standardResponse =
                standardResponseBuilder.createSuccessResponse(
                        isDeleted,
                        HttpStatus.OK.getReasonPhrase(),
                        HttpStatus.OK.value(),
                        "CarrierServices Deleted"
                );
        return new ResponseEntity<>(standardResponse, HttpStatus.OK);
    }
}
