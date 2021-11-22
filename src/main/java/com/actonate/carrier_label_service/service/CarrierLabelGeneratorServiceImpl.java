package com.actonate.carrier_label_service.service;

import com.actonate.carrier_label_service.constants.CarrierConstants;
import com.actonate.carrier_label_service.exceptions.BadRequestException;
import com.actonate.carrier_label_service.exceptions.ErrorCodes;
import com.actonate.carrier_label_service.model.*;
import com.actonate.carrier_label_service.service.providers.ShiprocketProviderService;
import com.actonate.carrier_label_service.view_model.CarrierShipmentInfoViewModel;
import com.actonate.carrier_label_service.view_model.ProviderConfigViewModel;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
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

    @Autowired
    CarrierLabelsService carrierLabelsService;

    private static ObjectMapper objectMapper = new ObjectMapper();
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

            Shipments shipment = this.shipmentsService.findById(shipmentDetail.getShipmentInfo().getId());

            System.out.println("Shipment Obj:"+ shipment + shipment.getCarrierLabelId());
            // if label with success status is already found in shipment then return

            if(shipment.getCarrierLabelId() == null || shipment.getCarrierLabelId().isEmpty()) {
                System.out.println("==Label ID not found:");

                Carriers carrier = this.carriersService.findByCode(shipmentDetail.getCarrierCode());

                String providerCode = shipmentDetail.getProviderCode();

                System.out.println("Inside CarrierLabelGeneratorServiceImpl.generateLabel():" + providerCode);

                ProviderConfigViewModel jsonConfig = this.getProviderConfig(shipmentDetail.getProviderCode(), shipmentDetail.getConfigEnvironment());

                System.out.println("---- jsonConfig" + jsonConfig);

                CarrierLabels labelInfo = new CarrierLabels();

                switch (providerCode) {
                    case "SHIPROCKET":

                        ShiprocketProviderService shiprocketProviderService = new ShiprocketProviderService();
                        labelInfo = shiprocketProviderService.generateLabel(shipmentDetail, jsonConfig); // label url, response & status will be filled

                        break;
                    default:
                        break;
                }

                System.out.println("---- labelInfo from service" + labelInfo);
                labelInfo.setShipmentId(shipment.getId());
                labelInfo.setAirwayBillCode(shipment.getAwbNo());
                labelInfo.setOrderTrackingCode(shipment.getTrackingCode());
                labelInfo.setCarrierId(carrier.getId());
//            labelInfo.setCarrierServiceId(carrierServices.getId());
                labelInfo.setLabelGeneratedAt(new Date());

                // save label obj
                CarrierLabels savedLabel = carrierLabelsService.create(labelInfo);

                if(labelInfo.getLabelGenerateStatus().equals("SUCCESS")) {
                    shipment.setCarrierLabelId(savedLabel.getId());
                    shipmentsService.update(shipment, shipment.getId());
                }
            }


        } catch (Exception e) {
            System.out.println("Error:"+e.getMessage());
        }
    }

    @Override
    public ProviderConfigViewModel getProviderConfig(String providerCode, String environment) throws JsonProcessingException {
        CarrierAPIProviders providerDetail = carrierAPIProvidersService.findByCode(providerCode);

        String carrierConfigStr = "";
        if(environment.equals(CarrierConstants.DEVELOPMENT)) {
            carrierConfigStr = providerDetail.getEnvConfigurationDev();
        } else if(environment.equals(CarrierConstants.PRODUCTION)) {
            carrierConfigStr = providerDetail.getEnvConfigurationProd();
        }


        System.out.println("---- carrierConfigStr" + carrierConfigStr + providerDetail.getEnvConfigurationDev());

        ProviderConfigViewModel jsonConfig = new ProviderConfigViewModel();
        if(!carrierConfigStr.isEmpty()) {

            jsonConfig = objectMapper.readValue(carrierConfigStr, ProviderConfigViewModel.class);
        }

        return jsonConfig;
    }

    @Override
    public boolean validateShipmentDetail(CarrierShipmentInfoViewModel shipmentDetail) {

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

    @Override
    public void validateIncomingRequest(String process, String environment, List<CarrierShipmentInfoViewModel> shipmentDetails) {
        if(!(environment.equals(CarrierConstants.DEVELOPMENT) || environment.equals(CarrierConstants.PRODUCTION))) {
            // throw error
            throw new BadRequestException("Invalid environment argument!");
        }

        if(process.equals(CarrierConstants.QUEUE)) {
            // push to kafka queue , call producer
            if(shipmentDetails.size() <= 0) {

                throw new BadRequestException("Invalid length of request parameter!");
            }
        } else if(process.equals(CarrierConstants.IMMEDIATE)) {
            System.out.println("inside CarrierLabelGeneratorController.generateLabel() immediate");
            if(shipmentDetails.size() != 1) {

                throw new BadRequestException("For Immediate label generation at a time only 1 shipment is allowed!");
            }

        } else {
            // throw error
            throw new BadRequestException("Invalid process argument!");
        }
    }
}
