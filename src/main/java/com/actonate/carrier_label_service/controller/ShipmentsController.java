package com.actonate.carrier_label_service.controller;

import com.actonate.carrier_label_service.exceptions.BadRequestException;
import com.actonate.carrier_label_service.exceptions.NotFoundException;
import com.actonate.carrier_label_service.model.ShipmentItems;
import com.actonate.carrier_label_service.model.Shipments;
import com.actonate.carrier_label_service.responses.StandardResponse;
import com.actonate.carrier_label_service.responses.StandardResponseBuilder;
import com.actonate.carrier_label_service.service.ShipmentItemsService;
import com.actonate.carrier_label_service.service.ShipmentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ShipmentsController {

    /**
     * StandardResponseBuilder to build standard responses for client.
     */
    @Autowired
    private StandardResponseBuilder standardResponseBuilder;

    /**
     * CarrierServicesService instance.
     */
    @Autowired
    private ShipmentsService shipmentsService;

    @PostMapping("/shipments")
    public ResponseEntity<StandardResponse<Shipments>> create(
            @RequestBody final Shipments toCreate
    ) throws BadRequestException, NotFoundException {

        System.out.println("CREATE Shipments API IS CALLED");
        Shipments entity = this.shipmentsService.create(toCreate);
        System.out.println("Shipments CREATED SUCCESSFUL");

        StandardResponse<Shipments> standardResponse =
                standardResponseBuilder.createSuccessResponse(
                        entity,
                        HttpStatus.OK.getReasonPhrase(),
                        HttpStatus.OK.value(),
                        "Shipments created"
                );
        return new ResponseEntity<>(standardResponse, HttpStatus.OK);
    }

    @GetMapping("/shipments")
    public ResponseEntity<StandardResponse<List<Shipments>>> getAllData() throws BadRequestException {
        List<Shipments> documents = this.shipmentsService.findAll();
        StandardResponse<List<Shipments>> standardResponse =
                standardResponseBuilder.createSuccessResponse(
                        documents,
                        HttpStatus.OK.getReasonPhrase(),
                        HttpStatus.OK.value(),
                        "Fetched Shipments."
                );
        return new ResponseEntity<>(standardResponse, HttpStatus.OK);
    }

    @GetMapping("/shipments/{id}")
    public ResponseEntity<StandardResponse<Shipments>> getSingleData(@PathVariable String id) throws BadRequestException {
        Shipments documents = this.shipmentsService.findById(id);
        StandardResponse<Shipments> standardResponse =
                standardResponseBuilder.createSuccessResponse(
                        documents,
                        HttpStatus.OK.getReasonPhrase(),
                        HttpStatus.OK.value(),
                        "Fetched Shipments."
                );
        return new ResponseEntity<>(standardResponse, HttpStatus.OK);
    }

    @PutMapping("/shipments/{id}")
    public ResponseEntity<StandardResponse<Shipments>> update(
            @PathVariable final String id,
            @RequestBody final Shipments toCreate
    ) throws BadRequestException, NotFoundException {

        System.out.println("UPDATE Shipments API IS CALLED");
        Shipments document = this.shipmentsService.update(toCreate,id);
        System.out.println("Shipments UPDATED SUCCESSFUL");

        StandardResponse<Shipments> standardResponse =
                standardResponseBuilder.createSuccessResponse(
                        document,
                        HttpStatus.OK.getReasonPhrase(),
                        HttpStatus.OK.value(),
                        "Shipments Updated"
                );
        return new ResponseEntity<>(standardResponse, HttpStatus.OK);
    }

    @DeleteMapping("/shipments/{id}")
    public ResponseEntity<StandardResponse<Boolean>> delete(@PathVariable String id) throws BadRequestException, NotFoundException {
        System.out.println("DELETE Shipments API IS CALLED");
        Boolean isDeleted = this.shipmentsService.delete(id);
        System.out.println("Shipments DELETED SUCCESSFUL");

        StandardResponse<Boolean> standardResponse =
                standardResponseBuilder.createSuccessResponse(
                        isDeleted,
                        HttpStatus.OK.getReasonPhrase(),
                        HttpStatus.OK.value(),
                        "Shipments Deleted"
                );
        return new ResponseEntity<>(standardResponse, HttpStatus.OK);
    }
}
