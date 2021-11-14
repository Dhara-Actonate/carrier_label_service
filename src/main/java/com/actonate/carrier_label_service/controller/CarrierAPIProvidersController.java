package com.actonate.carrier_label_service.controller;

import com.actonate.carrier_label_service.exceptions.BadRequestException;
import com.actonate.carrier_label_service.exceptions.NotFoundException;
import com.actonate.carrier_label_service.model.CarrierAPIProviders;
import com.actonate.carrier_label_service.responses.StandardResponse;
import com.actonate.carrier_label_service.responses.StandardResponseBuilder;
import com.actonate.carrier_label_service.service.CarrierAPIProvidersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CarrierAPIProvidersController {
    /**
     * StandardResponseBuilder to build standard responses for client.
     */
    @Autowired
    private StandardResponseBuilder standardResponseBuilder;

    /**
     * CustomerService instance.
     */
    @Autowired
    private CarrierAPIProvidersService carrierAPIProvidersService;

    @PostMapping("/carrier-api-providers")
    public ResponseEntity<StandardResponse<CarrierAPIProviders>> create(
            @RequestBody final CarrierAPIProviders toCreate
    ) throws BadRequestException, NotFoundException {

        System.out.println("CREATE CarrierAPIProviders API IS CALLED");
        CarrierAPIProviders carrierAPIProvider = this.carrierAPIProvidersService.create(toCreate);
        System.out.println("CarrierAPIProviders CREATED SUCCESSFUL");

        StandardResponse<CarrierAPIProviders> standardResponse =
                standardResponseBuilder.createSuccessResponse(
                        carrierAPIProvider,
                        HttpStatus.OK.getReasonPhrase(),
                        HttpStatus.OK.value(),
                        "CarrierAPIProviders created"
                );
        return new ResponseEntity<>(standardResponse, HttpStatus.OK);
    }

    @GetMapping("/carrier-api-providers")
    public ResponseEntity<StandardResponse<List<CarrierAPIProviders>>> getAllData() throws BadRequestException {
        List<CarrierAPIProviders> documents = this.carrierAPIProvidersService.findAll();
        StandardResponse<List<CarrierAPIProviders>> standardResponse =
                standardResponseBuilder.createSuccessResponse(
                        documents,
                        HttpStatus.OK.getReasonPhrase(),
                        HttpStatus.OK.value(),
                        "Fetched CarrierAPIProviders."
                );
        return new ResponseEntity<>(standardResponse, HttpStatus.OK);
    }

    @GetMapping("/carrier-api-providers/{id}")
    public ResponseEntity<StandardResponse<CarrierAPIProviders>> getSingleData(@PathVariable String id) throws BadRequestException {
       CarrierAPIProviders documents = this.carrierAPIProvidersService.findById(id);
        StandardResponse<CarrierAPIProviders> standardResponse =
                standardResponseBuilder.createSuccessResponse(
                        documents,
                        HttpStatus.OK.getReasonPhrase(),
                        HttpStatus.OK.value(),
                        "Fetched CarrierAPIProviders."
                );
        return new ResponseEntity<>(standardResponse, HttpStatus.OK);
    }

    @PutMapping("/carrier-api-providers/{id}")
    public ResponseEntity<StandardResponse<CarrierAPIProviders>> update(
            @PathVariable final String id,
            @RequestBody final CarrierAPIProviders toCreate
    ) throws BadRequestException, NotFoundException {

        System.out.println("UPDATE CarrierAPIProviders API IS CALLED");
        CarrierAPIProviders document = this.carrierAPIProvidersService.update(toCreate,id);
        System.out.println("CarrierAPIProviders UPDATED SUCCESSFUL");

        StandardResponse<CarrierAPIProviders> standardResponse =
                standardResponseBuilder.createSuccessResponse(
                        document,
                        HttpStatus.OK.getReasonPhrase(),
                        HttpStatus.OK.value(),
                        "CarrierAPIProviders Updated"
                );
        return new ResponseEntity<>(standardResponse, HttpStatus.OK);
    }

    @DeleteMapping("/carrier-api-providers/{id}")
    public ResponseEntity<StandardResponse<Boolean>> delete(@PathVariable String id) throws BadRequestException, NotFoundException {
        System.out.println("DELETE CarrierAPIProviders API IS CALLED");
        Boolean isDeleted = this.carrierAPIProvidersService.delete(id);
        System.out.println("CarrierAPIProviders DELETED SUCCESSFUL");

        StandardResponse<Boolean> standardResponse =
                standardResponseBuilder.createSuccessResponse(
                        isDeleted,
                        HttpStatus.OK.getReasonPhrase(),
                        HttpStatus.OK.value(),
                        "CarrierAPIProviders Deleted"
                );
        return new ResponseEntity<>(standardResponse, HttpStatus.OK);
    }
}
