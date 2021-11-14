package com.actonate.carrier_label_service.service;

import com.actonate.carrier_label_service.constants.CarrierConstants;
import com.actonate.carrier_label_service.exceptions.BadRequestException;
import com.actonate.carrier_label_service.exceptions.ErrorCodes;
import com.actonate.carrier_label_service.model.CarrierAPIProviders;
import com.actonate.carrier_label_service.model.CarrierServices;
import com.actonate.carrier_label_service.model.Carriers;
import com.actonate.carrier_label_service.model.Shipments;
import com.actonate.carrier_label_service.service.providers.ShiprocketProviderService;
import com.actonate.carrier_label_service.view_model.CarrierShipmentInfoViewModel;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarrierLabelGeneratorServiceImpl implements CarrierLabelGeneratorService {

    @Autowired
    ShipmentsService shipmentsService;

    @Autowired
    CarriersService carriersService;

    @Autowired
    CarrierServicesService carrierServicesService;

    @Autowired
    CarrierAPIProvidersService carrierAPIProvidersService;

//    @Override
//    public void generateLabelBulk(List<CarrierShipmentInfoViewModel> shipmentDetails) {
//        System.out.println("Inside CarrierLabelGeneratorServiceImpl.generateLabelBulk()"+shipmentDetails);
//        shipmentDetails.forEach(shipmentDetail -> {
//            generateLabel(shipmentDetail);
//        });
//    }

    @Override
    public void generateLabel(CarrierShipmentInfoViewModel shipmentDetail) {

        try {

            // for validating incoming object
            validateShipmentDetail(shipmentDetail);

            String providerCode = shipmentDetail.getProviderCode();

            System.out.println("Inside CarrierLabelGeneratorServiceImpl.generateLabel():" + providerCode);

            CarrierAPIProviders providerDetail = carrierAPIProvidersService.findByCode("SHIPROCKET");

            String carrierConfigStr = "";
            if(shipmentDetail.getConfigEnvironment().equals(CarrierConstants.DEVELOPMENT)) {
                carrierConfigStr = providerDetail.getEnvConfigurationDev();
            } else if(shipmentDetail.getConfigEnvironment().equals(CarrierConstants.PRODUCTION)) {
                carrierConfigStr = providerDetail.getEnvConfigurationDev();
            }

            JSONParser parser = new JSONParser();
            JSONObject jsonConfig = new JSONObject();
            if(carrierConfigStr.isEmpty()) {
                jsonConfig = (JSONObject) parser.parse(carrierConfigStr);
            }

            switch (providerCode) {
                case "SHIPROCKET":

                    ShiprocketProviderService shiprocketProviderService = new ShiprocketProviderService();
                    shiprocketProviderService.generateLabel(shipmentDetail, jsonConfig);

                    break;
                default:
                    break;
            }

        } catch (Exception e) {
            System.out.println("Error:"+e.getMessage());
        }
    }

    private boolean validateShipmentDetail(CarrierShipmentInfoViewModel shipmentDetail) {

        System.out.println("validateShipmentDetail");

        String carrierServiceCode = shipmentDetail.getCarrierServiceCode();
        String carrierCode = shipmentDetail.getCarrierCode();
        String providerCode = shipmentDetail.getProviderCode();

        String shipmentId = shipmentDetail.getShipmentInfo().getId();

        String trackingCode = shipmentDetail.getShipmentInfo().getTrackingCode();

        try {

            if(carrierCode.isEmpty() || carrierServiceCode.isEmpty() || providerCode.isEmpty() || shipmentId.isEmpty() || trackingCode.isEmpty()) {
                throw new BadRequestException("Input parameters are invalid.", ErrorCodes.INVALID_DATA_EXCEPTION.getCode());
            }

            Carriers carrier = this.carriersService.findByCode(carrierCode);

            CarrierServices carrierServices = this.carrierServicesService.findByCode(carrierServiceCode);

            CarrierAPIProviders carrierAPIProviders = this.carrierAPIProvidersService.findByCode(providerCode);

            Shipments shipment = this.shipmentsService.findById(shipmentId);

            return true;
        } catch (Exception e) {
            System.out.println("Error in validation"+ e.getMessage());

            return false;
        }
    }
}
