package com.actonate.carrier_label_service.controller;

import com.actonate.carrier_label_service.exceptions.BadRequestException;
import com.actonate.carrier_label_service.exceptions.NotFoundException;
import com.actonate.carrier_label_service.model.Carriers;
import com.actonate.carrier_label_service.model.ShipmentItems;
import com.actonate.carrier_label_service.responses.StandardResponse;
import com.actonate.carrier_label_service.responses.StandardResponseBuilder;
import com.actonate.carrier_label_service.service.CarriersService;
import com.actonate.carrier_label_service.service.ShipmentItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ShipmentItemsController {

    /**
     * StandardResponseBuilder to build standard responses for client.
     */
    @Autowired
    private StandardResponseBuilder standardResponseBuilder;

    /**
     * CarrierServicesService instance.
     */
    @Autowired
    private ShipmentItemsService shipmentItemsService;

    @PostMapping("/shipment-items")
    public ResponseEntity<StandardResponse<ShipmentItems>> create(
            @RequestBody final ShipmentItems toCreate
    ) throws BadRequestException, NotFoundException {

        System.out.println("CREATE ShipmentItems API IS CALLED");
        ShipmentItems entity = this.shipmentItemsService.create(toCreate);
        System.out.println("ShipmentItems CREATED SUCCESSFUL");

        StandardResponse<ShipmentItems> standardResponse =
                standardResponseBuilder.createSuccessResponse(
                        entity,
                        HttpStatus.OK.getReasonPhrase(),
                        HttpStatus.OK.value(),
                        "ShipmentItems created"
                );
        return new ResponseEntity<>(standardResponse, HttpStatus.OK);
    }

    @GetMapping("/shipment-items")
    public ResponseEntity<StandardResponse<List<ShipmentItems>>> getAllData() throws BadRequestException {
        List<ShipmentItems> documents = this.shipmentItemsService.findAll();
        StandardResponse<List<ShipmentItems>> standardResponse =
                standardResponseBuilder.createSuccessResponse(
                        documents,
                        HttpStatus.OK.getReasonPhrase(),
                        HttpStatus.OK.value(),
                        "Fetched ShipmentItems."
                );
        return new ResponseEntity<>(standardResponse, HttpStatus.OK);
    }

    @GetMapping("/shipment-items/{id}")
    public ResponseEntity<StandardResponse<ShipmentItems>> getSingleData(@PathVariable String id) throws BadRequestException {
        ShipmentItems documents = this.shipmentItemsService.findById(id);
        StandardResponse<ShipmentItems> standardResponse =
                standardResponseBuilder.createSuccessResponse(
                        documents,
                        HttpStatus.OK.getReasonPhrase(),
                        HttpStatus.OK.value(),
                        "Fetched ShipmentItems."
                );
        return new ResponseEntity<>(standardResponse, HttpStatus.OK);
    }

    @PutMapping("/shipment-items/{id}")
    public ResponseEntity<StandardResponse<ShipmentItems>> update(
            @PathVariable final String id,
            @RequestBody final ShipmentItems toCreate
    ) throws BadRequestException, NotFoundException {

        System.out.println("UPDATE ShipmentItems API IS CALLED");
        ShipmentItems document = this.shipmentItemsService.update(toCreate,id);
        System.out.println("ShipmentItems UPDATED SUCCESSFUL");

        StandardResponse<ShipmentItems> standardResponse =
                standardResponseBuilder.createSuccessResponse(
                        document,
                        HttpStatus.OK.getReasonPhrase(),
                        HttpStatus.OK.value(),
                        "ShipmentItems Updated"
                );
        return new ResponseEntity<>(standardResponse, HttpStatus.OK);
    }

    @DeleteMapping("/shipment-items/{id}")
    public ResponseEntity<StandardResponse<Boolean>> delete(@PathVariable String id) throws BadRequestException, NotFoundException {
        System.out.println("DELETE ShipmentItems API IS CALLED");
        Boolean isDeleted = this.shipmentItemsService.delete(id);
        System.out.println("ShipmentItems DELETED SUCCESSFUL");

        StandardResponse<Boolean> standardResponse =
                standardResponseBuilder.createSuccessResponse(
                        isDeleted,
                        HttpStatus.OK.getReasonPhrase(),
                        HttpStatus.OK.value(),
                        "ShipmentItems Deleted"
                );
        return new ResponseEntity<>(standardResponse, HttpStatus.OK);
    }
}
