package com.actonate.carrier_label_service.service;

import com.actonate.carrier_label_service.view_model.CarrierLabelRequestViewModel;
import com.actonate.carrier_label_service.view_model.CarrierShipmentInfoViewModel;
import com.actonate.carrier_label_service.view_model.ProviderConfigViewModel;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface CarrierLabelGeneratorService {

//    void generateLabelBulk(List<CarrierShipmentInfoViewModel> shipmentDetails);

    void generateLabel(CarrierShipmentInfoViewModel shipmentDetail);

    void validateIncomingRequest(String process, String environment, List<CarrierShipmentInfoViewModel> shipmentDetails);

    boolean validateShipmentDetail(CarrierShipmentInfoViewModel shipmentDetail);

    ProviderConfigViewModel getProviderConfig(String providerCode, String environment) throws JsonProcessingException;
}
