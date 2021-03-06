package com.actonate.carrier_label_service.controller;

import com.actonate.carrier_label_service.constants.CarrierConstants;
import com.actonate.carrier_label_service.exceptions.BadRequestException;
import com.actonate.carrier_label_service.service.CarrierLabelGeneratorService;
import com.actonate.carrier_label_service.view_model.CarrierLabelRequestViewModel;
import com.actonate.carrier_label_service.view_model.CarrierShipmentInfoViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CarrierLabelGeneratorController {

    @Autowired
    CarrierLabelGeneratorService carrierLabelGeneratorService;

    // add environment - production / staging - add in DB also
    @PostMapping("/label/generate") // /label/generate & /label/track - on demand, queue
    public void generateLabel(@RequestParam String process, @RequestParam String environment, @RequestBody CarrierLabelRequestViewModel data) throws Exception {

        List<CarrierShipmentInfoViewModel> shipmentDetails = data.getData();

        try {

            carrierLabelGeneratorService.validateIncomingRequest(process, environment, shipmentDetails);

            if(process.equals(CarrierConstants.QUEUE)) {
                // push to kafka queue , call producer

                shipmentDetails.forEach(shipmentDetail -> {
                    // push one by one to kafka queue
                    shipmentDetail.setConfigEnvironment(environment);

                });

            } else if(process.equals(CarrierConstants.IMMEDIATE)) {
                System.out.println("inside CarrierLabelGeneratorController.generateLabel() immediate");

                CarrierShipmentInfoViewModel details = shipmentDetails.get(0);
                details.setConfigEnvironment(environment);
                // call service
                carrierLabelGeneratorService.generateLabel(details);

            }
        } catch (Exception e) {
            throw new Exception(e);
        }

    }
}

// if label is already generated (not in error case) then resolve gracefully - in case of tracking call API again

// shipments -> carrier_json , carrier_shipment_generation_json ||  carrier_label -> awb , tracking etc

// workers -> api , pending shipment  /shipments


// foldername , package name - validate by piyush

// immediate - array length 1
// queue - array , individual task push