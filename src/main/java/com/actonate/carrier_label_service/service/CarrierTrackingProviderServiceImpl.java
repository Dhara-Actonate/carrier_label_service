package com.actonate.carrier_label_service.service;

import com.actonate.carrier_label_service.constants.CarrierConstants;
import com.actonate.carrier_label_service.exceptions.BadRequestException;
import com.actonate.carrier_label_service.model.CarrierAPIProviders;
import com.actonate.carrier_label_service.model.CarrierLabels;
import com.actonate.carrier_label_service.model.Shipments;
import com.actonate.carrier_label_service.service.providers.ShiprocketProviderService;
import com.actonate.carrier_label_service.view_model.CarrierShipmentInfoViewModel;
import com.actonate.carrier_label_service.view_model.ProviderConfigViewModel;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarrierTrackingProviderServiceImpl implements CarrierTrackingProviderService {


    @Autowired
    CarrierLabelGeneratorService carrierLabelGeneratorService;

    @Autowired
    CarrierAPIProvidersService carrierAPIProvidersService;

    @Autowired
    ShipmentsService shipmentsService;

    @Autowired
    CarrierLabelsService carrierLabelsService;

    @Override
    public void trackShipment(CarrierShipmentInfoViewModel shipmentDetail) throws Exception {

        try {

            // for validating incoming object
            carrierLabelGeneratorService.validateShipmentDetail(shipmentDetail);

            String providerCode = shipmentDetail.getProviderCode();

            System.out.println("Inside CarrierTrackingProviderServiceImpl.trackShipment():" + providerCode);

            ProviderConfigViewModel jsonConfig = this.carrierLabelGeneratorService.getProviderConfig(shipmentDetail.getProviderCode(), shipmentDetail.getConfigEnvironment());

            Shipments shipment = this.shipmentsService.findById(shipmentDetail.getShipmentInfo().getId());

            System.out.println("Shipment Obj:"+ shipment + shipment.getCarrierLabelId());

            if( shipment.getCarrierLabelId().isEmpty()) {
                throw new BadRequestException("Shipment label id not found!");
            }

            CarrierLabels labelInfo = this.carrierLabelsService.findById(shipment.getCarrierLabelId());

            String trackingResponse = new String();

            switch (providerCode) {
                case "SHIPROCKET":

                    ShiprocketProviderService shiprocketProviderService = new ShiprocketProviderService();
                    trackingResponse = shiprocketProviderService.generateTrackingInfo(shipmentDetail, jsonConfig);

                    break;
                default:
                    break;
            }

            labelInfo.setTrackingResponseRaw(trackingResponse);
            this.carrierLabelsService.update( labelInfo, shipment.getCarrierLabelId());

        } catch (Exception e) {
            System.out.println("Error:"+e.getMessage());
            throw new Exception(e);
        }
    }
}
