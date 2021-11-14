package com.actonate.carrier_label_service.controller;

import com.actonate.carrier_label_service.exceptions.BadRequestException;
import com.actonate.carrier_label_service.exceptions.NotFoundException;
import com.actonate.carrier_label_service.model.CarrierServices;
import com.actonate.carrier_label_service.model.Carriers;
import com.actonate.carrier_label_service.responses.StandardResponse;
import com.actonate.carrier_label_service.responses.StandardResponseBuilder;
import com.actonate.carrier_label_service.service.CarrierServicesService;
import com.actonate.carrier_label_service.service.CarriersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CarriersController {
    /**
     * StandardResponseBuilder to build standard responses for client.
     */
    @Autowired
    private StandardResponseBuilder standardResponseBuilder;

    /**
     * CarrierServicesService instance.
     */
    @Autowired
    private CarriersService carriersService;

    @PostMapping("/carriers")
    public ResponseEntity<StandardResponse<Carriers>> create(
            @RequestBody final Carriers toCreate
    ) throws BadRequestException, NotFoundException {

        System.out.println("CREATE Carriers API IS CALLED");
        Carriers entity = this.carriersService.create(toCreate);
        System.out.println("Carriers CREATED SUCCESSFUL");

        StandardResponse<Carriers> standardResponse =
                standardResponseBuilder.createSuccessResponse(
                        entity,
                        HttpStatus.OK.getReasonPhrase(),
                        HttpStatus.OK.value(),
                        "Carriers created"
                );
        return new ResponseEntity<>(standardResponse, HttpStatus.OK);
    }

    @GetMapping("/carriers")
    public ResponseEntity<StandardResponse<List<Carriers>>> getAllData() throws BadRequestException {
        List<Carriers> documents = this.carriersService.findAll();
        StandardResponse<List<Carriers>> standardResponse =
                standardResponseBuilder.createSuccessResponse(
                        documents,
                        HttpStatus.OK.getReasonPhrase(),
                        HttpStatus.OK.value(),
                        "Fetched Carriers."
                );
        return new ResponseEntity<>(standardResponse, HttpStatus.OK);
    }

    @GetMapping("/carriers/{id}")
    public ResponseEntity<StandardResponse<Carriers>> getSingleData(@PathVariable String id) throws BadRequestException {
        Carriers documents = this.carriersService.findById(id);
        StandardResponse<Carriers> standardResponse =
                standardResponseBuilder.createSuccessResponse(
                        documents,
                        HttpStatus.OK.getReasonPhrase(),
                        HttpStatus.OK.value(),
                        "Fetched Carriers."
                );
        return new ResponseEntity<>(standardResponse, HttpStatus.OK);
    }

    @PutMapping("/carriers/{id}")
    public ResponseEntity<StandardResponse<Carriers>> update(
            @PathVariable final String id,
            @RequestBody final Carriers toCreate
    ) throws BadRequestException, NotFoundException {

        System.out.println("UPDATE Carriers API IS CALLED");
        Carriers document = this.carriersService.update(toCreate,id);
        System.out.println("Carriers UPDATED SUCCESSFUL");

        StandardResponse<Carriers> standardResponse =
                standardResponseBuilder.createSuccessResponse(
                        document,
                        HttpStatus.OK.getReasonPhrase(),
                        HttpStatus.OK.value(),
                        "Carriers Updated"
                );
        return new ResponseEntity<>(standardResponse, HttpStatus.OK);
    }

    @DeleteMapping("/carriers/{id}")
    public ResponseEntity<StandardResponse<Boolean>> delete(@PathVariable String id) throws BadRequestException, NotFoundException {
        System.out.println("DELETE Carriers API IS CALLED");
        Boolean isDeleted = this.carriersService.delete(id);
        System.out.println("Carriers DELETED SUCCESSFUL");

        StandardResponse<Boolean> standardResponse =
                standardResponseBuilder.createSuccessResponse(
                        isDeleted,
                        HttpStatus.OK.getReasonPhrase(),
                        HttpStatus.OK.value(),
                        "Carriers Deleted"
                );
        return new ResponseEntity<>(standardResponse, HttpStatus.OK);
    }
}
