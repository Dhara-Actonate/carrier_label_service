package com.actonate.carrier_label_service.controller;

import com.actonate.carrier_label_service.constants.CarrierConstants;
import com.actonate.carrier_label_service.service.CarrierLabelGeneratorService;
import com.actonate.carrier_label_service.service.CarrierTrackingProviderService;
import com.actonate.carrier_label_service.view_model.CarrierLabelRequestViewModel;
import com.actonate.carrier_label_service.view_model.CarrierShipmentInfoViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CarrierTrackingProviderController {

    @Autowired
    CarrierLabelGeneratorService carrierLabelGeneratorService;

    @Autowired
    CarrierTrackingProviderService carrierTrackingProviderService;

    @PostMapping("/label/track")
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
                this.carrierTrackingProviderService.trackShipment(details);

            }
        } catch (Exception e) {
            throw new Exception(e);
        }

    }

}
