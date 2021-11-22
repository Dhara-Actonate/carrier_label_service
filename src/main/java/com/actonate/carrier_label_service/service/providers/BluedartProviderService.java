package com.actonate.carrier_label_service.service.providers;

import com.actonate.carrier_label_service.model.CarrierLabels;
import com.actonate.carrier_label_service.view_model.CarrierShipmentInfoViewModel;
import com.actonate.carrier_label_service.view_model.ProviderConfigViewModel;
import org.springframework.stereotype.Service;

@Service
public class BluedartProviderService extends ProviderService {

    @Override
    public CarrierLabels generateLabel(CarrierShipmentInfoViewModel shipmentDetail, ProviderConfigViewModel config) {
        // generate label logic here

        return new CarrierLabels();
    }

    @Override
    public String generateTrackingInfo(CarrierShipmentInfoViewModel shipmentDetail, ProviderConfigViewModel config) {
        return "";
    }
}
